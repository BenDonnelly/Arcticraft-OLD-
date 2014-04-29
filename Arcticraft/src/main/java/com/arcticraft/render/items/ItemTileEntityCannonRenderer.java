package com.arcticraft.render.items;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.arcticraft.model.AC_ModelCannon;
import com.arcticraft.tile_entity.TileEntityCannon;

public class ItemTileEntityCannonRenderer implements IItemRenderer
{

	private AC_ModelCannon modelChest;

	public ItemTileEntityCannonRenderer()
	{

		modelChest = new AC_ModelCannon();
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCannon(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
