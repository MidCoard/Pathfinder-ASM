package com.focess.pathfinder.navigation;

import com.focess.pathfinder.core.runnable.PathRunnable;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.entity.FocessEntity;

import java.lang.reflect.InvocationTargetException;

public abstract class FocessNavigation extends Navigation {

    private Object moveControllor;

    public void moveTo(final double x,final double y,final double z,final double speed) {
        try {
            NMSManager.MoveTo.invoke(moveControllor,x,y,z,speed);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public FocessNavigation(FocessEntity focessEntity) {
        super(focessEntity);
        try {
            this.moveControllor = NMSManager.MoveController.get(NMSManager.getNMSEntity(this.getFocessEntity().getBukkitEntity()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void stopPathMove() {
        PathRunnable.removePathMode(this.getClass(),this.getFocessEntity());
    }

    @Override
    public boolean avoidSunlight() {
        return false;
    }

    @Override
    public boolean avoidsWater() {
        return false;
    }

    @Override
    public void setAvoidsWater(boolean avoidsWater) {

    }

    @Override
    public boolean canOpenDoors() {
        return false;
    }

    @Override
    public boolean canEnterOpenDoors() {
        return false;
    }

    @Override
    public boolean canSwim() {
        return false;
    }

    @Override
    public void setCanSwim(boolean canSwim) {

    }

    @Override
    public void setAvoidSunlight(boolean avoidSunlight) {

    }

    @Override
    public void setCanOpenDoors(boolean canOpenDoors) {

    }

    @Override
    public void setCanEnterOpenDoors(boolean canEnterOpenDoors) {

    }

    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public void setSpeed(double speed) {

    }

    @Override
    public float getRangeMultiplier() {
        return 0;
    }

    @Override
    public void setRangeMultiplier(float rangeMultiplier) {

    }
}
