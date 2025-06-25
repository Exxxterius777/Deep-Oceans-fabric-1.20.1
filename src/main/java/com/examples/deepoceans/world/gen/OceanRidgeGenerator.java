package com.example.deepoceans.world.gen;

import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.math.random.Random;

public class OceanRidgeGenerator {
    public static final DoublePerlinNoiseSampler.NoiseParameters RIDGE_NOISE = 
        new DoublePerlinNoiseSampler.NoiseParameters(2, 1.0, 0.3, 1.5);
    
    public static double sampleRidgeNoise(DoublePerlinNoiseSampler sampler, int x, int z) {
        return sampler.sample(x * 0.1, 0, z * 0.1);
    }
}