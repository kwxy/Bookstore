package com.kwxy.bookstore.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostcodePLFormatValidator implements ConstraintValidator<PostcodePLFormat, String>{

    @Override
    public void initialize(PostcodePLFormat format){
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if (value.isEmpty()){
            return false;
        }

        boolean isValid;

        String postcodePLPattern = "^[0-9]{2}-[0-9]{3}$";

        Pattern pattern = Pattern.compile(postcodePLPattern);
        Matcher matcher = pattern.matcher(value);

        isValid = matcher.matches();

        return isValid;
    }
}
