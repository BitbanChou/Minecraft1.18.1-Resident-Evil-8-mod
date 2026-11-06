package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.CvgVariant;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityCvg extends EntityLycan{

    public EntityCvg(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 80.0D).
                add(Attributes.MOVEMENT_SPEED, 0.26D).
                add(Attributes.ATTACK_DAMAGE, 8D);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        if(ran.nextFloat()<0.4f) return SoundInit.CHAINSAW.get();
        return SoundEvents.RAVAGER_AMBIENT;
    }

    public CvgVariant getVariant1() {
        return CvgVariant.byId(this.getTypeVariant() & 255);
    }
}
