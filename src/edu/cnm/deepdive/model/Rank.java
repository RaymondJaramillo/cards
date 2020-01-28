package edu.cnm.deepdive.model;

/**
 * Encapsulates all of the rank values used in standard playing cards. This
 * {@code enum} also defines a {@link #symbol()} method that returns the 1-
 * or 2-character shorthand abbreviation used in card play notation for each
 * of its enumerated values.
 */
public enum Rank {
  ACE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  JACK,
  QUEEN,
  KING;

  private static final String[] symbols = {
      "A",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "10",
      "J",
      "Q",
      "K"
  };

  public String symbol() {
    return symbols[ordinal()];
  }
}
