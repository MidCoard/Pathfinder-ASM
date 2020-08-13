package com.focess.pathfinder.wrapped;

import com.google.common.collect.Maps;

import java.util.Map;

public abstract class WrappedType {

    private static final Map<Class<?>,Class<? extends WrappedType>> registersTypes = Maps.newHashMap();

    private static final Map<Class<? extends WrappedType>,Class<?>> wrappedTypes = Maps.newHashMap();

    protected static void register(Class<?> nmsClass,Class<? extends WrappedType> wrappedClass) {
        registersTypes.put(nmsClass,wrappedClass);
        wrappedTypes.put(wrappedClass,nmsClass);
    }

    public static Class<?> getNMSType(Class<?> c) {
        return wrappedTypes.get(c);
    }

    public abstract Object toNMS();
}
