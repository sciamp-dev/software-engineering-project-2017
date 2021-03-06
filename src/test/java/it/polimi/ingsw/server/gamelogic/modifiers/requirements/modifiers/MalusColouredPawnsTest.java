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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MalusColouredPawnsTest {
    private BoardActionRequirements boardActionRequirements;
    private TowerActionRequirements towerActionRequirements;
    private Player player;

    private MalusColouredPawns malusColouredPawns;

    @BeforeEach
    void setUp() {
        boardActionRequirements = new BoardActionRequirements(new SpaceActionRequirements(
                ActionType.MARKET, PawnColor.BLACK,
                4, 5, 0, false));

        SpaceActionRequirements spaceActionRequirements = new SpaceActionRequirements(
                ActionType.BLUE_TOWER, PawnColor.BLACK,
                4, 5, 0, false);
        Goods requiredGoods = new Goods(new Resources(5,4,3,2));

        towerActionRequirements = new TowerActionRequirements(spaceActionRequirements, requiredGoods, new Goods(),
                new Goods(), false, false);

        player = new Player(new PlayerDetails(), new PlayerBoard(new BonusTiles(new Goods(), new Goods()),
                new Goods(new Resources(5,5,5,5))));

        List<Pawn> pawns = new ArrayList<>();
        pawns.add(new Pawn(5, PawnColor.BLACK));
        pawns.add(new Pawn(5, PawnColor.ORANGE));
        player.getPlayerBoard().setPawns(pawns);

        List<PawnColor> pawnColors = new ArrayList<>();
        pawnColors.add(PawnColor.BLACK);
        pawnColors.add(PawnColor.ORANGE);

        List<ActionType> actionTypes = new ArrayList<>();
        actionTypes.add(ActionType.MARKET);
        actionTypes.add(ActionType.BLUE_TOWER);

        malusColouredPawns = new MalusColouredPawns(new AvailableActions(actionTypes), pawnColors, 2);
    }

    @Test
    void testEqualsTrue1() {
        List<PawnColor> pawnColors = new ArrayList<>();
        pawnColors.add(PawnColor.BLACK);
        pawnColors.add(PawnColor.ORANGE);
        List<ActionType> actionTypes = new ArrayList<>();
        actionTypes.add(ActionType.MARKET);
        actionTypes.add(ActionType.BLUE_TOWER);
        MalusColouredPawns malusColouredPawnsToConfront = new MalusColouredPawns(new AvailableActions(actionTypes),
                pawnColors, 2);
        assertTrue(malusColouredPawns.equals(malusColouredPawnsToConfront));
    }

    @Test
    void testEqualsTrue2() {
        MalusColouredPawns malusColouredPawnsToConfront = malusColouredPawns;
        assertTrue(malusColouredPawns.equals(malusColouredPawnsToConfront));
    }

    @Test
    void testEqualsFalse1() {
        List<PawnColor> pawnColors = new ArrayList<>();
        pawnColors.add(PawnColor.BLACK);
        pawnColors.add(PawnColor.ORANGE);
        List<ActionType> actionTypes = new ArrayList<>();
        actionTypes.add(ActionType.BLUE_TOWER);
        MalusColouredPawns malusColouredPawnsToConfront = new MalusColouredPawns(new AvailableActions(actionTypes),
                pawnColors, 2);
        assertFalse(malusColouredPawns.equals(malusColouredPawnsToConfront));
    }

    @Test
    void testEqualsFalse2() {
        List<PawnColor> pawnColors = new ArrayList<>();
        pawnColors.add(PawnColor.BLACK);
        List<ActionType> actionTypes = new ArrayList<>();
        actionTypes.add(ActionType.MARKET);
        actionTypes.add(ActionType.BLUE_TOWER);
        MalusColouredPawns malusColouredPawnsToConfront = new MalusColouredPawns(new AvailableActions(actionTypes),
                pawnColors, 2);
        assertFalse(malusColouredPawns.equals(malusColouredPawnsToConfront));
    }

    @Test
    void testEqualsFalse3() {
        List<PawnColor> pawnColors = new ArrayList<>();
        pawnColors.add(PawnColor.BLACK);
        pawnColors.add(PawnColor.ORANGE);
        List<ActionType> actionTypes = new ArrayList<>();
        actionTypes.add(ActionType.MARKET);
        actionTypes.add(ActionType.BLUE_TOWER);
        MalusColouredPawns malusColouredPawnsToConfront = new MalusColouredPawns(new AvailableActions(actionTypes),
                pawnColors, 4);
        assertFalse(malusColouredPawns.equals(malusColouredPawnsToConfront));
    }

    @Test
    void testEqualsDifferent1() {
        String different = "";
        assertFalse(malusColouredPawns.equals(different));
    }

    @Test
    void testEqualsDifferent2() {
        assertFalse(malusColouredPawns.equals(null));
    }

    @Test
    void testModifyRequirementsOfBoardAction() {
        boardActionRequirements = malusColouredPawns.modifyRequirements(boardActionRequirements);
        assertFalse(boardActionRequirements.hasRequirements(player));
    }

    @Test
    void testModifyRequirementsOfTowerAction() {
        towerActionRequirements = malusColouredPawns.modifyRequirements(towerActionRequirements);
        assertFalse(towerActionRequirements.hasRequirements(player));
    }

    @Test
    void testGetPawnColors() {
        List<PawnColor> pawnColors = new ArrayList<>();
        pawnColors.add(PawnColor.WHITE);
        pawnColors.add(PawnColor.ORANGE);
        malusColouredPawns.setPawnColors(pawnColors);
        assertEquals(malusColouredPawns.getPawnColors(), pawnColors);
    }

    @Test
    void testGetValue() {
        int numberToGet = 7;
        malusColouredPawns.setValue(numberToGet);
        assertEquals(numberToGet, malusColouredPawns.getValue());
    }
}