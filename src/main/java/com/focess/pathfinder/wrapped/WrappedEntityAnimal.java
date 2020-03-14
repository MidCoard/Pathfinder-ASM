package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Animals;

public class WrappedEntityAnimal extends WrappedType {
    static {
        register(NMSManager.getNMSClass("EntityAnimal",true),WrappedEntityAnimal.class);
    }
    private final Object nmsAnimals;

    private WrappedEntityAnimal(Object nmsAnimals) {
        this.nmsAnimals = nmsAnimals;
    }

    @Override
    public Object toNMS() {
        return this.nmsAnimals;
    }

    public static WrappedEntityAnimal getWrappedEntityAnimal(Animals animals) {
        Object nmsAnimals = NMSManager.getNMSEntity(animals);
        return getWrappedEntityAnimal(nmsAnimals);
    }

    private static WrappedEntityAnimal getWrappedEntityAnimal(Object nmsAnimals) {
        if (NMSManager.getNMSClass("EntityAnimal").isAssignableFrom(nmsAnimals.getClass()))
            return new WrappedEntityAnimal(nmsAnimals);
        throw new ClassCastException(nmsAnimals.getClass().getTypeName() + " cannot be cast to " + WrappedEntityAnimal.class.getTypeName());
    }
}
