package com.snowman.controller;

import com.snowman.model.Game;
import com.snowman.model.WordListProcessor;
import com.snowman.view.SinglePlayerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ResourceBundle;

public class SinglePlayer {

  public static final int DEFAULT_MAX_GUESS = 30;
  public static final int DEFAULT_MIN_GUESS = 1;
  public static final int DEFAULT_MAX_WORD_LENGTH = 15;
  public static final int DEFAULT_MIN_WORD_LENGTH = 4;
  public static final String MAKE_GUESS_PROMPT = "To guess the word, enter a letter or a word.";

  private final Game game;
  private final SinglePlayerView view;
  private final ResourceBundle bundle;
  private final WordListProcessor words;
  private final BufferedReader reader;

  public SinglePlayer(Game game, SinglePlayerView view, WordListProcessor words,
      ResourceBundle bundle, BufferedReader reader) {
    this.game = game;
    this.view = view;
    this.bundle = bundle;
    this.words = words;
    this.reader = reader;
  }

  public void play() {
    getInitialSetup();
    while (!game.isOver()) {
      updateView();
      view.displayCurrentState();
      String guess = getUserGuess();
      if (!game.isDuplicateGuess(guess)) {
        boolean isRightGuess = game.evaluateGuess(guess);
        view.displayGuessResult(isRightGuess);
      }
      game.updateIsOver();
    }
    view.printGameResult(game.hasWon(), game.getSecretWord());
  }

  public void getInitialSetup() {
    String wordLengthPreferencePrompt = bundle.getString("word_length_preference");
    String guessNumPreferencePrompt = bundle.getString("guess_num_preference");
    int wordLength = getWordLengthPreference(wordLengthPreferencePrompt);
    int initialGuess = getGuessNumPreference(guessNumPreferencePrompt);
    String randomWord = words.wordChoice(wordLength);
    game.setInitial(initialGuess, randomWord);
  }

  public String getUserGuess() {
    boolean isValidInput;
    String userInput;

    do {
      try {
        System.out.println(MAKE_GUESS_PROMPT);
        userInput = reader.readLine().toLowerCase().trim();
        isValidInput = userInput.matches("[a-zA-Z]+");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } while (!isValidInput);
    return userInput;
  }

  private int getGuessNumPreference(String guessNumPreferencePrompt) {
    int userGuessInput = 0;
    do {
      try {
        userGuessInput = promptUserGuess(reader, guessNumPreferencePrompt);
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (NumberFormatException ignored) {
      }
    } while (userGuessInput < DEFAULT_MIN_GUESS || userGuessInput > DEFAULT_MAX_GUESS);
    return userGuessInput;
  }

  private int getWordLengthPreference(String wordLengthPreferencePrompt) {
    int userWordLengthInput = 0;
    do {
      try {
        userWordLengthInput = promptUserWordLength(reader, wordLengthPreferencePrompt);
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (NumberFormatException ignored) {
      }
    } while (userWordLengthInput < DEFAULT_MIN_WORD_LENGTH
        || userWordLengthInput > DEFAULT_MAX_WORD_LENGTH);
    return userWordLengthInput;
  }

  private int promptUserWordLength(BufferedReader reader, String prompt)
      throws IOException, NumberFormatException {
    System.out.println(prompt);
    String userInput = reader.readLine().trim();
    return Integer.parseInt(userInput);
  }

  private int promptUserGuess(BufferedReader reader, String prompt)
      throws IOException, NumberFormatException {
    System.out.println(prompt);
    String userInput = reader.readLine().trim();
    return Integer.parseInt(userInput);
  }

  private void updateView() {
    view.updateCurrentState(game.getTriedWords(), game.getCurrentGuessState(), game.getSecretWord(),
        game.getRemainingGuess());
  }

}