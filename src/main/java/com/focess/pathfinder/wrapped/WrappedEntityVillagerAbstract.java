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
            return new WrappedEntityVillagerAbstract(nmsVillagerAbstract);
    }

    @Override
    public Object toNMS() {
        return this.nmsVillagerAbstract;
    }
}
