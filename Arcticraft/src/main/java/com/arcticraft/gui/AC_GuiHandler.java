package com.arcticraft.gui;

import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.world.World;

import com.arcticraft.inventory.AC_ContainerFreezer;
import com.arcticraft.inventory.AC_ContainerFurnace;
import com.arcticraft.inventory.AC_ContainerTreasureChest;
import com.arcticraft.tile_entity.TileEntityArcticFurnace;
import com.arcticraft.tile_entity.TileEntityFreezer;
import com.arcticraft.tile_entity.TileEntityTreasureChest;

import cpw.mods.fml.common.network.IGuiHandler;

public class AC_GuiHandler implements IGuiHandler {
	public AC_GuiHandler() {
	}

	/**
	 * Gets the server element. This means, do something server side, when this
	 * ID gets called.
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 0) {
			TileEntityArcticFurnace tileEntityTestContainer = (TileEntityArcticFurnace) world.getTileEntity(x, y, z);
			return new AC_ContainerFurnace(player.inventory, tileEntityTestContainer);
		} else if (ID == 1) {
			TileEntityFreezer tileEntityTestContainer = (TileEntityFreezer) world.getTileEntity(x, y, z);
			return new AC_ContainerFreezer(player.inventory, tileEntityTestContainer);
		} else if (ID == 2){
			TileEntityTreasureChest tileEntityTestContainer = (TileEntityTreasureChest) world.getTileEntity(x, y, z);
			return new AC_ContainerTreasureChest(player.inventory, tileEntityTestContainer);
		}
			return null;
	}

	/**
	 * Gets the client element. This means, do something client side, when this
	 * ID gets called.
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 0) {
			TileEntityArcticFurnace tileEntityTestContainer = (TileEntityArcticFurnace) world.getTileEntity(x, y, z);
			return new AC_GuiFurnace(player.inventory, tileEntityTestContainer);
		} else if (ID == 1) {
			TileEntityFreezer tileEntityTestContainer = (TileEntityFreezer) world.getTileEntity(x, y, z);
			return new AC_GuiFreezer(player.inventory, tileEntityTestContainer);
		}else if (ID == 2){
			TileEntityTreasureChest tileEntityTestContainer = (TileEntityTreasureChest) world.getTileEntity(x, y, z);
			return new AC_TreasureChest(player.inventory, tileEntityTestContainer);
		}
		return null;
	}
}
