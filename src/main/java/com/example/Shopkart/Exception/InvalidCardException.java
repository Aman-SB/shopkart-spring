package com.example.Shopkart.Exception;

public class InvalidCardException extends RuntimeException{
    public InvalidCardException(String message) {
        super(message);
    }
}
