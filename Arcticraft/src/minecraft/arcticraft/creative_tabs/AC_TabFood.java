package arcticraft.creative_tabs;

import net.minecraft.creativetab.CreativeTabs;
import arcticraft.items.AC_Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_TabFood extends CreativeTabs
{

	public AC_TabFood(int position, String tabID)
	{
		super(position, tabID);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return AC_Item.penguinMeatCooked.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Arcticraft Foodstuffs";
	}
}
