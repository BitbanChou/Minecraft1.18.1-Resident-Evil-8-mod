package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityBp;
import com.joy187.re8joymod.common.entity.EntityMMycete;
import com.joy187.re8joymod.common.entity.EntityMycete;
import com.joy187.re8joymod.common.entity.EntityWp;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class ItemBlackball extends Item {

    public int cd =0;
    public ItemBlackball() {
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand handIn) {
        World world = playerIn.level;
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
                            target.remove();
                        }
                    }
                    else{
                        if(co==0) {
                            SheepEntity elk = new SheepEntity(EntityType.SHEEP,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==1)
                        {
                            CowEntity elk = new CowEntity(EntityType.COW,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==2){
                            PigEntity elk = new PigEntity(EntityType.PIG,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==3){
                            BatEntity elk = new BatEntity(EntityType.BAT,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==4){
                            HorseEntity elk = new HorseEntity(EntityType.HORSE,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==5){
                            RabbitEntity elk = new RabbitEntity(EntityType.RABBIT,world);
                            spawnc(elk,target,world);
                        }
                        else if(co==6){
                            EntityWp elk = new EntityWp(EntityInit.WP.get(),world);
                            spawnc(elk,target,world);
                        }
                        else if(co==7){
                            EntityBp elk = new EntityBp(EntityInit.BP.get(),world);
                            spawnc(elk,target,world);
                        }
                        else if(co==8){
                            ChickenEntity elk = new ChickenEntity(EntityType.CHICKEN,world);
                            spawnc(elk,target,world);
                        }
                        else{
                            EntityMycete elk = new EntityMycete(EntityInit.MYCETE.get(),world);
                            //spawnc(elk,target,world);
                            elk.copyPosition(target);
                            world.addFreshEntity(elk);
                            target.remove();
                        }
                    }
                    if(!playerIn.abilities.instabuild) playerIn.giveExperienceLevels(-3);
                    playerIn.playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 2.0F,2.0F);
                }
            }
        }


        return ActionResultType.PASS;
    }

    public static void spawnc(LivingEntity elk,LivingEntity target,World world)
    {
        elk.setPos(target.position().x,target.position().y,target.position().z);
        CopyNormalAttr(target, elk);
        target.remove();
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
