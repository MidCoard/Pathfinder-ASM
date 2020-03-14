package com.focess.pathfinder.navigation;

import com.focess.pathfinder.core.exception.NavigationTypeError;
import com.focess.pathfinder.core.navigation.NMSNavigation;
import com.focess.pathfinder.entity.FocessEntity;
import net.minecraft.server.v1_12_R1.Navigation;

public class NormalNavigation extends NMSNavigation {
    public NormalNavigation(FocessEntity entity) throws Exception {
        super(entity);
        if(getNavigation().isAssignableFrom(Navigation.class)){

        }
        else{
            throw new NavigationTypeError("Could not cast this navigation to NormalNavigation");
        }
    }

    public void MoveTo(double x,double y,double z,float speed){

    }
}
