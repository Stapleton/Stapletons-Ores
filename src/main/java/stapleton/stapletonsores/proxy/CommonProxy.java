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
import stapleton.stapletonsores.util.Config;
import stapleton.stapletonsores.StapletonsOres;
import stapleton.stapletonsores.block.Ores;

import java.io.File;
import java.util.Map;
import java.util.Objects;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        String directoryPath = event.getModConfigurationDirectory().getPath();

        File modConfigDirectory = new File(directoryPath, "StapletonsOres");
        File overworld = new File(modConfigDirectory, "Overworld");
        File nether = new File(modConfigDirectory, "Nether");
        File end = new File(modConfigDirectory, "End");

        boolean ignoreThis = overworld.mkdir() && nether.mkdir() && end.mkdir();

        File oldConfigFile = new File(directoryPath, StapletonsOres.MOD_ID + ".cfg");

        if (oldConfigFile.exists()) {
            Configuration oldConfig = new Configuration(oldConfigFile);
            Config.isEnabled = oldConfig.getBoolean("Enabled?", Config.GENERAL, Config.isEnabled, "Enables/Disables the mod completely.");
            StapletonsOres.logger.info("Removed old config: " + oldConfigFile.delete() + " | Saved old config value: 'Enabled?' = " + Config.isEnabled);
        }

        Config.generalConfig(new Configuration(new File(modConfigDirectory.getPath(), StapletonsOres.MOD_ID + ".cfg")));

        for (String name : Ores.arrayOfOres) {
            switch (name.substring(0, 2)) {
                case "O_":
                    name = name.replace("O_", "");
                    Config.oreConfig(new Configuration(new File(overworld.getPath(), name + ".cfg")), name);
                    break;

                case "N_":
                    name = name.replace("N_", "");
                    Config.oreConfig(new Configuration(new File(nether.getPath(), name + ".cfg")), name);
                    break;

                case "E_":
                    name = name.replace("E_", "");
                    Config.oreConfig(new Configuration(new File(end.getPath(), name + ".cfg")), name);
                    break;
            }
        }
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
        //if (config.hasChanged()) config.save();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        StapletonsOres.logger.log(Level.INFO, "Registering Blocks...");
        for (Map.Entry<String, Block> entry : Ores.OreList.entrySet()) {
            //String name = entry.getKey();
            Block block = entry.getValue();
            event.getRegistry().register(block);
            //StapletonsOres.logger.log(Level.INFO,"Registered Block: " + block.getRegistryName());
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        StapletonsOres.logger.log(Level.INFO, "Registering Items...");
        // Item Blocks
        for (Map.Entry<String, Block> entry : Ores.OreList.entrySet()) {
            //String name = entry.getKey();
            Block block = entry.getValue();
            Item item = new ItemBlock(block).setRegistryName(Objects.requireNonNull(block.getRegistryName()));
            event.getRegistry().register(item);
            //StapletonsOres.logger.log(Level.INFO, "Registered Item Block: " + item.getRegistryName());
        }

        // Items
        //event.getRegistry().register(new TestItem());
    }
}
