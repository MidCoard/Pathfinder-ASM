package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.core.exception.NavigationUnMatch;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.entity.FocessEntity;
import org.bukkit.entity.Entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class NMSNavigation {
    private Class<?> navigation;
    private FocessEntity focessEntity;
    public NMSNavigation(FocessEntity entity) throws Exception {
        this.focessEntity = entity;
        Adapt(entity);
    }
    public Class<?> getNavigation(){
        return navigation;
    }
    private void Adapt(FocessEntity entity) throws Exception {
        Entity bukkit = entity.getBukkitEntity();
        Class<?> craftClass;
        if ((craftClass = bukkit.getClass()).isAssignableFrom(NMSManager.getCraftClass("CraftEntity"))) {
            Method getHandle = NMSManager.getMethod(craftClass, "getHandle");
            Class<?> nmsEntity = getHandle.invoke(craftClass).getClass();
            if (nmsEntity.isAssignableFrom(NMSManager.getNMSClass("EntityInsentient", true))) {
                Method getNavigation = NMSManager.getMethod(nmsEntity, "getNavigation");
                this.navigation = (Class<?>) getNavigation.invoke(nmsEntity);
                return;
            }
        }
        throw new NavigationUnMatch("Could not match the navigation from this entity");
    }

    public void MoveTo(double x,double y,double z,double speed) throws InvocationTargetException, IllegalAccessException {
        Method a = NMSManager.getMethod(navigation,"a",double.class,double.class,double.class,double.class);
        a.invoke(navigation,x,y,z,speed);
    }
    public void MoveTo(double x,double y,double z) throws InvocationTargetException, IllegalAccessException {
        Method a = NMSManager.getMethod(navigation,"a",double.class,double.class,double.class);
        a.invoke(navigation,x,y,z);
    }
}
