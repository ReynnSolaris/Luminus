package com.akryx.luminus.setup;

import net.minecraft.world.World;

/**
 * Created by Aaron on 7/1/2019.
 */
public interface IProxy {

    void init();

    World getClientWorld();
}
