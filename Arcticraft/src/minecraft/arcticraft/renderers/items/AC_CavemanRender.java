package arcticraft.renderers.items;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import arcticraft.models.blocks.AC_ModelBlockCaveman;
import arcticraft.tile_entities.AC_TileEntityCaveman;

public class AC_CavemanRender implements IItemRenderer
{

	private AC_ModelBlockCaveman caveman;

	public AC_CavemanRender()
	{
		caveman = new AC_ModelBlockCaveman();
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
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityCaveman(), 0.0D, 0.0D, 0.0D, 0.0F);

	}
}
