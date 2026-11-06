package com.joy187.re8joymod.event;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDuke;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.ItemInit;

import com.joy187.re8joymod.init.VillageInit;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.HERB.get(), 12);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,10,8,0.02F));
        }

        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.HUMUS_INGOT.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    stack,4,12,0.09F));
        }

        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.LEI.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.MACHINEHEARTS.get(), 2),
                    stack,10,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.LEI.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LYEYE.get(), 3),
                    stack,10,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.LEI.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LYEYE.get(), 3),
                    stack,10,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.LEI2.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 8),
                    stack,6,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.SLIVERREN.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI2.get(), 2),
                    stack,2,12,0.09F));
        }
 
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.PIPEBOMB.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 4),
                    stack,10,9,0.15F));
        }

        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.DESOLATE_GRASS_BLOCK.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 7),
                    stack,10,12,0.09F));
        }

        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(BlockInit.MINE.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 4),
                    stack,10,9,0.15F));
        }

        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.IRON_INGOT, 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 1),
                    stack,10,12,0.1F));
        }
//        if(event.getType() == VillageInit.DUKE.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//            ItemStack stack = new ItemStack(ItemInit.SA110.get(), 1);
//            int villagerLevel = 3;
//
//            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
//                    new ItemStack(ItemInit.LEI2.get(), 8),
//                    stack,1,2,0.09F));
//        }
//
//        if(event.getType() == VillageInit.DUKE.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//            ItemStack stack = new ItemStack(ItemInit.RIFLEAMMO.get(), 3);
//            int villagerLevel = 3;
//
//            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
//                    new ItemStack(ItemInit.LEI.get(), 1),
//                    stack,36,40,0.09F));
//        }
//
//        if(event.getType() == VillageInit.DUKE.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//            ItemStack stack = new ItemStack(ItemInit.SNIPERAMMO.get(), 1);
//            int villagerLevel = 3;
//
//            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
//                    new ItemStack(ItemInit.LEI.get(), 3),
//                    stack,16,20,0.09F));
//        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.KEY2.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 6),
                    stack,8,16,0.09F));
        }

        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.NETHERITE_SCRAP, 3);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 6),
                    stack,24,20,0.09F));
        }
//
//        if(event.getType() == VillageInit.DUKE.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//            ItemStack stack = new ItemStack(ItemInit.M1851B.get(), 1);
//            int villagerLevel = 3;
//
//            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
//                    new ItemStack(ItemInit.LEI.get(), 3),
//                    stack,16,12,0.09F));
//        }
        
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.MACHINEHEARTB.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI2.get(), 1),
                    stack,4,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.ROSEGENE.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI2.get(), 15),
                    stack,2,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.HERBFISH.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 3),
                    stack,6,9,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.BIRDANDPILAF.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 3),
                    stack,6,9,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.THREEFLAVOR.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI.get(), 3),
                    stack,6,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.TOCH.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI2.get(), 1),
                    stack,6,12,0.09F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.CIOR.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI2.get(), 1),
                    stack,6,12,0.12F));
        }
        
        if(event.getType() == VillageInit.DUKE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.SARMAL.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ItemInit.LEI2.get(), 1),
                    stack,4,12,0.09F));
        }
    }
}