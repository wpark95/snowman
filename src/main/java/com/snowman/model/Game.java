package com.snowman.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the state of a game of Snowman in single-player mode. This class acts as the model
 * component (MVC) for its controller {@link com.snowman.controller.SinglePlayer}.
 */
public class Game {

  private final Set<String> triedGuesses;

  private String secretWord;
  private String currentGuessState;
  private int remainingGuess;
  private boolean isOver;

  /**
   * Initializes an instance of {@link Game}.
   * <p>Initially, there is not tried guesses to track and therefore <code>triedGuesses</code> is
   * empty.</p>
   */
  public Game() {
    triedGuesses = new HashSet<>();
  }

  /**
   * Sets up the initial state of the game using the user preference (i.e., number of guesses and
   * length of the secret word), and sets up the initial state of guess and the secret word.
   *
   * @param initialGuess Initial guess that represents the state of initial guess, using underscores.
   * @param randomWord A randomly selected secret word.
   */
  public void setInitial(int initialGuess, String randomWord) {
    setRemainingGuess(initialGuess);
    setSecretWord(randomWord);
    setCurrentGuessState("_".repeat(randomWord.length()));
  }

  /**
   * Checks if the current guess was tried in this game in its history.
   *
   * @param guess User's current guess.
   * @return Returns true if the current guess is a duplicate one, otherwise returns false.
   */
  public boolean isDuplicateGuess(String guess) {
    boolean result = false;
    if (triedGuesses.contains(guess)) {
      result = true;
    } else {
      triedGuesses.add(guess);
    }
    return result;
  }

  /**
   * Evaluates the user's current guess by checking if it is a correct guess (i.e., the correct word
   * or a correct letter that the secret word includes) and returns the result of the evaluation.
   *
   * @param guess User's current guess.
   * @return Returns true if the current guess is a correct one, otherwise returns false.
   */
  public boolean evaluateGuess(String guess) {
    boolean result = false;
    if (guess.length() > 1) {
      if (guess.equals(secretWord)) {
        setCurrentGuessState(guess);
        result = true;
      } else {
        setRemainingGuess(remainingGuess - 1);
      }
    } else {
      if (getSecretWord().contains(guess)) {
        setCurrentGuessState(updateGuessState(guess, getSecretWord()));
        result = true;
      } else {
        setRemainingGuess(remainingGuess - 1);
      }
    }
    return result;
  }

  /**
   * Updates the current state of guess for this game (represented by underscores and letters) that
   * is used to compare user's guesses and the secret word when the user enters a correct letter.
   *
   * @param guess User's current guess that is a letter.
   * @param secretWord The secret word used during the duration of this game.
   * @return New guess state for this game.
   */
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

  /**
   * Updates the end status of current game (i.e., if the game is over or needs to keep playing).
   */
  public void updateIsOver() {
    if (currentGuessState.equals(getSecretWord())) {
      setOver(true);
    }
    if (getRemainingGuess() == 0) {
      setOver(true);
    }
  }

  /**
   * Checks the result of the game and returns that result.
   *
   * @return The result of checking if the user has won or not.
   */
  public boolean hasWon() {
    if (currentGuessState.equals(getSecretWord())) {
      return true;
    }
    return false;
  }

  // Getter and Setter Methods
  public Set<String> getTriedGuesses() {
    return triedGuesses;
  }

  public String getSecretWord() {
    return secretWord;
  }

  private void setSecretWord(String secretWord) {
    this.secretWord = secretWord;
  }

  public String getCurrentGuessState() {
    return currentGuessState;
  }

  private void setCurrentGuessState(String currentGuessState) {
    this.currentGuessState = currentGuessState;

  }

  public int getRemainingGuess() {
    return remainingGuess;
  }

  private void setRemainingGuess(int remainingGuess) {
    this.remainingGuess = remainingGuess;
  }

  public boolean isOver() {
    return isOver;
  }

  private void setOver(boolean over) {
    isOver = over;
  }

}
