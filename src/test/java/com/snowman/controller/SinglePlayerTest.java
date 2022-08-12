package com.snowman.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.snowman.model.Game;
import com.snowman.model.WordListProcessor;
import com.snowman.view.SinglePlayerView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import org.junit.jupiter.api.Test;

class SinglePlayerTest {

  private final Game game = new Game();
  private final SinglePlayerView view = new SinglePlayerView();
  private final ResourceBundle bundle = ResourceBundle.getBundle("strings");
  private final WordListProcessor words = new WordListProcessor();
  private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  @Test
  void play() {


  }

//  @Test
//  void getInitialSetupTest() {
//    SinglePlayer player = new SinglePlayer(game, view, words,
//        bundle, reader);
//    int expected = 0;
//
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  void getUserGuess() {
//  }
}