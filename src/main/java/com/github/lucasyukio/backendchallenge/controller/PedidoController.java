package com.github.lucasyukio.backendchallenge.controller;

import com.github.lucasyukio.backendchallenge.dto.request.PedidoRequest;
import com.github.lucasyukio.backendchallenge.dto.response.PedidoResponse;
import com.github.lucasyukio.backendchallenge.model.Pedido;
import com.github.lucasyukio.backendchallenge.service.ItemService;
import com.github.lucasyukio.backendchallenge.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ItemService itemService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ItemService itemService) {
        this.pedidoService = pedidoService;
        this.itemService = itemService;
    }

    @PostMapping("/pedido")
    public ResponseEntity<?> salvarPedido(@RequestBody @Valid PedidoRequest pedidoRequest) {
        Pedido pedido = pedidoService.salvarPedido(pedidoRequest);
        itemService.salvarItens(pedido, pedidoRequest.getItens());

        return ResponseEntity.ok("Pedido salvo com sucesso!");
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoResponse>> buscarPedidos() {
        List<PedidoResponse> pedidos = pedidoService.buscarPedidos();

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedido/{pedido}")
    public ResponseEntity<PedidoResponse> buscarPedido(@PathVariable("pedido") String pedido) {
        PedidoResponse pedidoResponse = pedidoService.buscarPedido(pedido);

        return ResponseEntity.ok(pedidoResponse);
    }

    @DeleteMapping("/pedido/{pedido}")
    public ResponseEntity<?> excluirPedido(@PathVariable("pedido") String pedido) {
        pedidoService.excluirPedido(pedido);

        return ResponseEntity.ok("Pedido excluído com sucesso!");
    }

}
