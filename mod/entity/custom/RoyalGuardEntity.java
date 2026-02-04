package net.lol15.dungeonsreborn.mod.entity.custom;

import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

public class RoyalGuardEntity extends Vindicator implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    // Animation tracking
    private boolean attackQueued = false;
    private boolean isAttackingAnimation = false;
    private int attackAnimationTicks = 0;
    private static final int ATTACK_ANIMATION_LENGTH = 20; // adjust to match animation length in ticks
    private boolean shieldBroken = false; // switched after first player hit

    public RoyalGuardEntity(EntityType<? extends RoyalGuardEntity> type, Level level) {
        super(type, level);
        // No held item
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!shieldBroken && source.getEntity() instanceof Player) {
            shieldBroken = true; // first time hit by player
        }
        return super.hurt(source, amount);
    }

    @Override
    public void swing(InteractionHand hand, boolean updateSelf) {
        super.swing(hand, updateSelf);
        attackQueued = true; // queue the attack animation
    }

    private PlayState predicate(AnimationState state) {
        String suffix = shieldBroken ? "-noshield" : "";

        // Attack animation has priority
        if (attackQueued || isAttackingAnimation) {
            if (!isAttackingAnimation) {
                isAttackingAnimation = true;
                attackAnimationTicks = ATTACK_ANIMATION_LENGTH;
                state.setAndContinue(RawAnimation.begin().thenPlay("guard.attack" + suffix));
                attackQueued = false;
            }

            if (attackAnimationTicks > 0) {
                attackAnimationTicks--;
            } else {
                isAttackingAnimation = false;
            }
            return PlayState.CONTINUE;
        }

        // Walk detection using velocity
        Vec3 vel = this.getDeltaMovement();
        if (this.onGround() && (vel.x * vel.x + vel.z * vel.z) > 0.001) {
            state.setAndContinue(RawAnimation.begin().thenLoop("guard.walk" + suffix));
            return PlayState.CONTINUE;
        }

        // Idle fallback
        state.setAndContinue(RawAnimation.begin().thenLoop("guard.idle" + suffix));
        return PlayState.CONTINUE;
    }

    // Freeze movement during attack
    @Override
    public void travel(Vec3 travelVector) {
        if (isAttackingAnimation) {
            super.travel(Vec3.ZERO); // stop movement
        } else {
            super.travel(travelVector);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Vindicator.createAttributes()
                .add(Attributes.MAX_HEALTH, 32.0)
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, 9.5)
                .add(Attributes.FOLLOW_RANGE, 64.0);
    }
}
