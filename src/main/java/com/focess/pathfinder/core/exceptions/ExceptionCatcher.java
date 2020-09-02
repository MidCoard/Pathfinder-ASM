package com.focess.pathfinder.core.exceptions;

import com.google.common.collect.Lists;

import java.util.List;

public class ExceptionCatcher {

    private static final List<Exception> exceptions = Lists.newCopyOnWriteArrayList();

    public static List<Exception> getExceptions() {
        return exceptions;
    }

    public static void catchException(Exception exception) {
        exceptions.add(exception);
    }
}
