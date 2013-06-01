package arcticraft.main;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

public class AC_EventWorldLoad
{

	Minecraft mc;

	@ForgeSubscribe
	public void worldLoad(WorldEvent event)
	{
		mc = mc.getMinecraft();

		if (mc.thePlayer != null && !mc.thePlayer.getEntityData().hasKey("temp"))
		{
			mc.thePlayer.getEntityData().setInteger("temp", 100);
		}
	}

}
