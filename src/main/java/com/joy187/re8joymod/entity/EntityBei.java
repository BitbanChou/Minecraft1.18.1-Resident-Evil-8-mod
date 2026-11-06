package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityBei extends Ravager implements GeoEntity {
	
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityBei.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityBei.class,
			EntityDataSerializers.INT);
    private int f=0;
    private int canSummon=0;
    
    public EntityBei(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 250;
        this.isNonBoss();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 150.0D).
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
            //this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(this.position().x + 0.8 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 0.8 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            }
        }
        super.aiStep();
    }
    
    public boolean isNonBoss()
    {
        return false;
    }
    
    public void startSeenByPlayer(ServerPlayer p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }

    public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        Random ran = new Random();
        int co = ran.nextInt(100);
        if(co<20 && f==1){
        	this.canSummon=1;
            if(co<15 && co%2==0){
                EntityDoll1 e = new EntityDoll1(EntityInit.DOLL1.get(),this.level());
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level().addFreshEntity(e);
            }
            else if(co<15 && co%2==1){
                EntityDoll2 e = new EntityDoll2(EntityInit.DOLL2.get(),this.level());
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level().addFreshEntity(e);
            }
            else if(co==16  || f==19){
                EntityAngie e = new EntityAngie(EntityInit.ANGIE.get(),this.level());
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level().addFreshEntity(e);
                this.getNavigation().moveTo(this.getX()-4-6*random.nextDouble(),this.getY(),this.getZ()+4+5*random.nextDouble(),5);
            }
            else {
                EntityDoll3 e = new EntityDoll3(EntityInit.DOLL3.get(),this.level());
                e.setPos(this.position().x+5*ran.nextFloat(),this.position().y+0.3*ran.nextFloat(),this.position().z+5*ran.nextFloat());
                this.level().addFreshEntity(e);
            }
            f=(f+2)%30;
        }
        else if(co>20 && co<40){
        	this.canSummon=0;
            if(co%5==0) this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20*1,1,true,true));
            else {
                this.level().addParticle(ParticleTypes.END_ROD, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
                f=(f+2)%30;
            }
        }
        else if(co>95 && ((this.getHealth() >= 10.0F && this.getHealth()<=30.0F) || (this.getHealth() >= 60.0F && this.getHealth()<=75.0F))){
        	this.canSummon=0;
            f=(f+1)%30;
            this.getNavigation().moveTo(this.getX()+6+5*random.nextDouble(),this.getY(),this.getZ()-6-5*random.nextDouble(),5);
        }
        else{
        	this.canSummon=0;
            this.level().addParticle(ParticleTypes.SOUL, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
            f=(f+1)%30;
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
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
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.walk"));
            return PlayState.CONTINUE;
        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.canSummon == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.summon"));
			return PlayState.CONTINUE;
		}
		if (this.canSummon == 0 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.attack"));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}
	
    @Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
        data.add(new AnimationController(this, "controller1",
                0, this::predicate1));
	}

	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
    
}
