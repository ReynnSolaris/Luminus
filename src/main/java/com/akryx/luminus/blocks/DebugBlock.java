package com.akryx.luminus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by Aaron on 7/1/2019.
 */
public class DebugBlock extends Block {

    public DebugBlock() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
                .lightValue(6)
        );
        setRegistryName("debugblock");
    }
}
