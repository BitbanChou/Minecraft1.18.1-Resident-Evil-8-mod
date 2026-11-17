package com.joy187.re8joymod.common.entity;


import com.joy187.re8joymod.common.entity.variant.DaughterVariant;
import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class EntitySummonDaughter extends EntitySummonSturm{

    private static final DataParameter<Integer> DATA_ID_TYPE_VARIANT =
            EntityDataManager.defineId(EntitySummonDaughter.class, DataSerializers.INT);

    public EntitySummonDaughter(EntityType<? extends WolfEntity> p_30369_, World p_30370_) {
        super(p_30369_, p_30370_);
        this.setTame(true);
        this.xpReward = 10;

        // TODO Auto-generated constructor stub
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.32F).
                add(Attributes.MAX_HEALTH, 45.0D).
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
        boolean flag = !(p_30372_ instanceof PlayerEntity) && p_30372_.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, p_30372_);
        }

        return flag;
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

                    this.heal((float)item.getFoodProperties().getNutrition());
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
//            else if (itemstack.is(ItemInit.RUSTPART.get()) && !this.isAngry()) {
//                if (!p_30412_.abilities.instabuild) {
//                    itemstack.shrink(1);
//                    this.heal((float)itemstack.getFoodProperties(this).getNutrition()*10);
//                }
//
////		            if (this.random.nextInt(2) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
////		               this.tame(p_30412_);
////		               this.navigation.stop();
////		               this.setTarget((LivingEntity)null);
////		               this.setOrderedToSit(true);
////		               this.level.broadcastEntityEvent(this, (byte)7);
////		            } else {
////		               this.level.broadcastEntityEvent(this, (byte)6);
////		            }
//
//                return ActionResultType.SUCCESS;
//            }

            return super.mobInteract(p_30412_, p_30413_);
        }
    }

    public boolean isTame() {
        return true;
    }

    public boolean isFood(ItemStack p_30440_) {
        Item item = p_30440_.getItem();
        return item.isEdible() && item.getFoodProperties().isMeat();
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


    public DaughterVariant getVariant() {
        return DaughterVariant.byId(this.getTypeVariant() & 255);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        //setSitting(tag.getBoolean("isSitting"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
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