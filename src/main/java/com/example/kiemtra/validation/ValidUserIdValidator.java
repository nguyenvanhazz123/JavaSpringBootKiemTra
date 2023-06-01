package com.example.kiemtra.validation;

import com.example.kiemtra.entity.User;
import com.example.kiemtra.validation.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user == null){
            return true;
        }
        return user.getId() != null;
    }
}
