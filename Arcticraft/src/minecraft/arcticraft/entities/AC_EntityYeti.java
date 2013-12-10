package arcticraft.entities;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class AC_EntityYeti extends EntityMob implements AC_IBossDisplayData
{

	Random rand = new Random();
	public String[] bossName = {"Glacken" , "Ceton" , "Esctor" , "Sesitur" , "Glacius" , "Benscus" , "Scentor" , "Nashausc" , "Fedsenur"};
	public final String chooseBossName = bossName[rand.nextInt(bossName.length)];

	public AC_EntityYeti(World par1World)
	{
		super(par1World);
		this.setHealth(this.getMaxHealth());
		this.setSize(width + 0.8F, height + 1.2F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.experienceValue = 50;

	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public void func_82206_m()
	{
		this.func_82215_s(220);
		this.setHealth(this.getMaxHealth() / 3.0F);
	}

	public void func_82215_s(int par1)
	{
		this.dataWatcher.updateObject(8, Integer.valueOf(par1));
	}

	public void onLivingUpdate()
	{

		if(! this.worldObj.isRemote)
		{
			this.dataWatcher.updateObject(16, Float.valueOf(this.getHealth()));
		}

		super.onLivingUpdate();

	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(100));
		this.dataWatcher.addObject(17, new Integer(0));
		this.dataWatcher.addObject(18, new Integer(0));
		this.dataWatcher.addObject(19, new Integer(0));
		this.dataWatcher.addObject(20, new Integer(0));
	}

	protected void func_110147_ax()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(350.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.399D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(8.0D);
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2)
	{
		//TODO 
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		boolean flag = super.attackEntityAsMob(par1Entity);

		if(flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float) this.worldObj.difficultySetting * 0.3F)
		{
			par1Entity.setFire(2 * this.worldObj.difficultySetting);
		}

		return flag;
	}

	public boolean canDespawn()
	{
		return false;
	}

	public String getEntityName()
	{
		return chooseBossName + ", the Yeti";
	}

	public boolean isMiniBoss()
	{
		return true;
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	public boolean canBeCollidedWith()
	{
		return ! this.isDead;
	}

}
