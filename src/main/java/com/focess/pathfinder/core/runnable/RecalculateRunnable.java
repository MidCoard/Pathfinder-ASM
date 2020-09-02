package com.focess.pathfinder.core.runnable;

import com.focess.pathfinder.core.navigation.SimpleNavigationManager;
import com.focess.pathfinder.navigation.Navigation;

public class RecalculateRunnable implements Runnable {

    @Override
    public void run() {
        for (Navigation navigation: SimpleNavigationManager.getAllNavigations())
            if (navigation.getFocessEntity().getBukkitEntity().isDead())
                SimpleNavigationManager.getAllNavigations().remove(navigation);
            else if (navigation.shouldRecalculatePath())
                navigation.recalculatePath();
    }
}
