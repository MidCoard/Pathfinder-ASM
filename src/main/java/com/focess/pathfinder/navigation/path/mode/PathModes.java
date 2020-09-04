package com.focess.pathfinder.navigation.path.mode;

import com.google.common.collect.Maps;

import java.util.Map;

public class PathModes  {

    private static final Map<String,Class<? extends PathMode>> pathModeTypes = Maps.newHashMap();

    static {
        registerPathMode("CallBack",PathCallBackMode.class);
    }

    public static boolean registerPathMode(String id,Class<? extends PathMode> cls) {
        if (hasRegisterPathMode(id))
            return false;
        pathModeTypes.put(id,cls);
        return true;
    }

    private static boolean hasRegisterPathMode(String id) {
        return pathModeTypes.containsKey(id);
    }

    public static Class<? extends PathMode> getPathModeClass(String id) {
        return pathModeTypes.get(id);
    }
}
