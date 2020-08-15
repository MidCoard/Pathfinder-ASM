package com.focess.pathfinder.core.navigation.focess;

import com.focess.pathfinder.navigation.*;

/**
 * 通过实现该类自定义路径寻找AI
 */
public abstract class FocessNavigation implements BasicNavigation{

	private FocessPath currentPath;//当前路径
	
	public FocessNavigation() {
		currentPath=new FocessPath();
	}
	
	public void recalculatePath() {
		
	}

	@Override
	public BasicPath getCurrentPath() {
		return this.currentPath;
	}
	
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
	 * 是否可以向下一个路径点出发
	 * @return
	 */
	public abstract boolean canGotoNextPathPoint();
}
