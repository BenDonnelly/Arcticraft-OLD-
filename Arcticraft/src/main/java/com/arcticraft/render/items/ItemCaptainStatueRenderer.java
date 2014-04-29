package com.arcticraft.render.items;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.arcticraft.model.AC_ModelStatue;
import com.arcticraft.tile_entity.TileEntityCaptain;

public class ItemCaptainStatueRenderer implements IItemRenderer
{

	private AC_ModelStatue chestModel;

	public ItemCaptainStatueRenderer()
	{

		chestModel = new AC_ModelStatue();
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCaptain(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
