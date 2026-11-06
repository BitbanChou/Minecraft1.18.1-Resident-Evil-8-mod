package com.joy187.re8joymod.items.itemBook;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.base.Strings;
import com.joy187.re8joymod.ClientModEventSubscriber;
import com.joy187.re8joymod.Main;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.util.NonNullLazy;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.util.thread.EffectiveSide;

public class ItemStoryBook extends Item {
	
//    public ItemStoryBook() {
//        super(new Item.Properties().tab(Main.TUTORIAL_TAB).stacksTo(1));
//    }
//	
//	 public InteractionResultHolder<ItemStack> use(Level p_43449_, Player p_43450_, InteractionHand p_43451_) {
//		      ItemStack itemstack = p_43450_.getItemInHand(p_43451_);
//		      p_43450_.openItemGui(itemstack, p_43451_);
//		      System.out.println("开");
//		      if (FMLEnvironment.dist == Dist.CLIENT)
//		          Minecraft.getInstance().setScreen(new BookBase(itemstack));
//		      p_43450_.awardStat(Stats.ITEM_USED.get(this));
//		      //return super.use(p_43449_,p_43450_,p_43451_);
//		      return InteractionResultHolder.sidedSuccess(itemstack, p_43449_.isClientSide());
//	}
	 
    public ItemStoryBook(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        return showBook(context.getLevel(), context.getItemInHand()).getResult();
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand hand)
    {
        //System.out.println("OPEN");
        ItemStack stack = playerIn.getItemInHand(hand);
        return showBook(worldIn, stack);
    }

    private InteractionResultHolder<ItemStack> showBook(Level worldIn, ItemStack stack)
    {
        if (!worldIn.isClientSide)
            return InteractionResultHolder.success(stack);

        CompoundTag nbt = stack.getTag();
//        if (nbt == null || !nbt.contains("Book", Tag.TAG_STRING))
//            return InteractionResultHolder.fail(stack);

        //Minecraft.getInstance().setScreen(new GuidebookScreen(new ResourceLocation(Main.MOD_ID, "textures/gui/re8storybookicon.png")));
//        if (FMLEnvironment.dist == Dist.CLIENT)        
//        	Minecraft.getInstance().setScreen(new BookBase(stack));
//            ClientAPI.displayBook("");
        if(worldIn.isClientSide)
        {
            Main.PROXY.openRe8StoryBookGui(stack);
        }
        return InteractionResultHolder.success(stack);
    }

    public ItemStack of(ResourceLocation book)
    {
        ItemStack stack = new ItemStack(this);
        CompoundTag tag = new CompoundTag();
        tag.putString("Book", book.toString());
        stack.setTag(tag);
        return stack;
    }

    @Nullable
    public String getBookLocation(ItemStack stack)
    {
        CompoundTag tag = stack.getTag();
        if (tag != null)
        {
            return tag.getString("Book");
        }
        return null;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        if (flagIn == TooltipFlag.Default.ADVANCED)
        {
            String book = getBookLocation(stack);
            if (!Strings.isNullOrEmpty(book))
            {
                tooltip.add(Component.translatable("text.gbook.tooltip.book",
                		Component.translatable(book).withStyle(ChatFormatting.ITALIC)
                ).withStyle(ChatFormatting.GRAY));
            }
        }
    }

    @Override
    public Component getName(ItemStack stack)
    {
        String book = getBookLocation(stack);
        if (!Strings.isNullOrEmpty(book))
        {
            if (FMLEnvironment.dist == Dist.CLIENT && EffectiveSide.get().isClient())
                return Component.nullToEmpty("");
        }

        return super.getName(stack);
    }

    public static String getSubtype(ItemStack stack)
    {
        if (stack.getItem() instanceof ItemStoryBook)
        {
            String bookLocation = ((ItemStoryBook) stack.getItem()).getBookLocation(stack);
            return bookLocation == null ? "" : bookLocation;
        }
        return "";
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        consumer.accept(new IClientItemExtensions()
        {
            private final NonNullLazy<BlockEntityWithoutLevelRenderer> ister = NonNullLazy.of(() -> 
            new BookItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels()));

//            @Override
//            public BlockEntityWithoutLevelRenderer getItemStackRenderer()
//            {
//                return ister.get();
//            }
        });
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Main.CPROXY.getArmorRenderProperties());
//    }
}
