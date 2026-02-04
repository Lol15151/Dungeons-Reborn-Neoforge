package net.lol15.dungeonsreborn.mod.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Vindicator2Entity extends Vindicator implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    // Synced boolean for attack/run logic
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Vindicator2Entity.class, EntityDataSerializers.BOOLEAN);

    public Vindicator2Entity(EntityType<? extends Vindicator> entityType, Level level) {
        super(entityType, level);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE)); // ✅ Give default axe
    }

    // Define tracked data (NeoForge 1.21.1 style)
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACKING, false);
    }

    // Basic vindicator-like stats
    public static AttributeSupplier.Builder createAttributes() {
        return Vindicator.createAttributes()
                .add(Attributes.MAX_HEALTH, 24.0)
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, 5.0)
                .add(Attributes.FOLLOW_RANGE, 32.0);
    }

    // Sync attacking flag each tick
    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide()) {
            boolean attacking = this.getTarget() != null && this.getTarget().isAlive();
            this.entityData.set(ATTACKING, attacking);
        }
    }

    @Override
    public void swing(InteractionHand hand, boolean updateSelf) {
        super.swing(hand, updateSelf);
        if (!this.level().isClientSide()) {
            this.entityData.set(ATTACKING, true);
        }
    }


    // ✅ GeckoLib animation logic
    private <T extends GeoEntity> PlayState predicate(AnimationState<T> state) {
        // ✅ Attack animation when swinging
        if (this.swinging) {
            state.setAndContinue(RawAnimation.begin().thenPlay("vindicator.attack"));
            return PlayState.CONTINUE;
        }

        // ✅ Run animation when locked on / aggressive
        if (this.getTarget() != null && this.isAggressive()) {
            state.setAndContinue(RawAnimation.begin().thenLoop("vindicator.run"));
            return PlayState.CONTINUE;
        }

        // ✅ Walk animation when moving but not aggressive
        if (state.isMoving()) {
            state.setAndContinue(RawAnimation.begin().thenLoop("vindicator.walk"));
            return PlayState.CONTINUE;
        }

        // ✅ Idle animation
        state.setAndContinue(RawAnimation.begin().thenLoop("vindicator.idle"));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
