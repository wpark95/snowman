package com.snowman.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameTest {

  Game game = new Game();

  public static List<Arguments> setInitial() {
    return List.of(
        Arguments.of(
            1, "word",
            2, "fire",
            3, "howl",
            4, "asparagus",
            5, "fan",
            6, "package",
            7, "hollow",
            15, "battle",
            21, "wallet",
            30, "panama"
        )
    );
  }

  public static List<Arguments> wordsSupplier() {
    return List.of(
        Arguments.of(
            "word",
            "fire",
            "howl",
            "asparagus",
            "fan",
            "package",
            "hollow",
            "battle",
            "wallet",
            "panama",
            "guntlet",
            "headphones",
            "firefighter",
            "meat",
            "potato",
            "scissors",
            "science",
            "flag",
            "snowman"
        )
    );
  }

  public static List<Arguments> correctWordLetterSupplier() {
    return List.of(
        Arguments.of(
            "letter", "t",
            "fire", "f",
            "fire", "i",
            "fire", "r",
            "fire", "e",
            "fire", "e",
            "apple", "a",
            "apple", "p",
            "apple", "l",
            "apple", "e",
            "banana", "b",
            "banana", "a",
            "banana", "n"
        )
    );
  }

  public static List<Arguments> incorrectWordLetterSupplier() {
    return List.of(
        Arguments.of(
            "letter", "a",
            "fire", "h",
            "fire", "g",
            "fire", "j",
            "fire", "p",
            "fire", "q",
            "apple", "z",
            "apple", "x",
            "apple", "y",
            "apple", "u",
            "banana", "p",
            "banana", "k",
            "banana", "l"
        )
    );
  }

  public static List<Arguments> correctWordsSupplier() {
    return List.of(
        Arguments.of(
            "letter", "letter",
            "fire", "fire",
            "apple", "apple",
            "banana", "banana",
            "howl", "howl",
            "asparagus", "asparagus",
            "fan", "fan",
            "package", "package",
            "hollow", "hollow",
            "battle", "battle",
            "wallet", "wallet",
            "panama", "panama"
        )
    );
  }

  public static List<Arguments> incorrectWordsSupplier() {
    return List.of(
        Arguments.of(
            "letter", "fire",
            "fire", "letter",
            "apple", "banana",
            "banana", "apple",
            "howl", "asparagus",
            "asparagus", "howl",
            "fan", "naf",
            "package", "hollow",
            "hollow", "hollou",
            "battle", "bottle",
            "wallet", "waltz",
            "panama", "panamaerican"
        )
    );
  }

  @ParameterizedTest
  @MethodSource
  void setInitial(int expectedInitialGuess, String expectedSecretWord) {
    game.setInitial(expectedInitialGuess, expectedSecretWord);
    int actualInitialGuess = game.getRemainingGuess();
    String actualSecretWord = game.getSecretWord();
    String actualGuessState = game.getCurrentGuessState();
    String expectedGuessState = "_".repeat(expectedSecretWord.length());
    assertEquals(expectedInitialGuess, actualInitialGuess);
    assertEquals(expectedSecretWord, actualSecretWord);
    assertEquals(expectedGuessState, actualGuessState);
  }

  @ParameterizedTest
  @MethodSource("wordsSupplier")
  void isDuplicateGuess_duplicates(String expectedDuplicates) {
    game.isDuplicateGuess(expectedDuplicates);
    assertTrue(game.isDuplicateGuess(expectedDuplicates));
  }

  @ParameterizedTest
  @MethodSource("wordsSupplier")
  void isDuplicateGuess_nonDuplicates(String word) {
    assertFalse(game.isDuplicateGuess(word));
  }

  @ParameterizedTest
  @MethodSource("correctWordLetterSupplier")
  void evaluateGuess_validLetters(String secretWord, String correctLetter) {
    game.setInitial(10, secretWord);
    assertTrue(game.evaluateGuess(correctLetter));
  }

  @ParameterizedTest
  @MethodSource("incorrectWordLetterSupplier")
  void evaluateGuess_invalidLetters(String secretWord, String incorrectLetter) {
    game.setInitial(10, secretWord);
    assertFalse(game.evaluateGuess(incorrectLetter));
  }

  @ParameterizedTest
  @MethodSource("correctWordsSupplier")
  void evaluateGuess_validWords(String secretWord, String correctWord) {
    game.setInitial(10, secretWord);
    assertTrue(game.evaluateGuess(correctWord));
  }

  @ParameterizedTest
  @MethodSource("incorrectWordsSupplier")
  void evaluateGuess_invalidWords(String secretWord, String incorrectWord) {
    game.setInitial(10, secretWord);
    assertFalse(game.evaluateGuess(incorrectWord));
  }

  @ParameterizedTest
  @MethodSource("wordsSupplier")
  void updateIsOver_userWins(String expectedCorrectWord) {
    game.setInitial(10, expectedCorrectWord);
    game.evaluateGuess(expectedCorrectWord);
    game.updateIsOver();
    assertTrue(game.isOver());
  }

  @ParameterizedTest
  @MethodSource("incorrectWordsSupplier")
  void updateIsOver_userLoses(String secretWord, String expectedIncorrectWord) {
    game.setInitial(1, secretWord);
    game.evaluateGuess(expectedIncorrectWord);
    game.updateIsOver();
    assertTrue(game.isOver());
  }

  @ParameterizedTest
  @MethodSource("wordsSupplier")
  void hasWon_userWins(String expectedCorrectWord) {
    System.out.println(expectedCorrectWord);
    game.setInitial(30, expectedCorrectWord);
    game.evaluateGuess(expectedCorrectWord);
    assertEquals(expectedCorrectWord, game.getCurrentGuessState());
    assertTrue(game.hasWon());
  }

  @ParameterizedTest
  @MethodSource("incorrectWordsSupplier")
  void hasWon_userLoses(String secretWord, String expectedCorrectWord) {
    game.setInitial(1, secretWord);
    game.evaluateGuess(expectedCorrectWord);
    assertEquals(expectedCorrectWord, game.getCurrentGuessState());
    assertFalse(game.hasWon());
  }

}