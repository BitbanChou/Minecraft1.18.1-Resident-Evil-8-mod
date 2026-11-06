package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityChief;
import com.joy187.re8joymod.entity.EntityCvg;
import com.joy187.re8joymod.entity.EntityVillagerGanado;
import com.joy187.re8joymod.init.ItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EyeOfEnder;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.List;
import java.util.function.Predicate;

public class ItemChiefEye extends Item {

    public ItemChiefEye() {
        super(new Properties().stacksTo(1).durability(150));
    }

    public InteractionResult useOn(UseOnContext p_41182_) {
        Level level = p_41182_.getLevel();
        BlockPos blockpos = p_41182_.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (blockstate.is(Blocks.END_PORTAL_FRAME) && !blockstate.getValue(EndPortalFrameBlock.HAS_EYE) && p_41182_.getPlayer()!=null) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState blockstate1 = blockstate.setValue(EndPortalFrameBlock.HAS_EYE, Boolean.valueOf(true));
                Block.pushEntitiesUp(blockstate, blockstate1, level, blockpos);
                level.setBlock(blockpos, blockstate1, 2);
                level.updateNeighbourForOutputSignal(blockpos, Blocks.END_PORTAL_FRAME);
                //p_41182_.getItemInHand().shrink(1);
                p_41182_.getItemInHand().hurtAndBreak(1, p_41182_.getPlayer(), (p_220009_1_) -> {
                    p_220009_1_.broadcastBreakEvent(p_41182_.getPlayer().getUsedItemHand());
                });
                level.levelEvent(1503, blockpos, 0);
                BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = EndPortalFrameBlock.getOrCreatePortalShape().find(level, blockpos);
                if (blockpattern$blockpatternmatch != null) {
                    BlockPos blockpos1 = blockpattern$blockpatternmatch.getFrontTopLeft().offset(-3, 0, -3);

                    for(int i = 0; i < 3; ++i) {
                        for(int j = 0; j < 3; ++j) {
                            level.setBlock(blockpos1.offset(i, 0, j), Blocks.END_PORTAL.defaultBlockState(), 2);
                        }
                    }

                    level.globalLevelEvent(1038, blockpos1.offset(1, 0, 1), 0);
                }

                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    public InteractionResultHolder<ItemStack> use(Level p_41184_, Player p_41185_, InteractionHand p_41186_) {
        ItemStack itemstack = p_41185_.getItemInHand(p_41186_);
        HitResult hitresult = getPlayerPOVHitResult(p_41184_, p_41185_, ClipContext.Fluid.NONE);
        if (hitresult.getType() == HitResult.Type.BLOCK && p_41184_.getBlockState(((BlockHitResult)hitresult).getBlockPos()).is(Blocks.END_PORTAL_FRAME)) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            p_41185_.startUsingItem(p_41186_);
            if (p_41184_ instanceof ServerLevel) {
                ServerLevel serverlevel = (ServerLevel)p_41184_;
                BlockPos blockpos = serverlevel.findNearestMapStructure(StructureTags.EYE_OF_ENDER_LOCATED, p_41185_.blockPosition(), 100, false);
                if (blockpos != null) {
                    EyeOfEnder eyeofender = new EyeOfEnder(p_41184_, p_41185_.getX(), p_41185_.getY(0.5D), p_41185_.getZ());
                    eyeofender.setItem(new ItemStack(Items.ENDER_PEARL));
                    eyeofender.signalTo(blockpos);
                    p_41184_.gameEvent(GameEvent.PROJECTILE_SHOOT, eyeofender.position(), GameEvent.Context.of(p_41185_));
                    p_41184_.addFreshEntity(eyeofender);
                    if (p_41185_ instanceof ServerPlayer) {
                        CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayer)p_41185_, blockpos);
                    }

                    p_41184_.playSound((Player)null, p_41185_.getX(), p_41185_.getY(), p_41185_.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundSource.NEUTRAL, 0.5F, 0.4F / (p_41184_.getRandom().nextFloat() * 0.4F + 0.8F));
                    p_41184_.levelEvent((Player)null, 1003, p_41185_.blockPosition(), 0);
                    if (!p_41185_.getAbilities().instabuild) {
                        //itemstack.shrink(1);
                        itemstack.hurtAndBreak(1, p_41185_, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(p_41185_.getUsedItemHand());
                        });
                    }

                    p_41185_.awardStat(Stats.ITEM_USED.get(this));
                    p_41185_.swing(p_41186_, true);
                    return InteractionResultHolder.success(itemstack);
                }
            }

            return InteractionResultHolder.consume(itemstack);
        }
    }

    private static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityChief);
    };

    public void inventoryTick(ItemStack stack, Level level, Entity p_41406_, int p_41407_, boolean p_41408_) {
        if (!level.isClientSide && stack.getItem()== ItemInit.CEYE.get()) {
            if(p_41406_ instanceof Player){
                if(((Player)p_41406_).getMainHandItem().getItem()==ItemInit.CEYE.get() ||
                        ((Player)p_41406_).getOffhandItem().getItem()==ItemInit.CEYE.get())
                {
                    for (LivingEntity lvt : p_41406_.level().getEntitiesOfClass(LivingEntity.class, p_41406_.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                        if(lvt instanceof EntityVillagerGanado || lvt instanceof EntityCvg){
                            if(((Monster)lvt).getTarget()!=null && ((Monster)lvt).getTarget()==p_41406_){
                                ((Monster)lvt).setTarget(null);
                            }
                        }
                    }

                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.chiefeye"));
    }

}
