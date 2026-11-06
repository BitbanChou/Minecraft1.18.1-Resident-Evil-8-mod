package com.joy187.re8joymod.event;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.*;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= Main.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class EntityEvent {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(EntityInit.FLY.get(), EntityFly.prepareAttributes().build());
        event.put(EntityInit.RE8DIMI.get(), EntityRe8Dimi.prepareAttributes().build());
        event.put(EntityInit.DIMI2.get(), EntityDimi2.prepareAttributes().build());
        event.put(EntityInit.ETHAN.get(), EntityEthan.prepareAttributes().build());
        event.put(EntityInit.DUND1.get(), EntityDund.prepareAttributes().build());
        event.put(EntityInit.DUND2.get(), EntityDund2.prepareAttributes().build());
        event.put(EntityInit.SAMCA.get(), EntitySamca.prepareAttributes().build());
        event.put(EntityInit.BELA.get(), EntityBela.prepareAttributes().build());
        event.put(EntityInit.CASSANDRA.get(), EntityCassandra.prepareAttributes().build());
        event.put(EntityInit.DANIELA.get(), EntityDaniela.prepareAttributes().build());
        event.put(EntityInit.BEI.get(), EntityBei.prepareAttributes().build());
        event.put(EntityInit.ANGIE.get(), EntityAngie.prepareAttributes().build());
        event.put(EntityInit.DOLL1.get(), EntityDoll1.prepareAttributes().build());
        event.put(EntityInit.DOLL2.get(), EntityDoll2.prepareAttributes().build());
        event.put(EntityInit.DOLL3.get(), EntityDoll3.prepareAttributes().build());
        event.put(EntityInit.BEIBABY.get(), EntityBeibaby.prepareAttributes().build());
        event.put(EntityInit.FRANK1.get(), EntityFrank1.prepareAttributes().build());
        event.put(EntityInit.FRANK2.get(), EntityFrank2.prepareAttributes().build());
        event.put(EntityInit.FRANK3.get(), EntityFrank3.prepareAttributes().build());
        event.put(EntityInit.FRANK4.get(), EntityFrank4.prepareAttributes().build());
        event.put(EntityInit.FRANK5.get(), EntityFrank5.prepareAttributes().build());
        event.put(EntityInit.FRANK6.get(), EntityFrank6.prepareAttributes().build());
        event.put(EntityInit.LYCANA.get(), EntityLycana.prepareAttributes().build());
        event.put(EntityInit.MYCETE.get(), EntityMycete.prepareAttributes().build());
        event.put(EntityInit.MMYCETE.get(), EntityMMycete.prepareAttributes().build());
        event.put(EntityInit.VARCOLAC.get(), EntityVarcolac.prepareAttributes().build());
        event.put(EntityInit.LYCAN.get(), EntityLycan.prepareAttributes().build());
        event.put(EntityInit.LYCAN1.get(), EntityLycan1.prepareAttributes().build());
        event.put(EntityInit.MOREAU.get(), EntityMoreau.prepareAttributes().build());
        event.put(EntityInit.MOREAU2.get(), EntityMoreau2.prepareAttributes().build());
        event.put(EntityInit.MOREAU3.get(), EntityMoreau3.prepareAttributes().build());
        event.put(EntityInit.HEISEN.get(), EntityHeisen.prepareAttributes().build());
        event.put(EntityInit.MUHEISEN.get(), EntityMuHeisen.prepareAttributes().build());
        event.put(EntityInit.MIA.get(), EntityMia.prepareAttributes().build());
        event.put(EntityInit.URIAS.get(), EntityUrias.prepareAttributes().build());
        event.put(EntityInit.URIASS.get(), EntityUriass.prepareAttributes().build());
        event.put(EntityInit.CHRIS.get(), EntityChris.prepareAttributes().build());
        event.put(EntityInit.AXEMAN.get(), EntityAxeman.prepareAttributes().build());
        event.put(EntityInit.HEISENCAR.get(), EntityHeisencar.prepareAttributes().build());
        event.put(EntityInit.DUKE.get(), EntityDuke.prepareAttributes().build());
        event.put(EntityInit.THEHAG.get(), EntityTheHag.prepareAttributes().build());
        event.put(EntityInit.MIRANDA1.get(), EntityMiranda1.prepareAttributes().build());
        event.put(EntityInit.MIRANDA2.get(), EntityMiranda2.prepareAttributes().build());
        event.put(EntityInit.MIRANDA3.get(), EntityMiranda3.prepareAttributes().build());
        event.put(EntityInit.MIRANDA4.get(), EntityMiranda4.prepareAttributes().build());
        event.put(EntityInit.ROSEMARY.get(), EntityRosemary.prepareAttributes().build());
        event.put(EntityInit.ADA.get(), EntityAda.prepareAttributes().build());
        event.put(EntityInit.ADA4.get(), EntityAda4.prepareAttributes().build());
        event.put(EntityInit.LEON.get(), EntityLeon.prepareAttributes().build());
        event.put(EntityInit.MOREAU4.get(), EntityMoreau4.prepareAttributes().build());
        event.put(EntityInit.SUMMONFRANK5.get(), EntitySummonSturm.prepareAttributes().build());
        event.put(EntityInit.SUMMONDAUGHTER.get(), EntitySummonDaughter.prepareAttributes().build());
        event.put(EntityInit.CHIEF2.get(), EntityChief2.prepareAttributes().build());
        event.put(EntityInit.CHIEF.get(), EntityChief.prepareAttributes().build());
        event.put(EntityInit.MERCHANT.get(), EntityMerchant.prepareAttributes().build());
        event.put(EntityInit.GARRADOR.get(), EntityGarrador.prepareAttributes().build());
        event.put(EntityInit.VILLAGERGANADO.get(), EntityVillagerGanado.prepareAttributes().build());
        event.put(EntityInit.CVG.get(), EntityCvg.prepareAttributes().build());
        event.put(EntityInit.PLAGAS.get(), EntityPlagas.prepareAttributes().build());
        event.put(EntityInit.U3.get(), EntityU3.prepareAttributes().build());
        event.put(EntityInit.ELG.get(), EntityElg.prepareAttributes().build());
        event.put(EntityInit.PLAGASVILLAGER.get(), EntityPlagasVillager.prepareAttributes().build());
        event.put(EntityInit.PLAGASZOMBIE.get(), EntityPlagasZombie.prepareAttributes().build());
        event.put(EntityInit.DALLAGO.get(), EntityDellago.prepareAttributes().build());
        event.put(EntityInit.PLAGASENDERMAN.get(), EntityPlagasEnderman.prepareAttributes().build());
        event.put(EntityInit.PLAGASCREEPER.get(), EntityPlagasCreeper.prepareAttributes().build());
        event.put(EntityInit.VERDUGO.get(), EntityVerdugo.prepareAttributes().build());
        event.put(EntityInit.MANNEQUIN.get(), EntityMannequin.prepareAttributes().build());
        event.put(EntityInit.ARMADURA.get(), EntityArmadura.prepareAttributes().build());
        event.put(EntityInit.ZEALOT.get(), EntityZealot.prepareAttributes().build());
        event.put(EntityInit.HELI.get(), EntityHeli.prepareAttributes().build());
        event.put(EntityInit.SALAZAR.get(), EntitySalazar.prepareAttributes().build());
        event.put(EntityInit.PLAGASARMADURA.get(), EntityPlagasArmadura.prepareAttributes().build());
        event.put(EntityInit.ZEALOTA.get(), EntityZealota.prepareAttributes().build());
        event.put(EntityInit.KRAUSER2.get(), EntityKrauser2.prepareAttributes().build());
        event.put(EntityInit.KRAUSER.get(), EntityKrauser.prepareAttributes().build());
        event.put(EntityInit.REGENERATOR.get(), EntityRegenerator.prepareAttributes().build());
        event.put(EntityInit.REGENERATOR2.get(), EntityRegenerator2.prepareAttributes().build());
        event.put(EntityInit.HANK.get(), EntityHank.prepareAttributes().build());
        event.put(EntityInit.PLAGASC.get(), EntityPlagasc.prepareAttributes().build());
        event.put(EntityInit.EVILDOG.get(), EntityEvilDog.prepareAttributes().build());
        event.put(EntityInit.PLAGASDOG.get(), EntityPlagasDog.prepareAttributes().build());
        event.put(EntityInit.JJ.get(), EntityJJ.prepareAttributes().build());
        event.put(EntityInit.CHIEF3.get(), EntityChief3.prepareAttributes().build());
        event.put(EntityInit.FIREENTITY.get(), FireEntity.prepareAttributes().build());
        event.put(EntityInit.SOLDI.get(), EntitySoldi.prepareAttributes().build());
        event.put(EntityInit.FE.get(), EntityFaceEater.prepareAttributes().build());
        event.put(EntityInit.NOVI.get(), EntityNovi.prepareAttributes().build());
        event.put(EntityInit.SADDLER.get(), EntitySaddler.prepareAttributes().build());
        event.put(EntityInit.STUFF.get(), EntityStuff.prepareAttributes().build());
        event.put(EntityInit.ASH.get(), EntityAsh.prepareAttributes().build());
        event.put(EntityInit.PLAGASM.get(), EntityPlagasm.prepareAttributes().build());
        event.put(EntityInit.SALAZ.get(), EntitySalaz.prepareAttributes().build());
        event.put(EntityInit.LUIS.get(), EntityLuis.prepareAttributes().build());
        event.put(EntityInit.SADDLER2.get(), EntitySaddler2.prepareAttributes().build());
        event.put(EntityInit.BRUTE.get(), EntityBrute.prepareAttributes().build());

        event.put(EntityInit.KLEE.get(), Klee.prepareAttributes().build());
        event.put(EntityInit.BOMB.get(), Bomb.prepareAttributes().build());
        event.put(EntityInit.JUMPBOMB.get(), JumpBomb.prepareAttributes().build());
        event.put(EntityInit.FIRE_ENTITY.get(), EntityHonghong.prepareAttributes().build());
    }


}
