package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemSword extends ItemSword
{

	public AC_ItemSword(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
		if (this == MainRegistry.TekkiteSword)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:tekkiteSword");
		}
		if (this == MainRegistry.EscariaSword)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:escariaSword");
		}

		if (this == MainRegistry.RigentemSword)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:rigentemSword");
		}

		if (this == MainRegistry.GlacianSword)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:glaciansSword");
		}

		if (this == MainRegistry.ArcticStoneSword)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:iceSword");
		}

		if (this == MainRegistry.FrostWoodSword)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:frostWoodSword");
		}

	}
}
