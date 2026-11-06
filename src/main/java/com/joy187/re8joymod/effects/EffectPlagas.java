package com.joy187.re8joymod.effects;

import com.joy187.re8joymod.entity.*;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.util.CommonFunctions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.Random;

public class EffectPlagas extends BaseEffect{

    public EffectPlagas(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 5 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        amplified++;
        if(living.getEffect(EffectInit.PLAGAS.get())!=null) {
            if (living.getEffect(EffectInit.PLAGAS.get()).getDuration() == 5) {
                if(living instanceof EntityZealot){
                    EntityPlagasm e=new EntityPlagasm(EntityInit.PLAGASM.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                if(living instanceof Wolf){
                    EntityEvilDog e=new EntityEvilDog(EntityInit.EVILDOG.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                if(living instanceof EntityEvilDog){
                    EntityPlagasDog e=new EntityPlagasDog(EntityInit.PLAGASDOG.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                if(living instanceof EntityRegenerator){
                    EntityRegenerator2 e=new EntityRegenerator2(EntityInit.REGENERATOR2.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                if(living instanceof AbstractSkeleton){
                    EntityFaceEater e=new EntityFaceEater(EntityInit.FE.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                if(living instanceof Villager){
                    EntityPlagasVillager e=new EntityPlagasVillager(EntityInit.PLAGASVILLAGER.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                else if (living instanceof Zombie){
                    EntityPlagasZombie e=new EntityPlagasZombie(EntityInit.PLAGASZOMBIE.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                if(living instanceof EnderMan){
                    EntityPlagasEnderman e=new EntityPlagasEnderman(EntityInit.PLAGASENDERMAN.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                if(living instanceof Creeper){
                    EntityPlagasCreeper e=new EntityPlagasCreeper(EntityInit.PLAGASCREEPER.get(),living.level());
                    e.copyPosition(living);
                    living.discard();
                    living.level().playSound((Player)null, living.getX(), living.getY(), living.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (living.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    living.level().addFreshEntity(e);
                }
                else if (living instanceof Player)
                {
                    int k=living.getRandom().nextInt(10);
                    if(k<4)
                        living.hurt(living.damageSources().cactus(), 10F * amplified);
                    else if(k>8)
                        living.addEffect(new MobEffectInstance(EffectInit.ZENHEART.get(), 200, 0));
                    else{
                        living.addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 200, 1));
                    }
                }
                else{
                    if(living.getRandom().nextFloat()<0.3f){
                        living.hurt(living.damageSources().magic(),living.getMaxHealth()*0.9f);
                    }
                    else{
                        living.addEffect(new MobEffectInstance(EffectInit.BURN.get(), 200, 3));
                    }
                }
            }
        }
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }
    
}
