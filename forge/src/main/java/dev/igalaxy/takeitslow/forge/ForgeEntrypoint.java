package dev.igalaxy.takeitslow.forge;

import dev.igalaxy.takeitslow.TakeItSlow;
import dev.igalaxy.takeitslow.config.TakeItSlowConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod("takeitslow")
public class ForgeEntrypoint {
    public ForgeEntrypoint() {
        TakeItSlow.onInitialize();

        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () ->
                new ConfigGuiHandler.ConfigGuiFactory(
                    (mc, screen) -> AutoConfig.getConfigScreen(TakeItSlowConfig.class, screen).get()
                )
        );
    }
}
