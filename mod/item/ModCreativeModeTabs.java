package net.lol15.dungeonsreborn.mod.item;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.lol15.dungeonsreborn.mod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    // Deferred register for creative tabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DungeonsReborn.MODID);

    // Dungeons Reborn tab
    public static final Supplier<CreativeModeTab> DUNGEONS_REBORN_TAB = CREATIVE_MODE_TAB.register(
            "dungeons_reborn_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ANCIENT_GOLD.value()))
                    .title(Component.translatable("creativetab.dungeonsreborn.dungeons_reborn"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Items
                        output.accept(ModItems.DOMINANCE_SHARD.value());
                        output.accept(ModItems.TEST.value());

                        // Blocks
                        // Blocks
                        output.accept(ModBlocks.LICHENED_STONE.value());
                        output.accept(ModBlocks.LICHENED_RUINED_COBBLESTONE.value());
                        output.accept(ModBlocks.POLISHED_RUINED_STONE.value());
                        output.accept(ModBlocks.RUINED_STONE_BRICKS.value());
                        output.accept(ModBlocks.LICHEN_COATED_STONE.value());
                        output.accept(ModBlocks.LIGHTLY_LICHENED_STONE.value());
                        output.accept(ModBlocks.LICHENED_HEATHER.value());
                        output.accept(ModBlocks.RUINED_COBBLESTONE.value());
                        output.accept(ModBlocks.FANCY_CARPET.value());
                        output.accept(ModBlocks.WINDSWEPT_HEATHER.value());
                        output.accept(ModBlocks.WINDSWEPT_GRASS.value());
                        output.accept(ModBlocks.ILLAGER_BRICK.value());
                        output.accept(ModBlocks.ANCIENT_GOLD.value());
                        output.accept(ModBlocks.POLISHED_LIMESTONE.value());
                        output.accept(ModBlocks.GILDED_POLISHED_LIMESTONE.value());
                        output.accept(ModBlocks.GILDED_POLISHED_LIMESTONE2.value());
                    })
                    .build()
    );

    // Register the creative tab deferred register
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
