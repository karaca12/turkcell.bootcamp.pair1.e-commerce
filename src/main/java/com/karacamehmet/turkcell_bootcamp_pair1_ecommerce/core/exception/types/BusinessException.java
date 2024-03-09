package com.karacamehmet.turkcell_bootcamp_pair1_ecommerce.core.exception.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
