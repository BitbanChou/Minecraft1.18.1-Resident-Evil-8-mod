package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class EntityTheHag extends EvokerEntity {

    public EntityTheHag(EntityType<? extends EvokerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MonsterEntity.createMonsterAttributes().
                add(Attributes.MOVEMENT_SPEED, 0.23D).
                add(Attributes.FOLLOW_RANGE, 40.0D).
                add(Attributes.MAX_HEALTH, 30.0D);
    }


    protected void performSpellCasting() {
        ServerWorld serverworld = (ServerWorld)EntityTheHag.this.level;

        for(int i = 0; i < 3; ++i) {
            BlockPos blockpos = EntityTheHag.this.blockPosition().offset(-2 + EntityTheHag.this.random.nextInt(5), 1, -2 + EntityTheHag.this.random.nextInt(5));
            EntitySamca vexentity = EntityInit.SAMCA.get().create(EntityTheHag.this.level);
            vexentity.moveTo(blockpos, 0.0F, 0.0F);
            vexentity.finalizeSpawn(serverworld, EntityTheHag.this.level.getCurrentDifficultyAt(blockpos), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
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
            this.level.addParticle(ParticleTypes.ENCHANT, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            if(f<0.25f){
                this.addEffect(new EffectInstance(Effects.INVISIBILITY, 60,0,false,false));
            }
            else if(f>0.55 && f<0.6){
                this.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 30,5,false,false));
            }
        }

        if(this.getHealth() > 1.0F && this.getHealth()<=10.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.2F);
            this.level.addParticle(ParticleTypes.HEART, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
        }
        super.customServerAiStep();
    }


}
