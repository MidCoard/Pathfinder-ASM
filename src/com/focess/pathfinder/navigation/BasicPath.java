package com.focess.pathfinder.navigation;

import java.util.List;

public interface BasicPath extends Path{
	/**
	 * 获得路径点列表
	 * @return
	 */
	List<PathPoint> getPathPoints();
	
}
