package arcticraft.world;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet43Experience;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class AC_Teleporter
{

	public static int DIMENSION_ID = MainRegistry.dimension, TENT_ID = Block.cloth.blockID, FENCE_ID = Block.fence.blockID, CHEST_ID = Block.chest.blockID, GROUND_ID = AC_Block.frostGrass.blockID, DIRT_ID = AC_Block.frostDirt.blockID;

	public static void teleportEntity(Entity entity, int dimensionId)
	{
		if(entity.worldObj.isRemote)
			return;

		World world = MinecraftServer.getServer().worldServerForDimension(dimensionId);
		int x = 0, y = 0, z = 0;

		if(dimensionId == 0)
		{
			EntityPlayer player = (EntityPlayer) entity;

			ChunkCoordinates spawnPoint = player.getBedLocation(0);
			ChunkCoordinates worldSpawn = world.getSpawnPoint();

			if(player.getBedLocation(0) != null)
			{
				x = spawnPoint.posX;
				z = spawnPoint.posZ;
				y = spawnPoint.posY;
			}

			else
			{
				x = worldSpawn.posX;
				z = worldSpawn.posZ;
				y = worldSpawn.posY;
			}
		}

		else
		{
			x = 0;
			z = 0;
			y = 25;
		}

		Entity newEntity = teleportEntity(world, entity, x, y, z);

		generateStructureIfRequired(newEntity);
	}

	private static Entity teleportEntity(World world, Entity entity, double x, double y, double z)
	{
		if(entity.riddenByEntity != null)
			entity.riddenByEntity.mountEntity(null);

		if(entity.ridingEntity != null)
			entity.mountEntity(null);

		entity.worldObj.updateEntityWithOptionalForce(entity, false);
		EntityPlayerMP player;

		if(entity instanceof EntityPlayerMP)
		{
			player = (EntityPlayerMP) entity;

			handlePlayerRespawn(entity, player, world);
		}

		removeEntityFromWorld(entity.worldObj, entity);

		entity.setLocationAndAngles(x + 0.5, y, z + 0.5, entity.rotationYaw, entity.rotationPitch);
		((WorldServer) world).theChunkProviderServer.loadChunk((int) x >> 4, (int) z >> 4);

		while(! world.isAirBlock((int) x, (int) y, (int) z))
			y += 1;
		y += 1;

		entity = recreateEntity(entity, world);

		if(entity == null)
			return null;

		if(entity instanceof EntityPlayerMP)
		{
			player = (EntityPlayerMP) entity;

			player.mcServer.getConfigurationManager().func_72375_a(player, (WorldServer) world);
			player.playerNetServerHandler.setPlayerLocation(x + 0.5, y, z + 0.5, entity.rotationYaw, entity.rotationPitch);
		}

		world.updateEntityWithOptionalForce(entity, false);

		if(entity instanceof EntityPlayerMP)
		{
			player = (EntityPlayerMP) entity;

			syncPlayer(player, world);
		}

		entity.setLocationAndAngles(x + 0.5, y, z + 0.5, entity.rotationYaw, entity.rotationPitch);
		return entity;
	}

	private static EntityPlayerMP handlePlayerRespawn(Entity entity, EntityPlayerMP player, World world)
	{
		player.closeScreen();
		player.dimension = world.provider.dimensionId;
		player.playerNetServerHandler.sendPacketToPlayer(new Packet9Respawn(player.dimension, (byte) player.worldObj.difficultySetting, world.getWorldInfo().getTerrainType(), world.getHeight(), player.theItemInWorldManager.getGameType()));

		((WorldServer) entity.worldObj).getPlayerManager().removePlayer(player);

		return player;
	}

	private static Entity recreateEntity(Entity entity, World world)
	{
		if(! (entity instanceof EntityPlayer))
		{
			NBTTagCompound nbt = new NBTTagCompound();
			entity.isDead = false;
			entity.riddenByEntity = null;
			entity.addEntityID(nbt);
			entity.isDead = true;

			entity = EntityList.createEntityFromNBT(nbt, world);

			if(entity == null)
				return null;
		}

		world.spawnEntityInWorld(entity);
		entity.setWorld(world);

		return entity;
	}

	@SuppressWarnings("rawtypes")
	private static void syncPlayer(EntityPlayerMP player, World world)
	{
		player.theItemInWorldManager.setWorld((WorldServer) world);
		player.mcServer.getConfigurationManager().updateTimeAndWeatherForPlayer(player, (WorldServer) world);
		player.mcServer.getConfigurationManager().syncPlayerInventory(player);

		Iterator iter = player.getActivePotionEffects().iterator();

		while(iter.hasNext())
		{
			PotionEffect effect = (PotionEffect) iter.next();
			player.playerNetServerHandler.sendPacketToPlayer(new Packet41EntityEffect(player.entityId, effect));
		}

		player.playerNetServerHandler.sendPacketToPlayer(new Packet43Experience(player.experience, player.experienceTotal, player.experienceLevel));
		GameRegistry.onPlayerChangedDimension(player);
	}

	private static void removeEntityFromWorld(World world, Entity entity)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;

			player.closeScreen();
			world.playerEntities.remove(player);
			world.updateAllPlayersSleepingFlag();

			int chunkX = entity.chunkCoordX, chunkZ = entity.chunkCoordZ;

			if(entity.addedToChunk && world.getChunkProvider().chunkExists(chunkX, chunkZ))
			{
				world.getChunkFromChunkCoords(chunkX, chunkZ).removeEntity(entity);
				world.getChunkFromChunkCoords(chunkX, chunkZ).isModified = true;
			}

			world.loadedEntityList.remove(entity);
			//			world.releaseEntitySkin(entity);
		}

		entity.isDead = false;
	}

	private static void generateStructureIfRequired(Entity entity)
	{
		int x = MathHelper.floor_double(entity.posX), y = MathHelper.floor_double(entity.posY), z = MathHelper.floor_double(entity.posZ);

		//if (entity.worldObj.getBlockId(x, y + 2, z) == TENT_ID || entity.worldObj.getBlockId(x + 2, y, z) == FENCE_ID || entity.worldObj.getBlockId(x + 2, y - 1, z) == FENCE_ID || entity.worldObj.getBlockId(x + 2, y + 1, z) == FENCE_ID || entity.worldObj.getBlockId(x - 2, y - 1, z) == CHEST_ID)
		//      return;

		if(entity.worldObj.getBlockId(x, y - 2, z) == Block.bedrock.blockID)
			return;

		generateStructure(entity.worldObj, MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ));
	}

	private static void generateStructure(World world, int x, int y, int z)
	{
		if(world.provider.dimensionId != DIMENSION_ID)
			return;

		y += 2;
		x -= 3;
		z -= 3;

		String[][] data = new String[][] { {"XXXXXXXXX" , "XXXXXXXXX" , "XXXXXXXXX" , "TTTTTTXXX" , "XXXXXXXXX" , "XXXXXXXXX" , "XXXXXXXXX"} , {"XXXXXXXXX" , "XXXXXXXXX" , "TTTTTTXXX" , "TXXXXFXXX" , "TTTTTTXXX" , "XXXXXXXXX" , "XXXXXXXXX"} ,
				{"XXXXXXXXX" , "TTTTTTXXX" , "TXXXXXXXX" , "TXXXXFXXX" , "TXXXXXXXX" , "TTTTTTXXX" , "XXXXXXXXX"} , {"TTTTTTXXX" , "TXXXXXXXX" , "TXXXXXXXX" , "TCXXXFXXX" , "TXXXXXXXX" , "TXXXXXXXX" , "TTTTTTXXX"} ,
				{"GGGGGGGGG" , "GGGGGGGGG" , "GGGGGGGGG" , "GGGBGGGGG" , "GGGGGGGGG" , "GGGGGGGGG" , "GGGGGGGGG"} , {"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"} ,
				{"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"} , {"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"} ,
				{"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"}};

		for(String[] row : data)
		{
			for(String col : row)
			{
				for(Character c : col.toCharArray())
				{
					int id = 0;
					int damage = 0;

					switch(c)
					{
					case 'X':
						id = 0;
						damage = 0;
						break;
					case 'T':
						id = TENT_ID;
						damage = 13;
						break;
					case 'F':
						id = FENCE_ID;
						damage = 0;
						break;
					case 'G':
						id = GROUND_ID;
						damage = 0;
						break;
					case 'R':
						id = DIRT_ID;
						damage = 0;
						break;
					case 'C':
						id = CHEST_ID;
						damage = 0;
						break;
					case 'B':
						id = Block.bedrock.blockID;
						damage = 0;
						break;
					}

					if(world.getBlockId(x, y, z) != id)
					{
						if(id == DIRT_ID && world.getBlockId(x, y, z) != 0 && world.getBlockId(x, y, z) != Block.snow.blockID /* && world.getBlockId(x, y, z) != MainRegistry.thickSnow.blockID */)
						{
							x++;
							continue;
						}

						world.setBlock(x, y, z, id, damage, 3);

						if(id == CHEST_ID)
						{
							TileEntityChest chest = (TileEntityChest) world.getBlockTileEntity(x, y, z);
							chest.setInventorySlotContents(1, new ItemStack(Item.boat, 1));
							chest.setInventorySlotContents(0, new ItemStack(AC_Item.GlacierFruit, 1));
						}
					}

					x++;
				}

				x -= 9;
				z++;
			}

			y -= 1;
			z -= 7;
		}
	}
}
