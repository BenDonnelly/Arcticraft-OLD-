package arcticraft.helpers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import arcticraft.entities.AC_EntityCaptain;
import arcticraft.entities.AC_EntityPirateHook;
import arcticraft.entities.AC_EskimoTrade;
import arcticraft.lib.Strings;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class AC_PacketHandler implements IPacketHandler
{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		if(packet.channel.equals(Strings.CHANNEL_ESKIMO_TRADE))
		{
			this.handleEskimoTrade(packet, player);
		}
		else if(packet.channel.equals(Strings.CHANNEL_ESKIMO_TALK))
		{
			this.handleEskimoTalk(packet, player);
		}
		else if(packet.channel.equals(Strings.CHANNEL_ROPE_POSITION)) {
			this.handleRopePosition(packet, player);
		}
	}

	private void handleRopePosition(Packet250CustomPayload packet, Player plyr) {
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		
		int captainId;
		int hookId;
		
		try {
			captainId = inputStream.readInt();
			hookId = inputStream.readInt();
		}
		catch(IOException e) {
			e.printStackTrace();
			return;
		}
		
		WorldClient world;
		
		if(plyr instanceof EntityPlayer)
		{
			world = (WorldClient) ((EntityPlayer) plyr).worldObj;
		}
		else
		{
			return;
		}
		
		((AC_EntityPirateHook) world.getEntityByID(hookId)).captain = (AC_EntityCaptain) world.getEntityByID(captainId);
	}

	private void handleEskimoTalk(Packet250CustomPayload packet, Player plyr)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		int itemID;
		int stackSize;
		int damageValue;

		try
		{
			itemID = inputStream.readInt();
			stackSize = inputStream.readInt();
			damageValue = inputStream.readInt();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}

		ItemStack stack = new ItemStack(itemID, stackSize, damageValue);
		EntityPlayer player;

		if(plyr instanceof EntityPlayer)
		{
			player = (EntityPlayer) plyr;
		}
		else
		{
			return;
		}

		player.inventory.addItemStackToInventory(stack);
	}

	private void handleEskimoTrade(Packet250CustomPayload packet, Player plyr)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		int itemID;
		int stackSize;
		int damageValue;
		int gems;

		try
		{
			itemID = inputStream.readInt();
			stackSize = inputStream.readInt();
			damageValue = inputStream.readInt();
			gems = inputStream.readInt();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}

		ItemStack stack = new ItemStack(itemID, stackSize, damageValue);
		EntityPlayer player;

		if(plyr instanceof EntityPlayer)
		{
			player = (EntityPlayer) plyr;
		}
		else
		{
			return;
		}

		if(AC_EskimoTrade.removeGemsFromInventory(player.inventory, gems))
		{
			player.addChatMessage("You have bought: " + stack.stackSize + "x " + stack.getDisplayName());
			player.inventory.addItemStackToInventory(stack);
		}
	}
}
