package com.focess.pathfinder.core.navigation.focess;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import com.focess.pathfinder.navigation.BasicPath;
import com.focess.pathfinder.navigation.PathPoint;

/**
 * 基本的path实现
 */
public abstract class FocessPath implements BasicPath{

	/**
	 * 路径点
	 */
	private List<FocessPathPoint> pathPoints=new ArrayList<>();
	
	/**
	 * 获取当前希望到达的路径点
	 * @return
	 */
	public abstract FocessPathPoint getNowPathPoint();

	@Override
	public List<FocessPathPoint> getPathPoints() {
		return this.pathPoints;
	}

	public void setPathPoints(List<FocessPathPoint> pathPoints) {
		this.pathPoints = pathPoints;
	}
	
	/**
	 * 添加路径点
	 * @param location
	 */
	public void addPathPoint(int pointIndex,Location location) {
		pathPoints.add(new FocessPathPoint(pointIndex,location));
	}
	
	/**
	 * 添加路径点
	 * @param point
	 */
	public void addPathPoint(FocessPathPoint point) {
		pathPoints.add(point);
	}
	
	/**
	 * 获取路径点
	 * @param index 路径点编号
	 * @return
	 */
	public FocessPathPoint getPathPoint(int index) {
		if(this.pathPoints.isEmpty())return null;
		for(FocessPathPoint point:this.pathPoints) {
			if(point.getPointIndex()==index) {
				return point;
			}
		}
		return null;
	}
	
	/**
	 * 该路径是否有效
	 * @return
	 */
	public abstract boolean isPathAlive();
	
}
