package arcticraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import arcticraft.items.AC_Item;

public class AC_EntityBoar extends EntityAnimal
{

	public AC_EntityBoar(World par1World)
	{
		super(par1World);
		this.setSize(0.9F, 0.9F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
	}

	protected void updateAITasks()
	{
		super.updateAITasks();
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "ac:mobs.boar_living";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "ac:mobs.boar_hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "ac:mobs.boar_death";
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}
	
	@Override
	protected float getSoundVolume()
	{
		return 0.7F;
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return this.isBurning() ? AC_Item.boarMeat.itemID : AC_Item.uncookedBoarMeat.itemID;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
	 * par2 - Level of Looting used to kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2)
	{
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

		for(int k = 0; k < j; ++k)
		{
			if(this.isBurning())
			{
				this.dropItem(AC_Item.boarMeat.itemID, 1);
			}
			else
			{
				this.dropItem(AC_Item.uncookedBoarMeat.itemID, 1);
			}
		}

	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}

}
