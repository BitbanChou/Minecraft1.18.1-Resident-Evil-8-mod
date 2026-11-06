package com.joy187.re8joymod.packet;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.config.ModCommonConfig;
import com.joy187.re8joymod.entity.EntityBOWShoot;
import com.joy187.re8joymod.entity.EntityFallingBlock;
import com.joy187.re8joymod.entity.EntityHeisencar;
import com.joy187.re8joymod.entity.EntityHeli;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.items.*;
import com.joy187.re8joymod.util.CommonFunctions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.phys.*;
import net.minecraftforge.network.NetworkEvent;
import net.minecraft.world.item.Item;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.world.item.Item;

public class FirePacket {
    private static final String MESSAGE_DRINK_WATER = "message.tutorialmod.drink_water";
    private static final String MESSAGE_NO_WATER = "message.tutorialmod.no_water";

    public FirePacket() {

    }

    public FirePacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = (ServerLevel) player.level();

            if(player.getVehicle() instanceof EntityHeli) {
                EntityHeli heli = (EntityHeli) player.getVehicle();
                heli.shoot(player, heli, level);
            }
            else if(player.getVehicle() instanceof EntityHeisencar){
                EntityHeisencar heli = (EntityHeisencar) player.getVehicle();
                heli.shoot(player, heli, level);
            }
            else if(player.getMainHandItem().getItem() instanceof ItemUrias && (player.getMainHandItem().getItem()!= ItemInit.SAW.get())){
                if(!player.getCooldowns().isOnCooldown(player.getMainHandItem().getItem()))
                {
                    for (LivingEntity livingentity : player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(8.0D), F_AREA)) {
                        player.playSound(SoundEvents.METAL_HIT, 3.0F, 1.0F);
                        livingentity.hurt(player.damageSources().mobAttack(player), livingentity.getMaxHealth()*0.1f);
                    }

                    for(int i = 0; i < 5; ++i) {
                        float f1 = (float)i * (float)Math.PI * 2.8F;
                        EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(player.level(), player.getX() + (double) Mth.cos(f1) * 2D, player.getY() + player.getRandom().nextDouble(), player.getZ() + (double)Mth.sin(f1) * 2D,
                                BlockInit.EXAMPLE_BLOCK.get().defaultBlockState(), 10);
                        player.level().addFreshEntity(fallingBlockEntity);
                    }

                    for(int k = 0; k < 8; ++k) {
                        float f2 = (float)k * (float)Math.PI * 1.8F / 8.0F + 1.2566371F;
                        EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(player.level(), player.getX() + (double)Mth.cos(f2) * 3D, player.getY() + player.getRandom().nextDouble(), player.getZ() + (double)Mth.sin(f2) * 3D,
                                BlockInit.EXAMPLE_BLOCK.get().defaultBlockState(), 10);
                        player.level().addFreshEntity(fallingBlockEntity);
                    }

                    player.level().playSound(null, player.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
                    player.getCooldowns().addCooldown(player.getMainHandItem().getItem(),200);
                }
            }
            else if((player.getMainHandItem().getItem() instanceof ItemWand) && !player.getCooldowns().isOnCooldown(player.getMainHandItem().getItem()))
            {
                ItemStack itemstack= player.getMainHandItem();
                //((ItemWand)itemstack.getItem()).time=0;
                if (!level.isClientSide) {

                    for (LivingEntity lvt : player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(3.0D), F_AREA)) {
                        double d00 = lvt.getX() - player.getX();
                        double d10 = lvt.getZ() - player.getZ();
                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                        lvt.hurt(player.damageSources().fellOutOfWorld(),lvt.getMaxHealth()*0.2f);
                        lvt.push(d00 / d20 * 6.0D, 0.2D, d10 / d20 * 6.0D);
                    }
                }

