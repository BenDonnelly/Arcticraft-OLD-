package com.arcticraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class AC_CreativeTabs {
	
	public static CreativeTabs tabBlock;
	public static CreativeTabs tabItem;
	public static CreativeTabs tabFood;
	
	public static void initialiseTabs(){
		tabBlock = new ACTabBlock(CreativeTabs.getNextID(), "ArcticraftBlocks");
		tabItem = new ACTabItem(CreativeTabs.getNextID(), "ArcticraftItems");
		tabFood = new ACTabFood(CreativeTabs.getNextID(), "ArcticraftFood");
	}
	
	
}
