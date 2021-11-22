package com.github.lucasyukio.backendchallenge.dto.request;

import com.github.lucasyukio.backendchallenge.shared.Status;
import com.github.lucasyukio.backendchallenge.validator.StatusSubset;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Setter @Getter @NoArgsConstructor
public class StatusRequest {

    @StatusSubset(anyOf = {Status.APROVADO, Status.REPROVADO})
    private Status status;

    private int itensAprovados;

    @Digits(integer = 9, fraction = 2)
    private BigDecimal valorAprovado;

    @NotBlank
    private String pedido;

}
