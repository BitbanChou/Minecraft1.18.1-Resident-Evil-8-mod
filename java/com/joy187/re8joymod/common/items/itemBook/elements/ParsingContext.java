package com.joy187.re8joymod.common.items.itemBook.elements;


import javax.xml.parsers.DocumentBuilder;

public interface ParsingContext
{
    boolean loadedFromConfigFolder();
    DocumentBuilder xmlDocumentBuilder();
}
