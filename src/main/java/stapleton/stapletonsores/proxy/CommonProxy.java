package stapleton.stapletonsores.proxy;

<<<<<<< HEAD
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
import stapleton.stapletonsores.block.Blocks;
import stapleton.stapletonsores.Config;
import stapleton.stapletonsores.StapletonsOres;
import stapleton.stapletonsores.block.IronOre;
import stapleton.stapletonsores.item.TestItem;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), StapletonsOres.MODID + ".cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new IronOre());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Item Blocks
        event.getRegistry().register(new ItemBlock(Blocks.ironOre).setRegistryName(Blocks.ironOre.getRegistryName()));

        // Items
        event.getRegistry().register(new TestItem());
    }
=======
public class CommonProxy {
>>>>>>> master
}
