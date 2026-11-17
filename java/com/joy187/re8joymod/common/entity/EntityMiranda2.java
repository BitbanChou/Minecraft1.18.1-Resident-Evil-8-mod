package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModEffects;
import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityMiranda2 extends RavagerEntity {

    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
    public int explosionPower = 1;

    public EntityMiranda2(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 280;
        this.isNonBoss();
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 280.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 8.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.99D).
                add(Attributes.ATTACK_DAMAGE, 8.0D);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            Random ran = new Random();
            int co = ran.nextInt(7);
            if(co==1 || co==2 || co==3) {
                if(entityIn instanceof LivingEntity)
                {
                    ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.BLINDNESS, 100,1,true,true));
                }
                if(entityIn instanceof PlayerEntity || entityIn instanceof IronGolemEntity || entityIn instanceof EntityEthan ||entityIn instanceof EntityChris || entityIn instanceof EntityMuHeisen){
                    this.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 100,1,true,true));
                    this.addEffect(new EffectInstance(Effects.INVISIBILITY, 100,1,true,true));
                }
            }
            else if(co==4) {
                if (entityIn instanceof PlayerEntity || entityIn instanceof IronGolemEntity || entityIn instanceof EntityEthan ||entityIn instanceof EntityChris)
                {
                    this.addEffect(new EffectInstance(Effects.JUMP, 20,2,true,true));
                    this.level.explode((Entity)null, entityIn.position().x, entityIn.position().y, entityIn.position().z, (float)this.explosionPower, true, Explosion.Mode.DESTROY);
                    this.level.addParticle(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY()+ran.nextFloat(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
                }
                ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.DEADLY.get(), 100,1,false,true));
            }
            else if(co==5){
                ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.LEVITATION, 20*2,1,false,true));
            }
            else {
                if(co==0) {
                    ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*3,3,false,true));
                    this.level.addParticle(ParticleTypes.FLASH, this.getX()+ran.nextFloat(), this.getY(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
                }
                else ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.WEAKNESS, 20*3,1,false,true));
            }

            return true;
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

        if(this.getHealth() >= 50.0F && this.getHealth()<=58.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.0F*ran.nextFloat());
        }

        if(this.getHealth() >= 100.0F && this.getHealth()<=110.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1.5F*ran.nextFloat());
        }

        if(this.getHealth() >= 135.0F && this.getHealth()<=140.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1F*ran.nextFloat());
        }
        if(this.getHealth() >=1.0F && this.getHealth()<=7.0F)
        {
            EntityMiranda3 e = new EntityMiranda3(EntityInit.MIRANDA3.get(),this.level);
            e.copyPosition(this);
            this.level.addFreshEntity(e);
            this.level.addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            this.remove();
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

//    public void aiStep() {
//        super.aiStep();
//        Random ran = new Random();
//        int co = ran.nextInt(4);
//        if(co==1)
//        {
//            //this.level.addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
//            for (int i = 0; i < 10; i++)
//            {
//                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
//                Vec3d pos = new Vec3d(this.position().x + 2.8 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 2.8 * Math.cos(0 + deltaOmega));
//                this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
//            }
//        }
//    }

}
