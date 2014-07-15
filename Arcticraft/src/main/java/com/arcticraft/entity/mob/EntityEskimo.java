package com.arcticraft.entity.mob;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.item.AC_Item;

public class EntityEskimo extends AC_EntityEskimoDefault
{

	public EntityEskimo(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 1.4F);
	}

	static
	{
		addStuffToBuy(AC_Item.arcaneDust, 5, 46, 0.5F);
		addStuffToBuy(AC_Block.crystalGlass, 10, 20, 0.3F);
		addStuffToBuy(AC_Block.campfire, 6, 20, 0.6F);
		addStuffToSell(AC_Item.bomb, 2, 6, 0.6F);
		addStuffToSell(AC_Item.bucketEmpty, 1, 1, 0.59F);
	}

	@Override
	public void func_110297_a_(ItemStack itemstack)
	{
		// TODO Auto-generated method stub

	}

}
