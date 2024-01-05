package scripts.kissa.LOST_SECTOR.hullmods;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import scripts.kissa.LOST_SECTOR.campaign.customStart.abilities.hellSpawnPeacefulSkill;

public class nskr_hellSpawnPeacefulSkillDummy extends BaseHullMod {

    @Override
    public void applyEffectsBeforeShipCreation(ShipAPI.HullSize hullSize, MutableShipStatsAPI stats, String id) {
    }

    @Override
    public void applyEffectsAfterShipCreation(ShipAPI ship, String id) {

        ship.addListener(new hellSpawnPeacefulSkill.hellSpawnPeacefulSkillListener(ship));
    }

    @Override
    public void advanceInCombat(ShipAPI ship, float amount) {
    }

    @Override
    public void advanceInCampaign(FleetMemberAPI member, float amount) {
        //why the fuck is unapply never called aaaa
        //safety
        if (!Global.getSector().getPlayerStats().hasSkill("hellSpawnPeacefulSkill")) {
            member.getVariant().removeMod("nskr_hellSpawnPeacefulSkillDummy");
        }
    }

    @Override
    public void addPostDescriptionSection(TooltipMakerAPI tooltip, ShipAPI.HullSize hullSize, ShipAPI ship, float width, boolean isForModSpec) {
    }

    @Override
    public String getDescriptionParam(int index, ShipAPI.HullSize hullSize) {
        return null;
    }

    @Override
    public boolean isApplicableToShip(ShipAPI ship) {
        return true;
    }

    @Override
    public boolean affectsOPCosts() {
        return false;
    }
}

