package net.lol15.dungeonsreborn.mod.entity;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = DungeonsReborn.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityAttributes {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

        event.put(
                ModEntityTypes.VINDICATOR2.value(),
                Mob.createMobAttributes()
                        .add(Attributes.MAX_HEALTH, 24.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.35D)
                        .add(Attributes.ATTACK_DAMAGE, 6.0D)
                        .build()
        );

        event.put(
                ModEntityTypes.ROYALGUARD.value(),
                Mob.createMobAttributes()
                        .add(Attributes.MAX_HEALTH, 24.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.35D)
                        .add(Attributes.ATTACK_DAMAGE, 6.0D)
                        .build()
        );

        event.put(
                ModEntityTypes.FAKE_PLAYER.value(),
                Mob.createMobAttributes()
                        .add(Attributes.MAX_HEALTH, 24.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.35D)
                        .add(Attributes.ATTACK_DAMAGE, 6.0D)
                        .build()
        );
    }

}
