package com.joy187.re8joymod.common.items;


import com.joy187.re8joymod.common.entity.EntityObBoat;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class ItemObBoat extends Item {

    private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::isPickable);

    public ItemObBoat(){
        super(new Item.Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1).fireResistant());
    }

    //private EntityObBoat.Type type= EntityObBoat.Type.OAK;


    public ActionResult<ItemStack> use(World p_40622_, PlayerEntity p_40623_, Hand p_40624_) {
        ItemStack itemstack = p_40623_.getItemInHand(p_40624_);
        RayTraceResult hitresult = getPlayerPOVHitResult(p_40622_, p_40623_, RayTraceContext.FluidMode.ANY);
        if (hitresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemstack);
        } else {
            Vector3d vec3 = p_40623_.getViewVector(1.0F);
            double d0 = 5.0D;
            List<Entity> list = p_40622_.getEntities(p_40623_, p_40623_.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vector3d vec31 = p_40623_.getEyePosition(1.0F);

                for(Entity entity : list) {
                    AxisAlignedBB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (aabb.contains(vec31)) {
                        return ActionResult.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == RayTraceResult.Type.BLOCK) {
                //EntityObBoat boat = new EntityObBoat(p_40622_, hitresult.getLocation().x, hitresult.getLocation().y, hitresult.getLocation().z);
                //EntityObBoat boat = new EntityObBoat(EntityInit.OBBOAT.get(),p_40622_);
                EntityObBoat boatentity = new EntityObBoat(p_40622_, hitresult.getLocation().x, hitresult.getLocation().y, hitresult.getLocation().z);
                //boatentity.setType(this.type);
                boatentity.yRot = p_40623_.yRot;
                if (!p_40622_.noCollision(boatentity, boatentity.getBoundingBox().inflate(-0.1D))) {
                    return ActionResult.fail(itemstack);
                } else {
                    if (!p_40622_.isClientSide) {
                        p_40622_.addFreshEntity(boatentity);
                        if (!p_40623_.abilities.instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    p_40623_.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.sidedSuccess(itemstack, p_40622_.isClientSide());
                }
            } else {
                return ActionResult.pass(itemstack);
            }
//                boat.setPos(hitresult.getLocation().x, hitresult.getLocation().y, hitresult.getLocation().z);
//                //boat.setType(this.type);
//                boat.yRot = p_40623_.yRot;
//                if (!p_40622_.noCollision(boat, boat.getBoundingBox())) {
//                    return ActionResult.fail(itemstack);
//                } else {
//                    if (!p_40622_.isClientSide) {
//                        p_40622_.addFreshEntity(boat);
//                        //p_40622_.gameEvent(p_40623_, GameEvent.ENTITY_PLACE, new BlockPos(hitresult.getLocation()));
//                        if (!p_40623_.abilities.instabuild) {
//                            itemstack.shrink(1);
//                        }
//                    }
//
//                    p_40623_.awardStat(Stats.ITEM_USED.get(this));
//                    return ActionResult.sidedSuccess(itemstack, p_40622_.isClientSide());
//                }
//            } else {
//                return ActionResult.pass(itemstack);
//            }
        }
    }

}
