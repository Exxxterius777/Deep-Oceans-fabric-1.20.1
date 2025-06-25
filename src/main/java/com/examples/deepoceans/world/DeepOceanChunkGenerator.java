package com.example.deepoceans.world;

import com.example.deepoceans.world.gen.DepthNoiseGenerator;
import com.example.deepoceans.world.gen.OceanRidgeGenerator;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.noise.NoiseConfig;

public class DeepOceanChunkGenerator {
    private final DoublePerlinNoiseSampler depthNoise;
    private final DoublePerlinNoiseSampler ridgeNoise;
    private final DoublePerlinNoiseSampler trenchNoise;
    
    public DeepOceanChunkGenerator(NoiseConfig noiseConfig, long seed) {
        this.depthNoise = noiseConfig.getOrCreateSampler(DepthNoiseGenerator.DEPTH_NOISE);
        this.ridgeNoise = noiseConfig.getOrCreateSampler(OceanRidgeGenerator.RIDGE_NOISE);
        this.trenchNoise = noiseConfig.getOrCreateSampler(DepthNoiseGenerator.TRENCH_NOISE);
    }
    
    public double getDepthNoise(int x, int z) {
        return this.depthNoise.sample(x * 0.25, 0, z * 0.25);
    }
    
    public double getRidgeNoise(int x, int z) {
        return this.ridgeNoise.sample(x * 0.1, 0, z * 0.1);
    }
    
    public double getTrenchNoise(int x, int z) {
        return this.trenchNoise.sample(x * 0.5, 0, z * 0.5);
    }
    
    public int getOceanDepth(int x, int z) {
        double depthNoise = getDepthNoise(x, z);
        double ridgeNoise = getRidgeNoise(x, z);
        double trenchNoise = getTrenchNoise(x, z);
        
        double baseDepth = -32 + depthNoise * 8;
        
        if (ridgeNoise > 0.7) {
            double ridgeHeight = (ridgeNoise - 0.7) * 50;
            baseDepth += ridgeHeight;
        }
        
        if (trenchNoise > 0.8) {
            double trenchDepth = (trenchNoise - 0.8) * 100;
            baseDepth -= trenchDepth;
        }
        
        return (int) MathHelper.clamp(baseDepth, -108, 0);
    }
    
    public static Codec<DeepOceanChunkGenerator> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            NoiseConfig.CODEC.fieldOf("noise").forGetter(generator -> null),
            Codec.LONG.fieldOf("seed").forGetter(generator -> 0L)
        ).apply(instance, DeepOceanChunkGenerator::new)
    );
}