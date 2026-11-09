package com.joy187.re8joymod.init;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.*;
import com.joy187.re8joymod.entity.EntitySamca;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            Main.MOD_ID);
    public static final RegistryObject<EntityType<EntityChaosFireball>> CHAOS_FIREBALL = ENTITY_TYPES.register("chaos_fireball",
            () -> EntityType.Builder.<EntityChaosFireball>of(EntityChaosFireball::new, MobCategory.MISC)
                    .sized(1.0F, 1.0F).setTrackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(Main.MOD_ID, "chaos_fireball").toString()));

//    public static final RegistryObject<EntityType<EntitySamca>> SAMCA = ENTITY_TYPES.register("samca",
//            () -> EntityType.Builder.of(EntitySamca::new, MobCategory.MONSTER).sized(1f,1.8f).setTrackingRange(20)
//                    .build(new ResourceLocation(Main.MOD_ID, "samca").toString()));
    public static final RegistryObject<EntityType<EntityFly>> FLY = ENTITY_TYPES.register("fly",
        () -> EntityType.Builder.of(EntityFly::new, MobCategory.MONSTER).sized(1f,1f).setTrackingRange(40)
                .build(new ResourceLocation(Main.MOD_ID, "fly").toString()));

    public static final RegistryObject<EntityType<EntityRe8Dimi>> RE8DIMI = ENTITY_TYPES.register("re8dimi",
            () -> EntityType.Builder.of(EntityRe8Dimi::new, MobCategory.MONSTER).sized(0.8f,3.0f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "re8dimi").toString()));

    public static final RegistryObject<EntityType<EntityDimi2>> DIMI2 = ENTITY_TYPES.register("dimi2",
            () -> EntityType.Builder.of(EntityDimi2::new, MobCategory.MONSTER).sized(5f,7.0f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "dimi2").toString()));

    public static final RegistryObject<EntityType<EntityEthan>> ETHAN = ENTITY_TYPES.register("ethan",
            () -> EntityType.Builder.of(EntityEthan::new, MobCategory.CREATURE).sized(1f,2.0f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "ethan").toString()));

    public static final RegistryObject<EntityType<EntityDund>> DUND1 = ENTITY_TYPES.register("dund",
            () -> EntityType.Builder.of(EntityDund::new, MobCategory.MONSTER).sized(1f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "dund").toString()));

    public static final RegistryObject<EntityType<EntityDund2>> DUND2 = ENTITY_TYPES.register("dund2",
            () -> EntityType.Builder.of(EntityDund2::new, MobCategory.MONSTER).sized(0.8f,1.8f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "dund2").toString()));

    public static final RegistryObject<EntityType<EntitySamca>> SAMCA = ENTITY_TYPES.register("samca",
            () -> EntityType.Builder.of(EntitySamca::new, MobCategory.MONSTER).sized(1f,1.8f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "samca").toString()));

    public static final RegistryObject<EntityType<EntityBela>> BELA = ENTITY_TYPES.register("bela",
            () -> EntityType.Builder.of(EntityBela::new, MobCategory.MONSTER).sized(1f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "bela").toString()));

    public static final RegistryObject<EntityType<EntityCassandra>> CASSANDRA = ENTITY_TYPES.register("cassandra",
            () -> EntityType.Builder.of(EntityCassandra::new, MobCategory.MONSTER).sized(1f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "cassandra").toString()));

    public static final RegistryObject<EntityType<EntityDaniela>> DANIELA = ENTITY_TYPES.register("daniela",
            () -> EntityType.Builder.of(EntityDaniela::new, MobCategory.MONSTER).sized(1f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "daniela").toString()));


    public static final RegistryObject<EntityType<EntityBei>> BEI = ENTITY_TYPES.register("bei",
            () -> EntityType.Builder.of(EntityBei::new, MobCategory.MONSTER).sized(1.1f,2.4f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "bei").toString()));

    public static final RegistryObject<EntityType<EntityAngie>> ANGIE = ENTITY_TYPES.register("angie",
            () -> EntityType.Builder.of(EntityAngie::new, MobCategory.MONSTER).sized(1.1f,1.3f).setTrackingRange(50)
                    .build(new ResourceLocation(Main.MOD_ID, "angie").toString()));

    public static final RegistryObject<EntityType<EntityDoll1>> DOLL1 = ENTITY_TYPES.register("doll1",
            () -> EntityType.Builder.of(EntityDoll1::new, MobCategory.MONSTER).sized(1.1f,1.0f).setTrackingRange(50)
                    .build(new ResourceLocation(Main.MOD_ID, "doll1").toString()));

    public static final RegistryObject<EntityType<EntityDoll2>> DOLL2 = ENTITY_TYPES.register("doll2",
            () -> EntityType.Builder.of(EntityDoll2::new, MobCategory.MONSTER).sized(1.0f,1.0f).setTrackingRange(50)
                    .build(new ResourceLocation(Main.MOD_ID, "doll2").toString()));

    public static final RegistryObject<EntityType<EntityDoll3>> DOLL3 = ENTITY_TYPES.register("doll3",
            () -> EntityType.Builder.of(EntityDoll3::new, MobCategory.MONSTER).sized(1.0f,1.0f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "doll3").toString()));

    public static final RegistryObject<EntityType<EntityBeibaby>> BEIBABY = ENTITY_TYPES.register("beibaby",
            () -> EntityType.Builder.of(EntityBeibaby::new, MobCategory.MONSTER).sized(1.2f,2.55f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "beibaby").toString()));

    public static final RegistryObject<EntityType<EntityFrank1>> FRANK1 = ENTITY_TYPES.register("frank1",
            () -> EntityType.Builder.of(EntityFrank1::new, MobCategory.MONSTER).sized(0.6f,2.1f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "frank1").toString()));

    public static final RegistryObject<EntityType<EntityFrank2>> FRANK2 = ENTITY_TYPES.register("frank2",
            () -> EntityType.Builder.of(EntityFrank2::new, MobCategory.MONSTER).sized(0.8f,2.4f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "frank2").toString()));

    public static final RegistryObject<EntityType<EntityFrank3>> FRANK3 = ENTITY_TYPES.register("frank3",
            () -> EntityType.Builder.of(EntityFrank3::new, MobCategory.MONSTER).sized(0.8f,2.4f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "frank3").toString()));

    public static final RegistryObject<EntityType<EntityFrank4>> FRANK4 = ENTITY_TYPES.register("frank4",
            () -> EntityType.Builder.of(EntityFrank4::new, MobCategory.MONSTER).sized(0.8f,2.4f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "frank4").toString()));

    public static final RegistryObject<EntityType<EntityLycana>> LYCANA = ENTITY_TYPES.register("lycana",
            () -> EntityType.Builder.of(EntityLycana::new, MobCategory.MONSTER).sized(0.8f,2.0f).setTrackingRange(45)
                    .build(new ResourceLocation(Main.MOD_ID, "lycana").toString()));


