package it.polimi.ingsw.gamelogic.modifiers.endgamerewards.modifiers;

import it.polimi.ingsw.gamelogic.basics.Points;
import it.polimi.ingsw.gamelogic.modifiers.endgamerewards.BasicEndGameRewards;

/**
 * Describes the effect of an Excommunication Tile that prevents the Player to collect the Victory Points from the
 * Character cards
 */
public class NoCharacterCardsEndRewards implements EndGameRewardsModifier {
    @Override
    public void modifyEndGameRewards(BasicEndGameRewards basicEndGameRewards) {
        basicEndGameRewards.setPointsForCharacterCards(new Points());
    }
}
