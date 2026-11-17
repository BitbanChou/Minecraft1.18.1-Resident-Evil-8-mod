package com.joy187.re8joymod.common.items.ItemSniper;

import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;

class PlayerExtensionImpl<E extends PlayerEntity>
        extends LivingExtensionImpl<E, PlayerHandler> implements PlayerExtension<E> {

    //private final SynchedData dataManager = new SynchedData();

    private static final DataParameter<Boolean> COMBAT_MODE_ENABLED =
            new DataParameter<>(0x02, DataSerializers.BOOLEAN);

    private boolean cachedCombatModeEnabled;

    PlayerExtensionImpl(E entity) {
        super(entity);
        //this.dataManager.register(COMBAT_MODE_ENABLED, false);
    }

    @Override
    public void tick() {
        this.cachedCombatModeEnabled = false;
        super.tick();
    }

//    @Override
//    protected void tickHandler(ResourceLocation extensionId, PlayerHandler extension) {
//        super.tickHandler(extensionId, extension);
//        if (extension.isCombatModeEnabled()) {
//            this.cachedCombatModeEnabled = true;
//        }
//    }

    @Override
    public void playerTick() {
        if (this.isCrouching()) {
            this.getEntity().setPose(Pose.SWIMMING);
        }
        for (PlayerHandler handler : this.handlers.values()) {
            handler.playerTick();
        }
    }

    @Override
    public boolean isCombatModeEnabled() {
        return false;
    }

    @Override
    public void setCombatModeEnabled(boolean combatModeEnabled) {

    }

    @Override
    public void openEquipmentMenu() {

    }

//    @Override
//    public void openStorage(ModEquipmentSlotType slotType) {
//
//    }

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
    public void encode(PacketBuffer out, boolean writeAll) {

    }

    @Override
    public void decode(PacketBuffer in) {

    }

    @Override
    public boolean requiresSync() {
        return false;
    }

//    @Override
//    public boolean isMovementBlocked() {
//        return !this.getEntity().isSpectator() && super.isMovementBlocked();
//    }

//    @Override
//    public boolean isCombatModeEnabled() {
//        return !this.getEntity().isSpectator()
//                && (this.cachedCombatModeEnabled || this.dataManager.get(COMBAT_MODE_ENABLED));
//    }

//    @Override
//    public void setCombatModeEnabled(boolean combatModeEnabled) {
//        this.dataManager.set(COMBAT_MODE_ENABLED, combatModeEnabled);
//    }

//    @Override
//    public void openEquipmentMenu() {
//        if (MinecraftForge.EVENT_BUS.post(new OpenEquipmentMenuEvent(this))) {
//            return;
//        }
//        this.getEntity().openMenu(new SimpleNamedContainerProvider(
//                (windowId, playerInventory, playerEntity) -> new EquipmentMenu(windowId,
//                        this.getEntity().inventory, this.getItemHandler()),
//                new TranslationTextComponent("container.equipment")));
//    }
//
//    @Override
//    public void openStorage(ModEquipmentSlotType slotType) {
//        ItemStack storageStack = this.getItemHandler().getStackInSlot(slotType.getIndex());
//        storageStack.getCapability(Capabilities.STORAGE)
//                .ifPresent(storage -> this.getEntity().openMenu(
//                        new SimpleNamedContainerProvider(storage, storageStack.getHoverName())));
//    }
//
//    @Override
//    public boolean handleDeath(DamageSource source) {
//        if (super.handleDeath(source)) {
//            return true;
//        } else if (source instanceof KillFeedProvider) {
//            NetworkChannel.PLAY.getSimpleChannel().send(PacketDistributor.ALL.noArg(),
//                    new AddKillFeedEntryMessage(((KillFeedProvider) source).createKillFeedEntry(this.getEntity())));
//        }
//        return false;
//    }

//    @Override
//    protected boolean keepInventory() {
//        return this.getLevel().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);
//    }

//    @Override
//    public void copyFrom(PlayerExtension<?> that, boolean wasDeath) {
//        // Copies the inventory. Doesn't actually matter if it was death or not.
//        // Death drops from 'that' should be cleared on death drops to prevent item duplication.
//        for (int i = 0; i < that.getItemHandler().getSlots(); i++) {
//            this.getItemHandler().setStackInSlot(i, that.getItemHandler().getStackInSlot(i));
//        }
//
//        for (PlayerHandler extension : this.handlers.values()) {
//            extension.copyFrom(that, wasDeath);
//        }
//    }
//
//    public SynchedData getDataManager() {
//        return this.dataManager;
//    }
//
//    @Override
//    public void encode(PacketBuffer out, boolean writeAll) {
//        super.encode(out, writeAll);
//        SynchedData.pack(
//                writeAll ? this.dataManager.getAll() : this.dataManager.packDirty(), out);
//    }
//
//    @Override
//    public void decode(PacketBuffer in) {
//        super.decode(in);
//        this.dataManager.assignValues(SynchedData.unpack(in));
//    }
//
//    @Override
//    public boolean requiresSync() {
//        return super.requiresSync() || this.dataManager.isDirty();
//    }
}
