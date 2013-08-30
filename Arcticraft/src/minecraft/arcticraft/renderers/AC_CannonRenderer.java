package arcticraft.renderers;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import arcticraft.models.AC_ModelCannon;
import arcticraft.tile_entities.AC_TileEntityCannon;

public class AC_CannonRenderer implements IItemRenderer
{

	private AC_ModelCannon cannonModel;

	public AC_CannonRenderer()
	{
		cannonModel = new AC_ModelCannon();
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
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityCannon(), 0.0D, 0.0D, 0.0D, 0.0F);

	}
}
