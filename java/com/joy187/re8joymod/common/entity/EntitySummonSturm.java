package com.joy187.re8joymod.common.entity;


import com.joy187.re8joymod.common.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;

public class EntitySummonSturm extends WolfEntity {

    private static final RangedInteger PERSISTENT_ANGER_TIME = TickRangeConverter.rangeOfSeconds(20, 39);
    private static final DataParameter<Integer> DATA_REMAINING_ANGER_TIME = EntityDataManager.defineId(EntitySummonSturm.class, DataSerializers.INT);
    public static final DataParameter<Integer> STATE = EntityDataManager.defineId(EntitySummonSturm.class,
            DataSerializers.INT);
    @Nullable
    private UUID persistentAngerTarget;
    public EntitySummonSturm(EntityType<? extends WolfEntity> p_30369_, World p_30370_) {
        super(p_30369_, p_30370_);
        this.setTame(true);
        this.xpReward = 15;

        // TODO Auto-generated constructor stub
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.26F).
                add(Attributes.MAX_HEALTH, 60.0D).
                add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

//	protected void registerGoals() {
//		      this.goalSelector.addGoal(1, new FloatGoal(this));
//		      this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
//		      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
//		      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
//		      this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
//		      this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
//		      this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
//		      this.goalSelector.addGoal(9, new BegGoal(this, 8.0F));
//		      this.goalSelector.addGoal(10, new LookAtPlayerEntityGoal(this, PlayerEntity.class, 8.0F));
//		      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
//		      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
//		      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
//		      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
//		      //this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::isAngryAt));
//		      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class, true));
//		      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityDund.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau3.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMuHeisen.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
//		      this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
//	}


    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(1, new EntitySummonSturm.AttackGoal(this));
        this.goalSelector.addGoal(2, new EntitySummonSturmAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityDund.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau3.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMuHeisen.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityBei.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityDoll1.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityLycan.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityUrias.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityUriass.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityAxeman.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));

    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.RAVAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockstate) {
        this.playSound(SoundEvents.RAVAGER_STEP, 0.15F, 1.0F);
    }

    public boolean isTame() {
        return true;
    }

    public ActionResultType mobInteract(PlayerEntity p_30412_, Hand p_30413_) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
        Item item = itemstack.getItem();
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(p_30412_) || this.isTame() || item == Items.BONE && !this.isTame() && !this.isAngry();
            return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!p_30412_.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    this.heal((float)item.getFoodProperties().getNutrition()*10);
                    return ActionResultType.SUCCESS;
                }

                if (!(item instanceof DyeItem)) {
                    ActionResultType interactionresult = super.mobInteract(p_30412_, p_30413_);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity)null);
                        return ActionResultType.SUCCESS;
                    }

                    return interactionresult;
                }

                DyeColor dyecolor = ((DyeItem)item).getDyeColor();
                if (dyecolor != this.getCollarColor()) {
                    this.setCollarColor(dyecolor);
                    if (!p_30412_.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    return ActionResultType.SUCCESS;
                }
            }
            else if (item == ModItems.RUSTEDPART.get() && !this.isAngry()) {
                if (!p_30412_.abilities.instabuild) {
                    itemstack.shrink(1);
                    this.heal((float)item.getFoodProperties().getNutrition()*10);
                }

//		            if (this.random.nextInt(2) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
//		               this.tame(p_30412_);
//		               this.navigation.stop();
//		               this.setTarget((LivingEntity)null);
//		               this.setOrderedToSit(true);
//		               this.level.broadcastEntityEvent(this, (byte)7);
//		            } else {
//		               this.level.broadcastEntityEvent(this, (byte)6);
//		            }

                return ActionResultType.SUCCESS;
            }

            return super.mobInteract(p_30412_, p_30413_);
        }
    }

    public boolean isFood(ItemStack p_30440_) {
        Item item = p_30440_.getItem();
        return p_30440_.getItem()== ModItems.RUSTEDPART.get();
    }

    public boolean isBaby() {
        return false;
    }

    public boolean doHurtTarget(Entity p_30372_) {
        boolean flag = !(p_30372_ instanceof PlayerEntity) && p_30372_.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, p_30372_);
        }

        return flag;
    }

    static class EntitySummonSturmAttackGoal extends MeleeAttackGoal {
        private final EntitySummonSturm zombie;

        public EntitySummonSturmAttackGoal(EntitySummonSturm entity, double p_i46803_2_, boolean p_i46803_4_) {
            super(entity, p_i46803_2_, p_i46803_4_);
            this.zombie=entity;
        }
    }

    public void setTame(boolean p_30443_) {
        super.setTame(p_30443_);
        if (p_30443_) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60.0D);
            this.setHealth(60.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60.0D);
        }

        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }

    //	   default boolean isAngry() {
//		      return this.getRemainingPersistentAngerTime() > 0;
//		   }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
        this.entityData.define(STATE, 0);
    }

    public int getRemainingPersistentAngerTime() {
        return this.entityData.get(DATA_REMAINING_ANGER_TIME);
    }

    public void setRemainingPersistentAngerTime(int p_30404_) {
        this.entityData.set(DATA_REMAINING_ANGER_TIME, p_30404_);
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }
    public boolean wantsToAttack(LivingEntity p_30389_, LivingEntity p_30390_) {
        if (!(p_30389_ instanceof GhastEntity)) {
//		         if (p_30389_ instanceof Wolf) {
//		            Wolf wolf = (Wolf)p_30389_;
//		            return !wolf.isTame() || wolf.getOwner() != p_30390_;
//		         } else if (p_30389_ instanceof PlayerEntity && p_30390_ instanceof PlayerEntity && !((PlayerEntity)p_30390_).canHarmPlayerEntity((PlayerEntity)p_30389_)) {
//		            return false;
//		         } else if (p_30389_ instanceof AbstractHorse && ((AbstractHorse)p_30389_).isTamed()) {
//		            return false;
//		         } else {
//		            return !(p_30389_ instanceof TamableAnimal) || !((TamableAnimal)p_30389_).isTame();
//		         }
            return true;
        } else {
            return false;
        }
    }

    public boolean canMate(AnimalEntity p_30392_) {
        return false;
    }

    static class AttackGoal extends Goal {
        private final EntitySummonSturm parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntitySummonSturm mob) {
            this.parentEntity = mob;
        }

        public boolean canUse() {
            return this.parentEntity.getTarget() != null;
        }

        public void start() {
            super.start();
            this.parentEntity.setAggressive(true);
        }

        @Override
        public void stop() {
            super.stop();
            this.parentEntity.setAggressive(false);
            this.parentEntity.setAttackingState(0);
            this.attackTimer = -1;
        }

        public void tick() {
            LivingEntity livingentity = this.parentEntity.getTarget();
            if (this.parentEntity.canSee(livingentity) && !(livingentity instanceof PlayerEntity)) {
                World world = this.parentEntity.level;
                ++this.attackTimer;
                Random rand = new Random();
                Vector3d vector3d = this.parentEntity.getViewVector(1.0F);
                double d0 = Math.min(livingentity.getY(), livingentity.getY());
                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                float f = (float) MathHelper.atan2(livingentity.getZ() - parentEntity.getZ(),
                        livingentity.getX() - parentEntity.getX());

                this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                if (this.attackTimer == 15) {
                    if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.40) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.50))
                            || (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.20) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.30)))
                        this.parentEntity.setAttackingState(2);
                    else{
                        this.parentEntity.setAttackingState(1);
                    }
                }
                if (this.attackTimer == 30) {
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -5;
                }
            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
        }
    }

}