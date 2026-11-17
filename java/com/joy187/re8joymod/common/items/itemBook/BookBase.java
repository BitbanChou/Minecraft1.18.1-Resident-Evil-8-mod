package com.joy187.re8joymod.common.items.itemBook;


import com.google.common.collect.Maps;
import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.init.ModBlocks;
import com.joy187.re8joymod.common.init.ModItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import org.lwjgl.opengl.GL11;

import java.util.Map;

public class BookBase extends Screen {

    protected static final int X = 256;
    protected static final int Y = 256;
    int page = 0;
    private static final ResourceLocation TEXTURE=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/re8storybookicon.png");
    private static final ResourceLocation DIMI=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/dimi.png");
    private static final ResourceLocation BEI=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/bei.png");
    private static final ResourceLocation MO=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/mo.png");
    private static final ResourceLocation HEISEN=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/heisen.png");
    private static final ResourceLocation MIRANDA=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/miranda.png");
    private static final ResourceLocation BREAK=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/to.png");
    private static final ResourceLocation DAUGHTERS=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/daughters.png");
    private static final ResourceLocation STURM=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/sturm.png");
    private static final ResourceLocation RECIPE9=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/recipe9.png");
    private static final ResourceLocation RECIPEV=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/recipev.png");
    private static final ResourceLocation DUKE=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/duke.png");
    private static final ResourceLocation END=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/end.png");
    private static final ResourceLocation ADA=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/ada.png");

    String breakBlock = I18n.get("book.break");
    //public static final BookBase BOOK_BASE = new Page1();
    private static final Map<String, ResourceLocation> PICTURE_LOCATION_CACHE = Maps.newHashMap();
    public ChangePageButton previousPage;
    public ChangePageButton nextPage;
    public ChangePageButton toIntroPage;
    public ChangePageButton toBossPage;
    public int bookPages;
    public int bookPagesTotal = 12;
    protected ItemStack book;
    protected boolean index;
    int pageType;

    public BookBase()
    {
        super(new TranslationTextComponent(""));
        index = true;
    }

    public BookBase(ItemStack book) {
        super(new TranslationTextComponent(""));
        this.book = book;
        index = true;
    }

