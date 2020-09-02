package com.focess.pathfinder.example;

import com.focess.pathfinder.core.entity.NMSFocessEntity;
import com.focess.pathfinder.entity.EntityManager;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.goal.WrappedGoal;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class ExampleCommand extends Command {
    public Map<String, WrappedGoal> marks = Maps.newHashMap();

    protected ExampleCommand() {
        super("example");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 2) {
            String prefix = strings[0];
            UUID uuid = UUID.fromString(strings[1]);
            NMSFocessEntity focessEntity = EntityManager.getFocessEntity(Bukkit.getEntity(uuid));
            if (prefix.equalsIgnoreCase("show")) {
                for (GoalItem goalItem : focessEntity.getGoalSelector().getGoalItems())
                    for (WrappedGoal wrappedGoal : focessEntity.getGoalSelector().getGoal(goalItem))
                        System.out.println(wrappedGoal.getNmsGoal().getClass());
            } else if (prefix.equalsIgnoreCase("showorder")) {
                for (WrappedGoal wrappedGoal : focessEntity.getGoalSelector().getGoals())
                    System.out.println(wrappedGoal.getNmsGoal().getClass().getName());
            }
        }
        if (strings.length == 3) {
            String prefix = strings[0];
            UUID uuid = UUID.fromString(strings[1]);
            NMSFocessEntity focessEntity = EntityManager.getFocessEntity(Bukkit.getEntity(uuid));
            GoalSelector goalSelector = focessEntity.getGoalSelector();
            if (prefix.equalsIgnoreCase("remove")) {
                goalSelector.removeExactGoal(marks.get(strings[2]));
            } else if (prefix.equalsIgnoreCase("add")) {
                goalSelector.addGoal(marks.get(strings[2]));
            }
        }
        if (strings.length == 4) {
            String prefix = strings[0];
            UUID uuid = UUID.fromString(strings[1]);
            NMSFocessEntity focessEntity = EntityManager.getFocessEntity(Bukkit.getEntity(uuid));
            GoalSelector goalSelector = focessEntity.getGoalSelector();
            if (prefix.equalsIgnoreCase("mark")) {
                int pos = Integer.parseInt(strings[2]);
                // marks.put(strings[3],goalSelector.getGoal(pos));
            }
        }
        return true;
    }
}
