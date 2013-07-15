package arcticraft.entities;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
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
		setSize(1.5F, 1.9F);
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled()
	{
		return true;
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



	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if (var2 != null && var2.itemID == AC_Block.mysticalSnow.blockID)
		{
			this.randomChat("trade");

			if (--var2.stackSize <= 0)
			{
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(AC_Item.MystFruit));
			}
			else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(AC_Item.MystFruit))) // fruit
			{
				par1EntityPlayer.dropPlayerItem(new ItemStack(AC_Item.MystFruit.itemID, 1, 0));
			}

			return true;
		}
		else
		{
			this.randomChat("give");

			return super.interact(par1EntityPlayer);
		}
	}

	public void randomChat(String type)
	{
		int i = rand.nextInt(3);

		if (type.equals("trade"))
		{
			if (i == 2)
			{
				MainRegistry.talkStuff("\247bIf you feel the need for some new adventures, eat this!", this.worldObj);
			}
			else if (i == 1)
			{
				MainRegistry.talkStuff("\247bDevouring this will send you off into the cold!", this.worldObj);
			}
			else
			{
				MainRegistry.talkStuff("\247bEating this will cast you into the snow barren Arctic!", this.worldObj);
			}
		}

		if (type.equals("give"))
		{
			if (i == 2)
			{
				MainRegistry.talkStuff("\247bIf you give me some Mystical Snow I will show you the way to a new world", this.worldObj);
			}
			else if (i == 1)
			{
				MainRegistry.talkStuff("\247bAdventures await if you hand me some Mystical Snow", this.worldObj);
			}
			else
			{
				MainRegistry.talkStuff("\247bA Freezing future awaits if I can have some Mystical Snow from you", this.worldObj);
			}
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
