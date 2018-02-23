/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.py.common.exception.ParamterException;

/**
 * 
 * @author jinlilong
 * @version $Id: ValidateUtil.java, v 0.1 2017年12月13日 下午7:09:26 jinlilong Exp $
 */
public class ValidateUtil {

    public static <T> void validate(T t) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            throw new ParamterException(constraintViolation.getMessage());
        }
    }

}
