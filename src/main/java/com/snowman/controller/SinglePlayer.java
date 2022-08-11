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

  public static final int DEFAULT_MAX_GUESS = 30;
  public static final int DEFAULT_MIN_GUESS = 1;
  public static final int DEFAULT_MAX_WORD_LENGTH = 15;
  public static final int DEFAULT_MIN_WORD_LENGTH = 4;
  public String userInput;

  private final Game game;

  public SinglePlayer(BufferedReader reader, WordListProcessor words, ResourceBundle bundle)
      throws IOException {
    String wordLengthPreferencePrompt = bundle.getString(Keys.WORD_LENGTH_PREFERENCE);
    String guessNumPreferencePrompt = bundle.getString(Keys.GUESS_NUM_PREFERENCE);

    int userWordLengthCount = 0;
    do {
      try {
        userWordLengthCount = promptUserWordLength(reader, wordLengthPreferencePrompt);
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (NumberFormatException e) {
        //ignore exception
      }
    } while (userWordLengthCount < DEFAULT_MIN_WORD_LENGTH || userWordLengthCount > DEFAULT_MAX_WORD_LENGTH);
    int wordLength = userWordLengthCount;

    int userGuessCount = 0;
    do {
      try {
        userGuessCount = promptUserGuess(reader, guessNumPreferencePrompt);
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (NumberFormatException e) {
        //ignore exception
      }
    } while (userGuessCount < DEFAULT_MIN_GUESS || userGuessCount > DEFAULT_MAX_GUESS);
    int remainingGuess = userGuessCount;

    game = new Game(new HashSet<>(), wordLength, remainingGuess, words.wordChoice(wordLength),
        reader);
    game.play();
  }

  private int promptUserWordLength(BufferedReader reader, String prompt)
      throws IOException, NumberFormatException {
    System.out.println(prompt);
    userInput = reader.readLine().trim();
    return Integer.parseInt(userInput);
  }

  private int promptUserGuess(BufferedReader reader, String prompt)
      throws IOException, NumberFormatException {
    System.out.println(prompt);
    userInput = reader.readLine().trim();
    return Integer.parseInt(userInput);
  }

}