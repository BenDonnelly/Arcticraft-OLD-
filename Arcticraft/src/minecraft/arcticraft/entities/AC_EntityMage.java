package arcticraft.entities;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;

public class AC_EntityMage extends EntityAnimal
{

	private Random rand = new Random();
	private int counter = 0;
	public boolean isSwinging = false;
	public int swingProgressInt = 0;

	public AC_EntityMage(World world)
	{
		super(world);
		this.texture = "/mods/AC/textures/mobs/ice_mage.png";
		setSize(1.5F, 1.9F);
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	/**
	 * Moves the entity based on the specified heading. Args: strafe, forward
	 */
	@Override
	public void moveEntityWithHeading(float par1, float par2)
	{

	}

	public boolean canDespawn()
	{
		return false;
	}

	@Override
	public int getMaxHealth()
	{
		return 1000;
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if (var2 != null && var2.itemID == MainRegistry.mysticalSnow.blockID)
		{
			MainRegistry.talkStuff("\247bIf you feel the need for some new adventures, eat this!", this.worldObj);

			if (--var2.stackSize <= 0)
			{
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(MainRegistry.MystFruit));
			}
			else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MainRegistry.MystFruit)))																									// fruit
			{
				par1EntityPlayer.dropPlayerItem(new ItemStack(MainRegistry.MystFruit.itemID, 1, 0));
			}
			return true;
		}
		else
		{
			MainRegistry.talkStuff("\247bIf you give me some Mystical Snow I will show you the way to a new world", this.worldObj);
			return super.interact(par1EntityPlayer);
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
