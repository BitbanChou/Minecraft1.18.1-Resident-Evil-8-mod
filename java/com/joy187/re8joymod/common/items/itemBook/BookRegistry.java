//package com.joy187.re8joymod.common.items.itemBook;
//
//import com.google.common.collect.Maps;
//import com.google.common.collect.Sets;
//import com.joy187.re8joymod.Main;
//import net.minecraft.client.Minecraft;
//import net.minecraft.item.ItemStack;
//import net.minecraft.resources.IResource;
//import net.minecraft.resources.IResourceManager;
//import net.minecraft.util.ResourceLocation;
//
//import javax.annotation.Nullable;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class BookRegistry
//{
//    public static final Set<ResourceLocation> REGISTRY = Sets.newHashSet();
//
//    private static boolean booksLoaded = false;
//    private static final Map<ResourceLocation, BookDocument> LOADED_BOOKS = Maps.newHashMap();
//
//    public static Map<ResourceLocation, BookDocument> getLoadedBooks()
//    {
//        if (!booksLoaded)
//        {
//            parseAllBooks(Minecraft.getInstance().getResourceManager());
//        }
//        return Collections.unmodifiableMap(LOADED_BOOKS);
//    }
//
//    public static void registerBook(ResourceLocation loc)
//    {
//        // TODO
//        if (booksLoaded)
//            throw new IllegalStateException("Books must be registered before resource loading start, preferably in the BookRegistryEvent.");
//        REGISTRY.add(loc);
//    }
//
//    static
//    {
//        registerBook(new ResourceLocation("re8joymod:xml/guidebook.xml"));
//    }
//
//    @Nullable
//    public static BookDocument get(ResourceLocation loc)
//    {
//        return getLoadedBooks().get(loc);
//    }
//
//    @Nullable
//    public static BookDocument get(ItemStack stack)
//    {
//        String loc = Main.guidebook.getBookLocation(stack);
//        return loc == null ? null : get(new ResourceLocation(loc));
//    }
//
//    public static void parseAllBooks(IResourceManager manager)
//    {
//        booksLoaded = true;
//
//        //TemplateLibrary.clear();
//
//        LOADED_BOOKS.clear();
//
//        Set<ResourceLocation> toLoad = Sets.newHashSet(REGISTRY);
//
//        for (String domain : manager.getNamespaces())
//        {
//            try
//            {
//                List<IResource> resources = manager.getResources(new ResourceLocation(domain, "books.json"));
//
//                for (IResource res : resources)
//                {
//                    //loadBooksData(toLoad, res);
//                }
//            }
//            catch (FileNotFoundException e)
//            {
//                // IGNORE, it just means nothing was found
//            }
//            catch (IOException e)
//            {
//                Main.LOGGER.error("Error loading books from resourcepacks", e);
//            }
//        }
//
//        //loadRawBookFiles();
//
//        String lang = Minecraft.getInstance().getLanguageManager().getSelected().getCode();
//
//        for (ResourceLocation loc : toLoad)
//        {
//            if (!LOADED_BOOKS.containsKey(loc))
//            {
//                BookDocument book = parseBook(manager, loc, lang);
//                if (book != null)
//                    LOADED_BOOKS.put(loc, book);
//            }
//        }
//    }
//
//    @Nullable
//    private static BookDocument parseBook(IResourceManager manager, ResourceLocation location, String lang)
//    {
//        BookDocument bookDocument = new BookDocument(location);
//        try
//        {
//            ResourceLocation bookLocation = bookDocument.getLocation();
//            String domain = bookLocation.getNamespace();
//            String path = bookLocation.getPath();
//            String pathWithoutExtension = path;
//            String extension = "";
//            int ext = path.lastIndexOf('.');
//            if (ext >= 0)
//            {
//                pathWithoutExtension = path.substring(0, ext);
//                extension = path.substring(ext);
//            }
//
//            String localizedPath = pathWithoutExtension + "." + lang + extension;
//            ResourceLocation localizedLoc = new ResourceLocation(domain, localizedPath);
//
//            IResource bookResource;
//            try
//            {
//                bookResource = manager.getResource(localizedLoc);
//            }
//            catch (IOException e)
//            {
//                bookResource = null;
//            }
//
//            if (bookResource == null)
//            {
//                bookResource = manager.getResource(bookLocation);
//            }
//            try (InputStream stream = bookResource.getInputStream())
//            {
//                if (!bookDocument.parseBook(stream, false))
//                    return null;
//            }
//        }
//        catch (IOException e)
//        {
//            //bookDocument.initializeWithLoadError(e.toString());
//        }
//        return bookDocument;
//    }
//
//}
