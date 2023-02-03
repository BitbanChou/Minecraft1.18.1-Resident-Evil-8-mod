package com.joy187.re8joymod.common.items.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

/*
 * Hey so basically this is the simplest possible tutorial for Forge 1.15 custom armor models
 * I will explain this in basic java terms and even english terms making this tutorial virtually stupid proof
 *
 * Okay so this code is just coming from the BlockBench tutorial on custom armor models
 *
 * Here we are literally just copying and pasting the class provided from the BlockBench discord, meaning none of this is original code
 */

// Just import everything and that should be alright

/* This is an abstract class which is usually just a 'shell'
 * We typically ue this in java when we want to use similar methods for multiple classes but don't want to write it out a bunch of times
 * Here's another way to think of this: an abstract class is a skeleton that we can use over and over again. Just because the skeleton is the same, doesn't mean the entire body is the same
 * The body can still be skinny, fat, etc.
 * Of course, there are more in depth reasons for using abstract classes, but for now that's what is important to know
 */

public abstract class ArmorBaseModel extends BipedModel {
    protected final ModelRenderer armorHead;
    protected final ModelRenderer armorBody;
    protected final ModelRenderer armorRightArm;
    protected final ModelRenderer armorLeftArm;
    protected final ModelRenderer armorRightLeg;
    protected final ModelRenderer armorLeftLeg;
    protected final ModelRenderer armorRightBoot;
    protected final ModelRenderer armorLeftBoot;

    private String texture;

    // below is what we call a constructor

    /* When we call this class we do all that junk inside the constructor (by call I mean creating a new instance of the class or extending it)
     *  The parameters inside the constructor (textureWidth, textureHeight, texture) are going to be important when we extend the class
     *  When we extend this class in our MyCustomArmorModel class, we will need to define what our texture width, height, and resourcelocation
     *  We do this with what is called a super constructor: you will see this in our custom model class
     */


    // What does this constructor do?

    /* This is going in-depth and if you read it you will be able to understand java as well as forge a little bit clearer
     * If you go into documentation within the BipedModel.class, you will see that we are basically just creating new instances of the stuff that is necessary
     * More specifically - armorHead, armorBody, armorLeftArm etc
     * Because this is our abstract class and we already defined them, we DO NOT need them in our custom armor model class
     *
     */

    public ArmorBaseModel(int textureWidth, int textureHeight, ResourceLocation texture){
        super(1F);
        this.texWidth = textureWidth;
        this.texHeight = textureHeight;
        this.texture = texture.toString();

        armorHead = new ModelRenderer(this);
        armorHead.setPos(0.0F, 0.0F, 0.0F);
        armorHead.addChild(armorHead);

        armorBody = new ModelRenderer(this);
        armorBody.setPos(0.0F, 0.0F, 0.0F);
        armorBody.addChild(armorBody);
        armorRightArm = new ModelRenderer(this);
        armorRightArm.setPos(0.0F, 0.0F, 0.0F);
        armorRightArm.addChild(armorRightArm);

        armorLeftArm = new ModelRenderer(this);
        armorLeftArm.setPos(0.0F, 0.0F, 0.0F);
        armorLeftArm.addChild(armorLeftArm);

        armorRightLeg = new ModelRenderer(this);
        armorRightLeg.setPos(0.0F, 0.0F, 0.0F);
        armorLeftArm.addChild(armorRightLeg);

        armorLeftLeg = new ModelRenderer(this);
        armorLeftLeg.setPos(0.0F, 0.0F, 0.0F);
        armorLeftArm.addChild(armorLeftLeg);


        armorRightBoot = new ModelRenderer(this);
        armorRightBoot.setPos(0.0F, 0.0F, 0.0F);
        armorLeftArm.addChild(armorRightBoot);

        armorLeftBoot = new ModelRenderer(this);
        armorLeftBoot.setPos(0.0F, 0.0F, 0.0F);
        armorLeftArm.addChild(armorLeftBoot);

        setupArmorParts();
    }
    /* As we can see right above we call the setupArmorParts which is seen below
     * This is where we will be setting up OUR custom armor parts
     * I'll explain more in depth in our other class
     */

    public abstract void setupArmorParts();

    public final String getTexture(){
        return this.texture;
    }

    /* BlockBench says:
     * Feel free to override this method as needed.
     * It's just required to hide armor parts depending on the equipment slot
     */

    // we don't really need to touch this or really any of the methods in below

    public BipedModel applySlot(EquipmentSlotType slot){
        armorHead.visible = false;
        armorBody.visible = false;
        armorRightArm.visible = false;
        armorLeftArm.visible = false;
        armorRightLeg.visible = false;
        armorLeftLeg.visible = false;
        armorRightBoot.visible = false;
        armorLeftBoot.visible = false;

        switch(slot){
            case HEAD:
                armorHead.visible = true;
                break;
            case CHEST:
                armorBody.visible = true;
                armorRightArm.visible = true;
                armorLeftArm.visible = true;
                break;
            case LEGS:
                armorRightLeg.visible = true;
                armorLeftLeg.visible = true;
                break;
            case FEET:
                armorRightBoot.visible = true;
                armorLeftBoot.visible = true;
                break;
            default:
                break;
        }

        return this;
    }

    public final ArmorBaseModel applyEntityStats(BipedModel defaultArmor){
        this.leftArmPose = defaultArmor.leftArmPose;
        this.rightArmPose = defaultArmor.rightArmPose;
        this.crouching = defaultArmor.crouching;
        this.riding=defaultArmor.riding;
        this.young=defaultArmor.young;

        this.head.copyFrom(this.head);
        this.hat.copyFrom(this.hat);
        this.body.copyFrom(this.body);
        this.rightArm.copyFrom(this.rightArm);
        this.leftArm.copyFrom(this.leftArm);
        this.rightLeg.copyFrom(this.rightLeg);
        this.leftLeg.copyFrom(this.leftLeg);

        return this;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        copyModelAngles(this.armorHead, this.armorHead);
        copyModelAngles(this.armorBody, this.armorBody);
        copyModelAngles(this.armorRightArm, this.armorRightArm);
        copyModelAngles(this.armorLeftArm, this.armorLeftArm);
        copyModelAngles(this.armorLeftArm, this.armorRightLeg);
        copyModelAngles(this.armorLeftArm, this.armorLeftLeg);
        copyModelAngles(this.armorLeftArm, this.armorRightBoot);
        copyModelAngles(this.armorLeftArm, this.armorLeftBoot);

        matrixStack.pushPose();

        this.armorHead.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.armorBody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.armorRightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.armorLeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.armorRightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.armorLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.armorRightBoot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.armorLeftBoot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        matrixStack.popPose();
    }

    public final void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    private final void copyModelAngles(ModelRenderer in, ModelRenderer out){
        out.xRot = in.xRot;
        out.yRot = in.yRot;
        out.zRot = in.zRot;
    }
}
