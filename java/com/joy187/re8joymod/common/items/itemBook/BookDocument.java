package com.joy187.re8joymod.common.items.itemBook;

import com.google.common.collect.Maps;
import com.google.common.primitives.Floats;
import com.joy187.re8joymod.common.items.itemBook.elements.ElementFactory;
import com.joy187.re8joymod.common.items.itemBook.elements.ParsingContext;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.util.Map;

public class BookDocument
{
    private static final float DEFAULT_FONT_SIZE = 1.0f;

    private float fontSize = 1.0f;

    public SectionRef home = new SectionRef(0, 0);
    private final ResourceLocation bookLocation;
    private String bookName;
    private ResourceLocation bookCover;
    private ResourceLocation bookModel;
    final Map<String, Integer> chaptersByName = Maps.newHashMap();

    private static final Map<ResourceLocation, ElementFactory> customElements = Maps.newHashMap();
    private ResourceLocation background;

    public static void registerCustomElement(ResourceLocation location, ElementFactory factory)
    {
        if (customElements.containsKey(location))
            throw new RuntimeException("Can not register two custom element factories with the same id.");

        customElements.put(location, factory);
    }

    public BookDocument(ResourceLocation bookLocation)
    {
        this.bookLocation = bookLocation;
    }

    public ResourceLocation getLocation()
    {
        return bookLocation;
    }

    public boolean parseBook(InputStream stream, boolean loadedFromConfigFolder)
    {
        try
        {
            //chapters.clear();
            bookName = "";
            bookCover = null;
            fontSize = DEFAULT_FONT_SIZE;
            //chaptersByName.clear();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            ParsingContext parsingContext = new ParsingContext()
            {

                @Override
                public boolean loadedFromConfigFolder()
                {
                    return loadedFromConfigFolder;
                }

                @Override
                public DocumentBuilder xmlDocumentBuilder()
                {
                    return dBuilder;
                }
            };

            doc.getDocumentElement().normalize();

            Node root = doc.getChildNodes().item(0);

            if (root.hasAttributes())
            {
                NamedNodeMap attributes = root.getAttributes();
                Node n = attributes.getNamedItem("title");
                if (n != null)
                {
                    bookName = n.getTextContent();
                }
                n = attributes.getNamedItem("cover");
                if (n != null)
                {
                    bookCover = new ResourceLocation(n.getTextContent());
                }
                n = attributes.getNamedItem("model");
                if (n != null)
                {
                    String text = n.getTextContent();
                    if (text.contains("#"))
                        bookModel = new ModelResourceLocation(text);
                    else
                        bookModel = new ResourceLocation(text);
                }
                n = attributes.getNamedItem("background");
                if (n != null)
                {
                    background = new ResourceLocation(n.getTextContent());
                }
                n = attributes.getNamedItem("fontSize");
                if (n != null)
                {
                    Float f = Floats.tryParse(n.getTextContent());
                    fontSize = f != null ? f : DEFAULT_FONT_SIZE;
                }
                n = attributes.getNamedItem("home");
                if (n != null)
                {
                    String ref = n.getTextContent();
                    home = SectionRef.fromString(ref);
                }
                n = attributes.getNamedItem("dependencies");
                if (n != null)
                {
                    for (String s : n.getTextContent().split(","))
                    {
                        // TODO
                        /*if (!Loader.isModLoaded(s))
                        {
                            initializeWithLoadError("Dependency not loaded: " + s);
                            return false;
                        }*/
                    }
                }
            }

            parseDocumentLevelElements(parsingContext, root.getChildNodes());
        }
        catch (ParserConfigurationException e)
        {
            //initializeWithLoadError(e.toString());
        }
        return true;
    }

//    private static final Map<ResourceLocation, Document> includeCache = new HashMap<>();
//
    private void parseDocumentLevelElements(ParsingContext context, NodeList firstLevel)
    {
        int chapterNumber = 0;
        for (int i = 0; i < firstLevel.getLength(); i++)
        {
            Node firstLevelNode = firstLevel.item(i);

            //chapterNumber = parseDocumentLevelElement(context, chapterNumber, firstLevelNode);
        }
    }

}

