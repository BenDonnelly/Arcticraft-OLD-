package com.arcticraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class AC_CreativeTabs {
	
	public static CreativeTabs tabBlock;
	public static CreativeTabs tabItem;
	public static CreativeTabs tabFood;
	public static CreativeTabs tabTool;
	public static CreativeTabs tabCombat;
	public static CreativeTabs tabMisc;
	
	public static void initialiseTabs(){
		tabBlock = new ACTabBlock(CreativeTabs.getNextID(), "ArcticraftBlocks");
		tabItem = new ACTabItem(CreativeTabs.getNextID(), "ArcticraftItems");
		tabFood = new ACTabFood(CreativeTabs.getNextID(), "ArcticraftFood");
		tabTool = new ACTabTool(CreativeTabs.getNextID(), "ArcticraftTool");
		tabCombat = new ACTabCombat(CreativeTabs.getNextID(), "ArcticraftCombat");
		tabMisc = new ACTabMisc(CreativeTabs.getNextID(), "ArcticraftMisc");
	}
	
	
}
