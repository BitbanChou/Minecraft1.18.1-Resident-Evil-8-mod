package com.joy187.re8joymod.common.blocks.virusgenerator;


import com.joy187.re8joymod.common.init.BlockEntityInit;
import com.joy187.re8joymod.common.init.ModItems;
import com.joy187.re8joymod.common.recipe.VirusGeneratorRecipe;
import com.joy187.re8joymod.common.screen.VirusGeneratorMenu;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Optional;

public class VirusGeneratorBlockEntity extends LockableTileEntity implements INamedContainerProvider, ITickableTileEntity {

    protected NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);
    protected IRecipeType<? extends VirusGeneratorRecipe> recipeType;

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected IIntArray data;

    private int progress = 0;
    private int maxProgress = 72;


    public VirusGeneratorBlockEntity() {
        super(BlockEntityInit.VIRUS_GENERATOR_BLOCK_ENTITY.get());
        this.data=new IIntArray() {
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
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.virus_generator");
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.virus_generator");
    }

    @Override
    protected Container createMenu(int pContainerId, PlayerInventory pInventory) {
        return new VirusGeneratorMenu(pContainerId, pInventory, this, this.data);
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
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
    public CompoundNBT save(@NotNull CompoundNBT tag) {
        tag.put("inventory", this.itemHandler.serializeNBT());
        tag.putInt("virus_generator.progress", this.progress);
        super.save(tag);
        return tag;
    }

    @Override
    public void load(BlockState p_230337_1_,CompoundNBT nbt) {
        super.load(p_230337_1_,nbt);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.items);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("virus_generator.progress");
    }

    public void dropContents() {
        Inventory inventory = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        InventoryHelper.dropContents(this.level, this.getBlockPos(), inventory);
    }

//    public void drops() {
//        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
//        for (int i = 0; i < itemHandler.getSlots(); i++) {
//            inventory.setItem(i, itemHandler.getStackInSlot(i));
//        }
//
//        Containers.dropContents(this.level, this.worldPosition, inventory);
//    }

    @Override
    public void tick() {
        if(hasRecipe(this)) {
            this.getBlockState().setValue(VirusGeneratorBlock.LIT, Boolean.valueOf(true));
            this.progress++;
            //setChanged(pLevel, pPos, pState);
            setChanged();
//            System.out.println(this.progress);
//            System.out.println(this.data.get(0));
            if(this.progress > this.maxProgress) {
                craftItem(this);
            }
        } else {
            this.getBlockState().setValue(VirusGeneratorBlock.LIT, Boolean.valueOf(false));
            this.resetProgress();
            //setChanged(pLevel, pPos, pState);
            setChanged();
        }
    }

    private boolean hasRecipe(VirusGeneratorBlockEntity entity) {
        World level = entity.level;
        Inventory inventory = new Inventory(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<VirusGeneratorRecipe> match = level.getRecipeManager()
                .getRecipeFor((IRecipeType)VirusGeneratorRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())
                && hasFuelSlot(entity); // && has0Slot(entity) && has1Slot(entity);

    }


    private static boolean hasFuelSlot(VirusGeneratorBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == ModItems.BLACKSHEEP.get()
                || entity.itemHandler.getStackInSlot(2).getItem() == Items.FERMENTED_SPIDER_EYE
                || entity.itemHandler.getStackInSlot(2).getItem() == ModItems.DESOLATE_GRASS_BLOCK.get();
    }

    private static void craftItem(VirusGeneratorBlockEntity entity) {
        World level = entity.level;
        Inventory inventory = new Inventory(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        //IRecipe<?> match = level.getRecipeManager().getRecipeFor(RecipeInit.VIRUS_GENERATOR_SERIALIZER., inventory, level).orElse(null);

//        Optional<VirusGeneratorRecipe> match = level.getRecipeManager()
//                .getRecipeFor((IRecipeType)RecipeInit.VIRUS_GENERATOR_SERIALIZER.get(), inventory, level);
        Optional<VirusGeneratorRecipe> match = level.getRecipeManager()
                .getRecipeFor((IRecipeType)VirusGeneratorRecipe.Type.INSTANCE, inventory, level);
        //return this.level.getRecipeManager().getRecipeFor((IRecipeType)this.recipeType, new Inventory(p_217057_1_), this.level).isPresent();

        if(match.isPresent()) {
            //if(has0Slot(entity) && has1Slot(entity) && hasFuelSlot(entity)) {
            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.extractItem(1,1, false);
            entity.itemHandler.extractItem(2,1, false);

            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + 1));
//          entity.itemHandler.setStackInSlot(3, new ItemStack(ItemInit.HUMUS.get(),
//        		  entity.itemHandler.getStackInSlot(3).getCount() + 1));
            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean canInsertItemIntoOutputSlot(Inventory inventory, ItemStack output) {
        return this.getItem(3).getItem() == output.getItem() || this.getItem(3).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(Inventory inventory) {
        return this.getItem(3).getMaxStackSize() > this.getItem(3).getCount();
    }

    private static boolean notReachLimit(VirusGeneratorBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(3).getCount()<64;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int p_70301_1_) {
        return this.items.get(p_70301_1_);
    }

    @Override
    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        return ItemStackHelper.removeItem(this.items, p_70298_1_, p_70298_2_);
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_70304_1_) {
        return ItemStackHelper.takeItem(this.items, p_70304_1_);
    }

    @Override
    public void setItem(int p_70299_1_, ItemStack p_70299_2_) {
        ItemStack itemstack = this.items.get(p_70299_1_);
        boolean flag = !p_70299_2_.isEmpty() && p_70299_2_.sameItem(itemstack) && ItemStack.tagMatches(p_70299_2_, itemstack);
        this.items.set(p_70299_1_, p_70299_2_);
        if (p_70299_2_.getCount() > this.getMaxStackSize()) {
            p_70299_2_.setCount(this.getMaxStackSize());
        }

        if (p_70299_1_ == 0 && !flag) {
            this.progress = 0;
            this.setChanged();
        }

    }

    @Override
    public boolean stillValid(PlayerEntity p_70300_1_) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return p_70300_1_.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

}