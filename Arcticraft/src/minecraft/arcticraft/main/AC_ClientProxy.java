package arcticraft.main;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityArcher;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.entities.AC_EntityBomb;
import arcticraft.entities.AC_EntityCaptain;
import arcticraft.entities.AC_EntityCaveman;
import arcticraft.entities.AC_EntityChefEskimo;
import arcticraft.entities.AC_EntityCheifEskimo;
import arcticraft.entities.AC_EntityDragon;
import arcticraft.entities.AC_EntityEskimo;
import arcticraft.entities.AC_EntityFrostGhost;
import arcticraft.entities.AC_EntityFrostZombie;
import arcticraft.entities.AC_EntityHunterEskimo;
import arcticraft.entities.AC_EntityHusky;
import arcticraft.entities.AC_EntityIceCreeper;
import arcticraft.entities.AC_EntityIceShard;
import arcticraft.entities.AC_EntityKnight;
import arcticraft.entities.AC_EntityMage;
import arcticraft.entities.AC_EntityMiner;
import arcticraft.entities.AC_EntityNPickThing;
import arcticraft.entities.AC_EntityPenguin;
import arcticraft.entities.AC_EntityPirate;
import arcticraft.entities.AC_EntityPirateHook;
import arcticraft.entities.AC_EntityPolarBear;
import arcticraft.entities.AC_EntitySled;
import arcticraft.entities.AC_EntityTraderEskimo;
import arcticraft.entities.AC_EntityWhale;
import arcticraft.entities.AC_EntityYeti;
import arcticraft.helpers.AC_EventSoundLoad;
import arcticraft.helpers.AC_KeyBindHelper;
import arcticraft.helpers.AC_TickHandler;
import arcticraft.helpers.AC_TickHandlerServer;
import arcticraft.items.AC_Item;
import arcticraft.models.AC_ModelBoar;
import arcticraft.models.AC_ModelChefEskimo;
import arcticraft.models.AC_ModelCheifEskimo;
import arcticraft.models.AC_ModelEntityCaveman;
import arcticraft.models.AC_ModelEskimo;
import arcticraft.models.AC_ModelFrostGhost;
import arcticraft.models.AC_ModelHunterEskimo;
import arcticraft.models.AC_ModelHusky;
import arcticraft.models.AC_ModelMage;
import arcticraft.models.AC_ModelPenguin;
import arcticraft.models.AC_ModelPirateHook;
import arcticraft.models.AC_ModelPolarBear;
import arcticraft.models.AC_ModelTraderEskimo;
import arcticraft.models.AC_ModelWhale;
import arcticraft.models.AC_ModelYeti;
import arcticraft.renderers.AC_CampfireRenderer;
import arcticraft.renderers.AC_CannonRenderer;
import arcticraft.renderers.AC_CannonballRenderer;
import arcticraft.renderers.AC_CaptainStatueRenderer;
import arcticraft.renderers.AC_CavemanRenderer;
import arcticraft.renderers.AC_FrostChestRender;
import arcticraft.renderers.AC_IceClubRenderer;
import arcticraft.renderers.AC_InvisoStaffRenderer;
import arcticraft.renderers.AC_NotchedPickaxeRenderer;
import arcticraft.renderers.AC_RenderArcher;
import arcticraft.renderers.AC_RenderBoar;
import arcticraft.renderers.AC_RenderBomb;
import arcticraft.renderers.AC_RenderCaptain;
import arcticraft.renderers.AC_RenderCaveman;
import arcticraft.renderers.AC_RenderChefEskimo;
import arcticraft.renderers.AC_RenderCheifEskimo;
import arcticraft.renderers.AC_RenderDragon;
import arcticraft.renderers.AC_RenderEskimo;
import arcticraft.renderers.AC_RenderFrostGhost;
import arcticraft.renderers.AC_RenderHunterEskimo;
import arcticraft.renderers.AC_RenderHusky;
import arcticraft.renderers.AC_RenderIceCreeper;
import arcticraft.renderers.AC_RenderIceShards;
import arcticraft.renderers.AC_RenderKnight;
import arcticraft.renderers.AC_RenderMage;
import arcticraft.renderers.AC_RenderMiner;
import arcticraft.renderers.AC_RenderNPickThing;
import arcticraft.renderers.AC_RenderPenguin;
import arcticraft.renderers.AC_RenderPirate;
import arcticraft.renderers.AC_RenderPirateHook;
import arcticraft.renderers.AC_RenderPolarBear;
import arcticraft.renderers.AC_RenderSled;
import arcticraft.renderers.AC_RenderTraderEskimo;
import arcticraft.renderers.AC_RenderWhale;
import arcticraft.renderers.AC_RenderYeti;
import arcticraft.renderers.AC_RenderZombie;
import arcticraft.renderers.AC_TresureChestRenderer;
import arcticraft.tile_entities.AC_TileEntityCampfire;
import arcticraft.tile_entities.AC_TileEntityCannon;
import arcticraft.tile_entities.AC_TileEntityCaptainStatue;
import arcticraft.tile_entities.AC_TileEntityCaveman;
import arcticraft.tile_entities.AC_TileEntityFrostChest;
import arcticraft.tile_entities.AC_TileEntityTresureChest;
import arcticraft.tile_entity_renderer.AC_TileEntityCampfireRenderer;
import arcticraft.tile_entity_renderer.AC_TileEntityCannonRenderer;
import arcticraft.tile_entity_renderer.AC_TileEntityCaptainStatueRenderer;
import arcticraft.tile_entity_renderer.AC_TileEntityCavemanRenderer;
import arcticraft.tile_entity_renderer.AC_TileEntityFrostChestRender;
import arcticraft.tile_entity_renderer.AC_TileEntityTresureChestRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityCaptain.class, new AC_RenderCaptain(new AC_ModelPirateHook()));
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
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPirateHook.class, new AC_RenderPirateHook());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityCaveman.class, new AC_RenderCaveman(new AC_ModelEntityCaveman(), 0.5F));

		
		

		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityCaptainStatue.class, new AC_TileEntityCaptainStatueRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.captainStatue.blockID, new AC_CaptainStatueRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityFrostChest.class, new AC_TileEntityFrostChestRender());
		MinecraftForgeClient.registerItemRenderer(AC_Block.frostChest.blockID, new AC_FrostChestRender());

		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityCampfire.class, new AC_TileEntityCampfireRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.campfire.blockID, new AC_CampfireRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityCaveman.class, new AC_TileEntityCavemanRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.caveman.blockID, new AC_CavemanRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityTresureChest.class, new AC_TileEntityTresureChestRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.tresureChest.blockID, new AC_TresureChestRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityCannon.class, new AC_TileEntityCannonRenderer());
		MinecraftForgeClient.registerItemRenderer(AC_Block.cannon.blockID, new AC_CannonRenderer());
		
		MinecraftForgeClient.registerItemRenderer(AC_Item.invisoStaff.itemID, (IItemRenderer) new AC_InvisoStaffRenderer());

		MinecraftForgeClient.registerItemRenderer(AC_Item.notchedPickaxe.itemID, (IItemRenderer) new AC_NotchedPickaxeRenderer());

		MinecraftForgeClient.registerItemRenderer(AC_Item.iceClub.itemID, (IItemRenderer) new AC_IceClubRenderer());
		
		MinecraftForgeClient.registerItemRenderer(AC_Item.iceClub.itemID, (IItemRenderer) new AC_IceClubRenderer());
		
		MinecraftForgeClient.registerItemRenderer(AC_Item.cannonball.itemID, (IItemRenderer) new AC_CannonballRenderer());


		
	}

	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

}
