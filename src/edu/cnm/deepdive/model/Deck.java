package edu.cnm.deepdive.model;

import java.security.SecureRandom;
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


  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  public void shuffle(Random rng) {
    cards.addAll(dealt);
    dealt.clear();
    Collections.shuffle(cards, rng);
  }

  public int remaining() {
    return cards.size();
  }

  public int dealt() {
    return dealt.size();
  }
  @Override
  public String toString() {
    return cards.toString();
  }
}


