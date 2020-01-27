package edu.cnm.deepdive.model;

import java.util.Objects;

/**
 * Encapsulates a single playing card as a combination of {@link Suit} and {@link Rank}. instances
 * of this class are immutable.
 *
 * @author Raymond Jaramillo
 */
public class Card {


  private final Suit suit;
  private final Rank rank;
  private final int hash;

  /**
   * Initializes the Card instance with the specified {@link Suit} and {@link Rank}.
   * @param suit {@link Suit} value of Card
   * @param rank {@link Rank} value of Card
   */
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash(suit, rank);
  }

  /**
   * Returns {@link Suit} of this Card instance.
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns {@link Rank} of this Card instance.
   */
  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean comparison = false;
    if (obj == this) {
      comparison = true;
    } else if (obj instanceof Card && obj.hashCode() == hash) {
      Card other = (Card) obj;
      if (suit == ((Card) obj).suit && rank == ((Card)obj).rank);
        comparison = true;
    }
    return comparison;
  }

}
