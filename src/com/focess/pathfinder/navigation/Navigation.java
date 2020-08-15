package com.focess.pathfinder.navigation;

public interface Navigation {
	/**
	 * 重新计算路径
	 */
	void recalculatePath();
	
	/**
	 * 获取当前路径
	 * @return
	 */
	Path getCurrentPath();
}
