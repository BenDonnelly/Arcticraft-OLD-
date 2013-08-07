package arcticraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class AC_EntityRegistry
{

	static int startEntityId = 327;
	static int zombieBackGround = 0x00AFAF;
	static int zombieSpots = 0x5FA88E;
	static int whiteColor = 0xffffff;
	static int blackColor = 0x000000;
	static int grayColor = 0x424242;
	static int lightGrayColor = 0xEEEEEE;
	static int lightBlueColor = 0xAFF5FF;
	static int blueishIcyColor = 0x3EA6CF;
	static int kindaBlueColor = 0x337BC7;
	static int purpleBlueishColor = 0x6419F0;
	static int redishPinkishColour = 0xEB0E58;
	static int greenishColour = 0x99FF66;
	static int yellowishColour = 0xFFFF33;
	static int brownishColour = 0x63560A;

	public static void registerEntityEggs()
	{	
		EntityRegistry.registerGlobalEntityID(AC_EntityWhale.class, "Whale", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Whale.name", "Whale");
		registerEntityEgg(AC_EntityWhale.class, blueishIcyColor, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityFrostGhost.class, "FrostGhost", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.FrostGhost.name", "Frost Ghost");
		registerEntityEgg(AC_EntityFrostGhost.class, lightGrayColor, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityMage.class, "Mage", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Mage.name", "The Ancient Ice Mage");
		registerEntityEgg(AC_EntityMage.class, kindaBlueColor, purpleBlueishColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityFrostZombie.class, "FrostZombie", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.FrostZombie.name", "Frost Zombie");
		registerEntityEgg(AC_EntityFrostZombie.class, zombieBackGround, zombieSpots);

		EntityRegistry.registerGlobalEntityID(AC_EntityIceCreeper.class, "IceCreeper", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.IceCreeper.name", "Ice Creeper");
		registerEntityEgg(AC_EntityIceCreeper.class, blueishIcyColor, lightBlueColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityPirate.class, "Pirate", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Pirate.name", "Pirate");
		registerEntityEgg(AC_EntityPirate.class, redishPinkishColour, blackColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityCaptain.class, "Captain", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Captain.name", "Pirate Captain");
		registerEntityEgg(AC_EntityCaptain.class, redishPinkishColour, blackColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityPenguin.class, "Penguin", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Penguin.name", "Penguin");
		registerEntityEgg(AC_EntityPenguin.class, blackColor, whiteColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityPolarBear.class, "PolarBear", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.PolarBear.name", "Polar Bear");
		registerEntityEgg(AC_EntityPolarBear.class, whiteColor, whiteColor);

		EntityRegistry.registerModEntity(AC_EntityIceShard.class, "IceShard", 0, MainRegistry.instance, 128, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.articcraft.IceShard.name", "Ice Shard");

		EntityRegistry.registerGlobalEntityID(AC_EntityBoar.class, "Boar", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Boar.name", "Boar");
		registerEntityEgg(AC_EntityBoar.class, lightGrayColor, lightGrayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityHusky.class, "Husky", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Husky.name", "Husky");
		registerEntityEgg(AC_EntityHusky.class, lightGrayColor, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityCheifEskimo.class, "EskimoCheif", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.EskimoCheif.name", "Eskimo Chief");
		registerEntityEgg(AC_EntityCheifEskimo.class, purpleBlueishColor, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityHunterEskimo.class, "EskimoHunter", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.EskimoHunter.name", "Eskimo Hunter");
		registerEntityEgg(AC_EntityHunterEskimo.class, redishPinkishColour, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityEskimo.class, "Eskimo", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Eskimo.name", "Eskimo");
		registerEntityEgg(AC_EntityEskimo.class, blueishIcyColor, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityTraderEskimo.class, "EskimoTrader", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.EskimoTrader.name", "Eskimo Trader");
		registerEntityEgg(AC_EntityTraderEskimo.class, greenishColour, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityChefEskimo.class, "EskimoChef", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.EskimoChef.name", "Eskimo Chef");
		registerEntityEgg(AC_EntityChefEskimo.class, yellowishColour, grayColor);

		EntityRegistry.registerGlobalEntityID(AC_EntityYeti.class, "Yeti", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Yeti.name", "Yeti");
		registerEntityEgg(AC_EntityYeti.class, 0x99FFFF, 0xDEDEDE);

		EntityRegistry.registerGlobalEntityID(AC_EntityDragon.class, "Dragon", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Dragon.name", "Dragon");
		registerEntityEgg(AC_EntityDragon.class, 0x99FFFF, 0xDEDEDE);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityKnight.class, "Knight", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Knight.name", "Knight");
		registerEntityEgg(AC_EntityKnight.class, brownishColour, 0xffffff);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityMiner.class, "Miner", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Miner.name", "Miner");
		registerEntityEgg(AC_EntityMiner.class, brownishColour, 0xffffff);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityArcher.class, "Archer", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Archer.name", "Archer");
		registerEntityEgg(AC_EntityArcher.class, brownishColour, 0xffffff);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityCaveman.class, "Caveman", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Caveman.name",  "Caveman");
		registerEntityEgg(AC_EntityCaveman.class, lightBlueColor, blueishIcyColor);
		
		EntityRegistry.registerModEntity(AC_EntityBomb.class, "Bomb", 1, MainRegistry.instance, 64, 10, true);
		EntityRegistry.registerModEntity(AC_EntitySled.class, "Sled", 2, MainRegistry.instance, 64, 10, true);
		EntityRegistry.registerModEntity(AC_EntityNPickThing.class, "NPickThing", 3, MainRegistry.instance, 64, 10, true);
		EntityRegistry.registerModEntity(AC_EntityPirateHook.class, "PirateHook", 4, MainRegistry.instance, 64, 10, true);
	}

	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));

	}

	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while(EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}

}
