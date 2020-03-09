package com.focess.pathfinder.core.exception;

import com.google.common.collect.Lists;

import java.util.List;

public class ExceptionCatcher {

    public static List<Exception> getExceptions() {
        return exceptions;
    }

    private static List<Exception> exceptions = Lists.newCopyOnWriteArrayList();

    public static void catchException(Exception exception) {
        exceptions.add(exception);
    }
}
