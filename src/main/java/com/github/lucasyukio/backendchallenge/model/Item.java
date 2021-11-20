package com.github.lucasyukio.backendchallenge.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String descricao;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal precoUnitario;

    @Min(value = 1)
    private int qtd;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Item(String descricao, BigDecimal precoUnitario, int qtd, Pedido pedido) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.qtd = qtd;
        this.pedido = pedido;
    }

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
