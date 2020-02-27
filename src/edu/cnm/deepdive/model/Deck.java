package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Encapsulates amount of cards by counting the amount of cards in a {@link Deck} and the amount of cards that have been dealt.
 */
public class Deck {

  private List<Card> cards;
  private List<Card> dealt;

  /**
   * This counts the cards in a {@link Deck} to make sure that there are 52.
   */
  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

  /**
   * Method will deal cards until {@link Deck} is empty and it is verified that there is 52 cards.
   * @return Returns cards until there are no more cards to deal.
   */
  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  /**
   * Method dealt cards and shuffles them
   * @param rng helps to suffle cards
   */
  public void shuffle(Random rng) {
    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    cards.addAll(dealt);
    dealt.clear();
  }

  /**
   * @return Will return the amount of cards counted in original {@link Deck}.
   */
  public int remaining() {
    return cards.size();
  }

  /**
   * @return Will return the amount of cards after being dealt to make sure they are the same as
   * started with.
   */
  public int dealt() {
    return dealt.size();
  }
  @Override
  public String toString() {
    return cards.toString();
  }

  public void sort(boolean gather) {
    if (gather) {
      gather();
    }
    // Comparator in the parameter
    cards.sort((card1, card2) -> {
      int result = card1.getSuit().compareTo(card2.getSuit());
      if (result == 0) {
        result = card1.getRank().compareTo(card2.getRank());
      }
      return result;
    });
  }
}


