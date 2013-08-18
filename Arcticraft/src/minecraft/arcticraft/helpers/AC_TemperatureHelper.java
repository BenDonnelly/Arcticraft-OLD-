package arcticraft.helpers;

import arcticraft.entities.AC_EntityPropertyTemperature;
import net.minecraft.entity.player.EntityPlayer;

public class AC_TemperatureHelper
{

	public static int getTemperature(EntityPlayer player)
	{
		return ((AC_EntityPropertyTemperature) player.getExtendedProperties("Temperature")).getTemperature();
	}
	
	public static void setTemperature(EntityPlayer player, int temp)
	{
		((AC_EntityPropertyTemperature) player.getExtendedProperties("Temperature")).setTemperature(temp);
	}
}
