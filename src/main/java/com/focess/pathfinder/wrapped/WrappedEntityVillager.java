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
         return new WrappedEntityVillager(nmsVillager);
   }

    @Override
    public Object toNMS() {
        return this.nmsVillager;
    }
}
