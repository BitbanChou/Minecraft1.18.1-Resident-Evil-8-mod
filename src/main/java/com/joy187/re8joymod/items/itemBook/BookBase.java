package com.joy187.re8joymod.items.itemBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;

import net.minecraft.client.gui.GuiGraphics;
import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.ItemInit;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ModListScreen;
import net.minecraftforge.common.ForgeI18n;
import com.google.common.primitives.Ints;

public class BookBase extends Screen{
	
    protected static final int X = 256;
    protected static final int Y = 256;
	int page = 0;
    private static final ResourceLocation TEXTURE=
    		new ResourceLocation(Main.MOD_ID, "textures/gui/re8storybookicon.png");
    private static final ResourceLocation DIMI=
            new ResourceLocation(Main.MOD_ID, "textures/gui/dimi.png");
    private static final ResourceLocation BEI=
            new ResourceLocation(Main.MOD_ID, "textures/gui/bei.png");
    private static final ResourceLocation MO=
            new ResourceLocation(Main.MOD_ID, "textures/gui/mo.png");
    private static final ResourceLocation HEISEN=
            new ResourceLocation(Main.MOD_ID, "textures/gui/heisen.png");
    private static final ResourceLocation MIRANDA=
            new ResourceLocation(Main.MOD_ID, "textures/gui/miranda.png");
    private static final ResourceLocation BREAK=
            new ResourceLocation(Main.MOD_ID, "textures/gui/to.png");
    private static final ResourceLocation DAUGHTERS=
            new ResourceLocation(Main.MOD_ID, "textures/gui/daughters.png");
    private static final ResourceLocation STURM=
            new ResourceLocation(Main.MOD_ID, "textures/gui/sturm.png");
    private static final ResourceLocation RECIPE9=
            new ResourceLocation(Main.MOD_ID, "textures/gui/recipe9.png");
    private static final ResourceLocation RECIPEV=
            new ResourceLocation(Main.MOD_ID, "textures/gui/recipev.png");
    private static final ResourceLocation DUKE=
            new ResourceLocation(Main.MOD_ID, "textures/gui/duke.png");
    private static final ResourceLocation END=
            new ResourceLocation(Main.MOD_ID, "textures/gui/end.png");
    private static final ResourceLocation ADA=
            new ResourceLocation(Main.MOD_ID, "textures/gui/ada.png");    
    
    String breakBlock = I18n.get("book.break");
    //public static final BookBase BOOK_BASE = new Page1();
    private static final Map<String, ResourceLocation> PICTURE_LOCATION_CACHE = Maps.newHashMap();
    public List<EnumRe8Page> allPageTypes = new ArrayList<>();
    public EnumRe8Page pageType;
//    public List<ButtonBase> indexButtons = new ArrayList<>();
    public ChangePageButton previousPage;
    public ChangePageButton nextPage;
    public ChangePageButton toIntroPage;
    public ChangePageButton toBossPage;
    public int bookPages;
    public int bookPagesTotal = 14;
    public int indexPages;
    public int indexPagesTotal = 5;
    protected ItemStack book;
    //protected boolean index;
    //protected Font font = getFontRenderer();
    private Button preButton;
    private Button nextButton;
    
    public BookBase()
    {
        super(Component.translatable("text.gbook.book.title"));
        this.book = book;
    }
    
	public BookBase(ItemStack book) {
        super(Component.translatable("re8_gui"));
        this.book = book;
    }

    protected static final Button.CreateNarration DEFAULT_NARRATION = (p_253298_) -> {
        return p_253298_.get();
    };

	public void render(GuiGraphics pPoseStack, int mouseX, int mouseY, float delta) {
	      renderBackground(pPoseStack);
	      
	      //background.draw(matrixStack, partialTicks, (int) bookHeight, (float) backgroundScale);
	      RenderSystem.setShader(GameRenderer::getPositionTexShader);
	      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	      RenderSystem.setShaderTexture(0, TEXTURE);
	      
	      int cornerX = (this.width - X) / 2;
	      int cornerY = (this.height - Y) / 2;
	      pPoseStack.blit(TEXTURE, cornerX, cornerY, 0, 0, X, Y, 256, 256);
	      //GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	      this.getMinecraft().getTextureManager().bindForSetup(TEXTURE);
	      //this.guiGraphics.blit(TEXTURE,book_left,book_top,book_width,window_height,book_width,window_height);
	      //this.guiGraphics.blit(TEXTURE, i, 2, 0, 0, 192, 192);
	      //renderTooltip(pPoseStack, mouseX, mouseY);
	      if (this.bookPages>=0) {
	            drawPerPage(pPoseStack, this.bookPages);
	            int pageLeft = bookPages * 2 + 1;
	            int pageRight = pageLeft + 1;
//	            ms.drawString(font, "" + pageLeft, book_left,book_top, 0X303030);
//	            ms.drawString(font, "" + pageRight, book_left,book_top, 0X303030);
	            pPoseStack.drawString(font, "" + pageLeft, cornerX, cornerY - (int) (Y * 0.13), 0X303030);
	            pPoseStack.drawString(font, "" + pageRight, cornerX, cornerY - (int) (Y * 0.13), 0X303030);
	        }
	      
	      super.render(pPoseStack, mouseX, mouseY, delta);
	      //System.out.println("当前页"+this.bookPages+".");
	   }	
	   
	   
	    @Override
	    public void init()
	    {
	        super.init();

	        int book_width = Math.round((3f/5)*this.width);
	        int up_x = this.width/2 - (book_width/2)+10;
	        int next_x = this.width/2 + (book_width/2)-25;
	        int both_y = Math.round(320*(float)this.height/512)+35;
	        //int both_y = (int)Math.round(book_width*0.625)-10;
	        //float zoom = 320*(float)this.height/512;


		    int cornerX = (this.width - X) / 2;
		    int cornerY = (this.height - Y) / 2+220;
	        this.addRenderableWidget(
	                this.previousPage = new ChangePageButton(cornerX+20, cornerY, false, 0, (p_214132_1_) -> {
	                		          	      	if(this.bookPages>0)
	          	      		this.bookPages--;
	          	      	else
	          	      		this.bookPages=0;
	        },DEFAULT_NARRATION));
	    
	        this.addRenderableWidget(
	        	this.nextPage = new ChangePageButton(cornerX+220, cornerY, true, 0, (p_214132_1_) -> {
      	      	if(this.bookPages<this.bookPagesTotal)
      	      		this.bookPages++;
	        }, DEFAULT_NARRATION));
	        
	        this.addRenderableWidget(
		        	this.toIntroPage = new ChangePageButton(cornerX+50, cornerY, true, 0, "book.intro", (p_214132_1_) -> {
		        		this.bookPages=0;
		        },DEFAULT_NARRATION));
	        
	        this.addRenderableWidget(
		        	this.toBossPage = new ChangePageButton(cornerX+85, cornerY, true, 0, "book.boss", (p_214132_1_) -> {
		        		this.bookPages=2;
		        },DEFAULT_NARRATION));
	        this.addRenderableWidget(
		        	this.toBossPage = new ChangePageButton(cornerX+140, cornerY, true, 0, "book.virus", (p_214132_1_) -> {
		        		this.bookPages=9;
		        },DEFAULT_NARRATION));
	        this.addRenderableWidget(
		        	this.toBossPage = new ChangePageButton(cornerX+175, cornerY, true, 0, "book.theend", (p_214132_1_) -> {
		        		this.bookPages=12;
		        },DEFAULT_NARRATION));
	    }
	    
