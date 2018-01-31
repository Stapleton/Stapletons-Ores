package stapleton.stapletonsores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import stapleton.stapletonsores.StapletonsOres;

public class IronOre extends Block {
    public static final String RegName = "iron_ore";

    public IronOre() {
        super(Material.ROCK);
        setUnlocalizedName(StapletonsOres.MODID + "." + RegName);
        setRegistryName(RegName);
    }
}