//    public static RegistryObject<EntityType<GrapplehookEntity>> GRAPELGUNENTITY = ENTITY_TYPES.register("grapnelgun",
//            ()->EntityType.Builder.<GrapplehookEntity>of(GrapplehookEntity::new, MobCategory.MISC).sized(0.25F, 0.25F)
//            .build("grapnelgun"));

//    public static final RegistryObject<EntityType<EntityObBoat>> OBBOAT = ENTITY_TYPES.register("obboat",
//            () -> EntityType.Builder.<EntityObBoat>of(EntityObBoat::new, MobCategory.MISC).sized(2f,0.8f).setTrackingRange(30)
//                    .build(new ResourceLocation(Main.MOD_ID, "obboat").toString()));



    public static final RegistryObject<EntityType<EntityFrank5>> FRANK5 = ENTITY_TYPES.register("frank5",
            () -> EntityType.Builder.of(EntityFrank5::new, MobCategory.MONSTER).sized(1.2f,2.7f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "frank5").toString()));

    public static final RegistryObject<EntityType<EntityFrank6>> FRANK6 = ENTITY_TYPES.register("frank6",
            () -> EntityType.Builder.of(EntityFrank6::new, MobCategory.MONSTER).sized(1.2f,2.65f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "frank6").toString()));

    public static final RegistryObject<EntityType<EntityMycete>> MYCETE = ENTITY_TYPES.register("mycete",
            () -> EntityType.Builder.of(EntityMycete::new, MobCategory.MONSTER).sized(0.7f,0.6f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "mycete").toString()));

    public static final RegistryObject<EntityType<EntityMMycete>> MMYCETE = ENTITY_TYPES.register("mmycete",
            () -> EntityType.Builder.of(EntityMMycete::new, MobCategory.MONSTER).sized(2.6f,8.6f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "mmycete").toString()));

    public static final RegistryObject<EntityType<DetonatorEntity>> DETONATOR_ENTITY = ENTITY_TYPES.register("detonator",
            () -> EntityType.Builder.<DetonatorEntity>of(DetonatorEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("detonator"));

    public static final RegistryObject<EntityType<EntityLycan>> LYCAN = ENTITY_TYPES.register("lycan",
            () -> EntityType.Builder.of(EntityLycan::new, MobCategory.MONSTER).sized(1f,2f).setTrackingRange(45)
                    .build(new ResourceLocation(Main.MOD_ID, "lycan").toString()));

    public static final RegistryObject<EntityType<EntityLycan1>> LYCAN1 = ENTITY_TYPES.register("lycan1",
            () -> EntityType.Builder.of(EntityLycan1::new, MobCategory.MONSTER).sized(1f,2.5f).setTrackingRange(45)
                    .build(new ResourceLocation(Main.MOD_ID, "lycan").toString()));

    public static final RegistryObject<EntityType<EntityVarcolac>> VARCOLAC = ENTITY_TYPES.register("varcolac",
            () -> EntityType.Builder.of(EntityVarcolac::new, MobCategory.MONSTER).sized(1.3f,3.0f).setTrackingRange(45)
                    .build(new ResourceLocation(Main.MOD_ID, "varcolac").toString()));

    public static final RegistryObject<EntityType<EntityMoreau>> MOREAU = ENTITY_TYPES.register("moreau",
            () -> EntityType.Builder.of(EntityMoreau::new, MobCategory.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "moreau").toString()));

    public static final RegistryObject<EntityType<EntityMoreau2>> MOREAU2 = ENTITY_TYPES.register("moreau2",
            () -> EntityType.Builder.of(EntityMoreau2::new, MobCategory.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "moreau2").toString()));

    public static final RegistryObject<EntityType<EntityMoreau3>> MOREAU3 = ENTITY_TYPES.register("moreau3",
            () -> EntityType.Builder.of(EntityMoreau3::new, MobCategory.MONSTER).sized(4f,8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "moreau3").toString()));

    public static final RegistryObject<EntityType<EntityMuHeisen>> MUHEISEN = ENTITY_TYPES.register("muheisen",
            () -> EntityType.Builder.of(EntityMuHeisen::new, MobCategory.MONSTER).sized(5f,6f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "muheisen").toString()));

    public static final RegistryObject<EntityType<EntityHeisen>> HEISEN = ENTITY_TYPES.register("heisen",
            () -> EntityType.Builder.of(EntityHeisen::new, MobCategory.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "heisen").toString()));

    public static final RegistryObject<EntityType<EntityUrias>> URIAS = ENTITY_TYPES.register("urias",
            () -> EntityType.Builder.of(EntityUrias::new, MobCategory.MONSTER).sized(1.5f,3.0f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "urias").toString()));

    public static final RegistryObject<EntityType<EntityUriass>> URIASS = ENTITY_TYPES.register("uriass",
            () -> EntityType.Builder.of(EntityUriass::new, MobCategory.MONSTER).sized(1.6f,3.5f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "uriass").toString()));

    public static final RegistryObject<EntityType<EntityMia>> MIA = ENTITY_TYPES.register("mia",
            () -> EntityType.Builder.of(EntityMia::new, MobCategory.CREATURE).sized(1f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "mia").toString()));

    public static final RegistryObject<EntityType<EntityChris>> CHRIS = ENTITY_TYPES.register("chris",
            () -> EntityType.Builder.of(EntityChris::new, MobCategory.CREATURE).sized(0.9f,2.1f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "chris").toString()));

    public static final RegistryObject<EntityType<EntityAxeman>> AXEMAN = ENTITY_TYPES.register("axeman",
            () -> EntityType.Builder.of(EntityAxeman::new, MobCategory.MONSTER).sized(1.5f,3.0f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "axeman").toString()));
    //    public static final RegistryObject<EntityType<EntityMoreau4>> MOREAU4 = ENTITY_TYPES.register("moreau4",
