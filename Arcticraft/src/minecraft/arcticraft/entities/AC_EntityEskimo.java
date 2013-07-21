package arcticraft.entities;

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
		addStuffToBuy(Block.stone, 5, 46, 0.5F);
		addStuffToBuy(Block.dirt, 10, 20, 0.3F);
		addStuffToBuy(Item.stick, 12, 54, 0.6F);
		addStuffToSell(Block.blockGold, 2, 6, 0.8F);
		addStuffToSell(Item.emerald, 1, 1, 0.99F);
	}

	@Override
	public void func_110297_a_(ItemStack itemstack)
	{
		// TODO Auto-generated method stub

	}

}
