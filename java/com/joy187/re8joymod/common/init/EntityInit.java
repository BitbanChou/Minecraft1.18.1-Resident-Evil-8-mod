package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Utils.MOD_ID);

    public static final RegistryObject<EntityType<EntityRe8Dimi>> RE8DIMI = ENTITY_TYPES.register("re8dimi",
            () -> EntityType.Builder.of(EntityRe8Dimi::new, EntityClassification.MONSTER).sized(0.8f,3.0f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "re8dimi").toString()));

    public static final RegistryObject<EntityType<EntityDimi2>> DIMI2 = ENTITY_TYPES.register("dimi2",
            () -> EntityType.Builder.of(EntityDimi2::new, EntityClassification.MONSTER).sized(1.8f,5.0f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "dimi2").toString()));

    public static final RegistryObject<EntityType<EntityBela>> BELA = ENTITY_TYPES.register("bela",
            () -> EntityType.Builder.of(EntityBela::new, EntityClassification.MONSTER).sized(0.8f,1.8f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "bela").toString()));

    public static final RegistryObject<EntityType<EntityCassandra>> CASSANDRA = ENTITY_TYPES.register("cassandra",
            () -> EntityType.Builder.of(EntityCassandra::new, EntityClassification.MONSTER).sized(0.8f,1.8f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "cassandra").toString()));

    public static final RegistryObject<EntityType<EntityDaniela>> DANIELA = ENTITY_TYPES.register("daniela",
            () -> EntityType.Builder.of(EntityDaniela::new, EntityClassification.MONSTER).sized(0.8f,2.0f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "daniela").toString()));

    public static final RegistryObject<EntityType<EntityBei>> BEI = ENTITY_TYPES.register("bei",
            () -> EntityType.Builder.of(EntityBei::new, EntityClassification.MONSTER).sized(1.1f,2.4f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "bei").toString()));

    public static final RegistryObject<EntityType<EntityAngie>> ANGIE = ENTITY_TYPES.register("angie",
            () -> EntityType.Builder.of(EntityAngie::new, EntityClassification.MONSTER).sized(1.1f,1.3f).setTrackingRange(50)
                    .build(new ResourceLocation(Utils.MOD_ID, "angie").toString()));

    public static final RegistryObject<EntityType<EntityDoll1>> DOLL1 = ENTITY_TYPES.register("doll1",
            () -> EntityType.Builder.of(EntityDoll1::new, EntityClassification.MONSTER).sized(1.1f,1.0f).setTrackingRange(50)
                    .build(new ResourceLocation(Utils.MOD_ID, "doll1").toString()));

    public static final RegistryObject<EntityType<EntityDoll2>> DOLL2 = ENTITY_TYPES.register("doll2",
            () -> EntityType.Builder.of(EntityDoll2::new, EntityClassification.MONSTER).sized(1.0f,1.0f).setTrackingRange(50)
                    .build(new ResourceLocation(Utils.MOD_ID, "doll2").toString()));

    public static final RegistryObject<EntityType<EntityDoll3>> DOLL3 = ENTITY_TYPES.register("doll3",
            () -> EntityType.Builder.of(EntityDoll3::new, EntityClassification.MONSTER).sized(1.0f,1.0f).setTrackingRange(25)
                    .build(new ResourceLocation(Utils.MOD_ID, "doll3").toString()));

    public static final RegistryObject<EntityType<EntityBeibaby>> BEIBABY = ENTITY_TYPES.register("beibaby",
            () -> EntityType.Builder.of(EntityBeibaby::new, EntityClassification.MONSTER).sized(1.2f,2.55f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "beibaby").toString()));

    public static final RegistryObject<EntityType<EntityEthan>> ETHAN = ENTITY_TYPES.register("ethan",
            () -> EntityType.Builder.of(EntityEthan::new, EntityClassification.MONSTER).sized(1f,2.0f).setTrackingRange(20)
                    .build(new ResourceLocation(Utils.MOD_ID, "ethan").toString()));

    public static final RegistryObject<EntityType<EntityHeisen>> HEISEN = ENTITY_TYPES.register("heisen",
            () -> EntityType.Builder.of(EntityHeisen::new, EntityClassification.MONSTER).sized(1f,2.2f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "heisen").toString()));

    public static final RegistryObject<EntityType<EntityMuHeisen>> MUHEISEN = ENTITY_TYPES.register("muheisen",
            () -> EntityType.Builder.of(EntityMuHeisen::new, EntityClassification.MONSTER).sized(2.5f,6.2f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "muheisen").toString()));

    public static final RegistryObject<EntityType<EntityMoreau>> MOREAU = ENTITY_TYPES.register("moreau",
            () -> EntityType.Builder.of(EntityMoreau::new, EntityClassification.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "moreau").toString()));

    public static final RegistryObject<EntityType<EntityMoreau2>> MOREAU2 = ENTITY_TYPES.register("moreau2",
            () -> EntityType.Builder.of(EntityMoreau2::new, EntityClassification.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "moreau2").toString()));

    public static final RegistryObject<EntityType<EntityMoreau3>> MOREAU3 = ENTITY_TYPES.register("moreau3",
            () -> EntityType.Builder.of(EntityMoreau3::new, EntityClassification.MONSTER).sized(3.3f,5f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "moreau3").toString()));

    public static final RegistryObject<EntityType<EntityMoreau4>> MOREAU4 = ENTITY_TYPES.register("moreau4",
            () -> EntityType.Builder.of(EntityMoreau4::new, EntityClassification.MONSTER).sized(4.3f,4.5f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "moreau4").toString()));

    public static final RegistryObject<EntityType<EntityFrank1>> FRANK1 = ENTITY_TYPES.register("frank1",
            () -> EntityType.Builder.of(EntityFrank1::new, EntityClassification.MONSTER).sized(0.6f,2.1f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "frank1").toString()));

    public static final RegistryObject<EntityType<EntityFrank2>> FRANK2 = ENTITY_TYPES.register("frank2",
            () -> EntityType.Builder.of(EntityFrank2::new, EntityClassification.MONSTER).sized(0.6f,2.4f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "frank2").toString()));

    public static final RegistryObject<EntityType<EntityFrank3>> FRANK3 = ENTITY_TYPES.register("frank3",
            () -> EntityType.Builder.of(EntityFrank3::new, EntityClassification.MONSTER).sized(0.8f,2.4f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "frank3").toString()));

    public static final RegistryObject<EntityType<EntityFrank4>> FRANK4 = ENTITY_TYPES.register("frank4",
            () -> EntityType.Builder.of(EntityFrank4::new, EntityClassification.MONSTER).sized(0.8f,2.4f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "frank4").toString()));

    public static final RegistryObject<EntityType<EntityFrank5>> FRANK5 = ENTITY_TYPES.register("frank5",
            () -> EntityType.Builder.of(EntityFrank5::new, EntityClassification.MONSTER).sized(0.8f,2.7f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "frank5").toString()));

    public static final RegistryObject<EntityType<EntityFrank6>> FRANK6 = ENTITY_TYPES.register("frank6",
            () -> EntityType.Builder.of(EntityFrank6::new, EntityClassification.MONSTER).sized(0.8f,2.65f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "frank6").toString()));

    public static final RegistryObject<EntityType<EntityDund>> DUND = ENTITY_TYPES.register("dund",
            () -> EntityType.Builder.of(EntityDund::new, EntityClassification.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "dund").toString()));

    public static final RegistryObject<EntityType<EntityDund2>> DUND2 = ENTITY_TYPES.register("dund2",
            () -> EntityType.Builder.of(EntityDund2::new, EntityClassification.MONSTER).sized(0.8f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "dund2").toString()));

    public static final RegistryObject<EntityType<EntitySamca>> SAMCA = ENTITY_TYPES.register("samca",
            () -> EntityType.Builder.of(EntitySamca::new, EntityClassification.MONSTER).sized(0.8f,2f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "samca").toString()));

    public static final RegistryObject<EntityType<EntityLycan>> LYCAN = ENTITY_TYPES.register("lycan",
            () -> EntityType.Builder.of(EntityLycan::new, EntityClassification.MONSTER).sized(1f,2f).setTrackingRange(45)
                    .build(new ResourceLocation(Utils.MOD_ID, "lycan").toString()));

    public static final RegistryObject<EntityType<EntityLycan1>> LYCAN1 = ENTITY_TYPES.register("lycan1",
            () -> EntityType.Builder.of(EntityLycan1::new, EntityClassification.MONSTER).sized(0.8f,2.5f).setTrackingRange(45)
                    .build(new ResourceLocation(Utils.MOD_ID, "lycan1").toString()));

