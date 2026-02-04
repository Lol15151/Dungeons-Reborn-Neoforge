package net.lol15.dungeonsreborn.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GauntletItem extends Item {
    public GauntletItem(Properties props) {
        super(props);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
