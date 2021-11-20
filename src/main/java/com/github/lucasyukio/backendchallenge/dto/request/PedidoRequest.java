package com.github.lucasyukio.backendchallenge.dto.request;

import com.github.lucasyukio.backendchallenge.validator.UniqueValue;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
public class PedidoRequest {

    @NotBlank
    @UniqueValue
    private String pedido;

    @NotEmpty
    @Valid
    private List<ItemRequest> itens;

    public String getPedido() {
        return pedido;
    }

    public List<ItemRequest> getItens() {
        return itens;
    }
}
