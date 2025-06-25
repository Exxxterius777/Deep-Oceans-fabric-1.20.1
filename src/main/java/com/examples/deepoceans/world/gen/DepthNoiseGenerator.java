package com.example.deepoceans.world.gen;

import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.math.random.Random;

public class DepthNoiseGenerator {
    public static final DoublePerlinNoiseSampler.NoiseParameters DEPTH_NOISE = 
        new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0, 1.0, 1.0, 1.0);
    public static final DoublePerlinNoiseSampler.NoiseParameters TRENCH_NOISE = 
        new DoublePerlinNoiseSampler.NoiseParameters(1, 1.0, 0.5, 2.0);
    
    public static double sampleDepthNoise(DoublePerlinNoiseSampler sampler, int x, int z) {
        return sampler.sample(x * 0.25, 0, z * 0.25);
    }
    
    public static double sampleTrenchNoise(DoublePerlinNoiseSampler sampler, int x, int z) {
        return sampler.sample(x * 0.5, 0, z * 0.5);
    }
}