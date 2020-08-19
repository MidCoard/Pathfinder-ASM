package com.focess.pathfinder.core.navigation.focess;

import com.focess.pathfinder.navigation.*;

/**
 * 通过实现该类自定义路径寻找AI
 */
public abstract class FocessNavigation implements BasicNavigation{
	
	public FocessNavigation() {
		
	}
	
	/**
	 * 时刻任务
	 */
	public abstract void timer();
	
	/**
	 * 是否到达了指定路径点
	 * @param pathPoint
	 * @return
	 */
	public abstract boolean isReachPathPoint(FocessPathPoint pathPoint);
	
	/**
	 * 使实体向路径点移动
	 * @param pathPoint
	 */
	public abstract void gotoPathPoint(FocessPathPoint pathPoint);

	/**
	 * 是否可以一步到达该路径点
	 * @return
	 */
	public abstract boolean canReachPathPointInOneStep(FocessPathPoint pathPoint);
	
	public abstract FocessPath getCurrentPath();
	
	public abstract boolean equals(Object another);
}
