package net.lol15.dungeonsreborn.mod.item;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.lol15.dungeonsreborn.mod.item.ModCreativeModeTabs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(DungeonsReborn.MODID);

    // --- Regular items ---
    public static final DeferredItem<Item> DOMINANCE_SHARD =
            ITEMS.register("dominance_shard", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TESTSWORD =
            ITEMS.register("testsword", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REDBANNER =
            ITEMS.register("redbanner", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TEST =
            ITEMS.register("test", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GAUNTLET =
            ITEMS.register("gauntlet", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, FlailItem> FLAIL =
            ITEMS.register("flail",
                    () -> new FlailItem(new Item.Properties().stacksTo(1)));

    // --- BlockItems ---
    public static final DeferredItem<BlockItem> BRASIER =
            ITEMS.register("brasier", () ->
                    new BlockItem(ModBlocks.BRASIER.get(),
                            new Item.Properties().rarity(Rarity.UNCOMMON))
            );

    // --- Auto-generate BlockItems for other blocks ---
    static {
        ModBlocks.BLOCKS.getEntries().forEach(regObject -> {
            // Skip manual ones (PUT HERE)
            if (regObject.getId().getPath().equals("brasier")) return;

            ITEMS.register(regObject.getId().getPath(), () ->
                    new BlockItem(regObject.get(), new Item.Properties()));
        });
    }

    // --- Register to event bus ---
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
