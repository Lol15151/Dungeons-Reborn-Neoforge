package net.lol15.dungeonsreborn.mod.datagen;


import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DungeonsReborn.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ANCIENT_GOLD.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ANCIENT_GOLD.get());
//                .add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
//                .add(ModBlocks.BLACK_OPAL_END_ORE.get())
//                .add(ModBlocks.BLACK_OPAL_NETHER_ORE.get());

//        tag(BlockTags.FENCES).add(ModBlocks.BLACK_OPAL_FENCE.get());
//        tag(BlockTags.FENCE_GATES).add(ModBlocks.BLACK_OPAL_FENCE_GATE.get());
//        tag(BlockTags.WALLS).add(ModBlocks.BLACK_OPAL_WALL.get());

        this.tag(BlockTags.LOGS_THAT_BURN);
//                .add(ModBlocks.EBONY_LOG.get())
//                .add(ModBlocks.EBONY_WOOD.get())
//                .add(ModBlocks.STRIPPED_EBONY_LOG.get())
//                .add(ModBlocks.STRIPPED_EBONY_WOOD.get());
    }
}
