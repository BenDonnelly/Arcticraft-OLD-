package arcticraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class AC_EntityHunterEskimo extends EntityMob
{

	public AC_EntityHunterEskimo(World par1World)
	{
		super(par1World);
		this.moveSpeed = 0.3F;
		this.texture = "/mods/AC/textures/mobs/eskimo_hunter.png";
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, AC_EntityBoar.class, 16.0F, 0, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, AC_EntityPenguin.class, 16.0F, 0, true));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this, AC_EntityPenguin.class, this.moveSpeed, false));
		this.tasks.addTask(8, new EntityAIAttackOnCollide(this, AC_EntityBoar.class, this.moveSpeed, false));
		this.tasks.addTask(10, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));

		
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public int attackStrenght(Entity par1Entity)
	{
		return 6;
	}

	public boolean canDespawn()
	{
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	public int getMaxHealth()
	{
		return 40;
	}

	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}

}
