package com.focess.pathfinder.core;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.entity.NMSFocessEntity;
import com.focess.pathfinder.core.listener.EntityListener;
import com.focess.pathfinder.core.runnable.ExceptionRunnable;
import com.focess.pathfinder.core.runnable.NavigationRunnable;
import com.focess.pathfinder.core.runnable.PathRunnable;
import com.focess.pathfinder.core.runnable.RecalculateRunnable;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.core.util.Pair;
import com.focess.pathfinder.core.util.PathfinderUtil;
import com.focess.pathfinder.entity.EntityManager;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.goal.FocessGoalItem;
import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.WrappedGoal;
import com.focess.pathfinder.util.Requests;
import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class PathfinderPlugin extends JavaPlugin {
    private static PathfinderPlugin plugin;

    public static PathfinderPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        if (NMSManager.getVersionInt() < 8) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.plugin = this;
        PathfinderClassLoader.loadClasses(this.getClassLoader());
        this.getServer().getPluginManager().registerEvents(new EntityListener(),this);
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new ExceptionRunnable(), 0L, 20L);
        this.getServer().getScheduler().runTaskTimer(this,new RecalculateRunnable(),0l,1l);
        this.getServer().getScheduler().runTaskTimer(this,new PathRunnable(),0l,1l);
        this.getServer().getScheduler().runTaskTimer(this,new NavigationRunnable(),0l,1l);
        Requests.allocateRequestManager(this,3);
        for (World world: Bukkit.getWorlds())
            for (Entity entity:world.getEntities())
                if (entity instanceof LivingEntity) {
                    FocessEntity focessEntity = new NMSFocessEntity(entity);
                    EntityManager.register(entity, focessEntity);
//                    for (MetadataValue value :focessEntity.getBukkitEntity().getMetadata("Goal"))
//                        if (value.value() instanceof List)
//                        for (Object object:(List)value.value()){
//                            Pair<Goal,Pair<Integer,Boolean>> goal = (Pair<Goal, Pair<Integer, Boolean>>) object;
//                            focessEntity.getGoalSelector().addGoal(new FocessGoalItem(goal.getKey()).build(goal.getValue().getKey(),goal.getValue().getValue()));
//                        }
//                    focessEntity.getBukkitEntity().removeMetadata("Goal",this);
                }
//        this.getServer().getPluginManager().registerEvents(new Example(),this);
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
//        for (FocessEntity entity:EntityManager.getAllFocessEntities()) {
//            List<Pair<Goal,Pair<Integer,Boolean>>> goals = Lists.newArrayList();
//            for (GoalItem goalItem : entity.getGoalSelector().getGoalItems())
//                if (goalItem.getType() == GoalItem.GoalType.FOCESS) {
//                    goals.addAll(entity.getGoalSelector().getGoal(goalItem).stream().map(i -> Pair.of((Goal) i.getGoal(), Pair.of(i.getPriority(), i.getControls().contains(Goal.Control.TARGET)))).collect(Collectors.toList()));
//                    entity.getGoalSelector().removeGoal(goalItem);
//                }
//           entity.getBukkitEntity().setMetadata("Goal",new FixedMetadataValue(this,goals));
//        }
    }
}
