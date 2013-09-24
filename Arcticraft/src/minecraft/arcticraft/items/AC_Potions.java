package arcticraft.items;

import arcticraft.lib.Strings;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_Potions extends Potion
{

	public AC_Potions(int par1, boolean par2, int par3)
	{
		super(par1, par2, par3);
	}

	@Override
	public int getStatusIconIndex()
	{
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "textures/gui/inventory.png"));
		return super.getStatusIconIndex();
	}
}
