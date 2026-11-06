package com.joy187.re8joymod.entity;

import java.util.EnumSet;

import com.joy187.re8joymod.init.EffectInit;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityFrank4 extends Vex{

	public EntityFrank4(EntityType<? extends Vex> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 30;
    }
	
	public static AttributeSupplier.Builder prepareAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 60.0D).
                add(Attributes.ARMOR, 6.0D).
                add(Attributes.ATTACK_DAMAGE, 12.5D);
	}
	
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 20 * (int)f));
        }

        return flag;
    }
    
	protected void registerGoals() {
	      super.registerGoals();
	      this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(4, new ChargeAttackGoal());
	      this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
	      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
	      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

	}

	class ChargeAttackGoal extends Goal {
	  public ChargeAttackGoal() {
	      this.setFlags(EnumSet.of(Flag.MOVE));
	  }
	
	  public boolean canUse() {
	      if (EntityFrank4.this.getTarget() != null && !EntityFrank4.this.getMoveControl().hasWanted() && EntityFrank4.this.random.nextInt(7) == 0) {
	          return EntityFrank4.this.distanceToSqr(EntityFrank4.this.getTarget()) > 4.0D;
	      } else {
	          return false;
	      }
	  }
	
	  public boolean canContinueToUse() {
	      return EntityFrank4.this.getMoveControl().hasWanted() && EntityFrank4.this.isCharging() && EntityFrank4.this.getTarget() != null && EntityFrank4.this.getTarget().isAlive();
	  }
	
	  public void start() {
	      LivingEntity livingentity = EntityFrank4.this.getTarget();
	      Vec3 vector3d = livingentity.getEyePosition(1.0F);
	      EntityFrank4.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
	      EntityFrank4.this.setIsCharging(true);
	      EntityFrank4.this.playSound(SoundEvents.VEX_CHARGE, 1.0F, 1.0F);
	  }
	
	  public void stop() {
	      EntityFrank4.this.setIsCharging(false);
	  }
	
	  public void tick() {
	      LivingEntity livingentity = EntityFrank4.this.getTarget();
	      if (EntityFrank4.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
	          EntityFrank4.this.doHurtTarget(livingentity);
	          EntityFrank4.this.setIsCharging(false);
	      } else {
	          double d0 = EntityFrank4.this.distanceToSqr(livingentity);
	          if (d0 < 9.0D) {
	              Vec3 vector3d = livingentity.getEyePosition(1.0F);
	              EntityFrank4.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
	          }
	      }
	
	  }
	}

}
