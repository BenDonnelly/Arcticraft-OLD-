package arcticraft.entities;

import arcticraft.main.MainRegistry;
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
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class AC_EntityCaptain extends EntityMob implements IBossDisplayData
{

	private static final IEntitySelector attackEntitySelector = null;

	public int deathTicks = 0;
	World theWorld;


	public boolean isSwinging = false;
	public int swingProgressInt = 0;
	
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
	
	public void swingItem()
	{
		if (!this.isSwinging || this.swingProgressInt >= this.getSwingSpeedModifier() / 2 || this.swingProgressInt < 0)
		{
			this.swingProgressInt = -1;
			this.isSwinging = true;
		}
	}
	
	private int getSwingSpeedModifier()
	{
		return this.isPotionActive(Potion.digSpeed) ? 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1 : (this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6);
	}
	
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
		/*THIS IS REMOVED FOR DEBUGGING if(!ModLoader.getMinecraftInstance().thePlayer.capabilities.isCreativeMode)
		{*/
			this.swingItem();
		//}
		super.onCollideWithPlayer(par1EntityPlayer);
	}
	
	protected void updateEntityActionState()
	{
		int var1 = this.getSwingSpeedModifier();

		if (this.isSwinging)
		{
			++this.swingProgressInt;

			if (this.swingProgressInt >= var1)
			{
				this.swingProgressInt = 0;
				this.isSwinging = false;
			}
		}
		else
		{
			this.swingProgressInt = 0;
		}

		this.swingProgress = (float)this.swingProgressInt / (float)var1;
		super.updateEntityActionState();
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
