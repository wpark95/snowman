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
    setRemainingGuess(initialGuess);
    setSecretWord(randomWord);
    setCurrentGuessState("_".repeat(randomWord.length()));
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

  public void evaluateGuess(String guess) {
    if (guess.length() > 1) { // If the guess is a word
      if (guess.equals(secretWord)) {
        setCurrentGuessState(guess);
      } else {
        setRemainingGuess(remainingGuess - 1);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nOh no! I'm melting!");
      }
    } else { // If the guess is a letter
      if (getSecretWord().contains(guess)) {
        setCurrentGuessState(updateGuessState(guess, getSecretWord()));
      } else {
        setRemainingGuess(remainingGuess - 1);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nOh no! I'm melting!");
      }
    }
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nGreat job!");
      }
    }
    return newGuessState;
  }

  public void updateIsOver() {
    if (currentGuessState.equals(getSecretWord())) {
      setOver(true);
    }
    if (getRemainingGuess() == 0) {
      setOver(true);
    }
  }

  public boolean hasWon() {
    if (currentGuessState.equals(getSecretWord())) {
      return true;
    }
    return false;
  }

  // Getter and Setter Methods
  public Set<String> getTriedWords() {
    return triedWords;
  }

  public String getSecretWord() {
    return secretWord;
  }

  public void setSecretWord(String secretWord) {
    this.secretWord = secretWord;
  }

  public String getCurrentGuessState() {
    return currentGuessState;
  }

  public void setCurrentGuessState(String currentGuessState) {
    this.currentGuessState = currentGuessState;

  }

  public int getRemainingGuess() {
    return remainingGuess;
  }

  public void setRemainingGuess(int remainingGuess) {
    this.remainingGuess = remainingGuess;
  }

  public boolean isOver() {
    return isOver;
  }

  public void setOver(boolean over) {
    isOver = over;
  }

}
