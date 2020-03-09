package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.goal.Goal;
import net.minecraft.server.v1_13_R1.PathfinderGoal;

public class NMSGoal extends PathfinderGoal {

    private final Goal goal;

    public NMSGoal(Goal goal) {
        this.goal = goal;
    }

    @Override
    public boolean a() {
        try {
            return goal.canStart();
        }
        catch(Exception e){

            return false;
        }
    }

    @Override
    public boolean b() {
        try {
            return goal.shouldContinue();
        }
        catch (Exception e) {
            return false;
            }
    }
    @Override
    public void c() {
        goal.start();
    }

    @Override
    public void d() {
        goal.stop();
    }

    @Override
    public void e() {
        goal.tick();
    }

    @Override
    public boolean f() {
        try {
            return goal.canStop();
        } catch (Exception e) {
            return false;
        }
    }
}