	    public void drawPerPage(GuiGraphics ms, int bookPages) {
	        switch (this.bookPages) {
            	case 0:
                    if (bookPages == 0) {
                    	ms.pose().pushPose();
                        ms.pose().scale(1F, 1F, 1F);
                        //drawImage(ms, DRAWINGS_0, 144, 0, 389, 1, 50, 50, 512F);
                        String text = I18n.get("book.welcome");
                        String text2 = I18n.get("book.welcome1");
                        String text3 = I18n.get("book.welcome2");
                      
              	      	int cornerX = (this.width - X) / 2 +10;
              	      	int cornerY = (this.height - Y) / 2+10;
                        ms.drawString(font,text,cornerX,cornerY+10, 0X303030);
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
                            ms.drawString(font,temp,cornerX,centerY+10*i, 0x000000);
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
                            ms.drawString(font,temp,cornerX,centerY+10*i, 0x000000);
                        }                        
                        ms.pose().popPose();
                    }
                    break;
                case 1:
                        if (bookPages == 1) {     
                        	ms.pose().pushPose();
                            ms.pose().scale(1F, 1F, 1F);
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
                                ms.drawString(font,temp,cornerX,cornerY+10*i, 0x000000);
                            }
                            //ms.drawString(font,text,cornerX,cornerY+10, 0x000000);
                            centerY +=10; 
                            ItemStack item = new ItemStack(BlockInit.DHANDS_BLOCK.get());
                            ms.renderItem(item, cornerX, centerY);
                            ms.renderItem(item, cornerX+10, centerY+5);
                            ms.renderItem(item, cornerX+20, centerY+10);
                            ms.renderItem(item, cornerX+30, centerY+15);

                            ms.renderItem(item, cornerX, centerY+12);
                            ms.renderItem(item, cornerX+30, centerY+15+12);
                            
                            ms.renderItem(item, cornerX, centerY+24);
                            ms.renderItem(item, cornerX+30, centerY+15+24);
     
                            ms.renderItem(item, cornerX, centerY+36);
                            ms.renderItem(item, cornerX+30, centerY+15+36);
                            
                            ms.renderItem(item, cornerX, centerY+48);
                            ms.renderItem(item, cornerX+10, centerY+5+48);
                            ms.renderItem(item, cornerX+20, centerY+10+48);
                            ms.renderItem(item, cornerX+30, centerY+15+48);
                            
                            ItemStack item2 = new ItemStack(Items.WATER_BUCKET);
                            ms.renderItem(item2, cornerX+50, centerY+15+24);
                            
                            ms.drawString(font,I18n.get("book.biome"),cornerX+130, centerY+5, 0x000000);
                            ms.drawString(font,"1: "+I18n.get("book.biome1"),cornerX+130, centerY+15, 0xB32016);
                            ms.drawString(font,"2: "+I18n.get("book.biome2"),cornerX+130, centerY+25, 0xB32016);
                            ms.drawString(font,"3: "+I18n.get("book.biome3"),cornerX+130, centerY+35, 0xB32016);
                            ms.drawString(font,"4: "+I18n.get("book.biome4"),cornerX+130, centerY+45, 0xB32016);
                            ms.drawString(font,"5: "+I18n.get("book.biome5"),cornerX+130, centerY+55, 0xB32016);

                            ms.pose().popPose();
                            
                            ms.pose().pushPose();
                            centerY +=80;
                            ms.drawString(font,text2,cornerX,centerY, 0x000000);
                            ItemStack item3 = new ItemStack(ItemInit.KEY.get());
                            ItemStack item4 = new ItemStack(ItemInit.KEY2.get());
                            ItemStack item5 = new ItemStack(ItemInit.KEY3.get());
                            ms.renderItem(item3, cornerX+5, centerY+20);
                            ms.renderItem(item4, cornerX+48, centerY+20);
                            ms.renderItem(item5, cornerX+95, centerY+20);

                            drawImage(ms, BREAK, cornerX+15, centerY+15, 0, 0, 32, 32, 512F);
                            drawImage(ms, BREAK, cornerX+65, centerY+15, 0, 0, 32, 32, 512F);

                            ms.pose().popPose();
                    }
                    break;
                case 2:
                    if (bookPages == 2) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        drawImage(ms, DIMI, cornerX, cornerY, 0, 0, 101, 128, 512F);

                        ms.pose().pushPose();
                        String text1 = I18n.get("book.dimiinfo1");
                        String text2 = I18n.get("book.dimiinfo2");
                        String text3 = I18n.get("book.dimiinfo3");
                        String fit = I18n.get("book.dimifit");
                        String loot = I18n.get("book.loot");

                        ms.pose().scale(0.8F, 0.8F, 0.8F);

                        ms.drawString(font,text1,cornerX+35,cornerY-30, 0x000000);
                        ms.drawString(font,text2,cornerX+35,cornerY-20, 0x000000);
                        ms.drawString(font,text3,cornerX+35,cornerY-10, 0x000000);
                        ms.drawString(font,fit,cornerX+35,cornerY+210, 0x971F11);

                        ItemStack item = new ItemStack(ItemInit.KEY.get());
                        ms.renderItem(item, cornerX+10, cornerY+140);

                        ItemStack item2 = new ItemStack(BlockInit.PALEW_BLOCK.get());
                        ms.renderItem(item2, cornerX+65, cornerY+140);

                        ms.pose().popPose();

                        drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                        ms.pose().popPose();

                        ms.pose().pushPose();
                        ms.pose().scale(1.5F, 1.5F, 1F);
                        ms.drawString(font,loot,cornerX+60,cornerY-15, 0x000000);

