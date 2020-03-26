package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.navigation.Path;

public class WrappedPath implements Path {

    private final Object nmsPath;

    protected WrappedPath(Object nmsPath){
        this.nmsPath = nmsPath;
    }

    public boolean isIdle() {
        return this.nmsPath == null || this.isFinished();
    }

    public boolean isFinished(){
        try {
            return (boolean) NMSManager.PathEntityMethodb.invoke(nmsPath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object toNMS() {
        return this.nmsPath;
    }
}
