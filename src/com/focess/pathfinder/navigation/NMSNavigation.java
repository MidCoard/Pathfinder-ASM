package com.focess.pathfinder.navigation;

import com.focess.pathfinder.entity.IFocessEntity;
import org.bukkit.Location;
import org.bukkit.World;

public interface NMSNavigation extends Navigation{
    float DEFAULT_RANGE_MULTIPLIER = 1.0F;

    World getWorld();

    boolean isIdle();

    void stop();

    default boolean startMovingTo(final double x, final double y, final double z, final double speed) {
        return startMovingAlong(findPathTo(x,y,z,1),speed);
    }

    default boolean startMovingTo(final IFocessEntity entity, final double speed) {
        NMSPath path = findPathTo(entity,1);
        return path != null && this.startMovingAlong(path,speed);
    }

    boolean startMovingAlong(final NMSPath path, final double speed);

    NMSPath findPathTo(final double x, final double y, final double z, final int distance);

    default NMSPath findPathTo(final IFocessEntity entity, final int distance) {
        Location location = entity.getBukkitEntity().getLocation();
        if (!location.getWorld().equals(this.getWorld()))
            return null;
        return findPathTo(location.getX(),location.getY(),location.getZ(),distance);
    }

    default NMSPath findPathTo(final IFocessEntity entity) {
        return findPathTo(entity,1);
    }

    default NMSPath findPathTo(final double x, final double y, final double z) {
        return findPathTo(x,y,z,1);
    }

    void setSpeed(double speed);

    void setCanSwim(final boolean canSwim);

    void setAvoidSunlight(final boolean avoidSunlight);

    void setCanOpenDoors(final boolean canOpenDoors);

    void setCanEnterOpenDoors(final boolean canEnterOpenDoors);

    boolean avoidSunlight();

    void setAvoidsWater(boolean avoidsWater);

    boolean getAvoidsWater();

    boolean canOpenDoors();

    boolean canEnterOpenDoors();

    boolean canSwim();

    @Override
    NMSPath getCurrentPath();

    double getSpeed();

    void setRangeMultiplier(final float rangeMultiplier);

    float getRangeMultiplier();

    boolean shouldRecalculatePath();

}
