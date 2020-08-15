package com.focess.pathfinder.core.navigation.focess;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import com.focess.pathfinder.navigation.BasicPath;
import com.focess.pathfinder.navigation.PathPoint;

/**
 * 基本的path实现
 */
public class FocessPath implements BasicPath{

	/**
	 * 路径点
	 */
	private List<PathPoint> pathPoints=new ArrayList<>();

	@Override
	public List<PathPoint> getPathPoints() {
		return this.pathPoints;
	}

	public void setPathPoints(List<PathPoint> pathPoints) {
		this.pathPoints = pathPoints;
	}
	
	/**
	 * 添加路径点
	 * @param location
	 */
	public void addPathPoint(int pointIndex,Location location) {
		pathPoints.add(new FocessPathPoint(pointIndex,location));
	}

}
