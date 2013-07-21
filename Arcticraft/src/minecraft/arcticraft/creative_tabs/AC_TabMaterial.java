package arcticraft.creative_tabs;

import net.minecraft.creativetab.CreativeTabs;
import arcticraft.items.AC_Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_TabMaterial extends CreativeTabs
{

	public AC_TabMaterial(int position, String tabID)
	{
		super(position, tabID);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return AC_Item.tekkiteGem.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Arcticraft Materials";
	}
}