//    public static final RegistryObject<EntityType<EntityLycana>> LYCANA = ENTITY_TYPES.register("lycana",
//            () -> EntityType.Builder.of(EntityLycana::new, EntityClassification.MONSTER).sized(0.8f,2.0f).setTrackingRange(45)
//                    .build(new ResourceLocation(Utils.MOD_ID, "lycana").toString()));

    public static final RegistryObject<EntityType<EntityVarcolac>> VARCOLAC = ENTITY_TYPES.register("varcolac",
            () -> EntityType.Builder.of(EntityVarcolac::new, EntityClassification.MONSTER).sized(1.3f,3.0f).setTrackingRange(45)
                    .build(new ResourceLocation(Utils.MOD_ID, "varcolac").toString()));

    public static final RegistryObject<EntityType<EntityChris>> CHRIS = ENTITY_TYPES.register("chris",
            () -> EntityType.Builder.of(EntityChris::new, EntityClassification.MONSTER).sized(0.9f,2.1f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "chris").toString()));

    public static final RegistryObject<EntityType<EntityUrias>> URIAS = ENTITY_TYPES.register("urias",
            () -> EntityType.Builder.of(EntityUrias::new, EntityClassification.MONSTER).sized(1.4f,3.0f).setTrackingRange(20)
                    .build(new ResourceLocation(Utils.MOD_ID, "urias").toString()));

    public static final RegistryObject<EntityType<EntityUriass>> URIASS = ENTITY_TYPES.register("uriass",
            () -> EntityType.Builder.of(EntityUriass::new, EntityClassification.MONSTER).sized(1.6f,3.5f).setTrackingRange(25)
                    .build(new ResourceLocation(Utils.MOD_ID, "uriass").toString()));

    public static final RegistryObject<EntityType<EntityTheHag>> THEHAG = ENTITY_TYPES.register("thehag",
            () -> EntityType.Builder.of(EntityTheHag::new, EntityClassification.MONSTER).sized(0.9f,1.8f).setTrackingRange(35)
                    .build(new ResourceLocation(Utils.MOD_ID, "thehag").toString()));

    public static final RegistryObject<EntityType<EntityMycete>> MYCETE = ENTITY_TYPES.register("mycete",
            () -> EntityType.Builder.of(EntityMycete::new, EntityClassification.MONSTER).sized(0.7f,0.6f).setTrackingRange(20)
                    .build(new ResourceLocation(Utils.MOD_ID, "mycete").toString()));

    public static final RegistryObject<EntityType<EntityMMycete>> MMYCETE = ENTITY_TYPES.register("mmycete",
            () -> EntityType.Builder.of(EntityMMycete::new, EntityClassification.MONSTER).sized(2.6f,16.6f).setTrackingRange(20)
                    .build(new ResourceLocation(Utils.MOD_ID, "mmycete").toString()));

    public static final RegistryObject<EntityType<EntityMiranda1>> MIRANDA1 = ENTITY_TYPES.register("miranda1",
            () -> EntityType.Builder.of(EntityMiranda1::new, EntityClassification.MONSTER).sized(0.8f,2.8f).setTrackingRange(20)
                    .build(new ResourceLocation(Utils.MOD_ID, "miranda1").toString()));

    public static final RegistryObject<EntityType<EntityMiranda2>> MIRANDA2 = ENTITY_TYPES.register("miranda2",
            () -> EntityType.Builder.of(EntityMiranda2::new, EntityClassification.MONSTER).sized(0.8f,3.1f).setTrackingRange(25)
                    .build(new ResourceLocation(Utils.MOD_ID, "miranda2").toString()));

    public static final RegistryObject<EntityType<EntityMiranda3>> MIRANDA3 = ENTITY_TYPES.register("miranda3",
            () -> EntityType.Builder.of(EntityMiranda3::new, EntityClassification.MONSTER).sized(0.8f,3.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "miranda3").toString()));

    public static final RegistryObject<EntityType<EntityMiranda4>> MIRANDA4 = ENTITY_TYPES.register("miranda4",
            () -> EntityType.Builder.of(EntityMiranda4::new, EntityClassification.MONSTER).sized(2.8f,5.5f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "miranda4").toString()));

    public static final RegistryObject<EntityType<EntityRose>> ROSE = ENTITY_TYPES.register("rose",
            () -> EntityType.Builder.of(EntityRose::new, EntityClassification.MONSTER).sized(1.2f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "rose").toString()));

    public static final RegistryObject<EntityType<EntityMia>> MIA = ENTITY_TYPES.register("mia",
            () -> EntityType.Builder.of(EntityMia::new, EntityClassification.MONSTER).sized(2f,0.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "mia").toString()));

    public static final RegistryObject<EntityType<EntityAda>> ADA = ENTITY_TYPES.register("ada",
            () -> EntityType.Builder.of(EntityAda::new, EntityClassification.MONSTER).sized(2f,0.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "ada").toString()));

    public static final RegistryObject<EntityType<HeisenCarEntity>> HEISENCAR = ENTITY_TYPES.register("heisencar",
            () -> EntityType.Builder.of(HeisenCarEntity::new, EntityClassification.MISC).sized(2f,0.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "heisencar").toString()));

    public static final RegistryObject<EntityType<EntityObBoat>> OBBOAT = ENTITY_TYPES.register("obboat",
            () -> EntityType.Builder.<EntityObBoat>of(EntityObBoat::new, EntityClassification.MISC).sized(1.375F, 1.26F).setTrackingRange(10)
                    .build(new ResourceLocation(Utils.MOD_ID, "obboat").toString()));

