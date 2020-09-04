package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.navigation.Navigation;
import com.focess.pathfinder.navigation.NavigationManager;
import com.focess.pathfinder.navigation.Navigations;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleNavigationManager implements NavigationManager {

    private Map<String,Navigation> navigationMappings = Maps.newHashMap();

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
    public Navigation getNavigation(String id) {
        try {
            Navigation temp;

            if ((temp = navigationMappings.get(id)) == null) {
                Navigation navigation = Navigations.getNavigationClass(id).getConstructor(FocessEntity.class).newInstance(this.entity);
                navigations.add(navigation);
                this.navigationMappings.put(id,navigation);
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

    @Override
    public boolean addNavigation(String id, Navigation navigation) {
        if (this.navigationMappings.containsKey(id))
            return false;
        this.navigationMappings.put(id, navigation);
        navigations.add(navigation);
        return true;
    }

    @Override
    public boolean removeNavigation(String id) {
        if (this.navigationMappings.containsKey(id)) {
            this.navigationMappings.remove(id);
            return true;
        }
        return false;
    }
}
