package arcticraft.lib;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class Debug
{

	public static boolean debugMode = true;
	public static boolean notifyOfGeneration = true;

	public static void out(Object text)
	{
		if(debugMode)	System.out.println("[" + (FMLCommonHandler.instance().getSide() == Side.CLIENT ? "CLIENT" : "SERVER") + "] " + text);
	}

	public static void notifyOfGenertion(Object type, String x, String z)
	{
		if(notifyOfGeneration)
		{
			Minecraft.getMinecraft().thePlayer.addChatMessage(type + " has been generated at, X= " + x + ", " + "Z= " + z);
		}
	}
}
