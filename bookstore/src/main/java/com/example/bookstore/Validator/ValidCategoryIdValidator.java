package com.example.bookstore.Validator;

import com.example.bookstore.Validator.annotation.ValidCategoryId;
import com.example.bookstore.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {


    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        return category != null && category.getId() != null;
    }
}
