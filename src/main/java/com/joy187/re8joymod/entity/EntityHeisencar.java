package com.joy187.re8joymod.entity;

import java.util.List;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.common.Tags;

import static net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE;

public class EntityHeisencar extends Horse {

    public int time;
    public int shootingCooldown = 75;

    public EntityHeisencar(EntityType<? extends EntityHeisencar> p_i50250_1_, Level p_i50250_2_) {
        super(p_i50250_1_, p_i50250_2_);
    }

//    public EntityHeisencar(World worldIn, double x, double y, double z) {
//        //this(EntityInit.HEISENCAR.get(), worldIn);
//        this.setPos(x, y, z);
//        this.setDeltaMovement(Vector3d.ZERO);
//        this.xo = x;
//        this.yo = y;
//        this.zo = z;
//    }
    public void aiStep() {
        super.aiStep();
        this.hurt(this.level().getEntities(this, this.getBoundingBox().inflate(1.0D), EntitySelector.NO_CREATIVE_OR_SPECTATOR));

    }

    @Override
    public boolean startRiding(Entity p_21396_, boolean p_21397_) {
        this.time = 0;
        return super.startRiding(p_21396_, p_21397_);
    }

    protected void registerGoals() {
        //this.goalSelector.addGoal(7, new LookAtGoal(this, Player.class, 6.0F));
        this.addBehaviourGoals();
    }

    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.JUMP_STRENGTH,0.2D);
    }

    @Override
    public void tick()
    {
        super.tick();
        if (time < shootingCooldown) time++;

        //for (var ability : getBreed().abilities()) ability.tick(this);
    }

//    @Override
//    public boolean canBeControlledByRider() {
//        Entity entity = this.getControllingPassenger();
//        if (!(entity instanceof Player)) {
//            return false;
//        } else {
//            Player Player = (Player)entity;
//            return true;
//        }
//    }

    @Override
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        if (entity instanceof LivingEntity) {
            return (LivingEntity)entity;
        }
        return null;
    }

    public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {

        this.doPlayerRide(p_230254_1_);
        return InteractionResult.sidedSuccess(this.level().isClientSide);
    }

    @Override
    public void travel(Vec3 p_213352_1_) {
        if (this.isAlive()) {
            LivingEntity living = this.getControllingPassenger();
            if (this.isVehicle() && living!=null) {
                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                    this.gallopSoundCounter = 0;
                }

                if (this.onGround() && this.playerJumpPendingScale == 0.0F && this.isStanding()) {
                    f = 0.0F;
                    f1 = 0.0F;
                }

                if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround()) {
                    double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
                    double d1;
                    if (this.hasEffect(MobEffects.JUMP)) {
                        d1 = d0 + (double)((float)(this.getEffect(MobEffects.JUMP).getAmplifier() + 1) * 0.1F);
                    } else {
                        d1 = d0;
                    }

                    Vec3 vector3d = this.getDeltaMovement();
                    this.setDeltaMovement(vector3d.x, d1, vector3d.z);
                    this.setIsJumping(true);
                    if(this.isJumping){
                          this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1,true,true));
                          this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1,true,true));
                          this.addEffect(new MobEffectInstance(MobEffects.HEAL, 20, 3));
//                          livingentity.addEffect(new EffectInstance(Effects.HEAL, 20, 4));

                          this.level().explode((Entity)null, this.getX()+5-random.nextInt(2), this.getY()+1, this.getZ()+5-random.nextInt(2), (float)1, true, Level.ExplosionInteraction.BLOCK);
                          this.level().explode((Entity)null, this.getX()-5+random.nextInt(2), this.getY()+1, this.getZ()-5+random.nextInt(2), (float)1, true, Level.ExplosionInteraction.BLOCK);
                          this.level().explode((Entity)null, this.getX()+5-random.nextInt(2), this.getY()+1, this.getZ()-5+random.nextInt(2), (float)1, true, Level.ExplosionInteraction.BLOCK);
                          this.level().explode((Entity)null, this.getX()-5+random.nextInt(2), this.getY()+1, this.getZ()+5-random.nextInt(2), (float)1, true, Level.ExplosionInteraction.BLOCK);

                          //                        System.out.println("yes");
                    }
                    this.hasImpulse = true;
                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
