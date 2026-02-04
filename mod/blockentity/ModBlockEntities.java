package net.lol15.dungeonsreborn.mod.blockentity;

import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.lol15.dungeonsreborn.mod.block.custom.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "dungeonsreborn");

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrasierBlockEntity>> BRASIER =
            BLOCK_ENTITIES.register("brasier",
                    () -> BlockEntityType.Builder.of(
                            BrasierBlockEntity::new,
                            ModBlocks.BRASIER.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GeomancerPillarBlockEntity>> GEOMANCER_PILLAR =
            BLOCK_ENTITIES.register("geomancer_pillar",
                    () -> BlockEntityType.Builder.of(
                            GeomancerPillarBlockEntity::new,
                            ModBlocks.GEOMANCER_PILLAR.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WindPlatformBlockEntity>> WIND_PLATFORM =
            BLOCK_ENTITIES.register("wind_platform",
                    () -> BlockEntityType.Builder.of(
                            WindPlatformBlockEntity::new,
                            ModBlocks.WIND_PLATFORM.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ArmorStatueBlockEntity>> ARMOR_STATUE =
            BLOCK_ENTITIES.register("armor_statue",
                    () -> BlockEntityType.Builder.of(
                            ArmorStatueBlockEntity::new,
                            ModBlocks.ARMOR_STATUE.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BracketTorchBlockEntity>> BRACKET_TORCH =
            BLOCK_ENTITIES.register("bracket_torch",
                    () -> BlockEntityType.Builder.of(
                            BracketTorchBlockEntity::new,
                            ModBlocks.BRACKET_TORCH.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FancyCarpetBlockEntity>> FANCY_CARPET =
            BLOCK_ENTITIES.register("fancy_carpet",
                    () -> BlockEntityType.Builder.of(
                            FancyCarpetBlockEntity::new,
                            ModBlocks.FANCY_CARPET.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SquallGolemBlockEntity>> SQUALL_GOLEM =
            BLOCK_ENTITIES.register("squall_golem",
                    () -> BlockEntityType.Builder.of(
                            SquallGolemBlockEntity::new,
                            ModBlocks.SQUALL_GOLEM.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IllagerBannerBlockEntity>> ILLAGER_BANNER =
            BLOCK_ENTITIES.register("illager_banner",
                    () -> BlockEntityType.Builder.of(
                            IllagerBannerBlockEntity::new,
                            ModBlocks.ILLAGER_BANNER.get()
                    ).build(null));
}
