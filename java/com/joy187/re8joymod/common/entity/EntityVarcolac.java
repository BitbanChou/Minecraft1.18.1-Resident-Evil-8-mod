package com.joy187.re8joymod.common.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityVarcolac extends RavagerEntity {
    public EntityVarcolac(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 30;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 100.0D).
                add(Attributes.MOVEMENT_SPEED, 0.24D).
                add(Attributes.ATTACK_DAMAGE, 8.5D);
    }

    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            if (this.isImmobile()) {
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
            } else {
                double d0 = this.getTarget() != null ? 0.26D : 0.28D;
                double d1 = this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(MathHelper.lerp(0.1D, d1, d0));
            }
        }
    }

    public boolean doHurtTarget(Entity entityIn) {
        boolean flag = super.doHurtTarget(entityIn);
        if (flag && this.getMainHandItem().isEmpty() && entityIn instanceof LivingEntity) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.HARM, 20 * (int)f));
        }
        return flag;
    }

}
