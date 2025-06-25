package com.example.deepoceans.world;

import com.example.deepoceans.DeepOceans;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OceanPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> ORE_GOLD_TRENCH = register(
        "ore_gold_trench",
        new PlacedFeature(
            RegistryEntry.of(new OreFeatureConfig(
                List.of(
                    OreFeatureConfig.createTarget(
                        OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                        net.minecraft.block.Blocks.GOLD_ORE.getDefaultState()
                    )
                ),
                16
            )),
            List.of(
                CountPlacementModifier.of(20),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(
                    net.minecraft.world.Heightmap.Type.OCEAN_FLOOR_WG,
                    net.minecraft.util.math.intprovider.UniformIntProvider.create(-108, -80)
                ),
                BiomePlacementModifier.of()
            )
        )
    );
    
   
    private static RegistryEntry<PlacedFeature> register(String id, PlacedFeature placedFeature) {
        return Registry.registerReference(
            Registries.PLACED_FEATURE,
            new Identifier(DeepOceans.MOD_ID, id),
            placedFeature
        );
    }
    
    public static void register() {
    }
}