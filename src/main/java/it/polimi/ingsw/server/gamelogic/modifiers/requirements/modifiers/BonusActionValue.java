package it.polimi.ingsw.server.gamelogic.modifiers.requirements.modifiers;

import it.polimi.ingsw.server.gamelogic.modifiers.AvailableActions;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.BoardActionRequirements;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.SpaceActionRequirements;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.TowerActionRequirements;

import java.util.Objects;

/**
 * Class that describes when it's given a Bonus value to perform an action
 */
public class BonusActionValue extends RequirementsModifier {
    private int bonusValue;

    public BonusActionValue(AvailableActions availableActions, int bonusValue) {
        super(availableActions);
        this.bonusValue = bonusValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        BonusActionValue that = (BonusActionValue) o;
        return bonusValue == that.bonusValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonusValue);
    }

    @Override
    public BoardActionRequirements modifyRequirements(BoardActionRequirements boardActionRequirements) {
        if (availableActions.hasAvailableAction(boardActionRequirements.getActionType())) {
            BoardActionRequirements bonusActionValueBoardActionModifier = boardActionRequirements;
            addBonusActionValue(bonusActionValueBoardActionModifier.getSpaceActionRequirements());
            return bonusActionValueBoardActionModifier;
        }
        return boardActionRequirements;
    }

    @Override
    public TowerActionRequirements modifyRequirements(TowerActionRequirements towerActionRequirements) {
        if (availableActions.hasAvailableAction(towerActionRequirements.getActionType())) {
            TowerActionRequirements bonusActionValueTowerActionModifier = towerActionRequirements;
            addBonusActionValue(bonusActionValueTowerActionModifier.getSpaceActionRequirements());
            return bonusActionValueTowerActionModifier;
        }
        return towerActionRequirements;
    }

    private void addBonusActionValue(SpaceActionRequirements spaceActionRequirements) {
        int actualBonusValue = spaceActionRequirements.getActionValueModifier();
        spaceActionRequirements.setActionValueModifier(bonusValue + actualBonusValue);
    }
}