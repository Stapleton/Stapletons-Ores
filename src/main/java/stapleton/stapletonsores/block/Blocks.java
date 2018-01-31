<<<<<<< HEAD
package stapleton.stapletonsores.block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import stapleton.stapletonsores.StapletonsOres;

public class Blocks {
    @GameRegistry.ObjectHolder(StapletonsOres.MODID + ":" + IronOre.RegName)
=======
package stapleton.stapletonsores;

import net.minecraftforge.fml.common.registry.GameRegistry;
import stapleton.stapletonsores.block.IronOre;

public class Blocks {
    @GameRegistry.ObjectHolder(StapletonsOres.MODID + IronOre.RegName)
>>>>>>> master
    public static IronOre ironOre;
}
