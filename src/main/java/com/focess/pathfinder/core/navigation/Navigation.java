package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.entity.FocessEntity;

import java.lang.reflect.InvocationTargetException;

public interface Navigation {
    Class<?> getNavigation();

    void MoveTo(double x,double y,double z,double speed) throws InvocationTargetException, IllegalAccessException;

    void MoveTo(double x,double y,double z) throws InvocationTargetException, IllegalAccessException;
}
