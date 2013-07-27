package arcticraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;

public class AC_EntityAIHookAttack extends EntityAIArrowAttack {

	private AC_EntityCaptain captain;
	
	public AC_EntityAIHookAttack(AC_EntityCaptain entity, double par2, float par5) {
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
