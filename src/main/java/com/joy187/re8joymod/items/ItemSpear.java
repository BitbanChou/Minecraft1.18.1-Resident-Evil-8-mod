package com.joy187.re8joymod.items;

import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.joy187.re8joymod.Main;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeMod;

public class ItemSpear extends SwordItem
{
	
    //private static final UUID ATTACK_REACH_MODIFIER = UUID.fromString("6C05J864-4748-24CE-90D6-0242AC170006");
    private Multimap<Attribute, AttributeModifier> defaultModifiers;

	public ItemSpear(Tier tier, int dmg, float speed, Properties properties){
        super(tier, dmg, speed, properties);
    }
    
    public ItemSpear(Tier tier) {
        super(tier,3,-2.8f,new Properties());
//        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
//        if (ForgeMod.REACH_DISTANCE.isPresent()) {
//            builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(ATTACK_REACH_MODIFIER, "Weapon modifier", this.getReach(), AttributeModifier.Operation.ADDITION));
//        }
//        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 1, AttributeModifier.Operation.ADDITION));
//        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.8f ,AttributeModifier.Operation.ADDITION));
//        this.defaultModifiers = builder.build();
    }
    
//    @Override
//    public float getReach()
//    {
//        return 20.0F;
//    }
    
    public ItemSpear CreateNewItemSpear(Tiers t) {

        Properties p = new Properties();
        ItemSpear item = null;
        switch(t)
        {
            case WOOD:
                item = new ItemSpear(t, 4, -2.4f, p);
                break;
            case STONE:
                item = new ItemSpear(t, 4, -2.5f, p);
                break;
//            case COPPER: // copper isn't a tier in vanilla (make my own tier?)
//                item = new SwordItem(t, DamageCopper, SpeedCopper, p);
//                break;
            case IRON:
                item = new ItemSpear(t, 5, -2.7f, p);
                break;
            case DIAMOND:
                item = new ItemSpear(t, 6, -2.9f, p);
                break;
            case GOLD:
                item = new ItemSpear(t, 5, -2.8f, p);
                break;
            case NETHERITE:
                item = new ItemSpear(t, 7, -3.0f, p);
                break;
            default:
                throw new IllegalStateException("Unexpected spear tier: " + t);
        }
        
        return item;
    }


}