    public void render(MatrixStack pMatrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(pMatrixStack);

        //background.draw(matrixStack, partialTicks, (int) bookHeight, (float) backgroundScale);
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.s(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.bindTexture(0);
        this.renderBackground(pMatrixStack);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bind(TEXTURE);
        this.getMinecraft().getTextureManager().getTexture(TEXTURE);

        int cornerX = (this.width - X) / 2;
        int cornerY = (this.height - Y) / 2;
        blit(pMatrixStack, cornerX, cornerY, 0, 0, X, Y, 256, 256);

        if (this.bookPages>=0) {
            drawPerPage(pMatrixStack, this.bookPages);
            int pageLeft = bookPages * 2 + 1;
            int pageRight = pageLeft + 1;
//	            font.draw(pMatrixStack, "" + pageLeft, book_left,book_top, 0X303030);
//	            font.draw(pMatrixStack, "" + pageRight, book_left,book_top, 0X303030);
            font.draw(pMatrixStack, "" + pageLeft, cornerX, cornerY - (int) (Y * 0.13), 0X303030);
            font.draw(pMatrixStack, "" + pageRight, cornerX, cornerY - (int) (Y * 0.13), 0X303030);
        }

        super.render(pMatrixStack, mouseX, mouseY, delta);
        //System.out.println("当前页"+this.bookPages+".");
    }


    @Override
    public void init()
    {
        super.init();

        int cornerX = (this.width - X) / 2;
        int cornerY = (this.height - Y) / 2+220;
        this.addButton(
                this.previousPage = new ChangePageButton(cornerX+15, cornerY, false, 0, (p_238834_1_) -> {

                    if(this.bookPages>0)
                        this.bookPages--;
                    else
                        this.bookPages=0;

                }));

        this.addButton(
                this.nextPage = new ChangePageButton(cornerX+220, cornerY, true, 0, (p_214132_1_) -> {
                    if(this.bookPages<this.bookPagesTotal)
                        this.bookPages++;

                }));

        this.addButton(
                this.toIntroPage = new ChangePageButton(cornerX+50, cornerY, true, 0, "book.intro",(p_214132_1_) -> {
                    this.bookPages=0;
                }));

        this.addButton(
                this.toBossPage = new ChangePageButton(cornerX+85, cornerY, true, 0, "book.boss",(p_214132_1_) -> {
                    this.bookPages=2;
                }));

        this.addButton(
                this.toBossPage = new ChangePageButton(cornerX+140, cornerY, true, 0, "book.virus",(p_214132_1_) -> {
                    this.bookPages=8;
                }));

        this.addButton(
                this.toBossPage = new ChangePageButton(cornerX+175, cornerY, true, 0, "book.theend",(p_214132_1_) -> {
                    this.bookPages=10;
                }));
    }

    public void drawPerPage(MatrixStack ms, int bookPages) {
        switch (this.bookPages) {
            case 0:
                if (bookPages == 0) {
                    ms.pushPose();
                    ms.scale(1F, 1F, 1F);
                    //drawImage(ms, DRAWINGS_0, 144, 0, 389, 1, 50, 50, 512F);
                    String text = I18n.get("book.welcome");
                    String text2 = I18n.get("book.welcome1");
                    String text3 = I18n.get("book.welcome2");

                    int cornerX = (this.width - X) / 2 +10;
                    int cornerY = (this.height - Y) / 2+10;
                    font.draw(ms,text,cornerX,cornerY+10, 0X303030);
                    int centerY = cornerY+20,cur=cornerY+20;
                    int len = text2.length();
                    for(int i=0;i*24<len;i++)
                    {
                        String temp ="";
                        if(i*24+24<len){
                            temp=text2.substring(i*24,(i+1)*24);
                        }
                        else{
                            temp=text2.substring(i*24);
                        }
                        cur=centerY+10*i;
                        font.draw(ms,temp,cornerX,centerY+10*i, 0x000000);
                    }

                    centerY=cur+10;
                    len = text3.length();
                    for(int i=0;i*24<len;i++)
                    {
                        String temp ="";
                        if(i*24+24<len){
                            temp=text3.substring(i*24,(i+1)*24);
                        }
                        else{
                            temp=text3.substring(i*24);
                        }
                        cur=centerY+10*i;
                        font.draw(ms,temp,cornerX,centerY+10*i, 0x000000);
                    }
                    ms.popPose();

                }
                break;
            case 1:
                if (bookPages == 1) {
                    ms.pushPose();
                    ms.scale(1F, 1F, 1F);
                    String text = I18n.get("book.enterdimension");
                    String text2 = I18n.get("book.key");

                    int cornerX = (this.width - X) / 2 +10;
                    int cornerY = (this.height - Y) / 2+15;
                    int centerY = cornerY;
                    int len = text.length();
                    for(int i=0;i*24<len;i++)
                    {
                        String temp ="";
                        if(i*24+24<len){
                            temp=text.substring(i*24,(i+1)*24);
                        }
                        else{
                            temp=text.substring(i*24);
                        }
                        centerY=cornerY+10*i;
                        font.draw(ms,temp,cornerX,cornerY+10*i, 0x000000);
                    }
                    //font.draw(ms,text,cornerX,cornerY+10, 0x000000);
                    centerY +=10;
                    ItemStack item = new ItemStack(ModBlocks.DHANDS_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item, cornerX, centerY);
                    this.itemRenderer.renderGuiItem(item, cornerX+10, centerY+5);
                    this.itemRenderer.renderGuiItem(item, cornerX+20, centerY+10);
                    this.itemRenderer.renderGuiItem(item, cornerX+30, centerY+15);

                    this.itemRenderer.renderGuiItem(item, cornerX, centerY+12);
                    this.itemRenderer.renderGuiItem(item, cornerX+30, centerY+15+12);

                    this.itemRenderer.renderGuiItem(item, cornerX, centerY+24);
                    this.itemRenderer.renderGuiItem(item, cornerX+30, centerY+15+24);

                    this.itemRenderer.renderGuiItem(item, cornerX, centerY+36);
                    this.itemRenderer.renderGuiItem(item, cornerX+30, centerY+15+36);

                    this.itemRenderer.renderGuiItem(item, cornerX, centerY+48);
                    this.itemRenderer.renderGuiItem(item, cornerX+10, centerY+5+48);
                    this.itemRenderer.renderGuiItem(item, cornerX+20, centerY+10+48);
                    this.itemRenderer.renderGuiItem(item, cornerX+30, centerY+15+48);

                    ItemStack item2 = new ItemStack(Items.WATER_BUCKET);
                    this.itemRenderer.renderGuiItem(item2, cornerX+50, centerY+15+24);

                    this.itemRenderer.renderGuiItem(item, cornerX+10, centerY+5);
                    font.draw(ms,I18n.get("book.biome"),cornerX+130, centerY+5, 0x000000);
                    font.draw(ms,"1: "+I18n.get("book.biome1"),cornerX+130, centerY+15, 0xB32016);
                    font.draw(ms,"2: "+I18n.get("book.biome2"),cornerX+130, centerY+25, 0xB32016);
                    font.draw(ms,"3: "+I18n.get("book.biome3"),cornerX+130, centerY+35, 0xB32016);
                    font.draw(ms,"4: "+I18n.get("book.biome4"),cornerX+130, centerY+45, 0xB32016);
                    font.draw(ms,"5: "+I18n.get("book.biome5"),cornerX+130, centerY+55, 0xB32016);

                    ms.popPose();

                    ms.pushPose();
                    centerY +=80;
                    font.draw(ms,text2,cornerX,centerY, 0x000000);
                    ItemStack item3 = new ItemStack(ModItems.KEY.get());
                    ItemStack item4 = new ItemStack(ModItems.KEY2.get());
                    ItemStack item5 = new ItemStack(ModItems.KEY3.get());
                    this.itemRenderer.renderGuiItem(item3, cornerX+5, centerY+20);
                    this.itemRenderer.renderGuiItem(item4, cornerX+48, centerY+20);
                    this.itemRenderer.renderGuiItem(item5, cornerX+95, centerY+20);

                    drawImage(ms, BREAK, cornerX+15, centerY+15, 0, 0, 32, 32, 512F);
                    drawImage(ms, BREAK, cornerX+65, centerY+15, 0, 0, 32, 32, 512F);

                    ms.popPose();


                }
                break;
            case 2:
                if (bookPages == 2) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    drawImage(ms, DIMI, cornerX, cornerY, 0, 0, 101, 128, 512F);

                    ms.pushPose();
                    String text1 = I18n.get("book.dimiinfo1");
                    String text2 = I18n.get("book.dimiinfo2");
                    String text3 = I18n.get("book.dimiinfo3");
                    String fit = I18n.get("book.dimifit");
                    String loot = I18n.get("book.loot");

                    ms.scale(0.8F, 0.8F, 0.8F);

                    font.draw(ms,text1,cornerX+35,cornerY-30, 0x000000);
                    font.draw(ms,text2,cornerX+35,cornerY-20, 0x000000);
                    font.draw(ms,text3,cornerX+35,cornerY-10, 0x000000);
                    font.draw(ms,fit,cornerX+35,cornerY+210, 0x971F11);

                    ItemStack item = new ItemStack(ModItems.KEY.get());
                    this.itemRenderer.renderGuiItem(item, cornerX+10, cornerY+140);

                    ItemStack item2 = new ItemStack(ModBlocks.PALEW_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item2, cornerX+65, cornerY+140);

                    ms.popPose();

                    drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                    ms.popPose();

                    ms.pushPose();
                    ms.scale(1.5F, 1.5F, 1F);
                    font.draw(ms,loot,cornerX+60,cornerY-15, 0x000000);

                    ItemStack item3 = new ItemStack(ModItems.DIMI_HAT.get());
                    this.itemRenderer.renderGuiItem(item3, cornerX+90+60-15, cornerY+15);

//                    ItemStack item4 = new ItemStack(ModItems.DIMI_SUIT.get());
//                    this.itemRenderer.renderGuiItem(item4, cornerX+90+60-15, cornerY+15+15);

                    ItemStack item5 = new ItemStack(ModItems.DIMIHANBLADE.get());
                    this.itemRenderer.renderGuiItem(item5, cornerX+70+40+60-15, cornerY+15);

                    ItemStack item6 = new ItemStack(ModItems.SLIVERREN.get());
                    this.itemRenderer.renderGuiItem(item6, cornerX+70+40+60-15, cornerY+15+15);

                    ItemStack item7 = new ItemStack(ModItems.WINE.get());
                    this.itemRenderer.renderGuiItem(item7, cornerX+70+40+60-15, cornerY+30+15);

                    ItemStack item8 = new ItemStack(ModItems.BOTTLE2.get());
                    this.itemRenderer.renderGuiItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                    ItemStack item9 = new ItemStack(ModBlocks.DIMITORSO.get());
                    this.itemRenderer.renderGuiItem(item9, cornerX+85+40+60-5, cornerY+15+15);

                    ms.popPose();

                }
            case 3:
                if (bookPages == 3) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    drawImage(ms, BEI, cornerX, cornerY, 0, 0, 95, 128, 512F);

                    ms.pushPose();
                    String text1 = I18n.get("book.beiinfo1");
                    String text2 = I18n.get("book.beiinfo2");
                    String text3 = I18n.get("book.beiinfo3");
                    //String text4 = I18n.get("book.beiinfo4");
                    String fit = I18n.get("book.beifit");
                    String loot = I18n.get("book.loot");

                    ms.scale(0.8F, 0.8F, 0.8F);

                    font.draw(ms,text1,cornerX+35,cornerY-30, 0x000000);
                    font.draw(ms,text2,cornerX+35,cornerY-20, 0x000000);
                    font.draw(ms,text3,cornerX+35,cornerY-10, 0x000000);
                    //font.draw(ms,text4,cornerX+35,cornerY-0, 0x000000);
                    font.draw(ms,fit,cornerX+35,cornerY+210, 0x971F11);

                    ItemStack item = new ItemStack(ModItems.KEY.get());
                    this.itemRenderer.renderGuiItem(item, cornerX+10, cornerY+140);

                    ItemStack item2 = new ItemStack(ModBlocks.DUNGEON_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item2, cornerX+65, cornerY+140);

                    ms.popPose();

                    drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                    ms.popPose();

                    ms.pushPose();
                    ms.scale(1.5F, 1.5F, 1F);
                    font.draw(ms,loot,cornerX+60,cornerY-15, 0x000000);

                    ItemStack item5 = new ItemStack(ModItems.RESHIELD.get());
                    this.itemRenderer.renderGuiItem(item5, cornerX+70+40+60-15, cornerY+15);

                    ItemStack item6 = new ItemStack(ModItems.ROSEGENE.get());
                    this.itemRenderer.renderGuiItem(item6, cornerX+70+40+60-15, cornerY+15+20);

                    ItemStack item7 = new ItemStack(ModItems.BOTTLE4.get());
                    this.itemRenderer.renderGuiItem(item7, cornerX+70+40+60-15, cornerY+30+20);

                    ms.popPose();
                }
            case 4:
                if (bookPages == 4) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    drawImage(ms, MO, cornerX, cornerY, 0, 0, 100, 128, 512F);

                    ms.pushPose();
                    String text1 = I18n.get("book.moinfo1");
                    String text2 = I18n.get("book.moinfo2");
                    String text3 = I18n.get("book.moinfo3");
                    String fit = I18n.get("book.mofit");
                    String loot = I18n.get("book.loot");

                    ms.scale(0.8F, 0.8F, 0.8F);

                    font.draw(ms,text1,cornerX+35,cornerY-30, 0x000000);
                    font.draw(ms,text2,cornerX+35,cornerY-20, 0x000000);
                    font.draw(ms,text3,cornerX+35,cornerY-10, 0x000000);
                    font.draw(ms,fit,cornerX+35,cornerY+210, 0x971F11);

                    ItemStack item = new ItemStack(ModItems.KEY2.get());
                    this.itemRenderer.renderGuiItem(item, cornerX+10, cornerY+140);

                    ItemStack item2 = new ItemStack(ModBlocks.MUCUS_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item2, cornerX+65, cornerY+140);

                    ms.popPose();

                    drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                    ms.popPose();

                    ms.pushPose();
                    ms.scale(1.5F, 1.5F, 1F);
                    font.draw(ms,loot,cornerX+60,cornerY-15, 0x000000);


                    ItemStack item5 = new ItemStack(ModItems.MOREAUHEAD.get());
                    this.itemRenderer.renderGuiItem(item5, cornerX+70+40+60-15, cornerY+15);

                    ItemStack item6 = new ItemStack(ModItems.MCHEESE.get());
                    this.itemRenderer.renderGuiItem(item6, cornerX+70+40+60-15, cornerY+15+15);

                    ItemStack item7 = new ItemStack(ModBlocks.MUCUS_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item7, cornerX+70+40+60-15, cornerY+30+15);

                    ItemStack item8 = new ItemStack(ModItems.BOTTLE3.get());
                    this.itemRenderer.renderGuiItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                    ItemStack item9 = new ItemStack(ModBlocks.MOREAUTORSO.get());
                    this.itemRenderer.renderGuiItem(item9, cornerX+85+40+60-5, cornerY+15+15);

                    ms.popPose();
                }
            case 5:
                if (bookPages == 5) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    drawImage(ms, HEISEN, cornerX, cornerY, 0, 0, 97, 128, 512F);

