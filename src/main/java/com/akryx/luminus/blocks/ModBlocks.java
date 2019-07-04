package com.akryx.luminus.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

/**
 * Created by Aaron on 7/1/2019.
 */
public class ModBlocks {
    @ObjectHolder("luminus:debugblock")
    public static DebugBlock DEBUGBLOCK;

    @ObjectHolder("luminus:kappagenerator")
    public static KappaGenerator KAPPAGENERATOR;

    @ObjectHolder("luminus:kappagenerator")
    public static TileEntityType<KappaGeneratorTile> KAPPA_TILE;
}
