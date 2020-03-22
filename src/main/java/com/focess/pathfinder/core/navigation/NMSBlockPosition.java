package com.focess.pathfinder.core.navigation;

public class NMSBlockPosition {
    private int x,y,z;
    public NMSBlockPosition(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
