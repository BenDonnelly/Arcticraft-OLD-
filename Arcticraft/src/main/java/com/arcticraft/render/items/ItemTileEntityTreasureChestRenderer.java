package com.arcticraft.render.items;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.arcticraft.model.AC_ModelCampfire;
import com.arcticraft.model.AC_ModelTresureChest;
import com.arcticraft.tile_entity.TileEntityTreasureChest;

public class ItemTileEntityTreasureChestRenderer implements IItemRenderer
{

	private AC_ModelTresureChest modelChest;

	public ItemTileEntityTreasureChestRenderer()
	{

		modelChest = new AC_ModelTresureChest();
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityTreasureChest(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
