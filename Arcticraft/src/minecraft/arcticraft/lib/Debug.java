package arcticraft.lib;

import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class Debug 
{
	public static boolean debugMode = true;
	
	public static void out(Object text)
	{
		if (debugMode) System.out.println("[" + (FMLCommonHandler.instance().getSide() == Side.CLIENT ? "CLIENT" : "SERVER") + "] " + text);
	}
}
