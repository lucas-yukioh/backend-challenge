package com.github.lucasyukio.backendchallenge.dto.response;

import com.github.lucasyukio.backendchallenge.model.Item;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemResponse {

    private String descricao;
    private BigDecimal precoUnitario;
    private int qtd;

    public ItemResponse(Item item) {
        this.descricao = item.getDescricao();
        this.precoUnitario = item.getPrecoUnitario();
        this.qtd = item.getQtd();
    }

}
