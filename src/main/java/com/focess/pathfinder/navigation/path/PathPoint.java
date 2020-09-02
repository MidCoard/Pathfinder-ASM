package com.focess.pathfinder.navigation.path;

import org.bukkit.Location;

import java.util.Objects;

public class PathPoint {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathPoint pathPoint = (PathPoint) o;
        return Objects.equals(location, pathPoint.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    private Location location;

    public PathPoint(Location loc) {
        this.location = loc;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
