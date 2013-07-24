package arcticraft.gui;

import arcticraft.lib.Strings;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class AC_GuiCaptainLog extends GuiScreenBook {

	private static final ResourceLocation texture = new ResourceLocation(Strings.MOD_ID, "textures/gui/captain_log.png");
	
	public AC_GuiCaptainLog(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack, boolean par3) {
		super(par1EntityPlayer, par2ItemStack, par3);
	}
	
	static ResourceLocation getTexture()
    {
        return texture;
    }

}
