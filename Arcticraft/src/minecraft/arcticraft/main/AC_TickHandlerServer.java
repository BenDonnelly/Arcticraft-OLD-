package arcticraft.main;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class AC_TickHandlerServer implements ITickHandler
{

	@Override
	public void tickStart(EnumSet <TickType> type, Object... tickData)
	{
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		{
			killPlayer((EntityPlayer) tickData [0]);
		}
	}

	public void killPlayer(EntityPlayer entityPlayer)
	{
		if (entityPlayer != null)
		{

			if (AC_TickHandler.value == 0)
			{
				entityPlayer.attackEntityFrom(AC_DamageSource.freezing, 5);

			}
			if (entityPlayer.getHealth() == 0)
			{
				AC_TickHandler.value = 50;
				System.out.println("Reset Value: " + AC_TickHandler.value);
			}
		}
	}
	@Override
	public void tickEnd(EnumSet <TickType> type, Object... tickData)
	{

	}

	@Override
	public EnumSet <TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel()
	{

		return "Arcticraft";
	}

}
