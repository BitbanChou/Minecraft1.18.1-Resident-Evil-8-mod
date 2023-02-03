package com.joy187.re8joymod.common.items;


import com.joy187.re8joymod.common.entity.EntityMoreauProjectile;
import com.joy187.re8joymod.helper.CommonFunctions;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ItemCrystalHammer extends AxeItem {

    //private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    //public static final int THROW_THRESHOLD_TIME = 10;
    //public static final float BASE_DAMAGE = 45.0F;
    //public static final float SHOOT_POWER = 3.5F;
    //public float DURA = 10.0F;

//	public ItemCrystalHammer() {
//        super(new Item.Properties().tab(Main.TUTORIAL_TAB).stacksTo(1));
//        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
//        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 45.0D, AttributeModifier.Operation.ADDITION));
//        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-2.9F, AttributeModifier.Operation.ADDITION));
//        this.defaultModifiers = builder.build();
//	}

    public ItemCrystalHammer(IItemTier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    public boolean canAttackBlock(BlockState p_43409_, World p_43410_, BlockPos p_43411_, PlayerEntity p_43412_) {
        return !p_43412_.isCreative();
    }

    public UseAction getUseActionation(ItemStack p_43417_) {
        return UseAction.SPEAR;
    }

    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }

    public void releaseUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) p_43396_;
            int i = this.getUseDuration(p_43394_) - p_43397_;
            if (i >= 10) {
                int j = EnchantmentHelper.getRiptide(p_43394_);
                if (j <= 0 || player.isInWaterOrRain()) {
                    if (!p_43395_.isClientSide) {
                        p_43394_.hurtAndBreak(10, player, (p_43388_) -> {
                            p_43388_.broadcastBreakEvent(p_43396_.getUsedItemHand());
                        });
                        if (j == 0) {
                            //ThrownTrident throwntrident = new ThrownTrident(p_43395_, player, p_43394_);
                            EntityMoreauProjectile throwntrident = new EntityMoreauProjectile(p_43395_, player);
                            throwntrident.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 2.5F + (float) j * 0.5F, 1.0F);
//		                     if (player.getAbilities().instabuild) {
//		                        throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
//		                     }

                            p_43395_.addFreshEntity(throwntrident);
                            p_43395_.playSound((PlayerEntity) null, throwntrident, SoundEvents.TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
//		                     if (!player.getAbilities().instabuild) {
//		                        player.getInventory().removeItem(p_43394_);
//		                     }
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (j > 0) {
                        float f7 = player.yRot;
                        float f = player.xRot;
                        float f1 = -MathHelper.sin(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                        float f2 = -MathHelper.sin(f * ((float) Math.PI / 180F));
                        float f3 = MathHelper.cos(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                        float f4 = MathHelper.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                        float f5 = 3.0F * ((1.0F + (float) j) / 4.0F);
                        f1 *= f5 / f4;
                        f2 *= f5 / f4;
                        f3 *= f5 / f4;
                        player.push((double) f1, (double) f2, (double) f3);
                        player.startAutoSpinAttack(20);
                        if (player.isOnGround()) {
                            float f6 = 1.1999999F;
                            player.move(MoverType.SELF, new Vector3d(0.0D, (double) 1.1999999F, 0.0D));
                        }

                        SoundEvent soundevent;
                        if (j >= 3) {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_3;
                        } else if (j == 2) {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_2;
                        } else {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_1;
                        }

                        p_43395_.playSound((PlayerEntity) null, player, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }

    //
    public ActionResultType useOn(ItemUseContext p_41297_) {
        PlayerEntity player = p_41297_.getPlayer();
        World level = p_41297_.getLevel();
        BlockPos blockpos = p_41297_.getClickedPos();

        BlockState blockstate = level.getBlockState(blockpos);
        if (!CampfireBlock.canLight(blockstate)) {
            BlockPos blockpos1 = blockpos.relative(p_41297_.getClickedFace());
            if (AbstractFireBlock.canBePlacedAt(level, blockpos1, p_41297_.getHorizontalDirection())) {
                level.playSound(player, blockpos1, SoundEvents.SMOKER_SMOKE, SoundCategory.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
                //BlockState blockstate1 = BaseFireBlock.getState(level, blockpos1);
                //level.setBlock(blockpos1, blockstate1, 11);
                //level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
                for (float i = 1; i <= 3; i += 0.5)
                    CommonFunctions.spawnHexAround(ParticleTypes.CRIMSON_SPORE, level, blockpos, i);
                level.explode((Entity) null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), (float) 1, true, Explosion.Mode.DESTROY);

                ItemStack itemstack = p_41297_.getItemInHand();
                if (player instanceof ServerPlayerEntity) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) player, blockpos1, itemstack);
                    itemstack.hurtAndBreak(2, player, (p_41300_) -> {
                        p_41300_.broadcastBreakEvent(p_41297_.getHand());
                    });
                }
//		              if(this.DURA<=0) {
//		            	  itemstack.shrink(1);
//		              }
                return ActionResultType.sidedSuccess(level.isClientSide());
            } else {
                return ActionResultType.FAIL;
            }
        } else {
            level.playSound(player, blockpos, SoundEvents.SMOKER_SMOKE, SoundCategory.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
            //level.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
            //level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
            if (player != null) {
                p_41297_.getItemInHand().hurtAndBreak(0, player, (p_41303_) -> {
                    p_41303_.broadcastBreakEvent(p_41297_.getHand());
                });
            }

            return ActionResultType.sidedSuccess(level.isClientSide());
        }
    }

    public ActionResult<ItemStack> use(World p_43405_, PlayerEntity p_43406_, Hand p_43407_) {
        ItemStack itemstack = p_43406_.getItemInHand(p_43407_);
        if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
            return ActionResult.fail(itemstack);
        } else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !p_43406_.isInWaterOrRain()) {
            return ActionResult.fail(itemstack);
        } else {
            p_43406_.startUsingItem(p_43407_);

            return ActionResult.consume(itemstack);
        }
    }

    public boolean hurtEnemy(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
        p_43390_.hurtAndBreak(1, p_43392_, (p_43414_) -> {
            p_43414_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack p_43399_, World p_43400_, BlockState p_43401_, BlockPos p_43402_, LivingEntity p_43403_) {
        if ((double) p_43401_.getDestroySpeed(p_43400_, p_43402_) != 0.0D) {
            p_43399_.hurtAndBreak(2, p_43403_, (p_43385_) -> {
                p_43385_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }
}