package com.focess.pathfinder.navigation.path.mode;

import com.focess.pathfinder.navigation.FocessNavigation;
import com.focess.pathfinder.navigation.path.FocessPath;
import org.bukkit.Location;

public class PathCallBackMode extends PathMode {
    protected Location targetLocation;

    protected boolean isNeedCallBack = false;

    public PathCallBackMode(FocessNavigation navigation, FocessPath path, double speed) {
        super(navigation,path,speed);
    }

    public PathCallBackMode(FocessNavigation navigation, FocessPath path) {
        super(navigation, path);
    }

    public boolean callBack() {
        return (isNeedCallBack && checkPosition()) || !isNeedCallBack;
    }

    public void nextStep() {
        if (!callBack())
            return;
        move();
    }

    public void move() {
        this.targetLocation = this.getPath().getCurrentPathPoint().getLocation();
        this.getNavigation().moveTo(targetLocation.getBlockX(),targetLocation.getBlockY(),targetLocation.getBlockZ(),this.getSpeed());
        isNeedCallBack = true;
    }

    private boolean checkPosition() {
        return this.getNavigation().getFocessEntity().getLocation().distance(this.targetLocation) < 1;
    }
}
