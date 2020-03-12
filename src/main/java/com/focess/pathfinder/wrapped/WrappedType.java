package com.focess.pathfinder.wrapped;

import com.google.common.collect.Maps;

import java.util.Map;

public abstract class WrappedType {

    private static Map<Class<?>,Class<? extends WrappedType>> registersType = Maps.newHashMap();

    protected static void register(Class<?> nmsClass,Class<? extends WrappedType> wrappedClass) {
        registersType.put(nmsClass,wrappedClass);
    }

    public abstract Object toNMS();
}
