package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shoe {

  private List<Card> cards;
  private Random rng;
  private List<Card> dealt;

  public Shoe(Iterable<Deck> decks, Random rng) {
    dealt = new LinkedList<>();
    cards = new ArrayList<>();

    for (Deck deck : decks) {
      while (deck.deal() != null)
        cards.add(deck.deal());

      break;
    }
    this.rng = rng;
  }

  public void shuffle() {
    cards.addAll(dealt);
    dealt.clear();
    Collections.shuffle(cards, rng);
  }

  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

}

/*



For each Deck in the decks parameter,


Repeatedly do the following (hint: consider using a while (true) loop):


Draw a Card from the current Deck.
If the Card drawn is non-null, add it to the list referenced by the cards field; otherwise, break out of this loop.


Set the rng field to refer to the value of the rng parameter.


A public method named shuffle, with return type void, and no parameters, that does the following:


Add the contents of dealt to cards.
Clear the contents of dealt.
Shuffle the contents of the cards field, using the rng field as a source of randomness.


A public method named deal, with return type Card, and no parameters, that does the following:


Removes the first item of the cards list, assigning it to a local variable.
If the value of the removed Card is not null, add it to the dealt list.
Return the value of the local variable.

Hint: Some of the above behavior (esp. in the deal and shuffle methods) is identical (or nearly so) to the corresponding behavior of the Deck class.

 */