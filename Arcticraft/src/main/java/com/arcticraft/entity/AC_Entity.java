package com.arcticraft.entity;

import net.minecraft.entity.EntityList;

import com.arcticraft.entity.item.EntityPirateHook;
import com.arcticraft.entity.mob.AC_EntityEskimoDefault;
import com.arcticraft.entity.mob.EntityBoar;
import com.arcticraft.entity.mob.EntityCaptain;
import com.arcticraft.entity.mob.EntityEskimoChef;
import com.arcticraft.entity.mob.EntityEskimoCheif;
import com.arcticraft.entity.mob.EntityEskimoHunter;
import com.arcticraft.entity.mob.EntityEskimoTrader;
import com.arcticraft.entity.mob.EntityFrostGhost;
import com.arcticraft.entity.mob.EntityFrostZombie;
import com.arcticraft.entity.mob.EntityHuskey;
import com.arcticraft.entity.mob.EntityIceCreeper;
import com.arcticraft.entity.mob.EntityMage;
import com.arcticraft.entity.mob.EntityPenguin;
import com.arcticraft.entity.mob.EntityPirate;
import com.arcticraft.entity.mob.EntityPolarBear;
import com.arcticraft.main.MainRegistry;

import cpw.mods.fml.common.registry.EntityRegistry;

public class AC_Entity {

	public static void mainRegistry() {
		registerEntity();
	}

	public static void registerEntity() {
		createEntity(EntityCannonball.class, "EntityCannonball", false, 0, 0);
		createEntity(EntityBomb.class, "EntityBomb", false, 0, 0);
		createEntity(EntityNPickaxe.class, "EntityNotchedPickaxe", false, 0, 0);
		createEntity(EntityIceShard.class, "EntityIceShard", false, 0, 0);
		createEntity(EntityPirateHook.class, "EntityPirateHook", false, 0, 0);

		createEntity(EntityFrostGhost.class, "EntityGhost", true, 0x7BE6E8, 0x000000);
		createEntity(EntityMage.class, "EntityMage", true, 0x7BE6E8, 0x000000);
		createEntity(EntityFrostZombie.class, "EntityFrostZombie", true, 0x7BE6E8, 0x000000);
		createEntity(EntityIceCreeper.class, "EntityIceCreeper", true, 0x7BE6E8, 0x000000);
		createEntity(EntityPirate.class, "EntityPirate", true, 0x7BE6E8, 0x000000);
		createEntity(EntityCaptain.class, "EntityCaptain", true, 0x7BE6E8, 0x000000);
		createEntity(EntityPenguin.class, "EntityPenguin", true, 0x7BE6E8, 0x000000);
		createEntity(EntityPolarBear.class, "EntityPolarBear", true, 0x7BE6E8, 0x000000);
		createEntity(EntityBoar.class, "EntityBoar", true, 0x7BE6E8, 0x000000);
		createEntity(EntityHuskey.class, "EntityHuskey", true, 0x7BE6E8, 0x000000);
		createEntity(EntityEskimoCheif.class, "EntityEskimoCheif", true, 0x7BE6E8, 0x000000);
		createEntity(EntityEskimoChef.class, "EntityEskimoChef", true, 0x7BE6E8, 0x000000);
		createEntity(EntityEskimoHunter.class, "EntityEskimoHunter", true, 0x7BE6E8, 0x000000);
		createEntity(EntityEskimoTrader.class, "EntityEskimoTrader", true, 0x7BE6E8, 0x000000);
		createEntity(AC_EntityEskimoDefault.class, "EntityEskimo", true, 0x7BE6E8, 0x000000);
		createEntity(EntityYeti.class, "EntityYeti", true, 0x7BE6E8, 0x000000);
		//createEntity(EntityKnight.class, "EntityKnight", true, 0x7BE6E8, 0x000000);
		//createEntity(EntityMiner.class, "EntityMiner", true, 0x7BE6E8, 0x000000);
		//createEntity(EntityArcher.class, "EntityArcher", true, 0x7BE6E8, 0x000000);
		//createEntity(EntityCaveman.class, "EntityCaveman", true, 0x7BE6E8, 0x000000);
	}

	public static void createEntity(Class entityClass, String entityName, boolean hasEgg, int solidColour, int spotColour) {
		int randomId = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, MainRegistry.instance, 64, 1, true);
		if (hasEgg) {
			createEgg(randomId, solidColour, spotColour);
		}
	}

	private static void createEgg(int randomId, int solidColour, int spotColour) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColour, spotColour));
	}
}
