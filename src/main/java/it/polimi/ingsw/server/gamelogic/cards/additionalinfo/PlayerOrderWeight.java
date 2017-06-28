package it.polimi.ingsw.server.gamelogic.cards.additionalinfo;

import it.polimi.ingsw.server.gamelogic.cards.CardVisitor;

import java.util.Objects;

/**
 * TODO: JavaDoc
 */
public class PlayerOrderWeight extends AdditionalCardInfo {
    private int weight;

    public PlayerOrderWeight(String name, int weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        PlayerOrderWeight that = (PlayerOrderWeight) o;
        return weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public void acceptCardVisitor(CardVisitor cardVisitor) {
        cardVisitor.visitAdditionalCardInfo(this);
    }
}