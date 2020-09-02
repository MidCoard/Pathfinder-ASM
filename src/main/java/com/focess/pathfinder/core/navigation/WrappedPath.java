package com.focess.pathfinder.core.navigation;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.core.util.NMSObject;
import com.focess.pathfinder.navigation.path.Path;

public class WrappedPath implements Path, NMSObject {

    private final Object nmsPath;

    protected WrappedPath(Object nmsPath) {
        this.nmsPath = nmsPath;
    }

    @Override
    public boolean isIdle() {
        return this.nmsPath == null || this.isFinished();
    }

    @Override
    public boolean isFinished() {
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
