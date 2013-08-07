package arcticraft.entities;

import arcticraft.items.AC_Item;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AC_EntityKnight extends AC_EntityCastleMobDefault
{

	public AC_EntityKnight(World par1World)
	{
		super(par1World);
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if(super.attackEntityAsMob(par1Entity))
		{
			if(par1Entity instanceof EntityLivingBase)
			{

				((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));

			}

			return true;
		}
		else
		{
			return false;
		}
	}

	public ItemStack getHeldItem()
	{
		return new ItemStack(AC_Item.ignisBlade, 1);
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);
		int var4;

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.eriumGem.itemID, 3);
		}

		var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.heatPack.itemID, 1);
		}
	}

	protected void dropRareDrop(int par1)
	{
		this.entityDropItem(new ItemStack(AC_Item.ignisBlade, 1), 0.0F);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return null;
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{

		return null;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return null;
	}

}
