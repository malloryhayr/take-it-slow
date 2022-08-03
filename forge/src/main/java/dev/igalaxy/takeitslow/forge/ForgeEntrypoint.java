package dev.igalaxy.takeitslow.forge;

import dev.igalaxy.takeitslow.TakeItSlow;
import dev.igalaxy.takeitslow.config.TakeItSlowConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod("takeitslow")
public class ForgeEntrypoint {
    public ForgeEntrypoint() {
        TakeItSlow.onInitialize();

        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory(
                    (mc, screen) -> AutoConfig.getConfigScreen(TakeItSlowConfig.class, screen).get()
                )
        );
    }
}
