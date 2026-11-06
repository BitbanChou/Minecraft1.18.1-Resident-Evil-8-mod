package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.ParticleInit;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class EntityElg extends EntityU3{

    private int attr = 0, attackTimer=0;
    private boolean zuan=false;
    public EntityElg(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.attackTimer=0;
        this.zuan=false;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 450.0D).
                add(Attributes.MOVEMENT_SPEED, 0.15D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 1.0D).
                add(Attributes.ARMOR_TOUGHNESS, 2.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.75D).
                add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    @Override
    protected void registerGoals() {
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        //this.goalSelector.addGoal(1, new AttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
//        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    private static final Predicate<Entity> ELG_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityElg);
    };

//    static class AttackGoal extends Goal {
//        private final EntityElg parentEntity;
//        protected int attackTimer = 0;
//        protected boolean zuan = false;
//
//        public AttackGoal(EntityElg ghast) {
//            this.parentEntity = ghast;
//        }
//
//        public boolean canUse() {
//            return this.parentEntity.getTarget() != null;
//        }
//
//        public void start() {
//            super.start();
//            this.parentEntity.setAggressive(true);
//        }
//
//        @Override
//        public void stop() {
//            super.stop();
//            this.parentEntity.setAggressive(false);
//            this.parentEntity.setAttackingState(0);
//            this.attackTimer = -1;
//            this.zuan = false;
//        }
//
//        public void tick() {
//            LivingEntity livingentity = this.parentEntity.getTarget();
//            if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
//                Level world = this.parentEntity.level();
//                ++this.attackTimer;
//                Random rand = new Random();
//                Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
//                double d0 = Math.min(livingentity.getY(), livingentity.getY());
//                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
//                double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
//                double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
//                double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
//                float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
//                        livingentity.getX() - parentEntity.getX());
//                this.parentEntity.attr=this.attackTimer;
//                this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
//                if((this.parentEntity.getHealth() > 350 && this.parentEntity.getHealth()<380) ||
//                        (this.parentEntity.getHealth() > 230 && this.parentEntity.getHealth()<240) ||
//                        (this.parentEntity.getHealth() > 150 && this.parentEntity.getHealth()<160) ||
//                        (this.parentEntity.getHealth() > 60 && this.parentEntity.getHealth()<70)){
//                    if(!this.zuan)
//                    {
//                        this.parentEntity.setDeltaMovement(vector3d);
//                        this.zuan=true;
//                    }
//                }
//                else{
//                    if (this.attackTimer==20) {
//                        if(this.parentEntity.getHealth() < 5 || this.parentEntity.getHealth() > 420 ||
//                                (this.parentEntity.getHealth() > 370 && this.parentEntity.getHealth()<400) ||
//                                (this.parentEntity.getHealth() > 320 && this.parentEntity.getHealth()<340) ||
//                                (this.parentEntity.getHealth() > 270 && this.parentEntity.getHealth()<300) ||
//                                (this.parentEntity.getHealth() > 170 && this.parentEntity.getHealth()<200) ||
//                                (this.parentEntity.getHealth() > 120 && this.parentEntity.getHealth()<130) ||
//                                (this.parentEntity.getHealth() > 90 && this.parentEntity.getHealth()<101) ||
//                                (this.parentEntity.getHealth() > 70 && this.parentEntity.getHealth()<75) ||
//                                (this.parentEntity.getHealth() > 26 && this.parentEntity.getHealth()<35) ||
//                                (this.parentEntity.getHealth() > 10 && this.parentEntity.getHealth()<18))
//                        {
//                            this.parentEntity.setAttackingState(3);
//
//                        }
//                        else{
//                            this.parentEntity.setAttackingState(2);
//                            if (!livingentity.hasPassenger(this.parentEntity) && !(livingentity instanceof EnderDragon)
//                                    && livingentity.getBbWidth() < 1.81F){
//                                livingentity.stopRiding();
//                                livingentity.startRiding(this.parentEntity, true);
//                            }
//                        }
//                    }
//                    else if(this.attackTimer==45){
//                        if(this.parentEntity.getAttckingState()==3)
//                        {
//                            for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(1.0D), ELG_AREA)) {
//                                lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity),lvt.getMaxHealth()*0.25f);
//                            }
//                        }
//
//                    }
//                    else if(this.attackTimer==30){
//                        if(this.parentEntity.getAttckingState()==2){
//                            for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(0.5D), ELG_AREA)) {
//                                double d00 = lvt.getX() - this.parentEntity.getX();
//                                double d10 = lvt.getZ() - this.parentEntity.getZ();
//                                double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
//                                lvt.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
//                                lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity),lvt.getArmorValue()+lvt.getMaxHealth()*0.15f);
//                            }
//                        }
//                        this.parentEntity.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), this.parentEntity.getRandomX(0.5), this.parentEntity.getRandomY(), this.parentEntity.getRandomZ(0.5), 0.0, 0.0, 0.0);
//
//                    }
//                    else if(this.attackTimer == 1){
//                        this.parentEntity.setAttackingState(1);
//                        this.parentEntity.setDeltaMovement(0,1+this.parentEntity.random.nextDouble(),0);
//                    }
//                }
//
//                if(this.attackTimer==18 && this.parentEntity.getAttckingState()==1){
//                    for(int l = 1; l < 10; l++)
//                    {
//                        this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -2.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 4.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 5.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -5.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 6.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -6.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 7.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -7.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 8.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -8.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 9.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -9.5F, 150, 1.5F, 0.15F, 1.0F);
//                    }
////                    this.parentEntity.level().addFreshEntity(new EntityCameraShake(this.parentEntity.level(),new Vec3(this.parentEntity.getX(),this.parentEntity.getY(),this.parentEntity.getZ()),
////                            35.0f, 0.1f, 10, 10));
//                    EntityCameraShake.ScreenShake(this.parentEntity.level(), new Vec3(this.parentEntity.getX(),this.parentEntity.getY(),this.parentEntity.getZ()), 30.0f, 0.15f, 0, 50);
//                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(1.1D), ELG_AREA)) {
//                        double d00 = lvt.getX() - this.parentEntity.getX();
//                        double d10 = lvt.getZ() - this.parentEntity.getZ();
//                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
//                        lvt.getDeltaMovement().add(d00*0.2D,d20+rand.nextDouble(),d10*0.2D);
//                    }
//                }
//
//                if (this.attackTimer == 46) {
//                    this.zuan=false;
//                    this.parentEntity.setAttackingState(0);
//                    this.attackTimer = -5;
//                }
//            }
//            else if (this.attackTimer > 0) {
//                --this.attackTimer;
//            }
//            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//        }
//
//    }

    @Override
    public void tick() {
        super.tick();

        // 模拟 canUse 逻辑
        if (this.getTarget() != null) {
            // 模拟 start 逻辑
            this.setAggressive(true);

            LivingEntity livingentity = this.getTarget();
            if (livingentity != null && this.hasLineOfSight(livingentity)) {
                Level world = this.level();
                ++this.attackTimer;
                Random rand = new Random();
                Vec3 vector3d = this.getViewVector(1.0F);
                double d0 = Math.min(livingentity.getY(), livingentity.getY());
                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                double d2 = livingentity.getX() - (this.getX() + vector3d.x * 2.0D);
                double d3 = livingentity.getY(0.5D) - (0.5D + this.getY(0.5D));
                double d4 = livingentity.getZ() - (this.getZ() + vector3d.z * 2.0D);
                float f = (float) Mth.atan2(livingentity.getZ() - this.getZ(),
                        livingentity.getX() - this.getX());
                this.attr = this.attackTimer;
                this.getNavigation().moveTo(livingentity, 1.5D);

                // 根据随机数决定是否执行钻地动作
                if (rand.nextInt(100) < 20 && !this.zuan) { // 20% 的概率执行钻地动作
                    this.setDeltaMovement(vector3d);
                    this.zuan = false;
                } else {
                    if (this.attackTimer == 20) {
                        // 根据随机数选择攻击状态
                        if (rand.nextInt(100) < 50) { // 50% 的概率选择攻击状态 3
                            this.setAttackingState(3);
                            attackAnimationState3.start(this.tickCount);
                        } else {
                            this.setAttackingState(2);
                            attackAnimationState2.start(this.tickCount);
                            if (!livingentity.hasPassenger(this) && !(livingentity instanceof EnderDragon)
                                    && livingentity.getBbWidth() < 1.81F) {
                                livingentity.stopRiding();
                                livingentity.startRiding(this, true);
                            }
                        }
                    } else if (this.attackTimer == 45) {
                        if (this.getAttckingState() == 3) {
                            for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.0D), ELG_AREA)) {
                                lvt.hurt(lvt.damageSources().mobAttack(this), lvt.getMaxHealth() * 0.25f);
                            }
                        }
                    } else if (this.attackTimer == 30) {
                        if (this.getAttckingState() == 2) {
                            for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.5D), ELG_AREA)) {
                                double d00 = lvt.getX() - this.getX();
                                double d10 = lvt.getZ() - this.getZ();
                                double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                                lvt.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
                                lvt.hurt(lvt.damageSources().mobAttack(this), lvt.getArmorValue() + lvt.getMaxHealth() * 0.15f);
                            }
                        }
                        this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
                    } else if (this.attackTimer == 1) {
                        this.setAttackingState(1);
                        attackAnimationState.start(this.tickCount);
                        this.setDeltaMovement(0, 1 + this.random.nextDouble(), 0);
                    }
                }

                if (this.attackTimer == 18 && this.getAttckingState() == 1) {
                    for (int l = 1; l < 10; l++) {
                        this.blockSmashAttack(l, 3F, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -2.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 4.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 5.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -5.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 6.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -6.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 7.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -7.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 8.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -8.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 9.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -9.5F, 150, 1.5F, 0.15F, 1.0F);
                    }
                    EntityCameraShake.ScreenShake(this.level(), new Vec3(this.getX(), this.getY(), this.getZ()), 30.0f, 0.15f, 0, 50);
                    for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.1D), ELG_AREA)) {
                        double d00 = lvt.getX() - this.getX();
                        double d10 = lvt.getZ() - this.getZ();
                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                        lvt.getDeltaMovement().add(d00 * 0.2D, d20 + rand.nextDouble(), d10 * 0.2D);
                    }
                }