                        ItemStack item3 = new ItemStack(ItemInit.DIMI_HAT.get());
                        ms.renderItem(item3, cornerX+90+60-15, cornerY+15);

//                        ItemStack item4 = new ItemStack(ItemInit.DIMI_SUIT.get());
//                        ms.renderItem(item4, cornerX+90+60-15, cornerY+15+15);

                        ItemStack item5 = new ItemStack(ItemInit.DIMIHANBLADE.get());
                        ms.renderItem(item5, cornerX+70+40+60-15, cornerY+15);

                        ItemStack item6 = new ItemStack(ItemInit.SLIVERREN.get());
                        ms.renderItem(item6, cornerX+70+40+60-15, cornerY+15+15);

                        ItemStack item7 = new ItemStack(ItemInit.WINE.get());
                        ms.renderItem(item7, cornerX+70+40+60-15, cornerY+30+15);

                        ItemStack item8 = new ItemStack(ItemInit.BOTTLE2.get());
                        ms.renderItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                        ItemStack item9 = new ItemStack(BlockInit.DIMITORSO.get());
                        ms.renderItem(item9, cornerX+85+40+60-5, cornerY+15+15);

                        ms.pose().popPose();

                    }
                case 3:
                    if (bookPages == 3) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        drawImage(ms, BEI, cornerX, cornerY, 0, 0, 95, 128, 512F);

                        ms.pose().pushPose();
                        String text1 = I18n.get("book.beiinfo1");
                        String text2 = I18n.get("book.beiinfo2");
                        String text3 = I18n.get("book.beiinfo3");
                        //String text4 = I18n.get("book.beiinfo4");
                        String fit = I18n.get("book.beifit");
                        String loot = I18n.get("book.loot");

                        ms.pose().scale(0.8F, 0.8F, 0.8F);

                        ms.drawString(font,text1,cornerX+35,cornerY-30, 0x000000);
                        ms.drawString(font,text2,cornerX+35,cornerY-20, 0x000000);
                        ms.drawString(font,text3,cornerX+35,cornerY-10, 0x000000);
                        //ms.drawString(font,text4,cornerX+35,cornerY-0, 0x000000);
                        ms.drawString(font,fit,cornerX+35,cornerY+210, 0x971F11);

                        ItemStack item = new ItemStack(ItemInit.KEY.get());
                        ms.renderItem(item, cornerX+10, cornerY+140);

                        ItemStack item2 = new ItemStack(BlockInit.DUNGEON_BLOCK.get());
                        ms.renderItem(item2, cornerX+65, cornerY+140);

                        ms.pose().popPose();

                        drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                        ms.pose().popPose();

                        ms.pose().pushPose();
                        ms.pose().scale(1.5F, 1.5F, 1F);
                        ms.drawString(font,loot,cornerX+60,cornerY-15, 0x000000);

                        ItemStack item5 = new ItemStack(ItemInit.RESHIELD.get());
                        ms.renderItem(item5, cornerX+70+40+60-15, cornerY+15);

                        ItemStack item6 = new ItemStack(ItemInit.ROSEGENE.get());
                        ms.renderItem(item6, cornerX+70+40+60-15, cornerY+15+20);

                        ItemStack item7 = new ItemStack(ItemInit.BOTTLE4.get());
                        ms.renderItem(item7, cornerX+70+40+60-15, cornerY+30+20);

                        ms.pose().popPose();
                    }
                case 4:
                    if (bookPages == 4) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        drawImage(ms, MO, cornerX, cornerY, 0, 0, 100, 128, 512F);

                        ms.pose().pushPose();
                        String text1 = I18n.get("book.moinfo1");
                        String text2 = I18n.get("book.moinfo2");
                        String text3 = I18n.get("book.moinfo3");
                        String fit = I18n.get("book.mofit");
                        String loot = I18n.get("book.loot");

                        ms.pose().scale(0.8F, 0.8F, 0.8F);

                        ms.drawString(font,text1,cornerX+35,cornerY-30, 0x000000);
                        ms.drawString(font,text2,cornerX+35,cornerY-20, 0x000000);
                        ms.drawString(font,text3,cornerX+35,cornerY-10, 0x000000);
                        ms.drawString(font,fit,cornerX+35,cornerY+210, 0x971F11);

                        ItemStack item = new ItemStack(ItemInit.KEY2.get());
                        ms.renderItem(item, cornerX+10, cornerY+140);

                        ItemStack item2 = new ItemStack(BlockInit.MUCUS_BLOCK.get());
                        ms.renderItem(item2, cornerX+65, cornerY+140);

                        ms.pose().popPose();

                        drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                        ms.pose().popPose();

                        ms.pose().pushPose();
                        ms.pose().scale(1.5F, 1.5F, 1F);
                        ms.drawString(font,loot,cornerX+60,cornerY-15, 0x000000);


                        ItemStack item5 = new ItemStack(ItemInit.MOREAUHEAD.get());
                        ms.renderItem(item5, cornerX+70+40+60-15, cornerY+15);

                        ItemStack item6 = new ItemStack(ItemInit.MCHEESE.get());
                        ms.renderItem(item6, cornerX+70+40+60-15, cornerY+15+15);

                        ItemStack item7 = new ItemStack(BlockInit.MUCUS_BLOCK.get());
                        ms.renderItem(item7, cornerX+70+40+60-15, cornerY+30+15);

                        ItemStack item8 = new ItemStack(ItemInit.BOTTLE3.get());
                        ms.renderItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                        ItemStack item9 = new ItemStack(BlockInit.MOREAUTORSO.get());
                        ms.renderItem(item9, cornerX+85+40+60-5, cornerY+15+15);

                        ms.pose().popPose();
                    }
                case 5:
                    if (bookPages == 5) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        drawImage(ms, HEISEN, cornerX, cornerY, 0, 0, 97, 128, 512F);

                        ms.pose().pushPose();
                        String text1 = I18n.get("book.heiseninfo1");
                        String text2 = I18n.get("book.heiseninfo2");
                        String text3 = I18n.get("book.heiseninfo3");
                        String fit = I18n.get("book.heisenfit");
                        String loot = I18n.get("book.loot");

                        ms.pose().scale(0.8F, 0.8F, 0.8F);

                        ms.drawString(font,text1,cornerX+35,cornerY-30, 0x000000);
                        ms.drawString(font,text2,cornerX+35,cornerY-20, 0x000000);
                        ms.drawString(font,text3,cornerX+35,cornerY-10, 0x000000);
                        ms.drawString(font,fit,cornerX+35,cornerY+210, 0x971F11);

                        ItemStack item = new ItemStack(ItemInit.KEY2.get());
                        ms.renderItem(item, cornerX+10, cornerY+140);

                        ItemStack item2 = new ItemStack(BlockInit.FACTW_BLOCK.get());
                        ms.renderItem(item2, cornerX+65, cornerY+140);

                        ms.pose().popPose();

                        drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                        ms.pose().popPose();

                        ms.pose().pushPose();
                        ms.pose().scale(1.5F, 1.5F, 1F);
                        ms.drawString(font,loot,cornerX+60,cornerY-15, 0x000000);



                        ItemStack item3 = new ItemStack(ItemInit.HEISEN_HEAD.get());
                        ms.renderItem(item3, cornerX+90+60-15, cornerY+15);

