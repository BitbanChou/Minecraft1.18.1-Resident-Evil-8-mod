//package com.joy187.re8joymod.common.mixin;
//
//
//
//import java.util.List;
//import java.util.Set;
//
//public class FMMixinPlugin implements IMixinConfigPlugin {
//
//    //private static final Logger LOGGER = LogManager.getLogger("fancymenu/FMMixinPlugin");
//
////    @Override
////    public void onLoad(String mixinPackage) {
////    }
////
////    @Override
////    public String getRefMapperConfig() {
////        return null;
////    }
////
////    @Override
////    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
////        if (isKonkreteLoaded()) {
//////            LOGGER.info("[FANCYMENU] APPLYING MIXIN: " + mixinClassName + " | TO TARGET: " + targetClassName);
////            return true;
////        }
////        return false;
////    }
////
////    @Override
////    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
////    }
////
////    @Override
////    public List<String> getMixins() {
////        return null;
////    }
////
////    @Override
////    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
////    }
////
////    @Override
////    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
////    }
////
////    private static boolean isKonkreteLoaded() {
////        try {
////            Class.forName("de.keksuccino.konkrete.Konkrete");
////            return true;
////        } catch (Exception e) {}
////        return false;
////    }
////    private boolean isFrameworkInstalled;
////    @Override
////    public void onLoad(String mixinPackage) {
////        try {
////            Class.forName("com.joy187.re8joymod.Main", false, this.getClass().getClassLoader());
////            isFrameworkInstalled = true;
////        } catch (Exception e) {
////            isFrameworkInstalled = false;
////        }
////    }
//
//    @Override
//    public String getRefMapperConfig() {
//        return null;
//    }
//
//    @Override
//    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
//        return isFrameworkInstalled; // this makes sure that forge's helpful mods not found screen shows up
//    }
//
//    @Override
//    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
//
//    }
//
//    @Override
//    public List<String> getMixins() {
//        return null;
//    }
//
//    @Override
//    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
//
//    }
//
//    @Override
//    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
//
//    }
//}