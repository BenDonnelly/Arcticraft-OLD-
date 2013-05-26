package arcticraft.entities;

import java.util.Random;

import net.minecraft.entity.EnumCreatureAttribute;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class AC_EntityPirate extends EntityMob
{

	private Random rand = new Random();
	private int counter = 0;
	public boolean isSwinging = false;
	public int swingProgressInt = 0;

	public AC_EntityPirate(World world)
	{
		super(world);
		this.texture = "/mods/AC/textures/mobs/pirate.png";
		this.moveSpeed = 0.8F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
	}

	public AC_EntityPirate(World world, double d, double d1, double d2)
	{
		super(world);
		this.texture = "/mods/AC/textures/mobs/pirate.png";
		this.moveSpeed = 0.8F;
	}
	
	@Override
	public int getMaxHealth()
	{
		return 14;
	}
	public int getAttackStrength()
	{
		return 4;
	}

	public int getTotalArmorValue()
	{
		return 4;
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
		return new ItemStack(Item.swordStone, 1);
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return Item.ingotIron.itemID;
	}
}
