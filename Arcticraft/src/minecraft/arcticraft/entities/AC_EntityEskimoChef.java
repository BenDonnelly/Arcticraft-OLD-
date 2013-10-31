package arcticraft.entities;

import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AC_EntityEskimoChef extends AC_EntityEskimoDefault
{

	public AC_EntityEskimoChef(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 1.4F);
	}
	
	static
	{
		addStuffToBuy(Item.fishCooked, 1, 3, 0.3F);
		addStuffToBuy(Item.fishRaw, 2, 5, 0.4F);
		addStuffToBuy(AC_Block.floranBerry, 1,2, 0.1F);
		addStuffToSell(AC_Item.penguinMeat, 1, 6, 0.58F);
		addStuffToSell(AC_Item.uncookedBoarMeat, 1, 4, 0.5F);
	}

	@Override
	public void func_110297_a_(ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}

}
