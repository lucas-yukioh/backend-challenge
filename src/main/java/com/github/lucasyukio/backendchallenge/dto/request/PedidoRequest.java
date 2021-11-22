package com.github.lucasyukio.backendchallenge.dto.request;

import com.github.lucasyukio.backendchallenge.model.Pedido;
import com.github.lucasyukio.backendchallenge.validator.UniqueValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter @Getter @NoArgsConstructor
public class PedidoRequest {

    @NotBlank
    @UniqueValue
    private String pedido;

    @NotEmpty
    @Valid
    private List<ItemRequest> itens;

    public Pedido toModel() {
        return new Pedido(pedido);
    }

}
