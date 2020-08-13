package com.focess.pathfinder.exception;

public class ClassClaimException extends RuntimeException {


    public ClassClaimException(Class<?> c) {
        super("Class claimed in " + c.getTypeName() + " is wrong");
    }
}
