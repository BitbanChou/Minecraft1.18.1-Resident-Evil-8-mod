package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.ModEffects;
import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.util.math.vector.Vector3d;import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityMiranda4 extends RavagerEntity {
    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
    public int explosionPower = 2;

    public EntityMiranda4(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 600;
        this.isNonBoss();
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 360.0D).
                add(Attributes.MOVEMENT_SPEED, 0.27000001192092896D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 30.0D).
                add(Attributes.ARMOR_TOUGHNESS, 50.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.5D).
                add(Attributes.ATTACK_DAMAGE, 10.5D);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                int i = 0;
                Random ran = new Random();
                int co = ran.nextInt(7);
                if(this.level.getDifficulty()== Difficulty.NORMAL)
                {
                    i=7;
                }
                else if(this.level.getDifficulty()== Difficulty.HARD)
                {
                    i=12;
                }
                if(i>0){
                    if(co==0 || co==1) ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.POISON, i*10,1,true,true));
                    else if(co==2 || co==3 || co==4) ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.BLINDNESS, i*4,1,true,true));
                    else if(co==5) {
                        this.level.explode((Entity)null, entityIn.position().x, entityIn.position().y, entityIn.position().z, (float)this.explosionPower, true, Explosion.Mode.NONE);
                        this.addEffect(new EffectInstance(Effects.REGENERATION, i*10,0,true,true));
                    }
                    else {
                        this.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 40,2,true,true));
                        ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.BURN.get(), 60,2,true,true));
                        this.level.addParticle(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
                        this.spawnSoulSpeedParticle();
                    }
                }
                if(i+co>=12){
                    this.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 60,4,true,true));
                    if(i+co==13) ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.DEADLY.get(), 40,2,true,true));
                }
            }
            return true;
        }
    }

    public void aiStep() {
        super.aiStep();
        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co==1)
        {
            //this.level.addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vector3d pos = new Vector3d(this.position().x + 3.5 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 3.5 * Math.cos(0 + deltaOmega));
                //this.level.spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level.addParticle(ParticleTypes.ENTITY_EFFECT, pos.x, pos.y, pos.z, 0,0,0);
            }
        }
    }


    @Override
    public void customServerAiStep()
    {
        Random ran = new Random();
        if(this.getHealth() >= 10.0F && this.getHealth()<=18.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(3.0F*ran.nextFloat());
        }

        if(this.getHealth() >= 100.0F && this.getHealth()<=110.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1.5F*ran.nextFloat());
        }

        super.customServerAiStep();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public void setCustomName(@Nullable ITextComponent p_200203_1_) {
        super.setCustomName(p_200203_1_);
        this.bossInfo.setName(this.getDisplayName());
    }

    public boolean isNonBoss()
    {
        return false;
    }

    public void startSeenByPlayer(ServerPlayerEntity p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }

    public void stopSeenByPlayer(ServerPlayerEntity p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_DEATH1.get();
        }
        return SoundInit.ENTITY_MIRA_DEATH2.get();
    }

    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_AMBIENT1.get();
        }
        else if(co==1) return  SoundInit.ENTITY_MIRA_AMBIENT3.get();
        return SoundInit.ENTITY_MIRA_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_HURT1.get();
        }
        return SoundInit.ENTITY_MIRA_HURT2.get();
    }
}
