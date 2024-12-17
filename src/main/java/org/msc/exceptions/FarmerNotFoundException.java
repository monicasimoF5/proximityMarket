package org.msc.exceptions;

public class FarmerNotFoundException extends RuntimeException {
    public FarmerNotFoundException(String message) {
        super(message);
    }
}
