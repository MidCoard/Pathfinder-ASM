package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Cat;

public class WrappedEntityCat extends WrappedType{

    static {
        register(NMSManager.getNMSClass("EntityCat",true),WrappedEntityCat.class);
    }


    private final Object nmsCat;

    private WrappedEntityCat(Object nmsCat) {
        this.nmsCat = nmsCat;
    }

    public static WrappedEntityCat getWrappedEntityCat(Cat cat) {
        Object nmsCat = NMSManager.getNMSEntity(cat);
        return getWrappedEntityCat(nmsCat);
    }

    private static WrappedEntityCat getWrappedEntityCat(Object nmsCat) {
            return new WrappedEntityCat(nmsCat);
   }

    @Override
    public Object toNMS() {
        return this.nmsCat;
    }
}
