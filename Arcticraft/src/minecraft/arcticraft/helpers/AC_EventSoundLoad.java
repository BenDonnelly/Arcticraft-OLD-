package arcticraft.helpers;

import arcticraft.items.AC_ItemRecord;
import arcticraft.main.MainRegistry;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

;

public class AC_EventSoundLoad
{

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try
		{
			/* TEMPLATE						When using this becomes modname.sound
			event.manager.addSound("modname/sound.wav", MainClass.class.getResource("path/filename.wav"));
			
			If you want to have a randomized sound for a mob you do this:
			
			event.manager.addSound("modname/mobsound1.wav", MainClass.class.getResource("path/filename.wav"));
			event.manager.addSound("modname/mobsound2.wav", MainClass.class.getResource("path/filename.wav"));
			event.manager.addSound("modname/mobsound3.wav", MainClass.class.getResource("path/filename.wav"));
			
			To play it in the entity file you just use modname.mobsound
			
			*/

			//Portal
			event.manager.addSound("ac:other/portal.wav");

			//Penguin
			event.manager.addSound("ac:mobs/penguin_hurt.wav");
			event.manager.addSound("ac:mobs/penguin_death.wav");
			event.manager.addSound("ac:mobs/penguin_idle.wav");

			//Pirate
			event.manager.addSound("ac:mobs/pirate_hurt.wav");
			event.manager.addSound("ac:mobs/pirate_death.wav");
			event.manager.addSound("ac:mobs/pirate_idle.wav");

			//Polar Bear
			event.manager.addSound("ac:mobs/bear_idle.wav");
			event.manager.addSound("ac:mobs/bear_angry.wav");
			event.manager.addSound("ac:mobs/bear_death.wav");
			event.manager.addSound("ac:mobs/bear_hurt.wav");

			//Boar
			event.manager.addSound("ac:mobs/boar_hurt.wav");
			event.manager.addSound("ac:mobs/boar_living.wav");
			event.manager.addSound("ac:mobs/boar_death.wav");
//thats how we did it in 1.5^ but i found on mc forums that you dont do it that way but lets try it anyway yup see
			
			//You have to use the mod name but last time we used the / now we might have to use : not sure, I also dont know if captaliztion matters cos our mod name is Arcticraft. By mod name I mean the mod name no tthe ID but lets the try the ID wait
			//lets try now
			//Ingame Music
			for (String name : AC_ItemRecord.recordNames)
			{
				event.manager.addStreaming("ac:records/" + name + ".wav");
			}

		}

		catch (Exception e)
		{
			System.err.println("Failed to register Arcticraft sounds");
		}
	}
}
