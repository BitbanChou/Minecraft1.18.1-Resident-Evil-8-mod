package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityMiranda1 extends RavagerEntity{

    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
    private static final DataParameter<Integer> DATA_ID_INV = EntityDataManager.defineId(EntityMoreau.class, DataSerializers.INT);

    public EntityMiranda1(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 280;
        this.isNonBoss();
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.32D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 5.0D).
                add(Attributes.ARMOR_TOUGHNESS, 5.0D).
                add(Attributes.ATTACK_DAMAGE, 8.5D);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,1,true,true));
                ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.DEADLY.get(), 60,1,true,true));
            }
            return true;
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        Random ran = new Random();

        if(this.getHealth() >= 10.0F && this.getHealth()<=18.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.0F*ran.nextFloat());
            this.level.addParticle(ParticleTypes.WHITE_ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
        }
        if(this.getHealth() >= 100.0F && this.getHealth()<=120.0F){
            this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY()+ran.nextFloat(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
        }
        if(this.getHealth() >= 130.0F && this.getHealth()<=160.0F){
            this.level.addParticle(ParticleTypes.LANDING_OBSIDIAN_TEAR, this.getX()+ran.nextFloat(), this.getY(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
        }
        if(this.getHealth() >= 0.1F && this.getHealth()<=8.0F)
        {
            EntityMiranda2 e = new EntityMiranda2(EntityInit.MIRANDA2.get(),this.level);
            e.copyPosition(this);
            this.level.addFreshEntity(e);
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            this.remove();
        }

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
                Vector3d pos = new Vector3d(this.position().x + 1 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 1 * Math.cos(0 + deltaOmega));
                this.level.addParticle(ParticleTypes.ENTITY_EFFECT, pos.x, pos.y, pos.z, 0,0,0);
            }
        }
    }
}
