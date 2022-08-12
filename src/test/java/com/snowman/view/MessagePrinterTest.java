package com.snowman.view;

import static com.snowman.view.Messages.BODY_LOW;
import static com.snowman.view.Messages.BODY_TOP;
import static com.snowman.view.Messages.HAPPY_FACE;
import static com.snowman.view.Messages.HAT_LOW;
import static com.snowman.view.Messages.HAT_TOP;
import static com.snowman.view.Messages.NEUTRAL_FACE;
import static com.snowman.view.Messages.SAD_FACE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MessagePrinterTest {

  public static final String TEST_WORD = "test";

  public static Stream<Arguments> remainingGuessSupplier() {
    return Stream.of(Arguments.of(
        1, HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + SAD_FACE + "\r\n",
        2, HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + BODY_TOP + "\r\n",
        3,
        HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + NEUTRAL_FACE + "\r\n" + BODY_TOP + "\r\n" + BODY_LOW
            + "\r\n",
        4, HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + HAPPY_FACE + "\r\n" + BODY_TOP + "\r\n" + BODY_LOW
            + "\r\n",
        -4, HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + HAPPY_FACE + "\r\n" + BODY_TOP + "\r\n" + BODY_LOW
            + "\r\n"));

  }

  @ParameterizedTest
  @MethodSource("remainingGuessSupplier")
  void shouldPrintSnowman_caseOnePlus(int remainingGuess, String expectedPrompt) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    SinglePlayerView.printSnowman(remainingGuess);
    String actualPrompt = outputStream.toString();
    Assertions.assertEquals(expectedPrompt, actualPrompt);
  }

  @Test
  void shouldPrintWinSnowman(String secretWord) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    String actualPrompt = outputStream.toString();
    Assertions.assertEquals(Messages.WIN_MESSAGE, actualPrompt);
  }

  @Test
  void shouldPrintLoseSnowman() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    SinglePlayerView.printLoseMessage(TEST_WORD);
    String expectedPrompt = "Sorry! You loose." + "\r\n";
    String actualPrompt = outputStream.toString();
    Assertions.assertEquals(expectedPrompt, actualPrompt);
  }

}
