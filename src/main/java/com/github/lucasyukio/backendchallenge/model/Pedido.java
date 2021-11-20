package com.github.lucasyukio.backendchallenge.model;

import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(unique = true)
    private String pedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.REMOVE)
    private List<Item> itens;

    public Pedido(String pedido) {
        this.pedido = pedido;
    }

    public String getPedido() {
        return pedido;
    }

    public List<Item> getItens() {
        return itens;
    }
}
