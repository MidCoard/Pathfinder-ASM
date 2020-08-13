package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.Sound;

import java.lang.reflect.Method;

public class WrappedSoundEffect extends WrappedType {

    private static final Method getSound;

    private static final Method getSoundEffect;

    static {
        register(NMSManager.getNMSClass("SoundEffect", true), WrappedSoundEffect.class);
        Class<?> CraftSound = NMSManager.getCraftClass("CraftSound");
        getSound = NMSManager.getMethod(CraftSound, "getSound", Sound.class);
        getSoundEffect = NMSManager.getMethod(CraftSound, "getSoundEffect", String.class);
    }

    private final Object sound;

    private WrappedSoundEffect(Object sound) {
        this.sound = sound;
    }

    public static WrappedSoundEffect getWrappedSoundEffect(Sound sound) {
        try {
            return getWrappedSoundEffect((String) getSound.invoke(null, sound));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WrappedSoundEffect getWrappedSoundEffect(String name) {
        try {
            return getWrappedSoundEffect(getSoundEffect.invoke(null, name));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static WrappedSoundEffect getWrappedSoundEffect(Object sound) {
        return new WrappedSoundEffect(sound);
    }

    @Override
    public Object toNMS() {
        return this.sound;
    }
}
