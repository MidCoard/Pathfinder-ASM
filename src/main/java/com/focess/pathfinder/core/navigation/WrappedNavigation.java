package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.navigation.Navigation;
import com.focess.pathfinder.navigation.path.Path;

public final class WrappedNavigation extends Navigation {

    private final Object nmsEntity;
    private WrappedPath currentPath;

    private Object nmsNavigation;
    private Object nmsPathNodeMaker;

    public WrappedNavigation(FocessEntity entity) {
        super(entity);
        this.nmsEntity = NMSManager.getNMSEntity(getFocessEntity().getBukkitEntity());
    }

    private void updateNavigation() {
        try {
            this.nmsNavigation = NMSManager.EntityInsentientMethodgetNavigation.invoke(nmsEntity);
        } catch (Exception e) {
            System.out.println(nmsEntity);
            throw new RuntimeException(e);
        }
    }

    private void updatePath() {
        updateNavigation();
        try {
            this.currentPath = new WrappedPath(NMSManager.NavigationAbstractc.get(this.nmsNavigation));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public boolean isIdle() {
        updatePath();
        return this.currentPath.isIdle();
    }

    @Override
    public void stop() {
        updateNavigation();
        try {
            NMSManager.NavigationAbstractc.set(this.nmsNavigation, null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean startMovingAlong(Path path, double speed) {
        updateNavigation();
        try {
            return (boolean) NMSManager.NavigationAbstractMethodNames.get("startMovingAlong").invoke(this.nmsNavigation, ((WrappedPath) path).toNMS(), speed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Path findPathTo(double x, double y, double z, double distance) {
        updateNavigation();
        if (NMSManager.getVersionInt() < 14) {
            try {
                return new WrappedPath(NMSManager.NavigationAbstractMethodNames.get("findPathTo").invoke(this.nmsNavigation, x, y, z));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                return new WrappedPath(NMSManager.NavigationAbstractMethodNames.get("findPathTo").invoke(this.nmsNavigation, x, y, z, (int)distance));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void updatePathNodeMaker() {
        updateNavigation();
        if (NMSManager.getVersionInt() == 8) {
            try {
                this.nmsPathNodeMaker = NMSManager.PathfinderGetPathfinderAbstract.get(NMSManager.NavigationAbstractGetPathfinder.get(this.nmsNavigation));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                this.nmsPathNodeMaker = NMSManager.NavigationAbstractGetPathfinderAbstract.get(this.nmsNavigation);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void setCanSwim(boolean canSwim) {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8) {
            if (NMSManager.getNMSClass("PathfinderWater").isAssignableFrom(this.nmsPathNodeMaker.getClass()))
                return;
            try {
                NMSManager.PathfinderNormalMethodNames.get("setCanSwim").invoke(this.nmsPathNodeMaker, canSwim);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                NMSManager.PathfinderAbstractMethodNames.get("setCanSwim").invoke(this.nmsPathNodeMaker, canSwim);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void setAvoidSunlight(boolean avoidSunlight) {
        updatePathNodeMaker();
        try {
            NMSManager.NavigationFieldAvoidSunlight.setBoolean(this.nmsNavigation, avoidSunlight);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setCanOpenDoors(boolean canOpenDoors) {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8)
            throw new UnsupportedOperationException("PathfinderWater does not contain this in Minecraft 1.8.");
        else {
            try {
                NMSManager.PathfinderAbstractMethodNames.get("setCanOpenDoors").invoke(this.nmsPathNodeMaker, canOpenDoors);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void setCanEnterOpenDoors(boolean canEnterOpenDoors) {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8) {
            if (NMSManager.getNMSClass("PathfinderNormal").isAssignableFrom(this.nmsPathNodeMaker.getClass())) {
                try {
                    NMSManager.PathfinderNormalMethodNames.get("setEnterDoors").invoke(this.nmsPathNodeMaker, canEnterOpenDoors);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            throw new UnsupportedOperationException("PathfinderWater does not contain this in Minecraft 1.8.");
        } else {
            try {
                NMSManager.PathfinderAbstractMethodNames.get("setCanEnterOpenDoors").invoke(this.nmsPathNodeMaker, canEnterOpenDoors);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean avoidSunlight() {
        updatePathNodeMaker();
        try {
            return NMSManager.NavigationFieldAvoidSunlight.getBoolean(this.nmsNavigation);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean avoidsWater() {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8) {
            try {
                return (boolean) NMSManager.PathfinderNormalMethodNames.get("getAvoidsWater").invoke(this.nmsPathNodeMaker);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else throw new UnsupportedOperationException("PathfinderWater does contain this in Minecraft 1.8.");
    }

    @Override
    public void setAvoidsWater(boolean avoidsWater) {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8) {
            try {
                NMSManager.PathfinderNormalMethodNames.get("setAvoidsWater").invoke(this.nmsPathNodeMaker, avoidsWater);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else throw new UnsupportedOperationException("PathfinderWater does contain this in Minecraft 1.8.");
    }

    @Override
    public boolean canOpenDoors() {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8)
            throw new UnsupportedOperationException("PathfinderWater does not contain this in Minecraft 1.8.");
        else {
            try {
                return (boolean) NMSManager.PathfinderAbstractMethodNames.get("canOpenDoors").invoke(this.nmsPathNodeMaker);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean canEnterOpenDoors() {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8) {
            if (NMSManager.getNMSClass("PathfinderNormal").isAssignableFrom(this.nmsPathNodeMaker.getClass())) {
                try {
                    return (boolean) NMSManager.PathfinderNormalMethodNames.get("getEnterDoors").invoke(this.nmsPathNodeMaker);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            throw new UnsupportedOperationException("PathfinderWater does not contain this in Minecraft 1.8.");
        } else {
            try {
                return (boolean) NMSManager.PathfinderAbstractMethodNames.get("canEnterOpenDoors").invoke(this.nmsPathNodeMaker);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean canSwim() {
        this.updatePathNodeMaker();
        if (NMSManager.getVersionInt() == 8) {
            if (NMSManager.getNMSClass("PathfinderWater").isAssignableFrom(this.nmsPathNodeMaker.getClass()))
                return true;
            try {
                return (boolean) NMSManager.PathfinderNormalMethodNames.get("getCanSwim").invoke(this.nmsPathNodeMaker);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                return (boolean) NMSManager.PathfinderAbstractMethodNames.get("canSwim").invoke(this.nmsPathNodeMaker);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Path getCurrentPath() {
        updatePath();
        return this.currentPath;
    }

    @Override
    public double getSpeed() {
        updateNavigation();
        try {
            return NMSManager.NavigationAbstractd.getDouble(this.nmsNavigation);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setSpeed(double speed) {
        updateNavigation();
        try {
            NMSManager.NavigationAbstractd.set(this.nmsNavigation, speed);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float getRangeMultiplier() {
        if (NMSManager.getVersionInt() < 15)
            throw new UnsupportedOperationException("No range multiplier in Minecraft lower version.");
        updateNavigation();
        try {
            return NMSManager.NavigationAbstracts.getFloat(this.nmsNavigation);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setRangeMultiplier(float rangeMultiplier) {
        if (NMSManager.getVersionInt() < 15)
            throw new UnsupportedOperationException("No range multiplier in Minecraft lower version.");
        updateNavigation();
        try {
            NMSManager.NavigationAbstracts.set(this.nmsNavigation, rangeMultiplier);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean shouldRecalculatePath() {
        if (NMSManager.getVersionInt() == 8)
            throw new UnsupportedOperationException("No range multiplier in Minecraft lower version.");
        updateNavigation();
        try {
            return (boolean) NMSManager.NavigationAbstractRecalculate.get(this.nmsNavigation);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void recalculatePath() {
        if (NMSManager.getVersionInt() == 8)
            throw new UnsupportedOperationException("No range multiplier in Minecraft lower version.");
        updateNavigation();
        try {
            NMSManager.NavigationAbstractMethodNames.get("recalculatePath").invoke(this.nmsNavigation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
