package com.focess.pathfinder.example;

import com.focess.pathfinder.goal.Goal;
import org.bukkit.Material;
import org.bukkit.entity.Spider;

public class SpiderNetGoal extends Goal {

    private final Spider spider;

    public SpiderNetGoal(Spider spider) {
        this.spider = spider;
        this.addControl(Control.MOVE);
        this.addControl(Control.JUMP);
        this.addControl(Control.LOOK);
    }

    @Override
    public boolean canStart() {
        return spider.isOnGround();
    }

    @Override
    public void start() {
        spider.getLocation().getBlock().setType(Material.LEGACY_WEB);
    }
}
