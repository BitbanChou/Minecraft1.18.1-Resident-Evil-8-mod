package com.joy187.re8joymod.common.items.ItemSniper;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class LivingExtensionImpl<E extends LivingEntity, H extends LivingHandler>
        implements LivingExtension<E, H> {

    /**
     * The vanilla entity.
     */
    private final E entity;

    protected final Map<ResourceLocation, H> handlers = new Object2ObjectArrayMap<>();

    protected final Map<ResourceLocation, H> dirtyHandlers = new Object2ObjectArrayMap<>();

    private final List<Integer> dirtySlots = new IntArrayList();

    //private final EntitySnapshot[] snapshots = new EntitySnapshot[20];

//    private final ItemStackHandler itemHandler =
//            new ItemStackHandler(ModEquipmentSlotType.values().length) {
//                @Override
//                public void onContentsChanged(int slot) {
//                    if (!LivingExtensionImpl.this.entity.getCommandSenderWorld().isClientSide()) {
//                        LivingExtensionImpl.this.dirtySlots.add(slot);
//                    }
//                }
//            };

    /**
     * The last held {@link ItemStack} - used to check if the entity has switched item.
     */
    protected ItemStack lastHeldStack = null;
//
//    @Nullable
//    private Action action;

    @Nullable
    private ProgressMonitor progressMonitor;

    private boolean movementBlocked;

    private boolean crouching;

    private Vector3d lastPos;

    private boolean moving;

    private Visibility cachedVisibility = Visibility.VISIBLE;

    private ItemStack lastClothingStack = ItemStack.EMPTY;

    LivingExtensionImpl(E entity) {
        this.entity = entity;
    }

    @Override
    public void load() {
        MinecraftForge.EVENT_BUS.post(new LivingExtensionEvent.Load(this));
    }

    @Override
    public void registerHandler(ResourceLocation id, H extension) {
        if (this.handlers.containsKey(id)) {
            throw new IllegalArgumentException(
                    "Handler with id " + id.toString() + " already registered");
        }
        this.handlers.put(id, extension);
    }

    @Override
    public Optional<H> getHandler(ResourceLocation id) {
        return Optional.ofNullable(this.handlers.get(id));
    }

    @Override
    public H getHandlerOrThrow(ResourceLocation id) {
        H handler = this.handlers.get(id);
        if (handler == null) {
            throw new IllegalStateException("Missing handler with ID: " + id.toString());
        }
        return handler;
    }

//    @Override
//    public Optional<Action> getAction() {
//        return Optional.ofNullable(this.action);
//    }
//
//    @Override
//    public boolean performAction(Action action, boolean force, boolean sendUpdate) {
//        if (MinecraftForge.EVENT_BUS.post(new LivingExtensionEvent.PerformAction<>(this, action))) {
//            return false;
//        }
//
//        final ProgressMonitor targetProgressMonitor = action.getTarget()
//                .flatMap(LivingExtension::getProgressMonitor)
//                .orElse(null);
//
//        if (this.progressMonitor != null || targetProgressMonitor != null) {
//            if (!force) {
//                return false;
//            }
//            this.progressMonitor.stop();
//            if (targetProgressMonitor != this.progressMonitor) {
//                targetProgressMonitor.stop();
//            }
//        }
//
//        if ((this.action != null && !force) || !action.start()) {
//            return false;
//        }
//
//        this.cancelAction(true);
//        this.action = action;
//        this.progressMonitor = action.getPerformerProgress();
//        action.getTarget().ifPresent(target -> target.setProgressMonitor(action.getTargetProgress()));
//        if (sendUpdate) {
//            PacketTarget target = this.getLevel().isClientSide()
//                    ? PacketDistributor.SERVER.noArg()
//                    : PacketDistributor.TRACKING_ENTITY_AND_SELF.with(this::getEntity);
//            int targetId = action.getTarget()
//                    .map(LivingExtension::getEntity)
//                    .map(Entity::getId)
//                    .orElse(-1);
//            NetworkChannel.PLAY.getSimpleChannel().send(target,
//                    new PerformActionMessage(action.getType(), this.getEntity().getId(), targetId));
//        }
//        return true;
//    }
//
//    @Override
//    public void cancelAction(boolean sendUpdate) {
//        if (this.action == null) {
//            return;
//        }
//        this.action.cancel();
//        this.removeAction();
//        if (sendUpdate) {
//            PacketTarget target = this.getLevel().isClientSide()
//                    ? PacketDistributor.SERVER.noArg()
//                    : PacketDistributor.TRACKING_ENTITY_AND_SELF.with(this::getEntity);
//            NetworkChannel.PLAY.getSimpleChannel().send(target,
//                    new CancelActionMessage(this.getEntity().getId()));
//        }
//    }

    @Override
    public void setProgressMonitor(ProgressMonitor actionProgress) {
        this.progressMonitor = actionProgress;
    }

    @Override
    public Optional<ProgressMonitor> getProgressMonitor() {
        return Optional.ofNullable(this.progressMonitor);
    }

//    private void removeAction() {
//        if (this.action != null) {
//            this.progressMonitor = null;
//            this.action.getTarget().ifPresent(target -> target.setProgressMonitor(null));
//            this.action = null;
//        }
//    }

    @Override
    public void setMovementBlocked(boolean movementBlocked) {
        this.movementBlocked = movementBlocked;
    }

//    @Override
//    public boolean isMovementBlocked() {
//        return this.movementBlocked;
//    }
    @Override
    public boolean isMoving() {
        return this.moving;
    }

    @Override
    public boolean isCrouching() {
        return false;
    }

    @Override
    public void setCrouching(boolean crouching, boolean sendUpdate) {

    }

    @Override
    public E getEntity() {
        return null;
    }

    @Override
    public void tick() {
        ItemStack heldStack = this.getMainHandItem();
        if (heldStack != this.lastHeldStack) {
            this.getProgressMonitor().ifPresent(ProgressMonitor::stop);
//            if (this.lastHeldStack != null) {
//                this.lastHeldStack.getCapability(Capabilities.GUN)
//                        .ifPresent(gun -> gun.reset(this));
//            }
//            if (heldStack.getCapability(Capabilities.GUN).isPresent()) {
//                this.entity.playSound(ModSoundEvents.GUN_EQUIP.get(), 0.25F, 1.0F);
//            }
//            this.lastHeldStack = heldStack;
//        }
//
//        // Reset this every tick
//        this.movementBlocked = false;
//
//        if (this.action != null && this.action.tick()) {
//            this.removeAction();
//        }
//
//        heldStack.getCapability(Capabilities.GUN).ifPresent(gun -> gun.tick(this));
//
//        this.updateClothing();
//        this.updateHat();
//
//        if (!this.entity.getCommandSenderWorld().isClientSide()) {
//            // This is called at the start of the entity tick so it's equivalent of last tick's position.
//            this.snapshots[this.entity.getServer().getTickCount() % 20] =
//                    new EntitySnapshot(this.entity);
//        }

        this.moving = !this.entity.position().equals(this.lastPos);
        this.lastPos = this.entity.position();

//        for (Map.Entry<ResourceLocation, H> entry : this.handlers.entrySet()) {
//            this.tickHandler(entry.getKey(), entry.getValue());
//        }
    }

//    protected void tickHandler(ResourceLocation handlerId, H handler) {
//        handler.tick();
//
//        // Precedence = (1) INVISIBLE (2) PARTIALLY_VISIBLE (3) VISIBLE
//        this.cachedVisibility = Visibility.VISIBLE;
//        switch (handler.getVisibility()) {
//            case INVISIBLE:
//                this.cachedVisibility = Visibility.INVISIBLE;
//            case PARTIALLY_VISIBLE:
//                if (this.cachedVisibility == Visibility.VISIBLE) {
//                    this.cachedVisibility = Visibility.PARTIALLY_VISIBLE;
//                }
//                break;
//            default:
//                break;
//        }
//
//        if (handler.isMovementBlocked()) {
//            this.movementBlocked = true;
//        }
//
//        if (handler.requiresSync()) {
//            this.dirtyHandlers.put(handlerId, handler);
//        }
//    }
//
//    private void updateHat() {
//        ItemStack headStack = this.itemHandler.getStackInSlot(ModEquipmentSlotType.HAT.getIndex());
//        Hat hat = headStack.getCapability(Capabilities.HAT).orElse(null);
//        if (headStack.getItem() == ModItems.SCUBA_MASK.get()
//                && this.entity.isEyeInFluid(FluidTags.WATER)) {
//            this.entity.addEffect(new EffectInstance(Effects.WATER_BREATHING, 2, 0, false, false, false));
//        } else if (hat != null && hat.hasNightVision()) {
//            this.entity.addEffect(new EffectInstance(Effects.NIGHT_VISION, 2, 0, false, false, false));
//        }
//    }
//
//    private void updateClothing() {
//        ItemStack clothingStack =
//                this.itemHandler.getStackInSlot(ModEquipmentSlotType.CLOTHING.getIndex());
//        Clothing clothing = clothingStack.getCapability(Capabilities.CLOTHING).orElse(null);
//
//        if (clothingStack != this.lastClothingStack) {
//            this.lastClothingStack.getCapability(Capabilities.CLOTHING)
//                    .map(Clothing::getAttributeModifiers)
//                    .ifPresent(this.entity.getAttributes()::removeAttributeModifiers);
//            if (clothing != null) {
//                this.entity.getAttributes()
//                        .addTransientAttributeModifiers(clothing.getAttributeModifiers());
//            }
//        }
//
//        if (clothing != null) {
//            // Fire immunity
//            if (clothing.hasFireImmunity()) {
//                if (this.entity.getRemainingFireTicks() > 0) {
//                    this.entity.clearFire();
//                }
//
//                this.entity
//                        .addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 2, 0, false, false, false));
//            }
//        }
//
//        if (clothingStack.getItem() == ModItems.SCUBA_CLOTHING.get()
//                && this.entity.isEyeInFluid(FluidTags.WATER)) {
//            this.entity
//                    .addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 2, 0, false, false, false));
//        }
//
//        this.lastClothingStack = clothingStack;
//    }
//
//
//    @Override
//    public float handleDamaged(DamageSource source, float amount) {
//        return this.handlers.values().stream().reduce(amount,
//                (result, extension) -> extension.handleDamaged(source, result), (u, t) -> t);
//    }
//
//    @Override
//    public boolean handleHurt(DamageSource source, float amount) {
//        return this.handlers.values().stream().anyMatch(e -> e.handleHurt(source, amount));
//    }
//
//    @Override
//    public boolean handleKill(Entity target) {
//        return this.handlers.values().stream().anyMatch(e -> e.handleKill(target));
//    }
//
//    @Override
//    public boolean handleDeath(DamageSource cause) {
//        return this.handlers.values().stream().map(e -> e.handleDeath(cause)).anyMatch(v -> v == true);
//    }
//
//    @Override
//    public boolean handleDeathLoot(DamageSource cause, Collection<ItemEntity> drops) {
//        if (this.handlers.values().stream()
//                .filter(e -> e.handleDeathLoot(cause, drops))
//                .findAny()
//                .isPresent()) {
//            return true;
//        }
//
//        if (!this.keepInventory()) {
//            for (int i = 0; i < this.itemHandler.getSlots(); i++) {
//                ItemStack itemStack =
//                        this.itemHandler.extractItem(i, Integer.MAX_VALUE, false);
//                if (!itemStack.isEmpty()) {
//                    ItemEntity itemEntity = new ItemEntity(this.getLevel(), this.getEntity().getX(),
//                            this.getEntity().getY(), this.getEntity().getZ(), itemStack);
//                    itemEntity.setDefaultPickUpDelay();
//                    drops.add(itemEntity);
//                }
//            }
//        }
//        return false;
//    }
//
//    protected boolean keepInventory() {
//        return false;
//    }
//
//    @Override
//    public Visibility getVisibility() {
//        return this.cachedVisibility;
//    }
//
//    @Override
//    public IItemHandlerModifiable getItemHandler() {
//        return this.itemHandler;
//    }
//
//    @Override
//    public EntitySnapshot getSnapshot(int tick) {
//        final int currentTick = this.entity.getServer().getTickCount();
//        if (tick >= currentTick) {
//            return new EntitySnapshot(this.entity);
//        } else if (tick < currentTick - 20) {
//            return this.snapshots[0];
//        }
//
//        final int snapshotIndex = tick % 20;
//        EntitySnapshot snapshot = this.snapshots[snapshotIndex];
//        if (snapshot == null) {
//            throw new IndexOutOfBoundsException();
//        }
//        return snapshot;
//    }
//
//    @Override
//    public boolean isCrouching() {
//        return this.crouching;
//    }
//
//    @Override
//    public void setCrouching(boolean crouching, boolean sendUpdate) {
//        if (!this.entity.isOnGround()) {
//            return;
//        }
//        this.crouching = crouching;
//        if (sendUpdate) {
//            PacketTarget target = this.getLevel().isClientSide()
//                    ? PacketDistributor.SERVER.noArg()
//                    : PacketDistributor.TRACKING_ENTITY_AND_SELF.with(this::getEntity);
//            NetworkChannel.PLAY.getSimpleChannel().send(target,
//                    new CrouchMessage(this.getEntity().getId(), crouching));
//        }
//    }
//
//    @Override
//    public E getEntity() {
//        return this.entity;
//    }
//
//    @Override
//    public CompoundNBT serializeNBT() {
//        CompoundNBT nbt = new CompoundNBT();
//        nbt.put("inventory", this.itemHandler.serializeNBT());
//        for (Map.Entry<ResourceLocation, H> entry : this.handlers.entrySet()) {
//            CompoundNBT extensionNbt = entry.getValue().serializeNBT();
//            if (!extensionNbt.isEmpty()) {
//                nbt.put(entry.getKey().toString(), extensionNbt);
//            }
//        }
//        return nbt;
//    }
//
//    @Override
//    public void deserializeNBT(CompoundNBT nbt) {
//        this.itemHandler.deserializeNBT(nbt.getCompound("inventory"));
//        for (Map.Entry<ResourceLocation, H> entry : this.handlers.entrySet()) {
//            CompoundNBT extensionNbt = nbt.getCompound(entry.getKey().toString());
//            if (!extensionNbt.isEmpty()) {
//                entry.getValue().deserializeNBT(extensionNbt);
//            }
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        return this.entity.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj)
//                || (obj instanceof LivingExtension
//                && ((LivingExtension<?, ?>) obj).getEntity().equals(this.entity));
//    }
//
//    @Override
//    public void encode(PacketBuffer out, boolean writeAll) {
//        // Item Handler
//        if (writeAll) {
//            for (int i = 0; i < this.itemHandler.getSlots(); i++) {
//                out.writeShort(i);
//                out.writeItem(this.itemHandler.getStackInSlot(i));
//            }
//        } else {
//            for (int i : this.dirtySlots) {
//                out.writeShort(i);
//                out.writeItem(this.itemHandler.getStackInSlot(i));
//            }
//            this.dirtySlots.clear();
//        }
//        out.writeShort(255);
//
//        // Handlers
//        Set<Map.Entry<ResourceLocation, H>> handlersToSend =
//                writeAll ? this.handlers.entrySet() : this.dirtyHandlers.entrySet();
//        out.writeVarInt(handlersToSend.size());
//        for (Map.Entry<ResourceLocation, H> entry : handlersToSend) {
//            out.writeResourceLocation(entry.getKey());
//            PacketBuffer handlerData = new PacketBuffer(Unpooled.buffer());
//            entry.getValue().encode(handlerData, writeAll);
//            out.writeVarInt(handlerData.readableBytes());
//            out.writeBytes(handlerData);
//        }
//        this.dirtyHandlers.clear();
//    }
//
//    @Override
//    public void decode(PacketBuffer in) {
//        // Item Handler
//        int slot;
//        while ((slot = in.readShort()) != 255) {
//            this.itemHandler.setStackInSlot(slot, in.readItem());
//        }
//
//        // Handlers
//        int handlersSize = in.readVarInt();
//        for (int x = 0; x < handlersSize; x++) {
//            ResourceLocation id = in.readResourceLocation();
//            int dataSize = in.readVarInt();
//            H handler = this.handlers.get(id);
//            if (handler == null) {
//                in.readerIndex(in.readerIndex() + dataSize);
//                continue;
//            }
//            handler.decode(in);
//        }
//    }
//
//    @Override
//    public boolean requiresSync() {
//        return !this.dirtySlots.isEmpty() || !this.dirtyHandlers.isEmpty();
    }

    @Override
    public void encode(PacketBuffer out, boolean writeAll) {

    }

    @Override
    public void decode(PacketBuffer in) {

    }

    @Override
    public boolean requiresSync() {
        return false;
    }
}
