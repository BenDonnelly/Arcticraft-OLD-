package arcticraft.main;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class AC_CommonProxy
{

public void registerKeyHandler(){
	
}
	
	public void registerTickHandler()
	{
		TickRegistry.registerScheduledTickHandler(new AC_TickHandlerScheduled(), Side.SERVER);
	}

	public void reigsterRenderThings()
	{

	}

	public int addArmor(String Armor)
	{
		return 0;
	}

}
