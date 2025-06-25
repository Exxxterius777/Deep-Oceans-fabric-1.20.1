package com.example.deepoceans.world;

import com.example.deepoceans.DeepOceans;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class OceanBiomes {
    public static final RegistryKey<Biome> DEEP_OCEAN = RegistryKey.of(RegistryKeys.BIOME, DeepOceans.id("deep_ocean"));
    public static final RegistryKey<Biome> DEEP_OCEAN_TRENCH = RegistryKey.of(RegistryKeys.BIOME, DeepOceans.id("deep_ocean_trench"));
    
    public static void register() {
    }
}