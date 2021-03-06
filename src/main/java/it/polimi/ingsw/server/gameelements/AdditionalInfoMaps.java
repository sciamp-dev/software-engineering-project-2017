package it.polimi.ingsw.server.gameelements;

import it.polimi.ingsw.server.gamelogic.cards.additionalinfo.AdditionalCardInfo;
import it.polimi.ingsw.server.gamelogic.modifiers.endgamerewards.modifiers.EndGameRewardsModifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Maps that describe the different effects of the cards. They have the name of the card as key and the Additional
 * info corresponding to the card's effect as object
 */

public class AdditionalInfoMaps {
    private static Map<String, List<AdditionalCardInfo>> flashEffectsOnChoice;
    private static Map<String, List<AdditionalCardInfo>> flashEffectsNotSelectable;
    private static Map<String, List<AdditionalCardInfo>> permanentEffectsOnChoice;
    private static Map<String, List<AdditionalCardInfo>> permanentEffectsNotSelectable;
    private static Map<String, EndGameRewardsModifier> thirdPeriodExcommunicationModifiers;

    public static void initializeMaps() {
        flashEffectsOnChoice = new HashMap<>();
        flashEffectsNotSelectable = new HashMap<>();
        permanentEffectsOnChoice = new HashMap<>();
        permanentEffectsNotSelectable = new HashMap<>();
        thirdPeriodExcommunicationModifiers = new HashMap<>();
    }

    public static Map<String, List<AdditionalCardInfo>> getFlashEffectsOnChoice() {
        return flashEffectsOnChoice;
    }

    public static void setFlashEffectsOnChoice(Map<String, List<AdditionalCardInfo>> flashEffectsOnChoice) {
        AdditionalInfoMaps.flashEffectsOnChoice = flashEffectsOnChoice;
    }

    public static Map<String, List<AdditionalCardInfo>> getFlashEffectsNotSelectable() {
        return flashEffectsNotSelectable;
    }

    public static void setFlashEffectsNotSelectable(Map<String, List<AdditionalCardInfo>> flashEffectsNotSelectable) {
        AdditionalInfoMaps.flashEffectsNotSelectable = flashEffectsNotSelectable;
    }

    public static Map<String, List<AdditionalCardInfo>> getPermanentEffectsOnChoice() {
        return permanentEffectsOnChoice;
    }

    public static void setPermanentEffectsOnChoice(Map<String, List<AdditionalCardInfo>> permanentEffectsOnChoice) {
        AdditionalInfoMaps.permanentEffectsOnChoice = permanentEffectsOnChoice;
    }

    public static Map<String, List<AdditionalCardInfo>> getPermanentEffectsNotSelectable() {
        return permanentEffectsNotSelectable;
    }

    public static void setPermanentEffectsNotSelectable(Map<String, List<AdditionalCardInfo>> permanentEffectsNotSelectable) {
        AdditionalInfoMaps.permanentEffectsNotSelectable = permanentEffectsNotSelectable;
    }

    public static Map<String, EndGameRewardsModifier> getThirdPeriodExcommunicationModifiers() {
        return thirdPeriodExcommunicationModifiers;
    }

    public static void setThirdPeriodExcommunicationModifiers(Map<String, EndGameRewardsModifier> thirdPeriodExcommunicationModifiers) {
        AdditionalInfoMaps.thirdPeriodExcommunicationModifiers = thirdPeriodExcommunicationModifiers;
    }
}
