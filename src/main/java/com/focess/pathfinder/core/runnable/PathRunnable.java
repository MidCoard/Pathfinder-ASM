package com.focess.pathfinder.core.runnable;

import com.focess.pathfinder.core.util.Pair;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.navigation.FocessNavigation;
import com.focess.pathfinder.navigation.path.mode.PathMode;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class PathRunnable implements Runnable {

    private  static Map<Class<? extends FocessNavigation>, List<Pair<FocessEntity,PathMode>>> pathModes = Maps.newConcurrentMap();

    static Map<FocessEntity,Class<? extends FocessNavigation>> targetNavigations = Maps.newConcurrentMap();

    public static void addPathMode(Class<? extends FocessNavigation> cls, FocessEntity focessEntity, PathMode pathMode) {
        pathModes.compute(cls,(k,v)->{
            if (v == null)
                v = Lists.newCopyOnWriteArrayList();

                v.add(Pair.of(focessEntity,pathMode));
                return v;
        });
        targetNavigations.compute(focessEntity,(k,v)-> {
            if (v == null)
                return cls;
            return v;
        });
    }

    public static void removePathMode(Class<? extends FocessNavigation> cls,FocessEntity entity) {
       pathModes
               .compute(cls,(k,v) ->{
                   if (v != null) {
                       v.removeIf(i->i.getKey().equals(entity));
                   }
                   return v;
               });
        targetNavigations.remove(entity);
    }

    @Override
    public void run() {
        for (Class<? extends FocessNavigation> cls:pathModes.keySet())
            for (Pair<FocessEntity,PathMode> pair: pathModes.get(cls)) {
                if (targetNavigations.get(pair.getKey()) == null) {
                    removePathMode(cls,pair.getKey());
                    continue;
                }
                if (targetNavigations.get(pair.getKey()).equals(cls))
                    pair.getValue().nextStep();
            }
    }
}
