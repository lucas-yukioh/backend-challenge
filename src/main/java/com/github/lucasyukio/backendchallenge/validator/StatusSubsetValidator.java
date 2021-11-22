package com.github.lucasyukio.backendchallenge.validator;

import com.github.lucasyukio.backendchallenge.shared.Status;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class StatusSubsetValidator implements ConstraintValidator<StatusSubset, Status> {
    private Status[] subset;

    @Override
    public void initialize(StatusSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Status value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }

}
