package arcticraft.entities;

import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AC_EntityEskimo extends AC_EntityDefaultEskimo
{

	public AC_EntityEskimo(World par1World)
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
