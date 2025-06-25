package com.example.deepoceans.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class OceanSurfaceRules {
    private static final MaterialRules.MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule SAND = makeStateRule(Blocks.SAND);
    private static final MaterialRules.MaterialRule GRAVEL = makeStateRule(Blocks.GRAVEL);
    
    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrBelowWater = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition isDeep = MaterialRules.y(-32, 0);
        MaterialRules.MaterialCondition isTrench = MaterialRules.y(-108, -32);
        
        return MaterialRules.sequence(
            MaterialRules.condition(MaterialRules.y(-128, -127), BEDROCK),
            
            MaterialRules.condition(isTrench,
                MaterialRules.sequence(
                    MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, DEEPSLATE),
                    MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE)
                )
            ),
            
            MaterialRules.condition(isDeep,
                MaterialRules.sequence(
                    MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, STONE),
                    MaterialRules.condition(MaterialRules.not(MaterialRules.STONE_DEPTH_FLOOR), GRAVEL)
                )
            ),
            
            MaterialRules.condition(isAtOrBelowWater,
                MaterialRules.sequence(
                    MaterialRules.condition(MaterialRules.y(0, 64), SAND),
                    MaterialRules.condition(MaterialRules.y(64, 128), GRAVEL)
                )
            )
        );
    }
    
    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
    
    public static void register() {
    }
}