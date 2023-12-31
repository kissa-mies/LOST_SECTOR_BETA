package scripts.kissa.LOST_SECTOR.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class nskr_hwi extends BaseHullMod {

	public static final float COST_REDUCTION = 10;

	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
		stats.getDynamic().getMod(Stats.LARGE_BALLISTIC_MOD).modifyFlat(id, -COST_REDUCTION);
		stats.getDynamic().getMod(Stats.LARGE_MISSILE_MOD).modifyFlat(id, -COST_REDUCTION);
		stats.getDynamic().getMod(Stats.LARGE_ENERGY_MOD).modifyFlat(id, -COST_REDUCTION);
	}

	public String getDescriptionParam(int index, HullSize hullSize) {
		if (index == 0) return "" + (int) COST_REDUCTION + "";
		return null;
	}

	@Override
	public boolean affectsOPCosts() {
		return true;
	}
}
