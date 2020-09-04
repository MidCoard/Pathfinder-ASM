package com.focess.pathfinder.navigation;

import com.focess.pathfinder.entity.FocessEntity;
import com.google.common.collect.Lists;

import java.util.List;

public interface NavigationManager {

    default Navigation getDefaultNavigation() {
        return getNavigation("default");
    }

    FocessEntity getFocessEntity();

    Navigation getNavigation(String id);

    default Navigation getNavigation(Class<? extends Navigation> navigationClass){
        return getNavigation(Navigations.getNavigationID(navigationClass));
    }


    void stop();

    default List<Navigation> getNavigations() {
        List<Navigation> navigations = Lists.newArrayList();
        for (String id:Navigations.navigationTypes.keySet())
            navigations.add(this.getNavigation(id));
        return navigations;
    }

    boolean addNavigation(String id,Navigation navigation);

    boolean removeNavigation(String id);
}
