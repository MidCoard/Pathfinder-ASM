package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.navigation.Navigation;
import com.focess.pathfinder.navigation.NavigationManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleNavigationManager implements NavigationManager {

    private Map<Class<? extends Navigation>,Navigation> navigationMappings = Maps.newHashMap();

    public static List<Navigation> getAllNavigations() {
        return navigations;
    }

    private static List<Navigation> navigations = Lists.newCopyOnWriteArrayList();

    private final FocessEntity entity;

    public SimpleNavigationManager(FocessEntity entity) {
        this.entity = entity;
        this.getNavigations();
    }

    @Override
    public FocessEntity getFocessEntity() {
        return this.entity;
    }

    @Override
    public Navigation getNavigation(Class<? extends Navigation> navigationClass) {
        try {
            Navigation temp;
            if ((temp = navigationMappings.get(navigationClass)) == null) {
                Navigation navigation = navigationClass.getConstructor(FocessEntity.class).newInstance(this.entity);
                navigations.add(navigation);
                return navigation;
            }
            return temp;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void stop() {
        for (Navigation navigation:this.getNavigations())
            navigation.stop();
    }
}
