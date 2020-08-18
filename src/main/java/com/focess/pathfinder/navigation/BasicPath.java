package com.focess.pathfinder.navigation;

import java.util.List;

import com.focess.pathfinder.core.navigation.focess.FocessPathPoint;

public interface BasicPath extends Path{
	/**
	 * 获得路径点列表
	 * @return
	 */
	List<FocessPathPoint> getPathPoints();
	
}
