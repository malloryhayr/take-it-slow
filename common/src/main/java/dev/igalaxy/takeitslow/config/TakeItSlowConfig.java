package dev.igalaxy.takeitslow.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "takeitslow")
public class TakeItSlowConfig implements ConfigData {
    @ConfigEntry.Category("Movement")
    public boolean allowSwimming = true;

    @ConfigEntry.Category("Movement")
    public boolean allowCreative = true;
}