                    ms.pushPose();
                    String text1 = I18n.get("book.heiseninfo1");
                    String text2 = I18n.get("book.heiseninfo2");
                    String text3 = I18n.get("book.heiseninfo3");
                    String fit = I18n.get("book.heisenfit");
                    String loot = I18n.get("book.loot");

                    ms.scale(0.8F, 0.8F, 0.8F);

                    font.draw(ms,text1,cornerX+35,cornerY-30, 0x000000);
                    font.draw(ms,text2,cornerX+35,cornerY-20, 0x000000);
                    font.draw(ms,text3,cornerX+35,cornerY-10, 0x000000);
                    font.draw(ms,fit,cornerX+35,cornerY+210, 0x971F11);

                    ItemStack item = new ItemStack(ModItems.KEY2.get());
                    this.itemRenderer.renderGuiItem(item, cornerX+10, cornerY+140);

                    ItemStack item2 = new ItemStack(ModBlocks.FACTW_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item2, cornerX+65, cornerY+140);

                    ms.popPose();

                    drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                    ms.popPose();

                    ms.pushPose();
                    ms.scale(1.5F, 1.5F, 1F);
                    font.draw(ms,loot,cornerX+60,cornerY-15, 0x000000);



                    ItemStack item3 = new ItemStack(ModItems.HEISEN_HEAD.get());
                    this.itemRenderer.renderGuiItem(item3, cornerX+90+60-15, cornerY+15);

//                    ItemStack item4 = new ItemStack(ModItems.DIMI_SUIT.get());
//                    this.itemRenderer.renderGuiItem(item4, cornerX+90+60-15, cornerY+15+15);

