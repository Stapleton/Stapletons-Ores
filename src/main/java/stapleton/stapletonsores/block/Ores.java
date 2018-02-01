package stapleton.stapletonsores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Level;
import stapleton.stapletonsores.StapletonsOres;
import stapleton.stapletonsores.core.BlockCore;

import java.util.HashMap;

public class Ores {
    public static final Ores INSTANCE = new Ores();
    public static HashMap<String, Block> OreList = new HashMap<>();

    private Ores() {}

    public static void preInit() {
        String stringOfOres = "Almandine,Aluminum,Apatite,Banded_Iron,Barite,Bastnasite,Bauxite,Bentonite,Beryllium,Brown_Limonite,Calcite,Cassiterite,Certus_Quartz,Chalcopyrite,Cinnabar,Coal,Cobaltite,Cooperite,Copper,Diamond,Emerald,Enriched_Naquadah,Galena,Garnierite,Glauconite,Gold,Graphite,Green_Sapphire,Grossular,Ilmenite,Iridium,Iron,Lapis,Lazurite,Lead,Lepidolite,Lignite,Lithium,Magnesite,Magnetite,Malachite,Molybdenite,Molybdenum,Monazite,Naquadah,Neodymium,Nether_Quartz,Nickel,Oilsands,Olivine,Palladium,Pentlandite,Phosphate,Phosphorus,Pitchblende,Platinum,Powellite,Pyrite,Pyrochlore,Pyrolusite,Pyrope,Quartzite,Redstone,Rock_Salt,Ruby,Salt,Sapphire,Scheelite,Silver,Soapstone,Sodalite,Spessartine,Sphalerite,Spodumene,Stibnite,Sulfur,Talc,Tantalite,Tetrahedrite,Thorium,Tin,Tungstate,Uraninite,Uranium,Vanadium_Magnetite,Wulfenite,Yellow_Limonite";
        String[] arrayOfOres = stringOfOres.split(",");

        StapletonsOres.LOG.log(Level.INFO, "Total: " + arrayOfOres.length);

        for (String item : arrayOfOres) {
            OreList.put(item.toUpperCase() + "_ORE", new BlockCore(item.toLowerCase() + "_ore", Material.ROCK));
        }

        MinecraftForge.EVENT_BUS.register(INSTANCE);
    }
}
