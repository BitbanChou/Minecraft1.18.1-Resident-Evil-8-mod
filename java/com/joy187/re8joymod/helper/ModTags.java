package com.joy187.re8joymod.helper;


import com.joy187.re8joymod.Utils;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.tags.BlockTags.bind;

public class ModTags {
    public static class Blocks {

        public static final ITag.INamedTag<Block> PORTAL_FRAME_BLOCKS
                = bind("portal_frame_blocks");

        private static ITag.INamedTag<Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation(Utils.MOD_ID, name));
        }

        private static ITag.INamedTag<Block> forgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

//    public static class Items {
//        public static final TagKey<Item> CITRINE_GEMS = forgeTag("gems/citrine");
//
//        private static TagKey<Item> tag(String name) {
//            return ItemTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
//        }
//
//        private static TagKey<Item> forgeTag(String name) {
//            return ItemTags.create(new ResourceLocation("forge", name));
//        }
//    }
}
