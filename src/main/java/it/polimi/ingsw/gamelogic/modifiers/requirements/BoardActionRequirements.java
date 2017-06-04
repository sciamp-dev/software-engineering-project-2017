package it.polimi.ingsw.gamelogic.modifiers.requirements;

import it.polimi.ingsw.gamelogic.enums.ActionType;
import it.polimi.ingsw.gamelogic.player.Player;

/**
 * Class that describes the requirements of a BoardAction
 */
public class BoardActionRequirements implements Requirements {
    private SpaceActionRequirements spaceActionRequirements;
    private int malusValue;

    private boolean canPlace;

    public BoardActionRequirements(SpaceActionRequirements spaceActionRequirements) {
        this.spaceActionRequirements = spaceActionRequirements;
        malusValue = 0;
        canPlace = true;
    }

    public BoardActionRequirements(SpaceActionRequirements spaceActionRequirements, int malusValue) {
        this.spaceActionRequirements = spaceActionRequirements;
        this.malusValue = malusValue;
        canPlace = true;
    }

    @Override
    public boolean hasRequirements(Player player) {
        /*
        TODO
         */
        return false;
    }

    public ActionType getActionType() {
        return spaceActionRequirements.getActionType();
    }

    public SpaceActionRequirements getSpaceActionRequirements() {
        return spaceActionRequirements;
    }

    public void setSpaceActionRequirements(SpaceActionRequirements spaceActionRequirements) {
        this.spaceActionRequirements = spaceActionRequirements;
    }

    public int getMalusValue() {
        return malusValue;
    }

    public void setMalusValue(int malusValue) {
        this.malusValue = malusValue;
    }

    public boolean isCanPlace() {
        return canPlace;
    }

    public void setCanPlace(boolean canPlace) {
        this.canPlace = canPlace;
    }
}