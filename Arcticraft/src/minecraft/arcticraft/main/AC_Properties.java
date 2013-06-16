package arcticraft.main;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;


public class AC_Properties
{
	public static boolean lazyTempUpdates = false;
	
	public static void loadConfig(Configuration config)
	{
		config.load();
		
		Property lazyTempUpdatesProp = config.get("general", "Lazy Temperature Updates", false);
		lazyTempUpdatesProp.comment = "Helps slower computers to avoid lag";
		
		lazyTempUpdates = lazyTempUpdatesProp.getBoolean(false);
		
		AC_TickHandlerScheduled.setTickRate();
		
		config.save();
	}
}
