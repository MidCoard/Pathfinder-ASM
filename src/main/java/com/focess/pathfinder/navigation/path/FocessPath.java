package com.focess.pathfinder.navigation.path;

import com.google.common.collect.Maps;
import org.bukkit.Location;

import java.util.Map;

public abstract class FocessPath implements Path {


    private Map<Integer, PathPoint> pathPoints = Maps.newHashMap();

    private int pos = 0;

    public PathPoint getCurrentPathPoint() {
        return this.getCurrentPathPoint(true);
    }

    public PathPoint getCurrentPathPoint(boolean flag) {
        if (flag)
            return getPathPoint(pos++);
        return getPathPoint(pos);
    }

    public Map<Integer, PathPoint> getPathPoints() {
        return Maps.newHashMap(this.pathPoints);
    }

    public void addPathPoint(int index, Location location) {
        pathPoints.put(index, new PathPoint(location));
    }


    public PathPoint getPathPoint(int index) {
        return pathPoints.get(index);
    }

    @Override
    public boolean isFinished() {
        return pos == this.pathPoints.size();
    }

}