//                        ItemStack item4 = new ItemStack(ItemInit.DIMI_SUIT.get());
//                        ms.renderItem(item4, cornerX+90+60-15, cornerY+15+15);

                        ItemStack item5 = new ItemStack(ItemInit.FENBAOCHUI.get());
                        ms.renderItem(item5, cornerX+70+40+60-15, cornerY+15);

                        ItemStack item6 = new ItemStack(ItemInit.FACTORYG.get());
                        ms.renderItem(item6, cornerX+70+40+60-15, cornerY+15+15);

                        ItemStack item7 = new ItemStack(ItemInit.CIGAR.get());
                        ms.renderItem(item7, cornerX+70+40+60-15, cornerY+30+15);

                        ItemStack item8 = new ItemStack(ItemInit.HSAW.get());
                        ms.renderItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                        ItemStack item9 = new ItemStack(ItemInit.BOTTLE1.get());
                        ms.renderItem(item9, cornerX+70+40+60-15, cornerY+60+15);

                        ItemStack item10 = new ItemStack(BlockInit.HEISENTORSO.get());
                        ms.renderItem(item10, cornerX+85+40+60-5, cornerY+15+15);

                        ms.pose().popPose();
                    }
                case 6:
                    if (bookPages == 6) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        drawImage(ms, MIRANDA, cornerX, cornerY, 0, 0, 106, 128, 512F);

                        ms.pose().pushPose();
                        String text1 = I18n.get("book.mirandainfo1");
//                        String text2 = I18n.get("book.heiseninfo2");
//                        String text3 = I18n.get("book.heiseninfo3");
//                        String fit = I18n.get("book.heisenfit");
                        String loot = I18n.get("book.loot");

//                        ms.pose().scale(0.8F, 0.8F, 0.8F);
    //
                        ms.drawString(font,text1,cornerX+20,cornerY-30, 0x000000);
//                        ms.drawString(font,text2,cornerX+35,cornerY-20, 0x000000);
//                        ms.drawString(font,text3,cornerX+35,cornerY-10, 0x000000);
//                        ms.drawString(font,fit,cornerX+35,cornerY+210, 0x971F11);

                        ItemStack item = new ItemStack(ItemInit.KEY3.get());
                        ms.renderItem(item, cornerX+10, cornerY+140);

                        ItemStack item2 = new ItemStack(BlockInit.FANTOM_BLOCK.get());
                        ms.renderItem(item2, cornerX+65, cornerY+140);

                        ms.pose().popPose();

                        drawImage(ms, BREAK, cornerX+30, cornerY+135, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+140, 0x971F11);
                        ms.pose().popPose();

                        ms.pose().pushPose();
                        ms.pose().scale(1.5F, 1.5F, 1F);
                        ms.drawString(font,loot,cornerX+60,cornerY-15, 0x000000);

                        ItemStack item3 = new ItemStack(ItemInit.MIRANDA_MASK.get());
                        ms.renderItem(item3, cornerX+90+60-15, cornerY+15);

//                        ItemStack item4 = new ItemStack(ItemInit.DIMI_SUIT.get());
//                        ms.renderItem(item4, cornerX+90+60-15, cornerY+15+15);

                        ItemStack item5 = new ItemStack(ItemInit.HAGWAND.get());
                        ms.renderItem(item5, cornerX+70+40+60-15, cornerY+20);

                        ItemStack item6 = new ItemStack(BlockInit.EXAMPLE_BLOCK.get());
                        ms.renderItem(item6, cornerX+70+40+60-15, cornerY+25+15);

                        ItemStack item7 = new ItemStack(ItemInit.BLACKBALL.get());
                        ms.renderItem(item7, cornerX+70+40+60-15, cornerY+40+15);