                    ItemStack item5 = new ItemStack(ModItems.FENBAOCHUI.get());
                    this.itemRenderer.renderGuiItem(item5, cornerX+70+40+60-15, cornerY+15);

                    ItemStack item6 = new ItemStack(ModItems.HCKEY.get());
                    this.itemRenderer.renderGuiItem(item6, cornerX+70+40+60-15, cornerY+15+15);

                    ItemStack item7 = new ItemStack(ModItems.CIGAR.get());
                    this.itemRenderer.renderGuiItem(item7, cornerX+70+40+60-15, cornerY+30+15);

                    ItemStack item8 = new ItemStack(ModItems.HSAW.get());
                    this.itemRenderer.renderGuiItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                    ItemStack item9 = new ItemStack(ModItems.BOTTLE1.get());
                    this.itemRenderer.renderGuiItem(item9, cornerX+70+40+60-15, cornerY+60+15);

                    ItemStack item10 = new ItemStack(ModBlocks.HEISENTORSO.get());
                    this.itemRenderer.renderGuiItem(item10, cornerX+85+40+60-5, cornerY+15+15);

                    ms.popPose();
                }
            case 6:
                if (bookPages == 6) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    drawImage(ms, MIRANDA, cornerX, cornerY, 0, 0, 106, 128, 512F);

                    ms.pushPose();
                    String text1 = I18n.get("book.mirandainfo1");
//                    String text2 = I18n.get("book.heiseninfo2");
//                    String text3 = I18n.get("book.heiseninfo3");
//                    String fit = I18n.get("book.heisenfit");
                    String loot = I18n.get("book.loot");

//                    ms.scale(0.8F, 0.8F, 0.8F);
//
                    font.draw(ms,text1,cornerX+20,cornerY-30, 0x000000);
//                    font.draw(ms,text2,cornerX+35,cornerY-20, 0x000000);
//                    font.draw(ms,text3,cornerX+35,cornerY-10, 0x000000);
//                    font.draw(ms,fit,cornerX+35,cornerY+210, 0x971F11);

                    ItemStack item = new ItemStack(ModItems.KEY3.get());
                    this.itemRenderer.renderGuiItem(item, cornerX+10, cornerY+140);

                    ItemStack item2 = new ItemStack(ModBlocks.FANTOM_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item2, cornerX+65, cornerY+140);

                    ms.popPose();

                    drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                    ms.popPose();

                    ms.pushPose();
                    ms.scale(1.5F, 1.5F, 1F);
                    font.draw(ms,loot,cornerX+60,cornerY-15, 0x000000);

                    ItemStack item3 = new ItemStack(ModItems.MIRANDA_MASK.get());
                    this.itemRenderer.renderGuiItem(item3, cornerX+90+60-15, cornerY+15);

