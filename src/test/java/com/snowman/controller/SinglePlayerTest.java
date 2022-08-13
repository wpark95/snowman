package com.snowman.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.snowman.model.Game;
import com.snowman.model.WordListProcessor;
import com.snowman.view.SinglePlayerView;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.CharBuffer;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SinglePlayerTest {

  private final Game game = new Game();
  private final SinglePlayerView view = new SinglePlayerView();
  private final WordListProcessor words = new WordListProcessor();
  private final ResourceBundle bundle = ResourceBundle.getBundle("strings");
  private final String mockInput = "alpha";
  ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());
  private BufferedReader reader = new BufferedReader(new InputStreamReader(mockInputStream));
  private final SinglePlayer controller = new SinglePlayer(game, view, words, bundle, reader);

  @Test
  void testGetInitialSetup_valid() throws IOException {
    //TODO: Update testGetInitialSetup_valid
    String actualInput = controller.getUserGuess();
    reader.readLine();
    assertEquals(mockInput, actualInput);
  }

}