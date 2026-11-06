package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.*;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

public class ItemSample extends Item {
    public ItemSample(){
        super(new Properties().stacksTo(64));
    }

//    @Override
//    public InteractionResult interactLivingEntity(ItemStack p_41398_, Player player, LivingEntity pTarget, InteractionHand p_41401_) {
//        ItemStack itemstack = player.getItemInHand(p_41401_);
//        if(!(pTarget instanceof EntityAda4) || !(pTarget.hasEffect(EffectInit.PLAGAS.get()))){
//            if(pTarget instanceof Villager){
//                EntityVillagerGanado e=new EntityVillagerGanado(EntityInit.VILLAGERGANADO.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//
//            }
//            else if(pTarget instanceof Pillager){
//                EntityZealota e=new EntityZealota(EntityInit.ZEALOTA.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof Raider){
//                EntityZealot e=new EntityZealot(EntityInit.ZEALOT.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof ElderGuardian){
//                EntityDellago e=new EntityDellago(EntityInit.DALLAGO.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
//                e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof ArmorStand){
//                EntityArmadura e=new EntityArmadura(EntityInit.ARMADURA.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
//                e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof EntityBeibaby){
//                EntityU3 e=new EntityU3(EntityInit.U3.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
//                e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof EntityAda){
//                EntityAda4 e=new EntityAda4(EntityInit.ADA4.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof EntityEthan){
//                EntityLeon e=new EntityLeon(EntityInit.LEON.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof Silverfish){
//                EntityPlagas e=new EntityPlagas(EntityInit.PLAGAS.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof IronGolem){
//                EntityChief e=new EntityChief(EntityInit.CHIEF.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof EntityFrank5 || pTarget instanceof EntityFrank6){
//                EntityGarrador e=new EntityGarrador(EntityInit.GARRADOR.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof WanderingTrader){
//                EntityMerchant e=new EntityMerchant(EntityInit.MERCHANT.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if(pTarget instanceof Zombie || pTarget instanceof Piglin){
//                EntityPlagasZombie e=new EntityPlagasZombie(EntityInit.PLAGASZOMBIE.get(),player.level());
//                e.copyPosition(pTarget);
//                pTarget.discard();
//                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                player.level().addFreshEntity(e);
//            }
//            else if((pTarget.getBbWidth()>2.0F && pTarget.getBbHeight()>4.0F) || pTarget instanceof Warden){
//                if(!(pTarget instanceof EnderDragon))
//                {
//                    EntityElg e=new EntityElg(EntityInit.ELG.get(),player.level());
//                    e.copyPosition(pTarget);
//                    pTarget.discard();
//                    e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
//                    e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
//                    player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//                    player.level().addFreshEntity(e);
//                }
//            }
//            else{
//                pTarget.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 20*5,5,false,false));
//
//            }
//            itemstack.shrink(1);
//
//        }
//
//        return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
//    }


    @Override
    public InteractionResult interactLivingEntity(ItemStack p_41398_, Player player, LivingEntity pTarget, InteractionHand p_41401_) {
        ItemStack itemstack = player.getItemInHand(p_41401_);
        if((!(pTarget instanceof EntityAda4) && !(pTarget instanceof EntityMiranda1) && !(pTarget instanceof EntityMiranda4)) || !(pTarget.hasEffect(EffectInit.PLAGAS.get()))){
            if(pTarget instanceof EntityFaceEater){
                EntityRegenerator e=new EntityRegenerator(EntityInit.REGENERATOR.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            if(pTarget instanceof Villager){
                EntityVillagerGanado e=new EntityVillagerGanado(EntityInit.VILLAGERGANADO.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof EntityBeibaby){
                EntityU3 e=new EntityU3(EntityInit.U3.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
                e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Pig){
                if(player.getRandom().nextDouble()<0.25){
                    EntityJJ e=new EntityJJ(EntityInit.JJ.get(),player.level());
                    e.copyPosition(pTarget);
                    pTarget.discard();
                    player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    player.level().addFreshEntity(e);
                }
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Cow){
                if(player.getRandom().nextDouble()<0.25){
                    EntityBrute e=new EntityBrute(EntityInit.BRUTE.get(),player.level());
                    e.copyPosition(pTarget);
                    pTarget.discard();
                    player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    player.level().addFreshEntity(e);
                }
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Spider){
                EntityPlagasc e=new EntityPlagasc(EntityInit.PLAGASC.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof EntityFrank5 || pTarget instanceof EntityFrank6){
                EntityGarrador e=new EntityGarrador(EntityInit.GARRADOR.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Sheep){
                EntityStuff e=new EntityStuff(EntityInit.STUFF.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Pillager){
                EntityZealota e=new EntityZealota(EntityInit.ZEALOTA.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Raider){
                EntityZealot e=new EntityZealot(EntityInit.ZEALOT.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof ElderGuardian){
                EntityDellago e=new EntityDellago(EntityInit.DALLAGO.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
                e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof ArmorStand){
                EntityArmadura e=new EntityArmadura(EntityInit.ARMADURA.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
                e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof EntityAda){
                EntityAda4 e=new EntityAda4(EntityInit.ADA4.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof EntityEthan){
                EntityLeon e=new EntityLeon(EntityInit.LEON.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Silverfish){
                EntityPlagas e=new EntityPlagas(EntityInit.PLAGAS.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof IronGolem){
                EntityChief e=new EntityChief(EntityInit.CHIEF.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof WanderingTrader){
                EntityMerchant e=new EntityMerchant(EntityInit.MERCHANT.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof Zombie || pTarget instanceof Piglin){
                EntityPlagasZombie e=new EntityPlagasZombie(EntityInit.PLAGASZOMBIE.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof EntityRegenerator){
                EntityRegenerator2 e=new EntityRegenerator2(EntityInit.REGENERATOR2.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if(pTarget instanceof AbstractSkeleton){
                EntityFaceEater e=new EntityFaceEater(EntityInit.FE.get(),player.level());
                e.copyPosition(pTarget);
                pTarget.discard();
                player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                player.level().addFreshEntity(e);
                itemstack.shrink(1);
                return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
            }
            else if((pTarget.getBbWidth()>2.0F && pTarget.getBbHeight()>4.0F) || pTarget instanceof Warden){
                if(!(pTarget instanceof EnderDragon))
                {
                    EntityElg e=new EntityElg(EntityInit.ELG.get(),player.level());
                    e.copyPosition(pTarget);
                    pTarget.discard();
                    e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
                    e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
                    player.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
                    player.level().addFreshEntity(e);
                    itemstack.shrink(1);
                    return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
                }
            }
            else{
                pTarget.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 20*5,5,false,false));

            }
            itemstack.shrink(1);

        }

        return super.interactLivingEntity(p_41398_, player, pTarget, p_41401_);
    }
}
