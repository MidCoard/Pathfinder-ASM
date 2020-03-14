package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;

public class WrappedEnumDifficulty extends WrappedType {

    public static final WrappedEnumDifficulty HARD;
    public static final WrappedEnumDifficulty NORMAL;
    public static final WrappedEnumDifficulty EASY;
    public static final WrappedEnumDifficulty PEACEFUL;
    static {
        Class<?> EnumDifficulty = NMSManager.getNMSClass("EnumDifficulty");


    }
    private final Object nmsEnumDifficulty;


    private WrappedEnumDifficulty(Object nmsEnumDifficulty) {
        this.nmsEnumDifficulty = nmsEnumDifficulty;
    }
}
