package arcticraft.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class AC_TemperatureHelper {

	public static final int tempID = 19;
	public static final int maxTemp = 100;
	
	public static int getTemperature(EntityPlayer player) {
		return player.getDataWatcher().getWatchableObjectInt(tempID);
	}
	
	public static void setTemperature(EntityPlayer player, int temp) {
		player.getDataWatcher().updateObject(tempID, Integer.valueOf(temp));
	}
	
	public static void changeTemperature(EntityPlayer player, int dtemp) {
		setTemperature(player, MathHelper.clamp_int(getTemperature(player) + dtemp, 0, maxTemp));
	}
}
