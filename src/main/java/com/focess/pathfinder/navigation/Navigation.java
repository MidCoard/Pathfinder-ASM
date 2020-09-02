package com.focess.pathfinder.navigation;

import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.navigation.path.Path;
import com.focess.pathfinder.util.Useless;
import org.bukkit.Location;
import org.bukkit.World;

public abstract class Navigation {

    @Useless
    public static final float DEFAULT_RANGE_MULTIPLIER = 1.0F;
    private final FocessEntity entity;

    public Navigation(FocessEntity entity) {
        this.entity = entity;
    }

    public World getWorld() {
        return entity.getBukkitEntity().getWorld();
    }

    public FocessEntity getFocessEntity() {
        return this.entity;
    }

    public abstract boolean isIdle();

    public abstract void stop();

    public boolean startMovingTo(final double x, final double y, final double z, final double speed) {
        return startMovingAlong(findPathTo(x, y, z, 1), speed);
    }

    public boolean startMovingTo(final FocessEntity entity, final double speed) {
        Path path = findPathTo(entity, 1);
        return path != null && this.startMovingAlong(path, speed);
    }

    public abstract boolean startMovingAlong(final Path path, final double speed);

    public abstract Path findPathTo(final double x, final double y, final double z, final double distance);

    public Path findPathTo(final FocessEntity entity, final double distance) {
        Location location = entity.getBukkitEntity().getLocation();
        if (!location.getWorld().equals(this.getWorld()))
            return null;
        return findPathTo(location.getX(), location.getY(), location.getZ(), distance);
    }

    public Path findPathTo(final FocessEntity entity) {
        return findPathTo(entity, 1);
    }

    public Path findPathTo(final double x, final double y, final double z) {
        return findPathTo(x, y, z, 1);
    }

    @Useless
    public abstract void setCanSwim(final boolean canSwim);

    @Useless
    public abstract void setAvoidSunlight(final boolean avoidSunlight);

    @Useless
    public abstract void setCanOpenDoors(final boolean canOpenDoors);

    @Useless
    public abstract void setCanEnterOpenDoors(final boolean canEnterOpenDoors);

    @Useless
    public abstract boolean avoidSunlight();

    @Useless
    public abstract boolean avoidsWater();

    @Useless
    public abstract void setAvoidsWater(boolean avoidsWater);

    @Useless
    public abstract boolean canOpenDoors();

    @Useless
    public abstract boolean canEnterOpenDoors();

    @Useless
    public abstract boolean canSwim();

    @Useless
    public abstract double getSpeed();

    @Useless
    public abstract void setSpeed(double speed);

    public abstract float getRangeMultiplier();

    public abstract void setRangeMultiplier(final float rangeMultiplier);

    public abstract boolean shouldRecalculatePath();

    public abstract void recalculatePath();

    public abstract Path getCurrentPath();
}
