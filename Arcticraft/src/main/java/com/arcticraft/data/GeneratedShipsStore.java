package com.arcticraft.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.config.Property.Type;
import cpw.mods.fml.common.FMLLog;

public class GeneratedShipsStore
{

	/*
	 * Config file structure:
	 * ships:
	 * ships:
	 * - 'x;z'avea 2sec, typing on other monitor k continue
	 */
	private static final String separator = "A";

	public static class CoordinatesXZ
	{

		public int x, z;

		public CoordinatesXZ(int x2, int z2)
		{
			x = x2;
			z = z2;
		}

		public int distance(CoordinatesXZ other)
		{
			int xVect = Math.abs(other.x - x);
			int yVect = Math.abs(other.z - z);
			// simple pythagoras' sentence thing
			double dist = Math.sqrt(Math.pow(xVect, 2) + Math.pow(yVect, 2));
			return (int) Math.round(dist);
		}
	}

	public static GeneratedShipsStore instance;
	private List<CoordinatesXZ> generatedShips; // this list will store X,Z pairs of coordinates where ship is generated

	public GeneratedShipsStore()
	{
		instance = this;
		generatedShips = new ArrayList<CoordinatesXZ>();
	}

	public Map<String, Property> save()
	{
		// serialize the generatedShips list to a String array like this: {"5;5","894;6546",...}
		String[] value = new String[generatedShips.size()];
		int i = 0;
		for(CoordinatesXZ ship : generatedShips)
		{
			value[i] = ship.x + separator + ship.z;
			FMLLog.info("Saved ship at %d,%d", ship.x, ship.z);
			++i;
		}
		Map<String, Property> result = new HashMap<String, Property>();
		result.put("ships", new Property("ships", value, Type.STRING));
		return result;
	}

	public void load(Map<String, Property> entries)
	{
		generatedShips.clear();
		if(entries == null || entries.get("ships") == null)
			return;
		// get the ships list as String[]. The array should look like this: {"5;5","894;6546",...}
		String[] stringList = entries.get("ships").getStringList();
		for(String string : stringList)
		{
			int x, z;
			// retrieve coordinates from the string
			x = Integer.parseInt(string.split(separator)[0]);
			z = Integer.parseInt(string.split(separator)[1]);
			// create the object from coordinates
			generatedShips.add(new CoordinatesXZ(x, z));
			FMLLog.info("Loaded ship at %d,%d", x, z);
		}
	}

	public boolean isAnyShipInRadius(int x, int z, int minShipDistance)
	{
		CoordinatesXZ shipPosition = new CoordinatesXZ(x, z);
		// this goes over all generated ships and finds any ship that is in distance less than minimal distance
		for(CoordinatesXZ pos : generatedShips)
		{
			if(pos.distance(shipPosition) < minShipDistance)
			{
				// if it finds any ship, returns true
				return true;
			}
		}
		// no ship = false
		return false;
	}

	public void addShip(CoordinatesXZ coordinatesXZ)
	{
		// this method will just add the generated ship to the list, so other ships won't generate nearby
		generatedShips.add(coordinatesXZ);
	}

}
