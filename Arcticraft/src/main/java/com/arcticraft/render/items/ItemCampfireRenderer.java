package com.arcticraft.render.items;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.arcticraft.Block.TileEntityCampfire;
import com.arcticraft.model.AC_ModelCampfire;

public class ItemCampfireRenderer implements IItemRenderer
{

	private AC_ModelCampfire modelCampfire;

	public ItemCampfireRenderer()
	{

		modelCampfire = new AC_ModelCampfire();
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCampfire(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
