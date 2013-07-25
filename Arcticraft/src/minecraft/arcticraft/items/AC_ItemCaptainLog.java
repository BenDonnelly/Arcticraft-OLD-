package arcticraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import arcticraft.gui.AC_GuiCaptainLog;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemCaptainLog extends Item {

	public AC_ItemCaptainLog(int ID) {
		super(ID);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		FMLClientHandler.instance().displayGuiScreen(player, new AC_GuiCaptainLog());
		return itemstack;
	}
}
