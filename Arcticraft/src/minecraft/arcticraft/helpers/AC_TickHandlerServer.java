package arcticraft.helpers;

import java.util.EnumSet;

import arcticraft.dispenser.AC_DispenserBehaviours;
import arcticraft.main.MainRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class AC_TickHandlerServer implements ITickHandler
{

	Minecraft mc;
	private int tickCounter;

	public AC_TickHandlerServer()
	{
		mc = mc.getMinecraft();
	}

	@Override
	public void tickStart(EnumSet <TickType> type, Object... tickData)
	{
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		{
			killPlayer((EntityPlayer) tickData [0]);
			freezingPotion((EntityPlayer) tickData [0]);
			AC_DispenserBehaviours.registerDispenserBehaviours();
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

	

	public void killPlayer(EntityPlayer entityPlayer)
	{
		if (entityPlayer != null)
		{

			if (AC_TickHandler.value == 0)
			{
				entityPlayer.attackEntityFrom(AC_DamageSource.freezing, 5);

			}

		}
	}

	public void freezingPotion(EntityPlayer entityPlayer)
	{
		//		entityPlayer.addPotionEffect(new PotionEffect(MainRegistry.freezePotion.id, 300, 0));
		tickCounter++;

		if (entityPlayer.isPotionActive(MainRegistry.freezePotion))
		{
			if (tickCounter == 40)
			{
				tickCounter = 0;
				AC_TickHandler.value -= 1;
				entityPlayer.attackEntityFrom(AC_DamageSource.freezing, 1);
			}
		}
	}

	@Override
	public String getLabel()
	{

		return "Arcticraft";
	}

}
