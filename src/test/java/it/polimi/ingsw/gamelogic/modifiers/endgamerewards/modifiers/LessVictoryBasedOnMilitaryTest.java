package it.polimi.ingsw.gamelogic.modifiers.endgamerewards.modifiers;

import it.polimi.ingsw.gamelogic.basics.Points;
import it.polimi.ingsw.gamelogic.modifiers.endgamerewards.BasicEndGameRewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessVictoryBasedOnMilitaryTest {
    private BasicEndGameRewards basicEndGameRewards;

    @BeforeEach
    void setUp() {
        basicEndGameRewards = new BasicEndGameRewards(new Points(5,0,0),
                new Points(10,0,0), new Points(15,0,0));
    }

    @Test
    void testModifyEndGameRewards() {
        LessVictoryBasedOnMilitary modifier = new LessVictoryBasedOnMilitary(new Points(10,10,10));
        modifier.modifyEndGameRewards(basicEndGameRewards);

        assertEquals(new Points(20,0,0), basicEndGameRewards.calculateFinalEndGameRewards());
    }
}