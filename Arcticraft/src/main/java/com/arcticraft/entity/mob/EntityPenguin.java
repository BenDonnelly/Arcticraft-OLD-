package com.arcticraft.entity.mob;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.item.AC_Item;

public class EntityPenguin extends EntityAnimal
{

	public EntityPenguin(World world)
	{
		super(world);
		this.setSize(0.9F, 0.9F); // this sets the hit area of the mob

		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIPanic(this, 0.38F));
		tasks.addTask(2, new EntityAIMate(this, 0.2F));
		tasks.addTask(3, new EntityAITempt(this, 0.25F, Items.fish, false));
		tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
		tasks.addTask(5, new EntityAIWander(this, 0.2F));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
		tasks.addTask(7, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10d);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.699D);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "ac:mobs.penguin_idle";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{

		return "ac:mobs.penguin_hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "ac:mobs.penguin_death";
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	public EntityPenguin func_90012_b(EntityAgeable par1EntityAgeable)
	{
		EntityPenguin entitypenguin = new EntityPenguin(this.worldObj);
		return entitypenguin;
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(3 + par2);
		int var4;

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.penguinMeat, 1);
		}

		var3 = this.rand.nextInt(3 + par2);

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.penguinFeather, 2);
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	{
		return this.func_90012_b(par1EntityAgeable);
	}

	public boolean getCanSpawnHere()
	{
		System.out.println("Spawning Penguin");

		for(int x = 0; x < 16; x++)
		{
			for(int y = 0; y < 16; y++)
			{
				for(int z = 0; z < 16; z++)
				{
					int x1 = MathHelper.floor_double(this.posX + x - 8);
					int y1 = MathHelper.floor_double(this.posY + y - 8);
					int z1 = MathHelper.floor_double(this.posZ + z - 8);

					if(this.worldObj.getBlock(x1, y1, z1) == AC_Block.acWaterStill)
					{
						return super.getCanSpawnHere();
					}
				}
			}
		}

		return false;
	}
}
