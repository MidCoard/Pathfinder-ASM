package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Villager;

public class WrappedEntityVillagerAbstract extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityVillagerAbstract",true),WrappedEntityVillagerAbstract.class);
    }

    private final Object nmsVillagerAbstract;

    private WrappedEntityVillagerAbstract(Object nmsVillagerAbstract) {
        this.nmsVillagerAbstract = nmsVillagerAbstract;
    }

    public static WrappedEntityVillagerAbstract getWrappedEntityVillagerAbstract(Villager villagerAbstract) {
        Object nmsVillagerAbstract = NMSManager.getNMSEntity(villagerAbstract);
        return getWrappedEntityVillagerAbstract(nmsVillagerAbstract);
    }

    private static WrappedEntityVillagerAbstract getWrappedEntityVillagerAbstract(Object nmsVillagerAbstract) {
        if (NMSManager.getNMSClass("EntityVillagerAbstract").isAssignableFrom(nmsVillagerAbstract.getClass()))
            return new WrappedEntityVillagerAbstract(nmsVillagerAbstract);
        throw new ClassCastException(nmsVillagerAbstract.getClass().getTypeName() + " cannot be cast to " + WrappedEntityVillagerAbstract.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsVillagerAbstract;
    }
}
