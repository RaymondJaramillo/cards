package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Card;
import edu.cnm.deepdive.model.Deck;
import edu.cnm.deepdive.model.Suit.Color;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Encapsulates a {@link Random} card from {@link Deck} and place a card into either {@link List}
 * redPile or blackPile based on what color the {@link Random} card is.
 */
public class Trick {

  private Deck deck;
  private List<Card> redPile;
  private List<Card> blackPile;
  private Random rng = new SecureRandom();

  /**
   * Assigns Trick and gives it different abilities with the prepare, split, swap, and report.
   * @param args Main arg for method.
   */
  public static void main(String[] args) {
    Trick trick = new Trick();
    trick.prepare();
    trick.split();
    trick.swap();
    trick.report();
  }

  /**
   * This method will take a {@link Deck} and shuffle it.
   */
  private void prepare() {
    deck = new Deck();
    deck.shuffle(rng);
  }

  /**
   * Takes the cards that have been shuffled and splits them by color based on random card color picked.
   */
  private void split() {
    redPile = new LinkedList<>();
    blackPile = new LinkedList<>();
    for (Card selector = deck.deal(); selector != null; selector = deck.deal()) {
      if (selector.getSuit().color() == Color.BLACK) {
        blackPile.add(deck.deal());
      } else {
        redPile.add(deck.deal());
      }
    }
  }

  /**
   * Takes the two piles of cards that were sorted and based on a {@link Random} number takes a certain
   * number of card from each pile and swaps them.
   */
  private void swap() {
    int swapSize = rng.nextInt(1 + Math.min(blackPile.size(), redPile.size()));
    for (int i = 0; i < swapSize; i++) {
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }
  }

  /**
   * Takes the amount of cards that were counted from each pile and displays them to user.
   */
  private void report() {
    int redCount = 0;
    int blackCount = 0;
    for (Card c : redPile) {
      if (c.getSuit().color() == Color.RED) {
        redCount++;
      }
    }
    for (Card c : blackPile) {
      if (c.getSuit().color() == Color.BLACK) {
        blackCount++;
      }
    }
    System.out.printf("Red pile: %s. Red count: %d.%n", redPile, redCount);
    System.out.printf("Black pile: %s. Black count: %d.%n", blackPile, blackCount);
  }

}