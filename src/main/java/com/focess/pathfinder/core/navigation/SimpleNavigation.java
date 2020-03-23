package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.navigation.Navigation;

public final class SimpleNavigation implements Navigation {

    private FocessEntity entity;
    private WrappedPath currentPath;

    private Object nmsNavigation;

    public SimpleNavigation(FocessEntity entity){
        this.entity = entity;
    }

    private void update() {
        Object nmsEntity = NMSManager.getNMSEntity(entity.getBukkitEntity());
        try {
            this.nmsNavigation = NMSManager.EntityInsentientMethodgetNavigation.invoke(nmsEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            this.currentPath = new WrappedPath(NMSManager.NavigationAbstractc.get(this.nmsNavigation));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public boolean isIdle(){
        update();
        return this.currentPath.isIdle();
    }



}
