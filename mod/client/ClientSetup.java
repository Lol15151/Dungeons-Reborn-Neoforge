package net.lol15.dungeonsreborn.mod.client;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.lol15.dungeonsreborn.mod.blockentity.ModBlockEntities;
import net.lol15.dungeonsreborn.mod.client.renderer.*;
import net.lol15.dungeonsreborn.mod.entity.ModEntityTypes;
import net.lol15.dungeonsreborn.mod.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import software.bernie.geckolib.renderer.GeoItemRenderer;

@EventBusSubscriber(
        modid = DungeonsReborn.MODID,
        bus = EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.RUNIC_GLASS_PANE.get(),
                RenderType.translucent()
        );
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

        // ===== BLOCK ENTITY RENDERERS =====
        event.registerBlockEntityRenderer(
                ModBlockEntities.BRASIER.get(),
                BrasierBlockEntityRenderer::new
        );

        event.registerBlockEntityRenderer(
                ModBlockEntities.GEOMANCER_PILLAR.get(),
                GeomancerPillarBlockEntityRenderer::new
        );

        event.registerBlockEntityRenderer(
                ModBlockEntities.WIND_PLATFORM.get(),
                WindPlatformBlockEntityRenderer::new
        );

        event.registerBlockEntityRenderer(
                ModBlockEntities.ARMOR_STATUE.get(),
                ArmorStatueBlockEntityRenderer::new
        );

        BlockEntityRenderers.register(
                ModBlockEntities.FANCY_CARPET.get(),
                FancyCarpetRenderer::new
        );

        BlockEntityRenderers.register(
                ModBlockEntities.BRACKET_TORCH.get(),
                BracketTorchBlockEntityRenderer::new
        );

        BlockEntityRenderers.register(
                ModBlockEntities.SQUALL_GOLEM.get(),
                SquallGolemBlockEntityRenderer::new
        );

        BlockEntityRenderers.register(
                ModBlockEntities.ILLAGER_BANNER.get(),
                IllagerBannerBlockEntityRenderer::new
        );
    }
}


