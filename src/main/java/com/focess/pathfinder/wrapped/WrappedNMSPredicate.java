package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.exception.ClassClaimException;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Predicate;

public class WrappedNMSPredicate<T extends WrappedType> implements Predicate {

    private final Predicate<T> predicate;

    public WrappedNMSPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    private T getWrappedType(Object object) {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            Class<?> c;
            try {
                c = Class.forName(((ParameterizedType) superClass).getActualTypeArguments()[0].getTypeName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (WrappedType.class.isAssignableFrom(c))
                try {
                    Method method = c.getDeclaredMethod("get" + c.getSimpleName(),Object.class);
                    method.setAccessible(true);
                    return (T) method.invoke(null,object);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
        throw new ClassClaimException(this.getClass());
    }

    @Override
    public final boolean test(Object o) {
        return this.predicate.test(getWrappedType(o));
    }
}
