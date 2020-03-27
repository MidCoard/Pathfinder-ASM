package com.focess.pathfinder.navigation;

public interface Path {

    boolean isIdle();

    boolean isFinished();

    Object toNMS();
}
