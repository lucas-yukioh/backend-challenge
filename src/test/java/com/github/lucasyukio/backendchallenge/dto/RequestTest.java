package com.github.lucasyukio.backendchallenge.dto;

import com.github.lucasyukio.backendchallenge.dto.request.ItemRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;

public class RequestTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @ParameterizedTest
    @CsvSource({
            "Item A, 10.0, 2",
            "Item B, 300.25, 1",
            "Item C, 25.55, 20"
    })
    void createValidItemRequest(String descricao, BigDecimal preco, int qtd) {
        ItemRequest itemRequest = new ItemRequest();

        itemRequest.setDescricao(descricao);
        itemRequest.setPrecoUnitario(preco);
        itemRequest.setQtd(qtd);

        Set<ConstraintViolation<ItemRequest>> violations = validator.validate(itemRequest);

        Assertions.assertTrue(violations.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void createInvalidItemRequestDescricao(String invalidDescricao) {
        ItemRequest itemRequest = new ItemRequest();

        itemRequest.setDescricao(invalidDescricao);
        itemRequest.setPrecoUnitario(BigDecimal.valueOf(10.0));
        itemRequest.setQtd(2);

        Set<ConstraintViolation<ItemRequest>> violations = validator.validate(itemRequest);

        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "Item com valores zerados, 0.0, 0",
            "Item com valores negativos, -10, -1",
            "Item com valor para preço inválido, 99.99999, 2"
    })
    void createInvalidItemRequestPrecoQtd(String descricao, BigDecimal preco, int qtd) {
        ItemRequest itemRequest = new ItemRequest();

        itemRequest.setDescricao(descricao);
        itemRequest.setPrecoUnitario(preco);
        itemRequest.setQtd(qtd);

        Set<ConstraintViolation<ItemRequest>> violations = validator.validate(itemRequest);

        Assertions.assertFalse(violations.isEmpty());
    }

}
