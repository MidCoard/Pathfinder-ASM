package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.IronGolem;

public class WrappedEntityIronGolem extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityIronGolem",true),WrappedEntityIronGolem.class);
    }

    private final Object nmsIronGolem;

    private WrappedEntityIronGolem(Object nmsIronGolem) {
        this.nmsIronGolem = nmsIronGolem;
    }

    public static WrappedEntityIronGolem getWrappedEntityIronGolem(IronGolem ironGolem){
        Object nmsIronGolem = NMSManager.getNMSEntity(ironGolem);
        return getWrappedEntityIronGolem(nmsIronGolem);
    }

    private static WrappedEntityIronGolem getWrappedEntityIronGolem(Object nmsIronGolem) {
            return new WrappedEntityIronGolem(nmsIronGolem);
     }

    @Override
    public Object toNMS() {
        return this.nmsIronGolem;
    }
}
