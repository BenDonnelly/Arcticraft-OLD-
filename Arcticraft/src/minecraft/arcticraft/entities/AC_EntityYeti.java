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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class AC_EntityYeti extends EntityMob implements AC_IBossDisplayData
{

	public int deathTicks = 0;
	World theWorld;
	Random rand = new Random();
	public String [] bossName =
		{"Glacken", "Ceton", "Esctor", "Sesitur", "Glacius", "Benscus", "Scentor", "Nashausc", "Fedsenur"};
	public String chooseBossName = bossName [rand.nextInt(bossName.length)];

	public AC_EntityYeti(World par1World)
	{
		super(par1World);
		this.setEntityHealth(this.func_110138_aP());
		this.setSize(width + 0.8F, height + 1.2F);
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class,  16, true));
		this.experienceValue = 50;

	}

	public boolean isAIEnabled()
	{
		return true;
	}

	 public void func_82206_m()
	    {
	        this.func_82215_s(220);
	        this.setEntityHealth(this.func_110138_aP() / 3.0F);
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
			this.dataWatcher.updateObject(16, Float.valueOf(this.func_110143_aJ()));
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
		this.dataWatcher.updateObject(16, Float.valueOf(this.func_110143_aJ()));
	}

	
	   protected void func_110147_ax()
       {
               super.func_110147_ax();
               // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
               this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(350.0D);
               // Follow Range - default 32.0D - min 0.0D - max 2048.0D
               this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(32.0D);
               // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
               this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.699D);
               // Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
               this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0D);
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
		return !this.isDead;
	}


	

}
