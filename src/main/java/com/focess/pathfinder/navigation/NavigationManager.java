package com.focess.pathfinder.navigation;

import com.focess.pathfinder.entity.FocessEntity;
import com.google.common.collect.Lists;

import java.util.List;

public interface NavigationManager {

    default Navigation getDefaultNavigation() {
        return getNavigation("default");
    }

    FocessEntity getFocessEntity();

    default Navigation getNavigation(String id) {
        return getNavigation(Navigations.getNavigationClass(id));
    }

    Navigation getNavigation(Class<? extends Navigation> navigationClass);

    void stop();

    default List<Navigation> getNavigations() {
        List<Navigation> navigations = Lists.newArrayList();
        for (String id:Navigations.navigationTypes.keySet())
            navigations.add(this.getNavigation(id));
        return navigations;
    }
}
