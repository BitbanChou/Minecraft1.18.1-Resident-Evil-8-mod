package com.joy187.re8joymod.entity;

import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import com.joy187.re8joymod.entity.EntityDund.DundAttackGoal;
import com.joy187.re8joymod.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BegGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntitySummonSturm extends Wolf implements GeoEntity, NeutralMob{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(EntitySummonSturm.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntitySummonSturm.class,
			EntityDataSerializers.INT);
	@Nullable
	private UUID persistentAngerTarget;
	public EntitySummonSturm(EntityType<? extends Wolf> p_30369_, Level p_30370_) {
		super(p_30369_, p_30370_);
	    this.setTame(true);
        this.xpReward = 15;
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
		// TODO Auto-generated constructor stub
	}

	public static AttributeSupplier.Builder prepareAttributes() {
		      return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.26F).
		    		  add(Attributes.MAX_HEALTH, 60.0D).
		    		  add(Attributes.ATTACK_DAMAGE, 10.0D);
		   }
	
	
//	protected void registerGoals() {
//		      this.goalSelector.addGoal(1, new FloatGoal(this));
//		      this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
//		      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
//		      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D));
//		      this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
//		      this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
//		      this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
//		      this.goalSelector.addGoal(9, new BegGoal(this, 8.0F));
//		      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
//		      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
//		      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
//		      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
//		      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
//		      //this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true, 10, true, false, this::isAngryAt));
//		      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class,true));
//		      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityDund.class,true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau.class,true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau3.class,true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMuHeisen.class,true)));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
//		      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
//		      this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
//	}
	   
	
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
	    this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
	    this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	    this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F,false));
		this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(2, new EntitySummonSturmAttackGoal(this, 1.0D,false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class,true));
	      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityDund.class,true));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau.class,true));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMoreau3.class,true));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMuHeisen.class,true));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EntityBei.class,true));
	      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityDoll1.class,true));
	      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityLycan.class,true));
	      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityUrias.class,true));
	      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityUriass.class,true));
	      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityAxeman.class,true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class,true));

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
	
	   public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
		      ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
		      Item item = itemstack.getItem();
		      if (this.level().isClientSide) {
		         boolean flag = this.isOwnedBy(p_30412_) || this.isTame() || itemstack.is(Items.BONE) && !this.isTame() && !this.isAngry();
		         return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		      } else {
		         if (this.isTame()) {
		            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
		               if (!p_30412_.getAbilities().instabuild) {
		                  itemstack.shrink(1);
		               }

		               this.heal((float)itemstack.getFoodProperties(this).getNutrition()*10);
		               this.gameEvent(GameEvent.ENTITY_INTERACT, this);
		               return InteractionResult.SUCCESS;
		            }

		            if (!(item instanceof DyeItem)) {
		               InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
		               if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
		                  this.setOrderedToSit(!this.isOrderedToSit());
		                  this.jumping = false;
		                  this.navigation.stop();
		                  this.setTarget((LivingEntity)null);
		                  return InteractionResult.SUCCESS;
		               }

		               return interactionresult;
		            }

		            DyeColor dyecolor = ((DyeItem)item).getDyeColor();
		            if (dyecolor != this.getCollarColor()) {
		               this.setCollarColor(dyecolor);
		               if (!p_30412_.getAbilities().instabuild) {
		                  itemstack.shrink(1);
		               }

		               return InteractionResult.SUCCESS;
		            }
		         } 
		         else if (itemstack.is(ItemInit.RUSTPART.get()) && !this.isAngry()) {
		            if (!p_30412_.getAbilities().instabuild) {
		               itemstack.shrink(1);
		               this.heal((float)itemstack.getFoodProperties(this).getNutrition()*10);
		            }

//		            if (this.random.nextInt(2) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
//		               this.tame(p_30412_);
//		               this.navigation.stop();
//		               this.setTarget((LivingEntity)null);
//		               this.setOrderedToSit(true);
//		               this.level().broadcastEntityEvent(this, (byte)7);
//		            } else {
//		               this.level().broadcastEntityEvent(this, (byte)6);
//		            }

		            return InteractionResult.SUCCESS;
		         }

		         return super.mobInteract(p_30412_, p_30413_);
		      }
		   }
	   
	   public boolean isFood(ItemStack p_30440_) {
		      Item item = p_30440_.getItem();
		      return p_30440_.getItem()==ItemInit.RUSTPART.get();
	   }
	   
	   public boolean isBaby() {
		      return false;
	   }
	   
	   public boolean doHurtTarget(Entity p_30372_) {
		      boolean flag = !(p_30372_ instanceof Player) && p_30372_.hurt(damageSources().mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
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
		      if (!(p_30389_ instanceof Ghast)) {
//		         if (p_30389_ instanceof Wolf) {
//		            Wolf wolf = (Wolf)p_30389_;
//		            return !wolf.isTame() || wolf.getOwner() != p_30390_;
//		         } else if (p_30389_ instanceof Player && p_30390_ instanceof Player && !((Player)p_30390_).canHarmPlayer((Player)p_30389_)) {
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
	   
	   public boolean canMate(Animal p_30392_) {
		         return false;
	   }
	   
	    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
	        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
	        {
	            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.death"));
	            return PlayState.CONTINUE;
	        }
	    	
	    	if (event.isMoving()) {
	    		//System.out.println("GOGOGO!");
	            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.walk"));
	            return PlayState.CONTINUE;
	        }
	        
	        event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.idle"));
	        return PlayState.CONTINUE;
	    }
	    
		private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {

			if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.attack2"));
				return PlayState.CONTINUE;
			}
			if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.attack"));
				return PlayState.CONTINUE;
			}
			
			return PlayState.STOP;
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
	             if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity) && !(livingentity instanceof Player)) {
	                  Level world = this.parentEntity.level();
	                  ++this.attackTimer;
	                  Random rand = new Random();
	                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
	                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
	                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
	                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
	                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
	                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
	                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
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
	                  this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

				 }
	             else if (this.attackTimer > 0) {
	                  --this.attackTimer;
	             }
	        }
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
