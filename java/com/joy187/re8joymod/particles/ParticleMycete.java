package com.joy187.re8joymod.common.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class ParticleMycete extends SpriteTexturedParticle {
    private final IAnimatedSprite sprites;
    float reddustParticleScale;

    public ParticleMycete(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, RedstoneParticleData p_i232378_14_, IAnimatedSprite sprite) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        this.sprites = sprite;
        this.xd *= (double)0.1F;
        this.yd *= (double)0.1F;
        this.zd *= (double)0.1F;
//        float f = (float)Math.random() * 0.4F + 0.6F;
//        this.rCol = ((float)(Math.random() * (double)0.2F) + 0.8F) * p_i232378_14_.getR() * f;
//        this.gCol = ((float)(Math.random() * (double)0.2F) + 0.8F) * p_i232378_14_.getG() * f;
//        this.bCol = ((float)(Math.random() * (double)0.2F) + 0.8F) * p_i232378_14_.getB() * f;


        //this.quadSize *= 0.75F * p_i232378_14_.getScale();
        int i = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.lifetime = (int)Math.max((float)i * p_i232378_14_.getScale(), 1.0F);
        this.setSpriteFromAge(sprite);

        this.quadSize *= 0.75F;
        this.quadSize *= p_i232378_14_.getScale();
        //this.reddustParticleScale = this.sprite;
        //this.set = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
        //this.particleMaxAge = (int) ((float) this.particleMaxAge * p_i232378_14_.getScale(););

        this.rCol = 0.8f;
        changeColor();
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public float getQuadSize(float p_217561_1_) {
        return this.quadSize * MathHelper.clamp(((float)this.age + p_217561_1_) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
            this.move(this.xd, this.yd, this.zd);
            if (this.y == this.yo) {
                this.xd *= 1.1D;
                this.zd *= 1.1D;
            }

            this.xd *= (double)0.96F;
            this.yd *= (double)0.96F;
            this.zd *= (double)0.96F;
            if (this.onGround) {
                this.xd *= (double)0.7F;
                this.zd *= (double)0.7F;
            }

        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<RedstoneParticleData> {
        private final IAnimatedSprite sprites;

        public Factory(IAnimatedSprite p_i50477_1_) {
            this.sprites = p_i50477_1_;
        }

        public Particle createParticle(RedstoneParticleData p_199234_1_, ClientWorld p_199234_2_, double p_199234_3_, double p_199234_5_, double p_199234_7_, double p_199234_9_, double p_199234_11_, double p_199234_13_) {
            return new ParticleMycete(p_199234_2_, p_199234_3_, p_199234_5_, p_199234_7_, p_199234_9_, p_199234_11_, p_199234_13_, p_199234_1_, this.sprites);
        }
    }

    void changeColor() {
        //mycete color
        float ratio = 1 - (float) 0.99 / this.lifetime;
        this.rCol = 1-(float)0.99 / this.lifetime;
        this.gCol = ratio ;
        this.bCol =  ratio / 3f;

        //blue purple
//        float ratio = 1 - (float) this.particleAge / this.particleMaxAge;
//        this.particleAlpha = 1-(float) this.particleAge / this.particleMaxAge;
//        this.particleGreen = 1-ratio ;
//        this.particleBlue =  1-ratio / 3f;
    }
}