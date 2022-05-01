package dev.igalaxy.takeitslow.fabric;

import dev.igalaxy.takeitslow.TakeItSlow;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        TakeItSlow.onInitialize();
    }
}
