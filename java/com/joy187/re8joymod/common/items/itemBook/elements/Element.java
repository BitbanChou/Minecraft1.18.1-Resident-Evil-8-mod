package com.joy187.re8joymod.common.items.itemBook.elements;

public abstract class Element
{
    public int position = 0;

    public int x = 0;
    public int y = 0;
    public int w = 0;
    public int h = 0;

    public int z = 0;

    @Override
    public String toString()
    {
        return toString(false);
    }

    public abstract String toString(boolean complete);
}
