package com.snowman.view;

import java.util.HashSet;
import java.util.Set;

public class SinglePlayerView {

  private Set<String> triedWords;
  private String currentGuessState;
  private String snowman;
  private int remainingGuess;

  public void updateCurrentState(Set<String> triedWords, String currentGuessState, int remainingGuess) {
    setTriedWords(triedWords);
    setCurrentGuessState(currentGuessState);
    setRemainingGuess(remainingGuess);
    //TODO: Add snowman
  }

  public void displayCurrentState() {
    System.out.println(getTriedWords());
    System.out.println(getCurrentGuessState());
    System.out.println(getRemainingGuess());
  }


  public Set<String> getTriedWords() {
    return triedWords;
  }

  public void setTriedWords(Set<String> triedWords) {
    this.triedWords = triedWords;
  }

  public String getCurrentGuessState() {
    return currentGuessState;
  }

  public void setCurrentGuessState(String currentGuessState) {
    this.currentGuessState = currentGuessState;
  }

  public String getSnowman() {
    return snowman;
  }

  public void setSnowman(String snowman) {
    this.snowman = snowman;
  }

  public int getRemainingGuess() {
    return remainingGuess;
  }

  public void setRemainingGuess(int remainingGuess) {
    this.remainingGuess = remainingGuess;
  }

}
