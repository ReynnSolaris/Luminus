package com.akryx.luminus.setup;

import com.akryx.luminus.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * Created by Aaron on 7/1/2019.
 */
public class ModSetup {

    public static ItemGroup itemGroup = new ItemGroup("luminus") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.DEBUGBLOCK);
        }
    };

    public static void init() {

    }
}
