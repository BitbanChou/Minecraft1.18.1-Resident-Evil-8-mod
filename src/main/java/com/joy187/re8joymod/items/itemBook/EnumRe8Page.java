package com.joy187.re8joymod.items.itemBook;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;


public enum EnumRe8Page {

    INTRODUCTION(2),
    BOSS(4);
 

    public static final ImmutableList<EnumRe8Page> ALL_PAGES = ImmutableList.copyOf(EnumRe8Page.values());
    public static final ImmutableList<Integer> ALL_INDEXES = ImmutableList
        .copyOf(IntStream.range(0, EnumRe8Page.values().length).iterator());

    public int pages;

    EnumRe8Page(int pages) {
        this.pages = pages;
    }

    public static Set<EnumRe8Page> containedPages(Collection<Integer> pages) {
        return pages.stream().map(ALL_PAGES::get).collect(Collectors.toSet());
    }

    public static boolean hasAllPages(ItemStack book) {
        return Ints.asList(book.getTag().getIntArray("Pages")).containsAll(ALL_INDEXES);
    }

    public static List<Integer> enumToInt(List<EnumRe8Page> pages) {
        return pages.stream().map(EnumRe8Page::ordinal).collect(Collectors.toList());
    }

    public static EnumRe8Page getRand() {
        return EnumRe8Page.values()[ThreadLocalRandom.current().nextInt(EnumRe8Page.values().length)];

    }

    public static void addRandomPage(ItemStack book) {
        if (book.getItem() instanceof ItemStoryBook) {
            List<EnumRe8Page> list = EnumRe8Page.possiblePages(book);
            if (!list.isEmpty()) {
                addPage(list.get(ThreadLocalRandom.current().nextInt(list.size())), book);
            }
        }
    }

    public static List<EnumRe8Page> possiblePages(ItemStack book) {
        if (book.getItem() instanceof ItemStoryBook) {
            CompoundTag tag = book.getTag();
            Collection<EnumRe8Page> containedPages = containedPages(Ints.asList(tag.getIntArray("Pages")));
            List<EnumRe8Page> possiblePages = new ArrayList<>(ALL_PAGES);
            possiblePages.removeAll(containedPages);
            return possiblePages;
        }
        return Collections.emptyList();
    }


    public static boolean addPage(EnumRe8Page page, ItemStack book) {
        boolean flag = false;
        if (book.getItem() instanceof ItemStoryBook) {
            CompoundTag tag = book.getTag();
            final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
            if (!already.contains(page.ordinal())) {
                already.add(page.ordinal());
                flag = true;
            }
            tag.putIntArray("Pages", Ints.toArray(already));
        }
        return flag;
    }


    @Nullable
    public static EnumRe8Page fromInt(int index) {
        if (index < 0) {
            return null;
        }
        int length = values().length;
        return values()[index % length];
    }
}


