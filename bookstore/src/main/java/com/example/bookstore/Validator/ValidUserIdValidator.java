package com.example.bookstore.Validator;

import com.example.bookstore.Validator.annotation.ValidUserId;
import com.example.bookstore.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (user == null)
            return true;
        return user.getId() !=null;
    }
}
