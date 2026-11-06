package com.joy187.re8joymod.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.init.SoundInit;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityMerchant extends WanderingTrader implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityMerchant(EntityType<? extends WanderingTrader> p_35381_, Level p_35382_) {
        super(p_35381_, p_35382_);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.merchant.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.merchant.idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
        public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        if (this.isSleeping()) {
            return null;
        } else {
            Random ran = new Random();
            if(ran.nextInt(2)==0)
            {
                return this.isTrading() ? SoundInit.ENTITY_MERCHANT_TRADE.get() : SoundInit.ENTITY_MERCHANT_AMBIENT1.get();
            }
            return this.isTrading() ? SoundInit.ENTITY_MERCHANT_AMBIENT2.get() : SoundInit.ENTITY_MERCHANT_AMBIENT3.get();
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_35498_) {
        return SoundInit.ENTITY_MERCHANT_AMBIENT1.get();
    }


    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> WANDERING_TRADER_TRADES =
            toIntMap(ImmutableMap.of(
                    1, new VillagerTrades.ItemListing[]{
                    new ItemsForEmeralds(ItemInit.LYEYE.get(), 2, 1, 10, 1),
                    new ItemsForEmeralds(Items.SLIME_BALL, 1, 1, 16, 1),
                    new ItemsForEmeralds(ItemInit.MACHINEHEARTS.get(), 2, 1, 10, 1),
//                    new ItemsForEmeralds(ItemInit.DESOLATE_GRASS_BLOCK.get(), 5, 1, 8, 1),
//                    new ItemsForEmeralds(ItemInit.BOWSHOOT.get(), 7, 1, 16, 1),
//                    new ItemsForEmeralds(ItemInit.THREEFLAVOR.get(), 2, 1, 16, 1),
                    new ItemsForEmeralds(ItemInit.RESOURCEL.get(), 5, 1, 16, 1),
                    new ItemsForEmeralds(Items.GUNPOWDER, 2, 1, 32, 2),
                    new ItemsForEmeralds(Items.IRON_INGOT, 1, 1, 32, 2),
                    new ItemsForEmeralds(ItemInit.BLACKFEATHER.get(), 6, 1, 8, 1)
                    },
                    2, new VillagerTrades.ItemListing[]{
//                    new ItemsForLei2(BlockInit.PINK_ROSE.get(), 1, 1, 6, 2),
//                    new ItemsForLei2(ItemInit.PLAGASKEY.get(), 1, 1, 2, 2),
//                    new ItemsForLei2(ItemInit.SARMAL.get(), 1, 1, 4, 1),
//                    new ItemsForLei2(ItemInit.CIOR.get(), 1, 1, 6, 1),
//                    new ItemsForLei2(BlockInit.FANTOM_BLOCK.get(), 8, 1, 2, 1),
                    new ItemsForLei2(BlockInit.MUCUS_BLOCK.get(), 1, 1, 16, 1),
                    new ItemsForLei2(ItemInit.HERB3.get(), 1, 1, 4, 2)
//                            new ItemsForLei2(ItemInit.GE.get(), 2, 1, 6, 3),
//                            new ItemsForLei2(ItemInit.ROSEGENE.get(), 3, 1, 6, 1)
                    }));


    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> p_35631_) {
        return new Int2ObjectOpenHashMap<>(p_35631_);
    }

    static class ItemsForEmeralds implements VillagerTrades.ItemListing {
        private final ItemStack itemStack;
        private final int emeraldCost;
        private final int numberOfItems;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public ItemsForEmeralds(Block p_35765_, int p_35766_, int p_35767_, int p_35768_, int p_35769_) {
            this(new ItemStack(p_35765_), p_35766_, p_35767_, p_35768_, p_35769_);
        }

        public ItemsForEmeralds(Item p_35741_, int p_35742_, int p_35743_, int p_35744_) {
            this(new ItemStack(p_35741_), p_35742_, p_35743_, 12, p_35744_);
        }

        public ItemsForEmeralds(Item p_35746_, int p_35747_, int p_35748_, int p_35749_, int p_35750_) {
            this(new ItemStack(p_35746_), p_35747_, p_35748_, p_35749_, p_35750_);
        }

        public ItemsForEmeralds(ItemStack p_35752_, int p_35753_, int p_35754_, int p_35755_, int p_35756_) {
            this(p_35752_, p_35753_, p_35754_, p_35755_, p_35756_, 0.05F);
        }

        public ItemsForEmeralds(ItemStack p_35758_, int p_35759_, int p_35760_, int p_35761_, int p_35762_, float p_35763_) {
            this.itemStack = p_35758_;
            this.emeraldCost = p_35759_;
            this.numberOfItems = p_35760_;
            this.maxUses = p_35761_;
            this.villagerXp = p_35762_;
            this.priceMultiplier = p_35763_;
        }

        public MerchantOffer getOffer(Entity p_219699_, RandomSource p_219700_) {
            return new MerchantOffer(new ItemStack(ItemInit.LEI.get(), this.emeraldCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }

    static class ItemsForLei2 implements VillagerTrades.ItemListing {
        private final ItemStack itemStack;
        private final int emeraldCost;
        private final int numberOfItems;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public ItemsForLei2(Block p_35765_, int p_35766_, int p_35767_, int p_35768_, int p_35769_) {
            this(new ItemStack(p_35765_), p_35766_, p_35767_, p_35768_, p_35769_);
        }

        public ItemsForLei2(Item p_35741_, int p_35742_, int p_35743_, int p_35744_) {
            this(new ItemStack(p_35741_), p_35742_, p_35743_, 12, p_35744_);
        }

        public ItemsForLei2(Item p_35746_, int p_35747_, int p_35748_, int p_35749_, int p_35750_) {
            this(new ItemStack(p_35746_), p_35747_, p_35748_, p_35749_, p_35750_);
        }

        public ItemsForLei2(ItemStack p_35752_, int p_35753_, int p_35754_, int p_35755_, int p_35756_) {
            this(p_35752_, p_35753_, p_35754_, p_35755_, p_35756_, 0.05F);
        }

        public ItemsForLei2(ItemStack p_35758_, int p_35759_, int p_35760_, int p_35761_, int p_35762_, float p_35763_) {
            this.itemStack = p_35758_;
            this.emeraldCost = p_35759_;
            this.numberOfItems = p_35760_;
            this.maxUses = p_35761_;
            this.villagerXp = p_35762_;
            this.priceMultiplier = p_35763_;
        }

        public MerchantOffer getOffer(Entity p_219699_, RandomSource p_219700_) {
            return new MerchantOffer(new ItemStack(ItemInit.LEI2.get(), this.emeraldCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }

    @Override
    protected void updateTrades() {
        VillagerTrades.ItemListing[] avillagertrades$itemlisting = WANDERING_TRADER_TRADES.get(1);
        VillagerTrades.ItemListing[] avillagertrades$itemlisting1 = WANDERING_TRADER_TRADES.get(2);
        if (avillagertrades$itemlisting != null && avillagertrades$itemlisting1 != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.addOffersFromItemListings(merchantoffers, avillagertrades$itemlisting, 5);
            int i = this.random.nextInt(avillagertrades$itemlisting1.length);
            VillagerTrades.ItemListing villagertrades$itemlisting = avillagertrades$itemlisting1[i];
            MerchantOffer merchantoffer = villagertrades$itemlisting.getOffer(this, this.random);
            if (merchantoffer != null) {
                merchantoffers.add(merchantoffer);
            }

        }
    }

}
