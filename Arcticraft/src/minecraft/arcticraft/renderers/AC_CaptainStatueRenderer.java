package arcticraft.renderers;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import arcticraft.models.AC_ModelStatue;
import arcticraft.tile_entities.AC_TileEntityCaptainStatue;

public class AC_CaptainStatueRenderer implements IItemRenderer
{

	private AC_ModelStatue plainStatueModel;

	public AC_CaptainStatueRenderer()
	{
		plainStatueModel = new AC_ModelStatue();
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
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityCaptainStatue(), 0.0D, 0.0D, 0.0D, 0.0F);

	}
}
