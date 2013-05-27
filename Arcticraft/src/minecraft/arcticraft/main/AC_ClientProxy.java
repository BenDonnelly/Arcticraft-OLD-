package arcticraft.main;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.entities.AC_EntityBomb;
import arcticraft.entities.AC_EntityFrostZombieBoss;
import arcticraft.entities.AC_EntityHusky;
import arcticraft.entities.AC_EntityIceCreeper;
import arcticraft.entities.AC_EntityIceShard;
import arcticraft.entities.AC_EntityMage;
import arcticraft.entities.AC_EntityPenguin;
import arcticraft.entities.AC_EntityPirate;
import arcticraft.entities.AC_EntityPolarBear;
import arcticraft.items.AC_ItemStatueRenderer;
import arcticraft.models.AC_ModelHusky;
import arcticraft.models.AC_ModelMage;
import arcticraft.models.AC_ModelPenguin;
import arcticraft.models.AC_ModelPolarBear;
import arcticraft.renderers.AC_FrostChestItemRenderHelper;
import arcticraft.renderers.AC_RenderBoar;
import arcticraft.renderers.AC_RenderBomb;
import arcticraft.renderers.AC_RenderFrostZombieBoss;
import arcticraft.renderers.AC_RenderHusky;
import arcticraft.renderers.AC_RenderIceCreeper;
import arcticraft.renderers.AC_RenderIceShards;
import arcticraft.renderers.AC_RenderMage;
import arcticraft.renderers.AC_RenderPenguin;
import arcticraft.renderers.AC_RenderPolarBear;
import arcticraft.renderers.TileEntityFrostChestRender;
import arcticraft.tile_entities.AC_TileEntityStatue;
import arcticraft.tile_entities.AC_TileEntityStatueRenderer;
import arcticraft.tile_entities.TileEntityFrostChest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class AC_ClientProxy extends AC_CommonProxy
{

	@Override
	public void registerTickHandler()
	{
		TickRegistry.registerTickHandler(new AC_TickHandler(), Side.CLIENT);
	}

	@Override
	public void reigsterRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityMage.class, new AC_RenderMage(new AC_ModelMage(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityIceCreeper.class, new AC_RenderIceCreeper());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityIceShard.class, new AC_RenderIceShards());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPenguin.class, new AC_RenderPenguin(new AC_ModelPenguin(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPirate.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityPolarBear.class, new AC_RenderPolarBear(new AC_ModelPolarBear(), 0.5F, 1));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityFrostZombieBoss.class, new AC_RenderFrostZombieBoss());
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityBoar.class, new AC_RenderBoar(new ModelPig(), new ModelPig(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityHusky.class, new AC_RenderHusky(new AC_ModelHusky(), new AC_ModelHusky(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(AC_EntityBomb.class, new AC_RenderBomb(MainRegistry.bomb, 0));
	
		ClientRegistry.bindTileEntitySpecialRenderer(AC_TileEntityStatue.class, new AC_TileEntityStatueRenderer());
		MinecraftForgeClient.registerItemRenderer(MainRegistry.statue.blockID, new AC_ItemStatueRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrostChest.class, new TileEntityFrostChestRender());
		MinecraftForgeClient.registerItemRenderer(MainRegistry.frostChest.blockID, new AC_FrostChestItemRenderHelper());
	}
}
