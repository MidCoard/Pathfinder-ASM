package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.entity.FocessEntity;

public class NMSNavigationManager implements NavigationManager{
    private FocessEntity entity;
    private Navigation navigation;
    public NMSNavigationManager(FocessEntity entity){
        this.entity = entity;
    }
    @Override
    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    public Navigation getNavigation() {
        return navigation;
    }

}
