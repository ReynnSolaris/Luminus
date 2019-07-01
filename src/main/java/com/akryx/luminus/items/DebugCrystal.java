package com.akryx.luminus.items;

import com.akryx.luminus.Luminus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

/**
 * Created by Aaron on 7/1/2019.
 */
public class DebugCrystal extends Item {
    public DebugCrystal() {
        super(new Item.Properties()
        .maxStackSize(1)
        .group(Luminus.setup.itemGroup)
        .rarity(Rarity.EPIC));
        setRegistryName("debugcrystal");
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }


}
