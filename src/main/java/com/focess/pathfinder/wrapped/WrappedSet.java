package com.focess.pathfinder.wrapped;

import java.util.HashSet;
import java.util.stream.Collectors;

public class WrappedSet<E extends WrappedType> extends HashSet<E> {

    public final Object toNMS() {
        return this.stream().map(E::toNMS).collect(Collectors.toSet());
    }
}
