package arcticraft.renderers;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import arcticraft.models.AC_ModelPlainStatue;
import arcticraft.tile_entities.AC_TileEntityCaptainStatue;

public class AC_CaptainStatueRenderer implements IItemRenderer
{

	private AC_ModelPlainStatue plainStatueModel;

	public AC_CaptainStatueRenderer()
	{
		plainStatueModel = new AC_ModelPlainStatue();
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
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityCaptainStatue(), 0.0D, 0.0D, 0.0D, 0.0F);

	}
}
