package net.lol15.dungeonsreborn.mod.launchpad;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;

public class LaunchPadTargets extends SavedData {

    // Map from pad position → target offset as BlockPos (integer offsets)
    private final Map<BlockPos, BlockPos> targetOffsets = new HashMap<>();

    public static LaunchPadTargets get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                new Factory<>(
                        LaunchPadTargets::new,
                        LaunchPadTargets::load
                ),
                "launchpad_targets"
        );
    }

    /** Save offset (integer BlockPos) */
    public void setTargetOffset(BlockPos pad, BlockPos offset) {
        targetOffsets.put(pad, offset);
        setDirty();
    }

    /** Compute actual target using current pad position + offset */
    public BlockPos getTarget(BlockPos pad) {
        BlockPos offset = targetOffsets.get(pad);
        if (offset == null) return null;
        return pad.offset(offset);
    }

    public static LaunchPadTargets load(CompoundTag tag, HolderLookup.Provider provider) {
        LaunchPadTargets data = new LaunchPadTargets();
        CompoundTag pads = tag.getCompound("pads");

        for (String key : pads.getAllKeys()) {
            CompoundTag t = pads.getCompound(key);
            BlockPos pad = new BlockPos(t.getInt("px"), t.getInt("py"), t.getInt("pz"));
            BlockPos offset = new BlockPos(t.getInt("ox"), t.getInt("oy"), t.getInt("oz"));
            data.targetOffsets.put(pad, offset);
        }
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider provider) {
        CompoundTag pads = new CompoundTag();

        for (Map.Entry<BlockPos, BlockPos> e : targetOffsets.entrySet()) {
            CompoundTag t = new CompoundTag();
            BlockPos pad = e.getKey();
            BlockPos offset = e.getValue();

            t.putInt("px", pad.getX());
            t.putInt("py", pad.getY());
            t.putInt("pz", pad.getZ());

            t.putInt("ox", offset.getX());
            t.putInt("oy", offset.getY());
            t.putInt("oz", offset.getZ());

            pads.put(pad.toShortString(), t);
        }

        tag.put("pads", pads);
        return tag;
    }
}
