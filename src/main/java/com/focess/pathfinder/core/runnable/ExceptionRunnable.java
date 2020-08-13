package com.focess.pathfinder.core.runnable;

import com.focess.pathfinder.core.exception.ExceptionCatcher;
import com.focess.pathfinder.core.exception.GoalRuntimeException;

public class ExceptionRunnable implements Runnable {

    @Override
    public void run() {
        for (Exception exception:ExceptionCatcher.getExceptions())
            throw new GoalRuntimeException(exception);
    }
}