//                if (this.attackTimer == 46) {
//                    this.zuan = false;
//                    this.setAttackingState(0);
//                    this.attackTimer = -5;
//                }
                this.lookAt(livingentity, 30.0F, 30.0F);

            }
//            else if (this.attackTimer > 0) {
//                --this.attackTimer;
//            }
        }

        if (this.attackTimer >= 80) {
            this.setAttackingState(0);
            this.attackTimer = -10;
            attackAnimationState.stop();
            attackAnimationState2.stop();
            attackAnimationState3.stop();
            this.attr = 0;
            this.zuan=false;
        }
//        else {
//            // 模拟 stop 逻辑
//            this.setAggressive(false);
//            this.setAttackingState(0);
//            this.attackTimer = -1;
//            this.zuan = false;
//        }
    }


    public void aiStep() {
        super.aiStep();
        this.hurt(this.level().getEntities(this, this.getBoundingBox().inflate(0.6D), EntitySelector.NO_CREATIVE_OR_SPECTATOR));
        if (this.entityData.get(STATE)==2) {
            this.roar();
        }

    }

    private void roar() {
        if (this.isAlive()) {
            Vec3 vec3 = this.getBoundingBox().getCenter();

//           for(int i = 0; i < 40; ++i) {
//              double d0 = this.random.nextGaussian() * 0.2D;
//              double d1 = this.random.nextGaussian() * 0.2D;
//              double d2 = this.random.nextGaussian() * 0.2D;
//              this.level().addParticle(ParticleTypes.DRIPPING_LAVA, vec3.x, vec3.y, vec3.z, d0, d1, d2);
//           }
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y , vec3.z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
            }
            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

    }

    private void hurt(List<Entity> p_70971_1_) {
        for(Entity entity : p_70971_1_) {
            if (entity instanceof LivingEntity) {
                entity.hurt(damageSources().mobAttack(this), 4.0F*random.nextFloat());
                this.doEnchantDamageEffects(this, entity);
                if(random.nextInt(10)>8)
                {
                    this.heal(random.nextFloat()*2);
                }
            }
        }
    }

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double)mxy;
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double extraX = (float)distance * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = (float)distance * Mth.cos((float)angle);
        double px = this.getX() + extraX + (double)(f * math);
        double pz = this.getZ() + extraZ + (double)(f1 * math);
        int hitX = Mth.floor((double)px);
        int hitZ = Mth.floor((double)pz);
        BlockPos pos = new BlockPos(hitX, hitY, hitZ);
        BlockPos abovePos = new BlockPos(pos).above();
        BlockState block = this.level().getBlockState(pos);
        BlockState blockAbove = this.level().getBlockState(abovePos);
        if (block.getBlock() != Blocks.AIR && !block.hasBlockEntity() && !blockAbove.blocksMotion()) {
            EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, block, 10);
            fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
            this.level().addFreshEntity(fallingBlockEntity);
            if (!this.level().isClientSide && block.getBlock() != Blocks.BEDROCK) {
//                if (CMConfig.IgnisBlockBreaking) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
//                else if (ForgeEventFactory.getMobGriefingEvent((Level)this.level(), (Entity)this)) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
            }
        }
        AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
        List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        for (Object entity : hit) {
            if(entity instanceof LivingEntity)
            {
                if (this.isAlliedTo((LivingEntity)entity) || entity instanceof EntityHeisen || (LivingEntity)entity == this) continue;
                if (entity instanceof Player && ((Player)entity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK) && shieldbreakticks > 0) {
                    this.disableShield((LivingEntity)entity, shieldbreakticks);
                }
                else{
                    boolean flag = ((LivingEntity)entity).hurt(damageSources().mobAttack(this), (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + (double)(((LivingEntity)entity).getMaxHealth() * hpdamage)));
                    if(flag)
                        ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(0.0, (double)airborne + 0.5, 0.0));
                }

            }
        }

    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(5+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }

}
