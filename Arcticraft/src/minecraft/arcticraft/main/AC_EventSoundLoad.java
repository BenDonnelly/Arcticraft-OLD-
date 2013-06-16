package arcticraft.main;                                                             
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import arcticraft.main.*;;

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
			event.manager.soundPoolSounds.addSound("arcticraft/portal.wav", MainRegistry.class.getResource("/mods/AC/sounds/other/portal.wav"));
			
			//Penguin
			event.manager.soundPoolSounds.addSound("arcticraft/penguinHurt.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/penguinhurt.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/penguinDeath.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/penguindeath.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/penguinIdle.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/penguinidle.wav"));
			
			//Pirate
			event.manager.soundPoolSounds.addSound("arcticraft/pirateHurt.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/buccaneerhit.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/pirateDeath.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/buccaneerdie.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/pirateIdle.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/buccaneermoan.wav"));
			
			//Polar Bear
			event.manager.soundPoolSounds.addSound("arcticraft/bearIdle1.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/bear1.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/bearIdle2.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/bear2.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/bearAngry.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/bearAngry.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/bearDeath.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/bearDead.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/bearHurt1.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/bearHurt1.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/bearHurt2.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/bearHurt2.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/bearHurt3.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/bearHurt3.wav"));
			
			//Boar
			event.manager.soundPoolSounds.addSound("arcticraft/boar_hurt.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/boar_hurt.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/boar_living.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/boar_living.wav"));
			event.manager.soundPoolSounds.addSound("arcticraft/boar_death.wav", MainRegistry.class.getResource("/mods/AC/sounds/mobs/boar_death.wav"));
			
		} 

		catch (Exception e)
		{
			System.err.println("Failed to register Arcticraft sounds");
		}
	}
}