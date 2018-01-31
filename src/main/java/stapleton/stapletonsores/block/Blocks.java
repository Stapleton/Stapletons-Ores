package stapleton.stapletonsores;

import net.minecraftforge.fml.common.registry.GameRegistry;
import stapleton.stapletonsores.block.IronOre;

public class Blocks {
    @GameRegistry.ObjectHolder(StapletonsOres.MODID + IronOre.RegName)
    public static IronOre ironOre;
}
