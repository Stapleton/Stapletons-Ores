package stapleton.stapletonsores.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import stapleton.stapletonsores.StapletonsOres;

public class BlockCore extends Block {

    protected static String blockName;

    public BlockCore(String name, Material material) {
        super(material);
        setHardness(3.0F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(StapletonsOres.tabCommon);
        setUnlocalizedName(StapletonsOres.MOD_ID + "." + name);
        setRegistryName(name);
        blockName = name;

    }
}
