package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Monster;

public class WrappedEntityMonster extends WrappedType {
    static {
        register(NMSManager.getNMSClass("EntityMonster", true), WrappedEntityMonster.class);
    }

    private final Object nmsMonster;

    private WrappedEntityMonster(Object nmsMonster) {
        this.nmsMonster = nmsMonster;
    }

    public static WrappedEntityMonster getWrappedEntityMonster(Monster monster) {
        Object nmsMonster = NMSManager.getNMSEntity(monster);
        return getWrappedEntityMonster(nmsMonster);
    }

    private static WrappedEntityMonster getWrappedEntityMonster(Object nmsMonster) {
        return new WrappedEntityMonster(nmsMonster);
    }

    @Override
    public Object toNMS() {
        return this.nmsMonster;
    }
}
