package stapleton.stapletonsores.block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import stapleton.stapletonsores.StapletonsOres;

public class Blocks {
    @GameRegistry.ObjectHolder(StapletonsOres.MODID + ":" + IronOre.RegName)
    public static IronOre ironOre;
}
