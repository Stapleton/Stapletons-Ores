package stapleton.stapletonsores;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import stapleton.stapletonsores.proxy.CommonProxy;

public class Config {
    private static final String GENERAL = "General";

    public static int configVersion = Reference.CONFIG_VERSION;
    public static boolean isEnabled = true;

    public static void readConfig() {
        Configuration config = CommonProxy.config;
        try {
            config.load();
            initGeneralConfig(config);
        } catch (Exception exception) {
        StapletonsOres.logger.log(Level.ERROR, "Unable to load config file!", exception);
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration config) {
        config.addCustomCategoryComment(GENERAL, "General Configuration");
        configVersion = config.getInt("Config Version", GENERAL, configVersion, Reference.CONFIG_VERSION, Reference.CONFIG_VERSION, "DO NOT CHANGE THIS!");
        isEnabled = config.getBoolean("Enabled?", GENERAL, isEnabled, "Enables/Disables the mod completely.");
    }
}
