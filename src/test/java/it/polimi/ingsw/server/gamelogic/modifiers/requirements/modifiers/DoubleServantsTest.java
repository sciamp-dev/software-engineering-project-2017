package it.polimi.ingsw.server.gamelogic.modifiers.requirements.modifiers;

import it.polimi.ingsw.server.gamelogic.basics.Goods;
import it.polimi.ingsw.server.gamelogic.basics.Resources;
import it.polimi.ingsw.server.gamelogic.modifiers.AvailableActions;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.BoardActionRequirements;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.SpaceActionRequirements;
import it.polimi.ingsw.server.gamelogic.modifiers.requirements.TowerActionRequirements;
import it.polimi.ingsw.server.gamelogic.player.*;
import it.polimi.ingsw.shared.model.ActionType;
import it.polimi.ingsw.shared.model.PawnColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DoubleServantsTest {
    private BoardActionRequirements boardActionRequirements;
    private TowerActionRequirements towerActionRequirements;
    private Player player;

    private DoubleServants doubleServants;

    @BeforeEach
    void setUp() {
        boardActionRequirements = new BoardActionRequirements(new SpaceActionRequirements(
                ActionType.MARKET, PawnColor.BLACK,
                3, 2, 2, false));

        SpaceActionRequirements spaceActionRequirements = new SpaceActionRequirements(
                ActionType.BLUE_TOWER, PawnColor.ORANGE,
                3, 1, 2, false);
        Goods requiredGoods = new Goods(new Resources(5,4,3,2));

        towerActionRequirements = new TowerActionRequirements(spaceActionRequirements, requiredGoods, new Goods(),
                new Goods(), false, false);

        player = new Player(new PlayerDetails(), new PlayerBoard(new BonusTiles(new Goods(), new Goods()),
                new Goods(new Resources(5,5,5,5))));

        List<Pawn> pawns = new ArrayList<>();
        pawns.add(new Pawn(2, PawnColor.BLACK));
        pawns.add(new Pawn(1, PawnColor.ORANGE));
        player.getPlayerBoard().setPawns(pawns);

        List<ActionType> actionTypes = new ArrayList<>();
        actionTypes.add(ActionType.MARKET);
        actionTypes.add(ActionType.BLUE_TOWER);
        doubleServants = new DoubleServants(new AvailableActions(actionTypes));
    }

     @Test
     void testEqualsTrue1() {
         List<ActionType> actionTypes = new ArrayList<>();
         actionTypes.add(ActionType.MARKET);
         actionTypes.add(ActionType.BLUE_TOWER);
        DoubleServants doubleServantsToConfront = new DoubleServants(new AvailableActions(actionTypes));
        assertTrue(doubleServants.equals(doubleServantsToConfront));
     }

     @Test
     void testEqualsTrue2() {
        DoubleServants doubleServantsToConfront = doubleServants;
        assertTrue(doubleServants.equals(doubleServantsToConfront));
     }

     @Test
     void testEqualsFalse() {
        DoubleServants doubleServantsToConfront = new DoubleServants(new AvailableActions(ActionType.COUNCIL_PALACE));
        assertFalse(doubleServants.equals(doubleServantsToConfront));
     }

     @Test
     void testEqualsDifferent1() {
        String different = "";
        assertFalse(doubleServants.equals(different));
     }

     @Test
     void testEqualsDifferent2() {
         assertFalse(doubleServants.equals(null));
     }

    @Test
    void testModifyRequirementsOfBoardAction() {
        boardActionRequirements = doubleServants.modifyRequirements(boardActionRequirements);
        assertTrue(boardActionRequirements.hasRequirements(player));
    }

    @Test
    void testModifyRequirementsOfTowerAction() {
        towerActionRequirements = doubleServants.modifyRequirements(towerActionRequirements);
        assertFalse(towerActionRequirements.hasRequirements(player));
    }
}