                player.displayClientMessage(Component.literal("Push!").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD), false);
                player.getCooldowns().addCooldown(itemstack.getItem(),120);
            }
            else if((player.getMainHandItem().getItem() instanceof ItemCrossbow2) && !player.getCooldowns().isOnCooldown(player.getMainHandItem().getItem())){
                ItemStack itemstack= player.getMainHandItem();
                ((ItemCrossbow2)itemstack.getItem()).time=0;
                if (!level.isClientSide && ((ItemCrossbow2)itemstack.getItem()).time%4==0) {
                    ItemBOWShoot arrowitem = (ItemBOWShoot) (itemstack.getItem() instanceof ItemBOWShoot ? itemstack : ItemInit.BOWSHOOT.get().asItem());
                    EntityBOWShoot abstractarrowentity = arrowitem.createArrow(level, itemstack, player);
                        //abstractarrowentity = customArrow(abstractarrowentity);
                        //abstractarrowentity.setItem(itemstack);
                    abstractarrowentity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.2F, 10.0F, 0.75F);
                    abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 2.5F, 2.5F);
                    level.addFreshEntity(abstractarrowentity);
                }

                player.displayClientMessage(Component.literal("Fire!").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD), false);
                player.getCooldowns().addCooldown(player.getMainHandItem().getItem(),20);
            }
            else if((player.getMainHandItem().getItem() instanceof SwordItem  || player.getMainHandItem().getItem() instanceof ItemCombatKnife
            || player.getMainHandItem().getItem() instanceof ItemSaw) && !player.getCooldowns().isOnCooldown(player.getMainHandItem().getItem())){
                // Notify the player that there is no water around!
                //player.sendSystemMessage(Component.translatable("Ops!"));
                // Output the current thirst level
                float range = 2F;
                Vec3 start = player.getEyePosition(1F);
                Vec3 look = player.getLookAngle();
                Vec3 direction = start.add(look.x * range, look.y * range, look.z * range);
                AABB bb = player.getBoundingBox().expandTowards(look.x * range, look.y * range, look.z * range).expandTowards(1, 1, 1);
                EntityHitResult emop = ProjectileUtil.getEntityHitResult(level, player, start, direction, bb, (e) -> e instanceof LivingEntity);
                if (emop != null) {
                    LivingEntity target = (LivingEntity) emop.getEntity();
                    float ampl=(player.getMainHandItem().getItem() instanceof ItemCombatKnife)?target.getMaxHealth()*0.05f:0;
                    ampl+=(player.getMainHandItem().getItem() instanceof ItemSaw)?target.getMaxHealth()*0.1f:0;
                    if((target.getHealth()<target.getMaxHealth()* ModCommonConfig.CAN_EXECUTE.get()+ampl && target.getMaxHealth()<80) || (target.getHealth()<5F && target.getMaxHealth()>=80))
                    {
                        double targetDist = start.distanceToSqr(target.getEyePosition(1F));
                        player.swing(InteractionHand.MAIN_HAND);
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2,20,false,false));
                        player.displayClientMessage(Component.literal("Execute!").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD), false);
                        player.moveTo(target.position());
                        player.setXRot(target.getXRot());
                        player.setYRot(target.getYRot());
                        // cancel if there's a block in the way
                        player.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 3.0F, 1.0F);
                        target.hurt(player.damageSources().fellOutOfWorld(), target.getMaxHealth()+target.getArmorValue());
                        player.giveExperiencePoints(player.getRandom().nextInt(6));
                        CommonFunctions.spawnFireFlame(player,ParticleInit.FLAME_PARTICLE.get());
                        BlockHitResult mop = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
                        double blockDist = mop.getBlockPos().distToCenterSqr(start);
                        if (mop.getType() == HitResult.Type.BLOCK && targetDist > blockDist) {
                            //return false;
                        }
                        player.getCooldowns().addCooldown(player.getMainHandItem().getItem(),140+Math.min(100, 60));
                        Main.renderExecute=20;
                    }

                    //target.knockback(f , -look.x, -look.z);
//            if (player instanceof ServerPlayer playerMP) {
//                GGDNetwork.getInstance().sendVanillaPacket(new ClientboundSetEntityMotionPacket(player), playerMP);
//            }
                }
            }
        });
        return true;
    }


    private static final Predicate<Entity> F_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof Player);
    };

    protected static BlockHitResult getPlayerPOVHitResult(Level p_41436_, Player p_41437_, ClipContext.Fluid p_41438_) {
        float f = p_41437_.getXRot();
        float f1 = p_41437_.getYRot();
        Vec3 vec3 = p_41437_.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = p_41437_.getBlockReach();
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return p_41436_.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, p_41438_, p_41437_));
    }

}
