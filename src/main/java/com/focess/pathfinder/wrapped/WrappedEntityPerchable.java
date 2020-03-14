package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;

public class WrappedEntityPerchable extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityPerchable",true),WrappedEntityPerchable.class);
    }
    @Override
    public Object toNMS() {
        return null;
    }

    public static WrappedEntityPerchable getWrappedEntityPerchable(Perchable)
}