//            () -> EntityType.Builder.of(EntityMoreau4::new, EntityClassification.MONSTER).sized(4.3f,4.5f).setTrackingRange(35)
//                    .build(new ResourceLocation(Utils.MOD_ID, "moreau4").toString()));
    public static final RegistryObject<EntityType<EntityMoreauProjectile>> MOPROJECTILE = ENTITY_TYPES.register("mopro",
            () -> EntityType.Builder.<EntityMoreauProjectile>of(EntityMoreauProjectile::new, MobCategory.MISC).sized(1F,1F)
                    .setTrackingRange(4).updateInterval(10).build("mopro"));

    public static final RegistryObject<EntityType<EntityHeisencar>> HEISENCAR = ENTITY_TYPES.register("heisencar",
            () -> EntityType.Builder.of(EntityHeisencar::new, MobCategory.MISC).sized(2f,0.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "heisencar").toString()));

    public static final RegistryObject<EntityType<EntityDuke>> DUKE = ENTITY_TYPES.register("duke",
            () -> EntityType.Builder.of(EntityDuke::new, MobCategory.MISC).sized(1.2f,3f).setTrackingRange(38)
                    .build(new ResourceLocation(Main.MOD_ID, "duke").toString()));


    public static final RegistryObject<EntityType<EntityTheHag>> THEHAG = ENTITY_TYPES.register("thehag",
            () -> EntityType.Builder.of(EntityTheHag::new, MobCategory.MONSTER).sized(1f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "thehag").toString()));

    public static final RegistryObject<EntityType<EntityMiranda1>> MIRANDA1 = ENTITY_TYPES.register("miranda1",
            () -> EntityType.Builder.of(EntityMiranda1::new, MobCategory.MONSTER).sized(1f,2.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "miranda1").toString()));

    public static final RegistryObject<EntityType<EntityMiranda2>> MIRANDA2 = ENTITY_TYPES.register("miranda2",
            () -> EntityType.Builder.of(EntityMiranda2::new, MobCategory.MONSTER).sized(1.2f,2.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "miranda2").toString()));

    public static final RegistryObject<EntityType<EntityMiranda3>> MIRANDA3 = ENTITY_TYPES.register("miranda3",
            () -> EntityType.Builder.of(EntityMiranda3::new, MobCategory.MONSTER).sized(1.5f,3.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "miranda3").toString()));

    public static final RegistryObject<EntityType<EntityMiranda4>> MIRANDA4 = ENTITY_TYPES.register("miranda4",
            () -> EntityType.Builder.of(EntityMiranda4::new, MobCategory.MONSTER).sized(2.8f,5.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "miranda4").toString()));

    public static final RegistryObject<EntityType<EntityRosemary>> ROSEMARY = ENTITY_TYPES.register("rosemary",
            () -> EntityType.Builder.of(EntityRosemary::new, MobCategory.MONSTER).sized(1.2f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "rosemary").toString()));

    public static final RegistryObject<EntityType<EntityAda>> ADA = ENTITY_TYPES.register("ada",
            () -> EntityType.Builder.of(EntityAda::new, MobCategory.MONSTER).sized(1.2f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "ada").toString()));

    public static final RegistryObject<EntityType<EntityMoreau4>> MOREAU4 = ENTITY_TYPES.register("moreau4",
            () -> EntityType.Builder.of(EntityMoreau4::new, MobCategory.MONSTER).sized(4.3f,4.5f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "moreau4").toString()));

    //    public static final RegistryObject<EntityType<EntityMiranda4>> MIRANDA4 = ENTITY_TYPES.register("miranda4",
