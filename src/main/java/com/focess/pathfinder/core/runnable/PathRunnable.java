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

    private  static Map<Class<? extends FocessNavigation>, List<Pair<FocessEntity,PathMode>>> pathModes = Maps.newHashMap();

    public static void addPathMode(Class<? extends FocessNavigation> cls, FocessEntity focessEntity, PathMode pathMode) {
        pathModes.compute(cls,(k,v)->{
            if (v == null)
                v = Lists.newCopyOnWriteArrayList();

                v.add(Pair.of(focessEntity,pathMode));
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

    }

    @Override
    public void run() {
        for (Class<?> cls:pathModes.keySet())
            for (Pair<FocessEntity,PathMode> pair: pathModes.get(cls))
                pair.getValue().nextStep();
    }
}
