package net.lol15.dungeonsreborn.mod.entity;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.entity.custom.RoyalGuardEntity;
import net.lol15.dungeonsreborn.mod.entity.custom.Vindicator2Entity;
import net.lol15.dungeonsreborn.mod.entity.custom.FakePlayerEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE.key(), DungeonsReborn.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<RoyalGuardEntity>> ROYALGUARD =
            ENTITY_TYPES.register(
                    "royalguard",
                    () -> EntityType.Builder.of(RoyalGuardEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .build(DungeonsReborn.MODID + ":royalguard")
            );

    public static final DeferredHolder<EntityType<?>, EntityType<Vindicator2Entity>> VINDICATOR2 =
            ENTITY_TYPES.register(
                    "vindicator2",
                    () -> EntityType.Builder.of(Vindicator2Entity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .build(DungeonsReborn.MODID + ":vindicator2")
            );

    // 🔥 FAKE PLAYER ENTITY (render-only)
    public static final DeferredHolder<EntityType<?>, EntityType<FakePlayerEntity>> FAKE_PLAYER =
            ENTITY_TYPES.register(
                    "fake_player",
                    () -> EntityType.Builder.of(FakePlayerEntity::new, MobCategory.MISC)
                            .sized(0.6f, 1.8f)
                            .clientTrackingRange(64)
                            .build(DungeonsReborn.MODID + ":fake_player")
            );
}
