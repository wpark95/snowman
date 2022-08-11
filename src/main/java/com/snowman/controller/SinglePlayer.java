package com.snowman.controller;

import com.snowman.model.Game;
import com.snowman.model.WordListProcessor;
import com.snowman.view.Keys;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;

public class SinglePlayer {

  public static final String INVALID_WORD_LENGTH =
      "Word length must be between 4 and 15 (inclusive). You entered: %1$d. Please try again.";
  public static final String INVALID_GUESS_NUM =
      "Number of guesses must be between 1 and 30 (inclusive). You entered: %1$d. Please try again.";
  public static final int DEFAULT_MAX_GUESS = 30;
  public static final int DEFAULT_MIN_GUESS = 1;
  public static final int DEFAULT_MAX_WORD_LENGTH = 15;
  public static final int DEFAULT_MIN_WORD_LENGTH = 4;

  private final Game game;

  public SinglePlayer(BufferedReader reader, WordListProcessor words, ResourceBundle bundle, Random rng)
      throws IOException {
    String wordLengthPreferencePrompt = bundle.getString(Keys.WORD_LENGTH_PREFERENCE);
    String guessNumPreferencePrompt = bundle.getString(Keys.GUESS_NUM_PREFERENCE);

    System.out.println(wordLengthPreferencePrompt);
    int wordLength = Integer.parseInt(reader.readLine().trim());
    if (wordLength == 0) {
      wordLength =
          rng.nextInt(DEFAULT_MAX_WORD_LENGTH - DEFAULT_MIN_WORD_LENGTH) + DEFAULT_MIN_WORD_LENGTH;
    } else {
      if (wordLength > DEFAULT_MAX_WORD_LENGTH || wordLength < DEFAULT_MIN_WORD_LENGTH) {
        throw new IllegalArgumentException(String.format(INVALID_WORD_LENGTH, wordLength));
      }
    }

    System.out.println(guessNumPreferencePrompt);
    int remainingGuess = Integer.parseInt(reader.readLine().trim());
    if (remainingGuess == 0) {
      remainingGuess = rng.nextInt(DEFAULT_MAX_GUESS - DEFAULT_MIN_GUESS) + DEFAULT_MIN_GUESS;
    } else {
      if (remainingGuess > DEFAULT_MAX_GUESS || remainingGuess < DEFAULT_MIN_GUESS) {
        throw new IllegalArgumentException(String.format(INVALID_GUESS_NUM, remainingGuess));
      }
    }

    game = new Game(new HashSet<>(), wordLength, remainingGuess, words.wordChoice(wordLength), reader);
    game.play();
  }

}