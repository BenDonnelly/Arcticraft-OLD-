package com.arcticraft.main;

import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.terraingen.BiomeEvent;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.creativetabs.AC_CreativeTabs;
import com.arcticraft.entity.AC_Entity;
import com.arcticraft.item.AC_Item;
import com.arcticraft.lib.Strings;
import com.arcticraft.world.WorldProviderArctic;
import com.arcticraft.world.biome.AC_BiomeGenBase;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Strings.MODID, name = Strings.name, version = Strings.version)
public class MainRegistry {

	@SidedProxy(clientSide = "com.arcticraft.main.ClientProxy", serverSide = "com.arcticraft.main.ServerProxy")
	public static ServerProxy proxy;

	@Instance(Strings.MODID)
	public static MainRegistry instance;

	public static final int dimensionId = DimensionManager.getNextFreeDimId();

	/**
	 * Loads before
	 * 
	 * @param PreEvent
	 */
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) {
		AC_CreativeTabs.initialiseTabs();
		AC_Block.mainRegistry();
		AC_Item.mainRegistry();
		AC_Entity.mainRegistry();
		
		 
		DimensionManager.registerProviderType(dimensionId, WorldProviderArctic.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
		
		
		proxy.registerNetworkThings();
		proxy.registerTileEntities();
	}

	/**
	 * Loads during
	 * 
	 * @param event
	 */
	@EventHandler
	public static void load(FMLInitializationEvent event) {
		proxy.registerRenderThings();
	}

	/**
	 * Loads after
	 * 
	 * @param PostEvent
	 */
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	public static void talkStuff(String s, World par1World) {
		Iterator<EntityPlayer> players = par1World.playerEntities.iterator();

		while (players.hasNext()) {
			EntityPlayer player = players.next();

			if (player instanceof EntityPlayerMP) {
				Minecraft.getMinecraft().thePlayer.sendChatMessage(s);
			}
		}

	}

}
