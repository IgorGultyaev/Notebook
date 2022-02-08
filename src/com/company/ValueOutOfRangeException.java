package com.company;

public class ValueOutOfRangeException extends RuntimeException {
    public ValueOutOfRangeException(String value_out_of_range) {
        super(value_out_of_range);
    }
}
