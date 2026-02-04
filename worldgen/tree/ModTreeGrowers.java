package net.lol15.dungeonsreborn.mod.worldgen.tree;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower EBONY = new TreeGrower(DungeonsReborn.MODID + ":ebony",
            Optional.empty(), Optional.of(ModConfiguredFeatures.EBONY_KEY), Optional.empty());
}