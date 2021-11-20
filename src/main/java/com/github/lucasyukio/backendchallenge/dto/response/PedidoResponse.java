package com.github.lucasyukio.backendchallenge.dto.response;

import com.github.lucasyukio.backendchallenge.model.Pedido;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidoResponse {

    private String pedido;
    private List<ItemResponse> itens;

    public PedidoResponse(Pedido pedido) {
        this.pedido = pedido.getPedido();
        this.itens = pedido.getItens().stream().map(ItemResponse::new).collect(Collectors.toList());
    }

}
