//package com.joy187.re8joymod.common.items.itemBook;
//
//
//import com.google.gson.JsonDeserializationContext;
//import com.google.gson.JsonObject;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.datafixers.util.Pair;
//import net.minecraft.block.BlockState;
//import net.minecraft.client.renderer.model.*;
//import net.minecraft.client.renderer.texture.TextureAtlasSprite;
//import net.minecraft.resources.IResourceManager;
//import net.minecraft.util.Direction;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.model.IModelConfiguration;
//import net.minecraftforge.client.model.IModelLoader;
//import net.minecraftforge.client.model.geometry.IModelGeometry;
//
//import javax.annotation.Nullable;
//import java.util.*;
//import java.util.function.Function;
//
//public class SpecialBakedModel implements IBakedModel
//{
//    private final boolean isSideLit;
//    private final ItemCameraTransforms cameraTransforms;
//    private final TextureAtlasSprite particle;
//    private final ItemOverrideList overrideList;
//
//    public SpecialBakedModel(ModelBakery bakery, IUnbakedModel unbakedModel, Function<ResourceLocation, IUnbakedModel> modelGetter,
//                             Function<RenderMaterial, TextureAtlasSprite> spriteGetter, boolean isSideLit, ItemCameraTransforms cameraTransforms,
//                             @Nullable TextureAtlasSprite particle)
//    {
//        this.particle = particle;
//        this.isSideLit = isSideLit;
//        this.cameraTransforms = cameraTransforms;
//        this.overrideList = new ItemOverrideList(bakery, unbakedModel, modelGetter, spriteGetter, Collections.emptyList());
//    }
//
//    @Override
//    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand)
//    {
//        return Collections.emptyList();
//    }
//
//    @Override
//    public boolean useAmbientOcclusion()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isGui3d()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean usesBlockLight()
//    {
//        return isSideLit;
//    }
//
//    @Override
//    public boolean isCustomRenderer()
//    {
//        return true;
//    }
//
//    @Override
//    public TextureAtlasSprite getParticleIcon()
//    {
//        return particle;
//    }
//
//    @Deprecated
//    @Override
//    public ItemCameraTransforms getTransforms()
//    {
//        return cameraTransforms;
//    }
//
//    @Override
//    public ItemOverrideList getOverrides()
//    {
//        return overrideList;
//    }
//
//    public static ItemCameraTransforms.TransformType cameraTransformType;
//
//    @Override
//    public IBakedModel handlePerspective(ItemCameraTransforms.TransformType cameraTransformType, MatrixStack mat)
//    {
//        SpecialBakedModel.cameraTransformType = cameraTransformType;
//        return this;
//    }
//
//    public static class Model implements IModelGeometry<Model>
//    {
//        @Override
//        public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation)
//        {
//            RenderMaterial particleLocation = owner.resolveTexture("particle");
//            TextureAtlasSprite part = spriteGetter.apply(particleLocation);
//
//            return new SpecialBakedModel(
//                    bakery, owner.getOwnerModel(), bakery::getModel, spriteGetter, owner.isSideLit(), owner.getCameraTransforms(), part);
//        }
//
//        @Override
//        public Collection<RenderMaterial> getTextures(IModelConfiguration owner, Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors)
//        {
//            return Collections.emptyList();
//        }
//    }
//
//    public static class ModelLoader implements IModelLoader<Model>
//    {
//        @Override
//        public void onResourceManagerReload(IResourceManager resourceManager)
//        {
//            BookRegistry.parseAllBooks(resourceManager);
//        }
//
//        @Override
//        public Model read(JsonDeserializationContext deserializationContext, JsonObject modelContents)
//        {
//            return new Model();
//        }
//    }
//}
