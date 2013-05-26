package arcticraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import arcticraft.containers.AC_ContainerArcticFreezer;
import arcticraft.containers.AC_ContainerArcticFurnace;
import arcticraft.tile_entities.AC_TileEntityArcticFurnace;
import arcticraft.tile_entities.AC_TileEntityFreezer;
import cpw.mods.fml.common.network.IGuiHandler;

public class AC_GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity instanceof AC_TileEntityArcticFurnace)
		{

			return new AC_ContainerArcticFurnace(player.inventory, (AC_TileEntityArcticFurnace) tile_entity);
		}
		
		if (tile_entity instanceof AC_TileEntityFreezer)
		{

			return new AC_ContainerArcticFreezer(player.inventory, (AC_TileEntityFreezer) tile_entity);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity instanceof AC_TileEntityArcticFurnace)
		{

			return new AC_GuiArcticFurnace(player.inventory, (AC_TileEntityArcticFurnace) tile_entity);
		}
		
		if (tile_entity instanceof AC_TileEntityFreezer)
		{

			return new AC_GuiFreezer(player.inventory, (AC_TileEntityFreezer) tile_entity);
		}

		return null;
	}
}
