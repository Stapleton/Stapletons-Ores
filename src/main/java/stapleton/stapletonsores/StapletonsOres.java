package stapleton.stapletonsores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import stapleton.stapletonsores.block.Ores;
import stapleton.stapletonsores.proxy.CommonProxy;

@Mod(useMetadata = true, modid = StapletonsOres.MOD_ID)
public class StapletonsOres {

    public static final String MOD_ID = "stapletonsores";

    @SidedProxy(clientSide = "stapleton.stapletonsores.proxy.ClientProxy", serverSide = "stapleton.stapletonsores.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static StapletonsOres instance;

    public static Logger logger;

    public static CreativeTabs Common;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        Ores.preInit();

        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
