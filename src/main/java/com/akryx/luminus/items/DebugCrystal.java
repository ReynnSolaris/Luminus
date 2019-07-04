package com.akryx.luminus.items;

import com.akryx.luminus.Luminus;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 7/1/2019.
 */
public class DebugCrystal extends Item {

    private int currentTick = 0, tickPerSecond = 20, currentName = 0;
    private List<String> Names = new ArrayList<>();

    private String c1 = ""+TextFormatting.RED, c2 = ""+TextFormatting.WHITE, c3 = ""+TextFormatting.BLUE, b = ""+TextFormatting.BOLD, r = ""+TextFormatting.RESET;

    public DebugCrystal() {
        super(new Item.Properties()
        .maxStackSize(64)
        .group(Luminus.setup.itemGroup)
        .rarity(Rarity.EPIC));
        setRegistryName("debugcrystal");
        Names.add(b+c1+"te"+c2+"st"+c3+"ing"+r);
        Names.add(b+c3+"te"+c1+"st"+c2+"ing"+r);
        Names.add(b+c2+"te"+c3+"st"+c1+"ing"+r);
    }
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        try {
            final ITextComponent a = new StringTextComponent(Names.get(currentName));
            stack.setDisplayName(a);
            currentTick++;
            if (currentTick >= tickPerSecond/4) {
                currentTick = 0;
               // if (stack.getCount() != 64)
                    ///stack.grow(1);
                if (currentName + 1 > Names.size()) {
                    currentName = 0;
                } else {
                    currentName++;
                }
            }
        } catch (Exception e) { currentName = 0;}
    }
}
