package stapleton.stapletonsores.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import stapleton.stapletonsores.Config;
import stapleton.stapletonsores.StapletonsOres;
import stapleton.stapletonsores.block.Ores;

import java.io.File;
import java.util.Map;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), StapletonsOres.MOD_ID + ".cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) config.save();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        StapletonsOres.LOG.log(Level.INFO, "Registering Blocks...");
        for (Map.Entry<String, Block> entry : Ores.OreList.entrySet()) {
            //String name = entry.getKey();
            Block block = entry.getValue();
            event.getRegistry().register(block);
            StapletonsOres.LOG.log(Level.INFO,"Registered Block: " + block.getRegistryName());
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        StapletonsOres.LOG.log(Level.INFO, "Registering Items...");
        // Item Blocks
        for (Map.Entry<String, Block> entry : Ores.OreList.entrySet()) {
            //String name = entry.getKey();
            Block block = entry.getValue();
            Item item = new ItemBlock(block).setRegistryName(block.getRegistryName());
            event.getRegistry().register(item);
            StapletonsOres.LOG.log(Level.INFO, "Registered Item Block: " + item.getRegistryName());
        }

        // Items
        //event.getRegistry().register(new TestItem());
    }
}
