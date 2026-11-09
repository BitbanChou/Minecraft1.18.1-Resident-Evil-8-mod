package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;

public class EntityPlagasArmadura extends EntityArmadura implements GeoEntity {
    private static final float TENTA_RANGE = 4.2F;
    private static final float TENTA_HALF_ANGLE = 55.0F;
    private static final int PLAGAS_DEBUFF_TICKS = 100; // 5 seconds

    private int normalAttacksSinceSpecial = 0;
    private int specialAfter = 4;

    public EntityPlagasArmadura(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.rollNextSpecialGate();
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 45.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.14D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.ATTACK_DAMAGE, 14.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    protected void customServerAiStep() {
        // Do not transform into PlagasVillager like base Armadura.
    }

    @Override
    protected String animWalk() {
        return "animation.plagasarmadura.walk";
    }

    @Override
    protected String animIdle() {
        return "animation.plagasarmadura.idle";
    }

    @Override
    protected String animAttack() {
        return "animation.plagasarmadura.attack";
    }

    @Override
    protected String animAttack2() {
        return "animation.plagasarmadura.attack2";
    }

    @Override
    protected String animSpecialAttack() {
        return "animation.plagasarmadura.tenta_attack";
    }

    @Override
    protected int pickAttackState() {
        if (this.normalAttacksSinceSpecial >= this.specialAfter) {
            return 3;
        }
        return super.pickAttackState();
    }

    @Override
    protected int attackDurationTicks(int state) {
        // tenta_attack animation_length = 1.6s
        return state == 3 ? 32 : super.attackDurationTicks(state);
    }

    @Override
    protected int attackHitTick(int state) {
        // Violent peaks: attack2 @0.9s, attack/tenta stab @1.0s
        if (state == 2) {
            return 18;
        }
        if (state == 1 || state == 3) {
            return 20;
        }
        return super.attackHitTick(state);
    }

    @Override
    protected void onAttackHit(LivingEntity target, int state, float baseDamage) {
        if (state == 3) {
            this.dealTentaHit(target, baseDamage * 1.35F);
            this.playSound(SoundEvents.PLAYER_ATTACK_CRIT, 1.25F, 0.7F);
            this.playSound(SoundEvents.SPIDER_HURT, 0.9F, 0.55F);
            return;
        }
        super.onAttackHit(target, state, baseDamage);
    }

    @Override
    protected void onAttackFinished(int state) {
        if (state == 3) {
            this.normalAttacksSinceSpecial = 0;
            this.rollNextSpecialGate();
        } else if (state == 1 || state == 2) {
            this.normalAttacksSinceSpecial++;
        }
    }

    private void rollNextSpecialGate() {
        this.specialAfter = 3 + this.random.nextInt(3); // 3, 4, or 5
    }

    private void dealTentaHit(LivingEntity prefer, float damage) {
        AABB box = this.getBoundingBox().inflate(TENTA_RANGE);
        for (LivingEntity e : this.level().getEntitiesOfClass(LivingEntity.class, box, ARMA_AREA)) {
            if (e == this || this.isAlliedTo(e)) {
                continue;
            }
            if (this.distanceTo(e) > TENTA_RANGE + 0.5F) {
                continue;
            }
            if (!this.inFrontCone(e, TENTA_HALF_ANGLE)) {
                continue;
            }
            e.hurt(this.damageSources().mobAttack(this), damage);
            e.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), PLAGAS_DEBUFF_TICKS, 0, false, true));
            if (e == prefer || e instanceof Player) {
                Vec3 push = this.getLookAngle();
                e.knockback(0.85F, -push.x, -push.z);
            }
        }
        this.spawnTentaParticles();
    }

    private void spawnTentaParticles() {
        if (!(this.level() instanceof ServerLevel server)) {
            return;
        }
        float yawRad = this.getYRot() * ((float) Math.PI / 180.0F);
        double baseY = this.getY() + 1.35D;
        for (int i = 0; i <= 10; i++) {
            float offsetDeg = -TENTA_HALF_ANGLE + (TENTA_HALF_ANGLE * 2.0F * i / 10.0F);
            float rad = yawRad + offsetDeg * ((float) Math.PI / 180.0F);
            for (float r : new float[]{1.8F, 2.8F, 3.8F}) {
                double x = this.getX() - Mth.sin(rad) * r;
                double z = this.getZ() + Mth.cos(rad) * r;
                server.sendParticles(ParticleTypes.CRIT, x, baseY, z, 2, 0.08D, 0.08D, 0.08D, 0.03D);
                if (i % 2 == 0) {
                    server.sendParticles(ParticleTypes.DAMAGE_INDICATOR, x, baseY + 0.15D, z, 1, 0.02D, 0.05D, 0.02D, 0.0D);
                }
            }
        }
    }
}
