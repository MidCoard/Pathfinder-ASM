package com.focess.pathfinder.core.navigation;

import java.util.List;

import org.bukkit.scheduler.BukkitRunnable;

import com.focess.pathfinder.core.navigation.focess.FocessNavigation;
import com.focess.pathfinder.core.util.DebugUtil;

/**
 * 路径计算线程
 */
public class FocessCalculateRunnable extends BukkitRunnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//DebugUtil.log("计算路径QAQ");
		List<FocessNavigation> navigations=NavigationManager.INSTANCE.getAllNavigations();
		if(!navigations.isEmpty()) {
			for(FocessNavigation nav:navigations) {
				nav.timer();
			}
		}
	}

}
