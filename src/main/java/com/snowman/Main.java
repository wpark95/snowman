package com.snowman;

import com.snowman.controller.MultiPlayer;
import com.snowman.controller.SinglePlayer;
import com.snowman.model.Game;
import com.snowman.model.WordListProcessor;
import com.snowman.view.Messages;
import com.snowman.view.SinglePlayerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Implements entry point for console-mode implementation of <strong>Snowman</strong> game.
 */
public class Main {

  private static final String BUNDLE_NAME = "strings";
  private static boolean isInitialRun = true;

  /**
   * @param args Command-line arguments.
   * @throws IOException Thrown if an I/O error is produced by failed or interrupted I/O
   *                     operations.
   */
  public static void main(String[] args) {
    ResourceBundle stringBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    WordListProcessor words = new WordListProcessor();
    String gameModePrompt = stringBundle.getString("game_mode");
    welcomeInitialRun(Messages.WELCOME_MESSAGE);

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ) {
      label:
      do {
        String gameMode = promptGameMode(reader, gameModePrompt);
        switch (gameMode) {
          case "1":
            Game game = new Game();
            SinglePlayerView view = new SinglePlayerView();
            SinglePlayer player = new SinglePlayer(game, view, words, stringBundle, reader);
            player.play();
            break;
          case "2":
            new MultiPlayer();
            break;
          case "q":
            break label;
        }
      } while (true);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void welcomeInitialRun(String welcomeMessage) {
    if (isInitialRun) {
      System.out.println(welcomeMessage);
      isInitialRun = false;
    }
  }

  private static String promptGameMode(BufferedReader reader, String prompt) throws IOException {
    System.out.println(prompt);
    return reader.readLine().trim();
  }

}