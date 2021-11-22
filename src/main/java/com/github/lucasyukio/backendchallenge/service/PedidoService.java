package com.github.lucasyukio.backendchallenge.service;

import com.github.lucasyukio.backendchallenge.dto.request.PedidoRequest;
import com.github.lucasyukio.backendchallenge.dto.request.StatusRequest;
import com.github.lucasyukio.backendchallenge.dto.response.PedidoResponse;
import com.github.lucasyukio.backendchallenge.dto.response.StatusResponse;
import com.github.lucasyukio.backendchallenge.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido salvarPedido(PedidoRequest pedidoRequest);

    List<PedidoResponse> buscarPedidos();

    PedidoResponse buscarPedido(String pedido);

    void excluirPedido(String pedido);

    StatusResponse mudarStatus(StatusRequest statusRequest);

}
