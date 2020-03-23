package com.focess.pathfinder.navigation;

import com.focess.pathfinder.core.navigation.WrappedPath;
import com.focess.pathfinder.entity.FocessEntity;
import org.bukkit.Location;
import org.bukkit.World;

public interface Navigation {

    World getWorld();

    boolean isIdle();

    void stop();

    boolean startMovingTo(final double x, final double y, final double z, final double speed);

    boolean startMovingTo(final FocessEntity entity, final double speed);

    boolean startMovingAlong(final WrappedPath path, final double speed);

    Path findPathTo(final double x, final double y, final double z, final int distance);

    default Path findPathTo(final FocessEntity entity, final int distance) {
        Location location = entity.getBukkitEntity().getLocation();
        if (!location.getWorld().equals(this.getWorld()))
            return null;
        return findPathTo(location.getX(),location.getY(),location.getZ(),distance);
    }

    void setSpeed(double speed);

    void setCanSwim(final boolean canSwim);

    boolean canSwim();

    void setAvoidSunlight(final boolean avoidSunlight);

    void setCanOpenDoors(final boolean canOpenDoors);

    void setCanEnterOpenDoors(final boolean canEnterOpenDoors);

    boolean avoidSunlight();

    boolean canOpenDoors();

    boolean canEnterOpenDoors();

    Path getCurrentPath();

    double getSpeed();
}
