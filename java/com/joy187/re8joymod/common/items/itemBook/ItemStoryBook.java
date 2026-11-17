package com.joy187.re8joymod.common.items.itemBook;

import com.joy187.re8joymod.Main;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStoryBook extends Item {


    public ItemStoryBook(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        return showBook(context.getLevel(), context.getItemInHand()).getResult();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
        //System.out.println("OPEN");
        ItemStack stack = playerIn.getItemInHand(hand);
        return showBook(worldIn, stack);
    }


    private ActionResult<ItemStack> showBook(World worldIn, ItemStack stack) {
        if (!worldIn.isClientSide)
            return ActionResult.success(stack);

        CompoundNBT nbt = stack.getTag();


        //Minecraft.getInstance().setScreen(new GuidebookScreen(new ResourceLocation(Main.MOD_ID, "textures/gui/re8storybookicon.png")));
//        if (FMLEnvironment.dist == Dist.CLIENT)
//        {
//            Minecraft.getInstance().setScreen(new BookBase(stack));
//        }
        if(worldIn.isClientSide)
        {
            Main.PROXY.openBestiaryGui(stack);
        }

//            ClientAPI.displayBook("");

        return ActionResult.success(stack);
    }

    public ItemStack of(ResourceLocation book) {
        ItemStack stack = new ItemStack(this);
        CompoundNBT tag = new CompoundNBT();
        tag.putString("Book", book.toString());
        stack.setTag(tag);
        return stack;
    }

    @Nullable
    public String getBookLocation(ItemStack stack) {
        CompoundNBT tag = stack.getTag();
        if (tag != null) {
            return tag.getString("Book");
        }
        return null;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        if (flagIn == ITooltipFlag.TooltipFlags.ADVANCED) {
            String book = getBookLocation(stack);
        }
    }

    @Override
    public ITextComponent getName(ItemStack stack) {
        String book = getBookLocation(stack);

        return super.getName(stack);
    }

    public static String getSubtype(ItemStack stack) {
        if (stack.getItem() instanceof ItemStoryBook) {
            String bookLocation = ((ItemStoryBook) stack.getItem()).getBookLocation(stack);
            return bookLocation == null ? "" : bookLocation;
        }
        return "";
    }

}
