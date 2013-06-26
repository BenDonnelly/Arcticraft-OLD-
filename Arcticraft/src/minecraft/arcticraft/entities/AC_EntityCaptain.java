package arcticraft.entities;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;

public class AC_EntityCaptain extends EntityMob implements IBossDisplayData
{

	private static final IEntitySelector attackEntitySelector = null;

	public int deathTicks = 0;
	World theWorld;

	public AC_EntityCaptain(World par1World)
	{
		super(par1World);
		this.setEntityHealth(this.getMaxHealth());
		this.texture = "/mods/AC/textures/mobs/captain.png";
		this.moveSpeed = 0.6F;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 30.0F, 0, false, false, attackEntitySelector));
		this.experienceValue = 50;
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			((EntityLiving) par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200));
			return true;
		}
		else
		{
			return false;
		}
	}

	public int func_82212_n()
	{
		return this.dataWatcher.getWatchableObjectInt(8);
	}

	public void func_82215_s(int par1)
	{
		this.dataWatcher.updateObject(8, Integer.valueOf(par1));
	}

	public void onLivingUpdate()
	{

		if (!this.worldObj.isRemote)
		{
			this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
		}

		super.onLivingUpdate();

	}

	public ItemStack getHeldItem()
	{
		return new ItemStack(MainRegistry.pirateSword, 1);
	}

	public void func_82206_m()
	{
		this.func_82215_s(220);
		this.setEntityHealth(this.getMaxHealth() / 3);
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

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Invul", this.func_82212_n());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.func_82215_s(par1NBTTagCompound.getInteger("Invul"));
		this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
	}

	@Override
	public int getMaxHealth()
	{
		return 250;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(MainRegistry.pirateSword.itemID, 1);
		this.dropItem(MainRegistry.captainStatue.blockID, 1);
	}

	/**
	 * Returns the amount of damage a mob should deal.
	 */
	public int getAttackStrength(Entity par1Entity)
	{
		return 8;
	}

	public boolean canDespawn()
	{
		return false;
	}

	@Override
	public int getDragonHealth()
	{
		return this.dataWatcher.getWatchableObjectInt(16);
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}

}
