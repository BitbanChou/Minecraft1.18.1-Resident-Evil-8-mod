package com.joy187.re8joymod.common.entity;


//public class EntityObBoat extends BoatEntity {
//    private double lastYd;
//    private double waterWorld;
//    private float invFriction;
//    private BoatEntity.Status status;
//    private float landFriction;
//    private BoatEntity.Status oldStatus;
//    private float deltaRotation;
//
//    public EntityObBoat(EntityType<? extends EntityObBoat> entityType, World level) {
//        super(entityType, level);
//        this.blocksBuilding = true;
//    }
//
////    public EntityObBoat(World world, double x, double y, double z) {
////        this(EntityInit.OBBOAT.get(), world);
////        this.setPos(x, y, z);
////        this.setDeltaMovement(Vector3d.ZERO);
////        this.xo = x;
////        this.yo = y;
////        this.zo = z;
////    }
////
////    public EntityObBoat(World worldIn) {
////        this(EntityInit.OBBOAT.get(), worldIn);
////    }
//
//
//    @Override
//    public IPacket<?> getAddEntityPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
//
//    @Override
//    public float getWaterWorldAbove() {
//        AxisAlignedBB boundingBox = this.getBoundingBox();
//        int minX = MathHelper.floor(boundingBox.minX);
//        int maxX = MathHelper.ceil(boundingBox.maxX);
//        int maxY = MathHelper.floor(boundingBox.maxY);
//        int minY = MathHelper.ceil(boundingBox.maxY - this.lastYd);
//        int minZ = MathHelper.floor(boundingBox.minZ);
//        int maxZ = MathHelper.ceil(boundingBox.maxZ);
//        BlockPos.Mutable blockPos = new BlockPos.Mutable();
//
//        for(int y = maxY; y < minY; ++y) {
//            float f = 0.0F;
//            for(int x = minX; x < maxX; ++x) {
//                for(int z = minZ; z < maxZ; ++z) {
//                    blockPos.set(x, y, z);
//                    FluidState fluidstate = this.level.getFluidState(blockPos);
//                    if (fluidstate.is(FluidTags.LAVA)) {
//                        f = Math.max(f, fluidstate.getHeight(this.level, blockPos));
//                    }
//                }
//            }
//
//            if (f < 1.0F) {
//                return blockPos.getY() + f;
//            }
//        }
//
//        return minY + 1;
//    }
//
////    @Override
////    public boolean checkInWater() {
////        AxisAlignedBB axisalignedbb = this.getBoundingBox();
////        int minX = MathHelper.floor(axisalignedbb.minX);
////        int maxX = MathHelper.ceil(axisalignedbb.maxX);
////        int minY = MathHelper.floor(axisalignedbb.minY);
////        int maxY = MathHelper.ceil(axisalignedbb.minY + 0.001D);
////        int minZ = MathHelper.floor(axisalignedbb.minZ);
////        int maxZ = MathHelper.ceil(axisalignedbb.maxZ);
////        boolean flag = false;
////        this.waterWorld = Double.MIN_VALUE;
////        BlockPos.Mutable blockPos = new BlockPos.Mutable();
////
////        for(int x = minX; x < maxX; ++x) {
////            for(int y = minY; y < maxY; ++y) {
////                for(int z = minZ; z < maxZ; ++z) {
////                    blockPos.set(x, y, z);
////                    FluidState fluidstate = this.level.getFluidState(blockPos);
////                    if (fluidstate.is(FluidTags.LAVA)) {
////                        float f = y + fluidstate.getHeight(this.level, blockPos);
////                        this.waterWorld = Math.max(f, this.waterWorld);
////                        flag |= axisalignedbb.minY < f;
////                    }
////                }
////            }
////        }
////        return flag;
////    }
//
//    @Nullable
//    public BoatEntity.Status isUnderwater() {
//        AxisAlignedBB axisalignedbb = this.getBoundingBox();
//        double yOffset = axisalignedbb.maxY + 0.001D;
//        int i = MathHelper.floor(axisalignedbb.minX);
//        int j = MathHelper.ceil(axisalignedbb.maxX);
//        int k = MathHelper.floor(axisalignedbb.maxY);
//        int l = MathHelper.ceil(yOffset);
//        int i1 = MathHelper.floor(axisalignedbb.minZ);
//        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
//        boolean flag = false;
//        BlockPos.Mutable blockPos = new BlockPos.Mutable();
//
//        for(int k1 = i; k1 < j; ++k1) {
//            for(int l1 = k; l1 < l; ++l1) {
//                for(int i2 = i1; i2 < j1; ++i2) {
//                    blockPos.set(k1, l1, i2);
//                    FluidState fluidstate = this.level.getFluidState(blockPos);
//                    if (fluidstate.is(FluidTags.LAVA) && yOffset < (double)((float)blockPos.getY() + fluidstate.getHeight(this.level, blockPos))) {
//                        if (!fluidstate.isSource()) {
//                            return BoatEntity.Status.UNDER_FLOWING_WATER;
//                        }
//
//                        flag = true;
//                    }
//                }
//            }
//        }
//
//        return flag ? BoatEntity.Status.UNDER_WATER : null;
//    }
//
//    @Override
//    protected void checkFallDamage(double amount, boolean onGround, BlockState state, BlockPos blockPos) {
//        this.lastYd = this.getDeltaMovement().y;
//    }
//
//    @Override
//    protected boolean canAddPassenger(Entity p_184219_1_) {
//        return this.getPassengers().size() < 2 && !this.isEyeInFluid(FluidTags.LAVA);
//    }
//
////    @Override
////    public void floatBoat() {
////        double d0 = (double)-0.04F;
////        double d1 = this.isNoGravity() ? 0.0D : (double)-0.04F;
////        double d2 = 0.0D;
////        this.invFriction = 0.05F;
////        if (this.oldStatus == BoatEntity.Status.IN_AIR && this.status != BoatEntity.Status.IN_AIR && this.status != BoatEntity.Status.ON_LAND) {
////            this.waterWorld = this.getY(1.0D);
////            this.setPos(this.getX(), (double)(this.getWaterWorldAbove() - this.getBbHeight()) + 0.101D, this.getZ());
////            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
////            this.lastYd = 0.0D;
////            this.status = BoatEntity.Status.IN_WATER;
////        } else {
////            if (this.status == BoatEntity.Status.IN_WATER) {
////                d2 = (this.waterWorld - this.getY()) / (double)this.getBbHeight() + 0.35;
////                this.invFriction = 0.9F;
////            } else if (this.status == BoatEntity.Status.UNDER_FLOWING_WATER) {
////                d1 = -7.0E-4D;
////                this.invFriction = 0.9F;
////            } else if (this.status == BoatEntity.Status.UNDER_WATER) {
////                d2 = 0.01F;
////                this.invFriction = 0.45F;
////            } else if (this.status == BoatEntity.Status.IN_AIR) {
////                this.invFriction = 0.9F;
////            } else if (this.status == BoatEntity.Status.ON_LAND) {
////                this.invFriction = this.landFriction;
////                if (this.getControllingPassenger() instanceof PlayerEntityEntity) {
////                    this.landFriction /= 2.0F;
////                }
////            }
////
////            Vector3d vector3d = this.getDeltaMovement();
////            this.setDeltaMovement(vector3d.x * (double)this.invFriction, vector3d.y + d1, vector3d.z * (double)this.invFriction);
////            this.deltaRotation *= this.invFriction;
////            if (d2 > 0.0D) {
////                Vector3d vector3d1 = this.getDeltaMovement();
////                this.setDeltaMovement(vector3d1.x, (vector3d1.y + d2 * 0.06153846016296973D) * 0.75D, vector3d1.z);
////            }
////        }
////
////    }
//
//    @Override
//    public boolean isOnFire() {
//        return false;
//    }
//
//    @Override
//    public boolean fireImmune() {
//        return true;
//    }
//
////    @Override
////    public Item getDropItem() {
////        return OB.ITEM.get();
////    }
////
////    @Override
////    public ItemStack getPickedResult(RayTraceResult target) {
////        return new ItemStack(OB.ITEM.get());
////    }
//
//}