//                    ItemStack item4 = new ItemStack(ModItems.DIMI_SUIT.get());
//                    this.itemRenderer.renderGuiItem(item4, cornerX+90+60-15, cornerY+15+15);

                    ItemStack item5 = new ItemStack(ModItems.HAGWAND.get());
                    this.itemRenderer.renderGuiItem(item5, cornerX+70+40+60-15, cornerY+20);

                    ItemStack item6 = new ItemStack(ModBlocks.UMBERLLA_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item6, cornerX+70+40+60-15, cornerY+25+15);

                    ItemStack item7 = new ItemStack(ModItems.BLACKBALL.get());
                    this.itemRenderer.renderGuiItem(item7, cornerX+70+40+60-15, cornerY+40+15);

//                    ItemStack item8 = new ItemStack(ModItems.BOTTLE2.get());
//                    this.itemRenderer.renderGuiItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                    ItemStack item9 = new ItemStack(ModItems.SOLARDISK.get());
                    this.itemRenderer.renderGuiItem(item9, cornerX+85+40+60-5, cornerY+15);

                    ms.popPose();
                }
            case 7:
                if (bookPages == 7) {

                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    //drawImage(ms, MIRANDA, cornerX, cornerY, 0, 0, 106, 128, 512F);

                    ms.pushPose();

                    String text1 = I18n.get("book.uriasinfo");
                    String text2 = I18n.get("book.uriassinfo");
                    String text3 = I18n.get("book.axemaninfo");
                    String text4 = I18n.get("book.moreaufishinfo");
                    String text5 = I18n.get("book.daughters");
                    String text6 = I18n.get("book.sturm");

//                    String text2 = I18n.get("book.heiseninfo2");
//                    String text3 = I18n.get("book.heiseninfo3");
//                    String fit = I18n.get("book.heisenfit");
                    //String loot = I18n.get("book.loot");

//                    ms.scale(0.8F, 0.8F, 0.8F);
//
                    font.draw(ms,text1,cornerX+35,cornerY-30, 0x000000);
                    ItemStack item = new ItemStack(ModItems.KEY.get());
                    this.itemRenderer.renderGuiItem(item, cornerX+10, cornerY-15);
                    ItemStack item2 = new ItemStack(ModBlocks.DEYE_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item2, cornerX+65, cornerY-15);
                    ms.popPose();
                    drawImage(ms, BREAK, cornerX+30, cornerY-20, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY-15, 0x971F11);
                    ms.popPose();



                    ms.pushPose();
                    font.draw(ms,text2,cornerX+20,cornerY+15, 0x000000);
                    ItemStack item3 = new ItemStack(ModItems.KEY2.get());
                    this.itemRenderer.renderGuiItem(item3, cornerX+10, cornerY+15+15);
                    this.itemRenderer.renderGuiItem(item2, cornerX+65, cornerY+15+15);
                    ms.popPose();
                    drawImage(ms, BREAK, cornerX+30, cornerY+25, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+15+15, 0x971F11);
                    ms.popPose();



                    ms.pushPose();
                    font.draw(ms,text3,cornerX+35,cornerY+15+45, 0x000000);
                    ItemStack item4 = new ItemStack(ModBlocks.DUNGEON_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item3, cornerX+10, cornerY+15+15+45);
                    this.itemRenderer.renderGuiItem(item4, cornerX+65, cornerY+15+15+45);

                    ms.popPose();
                    drawImage(ms, BREAK, cornerX+30, cornerY+70, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+15+15+45, 0x971F11);
                    ms.popPose();


                    ms.pushPose();
                    font.draw(ms,text4,cornerX+20,cornerY+15+90, 0x000000);
                    ItemStack item5 = new ItemStack(ModItems.KEY3.get());
                    ItemStack item6 = new ItemStack(ModBlocks.MUCUS_BLOCK.get());

                    this.itemRenderer.renderGuiItem(item5, cornerX+10, cornerY+15+15+90);
                    this.itemRenderer.renderGuiItem(item6, cornerX+65, cornerY+15+15+90);
                    ms.popPose();
                    drawImage(ms, BREAK, cornerX+30, cornerY+115, 0, 0, 32, 32, 512F);
                    ms.pushPose();
                    font.draw(ms,breakBlock,cornerX+35,cornerY+15+15+90, 0x971F11);

                    ItemStack item9 = new ItemStack(ModItems.URIASHAMMER.get());
                    ItemStack item10 = new ItemStack(ModItems.URIASSHAMMER.get());
                    ItemStack item11 = new ItemStack(ModItems.XUANFENGAXE.get());
                    this.itemRenderer.renderGuiItem(item9, cornerX+10, cornerY+15+15+90+30);
                    this.itemRenderer.renderGuiItem(item10, cornerX+30, cornerY+15+15+90+30);
                    this.itemRenderer.renderGuiItem(item11, cornerX+50, cornerY+15+15+90+30);

                    ms.popPose();

                    ms.pushPose();
                    font.draw(ms,text5,cornerX+120,cornerY-30, 0x000000);
                    font.draw(ms,text6,cornerX+145,cornerY+15+90, 0x000000);
                    ItemStack item7 = new ItemStack(ModBlocks.CRYSTALTORSO.get());
                    ItemStack item8 = new ItemStack(ModBlocks.CMH.get());
                    this.itemRenderer.renderGuiItem(item7, cornerX+130, cornerY+15+15+45);
                    this.itemRenderer.renderGuiItem(item8, cornerX+170, cornerY+15+15+45);

                    ms.popPose();

                    drawImage(ms, DAUGHTERS, cornerX+120, cornerY-15, 0, 0, 100, 72, 512F);
                    drawImage(ms, STURM, cornerX+135, cornerY+115, 0, 0, 82, 72, 512F);


                }
            case 8:
                if (bookPages == 8) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    //drawImage(ms, MIRANDA, cornerX, cornerY, 0, 0, 106, 128, 512F);

                    ms.pushPose();

                    String text1 = I18n.get("book.virusgenerator");
                    String text2 = I18n.get("book.virusgeneratorintro");
                    String text3 = I18n.get("book.virusgeneratorfuel");

                    String text4 = I18n.get("book.fuel1");
                    String text5 = I18n.get("item.re8joymod.blacksheep");
                    String text6 = I18n.get("item.re8joymod.desolate_grass");

                    font.draw(ms,text1,cornerX+20,cornerY-30, 0x000000);
                    font.draw(ms,text2,cornerX,cornerY-20, 0x000000);

                    ItemStack item = new ItemStack(ModBlocks.VIRUS_GENERATOR_BLOCK.get());
                    ItemStack item2 = new ItemStack(ModItems.MACHINEHEARTB.get());
                    ItemStack item3 = new ItemStack(ModBlocks.FACT_IRON_BLOCK.get());
                    ItemStack item4 = new ItemStack(ModBlocks.FANTOM_BLOCK.get());
                    ItemStack item5 = new ItemStack(Items.FERMENTED_SPIDER_EYE);
                    ItemStack item6 = new ItemStack(ModItems.BLACKSHEEP.get());
                    ItemStack item7 = new ItemStack(ModItems.DESOLATE_GRASS_BLOCK.get());

                    this.itemRenderer.renderGuiItem(item2, cornerX+12, cornerY-5);
                    this.itemRenderer.renderGuiItem(item2, cornerX+31, cornerY-5);
                    this.itemRenderer.renderGuiItem(item2, cornerX+50, cornerY-5);

                    this.itemRenderer.renderGuiItem(item3, cornerX+12, cornerY+15);
                    this.itemRenderer.renderGuiItem(item4, cornerX+31, cornerY+15);
                    this.itemRenderer.renderGuiItem(item3, cornerX+50, cornerY+15);

                    this.itemRenderer.renderGuiItem(item3, cornerX+12, cornerY+35);
                    this.itemRenderer.renderGuiItem(item3, cornerX+31, cornerY+35);
                    this.itemRenderer.renderGuiItem(item3, cornerX+50, cornerY+35);

                    this.itemRenderer.renderGuiItem(item, cornerX+87, cornerY+15);

                    font.draw(ms,"1: "+text4,cornerX,cornerY+100, 0x000000);
                    font.draw(ms,"2: "+text5,cornerX,cornerY+110, 0x000000);
                    font.draw(ms,"3: "+text6,cornerX,cornerY+120, 0x000000);

                    this.itemRenderer.renderGuiItem(item5, cornerX+24, cornerY+135);
                    this.itemRenderer.renderGuiItem(item6, cornerX+48, cornerY+135);
                    this.itemRenderer.renderGuiItem(item7, cornerX+72, cornerY+135);

                    ms.popPose();
                    drawImage(ms, RECIPE9, cornerX+10, cornerY-5, 0, 0, 99, 59, 512F);

                    ms.pushPose();
                    ms.scale(2F,2F,2F);
                    font.draw(ms,text3,cornerX-35,cornerY+15, 0x000000);
                    ms.popPose();
                }
            case 9:
                if (bookPages == 9) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;

                    ms.pushPose();
                    String text1 = I18n.get("book.virusgenerator");
                    font.draw(ms,text1,cornerX+20,cornerY-30, 0x000000);

                    ItemStack item = new ItemStack(Items.ROTTEN_FLESH);
                    ItemStack item2 = new ItemStack(ModItems.LYEYE.get());
                    ItemStack item3 = new ItemStack(ModItems.HUMUS.get());

                    ItemStack item4 = new ItemStack(Items.DANDELION);
                    ItemStack item5 = new ItemStack(ModItems.DESOLATE_GRASS_BLOCK.get());

                    ItemStack item6 = new ItemStack(ModBlocks.MUCUS_BLOCK.get());
                    ItemStack item7 = new ItemStack(ModBlocks.DHANDS_BLOCK.get());

                    ItemStack item8 = new ItemStack(Items.SPIDER_EYE);
                    ItemStack item9 = new ItemStack(ModItems.MOSPITTER.get());

                    ItemStack item10 = new ItemStack(ModItems.HERBGLASSES.get());
                    ItemStack item11 = new ItemStack(ModItems.EVIRUS.get());

                    ItemStack item12 = new ItemStack(ModBlocks.FANTOM_BLOCK.get());
                    ItemStack item13 = new ItemStack(Blocks.REDSTONE_BLOCK);
                    ItemStack item14 = new ItemStack(ModBlocks.UMBERLLA_BLOCK.get());

