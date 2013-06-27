package arcticraft.items;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import arcticraft.models.AC_ModelCampfire;
import arcticraft.models.AC_ModelPlainStatue;
import arcticraft.tile_entities.AC_TileEntityCampfire;

public class AC_ItemCampfireRenderer implements IItemRenderer
{

	private AC_ModelCampfire campfireModel;

	public AC_ItemCampfireRenderer()
	{
		campfireModel = new AC_ModelCampfire();
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
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityCampfire(), 0.0D, 0.0D, 0.0D, 0.0F);

	}
}
