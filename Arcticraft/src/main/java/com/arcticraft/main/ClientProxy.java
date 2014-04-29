package com.arcticraft.main;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.Block.TileEntityCampfire;
import com.arcticraft.entity.EntityCannonball;
import com.arcticraft.entity.EntityIceShard;
import com.arcticraft.entity.EntityNPickaxe;
import com.arcticraft.entity.item.EntityPirateHook;
import com.arcticraft.entity.mob.EntityCaptain;
import com.arcticraft.entity.mob.EntityFrostGhost;
import com.arcticraft.entity.mob.EntityFrostZombie;
import com.arcticraft.entity.mob.EntityIceCreeper;
import com.arcticraft.entity.mob.EntityMage;
import com.arcticraft.entity.mob.EntityPirate;
import com.arcticraft.item.AC_Item;
import com.arcticraft.model.AC_ModelFrostGhost;
import com.arcticraft.model.AC_ModelFrostZombie;
import com.arcticraft.model.AC_ModelMage;
import com.arcticraft.render.FrostChestRenderer;
import com.arcticraft.render.entity.RenderEntityCaptain;
import com.arcticraft.render.entity.RenderEntityFrostGhost;
import com.arcticraft.render.entity.RenderEntityFrostZombie;
import com.arcticraft.render.entity.RenderEntityIceCreeper;
import com.arcticraft.render.entity.RenderEntityIceShard;
import com.arcticraft.render.entity.RenderEntityNPickaxe;
import com.arcticraft.render.entity.RenderEntityPirate;
import com.arcticraft.render.entity.RenderIceMage;
import com.arcticraft.render.entity.RenderPirateHook;
import com.arcticraft.render.items.ItemCampfireRenderer;
import com.arcticraft.render.items.ItemCaptainStatueRenderer;
import com.arcticraft.render.items.ItemFrostChestRenderer;
import com.arcticraft.render.items.ItemTileEntityCannonRenderer;
import com.arcticraft.render.items.ItemTileEntityTreasureChestRenderer;
import com.arcticraft.render.items.NotchedPickaxeRender;
import com.arcticraft.render.tile_entity.AC_TileEntityCampfireRenderer;
import com.arcticraft.render.tile_entity.AC_TileEntityCannonRenderer;
import com.arcticraft.render.tile_entity.AC_TileEntityCaptainStatueRenderer;
import com.arcticraft.render.tile_entity.AC_TileEntityTreasureRenderer;
import com.arcticraft.tile_entity.AC_TileEntityFrostChest;
import com.arcticraft.tile_entity.TileEntityCannon;
import com.arcticraft.tile_entity.TileEntityCaptain;
import com.arcticraft.tile_entity.TileEntityTreasureChest;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{
	
	@Override
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(EntityCannonball.class, new RenderSnowball(AC_Item.cannonball));
		RenderingRegistry.registerEntityRenderingHandler(EntityCannonball.class, new RenderSnowball(AC_Item.bomb));
		RenderingRegistry.registerEntityRenderingHandler(EntityNPickaxe.class, new RenderEntityNPickaxe());
		RenderingRegistry.registerEntityRenderingHandler(EntityIceShard.class, new RenderEntityIceShard());
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateHook.class, new RenderPirateHook());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostGhost.class, new RenderEntityFrostGhost(new AC_ModelFrostGhost(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderIceMage(new AC_ModelMage(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostZombie.class, new RenderEntityFrostZombie(new AC_ModelFrostZombie(), 0, 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceCreeper.class, new RenderEntityIceCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityPirate.class, new RenderEntityPirate());
		RenderingRegistry.registerEntityRenderingHandler(EntityCaptain.class, new RenderEntityCaptain());
		
		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityFrostChest.class, new FrostChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AC_Block.frostChest), new ItemFrostChestRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaptain.class, new AC_TileEntityCaptainStatueRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AC_Block.captainStatue), new ItemCaptainStatueRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new AC_TileEntityCampfireRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AC_Block.campfire), new ItemCampfireRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTreasureChest.class, new AC_TileEntityTreasureRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AC_Block.tresureChest), new ItemTileEntityTreasureChestRenderer());
		

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCannon.class, new AC_TileEntityCannonRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AC_Block.cannon), new ItemTileEntityCannonRenderer());
	
		MinecraftForgeClient.registerItemRenderer(AC_Item.notchedPickaxe, (IItemRenderer) new NotchedPickaxeRender());
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	
}

