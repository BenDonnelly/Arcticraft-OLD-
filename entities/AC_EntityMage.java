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
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

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
		int i = rand.nextInt(3);

		if (i == 2)
		{
			MainRegistry.talkStuff("\247bI can never be killed, your better off not to bother", this.worldObj);
		}
		else if (i == 1)
		{
			MainRegistry.talkStuff("\247bYou should seriously stop, I have no weaknesses", this.worldObj);
		}
		else
		{
			MainRegistry.talkStuff("\247bThere is no point in what your doing, I am not going to hurt you", this.worldObj);
		}
		this.heal(100);
		return super.attackEntityFrom(par1DamageSource, par2);
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

	public int getAttackStrength()
	{
		return 4;
	}

	public int getTotalArmorValue()
	{
		return 4;
	}

	public ItemStack getHeldItem()
	{
		return new ItemStack(Item.swordStone, 1);
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
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(MainRegistry.mysticalSnow));// change
																																						// to
																																						// fruit
			}
			else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MainRegistry.mysticalSnow)))// change
																													// to
																													// fruit
			{
				par1EntityPlayer.dropPlayerItem(new ItemStack(MainRegistry.mysticalSnow.blockID, 1, 0));// change
																										// to
																										// fruit
			}
			return true;
		}
		else
		{
			MainRegistry.talkStuff("\247bIf you give me some Mystical Snow I will show you the way to a new world", this.worldObj);
			return super.interact(par1EntityPlayer);
		}
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return Item.ingotIron.itemID;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
