package arcticraft.main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;


public class AC_ForgeEvents
{

	@ForgeSubscribe
	public void playerDeath(LivingDeathEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			AC_TickHandler.value = 50;
			System.out.println("Resetting the players Temperature...");
		}
	}
}
