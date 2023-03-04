package pw.stapleton.stapletonsores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;
import pw.stapleton.stapletonsores.StapletonsOres;

import java.util.HashMap;
import java.util.Map;

public class Ores {
    private static final Ores INSTANCE = new Ores();
    public static HashMap<String, Block> OreList = new HashMap<>();
    public static String[] arrayOfOres = "O_Almandine,O_Aluminum,O_Apatite,O_Banded_Iron,N_Banded_Iron,O_Barite,O_Bastnasite,O_Bauxite,O_Bentonite,E_Bentonite,O_Beryllium,E_Beryllium,O_Brown_Limonite,N_Brown_Limonite,O_Calcite,E_Calcite,O_Cassiterite,E_Cassiterite,O_Certus_Quartz,O_Chalcopyrite,N_Chalcopyrite,O_Cinnabar,N_Cinnabar,O_Coal,O_Cobaltite,N_Cobaltite,E_Cobaltite,O_Cooperite,E_Cooperite,O_Copper,N_Copper,O_Diamond,O_Emerald,O_Galena,O_Garnierite,N_Garnierite,E_Garnierite,O_Glauconite,O_Gold,O_Graphite,O_Green_Sapphire,O_Grossular,E_Grossular,O_Ilmenite,O_Iridium,E_Iridium,O_Iron,N_Iron,O_Lapis,E_Lapis,O_Lazurite,E_Lazurite,O_Lead,O_Lepidolite,O_Lignite,O_Lithium,E_Lithium,O_Magnesite,E_Magnesite,O_Magnetite,N_Magnetite,O_Malachite,N_Malachite,O_Molybdenite,E_Molybdenite,O_Molybdenum,E_Molybdenum,O_Monazite,O_Neodymium,N_Nether_Quartz,O_Nickel,N_Nickel,E_Nickel,O_Olivine,E_Olivine,O_Palladium,E_Palladium,O_Pentlandite,O_Phosphate,O_Phosphorus,O_Pitchblende,O_Platinum,E_Platinum,O_Powellite,E_Powellite,N_Pyrite,O_Pyrolusite,E_Pyrolusite,O_Pyrope,O_Quartzite,O_Redstone,N_Redstone,O_Rock_Salt,O_Ruby,N_Ruby,O_Salt,O_Sapphire,O_Scheelite,E_Scheelite,O_Silver,O_Soapstone,O_Sodalite,E_Sodalite,O_Spessartine,E_Spessartine,N_Sphalerite,O_Spodumene,O_Stibnite,N_Stibnite,N_Sulfur,O_Talc,O_Tantalite,E_Tantalite,O_Tetrahedrite,N_Tetrahedrite,O_Thorium,E_Thorium,O_Tin,E_Tin,O_Tungsten,E_Tungsten,O_Uraninite,O_Uranium,O_Vanadium_Magnetite,N_Vanadium_Magnetite,O_Wulfenite,E_Wulfenite,O_Yellow_Limonite,N_Yellow_Limonite".split(",");

    private Ores() {}

    public static void preInit() {
        StapletonsOres.logger.log(Level.INFO, "Total: " + arrayOfOres.length);

        for (String item : arrayOfOres) {
            BlockCore blockOre = new BlockCore(item.toLowerCase() + "_ore", Material.ROCK);
            OreList.put(item.toLowerCase() + "_ore", blockOre);
        }

        MinecraftForge.EVENT_BUS.register(INSTANCE);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        for (Map.Entry<String, Block> entry : OreList.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(name, "inventory"));
        }
    }
}
