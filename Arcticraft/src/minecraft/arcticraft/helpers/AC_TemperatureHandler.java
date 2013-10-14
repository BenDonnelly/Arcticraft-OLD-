package arcticraft.helpers;

import java.util.EnumSet;

import arcticraft.main.MainRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class AC_TemperatureHandler implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		EntityPlayer player = (EntityPlayer) tickData[0];
		int temp = AC_TemperatureHelper.getTemperature(player);

		if (temp <= 10) {
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2));
			
			if (temp <= 5) {
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 50));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
				
				if (temp == 0) {
					player.addPotionEffect(new PotionEffect(MainRegistry.freezePotion.id, 1000, 1));
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "Temperature Handler";
	}

}
