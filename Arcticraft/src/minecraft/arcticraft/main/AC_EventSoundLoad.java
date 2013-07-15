package arcticraft.main;

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
			event.manager.soundPoolSounds.addSound("modname/sound.wav", MainClass.class.getResource("path/filename.wav"));
			
			If you want to have a randomized sound for a mob you do this:
			
			event.manager.soundPoolSounds.addSound("modname/mobsound1.wav", MainClass.class.getResource("path/filename.wav"));
			event.manager.soundPoolSounds.addSound("modname/mobsound2.wav", MainClass.class.getResource("path/filename.wav"));
			event.manager.soundPoolSounds.addSound("modname/mobsound3.wav", MainClass.class.getResource("path/filename.wav"));
			
			To play it in the entity file you just use modname.mobsound
			
			*/

			//Portal
			event.manager.soundPoolSounds.addSound("arcticraft/portal.wav");

			//Penguin
			event.manager.soundPoolSounds.addSound("arcticraft/penguinHurt.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/penguinDeath.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/penguinIdle.wav");

			//Pirate
			event.manager.soundPoolSounds.addSound("arcticraft/pirateHurt.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/pirateDeath.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/pirateIdle.wav");

			//Polar Bear
			event.manager.soundPoolSounds.addSound("arcticraft/bearIdle1.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/bearIdle2.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/bearAngry.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/bearDeath.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/bearHurt1.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/bearHurt2.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/bearHurt3.wav");

			//Boar
			event.manager.soundPoolSounds.addSound("arcticraft/boar_hurt.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/boar_living.wav");
			event.manager.soundPoolSounds.addSound("arcticraft/boar_death.wav");

			//Ingame Music
			event.manager.soundPoolMusic.addSound("arcticraft/Welcome To The Cold.wav");
			event.manager.soundPoolMusic.addSound("arcticraft/Frozen Feelings.wav");

		}

		catch (Exception e)
		{
			System.err.println("Failed to register Arcticraft sounds");
		}
	}
}