//                        ItemStack item8 = new ItemStack(ItemInit.BOTTLE2.get());
//                        ms.renderItem(item8, cornerX+70+40+60-15, cornerY+45+15);

                        ItemStack item9 = new ItemStack(ItemInit.SOLARDISK.get());
                        ms.renderItem(item9, cornerX+85+40+60-5, cornerY+15);

                        ms.pose().popPose();
                    }
                case 7:
                    if (bookPages == 7) {

                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        //drawImage(ms, MIRANDA, cornerX, cornerY, 0, 0, 106, 128, 512F);

                        ms.pose().pushPose();

                        String text1 = I18n.get("book.uriasinfo");
                        String text2 = I18n.get("book.uriassinfo");
                        String text3 = I18n.get("book.axemaninfo");
                        String text4 = I18n.get("book.moreaufishinfo");
                        String text5 = I18n.get("book.daughters");
                        String text6 = I18n.get("book.sturm");

//                        String text2 = I18n.get("book.heiseninfo2");
//                        String text3 = I18n.get("book.heiseninfo3");
//                        String fit = I18n.get("book.heisenfit");
                        //String loot = I18n.get("book.loot");

//                        ms.pose().scale(0.8F, 0.8F, 0.8F);
    //
                        ms.drawString(font,text1,cornerX+35,cornerY-30, 0x000000);
                        ItemStack item = new ItemStack(ItemInit.KEY.get());
                        ms.renderItem(item, cornerX+10, cornerY-15);
                        ItemStack item2 = new ItemStack(BlockInit.DEYE_BLOCK.get());
                        ms.renderItem(item2, cornerX+65, cornerY-15);
                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30, cornerY-20, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY-15, 0x971F11);
                        ms.pose().popPose();



                        ms.pose().pushPose();
                        ms.drawString(font,text2,cornerX+20,cornerY+15, 0x000000);
                        ItemStack item3 = new ItemStack(ItemInit.KEY2.get());
                        ms.renderItem(item3, cornerX+10, cornerY+15+15);
                        ms.renderItem(item2, cornerX+65, cornerY+15+15);
                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30, cornerY+25, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+15+15, 0x971F11);
                        ms.pose().popPose();



                        ms.pose().pushPose();
                        ms.drawString(font,text3,cornerX+35,cornerY+15+45, 0x000000);
                        ItemStack item4 = new ItemStack(BlockInit.DUNGEON_BLOCK.get());
                        ms.renderItem(item3, cornerX+10, cornerY+15+15+45);
                        ms.renderItem(item4, cornerX+65, cornerY+15+15+45);

                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30, cornerY+70, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+15+15+45, 0x971F11);
                        ms.pose().popPose();


                        ms.pose().pushPose();
                        ms.drawString(font,text4,cornerX+20,cornerY+15+90, 0x000000);
                        ItemStack item5 = new ItemStack(ItemInit.KEY3.get());
                        ItemStack item6 = new ItemStack(BlockInit.MUCUS_BLOCK.get());

                        ms.renderItem(item5, cornerX+10, cornerY+15+15+90);
                        ms.renderItem(item6, cornerX+65, cornerY+15+15+90);
                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30, cornerY+115, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+15+15+90, 0x971F11);

                        ItemStack item9 = new ItemStack(ItemInit.URIASHAMMER.get());
                        ItemStack item10 = new ItemStack(ItemInit.URIASSHAMMER.get());
                        ItemStack item11 = new ItemStack(ItemInit.XUANFENGAXE.get());
                        ms.renderItem(item9, cornerX+10, cornerY+15+15+90+30);
                        ms.renderItem(item10, cornerX+30, cornerY+15+15+90+30);
                        ms.renderItem(item11, cornerX+50, cornerY+15+15+90+30);

                        ms.pose().popPose();

                        ms.pose().pushPose();
                        ms.drawString(font,text5,cornerX+120,cornerY-30, 0x000000);
                        ms.drawString(font,text6,cornerX+145,cornerY+15+90, 0x000000);
                        ItemStack item7 = new ItemStack(BlockInit.CRYSTALTORSO.get());
                        ItemStack item8 = new ItemStack(BlockInit.CMH.get());
                        ms.renderItem(item7, cornerX+130, cornerY+15+15+45);
                        ms.renderItem(item8, cornerX+170, cornerY+15+15+45);

                        ms.pose().popPose();

                        drawImage(ms, DAUGHTERS, cornerX+120, cornerY-15, 0, 0, 100, 72, 512F);
                        drawImage(ms, STURM, cornerX+135, cornerY+115, 0, 0, 82, 72, 512F);


                    }
                case 8:
                    if (bookPages == 8) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        //drawImage(ms, MIRANDA, cornerX, cornerY, 0, 0, 106, 128, 512F);

                        ms.pose().pushPose();

                        String text1 = I18n.get("item.re8joymod.plagaskey");
                        //String text2 = I18n.get("book.virusgeneratorintro");
                        //String text3 = I18n.get("book.virusgeneratorfuel");

                        String text4 = I18n.get("book.fuel1");
                        String text5 = I18n.get("item.re8joymod.blacksheep");
                        String text6 = I18n.get("item.re8joymod.desolate_grass");

                        ms.drawString(font,text1,cornerX+20,cornerY-30, 0x000000);
                        //ms.drawString(font,text2,cornerX,cornerY-20, 0x000000);

                        ItemStack item = new ItemStack(ItemInit.PLAGASKEY.get());
                        ItemStack item2 = new ItemStack(Blocks.RED_STAINED_GLASS);
                        ItemStack item3 = new ItemStack(Blocks.GREEN_STAINED_GLASS);
                        ItemStack item4 = new ItemStack(ItemInit.KEY.get());
                        ItemStack item5 = new ItemStack(Blocks.BLUE_STAINED_GLASS);

                        ms.renderItem(item2, cornerX+12, cornerY-5);
                        //ms.renderItem(item2, cornerX+31, cornerY-5);
                        ms.renderItem(item3, cornerX+50, cornerY-5);

                        //ms.renderItem(item3, cornerX+12, cornerY+15);
                        ms.renderItem(item4, cornerX+31, cornerY+15);
                        //ms.renderItem(item3, cornerX+50, cornerY+15);

                        //ms.renderItem(item3, cornerX+12, cornerY+35);
                        ms.renderItem(item5, cornerX+31, cornerY+35);
                        //ms.renderItem(item3, cornerX+50, cornerY+35);

                        ms.renderItem(item, cornerX+87, cornerY+15);

//                        ms.drawString(font,"1: "+text4,cornerX,cornerY+100, 0x000000);
//                        ms.drawString(font,"2: "+text5,cornerX,cornerY+110, 0x000000);
//                        ms.drawString(font,"3: "+text6,cornerX,cornerY+120, 0x000000);
//
//                        ms.renderItem(item5, cornerX+24, cornerY+135);
//                        ms.renderItem(item6, cornerX+48, cornerY+135);
//                        ms.renderItem(item7, cornerX+72, cornerY+135);

                        ms.pose().popPose();
                        drawImage(ms, RECIPE9, cornerX+10, cornerY-5, 0, 0, 99, 59, 512F);

                        ms.pose().pushPose();
                        ms.pose().scale(2F,2F,2F);
                        //ms.drawString(font,text3,cornerX-35,cornerY+15, 0x000000);
                        ms.pose().popPose();

                        String text23 = I18n.get("entity.re8joymod.verdugo");

                        ms.pose().pushPose();
                        ms.drawString(font,text23,cornerX+35,cornerY+15+45, 0x000000);
                        ItemStack item14 = new ItemStack(Blocks.BLACKSTONE);
                        ms.renderItem(item, cornerX+10, cornerY+15+15+45);
                        ms.renderItem(item14, cornerX+65, cornerY+15+15+45);

                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30, cornerY+70, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+15+15+45, 0x971F11);
                        ms.pose().popPose();

                        String text24 = I18n.get("entity.re8joymod.salazar");

                        ms.pose().pushPose();
                        ms.drawString(font,text24,cornerX+20,cornerY+15+90, 0x000000);
                        ItemStack item16 = new ItemStack(Blocks.BELL);

                        ms.renderItem(item, cornerX+10, cornerY+15+15+90);
                        ms.renderItem(item16, cornerX+65, cornerY+15+15+90);
                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30, cornerY+115, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+15+15+90, 0x971F11);
                        ms.pose().popPose();

                        String text25 = I18n.get("entity.re8joymod.saddler");

                        ms.pose().pushPose();
                        ms.drawString(font,text25,cornerX+20,cornerY+15+90+45, 0x000000);
                        ItemStack item17 = new ItemStack(BlockInit.FANTOM_BLOCK.get());

                        ms.renderItem(item, cornerX+10, cornerY+15+15+90+45);
                        ms.renderItem(item17, cornerX+65, cornerY+15+15+90+45);
                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30, cornerY+115+45, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35,cornerY+15+15+90+45, 0x971F11);
                        ms.pose().popPose();

                        String text26 = I18n.get("entity.re8joymod.krauser");

                        ms.pose().pushPose();
                        ms.drawString(font,text26,cornerX+20+110,cornerY+15, 0x000000);
                        ItemStack item18 = new ItemStack(BlockInit.FACTW_BLOCK.get());

                        ms.renderItem(item, cornerX+10+110, cornerY+15+15);
                        ms.renderItem(item18, cornerX+65+110, cornerY+15+15);
                        ms.pose().popPose();
                        drawImage(ms, BREAK, cornerX+30+100, cornerY+115-90, 0, 0, 32, 32, 512F);
                        ms.pose().pushPose();
                        ms.drawString(font,breakBlock,cornerX+35+110,cornerY+15+15, 0x971F11);
                        ms.pose().popPose();
