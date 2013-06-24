package arcticraft.data_store;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraftforge.common.Property;
import net.minecraftforge.common.Property.Type;

public class TemperatureDataStorage
{

	public static TemperatureDataStorage instance;
	private HashMap <String, Integer> playerTemp = new HashMap <String, Integer>();
	public TemperatureDataStorage()
	{
		instance = this;
	}
	public int getTemperature(String playername)
	{
		if (!playerTemp.containsKey(playername)) playerTemp.put(playername, 50);
		return playerTemp.get(playername);
	}
	public void setTemperature(String playername, int temp)
	{
		playerTemp.put(playername, temp);
	}
	public void load(Map <String, Property> entries)
	{
		for (Entry <String, Property> entry : entries.entrySet())
		{
			setTemperature(entry.getKey(), entry.getValue().getInt());
			System.out.println("Load: "+entry.getKey()+" "+entry.getValue().getInt()+"C");
		}

	}
	public Map <? extends String, ? extends Property> save()
	{
		HashMap <String, Property> result = new HashMap <String, Property>();
		for (Entry <String, Integer> entry : playerTemp.entrySet())
		{
			System.out.println("Save: "+entry.getKey()+" "+entry.getValue()+"C");
			result.put(entry.getKey(), new Property(entry.getKey(), entry.getValue().toString(), Type.INTEGER));
		}
		return result;
	}
	public void clear()
	{
		playerTemp.clear();
	}
}
