package com.github.lucasyukio.backendchallenge.dto.request;

import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Setter
public class ItemRequest {

    @NotBlank
    private String descricao;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal precoUnitario;

    @Min(value = 1)
    private int qtd;

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQtd() {
        return qtd;
    }
}