//                    ItemStack item4 = new ItemStack(ModBlocks.FANTOM_BLOCK.get());
//                    ItemStack item5 = new ItemStack(Items.FERMENTED_SPIDER_EYE);
//                    ItemStack item6 = new ItemStack(ModItems.BLACKSHEEP.get());
//                    ItemStack item7 = new ItemStack(ModItems.DESOLATE_GRASS_BLOCK.get());

                    this.itemRenderer.renderGuiItem(item, cornerX+20, cornerY-10);
                    this.itemRenderer.renderGuiItem(item2, cornerX+20, cornerY+20);
                    this.itemRenderer.renderGuiItem(item3, cornerX+80, cornerY+7);

                    this.itemRenderer.renderGuiItem(item2, cornerX+20, cornerY+30+25);
                    this.itemRenderer.renderGuiItem(item4, cornerX+20, cornerY+30+30+25);
                    this.itemRenderer.renderGuiItem(item5, cornerX+80, cornerY+17+30+25);

                    this.itemRenderer.renderGuiItem(item6, cornerX+20, cornerY+30+60+30);
                    this.itemRenderer.renderGuiItem(item3, cornerX+20, cornerY+30+30+60+35);
                    this.itemRenderer.renderGuiItem(item7, cornerX+80, cornerY+17+30+60+30);

                    this.itemRenderer.renderGuiItem(item, cornerX+20+120, cornerY-10);
                    this.itemRenderer.renderGuiItem(item8, cornerX+20+120, cornerY+20);
                    this.itemRenderer.renderGuiItem(item9, cornerX+80+120, cornerY+7);

                    this.itemRenderer.renderGuiItem(item3, cornerX+20+120, cornerY+30+25);
                    this.itemRenderer.renderGuiItem(item10, cornerX+20+120, cornerY+30+30+25);
                    this.itemRenderer.renderGuiItem(item11, cornerX+80+120, cornerY+17+30+25);

                    this.itemRenderer.renderGuiItem(item12, cornerX+20+120, cornerY+30+60+30);
                    this.itemRenderer.renderGuiItem(item13, cornerX+20+120, cornerY+30+30+60+35);
                    this.itemRenderer.renderGuiItem(item14, cornerX+80+120, cornerY+17+30+60+30);
