package pw.stapleton.stapletonsores.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pw.stapleton.stapletonsores.StapletonsOres;
import pw.stapleton.stapletonsores.block.Ores;

import java.util.Map;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        initItemBlocks();
    }

    @SideOnly(Side.CLIENT)
    private static void initItemBlocks() {
        for (Map.Entry<String, Block> entry : Ores.OreList.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue();

            Item item = Item.getItemFromBlock(block);
            ModelResourceLocation model = new ModelResourceLocation(StapletonsOres.MOD_ID + ":" + name, "inventory");
            ModelBakery.registerItemVariants(item, model);
            ItemMeshDefinition meshDefinition = stack -> model;
            ModelLoader.setCustomMeshDefinition(item, meshDefinition);
        }
    }
}
