package com.snowman.controller;

import com.snowman.model.Game;
import com.snowman.model.WordListProcessor;
import com.snowman.view.SinglePlayerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Controls the flow of a single-player game by prompting and taking in user-inputs and controlling
 * the flow of user-inputs and data between its view {@link SinglePlayerView} and
 * model{@link Game}.
 */
public class SinglePlayer {

  // Class Constants
  public static final int DEFAULT_MAX_GUESS = 30;
  public static final int DEFAULT_MIN_GUESS = 1;
  public static final int DEFAULT_MAX_WORD_LENGTH = 15;
  public static final int DEFAULT_MIN_WORD_LENGTH = 4;

  private final Game game;
  private final SinglePlayerView view;
  private final ResourceBundle bundle;
  private final WordListProcessor words;
  private final BufferedReader reader;

  /**
   * Initializes an instance of {@link SinglePlayer}, using the provided model {@link Game}, view
   * {@link SinglePlayerView}, {@link WordListProcessor}, {@link ResourceBundle}, and reader
   * {@link BufferedReader}.
   *
   * @param game   An instance of {@link Game} that acts as the model (MVC) for its controller
   *               {@link SinglePlayer}.
   * @param view   An instance of {@link SinglePlayerView} that acts as the view (MVC) for its
   *               controller {@link SinglePlayer}.
   * @param words  An instance of {@link WordListProcessor} that can read in a list of words (.csv
   *               file) and can generate a random word.
   * @param bundle {@link ResourceBundle}
   * @param reader {@link BufferedReader} used to read in user-inputs.
   */
  public SinglePlayer(Game game, SinglePlayerView view, WordListProcessor words,
      ResourceBundle bundle, BufferedReader reader) {
    this.game = game;
    this.view = view;
    this.bundle = bundle;
    this.words = words;
    this.reader = reader;
  }

  /**
   * Plays a game of Snowman for single-player until the user guesses the secret word correctly or
   * until they are out of guesses.
   */
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

  /**
   * Sets up this controller's model {@link Game} according to user's initial game preferences. For
   * further details, please refer to <code>getWordLengthPreference</code> method and
   * <code>getGuessNumPreference</code> method.
   */
  public void getInitialSetup() {
    String wordLengthPreferencePrompt = bundle.getString("word_length_preference");
    String guessNumPreferencePrompt = bundle.getString("guess_num_preference");
    int wordLength = getWordLengthPreference(wordLengthPreferencePrompt);
    int initialGuess = getGuessNumPreference(guessNumPreferencePrompt);
    String randomWord = words.wordChoice(wordLength);
    game.setInitial(initialGuess, randomWord);
  }

  /**
   * Prompts the user to enter their guess and returns a cleansed version of their guess so that it
   * is case-insensitive (all lower-case) and trimmed (no surrounding white-spaces).
   * <p>This method prompts the user to enter a guess until they enter a valid guess (either an
   * English alphabet or a word comprised of the English alphabet). Then it converts the user input
   * to be all lower-cases and remove surrounding whitespaces and returns it.</p>
   *
   * @return User input converted to be all-lower-cases and trimmed.
   */
  public String getUserGuess() {
    boolean isValidInput;
    String userInput;

    do {
      try {
        System.out.println(bundle.getString("make_guess"));
        userInput = reader.readLine().toLowerCase().trim();
        isValidInput = userInput.matches("[a-zA-Z]+");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } while (!isValidInput);
    return userInput;
  }

  /**
   * Prompts the user to enter their preference for the number of guesses until they enter a valid
   * input and returns it.
   *
   * @param guessNumPreferencePrompt A prompt that asks the user to enter their preference.
   * @return Returns an integer that represents the user's preference for the number of guesses.
   */
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

  /**
   * Prompts the user to enter their preference for the length of the mystery word until they enter
   * a valid input and returns it.
   *
   * @param wordLengthPreferencePrompt A prompt that asks the user to enter their preference.
   * @return Returns an integer that represents the user's preference for word-length.
   */
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

  /**
   * Modifies and returns an integer representing user's preference for word-length.
   *
   * @param reader {@link BufferedReader} used to take in user-input.
   * @param prompt A prompt that prompts the user to enter their preference.
   * @return Number (integer) representing user preference for word-length.
   * @throws IOException           Thrown if errors or interruptions occur during I/O operations.
   * @throws NumberFormatException Thrown if converting a string to a numeric type results in
   *                               not having the appropriate format.
   */
  private int promptUserWordLength(BufferedReader reader, String prompt)
      throws IOException, NumberFormatException {
    System.out.println(prompt);
    String userInput = reader.readLine().trim();
    return Integer.parseInt(userInput);
  }

  /**
   * Modifies and returns an integer representing user's preference for the number of guesses.
   *
   * @param reader {@link BufferedReader} used to take in user-input.
   * @param prompt A prompt that prompts the user to enter their preference.
   * @return Number (integer) representing user preference for number of guesses.
   * @throws IOException           Thrown if errors or interruptions occur during I/O operations.
   * @throws NumberFormatException Thrown if converting a string to a numeric type results in
   *                               not having the appropriate format.
   */
  private int promptUserGuess(BufferedReader reader, String prompt)
      throws IOException, NumberFormatException {
    System.out.println(prompt);
    String userInput = reader.readLine().trim();
    return Integer.parseInt(userInput);
  }

  /**
   * Updates view {@link SinglePlayerView} (MVC) for this controller.
   */
  private void updateView() {
    view.updateCurrentState(game.getTriedWords(), game.getCurrentGuessState(), game.getSecretWord(),
        game.getRemainingGuess());
  }

}