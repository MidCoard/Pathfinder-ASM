package com.focess.pathfinder.core.runnable;

import com.focess.pathfinder.core.exception.ExceptionCatcher;

public class ExceptionRunnable implements Runnable {
    public void a(){
        System.out.println("f**k");
    }

    @Override
    public void run() {
        for (Exception exception:ExceptionCatcher.getExceptions())
            exception.printStackTrace();
    }
}
