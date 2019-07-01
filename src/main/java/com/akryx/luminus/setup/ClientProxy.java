package com.akryx.luminus.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

/**
 * Created by Aaron on 7/1/2019.
 */
public class ClientProxy implements IProxy {

    @Override
    public void init() {

    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
