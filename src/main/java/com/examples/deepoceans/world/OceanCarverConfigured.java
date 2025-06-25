package com.example.deepoceans.world;

import com.example.deepoceans.DeepOceans;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.RavineCarverConfig;

public class OceanCarverConfigured {
    public static final ConfiguredCarver<?> DEEP_OCEAN_TRENCH = new ConfiguredCarver<>(
        net.minecraft.world.gen.carver.Carver.RAVINE,
        new RavineCarverConfig(0.02f, 0.1f, 0, 1, 0.1f, 1.0f, -0.7f)
    );
    
    public static void register() {
        Registry.register(Registries.CONFIGURED_CARVER, DeepOceans.id("deep_ocean_trench"), DEEP_OCEAN_TRENCH);
    }
}