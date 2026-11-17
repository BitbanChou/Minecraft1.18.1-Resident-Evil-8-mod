package com.joy187.re8joymod.common.blocks;

//
//

//import com.joy187.re8joymod.common.init.DimensionInit;
//import com.joy187.re8joymod.common.init.ModBlocks;
//import com.joy187.re8joymod.common.world.portal.ModTeleporter;
//import com.joy187.re8joymod.helper.ModTags;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.PortalSize;
//import net.minecraft.block.material.Material;
//import net.minecraft.entity.Entity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.state.EnumProperty;
//import net.minecraft.state.StateContainer;
//import net.minecraft.state.properties.BlockStateProperties;
//import net.minecraft.util.*;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.shapes.ISelectionContext;
//import net.minecraft.util.math.shapes.VoxelShape;
//import net.minecraft.world.IBlockReader;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.World;
//import net.minecraft.world.server.ServerWorld;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.event.world.BlockEvent;
//import net.minecraftforge.eventbus.api.Cancelable;
//
//import javax.annotation.Nullable;
//import java.util.Random;
//
//public class RE8PortalBlock extends Block {
//    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
//    protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
//    protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
//    public RE8PortalBlock() {
//        super(Properties.of(Material.PORTAL)
//                .strength(-1F)
//                .noCollission()
//                .lightLevel((state) -> 10)
//                .noDrops()
//        );
//        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        switch(state.getValue(AXIS)) {
//            case Z:
//                return Z_AABB;
//            case X:
//            default:
//                return X_AABB;
//        }
//    }
//
//    public boolean trySpawnPortal(World worldIn, BlockPos pos) {
//        Size KJPortalBlock$size = this.isPortal(worldIn, pos);
//        if (KJPortalBlock$size != null && !onTrySpawnPortal(worldIn, pos, KJPortalBlock$size)) {
//            KJPortalBlock$size.placePortalBlocks();
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean onTrySpawnPortal(World world, BlockPos pos, Size size) {
//        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
//    }
//
//    @Cancelable
//    public static class PortalSpawnEvent extends BlockEvent {
//        private final Size size;
//
//        public PortalSpawnEvent(World world, BlockPos pos, BlockState state, Size size) {
//            super(world, pos, state);
//            this.size = size;
//        }
//
//        public Size getPortalSize()
//        {
//            return size;
//        }
//    }
//
//    @Nullable
//    public Size isPortal(World worldIn, BlockPos pos) {
//        Size KJPortalBlock$size = new Size(worldIn, pos, Direction.Axis.X);
//        if (KJPortalBlock$size.isValid() && KJPortalBlock$size.portalBlockCount == 0) {
//            return KJPortalBlock$size;
//        } else {
//            Size KaupenPortalBlock$size1 = new Size(worldIn, pos, Direction.Axis.Z);
//            return KaupenPortalBlock$size1.isValid() && KaupenPortalBlock$size1.portalBlockCount == 0 ? KaupenPortalBlock$size1 : null;
//        }
//    }
//
//    @Override
////    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, World worldIn, BlockPos currentPos, BlockPos facingPos) {
////        Direction.Axis direction$axis = facing.getAxis();
////        Direction.Axis direction$axis1 = stateIn.getValue(AXIS);
////        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
////        return !flag && facingState.getBlock() != this && !(new Size(worldIn, currentPos, direction$axis1)).validatePortal() ?
////                Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
////    }
//    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
//        Direction.Axis direction$axis = p_196271_2_.getAxis();
//        Direction.Axis direction$axis1 = p_196271_1_.getValue(AXIS);
//        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
//        return !flag && !p_196271_3_.is(this) && !(new PortalSize(p_196271_4_, p_196271_5_, direction$axis1)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
//    }

//    @Override
//    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entity) {
//        if(!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
//            if(entity.isOnPortalCooldown()) {
//                entity.setPortalCooldown();
//            }
//            else {
////                if(!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) {
////                    entity.portalEntrancePos = pos.immutable();
////                }
//                World entityWorld = entity.level;
//                if(entityWorld != null) {
//                    MinecraftServer minecraftserver = entityWorld.getServer();
//                    RegistryKey<World> destination = entity.level.dimension() == DimensionInit.RE8_DIMENSTON_WORLD
//                            ? World.OVERWORLD : DimensionInit.RE8_DIMENSTON_WORLD;
//                    if(minecraftserver != null) {
//                        ServerWorld destinationWorld = minecraftserver.getLevel(destination);
//                        if(destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
//                            entity.level.getProfiler().push("re8_portal");
//                            entity.setPortalCooldown();
//                            entity.changeDimension(destinationWorld, new ModTeleporter(destinationWorld));
//                            entity.level.getProfiler().pop();
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
//        if (rand.nextInt(100) == 0) {
//            worldIn.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D,
//                    (double)pos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT,
//                    SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
//        }
//
//        for(int i = 0; i < 4; ++i) {
//            double x = (double)pos.getX() + rand.nextDouble();
//            double y = (double)pos.getY() + rand.nextDouble();
//            double z = (double)pos.getZ() + rand.nextDouble();
//            double xSpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
//            double ySpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
//            double zSpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
//            int j = rand.nextInt(2) * 2 - 1;
//            if (!worldIn.getBlockState(pos.west()).is(this) && !worldIn.getBlockState(pos.east()).is(this)) {
//                x = (double)pos.getX() + 0.5D + 0.25D * (double)j;
//                xSpeed = rand.nextFloat() * 2.0F * (float)j;
//            } else {
//                z = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
//                zSpeed = rand.nextFloat() * 2.0F * (float)j;
//            }
//
//            // TODO: Particles
//            // worldIn.addParticle(PARTICLE_TYPE, x, y, z, xSpeed, ySpeed, zSpeed);
//        }
//    }
//
//    @Override
//    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
//        return ItemStack.EMPTY;
//    }
//
//    @Override
//    public BlockState rotate(BlockState state, Rotation rot) {
//        switch(rot) {
//            case COUNTERCLOCKWISE_90:
//            case CLOCKWISE_90:
//                switch(state.getValue(AXIS)) {
//                    case Z:
//                        return state.setValue(AXIS, Direction.Axis.X);
//                    case X:
//                        return state.setValue(AXIS, Direction.Axis.Z);
//                    default:
//                        return state;
//                }
//            default:
//                return state;
//        }
//    }
//
//    @Override
//    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
//        builder.add(AXIS);
//    }
//
//    public static class Size {
//        private final World level;
//        private final Direction.Axis axis;
//        private final Direction rightDir;
//        private final Direction leftDir;
//        private int portalBlockCount;
//        @Nullable
//        private BlockPos bottomLeft;
//        private int height;
//        private int width;
//
//        public Size(World level, BlockPos pos, Direction.Axis axis) {
//            this.level = level;
//            this.axis = axis;
//            if (axis == Direction.Axis.X) {
//                this.leftDir = Direction.EAST;
//                this.rightDir = Direction.WEST;
//            } else {
//                this.leftDir = Direction.NORTH;
//                this.rightDir = Direction.SOUTH;
//            }
//
//            for(BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.canConnect(level.getBlockState(pos.below())); pos = pos.below()) {
//            }
//
//            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
//            if (i >= 0) {
//                this.bottomLeft = pos.relative(this.leftDir, i);
//                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
//                if (this.width < 2 || this.width > 21) {
//                    this.bottomLeft = null;
//                    this.width = 0;
//                }
//            }
//
//            if (this.bottomLeft != null) {
//                this.height = this.calculatePortalHeight();
//            }
//
//        }
//
//        protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
//            int i;
//            for(i = 0; i < 22; ++i) {
//                BlockPos blockpos = pos.relative(directionIn, i);
//                if(!this.canConnect(this.level.getBlockState(blockpos)) ||
//                        !(this.level.getBlockState(blockpos.below()).is(ModTags.Blocks.PORTAL_FRAME_BLOCKS))) {
//                    break;
//                }
//            }
//
//            BlockPos framePos = pos.relative(directionIn, i);
//            return this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCKS) ? i : 0;
//        }
//
//        public int getHeight() {
//            return this.height;
//        }
//
//        public int getWidth() {
//            return this.width;
//        }
//
//        protected int calculatePortalHeight() {
//            label56:
//            for(this.height = 0; this.height < 21; ++this.height) {
//                for(int i = 0; i < this.width; ++i) {
//                    BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
//                    BlockState blockstate = this.level.getBlockState(blockpos);
//                    if (!this.canConnect(blockstate)) {
//                        break label56;
//                    }
//
//                    Block block = blockstate.getBlock();
//                    if (block == ModBlocks.RE8_PORTAL.get()) {
//                        ++this.portalBlockCount;
//                    }
//
//                    if (i == 0) {
//                        BlockPos framePos = blockpos.relative(this.leftDir);
//                        if (!(this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCKS))) {
//                            break label56;
//                        }
//                    } else if (i == this.width - 1) {
//                        BlockPos framePos = blockpos.relative(this.rightDir);
//                        if (!(this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCKS))) {
//                            break label56;
//                        }
//                    }
//                }
//            }
//
//            for(int j = 0; j < this.width; ++j) {
//                BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
//                if (!(this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCKS))) {
//                    this.height = 0;
//                    break;
//                }
//            }
//
//            if (this.height <= 21 && this.height >= 3) {
//                return this.height;
//            } else {
//                this.bottomLeft = null;
//                this.width = 0;
//                this.height = 0;
//                return 0;
//            }
//        }
//
//        protected boolean canConnect(BlockState pos) {
//            Block block = pos.getBlock();
//            return pos.isAir() || block == ModBlocks.RE8_PORTAL.get();
//        }
//
//        public boolean isValid() {
//            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
//        }
//
//        public void placePortalBlocks() {
//            for(int i = 0; i < this.width; ++i) {
//                BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);
//
//                for(int j = 0; j < this.height; ++j) {
//                    this.level.setBlock(blockpos.above(j), ModBlocks.RE8_PORTAL.get().defaultBlockState().setValue(RE8PortalBlock.AXIS, this.axis), 18);
//                }
//            }
//
//        }
//
//        private boolean isPortalCountValidForSize() {
//            return this.portalBlockCount >= this.width * this.height;
//        }
//
//        public boolean validatePortal() {
//            return this.isValid() && this.isPortalCountValidForSize();
//        }
//    }
//}
//public class RE8PortalBlock extends Block {
//    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
//    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
//    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
//
//
//    public RE8PortalBlock(AbstractBlock.Properties p_i48352_1_) {
//        super(p_i48352_1_);
//        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
//    }
//
//    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
//        switch((Direction.Axis)p_220053_1_.getValue(AXIS)) {
//            case Z:
//                return Z_AXIS_AABB;
//            case X:
//            default:
//                return X_AXIS_AABB;
//        }
//    }
//
//    public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
//        if (p_225542_2_.dimensionType().natural() && p_225542_2_.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && p_225542_4_.nextInt(2000) < p_225542_2_.getDifficulty().getId()) {
//            while(p_225542_2_.getBlockState(p_225542_3_).is(this)) {
//                p_225542_3_ = p_225542_3_.below();
//            }
//
//            if (p_225542_2_.getBlockState(p_225542_3_).isValidSpawn(p_225542_2_, p_225542_3_, EntityType.ZOMBIFIED_PIGLIN)) {
//                Entity entity = EntityType.ZOMBIFIED_PIGLIN.spawn(p_225542_2_, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, p_225542_3_.above(), SpawnReason.STRUCTURE, false, false);
//                if (entity != null) {
//                    entity.setPortalCooldown();
//                }
//            }
//        }
//
//    }
//
//    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
//        Direction.Axis direction$axis = p_196271_2_.getAxis();
//        Direction.Axis direction$axis1 = p_196271_1_.getValue(AXIS);
//        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
//        return !flag && !p_196271_3_.is(this) && !(new PortalSize(p_196271_4_, p_196271_5_, direction$axis1)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
//    }
//
////    public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
////        if (!p_196262_4_.isPassenger() && !p_196262_4_.isVehicle() && p_196262_4_.canChangeDimensions()) {
////            p_196262_4_.handleInsidePortal(p_196262_3_);
////        }
////
////    }
//        @Override
//    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entity) {
//        if(!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
//            if(entity.isOnPortalCooldown()) {
//                entity.setPortalCooldown();
//            }
//            else {
////                if(!entity.level.isClientSide && !pos.equals(entity.position())) {
////                    entity. = pos.immutable();
////                }
//                World entityWorld = entity.level;
//                if(entityWorld != null) {
//                    MinecraftServer minecraftserver = entityWorld.getServer();
//                    RegistryKey<World> destination = entity.level.dimension() == DimensionInit.RE8_DIMENSTON_WORLD
//                            ? World.OVERWORLD : DimensionInit.RE8_DIMENSTON_WORLD;
//                    if(minecraftserver != null) {
//                        ServerWorld destinationWorld = minecraftserver.getLevel(destination);
//                        if(destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
//                            entity.level.getProfiler().push("re8_portal");
//                            entity.setPortalCooldown();
//                            entity.changeDimension(destinationWorld, new ModTeleporter(destinationWorld));
//                            entity.level.getProfiler().pop();
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
//        if (p_180655_4_.nextInt(100) == 0) {
//            p_180655_2_.playLocalSound((double)p_180655_3_.getX() + 0.5D, (double)p_180655_3_.getY() + 0.5D, (double)p_180655_3_.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, p_180655_4_.nextFloat() * 0.4F + 0.8F, false);
//        }
//
//        for(int i = 0; i < 4; ++i) {
//            double d0 = (double)p_180655_3_.getX() + p_180655_4_.nextDouble();
//            double d1 = (double)p_180655_3_.getY() + p_180655_4_.nextDouble();
//            double d2 = (double)p_180655_3_.getZ() + p_180655_4_.nextDouble();
//            double d3 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
//            double d4 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
//            double d5 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
//            int j = p_180655_4_.nextInt(2) * 2 - 1;
//            if (!p_180655_2_.getBlockState(p_180655_3_.west()).is(this) && !p_180655_2_.getBlockState(p_180655_3_.east()).is(this)) {
//                d0 = (double)p_180655_3_.getX() + 0.5D + 0.25D * (double)j;
//                d3 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)j);
//            } else {
//                d2 = (double)p_180655_3_.getZ() + 0.5D + 0.25D * (double)j;
//                d5 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)j);
//            }
//
//            p_180655_2_.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
//        }
//
//    }
//
//    public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
//        return ItemStack.EMPTY;
//    }
//
//    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
//        switch(p_185499_2_) {
//            case COUNTERCLOCKWISE_90:
//            case CLOCKWISE_90:
//                switch((Direction.Axis)p_185499_1_.getValue(AXIS)) {
//                    case Z:
//                        return p_185499_1_.setValue(AXIS, Direction.Axis.X);
//                    case X:
//                        return p_185499_1_.setValue(AXIS, Direction.Axis.Z);
//                    default:
//                        return p_185499_1_;
//                }
//            default:
//                return p_185499_1_;
//        }
//    }
//
//    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
//        p_206840_1_.add(AXIS);
//    }
//
//    public boolean trySpawnPortal(World worldIn, BlockPos pos) {
////        PortalSize KJPortalBlock$size = this.isPortal(worldIn, pos);
////        if (KJPortalBlock$size != null && !onTrySpawnPortal(worldIn, pos, KJPortalBlock$size)) {
////            KJPortalBlock$size.placePortalBlocks();
////            return true;
////        } else {
////            return false;
////        }
//        return true;
//    }
//
//
//
////    @Nullable
////    public Size isPortal(World worldIn, BlockPos pos) {
////        Size KJPortalBlock$size = new Size(worldIn, pos, Direction.Axis.X);
////        if (KJPortalBlock$size.isValid() && KJPortalBlock$size.portalBlockCount == 0) {
////            return KJPortalBlock$size;
////        } else {
////            Size KaupenPortalBlock$size1 = new Size(worldIn, pos, Direction.Axis.Z);
////            return KaupenPortalBlock$size1.isValid() && KaupenPortalBlock$size1.portalBlockCount == 0 ? KaupenPortalBlock$size1 : null;
////        }
////    }
//
////    public void createPortalBlocks() {
////        BlockState blockstate = Blocks.NETHER_PORTAL.defaultBlockState().setValue(NetherPortalBlock.AXIS, this.axis);
////        BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)).forEach((p_242967_2_) -> {
////            this.level.setBlock(p_242967_2_, blockstate, 18);
////        });
////    }
////            public void placePortalBlocks() {
////            for(int i = 0; i < this.width; ++i) {
////                BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);
////
////                for(int j = 0; j < this.height; ++j) {
////                    this.setBlock(blockpos.above(j), ModBlocks.RE8_PORTAL.get().defaultBlockState().setValue(RE8PortalBlock.AXIS, this.axis), 18);
////                }
////            }
////
////        }
//    public static boolean onTrySpawnPortal(World world, BlockPos pos, PortalSize size) {
//        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
//    }
//
//    @Cancelable
//    public static class PortalSpawnEvent extends BlockEvent {
//        private final PortalSize size;
//
//        public PortalSpawnEvent(World world, BlockPos pos, BlockState state, PortalSize size) {
//            super(world, pos, state);
//            this.size = size;
//        }
//
//        public PortalSize getPortalSize()
//        {
//            return size;
//        }
//    }
//}