package com.github.lucasyukio.backendchallenge.repository;

import com.github.lucasyukio.backendchallenge.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByPedido(String pedido);

}
