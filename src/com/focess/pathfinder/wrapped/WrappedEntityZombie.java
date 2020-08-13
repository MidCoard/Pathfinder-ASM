package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Zombie;

public class WrappedEntityZombie extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityZombie",true),WrappedEntityZombie.class);
    }

    private final Object nmsZombie;

    private WrappedEntityZombie(Object nmsZombie) {
        this.nmsZombie = nmsZombie;
    }

    public static WrappedEntityZombie getWrappedEntityZombie(Zombie zombie) {
        Object nmsZombie = NMSManager.getNMSEntity(zombie);
        return getWrappedEntityZombie(nmsZombie);
    }

    private static WrappedEntityZombie getWrappedEntityZombie(Object nmsZombie) {
        return new WrappedEntityZombie(nmsZombie);
    }

    @Override
    public Object toNMS() {
        return this.nmsZombie;
    }
}
