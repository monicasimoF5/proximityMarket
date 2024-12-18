package org.msc.validations;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.msc.entities.Product;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SeasonValidator.class)
public @interface SeasonNotEmpty {
    String message() default "Season cannot be null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class SeasonValidator implements ConstraintValidator<SeasonNotEmpty, Product.Season> {

    @Override
    public boolean isValid(Product.Season season, ConstraintValidatorContext context) {
        return season != null;
    }

}
