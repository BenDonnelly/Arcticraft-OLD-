package com.arcticraft.render.items;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.arcticraft.tile_entity.AC_TileEntityFrostChest;

public class ItemFrostChestRenderer implements IItemRenderer
{

	private ModelChest chestModel;

	public ItemFrostChestRenderer()
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new AC_TileEntityFrostChest(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
