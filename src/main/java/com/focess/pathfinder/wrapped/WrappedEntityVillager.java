package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Villager;

public class WrappedEntityVillager extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityVillager",true),WrappedEntityVillager.class);
    }

    private final Object nmsVillager;

    private WrappedEntityVillager(Object nmsVillager) {
        this.nmsVillager = nmsVillager;
    }

    public static WrappedEntityVillager getWrappedEntityVillager(Villager villager) {
        Object nmsVillager = NMSManager.getNMSEntity(villager);
        return getWrappedEntityVillager(nmsVillager);
    }

    private static WrappedEntityVillager getWrappedEntityVillager(Object nmsVillager) {
        if (NMSManager.getNMSClass("EntityVillager").isAssignableFrom(nmsVillager.getClass()))
            return new WrappedEntityVillager(nmsVillager);
        throw new ClassCastException(nmsVillager.getClass().getTypeName() + " cannot be cast to " + WrappedEntityVillager.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsVillager;
    }
}
