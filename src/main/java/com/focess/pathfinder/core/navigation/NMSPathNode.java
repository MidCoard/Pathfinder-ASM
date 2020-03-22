package com.focess.pathfinder.core.navigation;

public class NMSPathNode {
    public final int x;
    public final int y;
    public final int z;
    private final int hashCode;
    public int heapIndex;
    public float penalizedPathLength;
    public float distanceToNearestTarget;
    public float heapWeight;
    public NMSPathNode previous;
    public boolean visited;
    public float pathLength;
    public float penalty;

    public NMSPathNode(final int x, final int y, final int z) {
        this.heapIndex = -1;
        this.x = x;
        this.y = y;
        this.z = z;
        this.hashCode = hash(x, y, z);
    }

    public NMSPathNode copyWithNewPosition(final int x, final int y, final int z) {
        final NMSPathNode lv = new NMSPathNode(x, y, z);
        lv.heapIndex = this.heapIndex;
        lv.penalizedPathLength = this.penalizedPathLength;
        lv.distanceToNearestTarget = this.distanceToNearestTarget;
        lv.heapWeight = this.heapWeight;
        lv.previous = this.previous;
        lv.visited = this.visited;
        lv.pathLength = this.pathLength;
        lv.penalty = this.penalty;
        return lv;
    }

    public static int hash(final int x, final int y, final int z) {
        return (y & 0xFF) | (x & 0x7FFF) << 8 | (z & 0x7FFF) << 24 | ((x < 0) ? Integer.MIN_VALUE : 0) | ((z < 0) ? 32768 : 0);
    }

    public float getDistance(final NMSPathNode node) {
        final float f = (float)(node.x - this.x);
        final float g = (float)(node.y - this.y);
        final float h = (float)(node.z - this.z);
        return (float) Math.sqrt(f * f + g * g + h * h);
    }

    public float getSquaredDistance(final NMSPathNode node) {
        final float f = (float)(node.x - this.x);
        final float g = (float)(node.y - this.y);
        final float h = (float)(node.z - this.z);
        return f * f + g * g + h * h;
    }

    public float getManhattanDistance(final NMSPathNode node) {
        final float f = (float)Math.abs(node.x - this.x);
        final float g = (float)Math.abs(node.y - this.y);
        final float h = (float)Math.abs(node.z - this.z);
        return f + g + h;
    }

    public float getManhattanDistance(final NMSBlockPosition pos) {
        final float f = (float)Math.abs(pos.getX() - this.x);
        final float g = (float)Math.abs(pos.getY() - this.y);
        final float h = (float)Math.abs(pos.getZ() - this.z);
        return f + g + h;
    }

    public NMSBlockPosition getPos() {
        return new NMSBlockPosition(this.x, this.y, this.z);
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof NMSPathNode) {
            final NMSPathNode lv = (NMSPathNode)o;
            return this.hashCode == lv.hashCode && this.x == lv.x && this.y == lv.y && this.z == lv.z;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    public boolean isInHeap() {
        return this.heapIndex >= 0;
    }

    @Override
    public String toString() {
        return "Node{x=" + this.x + ", y=" + this.y + ", z=" + this.z + '}';
    }


}
