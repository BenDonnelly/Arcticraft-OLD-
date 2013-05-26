package arcticraft.creative_tabs;

import arcticraft.main.MainRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;

public class AC_TabCombat extends CreativeTabs {
	public AC_TabCombat(int position, String tabID) {
		super(position, tabID);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return MainRegistry.IceShard.itemID; // this is the item that is
												// displayed on your tab's icon
	}

	public String getTranslatedTabLabel() {
		return "Arcticraft Combat"; // the name that shows up in-game
	}
}