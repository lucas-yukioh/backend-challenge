package com.github.lucasyukio.backendchallenge.dto.request;

import com.github.lucasyukio.backendchallenge.model.Item;
import com.github.lucasyukio.backendchallenge.model.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Setter @Getter @NoArgsConstructor
public class ItemRequest {

    @NotBlank
    private String descricao;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 9, fraction = 2)
    private BigDecimal precoUnitario;

    @Min(value = 1)
    private int qtd;

    public Item toModel(Pedido pedido) {
        return new Item(descricao, precoUnitario, qtd, pedido);
    }

}
