package com.focess.pathfinder.example;


import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.Goals;

public class Example {

    public Example() {
        Goal goal = Goals.MOVE.ArrowAttack.writeDouble(1d).build(10);
    }

}
