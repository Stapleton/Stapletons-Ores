package pw.stapleton.stapletonsores.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import pw.stapleton.stapletonsores.StapletonsOres;

public class BlockCore extends Block {

    protected static String blockName;

    public BlockCore(String name, Material material) {
        super(material);
        setSoundType(SoundType.STONE);
        setCreativeTab(StapletonsOres.tabCommon);
        setUnlocalizedName(StapletonsOres.MOD_ID + "." + name);
        setRegistryName(name);
        blockName = name;
    }
}
