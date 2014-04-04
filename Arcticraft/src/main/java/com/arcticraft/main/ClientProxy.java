package com.arcticraft.main;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.render.FrostChestRenderer;
import com.arcticraft.render.items.ItemCaptainStatueRenderer;
import com.arcticraft.render.items.ItemFrostChestRenderer;
import com.arcticraft.render.tile_entity.AC_TileEntityCaptainStatueRenderer;
import com.arcticraft.tile_entity.AC_TileEntityFrostChest;
import com.arcticraft.tile_entity.TileEntityCaptain;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy{
	
	public void registerRenderThings(){
		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityFrostChest.class, new FrostChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AC_Block.frostChest), new ItemFrostChestRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaptain.class, new AC_TileEntityCaptainStatueRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AC_Block.captainStatue), new ItemCaptainStatueRenderer());
	}
	
	
}
