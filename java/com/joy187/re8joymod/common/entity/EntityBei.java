package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.util.math.vector.Vector3d;import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
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

public class EntityBei extends RavagerEntity {

    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
    private static final DataParameter<Integer> DATA_ID_INV = EntityDataManager.defineId(EntityBei.class, DataSerializers.INT);
    private int f;

    public EntityBei(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.isNonBoss();
        this.xpReward = 250;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 150.0D).
                add(Attributes.MOVEMENT_SPEED, 0.43D).
                add(Attributes.FOLLOW_RANGE, 48.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 17.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.45D).
                add(Attributes.ATTACK_DAMAGE, 7.0D);
    }

    public void aiStep() {

        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co==1)
        {
            //this.level.addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vector3d pos = new Vector3d(this.position().x + 0.8 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 0.8 * Math.cos(0 + deltaOmega));
                //this.level.spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            }
        }
        super.aiStep();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.addGoal(3,new SwimGoal(this));
        this.goalSelector.addGoal(4, new JumpGoal() {
            @Override
            public boolean canUse() {
                return false;
            }
        });

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    public void setInvulnerableTicks(int p_82215_1_) {
        this.entityData.set(DATA_ID_INV, p_82215_1_);
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setInvulnerableTicks(p_70037_1_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }

    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                Random ran = new Random();
                int co = ran.nextInt(4);
                if(co==1) ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.BLINDNESS, 200,0,true,true));
                if(co==2) ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.LEVITATION, 40,1,true,true));
            }
            return true;
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        Random ran = new Random();
        int co = ran.nextInt(100);
        if(co<20 && f==1){
            if(co<15 && co%2==0){
                EntityDoll1 e = new EntityDoll1(EntityInit.DOLL1.get(),this.level);
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level.addFreshEntity(e);
            }
            else if(co<15 && co%2==1){
                EntityDoll2 e = new EntityDoll2(EntityInit.DOLL2.get(),this.level);
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level.addFreshEntity(e);
            }
            else if(co==16  || f==19){
                EntityAngie e = new EntityAngie(EntityInit.ANGIE.get(),this.level);
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level.addFreshEntity(e);
            }
            else {
                EntityDoll3 e = new EntityDoll3(EntityInit.DOLL3.get(),this.level);
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level.addFreshEntity(e);
            }
            f=(f+2)%30;
        }
        else if(co>20 && co<40){
            if(co%5==0) this.addEffect(new EffectInstance(Effects.INVISIBILITY, 20*1,1,true,true));
            else {
                this.level.addParticle(ParticleTypes.END_ROD, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
                f=(f+2)%30;
            }
        }
        else if(co>95 && ((this.getHealth() >= 10.0F && this.getHealth()<=30.0F) || (this.getHealth() >= 60.0F && this.getHealth()<=75.0F))){

            f=(f+1)%30;
        }
        else{
            this.level.addParticle(ParticleTypes.SOUL, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
            f=(f+1)%30;
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
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_BEI_AMBIENT1.get();
        }
        return SoundInit.ENTITY_BEI_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_BEI_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_BEI_DEATH1.get();
        }
        return SoundInit.ENTITY_BEI_DEATH2.get();
    }
    
}
