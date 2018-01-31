package stapleton.stapletonsores.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import stapleton.stapletonsores.StapletonsOres;

public class Items {
    @GameRegistry.ObjectHolder(StapletonsOres.MODID + ":" + TestItem.RegName)
    public static TestItem testItem;
}
