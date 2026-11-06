package com.joy187.re8joymod.items;

import java.util.Optional;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityGM79B;
import com.joy187.re8joymod.entity.EntityMoreauProjectile;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class ItemCrystalHammer extends AxeItem{
	
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
	
    public ItemCrystalHammer(Tier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }
    
	public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
		      return !p_43412_.isCreative();
		   }

	public UseAnim getUseAnimation(ItemStack p_43417_) {
		return UseAnim.SPEAR;
	}

		   public int getUseDuration(ItemStack p_43419_) {
		      return 72000;
		   }

		   public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
		      if (p_43396_ instanceof Player) {
		         Player player = (Player)p_43396_;
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
		                	 throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)j * 0.5F, 1.0F);
//		                     if (player.getAbilities().instabuild) {
//		                        throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
//		                     }

		                     p_43395_.addFreshEntity(throwntrident);
		                     p_43395_.playSound((Player)null, throwntrident, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
//		                     if (!player.getAbilities().instabuild) {
//		                        player.getInventory().removeItem(p_43394_);
//		                     }
		                  }
		               }

		               player.awardStat(Stats.ITEM_USED.get(this));
		               if (j > 0) {
		                  float f7 = player.getYRot();
		                  float f = player.getXRot();
		                  float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
		                  float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
		                  float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
		                  float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
		                  float f5 = 3.0F * ((1.0F + (float)j) / 4.0F);
		                  f1 *= f5 / f4;
		                  f2 *= f5 / f4;
		                  f3 *= f5 / f4;
		                  player.push((double)f1, (double)f2, (double)f3);
		                  player.startAutoSpinAttack(20);
		                  if (player.onGround()) {
		                     float f6 = 1.1999999F;
		                     player.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));
		                  }

		                  SoundEvent soundevent;
		                  if (j >= 3) {
		                     soundevent = SoundEvents.TRIDENT_RIPTIDE_3;
		                  } else if (j == 2) {
		                     soundevent = SoundEvents.TRIDENT_RIPTIDE_2;
		                  } else {
		                     soundevent = SoundEvents.TRIDENT_RIPTIDE_1;
		                  }

		                  p_43395_.playSound((Player)null, player, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
		               }

		            }
		         }
		      }
		   }
//		   
		    public InteractionResult useOn(UseOnContext p_41297_) {
		        Player player = p_41297_.getPlayer();
		        Level level = p_41297_.getLevel();
		        BlockPos blockpos = p_41297_.getClickedPos();
		        
		        BlockState blockstate = level.getBlockState(blockpos);
		        if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
		           BlockPos blockpos1 = blockpos.relative(p_41297_.getClickedFace());
		           if (BaseFireBlock.canBePlacedAt(level, blockpos1, p_41297_.getHorizontalDirection())) {
		              level.playSound(player, blockpos1, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
		              //BlockState blockstate1 = BaseFireBlock.getState(level, blockpos1);
		              //level.setBlock(blockpos1, blockstate1, 11);
		              //level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
		          	  for(float i=1;i<=3;i+=0.5)
		        		CommonFunctions.spawnHexAround(ParticleTypes.CRIMSON_SPORE,level,blockpos,i);
		              level.explode((Entity)null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), (float)1, Level.ExplosionInteraction.BLOCK);


		              ItemStack itemstack = p_41297_.getItemInHand();
		              if (player instanceof ServerPlayer) {
		                 CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos1, itemstack);
		                 itemstack.hurtAndBreak(2, player, (p_41300_) -> {
		                    p_41300_.broadcastBreakEvent(p_41297_.getHand());
		                 });
		              }
//		              if(this.DURA<=0) {
//		            	  itemstack.shrink(1);
//		              }
		              return InteractionResult.sidedSuccess(level.isClientSide());
		           } else {
		              return InteractionResult.FAIL;
		           }
		        } else {
		           level.playSound(player, blockpos, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
		           //level.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
		           //level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
		           if (player != null) {
		              p_41297_.getItemInHand().hurtAndBreak(0, player, (p_41303_) -> {
		                 p_41303_.broadcastBreakEvent(p_41297_.getHand());
		              });
		           }

		           return InteractionResult.sidedSuccess(level.isClientSide());
		        }
		     }
		    
		   public InteractionResultHolder<ItemStack> use(Level p_43405_, Player p_43406_, InteractionHand p_43407_) {
		      ItemStack itemstack = p_43406_.getItemInHand(p_43407_);
		      if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
		         return InteractionResultHolder.fail(itemstack);
		      } else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !p_43406_.isInWaterOrRain()) {
		         return InteractionResultHolder.fail(itemstack);
		      } else {
		         p_43406_.startUsingItem(p_43407_);
		         
		         return InteractionResultHolder.consume(itemstack);
		      }
		   }

		   public boolean hurtEnemy(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
			   p_43390_.hurtAndBreak(1, p_43392_, (p_43414_) -> {
		         p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		      });
		      return true;
		   }

		   public boolean mineBlock(ItemStack p_43399_, Level p_43400_, BlockState p_43401_, BlockPos p_43402_, LivingEntity p_43403_) {
		      if ((double)p_43401_.getDestroySpeed(p_43400_, p_43402_) != 0.0D) {
		         p_43399_.hurtAndBreak(2, p_43403_, (p_43385_) -> {
		            p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		         });
		      }

		      return true;
		   }

//		   
//	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43383_) {
//		return p_43383_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43383_);
//	}
	
//    public boolean isFoil(ItemStack p_77636_1_) {
//    	if(this.DURA>900) {
//    		
//            for(int j=0;j<3;j++)
//            {
// 	           for (int i = 0; i < 10; i++)
// 	           {
// 	               float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
// 	               Vec3 pos = new Vec3(vec3.x + 3 * Math.sin(0 + deltaOmega),  vec3.y + j, vec3.z + 3 * Math.cos(0 + deltaOmega));
// 	               //this.level.spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
// 	               this.level.addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
// 	           }           	   
//            }
//        }
//    	return this.DURA<0;
//    }
    
//    public void inventoryTick(ItemStack p_40720_, Level p_40721_, Entity p_40722_, int p_40723_, boolean p_40724_) {
//        if (!p_40721_.isClientSide) {
//            Vec3 vec3 = p_40722_.getBoundingBox().getCenter();
//        	if(this.DURA<900) {
//        		
//                for(int j=0;j<3;j++)
//                {
//     	           for (int i = 0; i < 10; i++)
//     	           {
//     	               float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
//     	               Vec3 pos = new Vec3(vec3.x + 3 * Math.sin(0 + deltaOmega),  vec3.y + j, vec3.z + 3 * Math.cos(0 + deltaOmega));
//     	               //this.level.spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
//     	               p_40721_.addParticle(ParticleInit.MUCUS_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
//     	           }           	   
//                }
//            }
//        }
//     }
//	@Override
//	public Predicate<ItemStack> getAllSupportedProjectiles() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int getDefaultProjectileRange() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
}
