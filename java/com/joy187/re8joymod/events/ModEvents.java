package com.joy187.re8joymod.events;


import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.*;
import com.joy187.re8joymod.common.init.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.Blocks;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.HERB.get(), 12);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,10,8,0.02F));
        }

//        if(event.getType() == VillagerProfession.TOOLSMITH) {
//            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
//            ItemStack stack = new ItemStack(ModItems.HUMUS_INGOT.get(), 1);
//            int villagerLevel = 3;
//
//            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 12),
//                    stack,4,12,0.09F));
//        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.LEI.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.MACHINEHEARTS.get(), 2),
                    stack,24,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.LEI.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LYEYE.get(), 3),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.LEI.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LYEYE.get(), 3),
                    stack,24,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.LEI2.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 8),
                    stack,10,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.SLIVERREN.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI2.get(), 2),
                    stack,2,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.PIPEB.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 4),
                    stack,6,9,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.GM79B.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 4),
                    stack,8,16,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.SA110.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI2.get(), 8),
                    stack,1,2,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.M1897B.get(), 3);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 1),
                    stack,24,28,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.RIFLEAMMO.get(), 3);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 1),
                    stack,36,40,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.SNIPERAMMO.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 3),
                    stack,16,20,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.MACHINEHEARTB.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI2.get(), 1),
                    stack,4,12,0.09F));
        }


        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.M1851B.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 3),
                    stack,16,20,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.ROSEGENE.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI2.get(), 15),
                    stack,3,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.HERBFISH.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 3),
                    stack,3,9,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BIRDANDPILAF.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 3),
                    stack,3,9,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.THREEFLAVOR.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI.get(), 3),
                    stack,6,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.TOCH.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI2.get(), 1),
                    stack,6,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.CIOR.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI2.get(), 1),
                    stack,6,12,0.09F));
        }

        if(event.getType() == EntityDuke.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.SARMAL.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.LEI2.get(), 1),
                    stack,6,12,0.15F));
        }

        //小黑商人
        if(event.getType() == EntityEdMan.EDMANGUARD.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.FEATHER, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEdMan.EDMANGUARD.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.ARROW, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 1),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEdMan.EDMANGUARD.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.NETHERITE_INGOT, 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEdMan.EDMANGUARD.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BLACK_BANNER, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,24,12,0.15F));
        }


        //小黑保安
        if(event.getType() == EntityEndGuard.EDMANGUARD1.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.IRON_SWORD, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndGuard.EDMANGUARD1.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.ARROW, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 1),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndGuard.EDMANGUARD1.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.DIAMOND_SWORD, 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndGuard.EDMANGUARD1.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.NETHERITE_SWORD, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,24,12,0.15F));
        }

        //小黑国王
        if(event.getType() == EntityEndKing.EDMANGUARD2.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Blocks.SPONGE, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndKing.EDMANGUARD2.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BREAD, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 1),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndKing.EDMANGUARD2.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.PORKCHOP, 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndKing.EDMANGUARD2.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.NETHERITE_SWORD, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,24,12,0.15F));
        }

        //小黑科学家
        if(event.getType() == EntityEndScienceBlack.EDMANGUARD3.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BLAZE_ROD, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndScienceBlack.EDMANGUARD3.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.FERMENTED_SPIDER_EYE, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 1),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndScienceBlack.EDMANGUARD3.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.PORKCHOP, 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,24,12,0.15F));
        }

        if(event.getType() == EntityEndScienceBlack.EDMANGUARD3.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.NETHERITE_SWORD, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,24,12,0.15F));
        }
    }
}