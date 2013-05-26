package arcticraft.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import arcticraft.models.AC_ModelPlainStatue;
import arcticraft.tile_entities.AC_TileEntityStatue;

public class AC_ItemStatueRenderer implements IItemRenderer
{

	private AC_ModelPlainStatue plainStatueModel;

	public AC_ItemStatueRenderer()
	{

		plainStatueModel = new AC_ModelPlainStatue();
	}

	@Override
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
		
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityStatue(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}