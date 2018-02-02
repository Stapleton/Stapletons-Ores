package stapleton.stapletonsores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;
import stapleton.stapletonsores.StapletonsOres;

import java.util.HashMap;
import java.util.Map;

public class Ores {
    private static final Ores INSTANCE = new Ores();
    public static HashMap<String, Block> OreList = new HashMap<>();
    private static String stringOfOres = "Almandine,Aluminum,Apatite,Banded_Iron,Barite,Bastnasite,Bauxite,Bentonite,Beryllium,Brown_Limonite,Calcite,Cassiterite,Certus_Quartz,Chalcopyrite,Cinnabar,Coal,Cobaltite,Cooperite,Copper,Diamond,Emerald,Enriched_Naquadah,Galena,Garnierite,Glauconite,Gold,Graphite,Green_Sapphire,Grossular,Ilmenite,Iridium,Iron,Lapis,Lazurite,Lead,Lepidolite,Lignite,Lithium,Magnesite,Magnetite,Malachite,Molybdenite,Molybdenum,Monazite,Naquadah,Neodymium,Nether_Quartz,Nickel,Oilsands,Olivine,Palladium,Pentlandite,Phosphate,Phosphorus,Pitchblende,Platinum,Powellite,Pyrite,Pyrochlore,Pyrolusite,Pyrope,Quartzite,Redstone,Rock_Salt,Ruby,Salt,Sapphire,Scheelite,Silver,Soapstone,Sodalite,Spessartine,Sphalerite,Spodumene,Stibnite,Sulfur,Talc,Tantalite,Tetrahedrite,Thorium,Tin,Tungstate,Uraninite,Uranium,Vanadium_Magnetite,Wulfenite,Yellow_Limonite";
    private static String[] arrayOfOres = stringOfOres.split(",");

    private Ores() {}

    public static void preInit() {
        StapletonsOres.logger.log(Level.INFO, "Total: " + arrayOfOres.length);

        for (String item : arrayOfOres) {
            OreList.put(item.toLowerCase() + "_ore", new BlockCore(item.toLowerCase() + "_ore", Material.ROCK));
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
