package com.joy187.re8joymod.blocks.virusgenerator;


import com.joy187.re8joymod.blocks.screen.VirusGeneratorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.joy187.re8joymod.init.BlockEntityInit;
import com.joy187.re8joymod.init.ItemInit;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

public class VirusGeneratorBlockEntity extends BlockEntity implements MenuProvider {
	
	private BlockState blockState;

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public VirusGeneratorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BlockEntityInit.VIRUS_GENERATOR_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return VirusGeneratorBlockEntity.this.progress;
                    case 1: return VirusGeneratorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: VirusGeneratorBlockEntity.this.progress = value; break;
                    case 1: VirusGeneratorBlockEntity.this.maxProgress = value; break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.virus_generator");
    }
    
//    protected Component getDefaultName() {
//        return Component.translatable("container.virus_generator");
//    }
    
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new VirusGeneratorMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap ==  ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }


    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("virus_generator.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("virus_generator.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState, VirusGeneratorBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
        	pState.setValue(VirusGeneratorBlock.LIT, Boolean.valueOf(true));
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
        	pState.setValue(VirusGeneratorBlock.LIT, Boolean.valueOf(false));
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
//    	if(hasRecipe(pBlockEntity) && notReachLimit(pBlockEntity)) {
//    		craftItem(pBlockEntity);
//    	}
    }

    private boolean hasRecipe(VirusGeneratorBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<VirusGeneratorRecipe> match = level.getRecipeManager()
                .getRecipeFor(VirusGeneratorRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem(getLevel().registryAccess()))
                && hasFuelSlot(entity); // && has0Slot(entity) && has1Slot(entity);
//        boolean canUse = has0Slot(entity) && hasFuelSlot(entity) && has1Slot(entity);
//        if(canUse) entity.blockState = entity.blockState.setValue(VirusGeneratorBlock.LIT, Boolean.valueOf(true));
//        else entity.blockState = entity.blockState.setValue(VirusGeneratorBlock.LIT, Boolean.valueOf(false));
//        return canUse;
    }

//    private static boolean has0Slot(VirusGeneratorBlockEntity entity) {
//        return entity.itemHandler.getStackInSlot(0).getItem() == Items.ROTTEN_FLESH;
//    }

//    private static boolean has1Slot(VirusGeneratorBlockEntity entity) {
//        return entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.LYEYE.get();
//    }

    private static boolean hasFuelSlot(VirusGeneratorBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == ItemInit.BLACKSHEEP.get()
        || entity.itemHandler.getStackInSlot(2).getItem() == Items.FERMENTED_SPIDER_EYE
        || entity.itemHandler.getStackInSlot(2).getItem() == ItemInit.DESOLATE_GRASS_BLOCK.get();
    }

    private void craftItem(VirusGeneratorBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<VirusGeneratorRecipe> match = level.getRecipeManager()
                .getRecipeFor(VirusGeneratorRecipe.Type.INSTANCE, inventory, level);
        
        if(match.isPresent()) {
            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.extractItem(1,1, false);
            entity.itemHandler.extractItem(2,1, false);

            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem(getLevel().registryAccess()).getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + 1));

          entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }
    
    private static boolean notReachLimit(VirusGeneratorBlockEntity entity) {
    	return entity.itemHandler.getStackInSlot(3).getCount()<64;
    }
    
//    @Override
//    public BlockState getBlockState() {
//        return this.blockState;
//     }
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

}