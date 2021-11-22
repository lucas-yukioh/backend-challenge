package com.github.lucasyukio.backendchallenge.service.impl;

import com.github.lucasyukio.backendchallenge.dto.request.PedidoRequest;
import com.github.lucasyukio.backendchallenge.dto.request.StatusRequest;
import com.github.lucasyukio.backendchallenge.dto.response.PedidoResponse;
import com.github.lucasyukio.backendchallenge.dto.response.StatusResponse;
import com.github.lucasyukio.backendchallenge.model.Pedido;
import com.github.lucasyukio.backendchallenge.repository.PedidoRepository;
import com.github.lucasyukio.backendchallenge.service.PedidoService;
import com.github.lucasyukio.backendchallenge.shared.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido salvarPedido(PedidoRequest pedidoRequest) {
        Pedido pedido = pedidoRequest.toModel();
        pedidoRepository.save(pedido);

        return pedido;
    }

    @Override
    public List<PedidoResponse> buscarPedidos() {
        List<PedidoResponse> pedidosResponse = new ArrayList<>();

        List<Pedido> pedidos = pedidoRepository.findAll();
        if(pedidos.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum pedido cadastrado");

        for(Pedido pedido : pedidos)
            pedidosResponse.add(new PedidoResponse(pedido));

        return pedidosResponse;
    }

    @Override
    public PedidoResponse buscarPedido(String pedido) {
        return new PedidoResponse(findPedido(pedido));
    }

    @Override
    public void excluirPedido(String pedido) {
        Pedido pedidoExc = findPedido(pedido);
        pedidoRepository.delete(pedidoExc);
    }

    @Override
    public StatusResponse mudarStatus(StatusRequest statusRequest){
        String pedido = statusRequest.getPedido();

        Optional<Pedido> pedidoOpt = pedidoRepository.findByPedido(pedido);
        if(!pedidoOpt.isPresent())
            return new StatusResponse(pedido, Status.CODIGO_PEDIDO_INVALIDO);

        Pedido pedidoObj = pedidoOpt.get();
        if(statusRequest.getStatus().equals(Status.REPROVADO))
            return new StatusResponse(pedido, Status.REPROVADO);
        else {
            if(statusRequest.getItensAprovados() == pedidoObj.getQtdTotal() &&
                    statusRequest.getValorAprovado().compareTo(pedidoObj.getPrecoTotal()) == 0)
                return new StatusResponse(pedido, Status.APROVADO);

            List<Status> listStatus = new ArrayList<>();

            if(statusRequest.getValorAprovado().compareTo(pedidoObj.getPrecoTotal()) < 0)
                listStatus.add(Status.APROVADO_VALOR_A_MENOR);

            if(statusRequest.getItensAprovados() < pedidoObj.getQtdTotal())
                listStatus.add(Status.APROVADO_QTD_A_MENOR);

            if(statusRequest.getValorAprovado().compareTo(pedidoObj.getPrecoTotal()) > 0)
                listStatus.add(Status.APROVADO_VALOR_A_MAIOR);

            if(statusRequest.getItensAprovados() > pedidoObj.getQtdTotal())
                listStatus.add(Status.APROVADO_QTD_A_MAIOR);

            return new StatusResponse(pedido, listStatus);
        }
    }

    private Pedido findPedido(String pedido) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findByPedido(pedido);
        if(!pedidoOpt.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");

        return pedidoOpt.get();
    }

}
