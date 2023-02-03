package com.joy187.re8joymod.common.potions;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;


public class BaseSimplePotion extends Potion {

    private BaseSimplePotion extended = null;
    private BaseSimplePotion empowered = null;
    private boolean registered = false;

    protected BaseSimplePotion(String name, EffectInstance statusEffect) {
        super(name, statusEffect);
    }

    public BaseSimplePotion getExtended() {
        return extended;
    }

    public void setExtended(BaseSimplePotion extended) {
        this.extended = extended;
    }

    public BaseSimplePotion getEmpowered() {
        return empowered;
    }

    public void setEmpowered(BaseSimplePotion empowered) {
        this.empowered = empowered;
    }

    public int registerTree(String namespace, String base) {
        if (registered) return 0;
        Registry.register(Registry.POTION, namespace+":"+base, this);
        registered = true;
        int registeredTotal = 1;
        if (extended != null) {
            registeredTotal += extended.registerTree(namespace, base+"_long");
        }

        if (empowered != null) {
            registeredTotal += empowered.registerTree(namespace, base+"_strong");
        }

        return registeredTotal;
    }

    public static class BaseSimplePotionInstant extends BaseSimplePotion {

        public BaseSimplePotionInstant(String name, Effect statusEffect, int amplifier) {
            super(name, new EffectInstance(statusEffect, 0, amplifier, false, true));
        }

//        @Override
//        public boolean hasInstantEffect() {
//            return true;
//        }

        public static BaseSimplePotionInstant generateAll(String name, Effect statusEffect) {
            BaseSimplePotionInstant base = new BaseSimplePotionInstant(name, statusEffect, 0);
            base.setEmpowered(new BaseSimplePotionInstant(name, statusEffect, 1));
            return base;
        }

    }

    public static class BaseSimplePotionTimed extends BaseSimplePotion {

        protected BaseSimplePotionTimed(String name, Effect statusEffect, int length, int amplifier) {
            super(name, new EffectInstance(statusEffect, length, amplifier, false, true));
        }

//        @Override
//        public boolean hasInstantEffect() {
//            return false;
//        }

        public static BaseSimplePotionTimed generateAll(String name, Effect statusEffect, int lengthNormal, int lengthExtended, int lengthEmpowered) {
            BaseSimplePotionTimed base = new BaseSimplePotionTimed(name, statusEffect, lengthNormal, 0);
            base.setEmpowered(new BaseSimplePotionTimed(name, statusEffect, lengthEmpowered, 1));
            base.setExtended(new BaseSimplePotionTimed(name, statusEffect, lengthExtended, 0));
            return base;
        }

        public static BaseSimplePotionTimed generateWithLengthened(String name, Effect statusEffect, int lengthNormal, int lengthExtended) {
            BaseSimplePotionTimed base = new BaseSimplePotionTimed(name, statusEffect, lengthNormal, 0);
            base.setEmpowered(null);
            base.setExtended(new BaseSimplePotionTimed(name, statusEffect, lengthExtended, 0));
            return base;
        }

    }

}
