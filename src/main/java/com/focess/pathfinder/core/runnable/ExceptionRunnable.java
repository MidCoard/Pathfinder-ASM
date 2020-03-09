package com.focess.pathfinder.core.runnable;

import com.focess.pathfinder.core.exception.ExceptionCatcher;

public class ExceptionRunnable implements Runnable {

    @Override
    public void run() {
        for (Exception exception:ExceptionCatcher.getExceptions())
            exception.printStackTrace();
    }
}
