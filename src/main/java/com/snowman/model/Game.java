package com.snowman.model;

import java.util.HashSet;
import java.util.Set;

public class Game {

  private final Set<String> triedWords;
  private String secretWord;
  private String currentGuessState;

  private int remainingGuess;

  private boolean isOver;

  public Game() {
    triedWords = new HashSet<>();
  }

  public void setInitial(int initialGuess, String randomWord) {
    remainingGuess = initialGuess;
    secretWord = randomWord;
    currentGuessState = "_".repeat(randomWord.length());
  }

  public boolean isDuplicateGuess(String guess) {
    boolean result = false;
    if (triedWords.contains(guess)) {
      result = true;
    } else {
      triedWords.add(guess);
    }
    return result;
  }

  public boolean evaluateGuess(String guess) {
    boolean result = false;

    if (guess.length() > 1) { // If the guess is a word
      if (guess.equals(secretWord)) {
        setCurrentGuessState(secretWord);
        result = true;
      } else {
        remainingGuess--;
      }
    } else { // If the guess is a letter
      if (secretWord.contains(guess)) {
        setCurrentGuessState(updateGuessState(guess, secretWord));
        result = true;
      } else {
        remainingGuess--;
      }
    }
    return result;
  }

  private String updateGuessState(String guess, String secretWord) {
    String newGuessState = getCurrentGuessState();
    char userLetter = guess.charAt(0);

    for (int i = 0; i < secretWord.length(); i++) {
      char currChar = secretWord.charAt(i);
      if (currChar == userLetter) {
        char[] chars = newGuessState.toCharArray();
        chars[i] = userLetter;
        newGuessState = String.valueOf(chars);
      }
    }
    return newGuessState;
  }

  public void updateIsOver() {
    if (currentGuessState.equals(secretWord)) {
      setOver(true);
    }
    if (remainingGuess == 0) {
      setOver(true);
    }
  }

  public boolean hasWon() {
    if (currentGuessState.equals(secretWord)) {
      return true;
    }
    return false;
  }

  public boolean isOver() {
    return isOver;
  }

  public void setOver(boolean over) {
    isOver = over;
  }

  public String getCurrentGuessState() {
    return currentGuessState;
  }

  public void setCurrentGuessState(String currentGuessState) {
    this.currentGuessState = currentGuessState;
  }

}