import com.google.common.collect.Lists;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.client.CSteerBoatPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class EntityObBoat extends BoatEntity {

    //private AnimationFactory factory = new AnimationFactory(this);

    private static final DataParameter<Integer> TIME_SINCE_HIT = EntityDataManager.defineId(EntityObBoat.class, DataSerializers.INT);
    private static final DataParameter<Integer> FORWARD_DIRECTION = EntityDataManager.defineId(EntityObBoat.class, DataSerializers.INT);
    private static final DataParameter<Float> DAMAGE_TAKEN = EntityDataManager.defineId(EntityObBoat.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> DATA_ID_HURTDIR = EntityDataManager.defineId(EntityObBoat.class, DataSerializers.INT);
    private static final DataParameter<Integer> DATA_ID_BUBBLE_TIME = EntityDataManager.defineId(EntityObBoat.class, DataSerializers.INT);
    private static final DataParameter<Boolean>[] DATA_ID_PADDLE = new DataParameter[]{EntityDataManager.defineId(EntityObBoat.class,
            DataSerializers.BOOLEAN), EntityDataManager.defineId(EntityObBoat.class, DataSerializers.BOOLEAN)};
    private final float[] paddlePositions;

    private float outOfControlCounter;
    private float deltaRotation;
    private int lerpSteps;
    private double boatPitch;
    private double lerpY;
    private double lerpZ;
    private double boatYaw;
    private double lerpXRot;
    private boolean leftInputDown;
    private boolean rightInputDown;
    private boolean forwardInputDown;
    private boolean backInputDown;
    private double lavaWorld;
    private float bubbleMultiplier;
    private float bubbleAngle;
    private float bubbleAngleO;
    private boolean isAboveBubbleColumn;
    private boolean bubbleColumnDirectionIsDown;
    private float invFriction;

    private float boatGlide;
    private Status status;
    private Status previousStatus;
    private double lastYd;


    public EntityObBoat(EntityType<? extends EntityObBoat> entityIn, World world) {
        super(entityIn, world);
        this.paddlePositions = new float[2];
        this.blocksBuilding = true;
        this.setDeltaMovement(Vector3d.ZERO);
//	        this.xo = x;
//	        this.yo = y;
//	        this.zo = z;
//	        this.setPos(x, y, z);
    }

//    public static AttributeSupplier.Builder prepareAttributes() {
//        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D)
//                .add(Attributes.MOVEMENT_SPEED, 0.20D);
//    }
//    public EntityObBoat(EntityType<? extends EntityObBoat> p_i50129_1_, World p_i50129_2_) {
//        super(p_i50129_1_, p_i50129_2_);
//        this.blocksBuilding = true;
//    }

    public EntityObBoat(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
        this(EntityInit.OBBOAT.get(), p_i1705_1_);
        this.setPos(p_i1705_2_, p_i1705_4_, p_i1705_6_);
        this.setDeltaMovement(Vector3d.ZERO);
        this.xo = p_i1705_2_;
        this.yo = p_i1705_4_;
        this.zo = p_i1705_6_;
    }
//    public EntityObBoat(World world)
//    {
//        super(EntityInit.OBBOAT.get(),world);
//        //this.isImmuneToFire = true;
//        this.paddlePositions = new float[2];
//        //this.preventEntitySpawning = true;
//        //this.setSize(1.375F, 0.5625F);
//    }
//
//    public EntityObBoat(World world, double x, double y, double z)
//    {
//        this(EntityInit.OBBOAT.get(),world);
////	        this.getDeltaMovement().x = 0.0D;
////	        this.getDeltaMovement().y = 0.0D;
////	        this.getDeltaMovement().z = 0.0D;
//        this.setDeltaMovement(Vector3d.ZERO);
//        this.xo = x;
//        this.yo = y;
//        this.zo = z;
//        this.setPos(x, y, z);
//    }


    //@Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    protected void defineSynchedData() {

        this.entityData.define(TIME_SINCE_HIT, 0);
        this.entityData.define(FORWARD_DIRECTION, 1);
        this.entityData.define(DAMAGE_TAKEN, 0.0F);
        this.entityData.define(DATA_ID_HURTDIR, 1);
        this.entityData.define(DATA_ID_BUBBLE_TIME, 0);

        for(DataParameter<Boolean> parameter : DATA_ID_PADDLE)
        {
            this.entityData.define(parameter, false);
        }
    }

//    @Override
//    public static boolean canVehicleCollide(Entity p_242378_0_, Entity p_242378_1_) {
//        super(p_242378_0_,p_242378_1_);
//        return (p_242378_1_.canBeCollidedWith() || p_242378_1_.isPushable()) && !p_242378_0_.isPassengerOfSameVehicle(p_242378_1_);
//    }
//
//    @Override
//    public AxisAlignedBB getCollisionBoundingBox()
//    {
//        return this.getBoundingBox();
//    }

    @Override
    public boolean isPushable()
    {
        return true;
    }

    @Override
    public double getPassengersRidingOffset()
    {
        return -0.1D;
    }

//	    @Override
//	    public boolean hurt(DamageSource source, float amount)
//	    {
//	        if(this.isInvulnerableTo(source))
//	        {
//	            return false;
//	        }
//	        else if(!this.level.isClientSide && !this.removed)
//	        {
////	            if(source instanceof DamageSource && source.getTrueSource() != null && this.hasPassenger(source.getTrueSource()))
////	            {
////	                return false;
////	            }
////	            else
////	            {
//	                this.setBubbleTime(-this.getBubbleTime());
//	                this.setHurtTime(10);
//	                this.setDamage(this.getDamage() + amount * 10.0F);
//	                //this.markVelocityChanged();
//	                boolean takeDamage = source.getEntity() instanceof PlayerEntity && ((PlayerEntity)source.getEntity()).abilities.instabuild;
//
//	                if(takeDamage || this.getDamage() > 40.0F)
//	                {
//	                    if (!takeDamage && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
//	                        this.spawnAtLocation(this.getDropItem());
//	                     }
//
//	                    this.kill();
//	                }
//
//	                return true;
////	            }
//	        }
//	        else
//	        {
//	            return true;
//	        }
//	    }

    private void tickBubbleColumn() {
        if (this.level.isClientSide) {
            int i = this.getBubbleTime();
            if (i > 0) {
                this.bubbleMultiplier += 0.05F;
            } else {
                this.bubbleMultiplier -= 0.1F;
            }

            this.bubbleMultiplier = MathHelper.clamp(this.bubbleMultiplier, 0.0F, 1.0F);
            this.bubbleAngleO = this.bubbleAngle;
            this.bubbleAngle = 10.0F * (float)Math.sin((double)(0.5F * (float)this.level.getGameTime())) * this.bubbleMultiplier;
        } else {
            if (!this.isAboveBubbleColumn) {
                this.setBubbleTime(0);
            }

            int k = this.getBubbleTime();
            if (k > 0) {
                --k;
                this.setBubbleTime(k);
                int j = 60 - k - 1;
                if (j > 0 && k == 0) {
                    this.setBubbleTime(0);
                    Vector3d vec3 = this.getDeltaMovement();
                    if (this.bubbleColumnDirectionIsDown) {
                        this.setDeltaMovement(vec3.add(0.0D, -0.7D, 0.0D));
                        this.ejectPassengers();
                    } else {
                        this.setDeltaMovement(vec3.x, this.hasPassenger(PlayerEntity.class) ? 2.7D : 0.6D, vec3.z);
                    }
                }

                this.isAboveBubbleColumn = false;
            }
        }

    }

//    public Item getDropItem(){
//        return ModItems.OBBOAT.get();
//    }

    public boolean hurt(DamageSource p_38319_, float p_38320_) {
        if (this.isInvulnerableTo(p_38319_)) {
            return false;
        } else if (!this.level.isClientSide && !this.removed) {
            this.setHurtDir(-this.getHurtDir());
            this.setHurtTime(10);
            this.setDamage(this.getDamage() + p_38320_ * 10.0F);
            this.markHurt();
            //this.gameEvent(GameEvent.ENTITY_DAMAGED, p_38319_.getEntity());
            boolean flag = p_38319_.getEntity() instanceof PlayerEntity && ((PlayerEntity)p_38319_.getEntity()).abilities.instabuild;
            if (flag || this.getDamage() > 40.0F) {
                if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                    this.spawnAtLocation(this.getDropItem());
                }

                this.remove();
            }

            return true;
        } else {
            return true;
        }
    }

    public void onAboveBubbleCol(boolean p_38381_) {
        if (!this.level.isClientSide) {
            this.isAboveBubbleColumn = true;
            this.bubbleColumnDirectionIsDown = p_38381_;
            if (this.getBubbleTime() == 0) {
                this.setBubbleTime(60);
            }
        }

        this.level.addParticle(ParticleTypes.SPLASH, this.getX() + (double)this.random.nextFloat(), this.getY() + 0.7D, this.getZ() + (double)this.random.nextFloat(), 0.0D, 0.0D, 0.0D);
        if (this.random.nextInt(20) == 0) {
            this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), this.getSwimSplashSound(), this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
        }

        //this.gameEvent(GameEvent.SPLASH, this.getControllingPassenger());
    }

    @Override
    public void push(Entity entity)
    {
        if(entity instanceof EntityObBoat)
        {
            if(entity.getBoundingBox().minY < this.getBoundingBox().maxY)
            {
                super.push(entity);
            }
        }
        else if(entity.getBoundingBox().minY <= this.getBoundingBox().minY)
        {
            super.push(entity);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateHurt()
    {
        this.setBubbleTime(-this.getBubbleTime());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return !this.removed;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
    {
        this.boatPitch = x;
        this.lerpY = y;
        this.lerpZ = z;
        this.boatYaw = yaw;
        this.lerpXRot = pitch;
        this.lerpSteps = 10;
    }

    @Override
    public Direction getMotionDirection() {
        return this.getDirection().getClockWise();
    }

    @Override
    public void tick()
    {
        this.previousStatus = this.status;
        this.status = this.getBoatStatus();

        if(this.status != Status.UNDER_LAVA && this.status != Status.UNDER_FLOWING_LAVA)
        {
            this.outOfControlCounter = 0.0F;
        }
        else
        {
            this.outOfControlCounter++;
        }

        if(!this.level.isClientSide && this.outOfControlCounter >= 60.0F)
        {
            this.ejectPassengers();
        }

        if(this.getHurtTime() > 0)
        {
            this.setHurtTime(this.getHurtTime() - 1);
        }

        if(this.getDamage() > 0.0F)
        {
            this.setDamage(this.getDamage() - 1.0F);
        }

        this.previousStatus = this.status;

//	        this.prevgetX() = this.getX();
//	        this.prevPosY = this.posY;
//	        this.prevPosZ = this.posZ;

//	        if(!this.level.isClientSide)
//	        {
//	            this.setFlag(6, this.isGlowing());
//	        }

        //super.tick();
        this.tickLerp();
        this.tickBubbleColumn();

        if(this.isControlledByLocalInstance())
        {
            if(this.getPassengers().size() == 0 || !(this.getPassengers().get(0) instanceof PlayerEntity))
            {
                this.setPaddleState(false, false);
            }

            this.updateMotion();

            if(this.level.isClientSide)
            {
                this.controlBoat();
                this.level.sendPacketToServer(new CSteerBoatPacket(this.getPaddleState(0), this.getPaddleState(1)));
            }

            //this.move(MoverType.SELF, this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z);
            this.move(MoverType.SELF, this.getDeltaMovement());
        }
        else
        {
            this.setDeltaMovement(Vector3d.ZERO);
        }

        for(int i = 0; i <= 1; i++)
        {
            if(this.getPaddleState(i))
            {
                if(!this.isSilent() && (double) (this.paddlePositions[i] % ((float) Math.PI * 2F)) <= (Math.PI / 4D) && ((double) this.paddlePositions[i] + 0.39269909262657166D) % (Math.PI * 2D) >= (Math.PI / 4D))
                {
                    SoundEvent event = this.getPaddleSound();

                    if(event != null)
                    {
                        Vector3d look = this.getViewVector(1.0F);
                        double lookX = i == 1 ? -look.z : look.z;
                        double lookZ = i == 1 ? look.x : -look.x;
                        this.level.playSound(null, this.getX() + lookX, this.getY(), this.getZ() + lookZ, event, this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat());
                    }
                }

                this.paddlePositions[i] = (float) ((double) this.paddlePositions[i] + 0.39269909262657166D);
            }
            else
            {
                this.paddlePositions[i] = 0.0F;
            }
        }

        this.checkInsideBlocks();

        List<Entity> entities = this.level.getEntities(this, this.getBoundingBox().inflate(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntityPredicates.pushableBy(this));

        if(!entities.isEmpty())
        {
            boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof PlayerEntity);

            for(Entity entity : entities)
            {
                if(!entity.hasPassenger(this))
                {
                    if(flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterMobEntity) && !(entity instanceof PlayerEntity))
                    {
                        entity.startRiding(this);
                    }
                    else
                    {
                        this.push(entity);
                    }
                }
            }
        }
    }

    protected SoundEvent getPaddleSound() {
        switch(this.getStatus()) {
            case IN_LAVA:
            case UNDER_LAVA:
            case UNDER_FLOWING_LAVA:
                return SoundEvents.BOAT_PADDLE_WATER;
            case ON_LAND:
                return SoundEvents.BOAT_PADDLE_LAND;
            case IN_AIR:
            default:
                return null;
        }
    }

//	    @Override
//	    public Item getDropItem()
//	    {
//	        return ItemInit.OBBOAT.get();
//	    }

    private void tickLerp()
    {
        if(this.lerpSteps > 0 && !this.isControlledByLocalInstance())
        {
            double posX = this.getX() + (this.boatPitch - this.getX()) / (double) this.lerpSteps;
            double posY = this.getY() + (this.lerpY - this.getY()) / (double) this.lerpSteps;
            double posZ = this.getZ() + (this.lerpZ - this.getZ()) / (double) this.lerpSteps;
            double yaw = MathHelper.wrapDegrees(this.boatYaw - (double) this.yRot);

            //this.yRot = (float) ((double) this.yRot + yaw / (double) this.lerpSteps);
            //this.rotationPitch = (float) ((double) this.rotationPitch + (this.lerpXRot - (double) this.rotationPitch) / (double) this.lerpSteps);
            this.yRot=(float)(this.yRot + (float)yaw / (float)this.lerpSteps);
            this.xRot=(float)(this.xRot + (float)(this.lerpXRot - (double)this.xRot) / (float)this.lerpSteps);

            this.lerpSteps--;
            this.setPos(getX(), posY, posZ);
            this.setRot(this.yRot, this.xRot);
        }
    }

    @Override
    public void setPaddleState(boolean leftPaddle, boolean rightPaddle)
    {
        this.entityData.set(DATA_ID_PADDLE[0], leftPaddle);
        this.entityData.set(DATA_ID_PADDLE[1], rightPaddle);
    }

    //
    @OnlyIn(Dist.CLIENT)
    public float getRowingTime(int side, float limbSwing)
    {
        return this.getPaddleState(side) ? (float) MathHelper.clampedLerp((double) this.paddlePositions[side] - 0.39269909262657166D, this.paddlePositions[side], limbSwing) : 0.0F;
    }

    private Status getBoatStatus()
    {
        Status status = this.getUnderLavaStatus();

        if(status != null)
        {
            this.lavaWorld = this.getBoundingBox().maxY;
            return status;
        }
        else if(this.checkInLava())
        {
            return Status.IN_LAVA;
        }
        else
        {
            float f = this.getGroundFriction();

            if(f > 0.0F)
            {
                this.boatGlide = f;
                return Status.ON_LAND;
            }
            else
            {
                return Status.IN_AIR;
            }
        }
    }

    private float getLavaWorldAbove()
    {

        AxisAlignedBB aabb = this.getBoundingBox();
        int i = MathHelper.floor(aabb.minX);
        int j = MathHelper.ceil(aabb.maxX);
        int k = MathHelper.floor(aabb.maxY);
        int l = MathHelper.ceil(aabb.maxY - this.lastYd);
        int i1 = MathHelper.floor(aabb.minZ);
        int j1 = MathHelper.ceil(aabb.maxZ);
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

        label39:
        for(int k1 = k; k1 < l; ++k1) {
            float f = 0.0F;

            for(int l1 = i; l1 < j; ++l1) {
                for(int i2 = i1; i2 < j1; ++i2) {
                    blockpos$mutableblockpos.set(l1, k1, i2);
                    FluidState fluidstate = this.level.getFluidState(blockpos$mutableblockpos);
                    if (fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)) {
                        f = Math.max(f, fluidstate.getHeight(this.level, blockpos$mutableblockpos));
                    }

                    if (f >= 1.0F) {
                        continue label39;
                    }
                }
            }

            if (f < 1.0F) {
                return (float)blockpos$mutableblockpos.getY() + f;
            }
        }

        return (float)(l + 1);
    }

    @Override
    public float getGroundFriction()
    {
//	        AxisAlignedBB entityBoundingBox = this.getBoundingBox();
//	        AxisAlignedBB boundingBox = new AxisAlignedBB(entityBoundingBox.minX, entityBoundingBox.minY - 0.001D, entityBoundingBox.minZ, entityBoundingBox.maxX, entityBoundingBox.minY, entityBoundingBox.maxZ);
//	        int minX = MathHelper.floor(boundingBox.minX) - 1;
//	        int maxX = MathHelper.ceil(boundingBox.maxX) + 1;
//	        int minY = MathHelper.floor(boundingBox.minY) - 1;
//	        int maxY = MathHelper.ceil(boundingBox.maxY) + 1;
//	        int minZ = MathHelper.floor(boundingBox.minZ) - 1;
//	        int maxZ = MathHelper.ceil(boundingBox.maxZ) + 1;
//
//	        List<AxisAlignedBB> list = new ArrayList<>();
//	        VoxelShape voxelshape = Shapes.create(entityBoundingBox);
//
//	        float slipperiness = 0.0F;
//	        int friction = 0;
//	        //BlockPos.Mutable mutableBlockPos = BlockPos.Mutable.retain();
//	        BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();
//
////	        try
////	        {
//	            for(int x = minX; x < maxX; x++)
//	            {
//	                for(int z = minZ; z < maxZ; z++)
//	                {
//	                    int offset = (x != minX && x != maxX - 1 ? 0 : 1) + (z != minZ && z != maxZ - 1 ? 0 : 1);
//
//	                    if(offset != 2)
//	                    {
//	                        for(int y = minY; y < maxY; y++)
//	                        {
//	                            if(offset <= 0 || y != minY && y != maxY - 1)
//	                            {
//	                                mutableBlockPos.set(x, y, z);
//	                                BlockState blockstate = this.level.getBlockState(mutableBlockPos);
//	    	  	                    //FluidState fluidstate = this.level.getFluidState(mutableBlockPos);
//
//	                                //blockstate.addCollisionBoxToList(this.level, mutableBlockPos, boundingBox, list, this, false);
//	                                if (!(blockstate.getBlock() instanceof WaterlilyBlock) 
//	                                		&& Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level, mutableBlockPos).move((double)x, (double)y, (double)z), voxelshape, BooleanOp.AND)) {
//	                                	slipperiness += blockstate.getFriction(this.level, mutableBlockPos, this);
//	                                   ++friction;
//	                                }
////	                                if(!list.isEmpty())
////	                                {
////	                                    slipperiness += blockstate.getBlock().getFriction(blockstate, this.level, mutableBlockPos, this);
////	                                    friction++;
////	                                }
//
//	                                list.clear();
//	                            }
//	                        }
//	                    }
//	                }
//	            }
////	        }
////	        finally
////	        {
////	            mutableBlockPos.release();
////	        }
//
//	        return slipperiness / (float) friction;
        AxisAlignedBB aabb = this.getBoundingBox();
        AxisAlignedBB aabb1 = new AxisAlignedBB(aabb.minX, aabb.minY - 0.001D, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
        int i = MathHelper.floor(aabb1.minX) - 1;
        int j = MathHelper.ceil(aabb1.maxX) + 1;
        int k = MathHelper.floor(aabb1.minY) - 1;
        int l = MathHelper.ceil(aabb1.maxY) + 1;
        int i1 = MathHelper.floor(aabb1.minZ) - 1;
        int j1 = MathHelper.ceil(aabb1.maxZ) + 1;
        VoxelShape voxelshape = VoxelShapes.create(aabb1);
        float f = 0.0F;
        int k1 = 0;
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

        for(int l1 = i; l1 < j; ++l1) {
            for(int i2 = i1; i2 < j1; ++i2) {
                int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
                if (j2 != 2) {
                    for(int k2 = k; k2 < l; ++k2) {
                        if (j2 <= 0 || k2 != k && k2 != l - 1) {
                            blockpos$mutableblockpos.set(l1, k2, i2);
                            BlockState blockstate = this.level.getBlockState(blockpos$mutableblockpos);
                            if (!(blockstate.getBlock() instanceof LilyPadBlock) && VoxelShapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level, blockpos$mutableblockpos).move((double)l1, (double)k2, (double)i2), voxelshape, IBooleanFunction.AND)) {
                                f += blockstate.getSlipperiness(this.level, blockpos$mutableblockpos, this);
                                ++k1;
                            }
                        }
                    }
                }
            }
        }

        return f / (float)k1;
    }

    private boolean checkInLava()
    {
        AxisAlignedBB entityBoundingBox = this.getBoundingBox();
        int minX = MathHelper.floor(entityBoundingBox.minX);
        int maxX = MathHelper.ceil(entityBoundingBox.maxX);
        int minY = MathHelper.floor(entityBoundingBox.minY);
        int maxY = MathHelper.ceil(entityBoundingBox.minY + 0.001D);
        int minZ = MathHelper.floor(entityBoundingBox.minZ);
        int maxZ = MathHelper.ceil(entityBoundingBox.maxZ);
        boolean flag = false;
        this.lavaWorld = -Double.MAX_VALUE;
        //BlockPos.Mutable mutableBlockPos = BlockPos.Mutable.retain();
        BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();


        for(int x = minX; x < maxX; x++)
        {
            for(int y = minY; y < maxY; y++)
            {
                for(int z = minZ; z < maxZ; z++)
                {
                    mutableBlockPos.set(x, y, z);
                    FluidState fluidstate = this.level.getFluidState(mutableBlockPos);

                    if((fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)))
                    {
//	                            float liquidHeight = fluidstate.getHeight(this.level, mutableBlockPos);
//	                            this.lavaWorld = Math.max(liquidHeight, this.lavaWorld);
//	                            flag |= entityBoundingBox.minY < (double) liquidHeight;
                        float f = (float)y + fluidstate.getHeight(this.level, mutableBlockPos);
                        this.lavaWorld = Math.max((double)f, this.lavaWorld);
                        flag |= entityBoundingBox.minY < (double)f;
                    }
                }
            }
        }


        return flag;
    }

    private Status getUnderLavaStatus()
    {
        AxisAlignedBB entityBoundingBox = this.getBoundingBox();
        double entityHeight = entityBoundingBox.maxY + 0.001D;
        int minX = MathHelper.floor(entityBoundingBox.minX);
        int maxX = MathHelper.ceil(entityBoundingBox.maxX);
        int minY = MathHelper.floor(entityBoundingBox.maxY);
        int maxY = MathHelper.ceil(entityHeight);
        int minZ = MathHelper.floor(entityBoundingBox.minZ);
        int maxZ = MathHelper.ceil(entityBoundingBox.maxZ);
        boolean flag = false;
        BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();
        for(int k1 = minX; k1 < maxX; ++k1) {
            for(int l1 = minY; l1 < maxY; ++l1) {
                for(int i2 = minZ; i2 < maxZ; ++i2) {
                    mutableBlockPos.set(k1, l1, i2);
                    FluidState fluidstate = this.level.getFluidState(mutableBlockPos);
                    if ((fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)) && entityHeight < (double)((float)mutableBlockPos.getY() +
                            fluidstate.getHeight(this.level, mutableBlockPos))) {
                        if (!fluidstate.isSource()) {
                            return Status.UNDER_FLOWING_LAVA;
                        }

                        flag = true;
                    }
                }
            }
        }

        return flag ? Status.UNDER_LAVA : null;
    }

    private void updateMotion()
    {
        double gravity = this.isNoGravity() ? 0.0D : -0.03999999910593033D;
        double position = 0.0D;
        this.invFriction = 0.05F;

        if(this.previousStatus == Status.IN_AIR && this.status != Status.IN_AIR && this.status != Status.ON_LAND)
        {
            this.lavaWorld = this.getY(1.0D); // + (double) this.height;
            this.setPos(this.getX(), (double) (this.getLavaWorldAbove() - this.getBbHeight()) + 0.101D, this.getZ());
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
            this.lastYd = 0.0D;
            this.status = Status.IN_LAVA;
        }
        else
        {
            if(this.status == Status.IN_LAVA)
            {
                position = (this.lavaWorld - this.getY()) / (double) this.getBbHeight();
                this.invFriction = 0.9F;
            }
            else if(this.status == Status.UNDER_FLOWING_LAVA)
            {
                gravity = -7.0E-4D;
                this.invFriction = 0.9F;
            }
            else if(this.status == Status.UNDER_LAVA)
            {
                position = 0.009999999776482582D;
                this.invFriction = 0.45F;
            }
            else if(this.status == Status.IN_AIR)
            {
                this.invFriction = 0.9F;
            }
            else if(this.status == Status.ON_LAND)
            {
                this.invFriction = this.boatGlide;

                if(this.getControllingPassenger() instanceof PlayerEntity)
                {
                    this.boatGlide /= 2.0F;
                }
            }

            //this.getDeltaMovement().x *= momentum;
            //this.getDeltaMovement().z *= momentum;
//	            Vector3d vec3 = this.getDeltaMovement();
//	            this.setDeltaMovement(vec3.x * (double)momentum, vec3.y + gravity, vec3.z * (double)momentum);
//
//	            this.deltaRotation *= momentum;
//	            this.getDeltaMovement().add(0.0D, gravity, 0.0D);// += gravity;
//
//	            if(position > 0.0D)
//	            {
////	                this.getDeltaMovement().y += position * 0.06153846016296973D;
////	                this.getDeltaMovement().y *= 0.75D;
//	                Vector3d vec31 = this.getDeltaMovement();
//	                this.setDeltaMovement(vec31.x, (vec31.y + position * 0.06153846016296973D) * 0.75D, vec31.z);
//	            }
            Vector3d vec3 = this.getDeltaMovement();
            this.setDeltaMovement(vec3.x * (double)this.invFriction, vec3.y + gravity, vec3.z * this.invFriction);
            this.deltaRotation *= this.invFriction;
            if (position > 0.0D) {
                Vector3d vec31 = this.getDeltaMovement();
                this.setDeltaMovement(vec31.x, (vec31.y + position * 0.06153846016296973D) * 0.75D, vec31.z);
            }
        }
    }

    private void controlBoat()
    {
        if(this.isVehicle())
        {
            float speed = 0.0F;

            if(this.leftInputDown)
            {
                this.deltaRotation += -1.0F;
            }

            if(this.rightInputDown)
            {
                this.deltaRotation++;
            }

            if(this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
            {
                speed += 0.005F;
            }

            //this.yRot += this.deltaRotation;
            this.yRot=(float)(this.yRot + this.deltaRotation);
            if(this.forwardInputDown)
            {
                speed += 0.04F;
            }

            if(this.backInputDown)
            {
                speed -= 0.005F;
            }

            this.setDeltaMovement(this.getDeltaMovement().add((double)(MathHelper.sin(-this.yRot * ((float)Math.PI / 180F)) * speed),
                    0D, (double)(MathHelper.cos(this.yRot * ((float)Math.PI / 180F)) * speed)));
//	            this.getDeltaMovement().x += (MathHelper.sin(-this.yRot * 0.017453292F) * speed);
//	            this.getDeltaMovement().z += (MathHelper.cos(this.yRot * 0.017453292F) * speed);
            this.setPaddleState(this.rightInputDown && !this.leftInputDown || this.forwardInputDown, this.leftInputDown && !this.rightInputDown || this.forwardInputDown);
        }
    }

    @Override
    public void positionRider(Entity passenger)
    {
        ((LivingEntity)passenger).addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 100));
        if(this.hasPassenger(passenger))
        {
            float x = 0.0F;
            float height = (float) ((this.removed ? 0.009999999776482582D : this.getPassengersRidingOffset()) + passenger.getMyRidingOffset());

            if(this.getPassengers().size() > 1)
            {
                int index = this.getPassengers().indexOf(passenger);

                if(index == 0)
                {
                    x = 0.2F;
                }
                else
                {
                    x = -0.6F;
                }

                if(passenger instanceof AnimalEntity)
                {
                    x = (float) ((double) x + 0.2D);
                }
            }

            Vector3d pos = (new Vector3d(x, 0.0D, 0.0D)).yRot(-this.yRot * 0.017453292F - ((float) Math.PI / 2F));
            passenger.setPos(this.position().x + pos.x, this.position().y + (double) height, this.position().z + pos.z);
            passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
            passenger.yRot=(float)(passenger.yRot + this.deltaRotation);
            this.clampRotation(passenger);

            if(passenger instanceof AnimalEntity && this.getPassengers().size() > 1)
            {
                int rotation = passenger.getId() % 2 == 0 ? 90 : 270;
                passenger.setYBodyRot(((AnimalEntity)passenger).yBodyRot + (float)rotation);
                passenger.setYHeadRot(passenger.getYHeadRot() + (float)rotation);
            }

//	            if(this.isInsideOfMaterial(Material.WATER))
//	            {
//	                passenger.dismountRidingEntity();
//	            }
        }
    }

    public Vector3d getDismountLocationForPassenger(LivingEntity p_38357_) {
        Vector3d vec3 = getCollisionHorizontalEscapeVector((double)(this.getBbWidth() * MathHelper.SQRT_OF_TWO), (double)p_38357_.getBbWidth(), p_38357_.yRot);
        double d0 = this.getX() + vec3.x;
        double d1 = this.getZ() + vec3.z;
        BlockPos blockpos = new BlockPos(d0, this.getBoundingBox().maxY, d1);
        BlockPos blockpos1 = blockpos.below();
        if (!this.level.getFluidState(blockpos1).is(FluidTags.WATER) || !this.level.getFluidState(blockpos1).is(FluidTags.LAVA)) {
            List<Vector3d> list = Lists.newArrayList();
            double d2 = this.level.getBlockFloorHeight(blockpos);
            //double d3 = (double)blockpos.getY() + this.level.getBlockFloorHeight(blockpos1);

            if (TransportationHelper.isBlockFloorValid(d2)) {
                list.add(new Vector3d(d0, (double)blockpos.getY() + d2, d1));
            }

            double d3 = this.level.getBlockFloorHeight(blockpos1);
            if (TransportationHelper.isBlockFloorValid(d3)) {
                list.add(new Vector3d(d0, (double)blockpos1.getY() + d3, d1));
            }
            //TransportationHelper.canDismountTo(this.level, p_230268_1_, axisalignedbb.move(vector3d))
            for(Pose pose : p_38357_.getDismountPoses()) {
                AxisAlignedBB axisalignedbb = p_38357_.getLocalBoundsForPose(pose);
                for(Vector3d vec31 : list) {
                    if (TransportationHelper.canDismountTo(this.level, p_38357_, axisalignedbb.move(vec31))) {
                        p_38357_.setPose(pose);
                        return vec31;
                    }
                }
            }

//            for(Pose pose : p_38357_.getDismountPoses()) {
//                Vector3d vector3d1 = TransportationHelper.findDismountLocation(this.level, d0, d2, d1, p_38357_, pose);
//                if (vector3d1 != null) {
//                    p_38357_.setPose(pose);
//                    return vector3d1;
//                }
//
//                Vector3d vector3d2 = TransportationHelper.findDismountLocation(this.level, d0, d3, d1, p_38357_, pose);
//                if (vector3d2 != null) {
//                    p_38357_.setPose(pose);
//                    return vector3d2;
//                }
//            }
        }

        return super.getDismountLocationForPassenger(p_38357_);
    }

    @Override
    protected void clampRotation(Entity entityToUpdate) {
        entityToUpdate.setYBodyRot(this.yRot);
        float f = MathHelper.wrapDegrees(entityToUpdate.yRot - this.yRot);
        float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
        entityToUpdate.yRotO += f1 - f;
        entityToUpdate.yRot=(float)(entityToUpdate.yRot + f1 - f);
        entityToUpdate.setYHeadRot(entityToUpdate.yRot);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void onPassengerTurned(Entity entityToUpdate) {
        this.clampRotation(entityToUpdate);
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT p_38359_) {
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT p_38338_) {

    }

    public EntityObBoat.Type getBoatType() {
        return EntityObBoat.Type.DARK_OAK;
    }

    @Override
    public ActionResultType interact(PlayerEntity player, Hand hand)
    {

        if (player.isSecondaryUseActive()) {
            return ActionResultType.PASS;
        } else if (this.outOfControlCounter < 60.0F) {
            if (!this.level.isClientSide) {
                return player.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.PASS;
            } else {
                return ActionResultType.SUCCESS;
            }
        } else {
            return ActionResultType.PASS;
        }
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos)
    {
        this.lastYd = this.getDeltaMovement().y;

        if(!this.isPassenger())
        {
            if(onGround)
            {
                if(this.fallDistance > 3.0F)
                {
                    if(this.status != Status.ON_LAND)
                    {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F);
                    if(!this.level.isClientSide && !this.removed)
                    {
                        this.kill();

                        if(this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS))
                        {
                            for(int i = 0; i < 3; i++)
                            {
                                //this.entityDropItem(new ItemStack(Blocks.OBSIDIAN, 1, 0), 0.0F);
                                this.spawnAtLocation(new ItemStack(ModBlocks.EBONY_PLANKS.get()), 0.0F);
                            }
                        }
                    }
                }

                this.fallDistance = 0.0F;
            }
            else if((!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.LAVA) && y < 0.0D) ||
                    (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && y < 0.0D) )
            {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }
        }
    }

    @Override
    public boolean getPaddleState(int state)
    {
        return this.entityData.get(DATA_ID_PADDLE[state]) && this.getControllingPassenger() != null;

    }

    @Override
    public void setDamage(float Damage)
    {
        this.entityData.set(DAMAGE_TAKEN, Damage);
    }

    @Override
    public float getDamage()
    {
        return this.entityData.get(DAMAGE_TAKEN);
    }

    @Override
    public void setHurtTime(int HurtTime)
    {
        this.entityData.set(TIME_SINCE_HIT, HurtTime);
    }

    public void setHurtDir(int p_38363_) {
        this.entityData.set(DATA_ID_HURTDIR, p_38363_);
    }

    public int getHurtDir() {
        return this.entityData.get(DATA_ID_HURTDIR);
    }

    @Override
    public int getHurtTime()
    {
        return this.entityData.get(TIME_SINCE_HIT);
    }

    //@Override
    public void setBubbleTime1(int bubbleTime)
    {
        this.entityData.set(FORWARD_DIRECTION, bubbleTime);
    }

    //@Override
    public int getBubbleTime1()
    {
        return this.entityData.get(FORWARD_DIRECTION);
    }

    private void setBubbleTime(int p_38367_) {
        this.entityData.set(DATA_ID_BUBBLE_TIME, p_38367_);
    }

    private int getBubbleTime() {
        return this.entityData.get(DATA_ID_BUBBLE_TIME);
    }
    @Override
    protected boolean canAddPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 2;
    }

    @Override
    public Entity getControllingPassenger()
    {
        List<Entity> passengers = this.getPassengers();
        return passengers.isEmpty() ? null : passengers.get(0);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void setInput(boolean left, boolean right, boolean forward, boolean back)
    {
        this.leftInputDown = left;
        this.rightInputDown = right;
        this.forwardInputDown = forward;
        this.backInputDown = back;
    }

    public enum Status
    {
        IN_LAVA,
        UNDER_LAVA,
        UNDER_FLOWING_LAVA,
        ON_LAND,
        IN_AIR
    }

    //	    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//	        if (event.isMoving()) {
//	            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.obboat.idle", true));
//	            return PlayState.CONTINUE;
//	        }
//	        
////	        if (this.isPathFinding()) {
////	          event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dund.attack", true));
////	          return PlayState.CONTINUE;        	
////	        }
////	        if (this.isSitting()) {
////	            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dund.attack", true));
////	            return PlayState.CONTINUE;
////	        }
//
//	        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.obboat.idle", true));
//	        return PlayState.CONTINUE;
//	    }
//	    
//		@Override
//		public void registerControllers(AnimationData data) {
//	        data.addAnimationController(new AnimationController(this, "controller",
//	                0, this::predicate));      
//		}
//
//		@Override
//		public AnimationFactory getFactory() {
//			// TODO Auto-generated method stub
//			return this.factory;
//		}
//		
    private EntityObBoat.Status getStatus() {
        EntityObBoat.Status boat$status = this.getUnderLavaStatus();
        if (boat$status != null) {
            this.lavaWorld = this.getBoundingBox().maxY;
            return boat$status;
        } else if (this.checkInLava()) {
            return EntityObBoat.Status.IN_LAVA;
        } else {
            float f = this.getGroundFriction();
            if (f > 0.0F) {
                this.boatGlide = f;
                return EntityObBoat.Status.ON_LAND;
            } else {
                return EntityObBoat.Status.IN_AIR;
            }
        }
    }


}
