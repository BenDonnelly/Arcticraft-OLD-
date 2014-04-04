package com.arcticraft.main;


import com.arcticraft.tile_entity.AC_TileEntityFrostChest;
import com.arcticraft.tile_entity.TileEntityArcticFurnace;
import com.arcticraft.tile_entity.TileEntityCaptain;
import com.arcticraft.tile_entity.TileEntityFreezer;

import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	public void registerRenderThings(){
	}
	
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityArcticFurnace.class, "AC_TileEntityFurnace");
		GameRegistry.registerTileEntity(TileEntityFreezer.class, "AC_TileEntityFreezer");
		GameRegistry.registerTileEntity(AC_TileEntityFrostChest.class, "AC_TileEntityChest");
		GameRegistry.registerTileEntity(TileEntityCaptain.class, "AC_TileEntityCaptain");
	}
}
