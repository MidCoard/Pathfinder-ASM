package com.focess.pathfinder.navigation;

import org.bukkit.World;

public class FocessNavigation implements Navigation{

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIdle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean startMovingAlong(Path path, double speed) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Path findPathTo(double x, double y, double z, int distance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanSwim(boolean canSwim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAvoidSunlight(boolean avoidSunlight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanOpenDoors(boolean canOpenDoors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanEnterOpenDoors(boolean canEnterOpenDoors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean avoidSunlight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAvoidsWater(boolean avoidsWater) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getAvoidsWater() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canOpenDoors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canEnterOpenDoors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSwim() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Path getCurrentPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRangeMultiplier(float rangeMultiplier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getRangeMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean shouldRecalculatePath() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recalculatePath() {
		// TODO Auto-generated method stub
		
	}

}
