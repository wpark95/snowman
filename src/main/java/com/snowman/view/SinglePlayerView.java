package com.snowman.view;

import java.util.Set;

public class SinglePlayerView {

  private Set<String> triedWords;
  private String currentGuessState;
  private String snowman;
  private String secretWord;
  private int remainingGuess;

  public void updateCurrentState(Set<String> triedWords, String currentGuessState,
      String secretWord, int remainingGuess) {
    setTriedWords(triedWords);
    setCurrentGuessState(currentGuessState);
    setRemainingGuess(remainingGuess);
    setSecretWord(secretWord);
  }

  public void displayGuessResult(boolean isRight) {
    if (isRight) {
      System.out.println(Messages.ANSI_GREEN + "\n\n\nGreat job, you are keeping me cold!\n" + Messages.ANSI_RESET);
    } else {
      System.out.println(Messages.ANSI_RED + "\n\n\nReally, Nick Bennett? You are going to let me melt like this?\n" + Messages.ANSI_RESET);
    }
  }
  public void displayCurrentState() {
    System.out.println(
        "Your remaining guesses: "
            + getRemainingGuess());
    System.out.println("You have tried so far: " + getTriedWords());
    System.out.println("Mystery word : " + getCurrentGuessState());
    printSnowman(getRemainingGuess());
  }

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

  public void printGameResult(boolean hasWon, String secretWord) {
    if (hasWon) {
      printWinMessage(secretWord);
    } else {
      printLoseMessage(secretWord);
    }
  }

  private static void printHappySnowman() {
    printHat();
    System.out.println(Messages.HAPPY_FACE);
    printBody();
  }

  private static void printNeutralSnowman() {
    printHat();
    System.out.println(Messages.NEUTRAL_FACE);
    printBody();
  }

  private static void printTopBodyOnlySnowman() {
    printHalfSnowman();
    System.out.println(Messages.BODY_TOP);
  }

  private static void printHalfSnowman() {
    printHat();
    System.out.println(Messages.SAD_FACE);
  }

  private static void printHat() {
    System.out.println(Messages.HAT_TOP);
    System.out.println(Messages.HAT_LOW);
  }

  private static void printBody() {
    System.out.println(Messages.BODY_TOP);
    System.out.println(Messages.BODY_LOW);
  }

  public static void printWinMessage(String secretWord) {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println(Messages.WIN_MESSAGE + secretWord);
  }

  public static void printLoseMessage(String secretWord) {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println(Messages.LOSE_MESSAGE + secretWord);
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

  public String getSecretWord() {
    return secretWord;
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
