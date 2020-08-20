package com.focess.pathfinder.core.exception;

public class PathfinderGoalNotFoundException extends RuntimeException {

    public PathfinderGoalNotFoundException(String name) {
        super("PathfinderGoal " + name + " is not found.");
    }


}