//            () -> EntityType.Builder.of(EntityMiranda4::new, EntityClassification.MONSTER).sized(2.8f,5.5f).setTrackingRange(30)
//                    .build(new ResourceLocation(Utils.MOD_ID, "miranda4").toString()));
//    public static final RegistryObject<EntityType<EntityObBoat>> OBBOAT = ENTITY_TYPES.register("obboat",
//    		() -> EntityType.Builder.<EntityObBoat>of(EntityObBoat::new, MobCategory.MISC).sized(1.2F, 1.25F)
//    				.setTrackingRange(4).updateInterval(10).build("obboat"));
//
    public static final RegistryObject<EntityType<EntitySummonSturm>> SUMMONFRANK5 = ENTITY_TYPES.register("summonfrank5",
            () -> EntityType.Builder.of(EntitySummonSturm::new, MobCategory.MONSTER).sized(1.2f,2.7f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "summonfrank5").toString()));

    public static final RegistryObject<EntityType<EntitySummonDaughter>> SUMMONDAUGHTER = ENTITY_TYPES.register("summondaughter",
            () -> EntityType.Builder.of(EntitySummonDaughter::new, MobCategory.MONSTER).sized(0.8f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "summondaughter").toString()));

    public static final RegistryObject<EntityType<EntityMoSpitter>> MOSPITTER = ENTITY_TYPES.register("mospitter",
            () -> EntityType.Builder.<EntityMoSpitter>of(EntityMoSpitter::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("mospitter"));

    public static final RegistryObject<EntityType<EntityM1897B>> M1897B = ENTITY_TYPES.register("m1897b",
            () -> EntityType.Builder.<EntityM1897B>of(EntityM1897B::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("m1897b"));

    public static final RegistryObject<EntityType<EntityM1851B>> M1851B = ENTITY_TYPES.register("m1851b",
            () -> EntityType.Builder.<EntityM1851B>of(EntityM1851B::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("m1851b"));

    public static final RegistryObject<EntityType<EntityGM79B>> GM79B = ENTITY_TYPES.register("gm79b",
            () -> EntityType.Builder.<EntityGM79B>of(EntityGM79B::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("gm79b"));

    public static final RegistryObject<EntityType<EntityPipeb>> PIPEB = ENTITY_TYPES.register("pipeb",
            () -> EntityType.Builder.<EntityPipeb>of(EntityPipeb::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("pipeb"));

    public static final RegistryObject<EntityType<EntityBOWShoot>> BOWSHOOT = ENTITY_TYPES.register("bowa",
            () -> EntityType.Builder.<EntityBOWShoot>of(EntityBOWShoot::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("bowa"));

    public static final RegistryObject<EntityType<EntitySniperAmmo>> SNIPERAMMO = ENTITY_TYPES.register("sniperammo",
            () -> EntityType.Builder.<EntitySniperAmmo>of(EntitySniperAmmo::new, MobCategory.MISC).sized(0.35F, 0.35F)
                    .setTrackingRange(4).updateInterval(10).build("sniperammo"));

    public static final RegistryObject<EntityType<EntityRifleAmmo>> RIFLEAMMO = ENTITY_TYPES.register("rifleammo",
            () -> EntityType.Builder.<EntityRifleAmmo>of(EntityRifleAmmo::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("rifleammo"));

    public static final RegistryObject<EntityType<EntityAda4>> ADA4 = ENTITY_TYPES.register("ada4",
            () -> EntityType.Builder.of(EntityAda4::new, MobCategory.CREATURE).sized(1.2f,1.7f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "ada4").toString()));

    public static final RegistryObject<EntityType<EntityLeon>> LEON = ENTITY_TYPES.register("leon",
            () -> EntityType.Builder.of(EntityLeon::new, MobCategory.CREATURE).sized(1.2f,2f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "leon").toString()));

    public static final RegistryObject<EntityType<EntityChief2>> CHIEF2 = ENTITY_TYPES.register("chief2",
            () -> EntityType.Builder.of(EntityChief2::new, MobCategory.MONSTER).sized(2.5f,4f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "chief2").toString()));

    public static final RegistryObject<EntityType<EntityChief>> CHIEF = ENTITY_TYPES.register("chief",
            () -> EntityType.Builder.of(EntityChief::new, MobCategory.MONSTER).sized(2.5f,4f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "chief").toString()));

    public static final RegistryObject<EntityType<EntityGarrador>> GARRADOR = ENTITY_TYPES.register("garrador",
            () -> EntityType.Builder.of(EntityGarrador::new, MobCategory.MONSTER).sized(2f,3f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "garrador").toString()));

    public static final RegistryObject<EntityType<GrapplehookEntity>> GRAPPLE = ENTITY_TYPES.register("grapple",
            () -> EntityType.Builder.<GrapplehookEntity>of(GrapplehookEntity::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("grapple"));

    public static final RegistryObject<EntityType<EntityMerchant>> MERCHANT = ENTITY_TYPES.register("merchant",
            () -> EntityType.Builder.of(EntityMerchant::new, MobCategory.MISC).sized(1.2f,1.8f).setTrackingRange(38)
                    .build(new ResourceLocation(Main.MOD_ID, "merchant").toString()));

    public static final RegistryObject<EntityType<EntityVillagerGanado>> VILLAGERGANADO = ENTITY_TYPES.register("ganado",
            () -> EntityType.Builder.of(EntityVillagerGanado::new, MobCategory.MONSTER).sized(1f,2f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "ganado").toString()));

    public static final RegistryObject<EntityType<EntityCvg>> CVG = ENTITY_TYPES.register("cvg",
            () -> EntityType.Builder.of(EntityCvg::new, MobCategory.MONSTER).sized(1.2f,2.4f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "cvg").toString()));

    public static final RegistryObject<EntityType<EntityPlagas>> PLAGAS = ENTITY_TYPES.register("plagas",
            () -> EntityType.Builder.of(EntityPlagas::new, MobCategory.MONSTER).sized(0.8f,0.4f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "plagas").toString()));

    public static final RegistryObject<EntityType<EntityU3>> U3 = ENTITY_TYPES.register("u3",
            () -> EntityType.Builder.of(EntityU3::new, MobCategory.MONSTER).sized(2f,3f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "u3").toString()));

    public static final RegistryObject<EntityType<EntityElg>> ELG = ENTITY_TYPES.register("elg",
            () -> EntityType.Builder.of(EntityElg::new, MobCategory.MONSTER).sized(4.8f,8f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "elg").toString()));

    public static final RegistryObject<EntityType<EntityPlagasVillager>> PLAGASVILLAGER = ENTITY_TYPES.register("plagasvillager",
            () -> EntityType.Builder.of(EntityPlagasVillager::new, MobCategory.MONSTER).sized(1f,2f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "plagasvillager").toString()));

    public static final RegistryObject<EntityType<EntityPlagasZombie>> PLAGASZOMBIE = ENTITY_TYPES.register("plagaszombie",
            () -> EntityType.Builder.of(EntityPlagasZombie::new, MobCategory.MONSTER).sized(1f,2f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "plagaszombie").toString()));

    public static final RegistryObject<EntityType<EntityDellago>> DALLAGO = ENTITY_TYPES.register("dallago",
            () -> EntityType.Builder.of(EntityDellago::new, MobCategory.MONSTER).sized(7.5f,3.5f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "dallago").toString()));

    public static final RegistryObject<EntityType<EntityPlagasEnderman>> PLAGASENDERMAN = ENTITY_TYPES.register("plagasenderman",
            () -> EntityType.Builder.of(EntityPlagasEnderman::new, MobCategory.MONSTER).sized(1.4f,4f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "plagasenderman").toString()));

    public static final RegistryObject<EntityType<EntityPlagasCreeper>> PLAGASCREEPER = ENTITY_TYPES.register("plagascreeper",
            () -> EntityType.Builder.of(EntityPlagasCreeper::new, MobCategory.MONSTER).sized(1f,2f).setTrackingRange(25)
                    .build(new ResourceLocation(Main.MOD_ID, "plagascreeper").toString()));

    public static final RegistryObject<EntityType<EntityHighEx>> HIGHEX = ENTITY_TYPES.register("highex",
            () -> EntityType.Builder.<EntityHighEx>of(EntityHighEx::new, MobCategory.MISC).sized(0.3F, 0.3F)
                    .setTrackingRange(4).updateInterval(10).build("highex"));

    public static final RegistryObject<EntityType<EntityVerdugo>> VERDUGO = ENTITY_TYPES.register("verdugo",
            () -> EntityType.Builder.of(EntityVerdugo::new, MobCategory.MONSTER).sized(1F, 2F)
                    .setTrackingRange(40).updateInterval(10).build("verdugo"));

    public static final RegistryObject<EntityType<EntityMannequin>> MANNEQUIN = ENTITY_TYPES.register("mannequin",
            () -> EntityType.Builder.of(EntityMannequin::new, MobCategory.MONSTER).sized(1F, 2F)
                    .setTrackingRange(40).updateInterval(10).build("mannequin"));

    public static final RegistryObject<EntityType<EntityArmadura>> ARMADURA = ENTITY_TYPES.register("armadura",
            () -> EntityType.Builder.of(EntityArmadura::new, MobCategory.MONSTER).sized(0.8F, 2F)
                    .fireImmune().setTrackingRange(40).updateInterval(10).build("armadura"));

    public static final RegistryObject<EntityType<EntityZealot>> ZEALOT = ENTITY_TYPES.register("zealot",
            () -> EntityType.Builder.of(EntityZealot::new, MobCategory.MONSTER).sized(1F, 2F)
                    .setTrackingRange(20).updateInterval(10).build("zealot"));

    public static final RegistryObject<EntityType<EntityHeli>> HELI = ENTITY_TYPES.register("helicopter",
            () -> EntityType.Builder.of(EntityHeli::new, MobCategory.MISC).sized(2.5f,3.5f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "helicopter").toString()));

    public static final RegistryObject<EntityType<EntitySalazar>> SALAZAR = ENTITY_TYPES.register("salazar",
            () -> EntityType.Builder.of(EntitySalazar::new, MobCategory.MONSTER).sized(0.6F, 1.5F)
                    .setTrackingRange(40).updateInterval(10).build("salazar"));

    public static final RegistryObject<EntityType<EntityFallingBlock>> FALLBLOCK = ENTITY_TYPES.register("fallblock",
            () -> EntityType.Builder.<EntityFallingBlock>of(EntityFallingBlock::new, (MobCategory)MobCategory.MISC).sized(0.98f, 0.98f)
                    .setTrackingRange(10).updateInterval(20).build("fallblock"));

    public static final RegistryObject<EntityType<EntityCameraShake>> SCSHAKE = ENTITY_TYPES.register("scshake",
            () -> EntityType.Builder.<EntityCameraShake>of(EntityCameraShake::new, MobCategory.MISC).noSummon().sized(1.0f, 1.0f)
                    .setUpdateInterval(Integer.MAX_VALUE).build("scshake"));

    public static final RegistryObject<EntityType<EntityPlagasArmadura>> PLAGASARMADURA = ENTITY_TYPES.register("plagasarmadura",
            () -> EntityType.Builder.of(EntityPlagasArmadura::new, MobCategory.MONSTER).sized(0.8F, 2F)
                    .fireImmune().setTrackingRange(40).updateInterval(10).build("plagasarmadura"));

    public static final RegistryObject<EntityType<EntityZealota>> ZEALOTA = ENTITY_TYPES.register("zealota",
            () -> EntityType.Builder.of(EntityZealota::new, MobCategory.MONSTER).sized(1F, 2F)
                    .setTrackingRange(20).updateInterval(10).build("zealota"));


    public static final RegistryObject<EntityType<EntityKrauser2>> KRAUSER2 = ENTITY_TYPES.register("krauser2",
            () -> EntityType.Builder.of(EntityKrauser2::new, MobCategory.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "krauser2").toString()));

    public static final RegistryObject<EntityType<EntityKrauser>> KRAUSER = ENTITY_TYPES.register("krauser",
            () -> EntityType.Builder.of(EntityKrauser::new, MobCategory.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "krauser").toString()));

    public static final RegistryObject<EntityType<EntityRegenerator>> REGENERATOR = ENTITY_TYPES.register("regenerator",
            () -> EntityType.Builder.of(EntityRegenerator::new, MobCategory.MONSTER).sized(1f,2.4f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "regenerator").toString()));

    public static final RegistryObject<EntityType<EntityRegenerator2>> REGENERATOR2 = ENTITY_TYPES.register("regenerator2",
            () -> EntityType.Builder.of(EntityRegenerator2::new, MobCategory.MONSTER).sized(1f,2.4f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "regenerator2").toString()));

    public static final RegistryObject<EntityType<EntityHank>> HANK = ENTITY_TYPES.register("hank",
            () -> EntityType.Builder.of(EntityHank::new, MobCategory.CREATURE).sized(1.2f,2f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "hank").toString()));

    public static final RegistryObject<EntityType<EntityPlagasc>> PLAGASC = ENTITY_TYPES.register("plagasc",
            () -> EntityType.Builder.of(EntityPlagasc::new, MobCategory.MONSTER).sized(0.8f,0.4f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "plagasc").toString()));

    public static final RegistryObject<EntityType<EntityEvilDog>> EVILDOG = ENTITY_TYPES.register("evildog",
            () -> EntityType.Builder.of(EntityEvilDog::new, MobCategory.MONSTER).sized(0.7f,0.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "evildog").toString()));

    public static final RegistryObject<EntityType<EntityPlagasDog>> PLAGASDOG = ENTITY_TYPES.register("plagasdog",
            () -> EntityType.Builder.of(EntityPlagasDog::new, MobCategory.MONSTER).sized(0.7f,0.7f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "plagasdog").toString()));

    public static final RegistryObject<EntityType<EntityJJ>> JJ = ENTITY_TYPES.register("jj",
            () -> EntityType.Builder.of(EntityJJ::new, MobCategory.MONSTER).sized(1.5f,3.0f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "jj").toString()));

    public static final RegistryObject<EntityType<EntityChief3>> CHIEF3 = ENTITY_TYPES.register("chief3",
            () -> EntityType.Builder.of(EntityChief3::new, MobCategory.MONSTER).sized(2.5f,4f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "chief3").toString()));

    public static final RegistryObject<EntityType<FireEntity>> FIREENTITY = ENTITY_TYPES.register("fireentity",
            () -> EntityType.Builder.<FireEntity>of(FireEntity::new, MobCategory.MISC).sized(0.7f, 0.7f)
                    .build(new ResourceLocation(Main.MOD_ID, "fireentity").toString()));

    public static final RegistryObject<EntityType<EntitySoldi>> SOLDI = ENTITY_TYPES.register("soldi",
            () -> EntityType.Builder.of(EntitySoldi::new, MobCategory.MONSTER).sized(0.8f,2f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "soldi").toString()));

    public static final RegistryObject<EntityType<EntityFaceEater>> FE = ENTITY_TYPES.register("fe",
            () -> EntityType.Builder.of(EntityFaceEater::new, MobCategory.MONSTER).sized(0.8f,2f).setTrackingRange(40)
                    .build(new ResourceLocation(Main.MOD_ID, "fe").toString()));

    public static final RegistryObject<EntityType<EntityNovi>> NOVI = ENTITY_TYPES.register("novi",
            () -> EntityType.Builder.of(EntityNovi::new, MobCategory.MONSTER).sized(1.4f,2.4f).setTrackingRange(5)
                    .build(new ResourceLocation(Main.MOD_ID, "novi").toString()));

    public static final RegistryObject<EntityType<EntitySaddler>> SADDLER = ENTITY_TYPES.register("saddler",
            () -> EntityType.Builder.of(EntitySaddler::new, MobCategory.MONSTER).sized(1.4f,2.4f).setTrackingRange(5)
                    .build(new ResourceLocation(Main.MOD_ID, "saddler").toString()));

    public static final RegistryObject<EntityType<EntityStuff>> STUFF = ENTITY_TYPES.register("stuff",
            () -> EntityType.Builder.of(EntityStuff::new, MobCategory.MONSTER).sized(1f,2f).setTrackingRange(5)
                    .build(new ResourceLocation(Main.MOD_ID, "stuff").toString()));

    public static final RegistryObject<EntityType<EntityAsh>> ASH = ENTITY_TYPES.register("ash",
            () -> EntityType.Builder.of(EntityAsh::new, MobCategory.CREATURE).sized(1f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "ash").toString()));

    public static final RegistryObject<EntityType<EntityPlagasm>> PLAGASM = ENTITY_TYPES.register("plagasm",
            () -> EntityType.Builder.of(EntityPlagasm::new, MobCategory.MONSTER).sized(1f,2f).setTrackingRange(20)
                    .build(new ResourceLocation(Main.MOD_ID, "plagasm").toString()));

    public static final RegistryObject<EntityType<EntitySalaz>> SALAZ = ENTITY_TYPES.register("salaz",
            () -> EntityType.Builder.of(EntitySalaz::new, MobCategory.MONSTER).sized(5F, 4F)
                    .setTrackingRange(40).updateInterval(10).build("salaz"));

    public static final RegistryObject<EntityType<EntityGE>> GOLDENEGG = ENTITY_TYPES.register("ge",
            () -> EntityType.Builder.<EntityGE>of(EntityGE::new, MobCategory.MISC).sized(0.5F, 0.5F)
                    .setTrackingRange(40).updateInterval(10).build("ge"));

    public static final RegistryObject<EntityType<EntityLuis>> LUIS = ENTITY_TYPES.register("luis",
            () -> EntityType.Builder.of(EntityLuis::new, MobCategory.CREATURE).sized(1.2f,2f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "luis").toString()));

    public static final RegistryObject<EntityType<EntitySaddler2>> SADDLER2 = ENTITY_TYPES.register("saddler2",
            () -> EntityType.Builder.of(EntitySaddler2::new, MobCategory.MONSTER).sized(3f,6f).setTrackingRange(5)
                    .build(new ResourceLocation(Main.MOD_ID, "saddler2").toString()));

    public static final RegistryObject<EntityType<EntityBrute>> BRUTE = ENTITY_TYPES.register("brute",
            () -> EntityType.Builder.of(EntityBrute::new, MobCategory.MONSTER).sized(1.5f,3.0f).setTrackingRange(35)
                    .build(new ResourceLocation(Main.MOD_ID, "brute").toString()));



    public static final RegistryObject<EntityType<Klee>> KLEE = ENTITY_TYPES.register("klee",
            () -> EntityType.Builder.of(Klee::new, MobCategory.MONSTER).sized(1.2f,1.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "klee").toString()));

    public static final RegistryObject<EntityType<Bomb>> BOMB = ENTITY_TYPES.register("bomb",
            () -> EntityType.Builder.of(Bomb::new, MobCategory.MONSTER).sized(0.5f,0.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "bomb").toString()));

    public static final RegistryObject<EntityType<JumpBomb>> JUMPBOMB = ENTITY_TYPES.register("jumpbomb",
            () -> EntityType.Builder.of(JumpBomb::new, MobCategory.MONSTER).sized(0.5f,0.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "jumpbomb").toString()));

    public static final RegistryObject<EntityType<EntityHonghong>> FIRE_ENTITY = ENTITY_TYPES.register("honghong",
            () -> EntityType.Builder.<EntityHonghong>of(EntityHonghong::new, (MobCategory)MobCategory.MISC).sized(0.98f, 0.98f)
                    .setTrackingRange(10).updateInterval(20).build("honghong"));

}
