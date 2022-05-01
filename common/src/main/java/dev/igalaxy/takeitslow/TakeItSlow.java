package dev.igalaxy.takeitslow;

import dev.igalaxy.takeitslow.config.TakeItSlowConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TakeItSlow {
    private static final Logger logger = LoggerFactory.getLogger("Take It Slow");

    public static void onInitialize() {
        AutoConfig.register(TakeItSlowConfig.class, JanksonConfigSerializer::new);

        logger.info("Remember to take it slow!");
    }

    public static TakeItSlowConfig getConfig() {
        return AutoConfig.getConfigHolder(TakeItSlowConfig.class).getConfig();
    }
}
