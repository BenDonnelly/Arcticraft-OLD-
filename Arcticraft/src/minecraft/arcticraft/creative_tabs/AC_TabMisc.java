package arcticraft.creative_tabs;

import net.minecraft.creativetab.CreativeTabs;
import arcticraft.items.AC_Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_TabMisc extends CreativeTabs
{

	public AC_TabMisc(int position, String tabID)
	{
		super(position, tabID);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return AC_Item.bucketIcyWater.itemID; 
	}

	public String getTranslatedTabLabel()
	{
		return "Arcticraft Misc";
	}
}
