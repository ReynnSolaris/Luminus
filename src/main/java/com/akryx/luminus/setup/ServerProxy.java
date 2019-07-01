package com.akryx.luminus.setup;

import net.minecraft.world.World;

/**
 * Created by Aaron on 7/1/2019.
 */
public class ServerProxy implements IProxy {
    @Override
    public void init() {

    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Only run this on the client!");
    }
}
