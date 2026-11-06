package com.joy187.re8joymod.items;



import java.util.Random;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMMycete;
import com.joy187.re8joymod.entity.EntityMycete;
import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemBlackball extends Item {

    public int cd =0;
    public ItemBlackball() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand handIn) {
        Level world = playerIn.level();
        if (!world.isClientSide)
        {
            if(target instanceof LivingEntity)
            {
                //EntityAngie elk = new EntityAngie(SheepEntity,world);
                if(playerIn.experienceLevel>5)
                {
                    Random ran = new Random();
                    int co=ran.nextInt(11);
                    if(target instanceof EntityMycete)
                    {
                        if(target instanceof EntityMycete){
                            EntityMMycete elk = new EntityMMycete(EntityInit.MMYCETE.get(),world);
                            //spawnc(elk,target,world);
                            elk.copyPosition(target);
                            world.addFreshEntity(elk);
                            target.discard();
                        }
                    }
                    else{
                        if(co==0) {
                            Sheep elk = new Sheep(EntityType.SHEEP,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==1)
                        {
                            Cow elk = new Cow(EntityType.COW,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==2){
                            Pig elk = new Pig(EntityType.PIG,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==3){
                            Bat elk = new Bat(EntityType.BAT,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==4){
                            Horse elk = new Horse(EntityType.HORSE,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==5){
                            Rabbit elk = new Rabbit(EntityType.RABBIT,world);
                            spawnc(elk,target,world);
                        }
//                        else if(co==6){
//                            EntityWp elk = new EntityWp(EntityInit.WP.get(),world);
//                            spawnc(elk,target,world);
//                        }
//                        else if(co==7){
//                            EntityBp elk = new EntityBp(EntityInit.BP.get(),world);
//                            spawnc(elk,target,world);
//                        }
                        else if(co==8){
                            Chicken elk = new Chicken(EntityType.CHICKEN,world);
                            spawnc(elk,target,world);
                        }
                        else{
                            EntityMycete elk = new EntityMycete(EntityInit.MYCETE.get(),world);
                            //spawnc(elk,target,world);
                            elk.copyPosition(target);
                            world.addFreshEntity(elk);
                            target.discard();
                        }
                    }
                    if(!playerIn.getAbilities().instabuild) playerIn.giveExperienceLevels(-3);
                    playerIn.playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 2.0F,2.0F);
                }
            }
        }


        return InteractionResult.PASS;
    }

    public static void spawnc(LivingEntity elk,LivingEntity target,Level world)
    {
        elk.setPos(target.position().x,target.position().y,target.position().z);
        CopyNormalAttr(target, elk);
        target.discard();
        world.addFreshEntity(elk);
        //playerIn.totalExperience-=50;
    }

    public static void CopyNormalAttr(LivingEntity ori, LivingEntity to)
    {
        CopyAttr(ori, to, Attributes.FOLLOW_RANGE);
        CopyAttr(ori, to, Attributes.MAX_HEALTH);
        CopyAttr(ori, to, Attributes.MOVEMENT_SPEED);
    }

    public static void CopyAttr(LivingEntity ori, LivingEntity to, Attribute attrType)
    {
        to.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(ori.getAttribute(attrType).getBaseValue());
    }
}
