package com.snowman;

import com.snowman.controller.MultiPlayer;
import com.snowman.controller.SinglePlayer;
import com.snowman.model.WordListProcessor;
import com.snowman.view.MessagePrinter;
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
    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    WordListProcessor words = new WordListProcessor();
    String gameModePrompt = bundle.getString("game_mode");

    welcomeInitialRun();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ) {
      label:
      do {
        String gameMode = promptGameMode(reader, gameModePrompt);
        switch (gameMode) {
          case "1":
            new SinglePlayer(reader, words, bundle);
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

  private static void welcomeInitialRun() {
    if (isInitialRun) {
      MessagePrinter.printWelcomeMessage();
      isInitialRun = false;
    }
  }

  private static String promptGameMode(BufferedReader reader, String prompt) throws IOException {
    System.out.println(prompt);
    return reader.readLine().trim();
  }

}