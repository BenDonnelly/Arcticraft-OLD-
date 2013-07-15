package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import arcticraft.items.AC_Item;
import arcticraft.main.MainRegistry;

public class AC_BlockOres extends Block {

	public AC_BlockOres(int par1) {
		super(par1, Material.rock);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		if (this == AC_Block.tekkiteOre) {
			return AC_Item.tekkiteGem.itemID;
		}
		
		if (this == AC_Block.escariaOre) {
			return AC_Item.escariaGem.itemID;
		}
		
		if (this == AC_Block.frigusOre) {
			return AC_Item.frigus.itemID;
		}
		
		if (this == AC_Block.glacianOre) {
			return AC_Block.glacianOre.blockID;
		}
		
		if (this == AC_Block.rigentemOre) {
			return AC_Block.rigentemOre.blockID;
		}
		
		
		else return this.blockID;
	}
}
