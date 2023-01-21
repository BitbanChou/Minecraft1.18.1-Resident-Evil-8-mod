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
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityHeisen extends RavagerEntity {

    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
    private static final DataParameter<Integer> DATA_ID_INV = EntityDataManager.defineId(EntityHeisen.class, DataSerializers.INT);

    public EntityHeisen(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 250;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(PathNodeType.LAVA, 8.0F);
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 240.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 48.0D).
                add(Attributes.ARMOR, 25.0D).
                add(Attributes.ARMOR_TOUGHNESS, 15.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0f));
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

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.BURN.get(), 20,0,true,true));
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
                Vector3d pos = new Vector3d(this.position().x + 0.8 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 0.8 * Math.cos(0 + deltaOmega));
                //this.level.spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level.addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 0,0,0);
            }
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        Random ran = new Random();

        if(this.getHealth() >= 0.1F && this.getHealth()<=7.0F)
        {
            EntityMuHeisen e = new EntityMuHeisen(EntityInit.MUHEISEN.get(),this.level);
            e.copyPosition(this);
            this.level.addFreshEntity(e);
            this.level.addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            this.remove();

        }

        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    protected boolean isSunSensitive() {
        return true;
    }

    public boolean isNonBoss()
    {
        return false;
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
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_HESEN_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_HESEN_AMBIENT2.get();
        return SoundInit.ENTITY_HESEN_AMBIENT3.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_HESEN_HURT1.get();
        return SoundInit.ENTITY_HESEN_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_HESEN_DEATH.get();
    }
}
