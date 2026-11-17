package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityDoll2 extends EntityDoll1{
    public int explosionPower = 2;

    public EntityDoll2(EntityType<? extends EntityDoll1> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 22;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 45.0D).
                add(Attributes.MOVEMENT_SPEED, 0.43D).
                add(Attributes.ATTACK_DAMAGE, 5.5D);
    }


    protected void customServerAiStep() {

        if(this.getHealth() >= 0.5F && this.getHealth()<=7.0F)
        {
            this.level.explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, true, Explosion.Mode.NONE);
        }
        super.customServerAiStep();
    }



    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.ENTITY_DOLL_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_DOLL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_DOLL_HURT.get();
    }


}
