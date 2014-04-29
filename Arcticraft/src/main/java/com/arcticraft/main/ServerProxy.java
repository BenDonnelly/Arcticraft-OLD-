package com.arcticraft.main;


import net.minecraftforge.common.MinecraftForge;

import com.arcticraft.Block.TileEntityCampfire;
import com.arcticraft.gui.AC_GuiHandler;
import com.arcticraft.tile_entity.AC_TileEntityFrostChest;
import com.arcticraft.tile_entity.TileEntityArcticFurnace;
import com.arcticraft.tile_entity.TileEntityCannon;
import com.arcticraft.tile_entity.TileEntityCaptain;
import com.arcticraft.tile_entity.TileEntityFreezer;
import com.arcticraft.tile_entity.TileEntityTreasureChest;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	public void registerRenderThings(){
	}
	
	public int addArmor(String armor) {
		return 0;
	}
	
	public static void registerNetworkThings(){
		NetworkRegistry.INSTANCE.registerGuiHandler(MainRegistry.instance, new AC_GuiHandler());
	}
	
	
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityArcticFurnace.class, "AC_TileEntityFurnace");
		GameRegistry.registerTileEntity(TileEntityFreezer.class, "AC_TileEntityFreezer");
		GameRegistry.registerTileEntity(AC_TileEntityFrostChest.class, "AC_TileEntityChest");
		GameRegistry.registerTileEntity(TileEntityCaptain.class, "AC_TileEntityCaptain");
		GameRegistry.registerTileEntity(TileEntityCampfire.class, "AC_TileEntityCampfire");
		GameRegistry.registerTileEntity(TileEntityTreasureChest.class, "AC_TileEntityTreasureChest");
		GameRegistry.registerTileEntity(TileEntityCannon.class, "AC_TileEntityCannon");
	}
}