//                    if (f1 > 0.0F) {
//                        float f2 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F));
//                        float f3 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F));
//                        this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
//                    }

                    this.playerJumpPendingScale = 0.0F;
                }

                //this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3((double)f, p_213352_1_.y, (double)f1));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(Vec3.ZERO);
                }

                if (this.onGround()) {
                    this.playerJumpPendingScale = 0.0F;
                    this.setIsJumping(false);
                }

                this.calculateEntityAnimation(false);
            } else {
                //this.flyingSpeed = 0.02F;
                super.travel(p_213352_1_);
            }
        }
    }

    protected void playGallopSound(SoundType p_190680_1_) {
        super.playGallopSound(p_190680_1_);
//        if (this.random.nextInt(2) > -1) {
            this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
//        }

        ItemStack stack = this.inventory.getItem(1);
        if (isArmor(stack)) stack.onHorseArmorTick(level(), this);
    }

    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundInit.ENTITY_HEISENCAR_FIRING.get();
    }

    protected SoundEvent getAngrySound() {
        super.getAngrySound();
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    @Nullable
    protected SoundEvent getEatingSound() {
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        super.getHurtSound(p_184601_1_);
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        if (!(p_180429_2_.getBlock() instanceof LiquidBlock)) {
            BlockState blockstate = this.level().getBlockState(p_180429_1_.above());
            SoundType soundtype = p_180429_2_.getSoundType(level(), p_180429_1_, this);
            if (blockstate.is(Blocks.SNOW)) {
                soundtype = blockstate.getSoundType(level(), p_180429_1_, this);
            }

            if (this.isVehicle() && this.canGallop) {
                ++this.gallopSoundCounter;
                if (this.gallopSoundCounter > 5 && this.gallopSoundCounter % 3 == 0) {
                    this.playGallopSound(soundtype);
                } else if (this.gallopSoundCounter <= 5) {
                    this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
                }
            } else if (soundtype == SoundType.WOOD) {
                this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
            } else {
                this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }

        }
    }

    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        if (p_225503_1_ > 1.0F) {
            this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), 0.4F, 1.0F);
        }

        int i = this.calculateFallDamage(p_225503_1_, p_225503_2_);
        if (i <= 0) {
            return false;
        } else {
            this.hurt(damageSources().fall(), (float)i);
            if (this.isVehicle()) {
                for(Entity entity : this.getIndirectPassengers()) {
                    entity.hurt(damageSources().fall(), (float)i);
                }
            }

            this.playBlockFallSound();
            return true;
        }
    }

    protected void playJumpSound() {
        this.playSound(SoundInit.ENTITY_HEISENCAR_FIRING.get(), 0.4F, 1.0F);
    }

    public float getSteeringSpeed() {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 1.15F;
    }

    public boolean canJump() {
        return true;
    }

    @Override
    public boolean isTamed() {
        return true;
    }

    @Override
    public boolean isSaddled() {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void onPlayerJump(int p_110206_1_) {
//            if (p_110206_1_ < 0) {
//                p_110206_1_ = 0;
//            }
//
//            if (p_110206_1_ >= 0) {
//                this.playerJumpPendingScale = 1.0F;
//
//            } else {
                this.playerJumpPendingScale = 0.4F + 0.4F * (float)p_110206_1_ / 90.0F;
//            }
    }

    private void hurt(List<Entity> p_70971_1_) {
        for(Entity entity : p_70971_1_) {
            if (entity instanceof LivingEntity) {
                if(!(entity instanceof Player)) {
                    entity.hurt(damageSources().mobAttack(this), 8.0F);
                    this.doEnchantDamageEffects(this, entity);
                    if(random.nextInt(10)>8)
                    {
                        this.heal(random.nextFloat()*2);
                    }
//                    double d0 = (this.getBoundingBox().minX + this.getBoundingBox().maxX) / 2.0D;
//                    double d1 = (this.getBoundingBox().minZ + this.getBoundingBox().maxZ) / 2.0D;
//                    double d2 = entity.getX() - d0;
//                    double d3 = entity.getZ() - d1;
//                    double d4 = Math.max(d2 * d2 + d3 * d3, 0.1D);
//                    entity.push(d2 / d4 * 4.0D, (double)0.5F, d3 / d4 * 4.0D);
                }
            }
        }
    }

    public boolean shoot(Player player, EntityHeisencar heli, Level world) {
        Player playerEntity = (Player) player;
        ItemStack itemStack = new ItemStack(ItemInit.HIGHEX.get());
        EntityHeisencar tankEntity = (EntityHeisencar) heli;
//        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
//            ItemStack stack = playerEntity.getInventory().offhand.get(i);
//            if (stack.getCount() >= shellsUsed) {
//                itemStack = stack;
//                break;
//            }
//            player.displayClientMessage(Component.literal("You don't have any ammo!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
//        }
        if (this.time < this.shootingCooldown) {
            player.displayClientMessage(Component.literal("Reloading " + (shootingCooldown - time) / 20 + " s !").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
//        if (itemStack.is(ItemInit.MOPRO.get())) {
        else{
            player.displayClientMessage(Component.literal("Fire!").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD), false);
            Vec3 vec3 = this.getBoundingBox().getCenter();
            for (int i = 0; i < 3; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y , vec3.z + 1 * Math.cos(0 + deltaOmega));
                this.level().addParticle(ParticleTypes.LARGE_SMOKE, pos.x, pos.y, pos.z, 0,0,0);
                EntityHighEx bomb = new EntityHighEx(level(), player,0);
                bomb.setItem(itemStack);
                bomb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level().addFreshEntity(bomb);
            }
        }


//        ThrownTrident throwntrident = new ThrownTrident(world, player, new ItemStack(ItemInit.VTRIDENT.get()).copy());
//            //ThrownTrident throwntrident = new ThrownTrident(p_43395_, player);
//            throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
//            world.addFreshEntity(throwntrident);
//            System.out.println("shoot!");
//            Fire shellEntity = new ItemEntity(heli, world);
//            shellEntity.shootFromRotation(tankEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, 3.5F, 0F);
//            world.addFreshEntity(shellEntity);
//            itemStack.shrink(shellsUsed);
//        }
        time = 0;
        return true;
    }

}