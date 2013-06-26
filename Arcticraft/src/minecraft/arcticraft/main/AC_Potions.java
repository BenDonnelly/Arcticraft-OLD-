package arcticraft.main;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;

public class AC_Potions extends Potion
{

	public AC_Potions(int par1, boolean par2, int par3)
	{
		super(par1, par2, par3);
	}

	@Override
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture("/mods/AC/textures/gui/inventory.png");
		return super.getStatusIconIndex();
	}
}
