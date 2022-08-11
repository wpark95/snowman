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

class SnowmanPrinterTest {

  private static final String HAT_TOP = "  *      /*\\  *    *";

  private static final String HAT_LOW = "    *  _/ _ \\_ *   * ";

  private static final String NEUTRAL_FACE = " *   * ('< ' ) *      *";

  private static final String SAD_FACE = " *   * (T< T ) *      *";

  private static final String HAPPY_FACE = " *   * (^< ^ ) *      *";

  private static final String BODY_TOP = "   * \\–(  :   )–/   *";

  private static final String BODY_LOW = "   *   (__: __)  *    *";


  public static Stream<Arguments> remainingGuessSupplier() {
    return Stream.of(Arguments.of(
        1, HAT_TOP + System.lineSeparator()
            + HAT_LOW + System.lineSeparator()
            + SAD_FACE + System.lineSeparator(),
        2, HAT_TOP + System.lineSeparator()
            + HAT_LOW + System.lineSeparator()
            + BODY_TOP + System.lineSeparator(),
        3, HAT_TOP + System.lineSeparator()
            + HAT_LOW + System.lineSeparator()
            + NEUTRAL_FACE + System.lineSeparator()
            + BODY_TOP + System.lineSeparator()
            + BODY_LOW + System.lineSeparator(),
        4, HAT_TOP + System.lineSeparator()
            + HAT_LOW + System.lineSeparator()
            + HAPPY_FACE + System.lineSeparator()
            + BODY_TOP + System.lineSeparator()
            + BODY_LOW + System.lineSeparator(),
        -4, HAT_TOP + System.lineSeparator()
            + HAT_LOW + System.lineSeparator()
            + HAPPY_FACE + System.lineSeparator()
            + BODY_TOP + System.lineSeparator()
            + BODY_LOW + System.lineSeparator())

    );

  }


  @ParameterizedTest
  @MethodSource("remainingGuessSupplier")
  void shouldPrintSnowman(int remainingGuess, String expectedPrompt) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    SnowmanPrinter.printSnowman(remainingGuess);
    String actualPrompt = outputStream.toString();
    Assertions.assertEquals(expectedPrompt, actualPrompt);


  }

  @Test
  void shouldPrintWinSnowman() {
    SnowmanPrinter.youWinSnowman();
  }

  @Test
  void shouldPrintLoseSnowman() {
  }
}
