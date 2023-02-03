package com.joy187.re8joymod.common.particles;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class ParticleBase  {
//    protected ParticleBase(ClientWorld p_i232411_1_, double p_i232411_2_, double p_i232411_4_, double p_i232411_6_) {
//        super(p_i232411_1_, p_i232411_2_, p_i232411_4_, p_i232411_6_);
//    }

//    TextureManager manager = Minecraft.getInstance().getTextureManager();
//    ResourceLocation location;
//    final float sizeHalf = 0.125F;
//
//    public ParticleBase(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
//        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
//
//        //Barrier:
//        //this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(itemIn));
//
//        //Breaking:
//        //this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(itemIn, meta));
//
//        //Digging:
//        //this.setParticleTexture(Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getTexture(state));
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public static class Factory implements IParticleFactory {
//        public Particle createParticle(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
//            return new ParticleBase(worldIn, xCoordIn, yCoordIn, zCoordIn, (float) xSpeedIn, (float) ySpeedIn, (float) zSpeedIn);
//        }
//    }
//
//
//    private static final VertexFormat VERTEX_FORMAT =
//            (new VertexFormat())
//                    .addElement(DefaultVertexFormats.POSITION_3F)
//                    .addElement(DefaultVertexFormats.TEX_2F)
//                    .addElement(DefaultVertexFormats.COLOR_4UB)
//                    .addElement(DefaultVertexFormats.TEX_2S)
//                    .addElement(DefaultVertexFormats.NORMAL_3B)
//                    .addElement(DefaultVertexFormats.PADDING_1B);
//
//
//    //to see relative particles, see ParticleBreaking; for global ones, see ParticleExplosionLarge
//    public void renderParticleBreaking(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
//        //Jitter is randFloat()*3
//        float f = ((float) this.particleTextureIndexX + this.particleTextureJitterX / 4.0F) / 16.0F;
//        float f1 = f + 0.015609375F;
//        float f2 = ((float) this.particleTextureIndexY + this.particleTextureJitterY / 4.0F) / 16.0F;
//        float f3 = f2 + 0.015609375F;
//        float f4 = 0.1F * this.particleScale;
//
//        if (this.particleTexture != null) {
//            //converts to 0~1
//            f = this.particleTexture.getInterpolatedU((double) (this.particleTextureJitterX / 4.0F * 16.0F));
//            f1 = this.particleTexture.getInterpolatedU((double) ((this.particleTextureJitterX + 1.0F) / 4.0F * 16.0F));
//            f2 = this.particleTexture.getInterpolatedV((double) (this.particleTextureJitterY / 4.0F * 16.0F));
//            f3 = this.particleTexture.getInterpolatedV((double) ((this.particleTextureJitterY + 1.0F) / 4.0F * 16.0F));
//        }
//
//        //inter pos is of player
//        float f5 = (float) (this.prevPosX + (this.posX - this.prevPosX) * (double) partialTicks - interpPosX);
//        float f6 = (float) (this.prevPosY + (this.posY - this.prevPosY) * (double) partialTicks - interpPosY);
//        float f7 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * (double) partialTicks - interpPosZ);
//        int i = this.getBrightnessForRender(partialTicks);//(0~16)<<4.  0x[Sky,16bit][Block,16bit]
//        int j = i >> 16 & 0xffff;//light map high
//        int k = i & 0xffff;//light map low
//        buffer.pos((double) (f5 - rotationX * f4 - rotationXY * f4), (double) (f6 - rotationZ * f4), (double) (f7 - rotationYZ * f4 - rotationXZ * f4)).tex((double) f, (double) f3).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(j, k).endVertex();
//        buffer.pos((double) (f5 - rotationX * f4 + rotationXY * f4), (double) (f6 + rotationZ * f4), (double) (f7 - rotationYZ * f4 + rotationXZ * f4)).tex((double) f, (double) f2).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(j, k).endVertex();
//        buffer.pos((double) (f5 + rotationX * f4 + rotationXY * f4), (double) (f6 + rotationZ * f4), (double) (f7 + rotationYZ * f4 + rotationXZ * f4)).tex((double) f1, (double) f2).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(j, k).endVertex();
//        buffer.pos((double) (f5 + rotationX * f4 - rotationXY * f4), (double) (f6 - rotationZ * f4), (double) (f7 + rotationYZ * f4 - rotationXZ * f4)).tex((double) f1, (double) f3).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(j, k).endVertex();
//    }
//
//    /**
//     * Renders the particle when you are using Layer 3 (or anything that's not 0&1)
//     */
//    public void renderParticleManual(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
//        float posArg = 0;
//        posArg = posArg * posArg;
//        float fadeFactor = 2.0F - posArg * 2.0F;
//
//        if (fadeFactor > 1.0F) {
//            fadeFactor = 1.0F;
//        }
//
//        fadeFactor = fadeFactor * 0.2F;
//        GlStateManager.disableLighting();
//
//        //offset between posNextLogical and posPartialTick
//        float offX = (float) (this.posX - interpPosX);
//        float offY = (float) (this.posY - interpPosY);
//        float offZ = (float) (this.posZ - interpPosZ);
//
//        float brightness = this.world.getLightBrightness(new BlockPos(this.posX, this.posY, this.posZ));
//
//        manager.bindTexture(location);
//
//        GlStateManager.enableBlend();
//        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
//        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
//
//        buffer.pos((double) (offX - sizeHalf), (double) offY, (double) (offZ + sizeHalf)).tex(0.0D, 1.0D).color(brightness, brightness, brightness, fadeFactor).endVertex();
//        buffer.pos((double) (offX + sizeHalf), (double) offY, (double) (offZ + sizeHalf)).tex(1.0D, 1.0D).color(brightness, brightness, brightness, fadeFactor).endVertex();
//        buffer.pos((double) (offX + sizeHalf), (double) offY, (double) (offZ - sizeHalf)).tex(1.0D, 0.0D).color(brightness, brightness, brightness, fadeFactor).endVertex();
//        buffer.pos((double) (offX - sizeHalf), (double) offY, (double) (offZ - sizeHalf)).tex(0.0D, 0.0D).color(brightness, brightness, brightness, fadeFactor).endVertex();
//        Tessellator.getInstance().draw();
//        GlStateManager.disableBlend();
//        GlStateManager.enableLighting();
//    }
//
//    /**
//     * Retrieve what effect layer (what texture) the particle should be rendered with. 0 for the particle sprite sheet,
//     * 1 for the main Texture atlas, and 3 for a custom texture
//     * 3 : explosionLarge(&Huge), footsteps, ItemPickup, MobAppearance(Guardian), SweepAttack,
//     * 1 : Barrier, Digging, Breaking
//     */
//    public int getFXLayer() {
//        return 1;
//    }

}