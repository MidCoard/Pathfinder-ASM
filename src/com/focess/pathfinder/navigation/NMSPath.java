package com.focess.pathfinder.navigation;

public interface NMSPath extends Path{

    boolean isIdle();

    boolean isFinished();

    Object toNMS();
}
