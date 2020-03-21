package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Creature;

public class WrappedEntityCreature extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityCreature",true),WrappedEntityCreature.class);
    }

    private final Object nmsCreature;

    private WrappedEntityCreature(Object nmsCreature) {
        this.nmsCreature = nmsCreature;
    }

    @Override
    public Object toNMS() {
        return this.nmsCreature;
    }

    public static WrappedEntityCreature getWrappedEntityCreature(Creature creature) {
        Object nmsCreature = NMSManager.getNMSEntity(creature);
        return getWrappedEntityCreature(nmsCreature);
    }

    private static WrappedEntityCreature getWrappedEntityCreature(Object nmsCreature) {
            return new WrappedEntityCreature(nmsCreature);
    }

}