//                        ms.pose().pushPose();
//                        ItemStack item12 = new ItemStack(ItemInit.HUMUS.get());
//                        ItemStack item13 = new ItemStack(BlockInit.DHANDS_BLOCK.get());
//                        ItemStack item14 = new ItemStack(ItemInit.HUMUS_INGOT.get());
//                        ms.renderItem(item12, cornerX+20+120, cornerY+30+60+30);
//                        ms.renderItem(item13, cornerX+20+120, cornerY+30+30+60+35);
//                        ms.renderItem(item14, cornerX+80+120, cornerY+17+30+60+30);
//                        ms.pose().popPose();
//                        drawImage(ms, RECIPEV, cornerX+130, cornerY+115, 0, 0, 99, 59, 512F);

                    }
                case 9:
                    if (bookPages == 9) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        //drawImage(ms, MIRANDA, cornerX, cornerY, 0, 0, 106, 128, 512F);

                        ms.pose().pushPose();

                        String text1 = I18n.get("book.virusgenerator");
                        String text2 = I18n.get("book.virusgeneratorintro");
                        String text3 = I18n.get("book.virusgeneratorfuel");

                        String text4 = I18n.get("book.fuel1");
                        String text5 = I18n.get("item.re8joymod.blacksheep");
                        String text6 = I18n.get("item.re8joymod.desolate_grass");

                        ms.drawString(font,text1,cornerX+20,cornerY-30, 0x000000);
                        ms.drawString(font,text2,cornerX,cornerY-20, 0x000000);

                        ItemStack item = new ItemStack(BlockInit.VIRUS_GENERATOR_BLOCK.get());
                        ItemStack item2 = new ItemStack(ItemInit.MACHINEHEARTB.get());
                        ItemStack item3 = new ItemStack(BlockInit.FACT_IRON_BLOCK.get());
                        ItemStack item4 = new ItemStack(BlockInit.FANTOM_BLOCK.get());
                        ItemStack item5 = new ItemStack(Items.FERMENTED_SPIDER_EYE);
                        ItemStack item6 = new ItemStack(ItemInit.BLACKSHEEP.get());
                        ItemStack item7 = new ItemStack(ItemInit.DESOLATE_GRASS_BLOCK.get());

                        ms.renderItem(item2, cornerX+12, cornerY-5);
                        ms.renderItem(item2, cornerX+31, cornerY-5);
                        ms.renderItem(item2, cornerX+50, cornerY-5);

                        ms.renderItem(item3, cornerX+12, cornerY+15);
                        ms.renderItem(item4, cornerX+31, cornerY+15);
                        ms.renderItem(item3, cornerX+50, cornerY+15);

                        ms.renderItem(item3, cornerX+12, cornerY+35);
                        ms.renderItem(item3, cornerX+31, cornerY+35);
                        ms.renderItem(item3, cornerX+50, cornerY+35);

                        ms.renderItem(item, cornerX+87, cornerY+15);

                        ms.drawString(font,"1: "+text4,cornerX,cornerY+100, 0x000000);
                        ms.drawString(font,"2: "+text5,cornerX,cornerY+110, 0x000000);
                        ms.drawString(font,"3: "+text6,cornerX,cornerY+120, 0x000000);

                        ms.renderItem(item5, cornerX+24, cornerY+135);
                        ms.renderItem(item6, cornerX+48, cornerY+135);
                        ms.renderItem(item7, cornerX+72, cornerY+135);

                        ms.pose().popPose();
                        drawImage(ms, RECIPE9, cornerX+10, cornerY-5, 0, 0, 99, 59, 512F);

                        ms.pose().pushPose();
                        ms.pose().scale(2F,2F,2F);
                        ms.drawString(font,text3,cornerX-35,cornerY+15, 0x000000);
                        ms.pose().popPose();
                        ms.pose().pushPose();
                        ItemStack item12 = new ItemStack(ItemInit.HUMUS.get());
                        ItemStack item13 = new ItemStack(BlockInit.DHANDS_BLOCK.get());
                        ItemStack item14 = new ItemStack(ItemInit.HUMUS_INGOT.get());
                        ms.renderItem(item12, cornerX+20+120, cornerY+30+60+30);
                        ms.renderItem(item13, cornerX+20+120, cornerY+30+30+60+35);
                        ms.renderItem(item14, cornerX+80+120, cornerY+17+30+60+30);
                        ms.pose().popPose();
                        drawImage(ms, RECIPEV, cornerX+130, cornerY+115, 0, 0, 99, 59, 512F);

                    }
                case 10:
                    if (bookPages == 10) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;

                        ms.pose().pushPose();
                        String text1 = I18n.get("book.virusgenerator");
                        ms.drawString(font,text1,cornerX+20,cornerY-30, 0x000000);

                        ItemStack item = new ItemStack(Items.ROTTEN_FLESH);
                        ItemStack item2 = new ItemStack(ItemInit.LYEYE.get());
                        ItemStack item3 = new ItemStack(ItemInit.HUMUS.get());

                        ItemStack item4 = new ItemStack(Items.DANDELION);
                        ItemStack item5 = new ItemStack(ItemInit.DESOLATE_GRASS_BLOCK.get());

                        ItemStack item6 = new ItemStack(BlockInit.MUCUS_BLOCK.get());
                        ItemStack item7 = new ItemStack(BlockInit.DHANDS_BLOCK.get());

                        ItemStack item8 = new ItemStack(Items.SPIDER_EYE);
                        ItemStack item9 = new ItemStack(ItemInit.MOSPITTER.get());

                        ItemStack item10 = new ItemStack(ItemInit.HERBGLASSES.get());
                        ItemStack item11 = new ItemStack(ItemInit.EVIRUS.get());

                        ItemStack item12 = new ItemStack(BlockInit.FANTOM_BLOCK.get());
                        ItemStack item13 = new ItemStack(Blocks.REDSTONE_BLOCK);
                        ItemStack item14 = new ItemStack(BlockInit.EXAMPLE_BLOCK.get());

