package com.arcticraft.main;


import com.arcticraft.Block.AC_Block;
import com.arcticraft.creativetabs.AC_CreativeTabs;
import com.arcticraft.gui.AC_GuiHandler;
import com.arcticraft.item.AC_Item;
import com.arcticraft.lib.Strings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Strings.MODID, name = Strings.name, version = Strings.version)

public class MainRegistry {
	
	@SidedProxy(clientSide = "com.arcticraft.main.ClientProxy", serverSide = "com.arcticraft.main.ServerProxy") 
	public static ServerProxy proxy;
	
	@Instance(Strings.MODID)
	public static MainRegistry instance;
	
	/**
	 * Loads before
	 * @param PreEvent
	 */
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent){
		AC_CreativeTabs.initialiseTabs();
		AC_Block.mainRegistry();
		AC_Item.mainRegistry();
		
		proxy.registerTileEntities();
		proxy.registerRenderThings();
	}
	
	/**
	 * Loads during
	 * @param event
	 */
	@EventHandler
	public static void load(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new AC_GuiHandler());
	}
	
	/**
	 * Loads after
	 * @param PostEvent
	 */
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){
		
	}
	
}
