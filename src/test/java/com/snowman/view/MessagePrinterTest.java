package com.snowman.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MessagePrinterTest {

  private static final String HAT_TOP = "  *      /*\\  *    *";
  private static final String HAT_LOW = "    *  _/ _ \\_ *   * ";
  private static final String NEUTRAL_FACE = " *   * ('< ' ) *      *";
  private static final String SAD_FACE = " *   * (T< T ) *      *";
  private static final String HAPPY_FACE = " *   * (^< ^ ) *      *";
  private static final String BODY_TOP = "   * \\–(  :   )–/   *";
  private static final String BODY_LOW = "   *   (__: __)  *    *";
  private static final String TEST_WORD = "TEST TEST 123";

  public static Stream<Arguments> remainingGuessSupplier() {
    return Stream.of(Arguments.of(
        0, "Sorry! You loose." + "\r\n",
        1, HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + SAD_FACE + "\r\n", 2,
        HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + BODY_TOP + "\r\n", 3,
        HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + NEUTRAL_FACE + "\r\n" + BODY_TOP + "\r\n" + BODY_LOW
            + "\r\n", 4,
        HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + HAPPY_FACE + "\r\n" + BODY_TOP + "\r\n" + BODY_LOW
            + "\r\n", -4,
        HAT_TOP + "\r\n" + HAT_LOW + "\r\n" + HAPPY_FACE + "\r\n" + BODY_TOP + "\r\n" + BODY_LOW
            + "\r\n"));

  }

  @ParameterizedTest
  @MethodSource("remainingGuessSupplier")
  void shouldPrintSnowman_caseOnePlus(int remainingGuess, String expectedPrompt) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    MessagePrinter.printSnowman(remainingGuess, TEST_WORD);
    String actualPrompt = outputStream.toString();
    Assertions.assertEquals(expectedPrompt, actualPrompt);
  }

  @Test
  void shouldPrintWinSnowman() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    MessagePrinter.printWinMessage(TEST_WORD);
    String expectedPrompt = "Congratulations! You Win." + "\r\n";
    String actualPrompt = outputStream.toString();
    Assertions.assertEquals(expectedPrompt, actualPrompt);
  }

  @Test
  void shouldPrintLoseSnowman() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    MessagePrinter.printLoseMessage(TEST_WORD);
    String expectedPrompt = "Sorry! You loose." + "\r\n";
    String actualPrompt = outputStream.toString();
    Assertions.assertEquals(expectedPrompt, actualPrompt);
  }

}
