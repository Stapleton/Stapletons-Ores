package stapleton.stapletonsores.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stapleton.stapletonsores.block.Ores;

public class SOTab extends CreativeTabs {

    private String label;
    private int tab;

    public SOTab(int id, String modid, String label, int tab) {
        super(id, modid);
        this.label = label;
        this.tab = tab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() {
        return new ItemStack(Ores.OreList.get("o_almandine_ore"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
        return getIconItemStack();
    }

    @Override
    public String getTabLabel() {
        return this.label;
    }
}
