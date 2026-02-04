package net.lol15.dungeonsreborn.mod.block;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.custom.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(DungeonsReborn.MODID);

    // =============== STANDARD BLOCKS ===============
    public static final DeferredBlock<Block> ORB_TEST_BLOCK = BLOCKS.register("orb_test_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> WINDSWEPT_GRASS = BLOCKS.register("windswept_grass",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> ILLAGER_BRICK = BLOCKS.register("illager_brick",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE_BRICKS)));

    public static final DeferredBlock<Block> POLISHED_LIMESTONE = BLOCKS.register("polished_limestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> WINDSWEPT_HEATHER =
            BLOCKS.register("windswept_heather",
                    () -> new WindsweptHeatherBlock(BlockBehaviour.Properties.of()
                            .strength(0.2f)
                            .sound(SoundType.MOSS)));

    public static final DeferredBlock<Block> ANCIENT_GOLD = BLOCKS.register("ancient_gold",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.HEAVY_CORE)));

    public static final DeferredBlock<Block> FANCY_CARPET =
            BLOCKS.register("fancy_carpet",
                    () -> new CarpetBlock(BlockBehaviour.Properties.of()
                            .strength(0.1F)
                            .sound(SoundType.WOOL)));

    public static final DeferredBlock<StairBlock> FANCY_CARPET_STAIRS =
            BLOCKS.register("fancy_carpet_stairs",
                    () -> new StairBlock(
                            Blocks.RED_CARPET.defaultBlockState(),
                            BlockBehaviour.Properties.of()
                                    .strength(0.1F)
                                    .sound(SoundType.WOOL)
                    ));

    public static final DeferredBlock<Block> LICHENED_STONE = BLOCKS.register("lichened_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> LICHENED_RUINED_COBBLESTONE = BLOCKS.register("lichened_ruined_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> POLISHED_RUINED_STONE = BLOCKS.register("polished_ruined_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> RUINED_STONE_BRICKS = BLOCKS.register("ruined_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> LICHEN_COATED_STONE = BLOCKS.register("lichen_coated_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> LIGHTLY_LICHENED_STONE = BLOCKS.register("lightly_lichened_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> LICHENED_HEATHER = BLOCKS.register("lichened_heather",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> RUINED_COBBLESTONE = BLOCKS.register("ruined_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    // =============== CUSTOM BLOCKS ===============

    public static final DeferredBlock<GildedPolishedLimestoneBlock> GILDED_POLISHED_LIMESTONE =
            BLOCKS.register("gilded_polished_limestone",
                    () -> new GildedPolishedLimestoneBlock(BlockBehaviour.Properties.of().strength(1.5f)));

    public static final DeferredBlock<GildedPolishedLimestone2Block> GILDED_POLISHED_LIMESTONE2 =
            BLOCKS.register("gilded_polished_limestone2",
                    () -> new GildedPolishedLimestone2Block(BlockBehaviour.Properties.of().strength(1.5f)));

    public static final DeferredHolder<Block, Block> BRASIER =
            BLOCKS.register("brasier",
                    () -> new BrasierBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredHolder<Block, Block> GEOMANCER_PILLAR =
            BLOCKS.register("geomancer_pillar",
                    () -> new GeomancerPillarBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredHolder<Block, Block> WIND_PLATFORM =
            BLOCKS.register("wind_platform",
                    () -> new WindPlatformBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredHolder<Block, Block> ARMOR_STATUE =
            BLOCKS.register("armor_statue",
                    () -> new ArmorStatueBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredHolder<Block, Block> SQUALL_GOLEM =
            BLOCKS.register("squall_golem",
                    () -> new SquallGolemBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredHolder<Block, Block> BRACKET_TORCH =
            BLOCKS.register("bracket_torch",
                    () -> new BracketTorchBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredHolder<Block, Block> ILLAGER_BANNER =
            BLOCKS.register("illager_banner",
                    () -> new IllagerBannerBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> RUNIC_GLASS_PANE =
            BLOCKS.register("runic_glass_pane", () -> new RunicGlassPaneBlock());

    public static final DeferredBlock<Block> PLANTER =
            BLOCKS.register("planter",
                    () -> new PlanterBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> LIMESTONE =
            BLOCKS.register("limestone",
                    () -> new LimestoneBlock(BlockBehaviour.Properties.of().strength(2.0f)));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