//    public static final RegistryObject<EntityType<EntityObBoat>> OBBOAT = ENTITY_TYPES.register("obboat",
//            () -> EntityType.Builder.<EntityObBoat>of(EntityObBoat::new, MobCategory.MISC).sized(1.2F, 1.25F)
//                    .setTrackingRange(4).updateInterval(10).build("obboat"));

    public static final RegistryObject<EntityType<EntityBp>> BP = ENTITY_TYPES.register("bp",
            () -> EntityType.Builder.of(EntityBp::new, EntityClassification.CREATURE).sized(0.9f,1.0f).setTrackingRange(10)
                    .build(new ResourceLocation(Utils.MOD_ID, "bp").toString()));

    public static final RegistryObject<EntityType<EntityWp>> WP = ENTITY_TYPES.register("wp",
            () -> EntityType.Builder.of(EntityWp::new, EntityClassification.CREATURE).sized(0.9f,1.0f).setTrackingRange(10)
                    .build(new ResourceLocation(Utils.MOD_ID, "wp").toString()));

    public static final RegistryObject<EntityType<EntityAxeman>> AXEMAN = ENTITY_TYPES.register("axeman",
            () -> EntityType.Builder.of(EntityAxeman::new, EntityClassification.MONSTER).sized(1.4f,3.0f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "axeman").toString()));

    public static final RegistryObject<EntityType<EntityGM79B>> GM79B =
            ENTITY_TYPES.register("gm79b", () -> EntityType.Builder.<EntityGM79B>of
                    (EntityGM79B::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("gm79b"));

    public static final RegistryObject<EntityType<EntityM1851B>> M1851B =
            ENTITY_TYPES.register("m1851b", () -> EntityType.Builder.<EntityM1851B>of
                    (EntityM1851B::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("m1851"));

    public static final RegistryObject<EntityType<EntityM1897B>> M1897B =
            ENTITY_TYPES.register("m1897b", () -> EntityType.Builder.<EntityM1897B>of
                    (EntityM1897B::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("m1897"));

    public static final RegistryObject<EntityType<EntitySniperAmmo>> SNIPERAMMO =
            ENTITY_TYPES.register("sniperammo", () -> EntityType.Builder.<EntitySniperAmmo>of
                    (EntitySniperAmmo::new, EntityClassification.MISC).sized(0.35F, 0.35F).setTrackingRange(4).updateInterval(10).build("sniperammo"));

    public static final RegistryObject<EntityType<EntityRifleAmmo>> RIFLEAMMO =
            ENTITY_TYPES.register("rifleammo", () -> EntityType.Builder.<EntityRifleAmmo>of
                    (EntityRifleAmmo::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("rifleammo"));

    public static final RegistryObject<EntityType<EntityMoSpitter>> MOSPITTER =
            ENTITY_TYPES.register("mospitter", () -> EntityType.Builder.<EntityMoSpitter>of
                    (EntityMoSpitter::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("mospitter"));

    public static final RegistryObject<EntityType<EntityMoreauProjectile>> MOPROJECTILE =
            ENTITY_TYPES.register("mopro", () -> EntityType.Builder.<EntityMoreauProjectile>of
                    (EntityMoreauProjectile::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("mopro"));

    public static final RegistryObject<EntityType<EntityBOWShoot>> BOWShoot =
            ENTITY_TYPES.register("bowa", () -> EntityType.Builder.<EntityBOWShoot>of
                    (EntityBOWShoot::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("bowa"));

    public static final RegistryObject<EntityType<EntityPipeb>> PIPEB =
            ENTITY_TYPES.register("pipeb", () -> EntityType.Builder.<EntityPipeb>of
                    (EntityPipeb::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("pipeb"));

    public static final RegistryObject<EntityType<EntityDuke>> DUKE = ENTITY_TYPES.register("duke",
            () -> EntityType.Builder.of(EntityDuke::new, EntityClassification.MISC).sized(1.2f,3f).setTrackingRange(38)
                    .build(new ResourceLocation(Utils.MOD_ID, "duke").toString()));

    public static final RegistryObject<EntityType<EntitySummonSturm>> SUMMONFRANK5 = ENTITY_TYPES.register("summonfrank5",
            () -> EntityType.Builder.of(EntitySummonSturm::new, EntityClassification.MONSTER).sized(1.2f,2.7f).setTrackingRange(40)
                    .build(new ResourceLocation(Utils.MOD_ID, "summonfrank5").toString()));

    public static final RegistryObject<EntityType<EntitySummonDaughter>> SUMMONDAUGHTER = ENTITY_TYPES.register("summondaughter",
            () -> EntityType.Builder.of(EntitySummonDaughter::new, EntityClassification.MONSTER).sized(0.8f,1.8f).setTrackingRange(30)
                    .build(new ResourceLocation(Utils.MOD_ID, "summondaughter").toString()));

    public static final RegistryObject<EntityType<EntityEdMan>> EDMAN = ENTITY_TYPES.register("edman",
            () -> EntityType.Builder.of(EntityEdMan::new, EntityClassification.MISC).sized(1.2f,3f).setTrackingRange(38)
                    .build(new ResourceLocation(Utils.MOD_ID, "edman").toString()));
    public static final RegistryObject<EntityType<EntityEndGuard>> ENDGUARD = ENTITY_TYPES.register("endguard",
            () -> EntityType.Builder.of(EntityEndGuard::new, EntityClassification.MISC).sized(1.2f,3f).setTrackingRange(38)
                    .build(new ResourceLocation(Utils.MOD_ID, "endguard").toString()));
    public static final RegistryObject<EntityType<EntityEndKing>> ENDKING = ENTITY_TYPES.register("endking",
            () -> EntityType.Builder.of(EntityEndKing::new, EntityClassification.MISC).sized(1.2f,3f).setTrackingRange(38)
                    .build(new ResourceLocation(Utils.MOD_ID, "endking").toString()));
    public static final RegistryObject<EntityType<EntityEndScienceBlack>> ENDSCIBLACK = ENTITY_TYPES.register("scienceblack",
            () -> EntityType.Builder.of(EntityEndScienceBlack::new, EntityClassification.MISC).sized(1.2f,3f).setTrackingRange(38)
                    .build(new ResourceLocation(Utils.MOD_ID, "scienceblack").toString()));
}
