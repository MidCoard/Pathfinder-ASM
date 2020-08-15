package com.focess.pathfinder.core.entity;

import org.bukkit.entity.Entity;

import com.focess.pathfinder.entity.IFocessEntity;

public class BasicFocessEntity implements IFocessEntity{
	
	private Entity bukkitEntity;
	
	public BasicFocessEntity(Entity bukkitEntity) {
		this.bukkitEntity=bukkitEntity;
	}
	
	@Override
	public Entity getBukkitEntity() {
		return this.bukkitEntity;
	}

}
