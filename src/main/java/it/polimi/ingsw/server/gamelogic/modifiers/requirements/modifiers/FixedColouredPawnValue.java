package it.polimi.ingsw.server.gamelogic.modifiers.requirements.modifiers;

import it.polimi.ingsw.server.gamelogic.modifiers.AvailableActions;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.BoardActionRequirements;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.SpaceActionRequirements;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.TowerActionRequirements;
import it.polimi.ingsw.shared.model.PawnColor;

import java.util.Objects;

/**
 * Class that represents the effect of a card that fixes the value of one of the player's pawn
 */
public class FixedColouredPawnValue extends RequirementsModifier {
    private PawnColor pawnColor;
    private int pawnValue;

    public FixedColouredPawnValue(AvailableActions availableActions, PawnColor pawnColor, int pawnValue) {
        super(availableActions);
        this.pawnColor = pawnColor;
        this.pawnValue = pawnValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        FixedColouredPawnValue that = (FixedColouredPawnValue) o;
        return pawnValue == that.pawnValue &&
                pawnColor == that.pawnColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pawnColor, pawnValue);
    }

    @Override
    public BoardActionRequirements modifyRequirements(BoardActionRequirements boardActionRequirements) {
        if (availableActions.hasAvailableAction(boardActionRequirements.getActionType())) {
            BoardActionRequirements fixedColouredPawnValueBoardActionModifier = boardActionRequirements;
            fixedValueIfSameColorPawn(fixedColouredPawnValueBoardActionModifier.getSpaceActionRequirements());
            return fixedColouredPawnValueBoardActionModifier;
        }
        return boardActionRequirements;
    }

    @Override
    public TowerActionRequirements modifyRequirements(TowerActionRequirements towerActionRequirements) {
        if (availableActions.hasAvailableAction(towerActionRequirements.getActionType())) {
            TowerActionRequirements fixedColouredPawnValueTowerActionModifier = towerActionRequirements;
            fixedValueIfSameColorPawn(fixedColouredPawnValueTowerActionModifier.getSpaceActionRequirements());
            return fixedColouredPawnValueTowerActionModifier;
        }
        return towerActionRequirements;
    }

    private void fixedValueIfSameColorPawn(SpaceActionRequirements spaceActionRequirements) {
        if (pawnColor == spaceActionRequirements.getPawnColor()) {
            if (spaceActionRequirements.modifiedActionValue()) {
                if (spaceActionRequirements.getActionValue() < pawnValue)
                    spaceActionRequirements.setActionValue(pawnValue);
            }
            else
                spaceActionRequirements.setActionValue(pawnValue);
        }
    }

    public PawnColor getPawnColor() {
        return pawnColor;
    }

    public void setPawnColor(PawnColor pawnColor) {
        this.pawnColor = pawnColor;
    }

    public int getPawnValue() {
        return pawnValue;
    }

    public void setPawnValue(int pawnValue) {
        this.pawnValue = pawnValue;
    }
}
