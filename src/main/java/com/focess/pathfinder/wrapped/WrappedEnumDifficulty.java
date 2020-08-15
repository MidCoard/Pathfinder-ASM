package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;

public class WrappedEnumDifficulty extends WrappedType {

    public static WrappedEnumDifficulty HARD;
    public static WrappedEnumDifficulty NORMAL;
    public static WrappedEnumDifficulty EASY;
    public static WrappedEnumDifficulty PEACEFUL;
    static {
        Class<?> EnumDifficulty = NMSManager.getNMSClass("EnumDifficulty");
        for (Object e:EnumDifficulty.getEnumConstants())
            switch (((Enum)e).name()) {
                case "HARD": HARD = getWrappedEnumDifficulty(e,"HARD");break;
                case "NORMAL": NORMAL = getWrappedEnumDifficulty(e,"NORMAL");break;
                case "EASY": EASY = getWrappedEnumDifficulty(e,"EASY");break;
                case "PEACEFUL": PEACEFUL = getWrappedEnumDifficulty(e,"PEACEFUL");break;
            }
        register(EnumDifficulty,WrappedEnumDifficulty.class);
    }

    private static WrappedEnumDifficulty getWrappedEnumDifficulty(Object e,String name) {
        return new WrappedEnumDifficulty(e,name);
    }

    private final Object nmsEnumDifficulty;
    private final String name;


    private WrappedEnumDifficulty(Object nmsEnumDifficulty, String name) {
        this.nmsEnumDifficulty = nmsEnumDifficulty;
        this.name = name;
    }

    public static WrappedEnumDifficulty getWrappedEnumDifficulty(Object nmsEnumDifficulty) {
        if (NMSManager.getNMSClass("EnumDifficulty").isAssignableFrom(nmsEnumDifficulty.getClass()))
            return getWrappedEnumByName(((Enum)nmsEnumDifficulty).name());
        throw new ClassCastException(nmsEnumDifficulty.getClass().getTypeName() + " cannot be cast to " + WrappedEnumDifficulty.class.getTypeName());
    }

    private static WrappedEnumDifficulty getWrappedEnumByName(String name) {
        switch (name) {
            case "HARD": return HARD;
            case "NORMAL": return NORMAL;
            case "EASY": return EASY;
            case "PEACEFUL": return PEACEFUL;
        }
        return null;
    }

    @Override
    public Object toNMS() {
        return this.nmsEnumDifficulty;
    }
}
