package com.joy187.re8joymod.items;


import com.joy187.re8joymod.entity.EntityChief;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.ItemInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PacketDistributor;


import java.util.Random;
import java.util.function.Predicate;

public class ItemTenta extends ItemUrias{

    public ItemTenta(Tier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }
    
    private static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof Player);
    };
    
    public InteractionResultHolder<ItemStack> use(Level p_41290_, Player p_41291_, InteractionHand p_41292_) {
        ItemStack itemstack = p_41291_.getMainHandItem();
        if(!p_41291_.getCooldowns().isOnCooldown(itemstack.getItem())) {

            for (LivingEntity livingentity : p_41291_.level().getEntitiesOfClass(LivingEntity.class, p_41291_.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                Vec3 vec3 = p_41291_.position().add(0.0D, (double)1.6F, 0.0D);
                Vec3 vec31 = livingentity.getEyePosition().subtract(vec3);
                Vec3 vec32 = vec31.normalize();

                for(int i = 1; i < Mth.floor(vec31.length()) + 7; ++i) {
                    Vec3 vec33 = vec3.add(vec32.scale((double)i));
                }

                p_41291_.playSound(SoundEvents.SOUL_ESCAPE, 3.0F, 1.0F);
                if(livingentity instanceof IronGolem)
                    livingentity.hurt(p_41291_.damageSources().mobAttack(p_41291_), livingentity.getHealth()*0.25F);
                else
                    livingentity.hurt(p_41291_.damageSources().mobAttack(p_41291_), 5.0F);
                double d1 = 0.25D * (1.0D - livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                double d0 = 1.5D * (1.0D - livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                livingentity.push(-vec32.x() * d0, vec32.y() * d1, -vec32.z() * d0);
            }

            p_41291_.getCooldowns().addCooldown(this,100);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, p_41290_.isClientSide());
    }

    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        Random ran = new Random();

        if(ran.nextInt(5)==1){
            target.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(),300,0,true,true));
        }

        return true;
    }

}
