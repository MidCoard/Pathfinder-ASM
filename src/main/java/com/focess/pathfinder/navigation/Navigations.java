package com.focess.pathfinder.navigation;

import com.focess.pathfinder.core.navigation.WrappedNavigation;
import com.focess.pathfinder.navigation.path.mode.PathMode;
import com.google.common.collect.Maps;

import java.util.Map;

public class Navigations {

    static final Map<String, Class<? extends Navigation>> navigationTypes = Maps.newHashMap();

    static {
        registerNavigation("default", WrappedNavigation.class);
    }

    public static <T extends Navigation> boolean registerNavigation(String id, Class<T> cls) {
        if (hasRegisterNavigation(id))
            return false;
        navigationTypes.put(id, cls);
        return true;
    }

    public static boolean hasRegisterNavigation(String id) {
        return navigationTypes.containsKey(id);
    }

    static Class<? extends Navigation> getNavigationClass(String id) {
        return navigationTypes.get(id);
    }

}
