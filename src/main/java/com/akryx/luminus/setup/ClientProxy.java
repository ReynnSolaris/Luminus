package com.akryx.luminus.setup;

import com.akryx.luminus.blocks.KappaGeneratorScreen;
import com.akryx.luminus.blocks.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

/**
 * Created by Aaron on 7/1/2019.
 */
public class ClientProxy implements IProxy {

    @Override
    public void init() {
        ScreenManager.registerFactory(ModBlocks.KAPPA_CONTAINER, KappaGeneratorScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
