package com.focess.pathfinder.navigation.path.mode;

import com.focess.pathfinder.core.runnable.PathRunnable;
import com.focess.pathfinder.navigation.FocessNavigation;
import com.focess.pathfinder.navigation.Navigations;
import com.focess.pathfinder.navigation.path.FocessPath;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

public abstract class PathMode {

    private final FocessNavigation navigation;
    private final double speed;

    public FocessPath getPath() {
        return path;
    }

    private final FocessPath path;

    protected PathMode(FocessNavigation navigation,FocessPath path,double speed) {
        this.speed = speed;
        this.path = path;
        this.navigation = navigation;
    }

    public PathMode(FocessNavigation navigation,FocessPath path) {
        this(navigation,path,1);
    }

    public abstract void nextStep();

    public FocessNavigation getNavigation() {
        return navigation;
    }

    public double getSpeed() {
        return this.speed;
    }

    @Nullable
    public static PathMode createPathMode(String id,FocessNavigation navigation,FocessPath path,double speed) {
        PathMode pathMode = null;
        try {
            pathMode = PathModes.getPathModeClass(id).getConstructor(FocessNavigation.class, FocessPath.class,double.class).newInstance(navigation,path,speed);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (pathMode == null)
            return null;
        PathRunnable.addPathMode(navigation.getClass(),navigation.getFocessEntity(),pathMode);
        return pathMode;
    }
}
