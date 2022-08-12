package com.snowman.view;

import java.util.Set;

/**
 * Represents the data to be displayed to the user in single-player mode. This class acts as the
 * view component (MVC) for its controller {@link com.snowman.controller.SinglePlayer}.
 */
public class SinglePlayerView {

  private Set<String> triedWords;
  private String currentGuessState;
  private String snowman;
  private String secretWord;
  private int remainingGuess;

  /**
   * Updates the current status of a single-player Snowman game that is visible to the user.
   *
   * @param triedWords        Words (or letters) that the user has tried in the past in this game.
   * @param currentGuessState Current state of guess for the game, represented using underscores and
   *                          the English alphabet.
   * @param secretWord        The secret word that the user has to guess to win the game and is
   *                          displayed at the end of a game.
   * @param remainingGuess    The number of remaining guesses for the user.
   */
  public void updateCurrentState(Set<String> triedWords, String currentGuessState,
      String secretWord, int remainingGuess) {
    setTriedWords(triedWords);
    setCurrentGuessState(currentGuessState);
    setRemainingGuess(remainingGuess);
    setSecretWord(secretWord);
  }

  /**
   * Displays the result of the user's current attempted guess.
   *
   * @param isRight Represents if the user has attempted a correct guess or not.
   */
  public void displayGuessResult(boolean isRight) {
    if (isRight) {
      System.out.println(Messages.ANSI_GREEN + "\n\n\nGreat job, you are keeping me cold!\n"
          + Messages.ANSI_RESET);
    } else {
      System.out.println(Messages.ANSI_RED
          + "\n\n\nReally, Nick Bennett? You are going to let me melt like this?\n"
          + Messages.ANSI_RESET);
    }
  }

  /**
   * Displays the current status of guess for the game, represented using underscores and
   * the English alphabet.
   */
  public void displayCurrentState() {
    System.out.println(
        "Your remaining guesses: "
            + getRemainingGuess());
    System.out.println("You have tried so far: " + getTriedWords());
    System.out.println("Mystery word : " + getCurrentGuessState());
    printSnowman(getRemainingGuess());
  }

  /**
   * Displays an appropriate snowman according to the current state of the game.
   *
   * @param remainingGuess
   */
  public static void printSnowman(int remainingGuess) {
    switch (remainingGuess) {
      case 1:
        printHalfSnowman();
        break;
      case 2:
        printTopBodyOnlySnowman();
        break;
      case 3:
        printNeutralSnowman();
        break;
      default:
        printHappySnowman();
        break;
    }
  }

  /**
   * Displays the final result of the current (now-past) game and the secret word at the end
   * of a game.
   *
   * @param hasWon Represents whether the user won the game or lost.
   * @param secretWord The secret word that the user had to guess for this current (now-past) game.
   */
  public void printGameResult(boolean hasWon, String secretWord) {
    if (hasWon) {
      printWinMessage(secretWord);
    } else {
      printLoseMessage(secretWord);
    }
  }

  /**
   * Displays a happy and healthy snowman.
   */
  private static void printHappySnowman() {
    printHat();
    System.out.println(Messages.HAPPY_FACE);
    printBody();
  }

  /**
   * Displays a healthy but not happy (maybe a little bit nervous) snowman.
   */
  private static void printNeutralSnowman() {
    printHat();
    System.out.println(Messages.NEUTRAL_FACE);
    printBody();
  }

  /**
   * Displays an upper-body of a snowman.
   */
  private static void printTopBodyOnlySnowman() {
    printHalfSnowman();
    System.out.println(Messages.BODY_TOP);
  }

  /**
   * Displays an unhealthy snowman with only its sad face and hat left.
   */
  private static void printHalfSnowman() {
    printHat();
    System.out.println(Messages.SAD_FACE);
  }

  /**
   * Displays the hat of a snowman.
   */
  private static void printHat() {
    System.out.println(Messages.HAT_TOP);
    System.out.println(Messages.HAT_LOW);
  }

  /**
   * Displays an entire body of a snowman.
   */
  private static void printBody() {
    System.out.println(Messages.BODY_TOP);
    System.out.println(Messages.BODY_LOW);
  }

  /**
   * Prints the winning message for a single-player game of Snowman.
   * @param secretWord The word that the user had to guess for the current (now-past) game.
   */
  public static void printWinMessage(String secretWord) {
    System.out.println(Messages.WIN_MESSAGE + secretWord);
  }

  /**
   * Prints the losing message for a single-player game of Snowman.
   * @param secretWord The word that the user had to guess for the current (now-past) game.
   */
  public static void printLoseMessage(String secretWord) {
    System.out.println(Messages.LOSE_MESSAGE + secretWord);
  }

  // Getter and Setter methods
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

  public void setSecretWord(String secretWord) {
    this.secretWord = secretWord;
  }

  public int getRemainingGuess() {
    return remainingGuess;
  }

  public void setRemainingGuess(int remainingGuess) {
    this.remainingGuess = remainingGuess;
  }

}
