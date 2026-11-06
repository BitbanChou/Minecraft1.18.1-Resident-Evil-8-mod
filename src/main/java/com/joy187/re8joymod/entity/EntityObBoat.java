//package com.joy187.re8joymod.entity;
//
//import java.util.List;
//import java.util.function.IntFunction;
//
//import com.google.common.collect.Lists;
//import com.joy187.re8joymod.init.BlockInit;
//import com.joy187.re8joymod.init.EntityInit;
//import com.joy187.re8joymod.init.ItemInit;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
//import net.minecraft.network.syncher.EntityDataAccessor;
//import net.minecraft.network.syncher.EntityDataSerializers;
//import net.minecraft.network.syncher.SynchedEntityData;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.tags.FluidTags;
//import net.minecraft.util.ByIdMap;
//import net.minecraft.util.Mth;
//import net.minecraft.util.StringRepresentable;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntitySelector;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.Mob;
//import net.minecraft.world.entity.MoverType;
//import net.minecraft.world.entity.Pose;
//import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.animal.Animal;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.vehicle.Boat;
//import net.minecraft.world.entity.vehicle.DismountHelper;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.GameRules;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.WaterlilyBlock;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.gameevent.GameEvent;
//import net.minecraft.world.level.material.FluidState;
//import net.minecraft.world.phys.AABB;
//import net.minecraft.world.phys.Vec3;
//import net.minecraft.world.phys.shapes.BooleanOp;
//import net.minecraft.world.phys.shapes.Shapes;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//;
//import net.minecraft.world.entity.animal.WaterAnimal;
//
//public class EntityObBoat extends Boat{
//
//		//private AnimatableInstanceCache factory = new AnimatableInstanceCache(this);
//
//	    private static final EntityDataAccessor<Integer> TIME_SINCE_HIT = SynchedEntityData.defineId(EntityObBoat.class, EntityDataSerializers.INT);
//	    private static final EntityDataAccessor<Integer> FORWARD_DIRECTION = SynchedEntityData.defineId(EntityObBoat.class, EntityDataSerializers.INT);
//	    private static final EntityDataAccessor<Float> DAMAGE_TAKEN = SynchedEntityData.defineId(EntityObBoat.class, EntityDataSerializers.FLOAT);
//	    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(EntityObBoat.class, EntityDataSerializers.INT);
//	    private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(EntityObBoat.class, EntityDataSerializers.INT);
//	    private static final EntityDataAccessor<Boolean>[] DATA_ID_PADDLE = new EntityDataAccessor[]{SynchedEntityData.defineId(EntityObBoat.class,
//	    		EntityDataSerializers.BOOLEAN), SynchedEntityData.defineId(EntityObBoat.class, EntityDataSerializers.BOOLEAN)};
//		private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);
//
//	    private final float[] paddlePositions;
//
//	    private float outOfControlCounter;
//	    private float deltaRotation;
//	    private int lerpSteps;
//	    private double boatPitch;
//	    private double lerpY;
//	    private double lerpZ;
//	    private double boatYaw;
//	    private double lerpXRot;
//	    private boolean leftInputDown;
//	    private boolean rightInputDown;
//	    private boolean forwardInputDown;
//	    private boolean backInputDown;
//	    private double lavaLevel;
//	    private float bubbleMultiplier;
//	    private float bubbleAngle;
//	    private float bubbleAngleO;
//	    private boolean isAboveBubbleColumn;
//	    private boolean bubbleColumnDirectionIsDown;
//	    private float invFriction;
//
//	    private float boatGlide;
//	    private Status status;
//	    private Status previousStatus;
//	    private double lastYd;
//
//
//	    public EntityObBoat(EntityType<? extends EntityObBoat> entityIn, Level world) {
//	       super(entityIn, world);
//	       this.paddlePositions = new float[2];
//	       this.blocksBuilding = true;
//       	   this.setDeltaMovement(Vec3.ZERO);
////	        this.xo = x;
////	        this.yo = y;
////	        this.zo = z;
////	        this.setPos(x, y, z);
//	    }
//
//	    public static AttributeSupplier.Builder prepareAttributes() {
//	        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D)
//	        		.add(Attributes.MOVEMENT_SPEED, 0.20D);
//	     }
//
//	    public EntityObBoat(Level world)
//	    {
//	        super(EntityInit.OBBOAT.get(),world);
//	        //this.isImmuneToFire = true;
//	        this.paddlePositions = new float[2];
//	        //this.preventEntitySpawning = true;
//	        //this.setSize(1.375F, 0.5625F);
//	    }
//
//	    public EntityObBoat(Level world, double x, double y, double z)
//	    {
//	    	this(EntityInit.OBBOAT.get(),world);
////	        this.getDeltaMovement().x = 0.0D;
////	        this.getDeltaMovement().y = 0.0D;
////	        this.getDeltaMovement().z = 0.0D;
//        	this.setDeltaMovement(Vec3.ZERO);
//	        this.xo = x;
//	        this.yo = y;
//	        this.zo = z;
//	        this.setPos(x, y, z);
//	    }
//
//
//	    //@Override
//	    protected boolean canTriggerWalking()
//	    {
//	        return false;
//	    }
//
//	    @Override
//	    protected void defineSynchedData() {
//
//	        this.entityData.define(TIME_SINCE_HIT, 0);
//	        this.entityData.define(FORWARD_DIRECTION, 1);
//	        this.entityData.define(DAMAGE_TAKEN, 0.0F);
//	        this.entityData.define(DATA_ID_HURTDIR, 1);
//	        this.entityData.define(DATA_ID_BUBBLE_TIME, 0);
//			this.entityData.define(DATA_ID_TYPE, Type.EBONY.ordinal());
//
//	        for(EntityDataAccessor<Boolean> parameter : DATA_ID_PADDLE)
//	        {
//	            this.entityData.define(parameter, false);
//	        }
//	     }
//
//	    //@Override
//	    public AABB getCollisionBox(Entity entity)
//	    {
//	        return entity.isPushable() ? entity.getBoundingBox() : null;
//	    }
//
//	    //@Override
//	    public AABB getCollisionBoundingBox()
//	    {
//	        return this.getBoundingBox();
//	    }
//
//	    @Override
//	    public boolean isPushable()
//	    {
//	        return true;
//	    }
//
//	    @Override
//	    public double getPassengersRidingOffset()
//	    {
//	        return -0.1D;
//	    }
//
////	    @Override
////	    public boolean hurt(DamageSource source, float amount)
////	    {
////	        if(this.isInvulnerableTo(source))
////	        {
////	            return false;
////	        }
////	        else if(!this.level().isClientSide && !this.isRemoved())
////	        {
//////	            if(source instanceof damageSources() && source.getTrueSource() != null && this.hasPassenger(source.getTrueSource()))
//////	            {
//////	                return false;
//////	            }
//////	            else
//////	            {
////	                this.setBubbleTime(-this.getBubbleTime());
////	                this.setHurtTime(10);
////	                this.setDamage(this.getDamage() + amount * 10.0F);
////	                //this.markVelocityChanged();
////	                boolean takeDamage = source.getEntity() instanceof Player && ((Player)source.getEntity()).getAbilities().instabuild;
////
////	                if(takeDamage || this.getDamage() > 40.0F)
////	                {
////	                    if (!takeDamage && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
////	                        this.spawnAtLocation(this.getDropItem());
////	                     }
////
////	                    this.kill();
////	                }
////
////	                return true;
//////	            }
////	        }
////	        else
////	        {
////	            return true;
////	        }
////	    }
//
//	    private void tickBubbleColumn() {
//	        if (this.level().isClientSide) {
//	           int i = this.getBubbleTime();
//	           if (i > 0) {
//	              this.bubbleMultiplier += 0.05F;
//	           } else {
//	              this.bubbleMultiplier -= 0.1F;
//	           }
//
//	           this.bubbleMultiplier = Mth.clamp(this.bubbleMultiplier, 0.0F, 1.0F);
//	           this.bubbleAngleO = this.bubbleAngle;
//	           this.bubbleAngle = 10.0F * (float)Math.sin((double)(0.5F * (float)this.level().getGameTime())) * this.bubbleMultiplier;
//	        } else {
//	           if (!this.isAboveBubbleColumn) {
//	              this.setBubbleTime(0);
//	           }
//
//	           int k = this.getBubbleTime();
//	           if (k > 0) {
//	              --k;
//	              this.setBubbleTime(k);
//	              int j = 60 - k - 1;
//	              if (j > 0 && k == 0) {
//	                 this.setBubbleTime(0);
//	                 Vec3 vec3 = this.getDeltaMovement();
//	                 if (this.bubbleColumnDirectionIsDown) {
//	                    this.setDeltaMovement(vec3.add(0.0D, -0.7D, 0.0D));
//	                    this.ejectPassengers();
//	                 } else {
//	                    this.setDeltaMovement(vec3.x, this.hasPassenger((p_150274_) -> {
//	                       return p_150274_ instanceof Player;
//	                    }) ? 2.7D : 0.6D, vec3.z);
//	                 }
//	              }
//
//	              this.isAboveBubbleColumn = false;
//	           }
//	        }
//
//	     }
//
//	    public Item getDropItem(){
//	    	return ItemInit.OBBOAT.get();
//	    }
//
//	    public boolean hurt(DamageSource p_38319_, float p_38320_) {
//	        if (this.isInvulnerableTo(p_38319_)) {
//	           return false;
//	        } else if (!this.level().isClientSide && !this.isRemoved()) {
//	           this.setHurtDir(-this.getHurtDir());
//	           this.setHurtTime(10);
//	           this.setDamage(this.getDamage() + p_38320_ * 10.0F);
//	           this.markHurt();
//	           this.gameEvent(GameEvent.ENTITY_DAMAGE, p_38319_.getEntity());
//	           boolean flag = p_38319_.getEntity() instanceof Player && ((Player)p_38319_.getEntity()).getAbilities().instabuild;
//	           if (flag || this.getDamage() > 40.0F) {
//	              if (!flag && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
//	                 this.spawnAtLocation(this.getDropItem());
//	              }
//
//	              this.discard();
//	           }
//
//	           return true;
//	        } else {
//	           return true;
//	        }
//	     }
//
//	    public void onAboveBubbleCol(boolean p_38381_) {
//	        if (!this.level().isClientSide) {
//	           this.isAboveBubbleColumn = true;
//	           this.bubbleColumnDirectionIsDown = p_38381_;
//	           if (this.getBubbleTime() == 0) {
//	              this.setBubbleTime(60);
//	           }
//	        }
//
//	        this.level().addParticle(ParticleTypes.SPLASH, this.getX() + (double)this.random.nextFloat(), this.getY() + 0.7D, this.getZ() + (double)this.random.nextFloat(), 0.0D, 0.0D, 0.0D);
//	        if (this.random.nextInt(20) == 0) {
//	           this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getSwimSplashSound(), this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
//	        }
//
//	        this.gameEvent(GameEvent.SPLASH, this.getControllingPassenger());
//	     }
//
//	    @Override
//	    public void push(Entity entity)
//	    {
//	        if(entity instanceof EntityObBoat)
//	        {
//	            if(entity.getBoundingBox().minY < this.getBoundingBox().maxY)
//	            {
//	                super.push(entity);
//	            }
//	        }
//	        else if(entity.getBoundingBox().minY <= this.getBoundingBox().minY)
//	        {
//	            super.push(entity);
//	        }
//	    }
//
//	    //@Override
//	    @OnlyIn(Dist.CLIENT)
//	    public void animateHurt()
//	    {
//	        this.setBubbleTime(-this.getBubbleTime());
//	        this.setHurtTime(10);
//	        this.setDamage(this.getDamage() * 11.0F);
//	    }
//
//	    @Override
//	    public boolean canBeCollidedWith()
//	    {
//	        return !this.isRemoved();
//	    }
//
//	    @Override
//	    @OnlyIn(Dist.CLIENT)
//	    public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
//	    {
//	        this.boatPitch = x;
//	        this.lerpY = y;
//	        this.lerpZ = z;
//	        this.boatYaw = yaw;
//	        this.lerpXRot = pitch;
//	        this.lerpSteps = 10;
//	    }
//
//	    @Override
//	    public Direction getMotionDirection() {
//	        return this.getDirection().getClockWise();
//	    }
//
//	    @Override
//	    public void tick()
//	    {
//	        this.previousStatus = this.status;
//	        this.status = this.getBoatStatus();
//
//	        if(this.status != Status.UNDER_LAVA && this.status != Status.UNDER_FLOWING_LAVA)
//	        {
//	            this.outOfControlCounter = 0.0F;
//	        }
//	        else
//	        {
//	            this.outOfControlCounter++;
//	        }
//
//	        if(!this.level().isClientSide && this.outOfControlCounter >= 60.0F)
//	        {
//	            this.ejectPassengers();
//	        }
//
//	        if(this.getHurtTime() > 0)
//	        {
//	            this.setHurtTime(this.getHurtTime() - 1);
//	        }
//
//	        if(this.getDamage() > 0.0F)
//	        {
//	            this.setDamage(this.getDamage() - 1.0F);
//	        }
//
//	        this.previousStatus = this.status;
//
////	        this.prevgetX() = this.getX();
////	        this.prevPosY = this.posY;
////	        this.prevPosZ = this.posZ;
//
////	        if(!this.level().isClientSide)
////	        {
////	            this.setFlag(6, this.isGlowing());
////	        }
//
//	        //super.tick();
//	        this.tickLerp();
//	        this.tickBubbleColumn();
//
//	        if(this.isControlledByLocalInstance())
//	        {
//	            if(this.getPassengers().size() == 0 || !(this.getPassengers().get(0) instanceof Player))
//	            {
//	                this.setPaddleState(false, false);
//	            }
//
//	            this.updateMotion();
//
//	            if(this.level().isClientSide)
//	            {
//	                this.controlBoat();
//	                this.level().sendPacketToServer(new ServerboundPaddleBoatPacket(this.getPaddleState(0), this.getPaddleState(1)));
//	            }
//
//	            //this.move(MoverType.SELF, this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z);
//	            this.move(MoverType.SELF, this.getDeltaMovement());
//	        }
//	        else
//	        {
//	        	this.setDeltaMovement(Vec3.ZERO);
//	        }
//
//	        for(int i = 0; i <= 1; i++)
//	        {
//	            if(this.getPaddleState(i))
//	            {
//	                if(!this.isSilent() && (double) (this.paddlePositions[i] % ((float) Math.PI * 2F)) <= (Math.PI / 4D) && ((double) this.paddlePositions[i] + 0.39269909262657166D) % (Math.PI * 2D) >= (Math.PI / 4D))
//	                {
//	                    SoundEvent event = this.getPaddleSound();
//
//	                    if(event != null)
//	                    {
//	                        Vec3 look = this.getViewVector(1.0F);
//	                        double lookX = i == 1 ? -look.z : look.z;
//	                        double lookZ = i == 1 ? look.x : -look.x;
//	                        this.level().playSound(null, this.getX() + lookX, this.getY(), this.getZ() + lookZ, event, this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat());
//	                    }
//	                }
//
//	                this.paddlePositions[i] = (float) ((double) this.paddlePositions[i] + 0.39269909262657166D);
//	            }
//	            else
//	            {
//	                this.paddlePositions[i] = 0.0F;
//	            }
//	        }
//
//	        this.checkInsideBlocks();
//
//	        List<Entity> entities = this.level().getEntities(this, this.getBoundingBox().inflate(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntitySelector.pushableBy(this));
//
//	        if(!entities.isEmpty())
//	        {
//	            boolean flag = !this.level().isClientSide && !(this.getControllingPassenger() instanceof Player);
//
//	            for(Entity entity : entities)
//	            {
//	                if(!entity.hasPassenger(this))
//	                {
//	                    if(flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player))
//	                    {
//	                        entity.startRiding(this);
//	                    }
//	                    else
//	                    {
//	                        this.push(entity);
//	                    }
//	                }
//	            }
//	        }
//	    }
//
//	    protected SoundEvent getPaddleSound() {
//	        switch(this.getStatus()) {
//	        case IN_LAVA:
//	        case UNDER_LAVA:
//	        case UNDER_FLOWING_LAVA:
//	           return SoundEvents.BOAT_PADDLE_WATER;
//	        case ON_LAND:
//	           return SoundEvents.BOAT_PADDLE_LAND;
//	        case IN_AIR:
//	        default:
//	           return null;
//	        }
//	     }
//
////	    @Override
////	    public Item getDropItem()
////	    {
////	        return ItemInit.OBBOAT.get();
////	    }
//
//	    private void tickLerp()
//	    {
//	        if(this.lerpSteps > 0 && !this.isControlledByLocalInstance())
//	        {
//	            double posX = this.getX() + (this.boatPitch - this.getX()) / (double) this.lerpSteps;
//	            double posY = this.getY() + (this.lerpY - this.getY()) / (double) this.lerpSteps;
//	            double posZ = this.getZ() + (this.lerpZ - this.getZ()) / (double) this.lerpSteps;
//	            double yaw = Mth.wrapDegrees(this.boatYaw - (double) this.getYRot());
//
//	            //this.getYRot() = (float) ((double) this.getYRot() + yaw / (double) this.lerpSteps);
//	            //this.rotationPitch = (float) ((double) this.rotationPitch + (this.lerpXRot - (double) this.rotationPitch) / (double) this.lerpSteps);
//	            this.setYRot(this.getYRot() + (float)yaw / (float)this.lerpSteps);
//	            this.setXRot(this.getXRot() + (float)(this.lerpXRot - (double)this.getXRot()) / (float)this.lerpSteps);
//
//	            this.lerpSteps--;
//	            this.setPos(getX(), posY, posZ);
//	            this.setRot(this.getYRot(), this.getXRot());
//	        }
//	    }
//
//	    //@Override
//	    public void setPaddleState(boolean leftPaddle, boolean rightPaddle)
//	    {
//	        this.entityData.set(DATA_ID_PADDLE[0], leftPaddle);
//	        this.entityData.set(DATA_ID_PADDLE[1], rightPaddle);
//	    }
//
//	    //
//	    @OnlyIn(Dist.CLIENT)
//	    public float getRowingTime(int side, float limbSwing)
//	    {
//	        return this.getPaddleState(side) ? (float) Mth.clampedLerp((double) this.paddlePositions[side] - 0.39269909262657166D, this.paddlePositions[side], limbSwing) : 0.0F;
//	    }
//
//	    private Status getBoatStatus()
//	    {
//	        Status status = this.getUnderLavaStatus();
//
//	        if(status != null)
//	        {
//	            this.lavaLevel = this.getBoundingBox().maxY;
//	            return status;
//	        }
//	        else if(this.checkInLava())
//	        {
//	            return Status.IN_LAVA;
//	        }
//	        else
//	        {
//	            float f = this.getGroundFriction();
//
//	            if(f > 0.0F)
//	            {
//	                this.boatGlide = f;
//	                return Status.ON_LAND;
//	            }
//	            else
//	            {
//	                return Status.IN_AIR;
//	            }
//	        }
//	    }
//
//	    private float getLavaLevelAbove()
//	    {
////	        AABB boundingBox = this.getBoundingBox();
////	        int minX = Mth.floor(boundingBox.minX);
////	        int maxX = Mth.ceil(boundingBox.maxX);
////	        int minY = Mth.floor(boundingBox.maxY);
////	        int maxY = Mth.ceil(boundingBox.maxY - this.lastYd);
////	        int minZ = Mth.floor(boundingBox.minZ);
////	        int maxZ = Mth.ceil(boundingBox.maxZ);
////	        //BlockPos.MutableBlockPos mutableBlockPos = BlockPos.MutableBlockPos.retain();
////	        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
////
//////	        try
//////	        {
////	            label78:
////
////	            for(int y = minY; y < maxY; y++)
////	            {
////	                float liquidHeight = 0.0F;
////	                int x = minX;
////
////	                while(true)
////	                {
////	                    if(x >= maxX)
////	                    {
////	                        if(liquidHeight < 1.0F)
////	                        {
////	                            return (float) mutableBlockPos.getY() + liquidHeight;
////	                        }
////
////	                        break;
////	                    }
////
////	                    for(int z = minZ; z < maxZ; z++)
////	                    {
////	                        mutableBlockPos.set(x, y, z);
////	                        //IBlockState state = this.world.getBlockState(mutableBlockPos);
////	                        FluidState fluidstate = this.level().getFluidState(mutableBlockPos);
////
////	                        if(fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA))
////	                        {
////	                            liquidHeight = Math.max(liquidHeight, fluidstate.getHeight(this.level(), mutableBlockPos));
////	                        }
////
////	                        if(liquidHeight >= 1.0F)
////	                        {
////	                            continue label78;
////	                        }
////	                    }
////
////	                    x++;
////	                }
////	            }
////
////	            return (float) (maxY + 1);
////	        }
////	        finally
////	        {
////	            mutableBlockPos.above();
////	        }
//	        AABB aabb = this.getBoundingBox();
//	        int i = Mth.floor(aabb.minX);
//	        int j = Mth.ceil(aabb.maxX);
//	        int k = Mth.floor(aabb.maxY);
//	        int l = Mth.ceil(aabb.maxY - this.lastYd);
//	        int i1 = Mth.floor(aabb.minZ);
//	        int j1 = Mth.ceil(aabb.maxZ);
//	        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//	        label39:
//	        for(int k1 = k; k1 < l; ++k1) {
//	           float f = 0.0F;
//
//	           for(int l1 = i; l1 < j; ++l1) {
//	              for(int i2 = i1; i2 < j1; ++i2) {
//	                 blockpos$mutableblockpos.set(l1, k1, i2);
//	                 FluidState fluidstate = this.level().getFluidState(blockpos$mutableblockpos);
//	                 if (fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)) {
//	                    f = Math.max(f, fluidstate.getHeight(this.level(), blockpos$mutableblockpos));
//	                 }
//
//	                 if (f >= 1.0F) {
//	                    continue label39;
//	                 }
//	              }
//	           }
//
//	           if (f < 1.0F) {
//	              return (float)blockpos$mutableblockpos.getY() + f;
//	           }
//	        }
//
//	        return (float)(l + 1);
//	    }
//
//	    //@Override
//	    public float getGroundFriction()
//	    {
////	        AABB entityBoundingBox = this.getBoundingBox();
////	        AABB boundingBox = new AABB(entityBoundingBox.minX, entityBoundingBox.minY - 0.001D, entityBoundingBox.minZ, entityBoundingBox.maxX, entityBoundingBox.minY, entityBoundingBox.maxZ);
////	        int minX = Mth.floor(boundingBox.minX) - 1;
////	        int maxX = Mth.ceil(boundingBox.maxX) + 1;
////	        int minY = Mth.floor(boundingBox.minY) - 1;
////	        int maxY = Mth.ceil(boundingBox.maxY) + 1;
////	        int minZ = Mth.floor(boundingBox.minZ) - 1;
////	        int maxZ = Mth.ceil(boundingBox.maxZ) + 1;
////
////	        List<AABB> list = new ArrayList<>();
////	        VoxelShape voxelshape = Shapes.create(entityBoundingBox);
////
////	        float slipperiness = 0.0F;
////	        int friction = 0;
////	        //BlockPos.MutableBlockPos mutableBlockPos = BlockPos.MutableBlockPos.retain();
////	        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
////
//////	        try
//////	        {
////	            for(int x = minX; x < maxX; x++)
////	            {
////	                for(int z = minZ; z < maxZ; z++)
////	                {
////	                    int offset = (x != minX && x != maxX - 1 ? 0 : 1) + (z != minZ && z != maxZ - 1 ? 0 : 1);
////
////	                    if(offset != 2)
////	                    {
////	                        for(int y = minY; y < maxY; y++)
////	                        {
////	                            if(offset <= 0 || y != minY && y != maxY - 1)
////	                            {
////	                                mutableBlockPos.set(x, y, z);
////	                                BlockState blockstate = this.level().getBlockState(mutableBlockPos);
////	    	  	                    //FluidState fluidstate = this.level().getFluidState(mutableBlockPos);
////
////	                                //blockstate.addCollisionBoxToList(this.level(), mutableBlockPos, boundingBox, list, this, false);
////	                                if (!(blockstate.getBlock() instanceof WaterlilyBlock)
////	                                		&& Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level(), mutableBlockPos).move((double)x, (double)y, (double)z), voxelshape, BooleanOp.AND)) {
////	                                	slipperiness += blockstate.getFriction(this.level(), mutableBlockPos, this);
////	                                   ++friction;
////	                                }
//////	                                if(!list.isEmpty())
//////	                                {
//////	                                    slipperiness += blockstate.getBlock().getFriction(blockstate, this.level(), mutableBlockPos, this);
//////	                                    friction++;
//////	                                }
////
////	                                list.clear();
////	                            }
////	                        }
////	                    }
////	                }
////	            }
//////	        }
//////	        finally
//////	        {
//////	            mutableBlockPos.release();
//////	        }
////
////	        return slipperiness / (float) friction;
//	        AABB aabb = this.getBoundingBox();
//	        AABB aabb1 = new AABB(aabb.minX, aabb.minY - 0.001D, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
//	        int i = Mth.floor(aabb1.minX) - 1;
//	        int j = Mth.ceil(aabb1.maxX) + 1;
//	        int k = Mth.floor(aabb1.minY) - 1;
//	        int l = Mth.ceil(aabb1.maxY) + 1;
//	        int i1 = Mth.floor(aabb1.minZ) - 1;
//	        int j1 = Mth.ceil(aabb1.maxZ) + 1;
//	        VoxelShape voxelshape = Shapes.create(aabb1);
//	        float f = 0.0F;
//	        int k1 = 0;
//	        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//	        for(int l1 = i; l1 < j; ++l1) {
//	           for(int i2 = i1; i2 < j1; ++i2) {
//	              int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
//	              if (j2 != 2) {
//	                 for(int k2 = k; k2 < l; ++k2) {
//	                    if (j2 <= 0 || k2 != k && k2 != l - 1) {
//	                       blockpos$mutableblockpos.set(l1, k2, i2);
//	                       BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
//	                       if (!(blockstate.getBlock() instanceof WaterlilyBlock) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level(), blockpos$mutableblockpos).move((double)l1, (double)k2, (double)i2), voxelshape, BooleanOp.AND)) {
//	                          f += blockstate.getFriction(this.level(), blockpos$mutableblockpos, this);
//	                          ++k1;
//	                       }
//	                    }
//	                 }
//	              }
//	           }
//	        }
//
//	        return f / (float)k1;
//	    }
//
//	    private boolean checkInLava()
//	    {
//	        AABB entityBoundingBox = this.getBoundingBox();
//	        int minX = Mth.floor(entityBoundingBox.minX);
//	        int maxX = Mth.ceil(entityBoundingBox.maxX);
//	        int minY = Mth.floor(entityBoundingBox.minY);
//	        int maxY = Mth.ceil(entityBoundingBox.minY + 0.001D);
//	        int minZ = Mth.floor(entityBoundingBox.minZ);
//	        int maxZ = Mth.ceil(entityBoundingBox.maxZ);
//	        boolean flag = false;
//	        this.lavaLevel = -Double.MAX_VALUE;
//	        //BlockPos.MutableBlockPos mutableBlockPos = BlockPos.MutableBlockPos.retain();
//	        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
//
//
//	            for(int x = minX; x < maxX; x++)
//	            {
//	                for(int y = minY; y < maxY; y++)
//	                {
//	                    for(int z = minZ; z < maxZ; z++)
//	                    {
//	                        mutableBlockPos.set(x, y, z);
//	  	                    FluidState fluidstate = this.level().getFluidState(mutableBlockPos);
//
//	                        if((fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)))
//	                        {
////	                            float liquidHeight = fluidstate.getHeight(this.level(), mutableBlockPos);
////	                            this.lavaLevel = Math.max(liquidHeight, this.lavaLevel);
////	                            flag |= entityBoundingBox.minY < (double) liquidHeight;
//	                            float f = (float)y + fluidstate.getHeight(this.level(), mutableBlockPos);
//	                            this.lavaLevel = Math.max((double)f, this.lavaLevel);
//	                            flag |= entityBoundingBox.minY < (double)f;
//	                        }
//	                    }
//	                }
//	            }
//
//
//	        return flag;
//	    }
//
//	    private Status getUnderLavaStatus()
//	    {
//	        AABB entityBoundingBox = this.getBoundingBox();
//	        double entityHeight = entityBoundingBox.maxY + 0.001D;
//	        int minX = Mth.floor(entityBoundingBox.minX);
//	        int maxX = Mth.ceil(entityBoundingBox.maxX);
//	        int minY = Mth.floor(entityBoundingBox.maxY);
//	        int maxY = Mth.ceil(entityHeight);
//	        int minZ = Mth.floor(entityBoundingBox.minZ);
//	        int maxZ = Mth.ceil(entityBoundingBox.maxZ);
//	        boolean flag = false;
//	        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
//	        for(int k1 = minX; k1 < maxX; ++k1) {
//	            for(int l1 = minY; l1 < maxY; ++l1) {
//	               for(int i2 = minZ; i2 < maxZ; ++i2) {
//	            	   mutableBlockPos.set(k1, l1, i2);
//	                  FluidState fluidstate = this.level().getFluidState(mutableBlockPos);
//	                  if ((fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)) && entityHeight < (double)((float)mutableBlockPos.getY() +
//	                		  fluidstate.getHeight(this.level(), mutableBlockPos))) {
//	                     if (!fluidstate.isSource()) {
//	                        return Status.UNDER_FLOWING_LAVA;
//	                     }
//
//	                     flag = true;
//	                  }
//	               }
//	            }
//	         }
//
//	        return flag ? Status.UNDER_LAVA : null;
//	    }
//
//	    private void updateMotion()
//	    {
//	        double gravity = this.isNoGravity() ? 0.0D : -0.03999999910593033D;
//	        double position = 0.0D;
//	        this.invFriction = 0.05F;
//
//	        if(this.previousStatus == Status.IN_AIR && this.status != Status.IN_AIR && this.status != Status.ON_LAND)
//	        {
//	            this.lavaLevel = this.getY(1.0D); // + (double) this.height;
//	            this.setPos(this.getX(), (double) (this.getLavaLevelAbove() - this.getBbHeight()) + 0.101D, this.getZ());
//	            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
//	            this.lastYd = 0.0D;
//	            this.status = Status.IN_LAVA;
//	        }
//	        else
//	        {
//	            if(this.status == Status.IN_LAVA)
//	            {
//	                position = (this.lavaLevel - this.getY()) / (double) this.getBbHeight();
//	                this.invFriction = 0.9F;
//	            }
//	            else if(this.status == Status.UNDER_FLOWING_LAVA)
//	            {
//	                gravity = -7.0E-4D;
//	                this.invFriction = 0.9F;
//	            }
//	            else if(this.status == Status.UNDER_LAVA)
//	            {
//	                position = 0.009999999776482582D;
//	                this.invFriction = 0.45F;
//	            }
//	            else if(this.status == Status.IN_AIR)
//	            {
//	            	this.invFriction = 0.9F;
//	            }
//	            else if(this.status == Status.ON_LAND)
//	            {
//	            	this.invFriction = this.boatGlide;
//
//	                if(this.getControllingPassenger() instanceof Player)
//	                {
//	                    this.boatGlide /= 2.0F;
//	                }
//	            }
//
//	            //this.getDeltaMovement().x *= momentum;
//	            //this.getDeltaMovement().z *= momentum;
////	            Vec3 vec3 = this.getDeltaMovement();
////	            this.setDeltaMovement(vec3.x * (double)momentum, vec3.y + gravity, vec3.z * (double)momentum);
////
////	            this.deltaRotation *= momentum;
////	            this.getDeltaMovement().add(0.0D, gravity, 0.0D);// += gravity;
////
////	            if(position > 0.0D)
////	            {
//////	                this.getDeltaMovement().y += position * 0.06153846016296973D;
//////	                this.getDeltaMovement().y *= 0.75D;
////	                Vec3 vec31 = this.getDeltaMovement();
////	                this.setDeltaMovement(vec31.x, (vec31.y + position * 0.06153846016296973D) * 0.75D, vec31.z);
////	            }
//	            Vec3 vec3 = this.getDeltaMovement();
//	            this.setDeltaMovement(vec3.x * (double)this.invFriction, vec3.y + gravity, vec3.z * this.invFriction);
//	            this.deltaRotation *= this.invFriction;
//	            if (position > 0.0D) {
//	               Vec3 vec31 = this.getDeltaMovement();
//	               this.setDeltaMovement(vec31.x, (vec31.y + position * 0.06153846016296973D) * 0.75D, vec31.z);
//	            }
//	        }
//	    }
//
//	    private void controlBoat()
//	    {
//	        if(this.isVehicle())
//	        {
//	            float speed = 0.0F;
//
//	            if(this.leftInputDown)
//	            {
//	                this.deltaRotation += -1.0F;
//	            }
//
//	            if(this.rightInputDown)
//	            {
//	                this.deltaRotation++;
//	            }
//
//	            if(this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
//	            {
//	                speed += 0.005F;
//	            }
//
//	            //this.getYRot() += this.deltaRotation;
//	            this.setYRot(this.getYRot() + this.deltaRotation);
//	            if(this.forwardInputDown)
//	            {
//	                speed += 0.04F;
//	            }
//
//	            if(this.backInputDown)
//	            {
//	                speed -= 0.005F;
//	            }
//
//	            this.setDeltaMovement(this.getDeltaMovement().add((double)(Mth.sin(-this.getYRot() * ((float)Math.PI / 180F)) * speed),
//	            		0D, (double)(Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * speed)));
////	            this.getDeltaMovement().x += (Mth.sin(-this.getYRot() * 0.017453292F) * speed);
////	            this.getDeltaMovement().z += (Mth.cos(this.getYRot() * 0.017453292F) * speed);
//	            this.setPaddleState(this.rightInputDown && !this.leftInputDown || this.forwardInputDown, this.leftInputDown && !this.rightInputDown || this.forwardInputDown);
//	        }
//	    }
//
//
//	    @Override
//	    public void positionRider(Entity passenger, MoveFunction moveFunction)
//	    {
//	        ((LivingEntity)passenger).addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100));
//	        if(this.hasPassenger(passenger))
//	        {
//	            float x = 0.0F;
//	            float height = (float) ((this.isRemoved() ? 0.009999999776482582D : this.getPassengersRidingOffset()) + passenger.getMyRidingOffset());
//
//	            if(this.getPassengers().size() > 1)
//	            {
//	                int index = this.getPassengers().indexOf(passenger);
//
//	                if(index == 0)
//	                {
//	                    x = 0.2F;
//	                }
//	                else
//	                {
//	                    x = -0.6F;
//	                }
//
//	                if(passenger instanceof Animal)
//	                {
//	                    x = (float) ((double) x + 0.2D);
//	                }
//	            }
//
//	            Vec3 pos = (new Vec3(x, 0.0D, 0.0D)).yRot(-this.getYRot() * 0.017453292F - ((float) Math.PI / 2F));
//	            passenger.setPos(this.position().x + pos.x, this.position().y + (double) height, this.position().z + pos.z);
//	            passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
//	            passenger.setYRot(passenger.getYRot() + this.deltaRotation);
//	            this.clampRotation(passenger);
//
//	            if(passenger instanceof Animal && this.getPassengers().size() > 1)
//	            {
//	                int rotation = passenger.getId() % 2 == 0 ? 90 : 270;
//	                passenger.setYBodyRot(((Animal)passenger).yBodyRot + (float)rotation);
//	                passenger.setYHeadRot(passenger.getYHeadRot() + (float)rotation);
//	            }
//
////	            if(this.isInsideOfMaterial(Material.WATER))
////	            {
////	                passenger.dismountRidingEntity();
////	            }
//	        }
//	    }
//
//	    public Vec3 getDismountLocationForPassenger(LivingEntity p_38357_) {
//	        Vec3 vec3 = getCollisionHorizontalEscapeVector((double)(this.getBbWidth() * Mth.SQRT_OF_TWO), (double)p_38357_.getBbWidth(), p_38357_.getYRot());
//	        double d0 = this.getX() + vec3.x;
//	        double d1 = this.getZ() + vec3.z;
//	        BlockPos blockpos = new BlockPos(Mth.floor(d0), Mth.floor(this.getBoundingBox().maxY), Mth.floor(d1));
//	        BlockPos blockpos1 = blockpos.below();
//	        if (!this.level().getFluidState(blockpos1).is(FluidTags.WATER) || !this.level().getFluidState(blockpos1).is(FluidTags.LAVA)) {
//	           List<Vec3> list = Lists.newArrayList();
//	           double d2 = this.level().getBlockFloorHeight(blockpos);
//	           if (DismountHelper.isBlockFloorValid(d2)) {
//	              list.add(new Vec3(d0, (double)blockpos.getY() + d2, d1));
//	           }
//
//	           double d3 = this.level().getBlockFloorHeight(blockpos1);
//	           if (DismountHelper.isBlockFloorValid(d3)) {
//	              list.add(new Vec3(d0, (double)blockpos1.getY() + d3, d1));
//	           }
//
//	           for(Pose pose : p_38357_.getDismountPoses()) {
//	              for(Vec3 vec31 : list) {
//	                 if (DismountHelper.canDismountTo(this.level(), vec31, p_38357_, pose)) {
//	                    p_38357_.setPose(pose);
//	                    return vec31;
//	                 }
//	              }
//	           }
//	        }
//
//	        return super.getDismountLocationForPassenger(p_38357_);
//	     }
//
//	    //@Override
//	    protected void clampRotation(Entity entityToUpdate) {
//	        entityToUpdate.setYBodyRot(this.getYRot());
//	        float f = Mth.wrapDegrees(entityToUpdate.getYRot() - this.getYRot());
//	        float f1 = Mth.clamp(f, -105.0F, 105.0F);
//	        entityToUpdate.yRotO += f1 - f;
//	        entityToUpdate.setYRot(entityToUpdate.getYRot() + f1 - f);
//	        entityToUpdate.setYHeadRot(entityToUpdate.getYRot());
//	     }
//
//	    //@Override
//	    @OnlyIn(Dist.CLIENT)
//	    public void onPassengerTurned(Entity entityToUpdate) {
//	        this.clampRotation(entityToUpdate);
//	     }
//
//	    //@Override
//	    protected void addAdditionalSaveData(CompoundTag p_38359_) {
//	    }
//
//	    //@Override
//	    protected void readAdditionalSaveData(CompoundTag p_38338_) {
//
//	    }
//
//	    public Type getBoatType() {
//	        return Type.EBONY;
//	     }
//
//	    @Override
//	    public InteractionResult interact(Player player, InteractionHand hand)
//	    {
////	        if(player.isSecondaryUseActive())
////	        {
////	            return InteractionResult.PASS;
////	        }
////	        else
////	        {
////	            if(!this.level().isClientSide && this.outOfControlCounter < 60.0F && !this.isInsideOfMaterial(Material.WATER))
////	            {
////	                player.startRiding(this);
////	            }
////
////	            return InteractionResult.SUCCESS;
////	        }
//	        if (player.isSecondaryUseActive()) {
//	            return InteractionResult.PASS;
//	         } else if (this.outOfControlCounter < 60.0F) {
//	            if (!this.level().isClientSide) {
//	               return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
//	            } else {
//	               return InteractionResult.SUCCESS;
//	            }
//	         } else {
//	            return InteractionResult.PASS;
//	         }
//	    }
//
//	    @Override
//	    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos)
//	    {
//	        this.lastYd = this.getDeltaMovement().y;
//
//	        if(!this.isPassenger())
//	        {
//	            if(onGround)
//	            {
//	                if(this.fallDistance > 3.0F)
//	                {
//	                    if(this.status != Status.ON_LAND)
//	                    {
//	                        this.fallDistance = 0.0F;
//	                        return;
//	                    }
//
//	                    this.causeFallDamage(this.fallDistance, 1.0F, damageSources().fall());
//	                    if(!this.level().isClientSide && !this.isRemoved())
//	                    {
//	                        this.kill();
//
//	                        if(this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS))
//	                        {
//	                            for(int i = 0; i < 3; i++)
//	                            {
//	                                //this.entityDropItem(new ItemStack(Blocks.OBSIDIAN, 1, 0), 0.0F);
//	                                this.spawnAtLocation(new ItemStack(BlockInit.EBONY_PLANKS.get()), 0.0F);
//	                            }
//	                        }
//	                    }
//	                }
//
//	                this.fallDistance = 0.0F;
//	            }
//	            else if((!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.LAVA) && y < 0.0D) ||
//	                    (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && y < 0.0D) )
//	            {
//	                this.fallDistance = (float) ((double) this.fallDistance - y);
//	            }
//	        }
//	    }
//
//	    //@Override
//	    public boolean getPaddleState(int state)
//	    {
//	        return this.entityData.get(DATA_ID_PADDLE[state]) && this.getControllingPassenger() != null;
//
//	    }
//
//	    //@Override
//	    public void setDamage(float Damage)
//	    {
//	        this.entityData.set(DAMAGE_TAKEN, Damage);
//	    }
//
//	    //@Override
//	    public float getDamage()
//	    {
//	        return this.entityData.get(DAMAGE_TAKEN);
//	    }
//
//	    @Override
//	    public void setHurtTime(int HurtTime)
//	    {
//	        this.entityData.set(TIME_SINCE_HIT, HurtTime);
//	    }
//
//	    public void setHurtDir(int p_38363_) {
//	        this.entityData.set(DATA_ID_HURTDIR, p_38363_);
//	     }
//
//	    public int getHurtDir() {
//	        return this.entityData.get(DATA_ID_HURTDIR);
//	     }
//
//	    @Override
//	    public int getHurtTime()
//	    {
//	        return this.entityData.get(TIME_SINCE_HIT);
//	    }
//
//	    //@Override
//	    public void setBubbleTime1(int bubbleTime)
//	    {
//	        this.entityData.set(FORWARD_DIRECTION, bubbleTime);
//	    }
//
//	    //@Override
//	    public int getBubbleTime1()
//	    {
//	        return this.entityData.get(FORWARD_DIRECTION);
//	    }
//
//	    private void setBubbleTime(int p_38367_) {
//	        this.entityData.set(DATA_ID_BUBBLE_TIME, p_38367_);
//	     }
//
//	     private int getBubbleTime() {
//	        return this.entityData.get(DATA_ID_BUBBLE_TIME);
//	     }
//	    @Override
//	    protected boolean canAddPassenger(Entity passenger)
//	    {
//	        return this.getPassengers().size() < 2;
//	    }
//
//	    @Override
//	    public LivingEntity getControllingPassenger()
//	    {
//	        List<Entity> passengers = this.getPassengers();
//	        return passengers.isEmpty() ? null : (LivingEntity)passengers.get(0);
//	    }
//
//	    //@Override
//	    @OnlyIn(Dist.CLIENT)
//	    public void setInput(boolean left, boolean right, boolean forward, boolean back)
//	    {
//	        this.leftInputDown = left;
//	        this.rightInputDown = right;
//	        this.forwardInputDown = forward;
//	        this.backInputDown = back;
//	    }
//
//	    public enum Status
//	    {
//	        IN_LAVA,
//	        UNDER_LAVA,
//	        UNDER_FLOWING_LAVA,
//	        ON_LAND,
//	        IN_AIR
//	    }
//
////	    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
////	        if (event.isMoving()) {
////	            event.setAndContinue(RawAnimation.begin().thenPlay("animation.obboat.idle"));
////	            return PlayState.CONTINUE;
////	        }
////
//////	        if (this.isPathFinding()) {
//////	          event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.attack"));
//////	          return PlayState.CONTINUE;
//////	        }
//////	        if (this.isSitting()) {
//////	            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.attack"));
//////	            return PlayState.CONTINUE;
//////	        }
////
////	        event.setAndContinue(RawAnimation.begin().thenPlay("animation.obboat.idle"));
////	        return PlayState.CONTINUE;
////	    }
////
////		@Override
////		public void registerControllers(AnimatableManager.ControllerRegistrar data) {
////	        data.add(new AnimationController(this, "controller",
////	                0, this::predicate));
////		}
////
////		@Override
////		public AnimatableInstanceCache getAnimatableInstanceCache() {
////			// TODO Auto-generated method stub
////			return this.factory;
////		}
////
//		private Status getStatus() {
//			 Status boat$status = this.getUnderLavaStatus();
//			 if (boat$status != null) {
//			         this.lavaLevel = this.getBoundingBox().maxY;
//			         return boat$status;
//			 } else if (this.checkInLava()) {
//			         return Status.IN_LAVA;
//			 } else {
//			         float f = this.getGroundFriction();
//			         if (f > 0.0F) {
//			            this.boatGlide = f;
//			            return Status.ON_LAND;
//			         } else {
//			            return Status.IN_AIR;
//			         }
//			      }
//		}
//
//	public static enum Type implements StringRepresentable {
//		EBONY(BlockInit.EBONY_PLANKS.get(), "obboat1");
//
//		private final String name;
//		private final Block planks;
//		public static final StringRepresentable.EnumCodec<EntityObBoat.Type> CODEC = StringRepresentable.fromEnum(EntityObBoat.Type::values);
//		private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
//
//		private Type(Block pPlanks, String pName) {
//			this.name = pName;
//			this.planks = pPlanks;
//		}
//
//		public String getSerializedName() {
//			return this.name;
//		}
//
//		public String getName() {
//			return this.name;
//		}
//
//		public Block getPlanks() {
//			return this.planks;
//		}
//
//		public String toString() {
//			return this.name;
//		}
//
//		/**
//		 * Get a boat type by its enum ordinal
//		 */
//		public static EntityObBoat.Type byId(int pId) {
//			return BY_ID.apply(pId);
//		}
//
//		public static EntityObBoat.Type byName(String pName) {
//			return CODEC.byName(pName, EBONY);
//		}
//	}
//
//	public void setVariant(EntityObBoat.Type pVariant) {
//		this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
//	}
//
//	public EntityObBoat.Type getModVariant() {
//		return EntityObBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
//	}
//}
