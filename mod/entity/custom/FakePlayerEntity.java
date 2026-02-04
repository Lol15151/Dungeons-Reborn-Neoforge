package net.lol15.dungeonsreborn.mod.entity.custom;

import java.util.Collections;
import java.util.UUID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class FakePlayerEntity extends LivingEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private UUID realPlayerUUID;

    public FakePlayerEntity(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
        this.noPhysics = true;
        this.setInvulnerable(true);
        this.setSilent(true);
    }

    public void setRealPlayerUUID(UUID uuid) { this.realPlayerUUID = uuid; }
    public UUID getRealPlayerUUID() { return this.realPlayerUUID; }

    @Override
    public Iterable<ItemStack> getArmorSlots() { return Collections.emptyList(); }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) { return ItemStack.EMPTY; }

    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {}

    @Override
    public HumanoidArm getMainArm() { return HumanoidArm.RIGHT; }

    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.1D);
    }

    private <T extends GeoEntity> PlayState predicate(AnimationState<T> state) {
        state.setAndContinue(RawAnimation.begin().thenLoop("player.idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }

    @Override
    public boolean isPushable() { return false; }

    @Override
    protected void pushEntities() {}

    @Override
    public boolean canBeCollidedWith() { return false; }
}
