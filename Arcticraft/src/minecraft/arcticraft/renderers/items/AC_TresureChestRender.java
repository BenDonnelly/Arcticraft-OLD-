package arcticraft.renderers.items;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import arcticraft.models.blocks.AC_ModelTresureChest;
import arcticraft.tile_entities.AC_TileEntityCampfire;
import arcticraft.tile_entities.AC_TileEntityTresureChest;

public class AC_TresureChestRender implements IItemRenderer
{

	private AC_ModelTresureChest chestModel;

	public AC_TresureChestRender()
	{
		chestModel = new AC_ModelTresureChest();
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{

		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityTresureChest(), 0.0D, 0.0D, 0.0D, 0.0F);

	}
}
