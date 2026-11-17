package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.ModEffects;
import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.RavagerEntity;
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
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.Random;


public class EntityMoreau3 extends RavagerEntity {

    public int explosionPower = 5;
    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
    private static final DataParameter<Integer> DATA_ID_INV = EntityDataManager.defineId(EntityMoreau.class, DataSerializers.INT);

    public EntityMoreau3(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 350;
        this.isNonBoss();
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 270.0D).
                add(Attributes.MOVEMENT_SPEED, 0.3D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 20.0D).
                add(Attributes.ATTACK_DAMAGE, 11.5D);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new JumpGoal() {
            @Override
            public boolean canUse() {
                return false;
            }
        });
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
//        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Entity.class, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.WITHER, 20,0,true,true));
                ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.EROSION.get(), 200,1,true,true));
                ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.HUNGER, 200,1,true,true));
            }
            return true;
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        Random ran = new Random();
        if(this.getHealth() >= 100.0F && this.getHealth()<=105.0F)
        {
            this.level.addParticle(ParticleTypes.BUBBLE, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for(int i=0;i<5;i++)
                this.heal(2.0F*ran.nextFloat());
        }
        if(this.getHealth() >= 50.0F && this.getHealth()<=55.0F)
        {
            this.level.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for(int i=0;i<5;i++)
                this.heal(2.5F*ran.nextFloat());
        }
        if(this.getHealth() >= 0.1F && this.getHealth()<=10.0F)
        {
//            Vector3d vec3d = this.getLook(1.0F);
            this.level.addParticle(ParticleTypes.EXPLOSION_EMITTER, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
            this.level.explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, true, Explosion.Mode.DESTROY);
        }

        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
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
        if(co==0) return SoundInit.ENTITY_MOREAU_AMBIENT1.get();
        return SoundInit.ENTITY_MOREAU_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_MOREAU_HURT1.get();
        return SoundInit.ENTITY_MOREAU_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_MOREAU_DEATH.get();
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
                Vector3d pos = new Vector3d(this.position().x + 2.8 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 2.8 * Math.cos(0 + deltaOmega));
                this.level.addParticle(ParticleTypes.BUBBLE, pos.x, pos.y, pos.z, 0,0,0);
            }
        }
    }
}