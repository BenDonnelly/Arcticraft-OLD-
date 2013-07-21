package arcticraft.dispenser;

import net.minecraft.block.BlockDispenser;
import arcticraft.items.AC_Item;

public class AC_DispenserBehaviours
{

	public static void registerDispenserBehaviours()
	{

		BlockDispenser.dispenseBehaviorRegistry.putObject(AC_Item.bomb, new AC_DispenserBehaviourBomb());
		BlockDispenser.dispenseBehaviorRegistry.putObject(AC_Item.IceShard, new AC_DispenserBehaviorIceshard());
		AC_DispenserBehaviorFilledBucket dispenserbehaviorfilledbucket = new AC_DispenserBehaviorFilledBucket();
		BlockDispenser.dispenseBehaviorRegistry.putObject(AC_Item.bucketIcyWater, dispenserbehaviorfilledbucket);
		BlockDispenser.dispenseBehaviorRegistry.putObject(AC_Item.bucketEmpty, new AC_DispenserBehaviorEmptyBucket());
	}
}
