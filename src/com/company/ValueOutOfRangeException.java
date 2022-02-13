package com.company;

public class ValueOutOfRangeException extends RuntimeException {
    public ValueOutOfRangeException(String valueOutOfRange) {
        super(valueOutOfRange);
    }
}
