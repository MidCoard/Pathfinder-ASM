package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;

public class WrappedIRangedEntity extends WrappedType {

    static  {
        register(NMSManager.getNMSClass("IRangedEntity",true),WrappedIRangedEntity.class);
    }
    @Override
    public Object toNMS() {
        //todo
        return null;
    }
}
