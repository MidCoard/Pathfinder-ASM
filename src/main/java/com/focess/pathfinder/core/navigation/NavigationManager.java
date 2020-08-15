package com.focess.pathfinder.core.navigation;

import java.util.ArrayList;
import java.util.List;

import com.focess.pathfinder.core.PathfinderPlugin;
import com.focess.pathfinder.core.navigation.focess.FocessNavigation;

public class NavigationManager {
	public static final NavigationManager INSTANCE=new NavigationManager();
	
	private FocessCalculateRunnable calculateRunnable=new FocessCalculateRunnable();//路径计算线程
	private List<FocessNavigation> registeredFocessNavigations=new ArrayList<>();//注册的ai管理器
	
	public void init() {
		calculateRunnable.runTaskTimer(PathfinderPlugin.getPlugin(), 1, 2);
	}

	public void registerFocessNavigation(FocessNavigation focessNavigation) {
		registeredFocessNavigations.add(focessNavigation);
	}

	public FocessCalculateRunnable getCalculateRunnable() {
		return calculateRunnable;
	}

	public void setCalculateRunnable(FocessCalculateRunnable calculateRunnable) {
		this.calculateRunnable = calculateRunnable;
	}
	
}
