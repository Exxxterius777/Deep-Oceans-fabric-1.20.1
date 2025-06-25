package com.example.deepoceans;

import com.example.deepoceans.world.OceanBiomes;
import com.example.deepoceans.world.OceanCarverConfigured;
import com.example.deepoceans.world.OceanPlacedFeatures;
import com.example.deepoceans.world.OceanSurfaceRules;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepOceans implements ModInitializer {
    public static final String MOD_ID = "deepoceans";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        OceanBiomes.register();
        OceanCarverConfigured.register();
        OceanPlacedFeatures.register();
        OceanSurfaceRules.register();
        
        LOGGER.info("Deep Oceans initialized!");
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}