//                        ItemStack item4 = new ItemStack(BlockInit.FANTOM_BLOCK.get());
//                        ItemStack item5 = new ItemStack(Items.FERMENTED_SPIDER_EYE);
//                        ItemStack item6 = new ItemStack(ItemInit.BLACKSHEEP.get());
//                        ItemStack item7 = new ItemStack(ItemInit.DESOLATE_GRASS_BLOCK.get());

                        ms.renderItem(item, cornerX+20, cornerY-10);
                        ms.renderItem(item2, cornerX+20, cornerY+20);
                        ms.renderItem(item3, cornerX+80, cornerY+7);

                        ms.renderItem(item2, cornerX+20, cornerY+30+25);
                        ms.renderItem(item4, cornerX+20, cornerY+30+30+25);
                        ms.renderItem(item5, cornerX+80, cornerY+17+30+25);

                        ms.renderItem(item6, cornerX+20, cornerY+30+60+30);
                        ms.renderItem(item3, cornerX+20, cornerY+30+30+60+35);
                        ms.renderItem(item7, cornerX+80, cornerY+17+30+60+30);

                        ms.renderItem(item, cornerX+20+120, cornerY-10);
                        ms.renderItem(item8, cornerX+20+120, cornerY+20);
                        ms.renderItem(item9, cornerX+80+120, cornerY+7);

                        ms.renderItem(item3, cornerX+20+120, cornerY+30+25);
                        ms.renderItem(item10, cornerX+20+120, cornerY+30+30+25);
                        ms.renderItem(item11, cornerX+80+120, cornerY+17+30+25);

                        ms.renderItem(item12, cornerX+20+120, cornerY+30+60+30);
                        ms.renderItem(item13, cornerX+20+120, cornerY+30+30+60+35);
                        ms.renderItem(item14, cornerX+80+120, cornerY+17+30+60+30);

                        ms.pose().popPose();
                        drawImage(ms, RECIPEV, cornerX+10, cornerY-15, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+10, cornerY+50, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+10, cornerY+115, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+130, cornerY-15, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+130, cornerY+50, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+130, cornerY+115, 0, 0, 99, 59, 512F);
                    }
                case 11:
                    if (bookPages == 11) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;

                        ms.pose().pushPose();
                        String text1 = I18n.get("book.virusgenerator");
                        ms.drawString(font,text1,cornerX+20,cornerY-30, 0x000000);

                        ItemStack item = new ItemStack(BlockInit.PINK_ROSE.get());
                        ItemStack item2 = new ItemStack(ItemInit.HERBGLASSES.get());
                        ItemStack item3 = new ItemStack(ItemInit.SAMPLE.get());

                        ItemStack item4 = new ItemStack(Items.DIAMOND);
                        ItemStack item5 = new ItemStack(ItemInit.DESOLATE_GRASS_BLOCK.get());
                        ItemStack item6 = new ItemStack(ItemInit.FANTOM_INGOT.get());

                        ItemStack item7 = new ItemStack(ItemInit.HERB2.get());
                        ItemStack item8 = new ItemStack(Items.LEATHER);
                        ItemStack item9 = new ItemStack(ItemInit.SLEATHER.get());

                        ItemStack item10 = new ItemStack(Items.WITHER_ROSE);

                        ItemStack item13 = new ItemStack(Blocks.REDSTONE_BLOCK);
                        ItemStack item14 = new ItemStack(BlockInit.EXAMPLE_BLOCK.get());

//                        ItemStack item4 = new ItemStack(BlockInit.FANTOM_BLOCK.get());
//                        ItemStack item5 = new ItemStack(Items.FERMENTED_SPIDER_EYE);
//                        ItemStack item6 = new ItemStack(ItemInit.BLACKSHEEP.get());
//                        ItemStack item7 = new ItemStack(ItemInit.DESOLATE_GRASS_BLOCK.get());

                        ms.renderItem(item, cornerX+20, cornerY-10);
                        ms.renderItem(item2, cornerX+20, cornerY+20);
                        ms.renderItem(item3, cornerX+80, cornerY+7);

                        ms.renderItem(item4, cornerX+20, cornerY+30+25);
                        ms.renderItem(item5, cornerX+20, cornerY+30+30+25);
                        ms.renderItem(item6, cornerX+80, cornerY+17+30+25);

                        ms.renderItem(item7, cornerX+20, cornerY+30+60+30);
                        ms.renderItem(item8, cornerX+20, cornerY+30+30+60+35);
                        ms.renderItem(item9, cornerX+80, cornerY+17+30+60+30);

                        ms.renderItem(item10, cornerX+20+120, cornerY-10);
                        ms.renderItem(item5, cornerX+20+120, cornerY+20);
                        ms.renderItem(item, cornerX+80+120, cornerY+7);

