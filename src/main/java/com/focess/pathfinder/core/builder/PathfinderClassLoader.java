package com.focess.pathfinder.core.builder;

import com.focess.pathfinder.core.goal.NMSGoalDump;

public class PathfinderClassLoader extends ClassLoader {

    public static Class<?> NMSGoal;

    public static void loadClasses() {
        PathfinderClassLoader loader = new PathfinderClassLoader();
        try {
            NMSGoal = Class.forName("com,focess.pathfinder.core.goal.NMSGoal");
        } catch (ClassNotFoundException exception) {
            try {
                byte[] nmsGoal = NMSGoalDump.dump();
                NMSGoal = loader.buildClass("com.focess.pathfinder.core.goal.NMSGoal",nmsGoal,0,nmsGoal.length);
                System.out.println("Build Goal Successfully.");
            } catch (Exception e) {
                System.err.println("Build Goal Wrongly.");
                e.printStackTrace();
            }
        }
    }

    private PathfinderClassLoader(){}

    public Class<?> buildClass(String name, byte[] bytes, int off, int len) {
        return this.defineClass(name,bytes,off,len);
    }
}
