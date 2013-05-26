package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemAxe extends ItemAxe
{

	public AC_ItemAxe(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
		if (this == MainRegistry.TekkiteAxe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:tekkiteAxe");
		}
		if (this == MainRegistry.EscariaAxe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:escariaAxe");
		}

		if (this == MainRegistry.RigentemAxe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:rigentemAxe");
		}

		if (this == MainRegistry.GlacianAxe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:glaciansAxe");
		}

		if (this == MainRegistry.ArcticStoneAxe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:iceAxe");
		}

		if (this == MainRegistry.FrostWoodAxe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:frostWoodAxe");
		}
	}
}