//                        ms.renderItem(item3, cornerX+20+120, cornerY+30+25);
//                        ms.renderItem(item10, cornerX+20+120, cornerY+30+30+25);
//                        ms.renderItem(item11, cornerX+80+120, cornerY+17+30+25);
//
//                        ms.renderItem(item12, cornerX+20+120, cornerY+30+60+30);
//                        ms.renderItem(item13, cornerX+20+120, cornerY+30+30+60+35);
//                        ms.renderItem(item14, cornerX+80+120, cornerY+17+30+60+30);

                        ms.pose().popPose();
                        drawImage(ms, RECIPEV, cornerX+10, cornerY-15, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+10, cornerY+50, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+10, cornerY+115, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+130, cornerY-15, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+130, cornerY+50, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPEV, cornerX+130, cornerY+115, 0, 0, 99, 59, 512F);
                    }
                case 12:
                    if (bookPages == 12) {

                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        String text1 = I18n.get("book.armybuild");
                        String text2 = I18n.get("book.duketrade");
                        String text3 = I18n.get("book.duketradewarn");

                        ms.pose().pushPose();
                        ms.drawString(font,text1,cornerX+20,cornerY-30, 0x000000);
                        ms.drawString(font,text2,cornerX+130,cornerY-30, 0x000000);
                        ms.drawString(font,text3,cornerX+120,cornerY+110, 0x000000);

                        ItemStack item = new ItemStack(ItemInit.RUSTPART.get());
                        ItemStack item2 = new ItemStack(BlockInit.CMH.get());
                        ItemStack item3 = new ItemStack(ItemInit.SUMMONFRANK5_SPAWN_EGG.get());

                        ms.renderItem(item, cornerX+31, cornerY-5);
                        ms.renderItem(item2, cornerX+31, cornerY+15);
                        ms.renderItem(item, cornerX+12, cornerY+35);
                        ms.renderItem(item, cornerX+50, cornerY+35);
                        ms.renderItem(item3, cornerX+87, cornerY+15);

                        ItemStack item4 = new ItemStack(Items.REDSTONE);
                        ItemStack item5 = new ItemStack(BlockInit.CRYSTALTORSO.get());
                        ItemStack item6 = new ItemStack(ItemInit.SUMMONDAUGHTER_SPAWN_EGG.get());

                        ms.renderItem(item4, cornerX+31, cornerY-5+90);
                        ms.renderItem(item5, cornerX+31, cornerY+15+90);
                        ms.renderItem(item4, cornerX+12, cornerY+35+90);
                        ms.renderItem(item4, cornerX+50, cornerY+35+90);
                        ms.renderItem(item6, cornerX+87, cornerY+15+90);

                        ItemStack item7 = new ItemStack(BlockInit.EXAMPLE_BLOCK.get());
                        ms.renderItem(item7, cornerX+120, cornerY+15+90+20);

                        ms.pose().popPose();

                        drawImage(ms, RECIPE9, cornerX+10, cornerY-5, 0, 0, 99, 59, 512F);
                        drawImage(ms, RECIPE9, cornerX+10, cornerY+85, 0, 0, 99, 59, 512F);
                        drawImage(ms, DUKE, cornerX+120, cornerY-15, 0, 0, 102, 120, 512F);


                    }
                case 13:
                    if (bookPages == 13) {
                        int cornerX = (this.width - X) / 2 +15;
                        int cornerY = (this.height - Y) / 2+45;
                        String text1 = I18n.get("book.showcase");
                        ms.pose().pushPose();
                        ms.drawString(font,text1,cornerX+20,cornerY-30, 0x000000);
                        ms.drawString(font,"?",cornerX+150,cornerY-30, 0x000000);

//                        ItemStack item = new ItemStack(ItemInit.M1851B.get());
//                        ItemStack item2 = new ItemStack(ItemInit.M1851.get());
//                        ItemStack item3 = new ItemStack(ItemInit.STAKE.get());
//                        ItemStack item4 = new ItemStack(ItemInit.BERETTA92FS.get());
//
//                        ms.renderItem(item, cornerX+12, cornerY-5);
//                        ms.renderItem(item2, cornerX+12, cornerY+15);
//                        ms.renderItem(item3, cornerX+12, cornerY+35);
//                        ms.renderItem(item4, cornerX+12, cornerY+55);
//
//                        ItemStack item5 = new ItemStack(ItemInit.M1897B.get());
//                        ItemStack item6 = new ItemStack(ItemInit.M1897.get());
//                        ItemStack item7 = new ItemStack(ItemInit.W870.get());
//                        ItemStack item8 = new ItemStack(ItemInit.SYG12.get());
//
//                        ms.renderItem(item5, cornerX+12+25, cornerY-5);
//                        ms.renderItem(item6, cornerX+12+25, cornerY+15);
//                        ms.renderItem(item7, cornerX+12+25, cornerY+35);
//                        ms.renderItem(item8, cornerX+12+25, cornerY+55);

//                        ItemStack item9 = new ItemStack(ItemInit.SNIPERAMMO.get());
//                        ItemStack item10 = new ItemStack(ItemInit.F2RIFLE.get());
//                        ItemStack item11 = new ItemStack(ItemInit.SA110.get());

//                        ms.renderItem(item9, cornerX+12+25+25, cornerY-5);
//                        ms.renderItem(item10, cornerX+12+25+25, cornerY+15);
//                        ms.renderItem(item11, cornerX+12+25+25, cornerY+40);

//                        ItemStack item12 = new ItemStack(ItemInit.RIFLEAMMO.get());
//                        ItemStack item13 = new ItemStack(ItemInit.WCX.get());
//                        ItemStack item14 = new ItemStack(ItemInit.DRAGOON.get());

//                        ms.renderItem(item12, cornerX+12, cornerY-5+75);
//                        ms.renderItem(item13, cornerX+12, cornerY+15+75);
//                        ms.renderItem(item14, cornerX+12, cornerY+35+75);

//                        ItemStack item17 = new ItemStack(ItemInit.GM79B.get());
//                        ItemStack item18 = new ItemStack(ItemInit.GM79.get());

//                        ms.renderItem(item17, cornerX+12+25, cornerY-5+75);
//                        ms.renderItem(item18, cornerX+12+25, cornerY+15+75);

                        ItemStack item15 = new ItemStack(ItemInit.BOWSHOOT.get());
                        ItemStack item16 = new ItemStack(ItemInit.CROSSBOW1.get());
                        ms.renderItem(item15, cornerX+125, cornerY+15+75);
                        ms.renderItem(item16, cornerX+125, cornerY+35+75);

                        ms.pose().popPose();
                        drawImage(ms, ADA, cornerX+135, cornerY-15, 0, 0, 56, 100, 512F);

                    }
                case 14:
                    if (bookPages == 14) {
                        int cornerX = (this.width - X) / 2;
                        int cornerY = (this.height - Y) / 2;
                        drawImage(ms, END, cornerX, cornerY, 0, 0, 255, 255, 512F);

                    }
                default:
                    break;
	        }
	    }
	    
	    public void drawImage(GuiGraphics ms, ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
	        ms.pose().pushPose();
		    RenderSystem.setShader(GameRenderer::getPositionTexShader);
		    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		    RenderSystem.setShaderTexture(0, texture);
	        this.getMinecraft().getTextureManager().bindForSetup(texture);
	        ms.pose().scale(scale / 512F, scale / 512F, scale / 512F);
            ms.blit(texture, x, y, u, v, width, height, width, height);
	        ms.pose().popPose();
	    }
	    
	    @Override
	    public void tick()
	    {
	        super.tick();

	    }
	    
	    @Override
	    public boolean isPauseScreen()
	    {
	        return true;
	    }
}
