package arcticraft.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

import arcticraft.lib.Strings;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.common.Configuration;

public class TemperatureHandlerServer 
{
	private static HashMap<String, Integer> tempStorage = new HashMap<String, Integer>();
	
	public static void setTemperature(String name, int value)
	{
		tempStorage.put(name, (Integer)value);
	}
	
	public static int getTemperature(String name)
	{
		if (!tempStorage.containsKey(name)) tempStorage.put(name, (Integer)50);
		return (int)tempStorage.get(name);
	}
	
	public static void clear()
	{
		tempStorage.clear();
	}
	
	public static void loadFromFile(Configuration file)
	{
		
	}
	
	public static void saveToFile(Configuration file)
	{
		
	}
	
	public static void updateTemp(EntityClientPlayerMP player, int value)
	{
		ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream(16);
		DataOutputStream outputStream = new DataOutputStream(byteArrayOutStream);
		
		try { outputStream.writeInt(value); }
		catch (Exception e) { }
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "UPDATETEMP";
		packet.data = byteArrayOutStream.toByteArray();
		packet.length = byteArrayOutStream.size();
		
		player.sendQueue.addToSendQueue(packet);
	}
}
