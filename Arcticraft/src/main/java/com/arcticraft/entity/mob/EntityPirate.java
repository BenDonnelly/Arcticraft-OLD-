package com.arcticraft.entity.mob;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class EntityPirate extends EntityMob
{

	private Random rand = new Random();
	private int counter = 0;
	public boolean isSwinging = false;
	public int swingProgressInt = 0;

	public EntityPirate(World world)
	{
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16, true));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.0D);
	}

	public boolean canDespawn()
	{
		return false;
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		boolean flag = super.attackEntityAsMob(par1Entity);

		if(flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float) this.worldObj.difficultySetting.getDifficultyId() * 0.3F)
		{
			par1Entity.setFire(2 * this.worldObj.difficultySetting.getDifficultyId());
		}

		return flag;
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public int getTotalArmorValue()
	{
		return 4;
	}

	public void swingItem()
	{
		if(! this.isSwinging || this.swingProgressInt >= this.getSwingSpeedModifier() / 2 || this.swingProgressInt < 0)
		{
			this.swingProgressInt = - 1;
			this.isSwinging = true;
		}
	}

	private int getSwingSpeedModifier()
	{
		return this.isPotionActive(Potion.digSpeed) ? 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1 : (this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "ac:mobs.pirate_idle";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{

		return "ac:mobs.pirate_hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "ac:mobs.pirate_death";
	}

	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
		/*
		 * THIS IS REMOVED FOR DEBUGGING if(!ModLoader.getMinecraftInstance().thePlayer.capabilities.isCreativeMode)
		 * {
		 */
		this.swingItem();
		//}
		super.onCollideWithPlayer(par1EntityPlayer);
	}

	protected void updateEntityActionState()
	{
		int var1 = this.getSwingSpeedModifier();

		if(this.isSwinging)
		{
			++this.swingProgressInt;

			if(this.swingProgressInt >= var1)
			{
				this.swingProgressInt = 0;
				this.isSwinging = false;
			}
		}
		else
		{
			this.swingProgressInt = 0;
		}

		this.swingProgress = (float) this.swingProgressInt / (float) var1;
		super.updateEntityActionState();
	}

	public ItemStack getHeldItem()
	{
		return new ItemStack(Items.iron_sword, 1);
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected Item getDropItem()
	{
		return Items.iron_ingot;
	}
}
