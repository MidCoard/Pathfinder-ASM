package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Llama;

public class WrappedEntityLlama extends WrappedType {
    static {
        register(NMSManager.getNMSClass("EntityLlama", true), WrappedEntityLlama.class);
    }

    private final Object nmsLlama;

    private WrappedEntityLlama(Object nmsLlama) {
        this.nmsLlama = nmsLlama;
    }

    public static WrappedEntityLlama getWrappedEntityLlama(Llama llama) {
        Object nmsLlama = NMSManager.getNMSEntity(llama);
        return getWrappedEntityLlama(nmsLlama);
    }

    private static WrappedEntityLlama getWrappedEntityLlama(Object nmsLlama) {
        return new WrappedEntityLlama(nmsLlama);
    }

    @Override
    public Object toNMS() {
        return this.nmsLlama;
    }
}
