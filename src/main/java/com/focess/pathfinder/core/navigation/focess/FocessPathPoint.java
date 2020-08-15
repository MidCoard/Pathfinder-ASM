package com.focess.pathfinder.core.navigation.focess;

import org.bukkit.Location;

import com.focess.pathfinder.navigation.PathPoint;

/**
 * 路径点的默认实现
 */
public class FocessPathPoint implements PathPoint{
	private Location location;
	private int pointIndex;
	
	public FocessPathPoint(int index,Location loc) {
		this.location=loc;
		this.pointIndex=index;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * 获得路径点编号
	 * @return
	 */
	public int getPointIndex() {
		return pointIndex;
	}

	/**
	 * 设置路径点编号
	 * @param pointIndex
	 */
	public void setPointIndex(int pointIndex) {
		this.pointIndex = pointIndex;
	}
}
