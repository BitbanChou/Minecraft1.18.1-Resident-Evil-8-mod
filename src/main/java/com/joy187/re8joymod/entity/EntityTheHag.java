package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class EntityTheHag extends Evoker {

    public EntityTheHag(EntityType<? extends Evoker> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));

    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.23D).
                add(Attributes.FOLLOW_RANGE, 40.0D).
                add(Attributes.MAX_HEALTH, 30.0D);
    }


    protected void performSpellCasting() {
    	ServerLevel serverworld = (ServerLevel)EntityTheHag.this.level();

        for(int i = 0; i < 3; ++i) {
            BlockPos blockpos = EntityTheHag.this.blockPosition().offset(-2 + EntityTheHag.this.random.nextInt(5), 1, -2 + EntityTheHag.this.random.nextInt(5));
            EntitySamca vexentity = EntityInit.SAMCA.get().create(EntityTheHag.this.level());
            vexentity.moveTo(blockpos, 0.0F, 0.0F);
            vexentity.finalizeSpawn(serverworld, EntityTheHag.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
            vexentity.setOwner(EntityTheHag.this);
            vexentity.setBoundOrigin(blockpos);
            vexentity.setLimitedLife(20 * (30 + EntityTheHag.this.random.nextInt(90)));
            serverworld.addFreshEntityWithPassengers(vexentity);
        }
    }

    protected void customServerAiStep() {
        if(this.getHealth() > 10.0F && this.getHealth()<=25.0F)
        {
            Random ran = new Random();
            float f = ran.nextFloat();
            for(int i=0;i<5;i++)
                this.heal(1.5F*f);
            this.level().addParticle(ParticleTypes.ENCHANT, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            if(f<0.25f){
                this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60,0,false,false));
            }
            else if(f>0.55 && f<0.6){
                this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30,5,false,false));
            }
        }

        if(this.getHealth() > 1.0F && this.getHealth()<=10.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.2F);
            this.level().addParticle(ParticleTypes.HEART, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
        }

        BlockPos blockpos = this.blockPosition();
        FluidState fluidstate = this.level().getFluidState(blockpos);
        BlockState blockstate0 = this.level().getBlockState(blockpos.below());
        BlockState blockstate = this.level().getBlockState(blockpos.below().below().below().below());
        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 29.99F && this.getHealth()<=30.0F)
        {
            this.discard();
        }
        if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 29.99F && this.getHealth()<=30.0F) {
            this.discard();
        }

        super.customServerAiStep();
    }


}
