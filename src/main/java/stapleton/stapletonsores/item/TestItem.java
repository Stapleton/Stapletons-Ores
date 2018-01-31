package stapleton.stapletonsores.item;

import net.minecraft.item.Item;
import stapleton.stapletonsores.StapletonsOres;

public class TestItem extends Item {
    public static final String RegName = "testitem";
    public TestItem() {
        setRegistryName(RegName);
        setUnlocalizedName(StapletonsOres.MODID + "." + RegName);
    }
}
