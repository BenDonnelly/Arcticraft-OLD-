package com.arcticraft.entity.mob.ai;

import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;

import com.arcticraft.entity.mob.EntityCaptain;

public class EntityAIHookAttack extends EntityAIArrowAttack {

	private EntityCaptain captain;
	
	public EntityAIHookAttack(EntityCaptain entity, double par2, float par5) {
		super((IRangedAttackMob) entity, par2, entity.hookAnimationTime, par5);
		this.captain = entity;
	}
	
	@Override
	public boolean shouldExecute() {
        return this.captain.isAboutToThrowHook() && super.shouldExecute();
    }

	@Override
	public void updateTask() {
		super.updateTask();
		//Stands still
		this.captain.getNavigator().clearPathEntity();
	}
}
