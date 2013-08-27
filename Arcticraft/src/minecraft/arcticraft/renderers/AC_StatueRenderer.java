package arcticraft.renderers;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import arcticraft.models.AC_ModelPlainStatue;
import arcticraft.tile_entities.AC_TileEntityStatue;

public class AC_StatueRenderer implements IItemRenderer
{

	private AC_ModelPlainStatue plainStatueModel;

	public AC_StatueRenderer()
	{
		plainStatueModel = new AC_ModelPlainStatue();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}
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
