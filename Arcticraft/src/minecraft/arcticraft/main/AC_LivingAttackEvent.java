package arcticraft.main;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class AC_LivingAttackEvent
{

	@ForgeSubscribe
	public void onEntityHurt(LivingAttackEvent event)
	{
		
		if(AC_TickHandler.value == 0)
		{
		}
	}
	
}
