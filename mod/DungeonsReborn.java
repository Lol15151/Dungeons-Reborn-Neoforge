package net.lol15.dungeonsreborn.mod;

import com.mojang.logging.LogUtils;
import net.lol15.dungeonsreborn.mod.animation.player.ModAnimations;
import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.lol15.dungeonsreborn.mod.blockentity.ModBlockEntities;
import net.lol15.dungeonsreborn.mod.client.ClientEvents;
import net.lol15.dungeonsreborn.mod.entity.ModEntityTypes;
import net.lol15.dungeonsreborn.mod.item.ModCreativeModeTabs;
import net.lol15.dungeonsreborn.mod.item.ModItems;
import net.lol15.dungeonsreborn.mod.launchpad.LaunchPadEvents;
import net.lol15.dungeonsreborn.mod.network.ModPackets;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(DungeonsReborn.MODID)
public class DungeonsReborn {

    public static final String MODID = "dungeonsreborn";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DungeonsReborn(IEventBus modEventBus, ModContainer modContainer) {

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);

        // 👇 REGISTER CLIENT ANIMATIONS HERE
        if (net.neoforged.fml.loading.FMLEnvironment.dist == Dist.CLIENT) {
            ModAnimations.register(modEventBus);
        }

        modEventBus.addListener(this::commonSetup);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        NeoForge.EVENT_BUS.register(this);
    }


    private void commonSetup(FMLCommonSetupEvent event) {
        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(net.minecraft.world.level.block.Blocks.DIRT));
        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server starting for DungeonsReborn...");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ClientEvents.register(); // NeoForge handles GeoItem automatically
            LaunchPadEvents.register();
        }
    }
}
