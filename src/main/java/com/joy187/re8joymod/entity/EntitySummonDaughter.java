package com.joy187.re8joymod.entity;

import java.util.Random;

import javax.annotation.Nullable;

import com.joy187.re8joymod.entity.variant.DaughterVariant;
import com.joy187.re8joymod.entity.variant.LycanVariant;
import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntitySummonDaughter extends EntitySummonSturm implements GeoEntity, NeutralMob{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(EntitySummonDaughter.class, EntityDataSerializers.INT);
    
	public EntitySummonDaughter(EntityType<? extends Wolf> p_30369_, Level p_30370_) {
		super(p_30369_, p_30370_);
	    this.setTame(true);
        this.xpReward = 10;
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
		// TODO Auto-generated constructor stub
	}
	
	public static AttributeSupplier.Builder prepareAttributes() {
	      return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.32F).
	    		  add(Attributes.MAX_HEALTH, 35.0D).
	    		  add(Attributes.ATTACK_DAMAGE, 8.0D);
	   }
	
	protected void defineSynchedData() {
		      super.defineSynchedData();
		      this.entityData.define(DATA_ID_TYPE_VARIANT, this.random.nextInt(3));
	}
	
	   
	@Nullable
	protected SoundEvent getAmbientSound() {
		Random ran = new Random();
		int co = ran.nextInt(3);
		if(co==0) {
			return SoundInit.ENTITY_CASSANDRA_AMBIENT.get();
		}
		else if(co==1) {
			return SoundInit.ENTITY_DANIELA_AMBIENT1.get();
		}
	    return SoundInit.ENTITY_BELA_AMBIENT.get();
	}

	protected SoundEvent getHurtSound(DamageSource source) {
		Random ran = new Random();
		int co = ran.nextInt(2);
		if(co==0) {
		      return SoundInit.ENTITY_DANIELA_HURT.get();
		}
	      return SoundInit.ENTITY_BELA_HURT.get();
	}
	
	   public boolean doHurtTarget(Entity p_30372_) {
		      boolean flag = !(p_30372_ instanceof Player) && p_30372_.hurt(damageSources().mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		      if (flag) {
		         this.doEnchantDamageEffects(this, p_30372_);
		      }

		      return flag;
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

		               this.heal((float)itemstack.getFoodProperties(this).getNutrition());
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
	   
		public boolean isTame() {
			return true;
		}
		
	   public boolean isFood(ItemStack p_30440_) {
		      Item item = p_30440_.getItem();
		      return item.isEdible() && p_30440_.getFoodProperties(this).isMeat();
		   }
	   
	protected SoundEvent getDeathSound() {
		Random ran = new Random();
		int co = ran.nextInt(2);
		if(co==0) {
			return SoundInit.ENTITY_CASSANDRA_DEATH1.get();
		}
		return SoundInit.ENTITY_DANIELA_DEATH.get();
	}
	
	public void setTame(boolean p_30443_) {
		  super.setTame(p_30443_);
		  if (p_30443_) {
		         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(35.0D);
		         this.setHealth(60.0F);
		      } else {
		         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(35.0D);
		      }

		 this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(8.0D);
	}
	
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
        {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.death"));
            return PlayState.CONTINUE;
        }
    	
    	if (event.isMoving()) {
    		//System.out.println("GOGOGO!");
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.walk"));
            return PlayState.CONTINUE;
        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {

		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.attack2"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.attack"));
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
	
    public DaughterVariant getVariant() {
        return DaughterVariant.byId(this.getTypeVariant() & 255);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        //setSitting(tag.getBoolean("isSitting"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        //tag.putBoolean("isSitting", this.isSitting());
        tag.putInt("Variant", this.getTypeVariant());
    }
    
    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(DaughterVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
}