//                    this.itemRenderer.renderGuiItem(item3, cornerX+12, cornerY+15);
//                    this.itemRenderer.renderGuiItem(item4, cornerX+31, cornerY+15);
//                    this.itemRenderer.renderGuiItem(item2, cornerX+50, cornerY+15);
//
//                    this.itemRenderer.renderGuiItem(item3, cornerX+12, cornerY+35);
//                    this.itemRenderer.renderGuiItem(item3, cornerX+31, cornerY+35);
//                    this.itemRenderer.renderGuiItem(item3, cornerX+50, cornerY+35);
//
//                    this.itemRenderer.renderGuiItem(item, cornerX+87, cornerY+15);
//
//                    font.draw(ms,text4,cornerX,cornerY+100, 0x000000);
//                    font.draw(ms,text5,cornerX,cornerY+110, 0x000000);
//                    font.draw(ms,text6,cornerX,cornerY+120, 0x000000);
//
//                    this.itemRenderer.renderGuiItem(item5, cornerX+24, cornerY+135);
//                    this.itemRenderer.renderGuiItem(item6, cornerX+48, cornerY+135);
//                    this.itemRenderer.renderGuiItem(item7, cornerX+72, cornerY+135);
//
                    ms.popPose();
                    drawImage(ms, RECIPEV, cornerX+10, cornerY-15, 0, 0, 99, 59, 512F);
                    drawImage(ms, RECIPEV, cornerX+10, cornerY+50, 0, 0, 99, 59, 512F);
                    drawImage(ms, RECIPEV, cornerX+10, cornerY+115, 0, 0, 99, 59, 512F);
                    drawImage(ms, RECIPEV, cornerX+130, cornerY-15, 0, 0, 99, 59, 512F);
                    drawImage(ms, RECIPEV, cornerX+130, cornerY+50, 0, 0, 99, 59, 512F);
                    drawImage(ms, RECIPEV, cornerX+130, cornerY+115, 0, 0, 99, 59, 512F);
                }
            case 10:
                if (bookPages == 10) {

                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    String text1 = I18n.get("book.armybuild");
                    String text2 = I18n.get("book.duketrade");
                    String text3 = I18n.get("book.duketradewarn");

                    ms.pushPose();
                    font.draw(ms,text1,cornerX+20,cornerY-30, 0x000000);
                    font.draw(ms,text2,cornerX+130,cornerY-30, 0x000000);
                    font.draw(ms,text3,cornerX+120,cornerY+110, 0x000000);

                    ItemStack item = new ItemStack(ModItems.RUSTEDPART.get());
                    ItemStack item2 = new ItemStack(ModBlocks.CMH.get());
                    ItemStack item3 = new ItemStack(ModItems.FRANK5KEY.get());

                    this.itemRenderer.renderGuiItem(item, cornerX+31, cornerY-5);
                    this.itemRenderer.renderGuiItem(item2, cornerX+31, cornerY+15);
                    this.itemRenderer.renderGuiItem(item, cornerX+12, cornerY+35);
                    this.itemRenderer.renderGuiItem(item, cornerX+50, cornerY+35);
                    this.itemRenderer.renderGuiItem(item3, cornerX+87, cornerY+15);

                    ItemStack item4 = new ItemStack(Items.REDSTONE);
                    ItemStack item5 = new ItemStack(ModBlocks.CRYSTALTORSO.get());
                    ItemStack item6 = new ItemStack(ModItems.SUMMONDAUGHTER_SPAWN_EGG.get());

                    this.itemRenderer.renderGuiItem(item4, cornerX+31, cornerY-5+90);
                    this.itemRenderer.renderGuiItem(item5, cornerX+31, cornerY+15+90);
                    this.itemRenderer.renderGuiItem(item4, cornerX+12, cornerY+35+90);
                    this.itemRenderer.renderGuiItem(item4, cornerX+50, cornerY+35+90);
                    this.itemRenderer.renderGuiItem(item6, cornerX+87, cornerY+15+90);

                    ItemStack item7 = new ItemStack(ModBlocks.UMBERLLA_BLOCK.get());
                    this.itemRenderer.renderGuiItem(item7, cornerX+120, cornerY+15+90+20);

                    ms.popPose();

                    drawImage(ms, RECIPE9, cornerX+10, cornerY-5, 0, 0, 99, 59, 512F);
                    drawImage(ms, RECIPE9, cornerX+10, cornerY+85, 0, 0, 99, 59, 512F);
                    drawImage(ms, DUKE, cornerX+120, cornerY-15, 0, 0, 102, 120, 512F);


                }
            case 11:
                if (bookPages == 11) {
                    int cornerX = (this.width - X) / 2 +15;
                    int cornerY = (this.height - Y) / 2+45;
                    String text1 = I18n.get("book.showcase");
                    ms.pushPose();
                    font.draw(ms,text1,cornerX+20,cornerY-30, 0x000000);
                    font.draw(ms,"?",cornerX+150,cornerY-30, 0x000000);

                    ItemStack item = new ItemStack(ModItems.M1851B.get());
                    ItemStack item2 = new ItemStack(ModItems.M1851.get());
                    ItemStack item3 = new ItemStack(ModItems.STAKE.get());
                    ItemStack item4 = new ItemStack(ModItems.BERETTA92FS.get());

                    this.itemRenderer.renderGuiItem(item, cornerX+12, cornerY-5);
                    this.itemRenderer.renderGuiItem(item2, cornerX+12, cornerY+15);
                    this.itemRenderer.renderGuiItem(item3, cornerX+12, cornerY+35);
                    this.itemRenderer.renderGuiItem(item4, cornerX+12, cornerY+55);

                    ItemStack item5 = new ItemStack(ModItems.M1897B.get());
                    ItemStack item6 = new ItemStack(ModItems.M1897.get());
                    ItemStack item7 = new ItemStack(ModItems.W870.get());
                    ItemStack item8 = new ItemStack(ModItems.SYG12.get());

                    this.itemRenderer.renderGuiItem(item5, cornerX+12+25, cornerY-5);
                    this.itemRenderer.renderGuiItem(item6, cornerX+12+25, cornerY+15);
                    this.itemRenderer.renderGuiItem(item7, cornerX+12+25, cornerY+35);
                    this.itemRenderer.renderGuiItem(item8, cornerX+12+25, cornerY+55);

                    ItemStack item9 = new ItemStack(ModItems.SNIPERAMMO.get());
                    ItemStack item10 = new ItemStack(ModItems.F2RIFLE.get());
                    ItemStack item11 = new ItemStack(ModItems.SA110.get());

                    this.itemRenderer.renderGuiItem(item9, cornerX+12+25+25, cornerY-5);
                    this.itemRenderer.renderGuiItem(item10, cornerX+12+25+25, cornerY+15);
                    this.itemRenderer.renderGuiItem(item11, cornerX+12+25+25, cornerY+40);

                    ItemStack item12 = new ItemStack(ModItems.RIFLEAMMO.get());
                    ItemStack item13 = new ItemStack(ModItems.WCX.get());
                    ItemStack item14 = new ItemStack(ModItems.DRAGOON.get());

                    this.itemRenderer.renderGuiItem(item12, cornerX+12, cornerY-5+75);
                    this.itemRenderer.renderGuiItem(item13, cornerX+12, cornerY+15+75);
                    this.itemRenderer.renderGuiItem(item14, cornerX+12, cornerY+35+75);

                    ItemStack item17 = new ItemStack(ModItems.GM79B.get());
                    ItemStack item18 = new ItemStack(ModItems.GM79.get());

                    this.itemRenderer.renderGuiItem(item17, cornerX+12+25, cornerY-5+75);
                    this.itemRenderer.renderGuiItem(item18, cornerX+12+25, cornerY+15+75);

                    ItemStack item15 = new ItemStack(ModItems.BOWSHOOT.get());
                    ItemStack item16 = new ItemStack(ModItems.CROSSBOW1.get());
                    this.itemRenderer.renderGuiItem(item15, cornerX+125, cornerY+15+75);
                    this.itemRenderer.renderGuiItem(item16, cornerX+125, cornerY+35+75);

                    ms.popPose();
                    drawImage(ms, ADA, cornerX+135, cornerY-15, 0, 0, 56, 100, 512F);

                }
            case 12:
                if (bookPages == 12) {
                    int cornerX = (this.width - X) / 2;
                    int cornerY = (this.height - Y) / 2;
                    drawImage(ms, END, cornerX, cornerY, 0, 0, 255, 255, 512F);

                }
            default:
                break;
        }
    }

    @Override
    public void tick()
    {
        super.tick();

//	        if (background.update())
//	            minecraft.setScreen(null);

        //updateButtonStates();
    }

    @Override
    public boolean isPauseScreen()
    {
        return true;
    }

    public void drawImage(MatrixStack ms, ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
        ms.pushPose();
        this.getMinecraft().getTextureManager().bind(texture);
        ms.scale(scale / 512F, scale / 512F, scale / 512F);
        blit(ms, x, y, u, v, width, height, width, height);
        ms.popPose();
    }

}
