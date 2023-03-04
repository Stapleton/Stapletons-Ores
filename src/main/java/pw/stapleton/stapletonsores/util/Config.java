package pw.stapleton.stapletonsores.util;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import pw.stapleton.stapletonsores.StapletonsOres;
import pw.stapleton.stapletonsores.block.Ores;

public class Config {
    public static final String GENERAL = "General";
    private static final String ORES = "Ore Settings";

    private static int configVersion = 1;
    public static boolean isEnabled = true;
    private static int oreHardness = 3;
    private static int oreResistance = 5;

    public static void generalConfig(Configuration general) {
        try {
            general.load();
            initGeneralConfig(general);
        } catch (Exception exception) {
            StapletonsOres.logger.log(Level.ERROR, "Unable to load config file!", exception);
        } finally {
            if (general.hasChanged()) {
                general.save();
            }
        }
    }

    public static void oreConfig(Configuration config, String oreName, String originalOreName) {
        try {
            config.load();
            initOreConfig(config, oreName, originalOreName);
        } catch (Exception exception) {
            StapletonsOres.logger.log(Level.ERROR, "Unable to load config file!", exception);
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration general) {
        general.addCustomCategoryComment(GENERAL, "Main Configuration");
        configVersion = general.getInt("Config Version", GENERAL, configVersion, configVersion, configVersion, "DO NOT CHANGE THIS!");
        isEnabled = general.getBoolean("Enabled?", GENERAL, isEnabled, "Enables/Disables the mod completely.");
    }

    private static void initOreConfig(Configuration ore, String oreName, String originalOreName) {
        ore.addCustomCategoryComment(GENERAL, "This currently is just proof of concept. Doesn't affect anything yet...");
        configVersion = ore.getInt("Config Version", GENERAL, configVersion, configVersion, configVersion, "DO NOT CHANGE THIS!");
        isEnabled = ore.getBoolean("Enabled?", GENERAL, isEnabled, "Enables/Disables " + oreName);

        ore.addCustomCategoryComment(ORES, "Material config for " + oreName);
        oreResistance = ore.getInt("Block Resistance", ORES, oreResistance, 0, 10, "'Actual Resistance' = 'Block Resistance' * 3\r\n\r\n");
        oreHardness = ore.getInt("Ore Hardness", ORES, oreHardness, -1, 10, "if ('Actual Resistance' < 'Ore Hardness' * 5)\r\n{ 'Actual Resistance' = 'Ore Hardness' * 5 }\r\nelse { 'Actual Hardness' = 'Ore Hardness' }\r\n\r\nNote: -1 Hardness is Unbreakable.\r\n");

        Ores.OreList.get(originalOreName.toLowerCase() + "_ore").setResistance(oreResistance).setHardness(oreHardness);
    }
}
