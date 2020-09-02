package com.focess.pathfinder.core.runnable;

import com.focess.pathfinder.core.exceptions.ExceptionCatcher;
import com.focess.pathfinder.core.exceptions.GoalRuntimeException;

public class ExceptionRunnable implements Runnable {

    @Override
    public void run() {
        if (ExceptionCatcher.getExceptions().size() != 0) {
            Exception exception = ExceptionCatcher.getExceptions().get(0);
            ExceptionCatcher.getExceptions().remove(0);
            throw new GoalRuntimeException(exception);
        }
    }
}
