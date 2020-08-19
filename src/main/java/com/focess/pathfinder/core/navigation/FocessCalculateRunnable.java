package com.focess.pathfinder.core.navigation;

import java.util.List;

import org.bukkit.scheduler.BukkitRunnable;

import com.focess.pathfinder.core.navigation.focess.FocessNavigation;
import com.focess.pathfinder.core.navigation.focess.FocessPath;

/**
 * 路径计算线程
 */
public class FocessCalculateRunnable extends BukkitRunnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//DebugUtil.log("计算路径QAQ");
		List<FocessNavigation> navigations=NavigationManager.INSTANCE.getAllNavigations();
		for(int i=0;i<navigations.size();i++) {
			FocessNavigation nav=navigations.get(i);
			FocessPath path=nav.getCurrentPath();
			if(!path.isPathAlive()) {
				nav.recalculatePath();
			}
			nav.timer();
		}
	}

}
