package arcticraft.main;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;


public class AC_TickHandlerScheduled implements IScheduledTickHandler
{

	private static int tickRate = 19;
	
	public static void setTickRate()
	{
		if (AC_Properties.lazyTempUpdates) tickRate = 39;
	}
	
	@Override
	public void tickStart(EnumSet <TickType> type, Object... tickData)
	{
		int i, j;
		EntityPlayer playerToCheck;
		for (i = 0; i < MinecraftServer.getServer().worldServers.length; ++i)
		{
			for (j = 0; j < MinecraftServer.getServer().worldServers[i].playerEntities.size(); ++j)
			{
				try 
				{ 
					playerToCheck = (EntityPlayer)MinecraftServer.getServer().worldServers[i].playerEntities.get(j);
				}
				catch(Exception e) 
				{ 
					System.out.println("[AC] Failed to cast an player object into an EntityPlayer! This is a serious bug!");
				}
			}
		}

	}

	@Override
	public void tickEnd(EnumSet <TickType> type, Object... tickData)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet <TickType> ticks()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextTickSpacing()
	{
		return tickRate;
		
	}

}
