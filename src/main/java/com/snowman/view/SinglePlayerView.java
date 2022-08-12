package com.snowman.view;

import java.util.HashSet;
import java.util.Set;

public class SinglePlayerView {

  private Set<String> triedWords;
  private String currentVisible;
  private int remainingGuess;

  public void updateCurrentState(Set<String> triedWords, String currentVisible, int remainingGuess) {
    this.triedWords = triedWords;
    this.currentVisible = currentVisible;
    this.remainingGuess = remainingGuess;
  }

  public void displayCurrentState() {
    System.out.println(triedWords);
    System.out.println(currentVisible);
    System.out.println(remainingGuess);
  }

}
