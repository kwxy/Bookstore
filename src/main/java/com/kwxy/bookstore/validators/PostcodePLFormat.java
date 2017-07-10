package com.kwxy.bookstore.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PostcodePLFormatValidator.class)
public @interface PostcodePLFormat{

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Prawidłowy format: xx-xxx";
}
