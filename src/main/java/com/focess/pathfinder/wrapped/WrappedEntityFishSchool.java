package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Fish;

public class WrappedEntityFishSchool extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityFishSchool", true), WrappedEntityFishSchool.class);
    }

    private final Object nmsFish;

    private WrappedEntityFishSchool(Object nmsFish) {
        this.nmsFish = nmsFish;
    }

    public static WrappedEntityFishSchool getWrappedEntityFishSchool(Fish fish) {
        Object nmsFish = NMSManager.getNMSEntity(fish);
        return getWrappedEntityFishSchool(nmsFish);
    }

    private static WrappedEntityFishSchool getWrappedEntityFishSchool(Object nmsFish) {
        if (NMSManager.getNMSClass("EntityFishSchool").isAssignableFrom(nmsFish.getClass()))
            return new WrappedEntityFishSchool(nmsFish);
        throw new ClassCastException(nmsFish.getClass().getTypeName() + " cannot be cast to " + WrappedEntityFishSchool.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsFish;
    }
}
