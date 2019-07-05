package com.akryx.luminus;

import com.akryx.luminus.blocks.DebugBlock;
import com.akryx.luminus.blocks.KappaGenerator;
import com.akryx.luminus.blocks.KappaGeneratorTile;
import com.akryx.luminus.blocks.ModBlocks;
import com.akryx.luminus.items.DebugCrystal;
import com.akryx.luminus.items.ModItems;
import com.akryx.luminus.setup.ClientProxy;
import com.akryx.luminus.setup.IProxy;
import com.akryx.luminus.setup.ModSetup;
import com.akryx.luminus.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

/**
 * Created by Aaron on 6/30/2019.
 */
@Mod("luminus")
public class Luminus {
    private static final Logger LOGGER = LogManager.getLogger();

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    public Luminus() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.init();
        setup.init();
        LOGGER.info("Hello from preinit.");
    }
    private void doClientStuff(final FMLClientSetupEvent event) {

    }
    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("luminus", "hello world", () -> {LOGGER.info("Hello from MDK"); return "Hello World";});
    }

    private void processIMC(final InterModProcessEvent event ) {
        LOGGER.info("Got IMC {}", event.getIMCStream().
        map(m->m.getMessageSupplier().get())
        .collect(Collectors.toList()));
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new DebugBlock());
            event.getRegistry().register(new KappaGenerator());
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties().group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.DEBUGBLOCK, properties).setRegistryName("debugblock"));
            event.getRegistry().register(new BlockItem(ModBlocks.KAPPAGENERATOR, properties).setRegistryName("kappagenerator"));
            event.getRegistry().register(new DebugCrystal());
        }
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(() -> new KappaGeneratorTile(), ModBlocks.KAPPAGENERATOR).build(null).setRegistryName("kappagenerator"));
        }
    }
}
