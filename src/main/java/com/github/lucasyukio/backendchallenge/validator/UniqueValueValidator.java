package com.github.lucasyukio.backendchallenge.validator;

import com.github.lucasyukio.backendchallenge.model.Pedido;
import com.github.lucasyukio.backendchallenge.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findByPedido(value.toString());

        return !pedidoOpt.isPresent();
    }

}
