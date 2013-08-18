package arcticraft.helpers;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import arcticraft.items.AC_ItemRecord;

;

public class AC_EventSoundLoad
{

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try
		{
		
			/*Portal*/
			event.manager.addSound("ac:other/portal.wav");

			/*Penguin*/
			event.manager.addSound("ac:mobs/penguin_hurt.wav");
			event.manager.addSound("ac:mobs/penguin_death.wav");
			event.manager.addSound("ac:mobs/penguin_idle.wav");

			/*Pirate*/
			event.manager.addSound("ac:mobs/pirate_hurt.wav");
			event.manager.addSound("ac:mobs/pirate_death.wav");
			event.manager.addSound("ac:mobs/pirate_idle.wav");

			/*Polar Bear*/
			event.manager.addSound("ac:mobs/bear_idle.wav");
			event.manager.addSound("ac:mobs/bear_angry.wav");
			event.manager.addSound("ac:mobs/bear_death.wav");
			event.manager.addSound("ac:mobs/bear_hurt.wav");

			/*Boar*/
			event.manager.addSound("ac:mobs/boar_hurt.wav");
			event.manager.addSound("ac:mobs/boar_living.wav");
			event.manager.addSound("ac:mobs/boar_death.wav");
		
			/*Caveman*/
			event.manager.addSound("ac:mobs/caveman_footstep.wav");
			event.manager.addSound("ac:mobs/caveman_living.wav");
			event.manager.addSound("ac:mobs/caveman_hurt.wav");
			event.manager.addSound("ac:mobs/caveman_death.wav");
			
			/*Records*/
			for(String name : AC_ItemRecord.recordNames)
			{
				event.manager.addStreaming("ac:records/" + name + ".wav");
			}

		}

		catch(Exception e)
		{
			System.err.println("Failed to register Arcticraft sounds");
		}
	}
}
