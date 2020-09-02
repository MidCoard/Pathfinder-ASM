package com.focess.pathfinder.util;

import com.focess.pathfinder.core.PathfinderPlugin;
import com.google.common.collect.Lists;
import org.bukkit.Bukkit;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Requests {

    private static boolean isAllocated = false;

    private static RequestManager[] managers;

    public static void addRequest(Request request) {
        if (!isAllocated)
            return;
        Random random = new Random(new Date().getTime());
        managers[random.nextInt(managers.length)].addRequest(request);
    }

    public static void allocateRequestManager(PathfinderPlugin plugin,int count) {
        if (isAllocated)
            return;
        isAllocated = true;
        managers = new RequestManager[count];
        for (int i = 0;i<count;i++)
            Bukkit.getScheduler().runTaskTimer(plugin,managers[i] = new RequestManager(), 0l,1l );
    }

    private static class RequestManager implements Runnable {

        private List<Request> requests = Lists.newCopyOnWriteArrayList();

        private void addRequest(Request request) {
            requests.add(request);
        }

        @Override
        public void run() {
            for (Request request:requests) {
                requests.remove(request);
                request.run();
            }
        }
    }

    public static abstract class Request {

        public abstract void run();
    }
}
