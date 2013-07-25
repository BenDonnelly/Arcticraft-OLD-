package arcticraft.main;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import arcticraft.blocks.AC_Block;

import arcticraft.helpers.AC_EventSoundLoad;
import arcticraft.helpers.AC_KeyBindHelper;
import arcticraft.helpers.AC_TickHandler;
import arcticraft.helpers.AC_TickHandlerServer;
import arcticraft.items.AC_Item;

import arcticraft.tile_entities.AC_TileEntityCampfire;
import arcticraft.tile_entities.AC_TileEntityCampfireRenderer;
import arcticraft.tile_entities.AC_TileEntityCaptainStatue;
import arcticraft.tile_entities.AC_TileEntityCaptainStatueRenderer;
import arcticraft.tile_entities.AC_TileEntityFrostChest;
import arcticraft.tile_entities.AC_TileEntityFrostChestRender;
import arcticraft.tile_entities.AC_TileEntityStatue;
import arcticraft.tile_entities.AC_TileEntityStatueRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import arcticraft.entities.*;
import arcticraft.renderers.*;
import arcticraft.models.*;
import arcticraft.tile_entities.*;

public class AC_ClientProxy extends AC_CommonProxy
{

	@Override
	public void registerKeyHandler()
	{
		KeyBindingRegistry.registerKeyBinding(new AC_KeyBindHelper());
	}

	@Override
	public void registerTickHandler()
	{
		TickRegistry.registerTickHandler(new AC_TickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new AC_TickHandlerServer(), Side.SERVER);

	}

	@Override
	public void reigsterRenderThings()
	{

		MinecraftForge.EVENT_BUS.register(new AC_EventSoundLoad());

		RenderingRegistry.registerEntityRenderingHandler(AC_EntityNPickThing.class, new AC_RenderNPickThing());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityWhale.class, new AC_RenderWhale(new AC_ModelWhale(), 20.0F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityMage.class, new AC_RenderMage(new AC_ModelMage(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityFrostGhost.class, new AC_RenderFrostGhost(new AC_ModelFrostGhost(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityIceCreeper.class, new AC_RenderIceCreeper());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityIceShard.class, new AC_RenderIceShards());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPenguin.class, new AC_RenderPenguin(new AC_ModelPenguin(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPirate.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPolarBear.class, new AC_RenderPolarBear(new AC_ModelPolarBear(), 1.4F, 1.4F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityBoar.class, new AC_RenderBoar(new AC_ModelBoar(), new AC_ModelBoar(), 0.8F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityHusky.class, new AC_RenderHusky(new AC_ModelHusky(), new AC_ModelHusky(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityBomb.class, new AC_RenderBomb(AC_Item.bomb, 0));//gets the texture from the item for rendering 
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityCaptain.class, new AC_RenderCaptain());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityCheifEskimo.class, new AC_RenderCheifEskimo(new AC_ModelCheifEskimo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityHunterEskimo.class, new AC_RenderHunterEskimo(new AC_ModelHunterEskimo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityEskimo.class, new AC_RenderEskimo(new AC_ModelEskimo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityTraderEskimo.class, new AC_RenderTraderEskimo(new AC_ModelTraderEskimo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityChefEskimo.class, new AC_RenderChefEskimo(new AC_ModelChefEskimo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityYeti.class, new AC_RenderYeti(new AC_ModelYeti(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityDragon.class, new AC_RenderDragon());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityFrostZombie.class, new AC_RenderZombie(new ModelZombie(), 0.5F, 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPirate.class, new AC_RenderPirate());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntitySled.class, new AC_RenderSled());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityKnight.class, new AC_RenderKnight());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityMiner.class, new AC_RenderMiner());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityArcher.class, new AC_RenderArcher());

		
		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityStatue.class, new AC_TileEntityStatueRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.statue.blockID, new AC_ItemStatueRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityCaptainStatue.class, new AC_TileEntityCaptainStatueRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.captainStatue.blockID, new AC_CaptainStatueRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityFrostChest.class, new AC_TileEntityFrostChestRender());
		MinecraftForgeClient.registerItemRenderer(AC_Block.frostChest.blockID, new AC_FrostChestRender());

		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityCampfire.class, new AC_TileEntityCampfireRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.campfire.blockID, new AC_CampfireRenderer());

		MinecraftForgeClient.registerItemRenderer(AC_Item.invisoStaff.itemID, (IItemRenderer) new AC_InvisoStaffRenderer());

		MinecraftForgeClient.registerItemRenderer(AC_Item.notchedPickaxe.itemID, (IItemRenderer) new AC_NotchedPickaxeRenderer());

	}

	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

}
