package edu.cnm.deepdive.model;

import java.util.LinkedList;
import java.util.List;

public class Hand {

  private List<Card> cards;

  public Hand() {
    cards = new LinkedList<>();
  }

  public void add(Card card) {
    cards.add(card);
  }
}

/*
A private field named cards, of the type List<Card>.


This field should be initialized (using either declaration-with-assignment or a constructor) to an empty LinkedList.



A public method named add, taking a Card as a parameter.


Implement this method so that when invoked, the specified Card instance is added to the list referenced by the cards field.


 */