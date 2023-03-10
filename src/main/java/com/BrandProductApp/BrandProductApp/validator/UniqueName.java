package com.BrandProductApp.BrandProductApp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {UniqueNameValidator.class})
public @interface UniqueName {
    //Burası brand için kullanılacak brand adı yalnızca 1 kere tanımlanabilir
    String message() default "{backend.constraints.UniqueName.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
