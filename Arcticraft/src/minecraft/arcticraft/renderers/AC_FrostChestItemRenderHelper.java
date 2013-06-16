package arcticraft.renderers;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import arcticraft.models.AC_ModelPlainStatue;
import arcticraft.tile_entities.AC_TileEntityFrostChest;

public class AC_FrostChestItemRenderHelper implements IItemRenderer
{

	private ModelChest chestModel;

	public AC_FrostChestItemRenderHelper()
	{

		chestModel = new ModelChest();
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
		
		TileEntityRenderer.instance.renderTileEntityAt(new AC_TileEntityFrostChest(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}