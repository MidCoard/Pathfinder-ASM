package com.focess.pathfinder.core.exceptions;

public class GoalRuntimeException extends RuntimeException {

    public GoalRuntimeException(Exception exception) {
        super(exception);
    }
}
