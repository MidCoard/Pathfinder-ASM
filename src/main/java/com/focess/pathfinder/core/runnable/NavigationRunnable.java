package com.focess.pathfinder.core.runnable;

import com.focess.pathfinder.entity.EntityManager;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.navigation.FocessNavigation;
import com.focess.pathfinder.navigation.Navigation;

import java.util.UnknownFormatConversionException;

public class NavigationRunnable implements Runnable {
    @Override
    public void run() {
        for (FocessEntity entity: EntityManager.getAllFocessEntities())
            // contains ....
            if (entity.getNavigationManager() != null && PathRunnable.targetNavigations.get(entity) != null)
                for (Navigation navigation:entity.getNavigationManager().getNavigations())
                    if (!navigation.getClass().equals(PathRunnable.targetNavigations.get(entity)))
                        navigation.stop();
    }
}
