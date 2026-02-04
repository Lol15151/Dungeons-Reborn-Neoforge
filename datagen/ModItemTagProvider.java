package net.lol15.dungeonsreborn.mod.datagen;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.lol15.dungeonsreborn.mod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_) {
        super(p_275343_, p_275729_, p_275322_);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
  //  public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
   //                           CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
//        super(pOutput, pLookupProvider, pBlockTags, DungeonsReborn.MODID, existingFileHelper);
//    }

 //   @Override
 //   protected void addTags(HolderLookup.Provider pProvider) {
 //       tag(ModTags.Items.TRANSFORMABLE_ITEMS)
 //               .add(ModItems.BLACK_OPAL.get())
 //               .add(Items.COAL)
//                .add(Items.DANDELION)
 //               .add(Items.COMPASS);

 //       tag(ItemTags.LOGS_THAT_BURN)
 //               .add(ModBlocks.EBONY_LOG.get().asItem())
 //               .add(ModBlocks.EBONY_WOOD.get().asItem())
//                .add(ModBlocks.STRIPPED_EBONY_LOG.get().asItem())
//                .add(ModBlocks.STRIPPED_EBONY_WOOD.get().asItem());

//        tag(ItemTags.PLANKS)
//                .add(ModBlocks.EBONY_PLANKS.get().asItem());
//    }
//}
