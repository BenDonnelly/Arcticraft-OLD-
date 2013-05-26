package arcticraft.creative_tabs;

import arcticraft.main.MainRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;

public class AC_TabMisc extends CreativeTabs {
	public AC_TabMisc(int position, String tabID) {
		super(position, tabID);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return MainRegistry.bucketIcyWater.itemID; // this is the item that is
												// displayed on your tab's icon
	}

	public String getTranslatedTabLabel() {
		return "Arcticraft Misc"; // the name that shows up in-game
	}
}