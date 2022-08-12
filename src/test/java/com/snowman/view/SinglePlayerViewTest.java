package com.snowman.view;

import static com.snowman.view.Messages.BODY_LOW;
import static com.snowman.view.Messages.BODY_TOP;
import static com.snowman.view.Messages.HAPPY_FACE;
import static com.snowman.view.Messages.HAT_LOW;
import static com.snowman.view.Messages.HAT_TOP;
import static com.snowman.view.Messages.NEUTRAL_FACE;
import static com.snowman.view.Messages.SAD_FACE;

import com.snowman.controller.SinglePlayer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SinglePlayerViewTest {

  private final SinglePlayerView view = new SinglePlayerView();

  public static Stream<Arguments> testPrintSnowman() {
    return Stream.of(
        Arguments.of(
            1, HAT_TOP + "\n" + HAT_LOW + "\n" + SAD_FACE + "\n",
            2, HAT_TOP + "\n" + HAT_LOW + "\n" + BODY_TOP + "\n",
            3, HAT_TOP + "\n" + HAT_LOW + "\n" + NEUTRAL_FACE + "\n" + BODY_TOP + "\n" + BODY_LOW
                + "\n",
            4,
            HAT_TOP + "\n" + HAT_LOW + "\n" + HAPPY_FACE + "\n" + BODY_TOP + "\n" + BODY_LOW + "\n",
            5,
            HAT_TOP + "\n" + HAT_LOW + "\n" + HAPPY_FACE + "\n" + BODY_TOP + "\n" + BODY_LOW + "\n",
            15,
            HAT_TOP + "\n" + HAT_LOW + "\n" + HAPPY_FACE + "\n" + BODY_TOP + "\n" + BODY_LOW + "\n"
        )
    );
  }

  public static Stream<Arguments> testUpdateCurrentState_valid() {
    String[] arr1 = {"hello", "world", "snowman"};
    String[] arr2 = {"brandon"};
    String[] arr3 = {"brandon", "pratibha"};
    String[] arr4 = {"brandon", "pratibha", "will"};
    String[] arr5 = {"brandon", "pratibha", "will", "nick"};
    return Stream.of(
        Arguments.of(
            new HashSet<>(Arrays.asList(arr1)), "____", "test", 3,
            new HashSet<>(Arrays.asList(arr2)), "_______", "word", 5,
            new HashSet<>(Arrays.asList(arr3)), "__________", "fire", 7,
            new HashSet<>(Arrays.asList(arr4)), "____________", "fruit", 1,
            new HashSet<>(Arrays.asList(arr5)), "_______________", "microquake", 29
        )
    );
  }

  public static Stream<Arguments> testUpdateCurrentState_invalid() {
    String[] arr1 = {"hello", "world", "snowman"};
    String[] arr2 = {"brandon"};
    String[] arr3 = {"brandon", "pratibha"};
    String[] arr4 = {"brandon", "pratibha", "will"};
    String[] arr5 = {"brandon", "pratibha", "will", "nick"};
    return Stream.of(
        Arguments.of(
            new HashSet<>(Arrays.asList(arr1)), "____", "test", 3,
            new HashSet<>(Arrays.asList(arr5)),
            new HashSet<>(Arrays.asList(arr2)), "_______", "word", 5,
            new HashSet<>(Arrays.asList(arr5)),
            new HashSet<>(Arrays.asList(arr3)), "__________", "fire", 7,
            new HashSet<>(Arrays.asList(arr5)),
            new HashSet<>(Arrays.asList(arr4)), "____________", "fruit", 1,
            new HashSet<>(Arrays.asList(arr5)),
            new HashSet<>(Arrays.asList(arr5)), "_______________", "microquake", 29,
            new HashSet<>(Arrays.asList(arr1))
        )
    );
  }

  @ParameterizedTest
  @MethodSource
  void testPrintSnowman(int remainingGuess, String expectedSnowman) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    view.printSnowman(remainingGuess);
    String actualSnowman = outputStream.toString();
    Assertions.assertEquals(expectedSnowman, actualSnowman);
  }

  @ParameterizedTest
  @MethodSource
  void testUpdateCurrentState_valid(Set<String> expectedSet, String expectedGuessState,
      String expectedSecretWord, int expectedRemainingGuess) {
    view.updateCurrentState(expectedSet, expectedGuessState, expectedSecretWord,
        expectedRemainingGuess);
    Assertions.assertEquals(expectedSet, view.getTriedWords());
    Assertions.assertEquals(expectedGuessState, view.getCurrentGuessState());
    Assertions.assertEquals(expectedSecretWord, view.getSecretWord());
    Assertions.assertEquals(expectedRemainingGuess, view.getRemainingGuess());
  }

  @ParameterizedTest
  @MethodSource
  void testUpdateCurrentState_invalid(Set<String> expectedSet, String expectedGuessState,
      String expectedSecretWord, int expectedRemainingGuess, Set<String> unexpectedSet) {
    view.updateCurrentState(expectedSet, expectedGuessState, expectedSecretWord,
        expectedRemainingGuess);

    expectedGuessState = expectedGuessState + "_";
    expectedSecretWord = expectedSecretWord.toUpperCase();
    expectedRemainingGuess++;
    Assertions.assertNotEquals(unexpectedSet, view.getTriedWords());
    Assertions.assertNotEquals(expectedGuessState + "_", view.getCurrentGuessState());
    Assertions.assertNotEquals(expectedSecretWord + "e", view.getSecretWord());
    Assertions.assertNotEquals(expectedRemainingGuess, view.getRemainingGuess());
  }

  @Test
  void displayGuessResult_true() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    view.displayGuessResult(true);
    String trueMessage = outputStream.toString();
    Assertions.assertEquals(
        Messages.ANSI_GREEN + "\n\n\nGreat job, you are keeping me cold!\n"
            + Messages.ANSI_RESET + "\n", trueMessage
    );
  }

  @Test
  void displayGuessResult_false() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    view.displayGuessResult(false);
    String falseMessage = outputStream.toString();
    Assertions.assertEquals(
        Messages.ANSI_RED
            + "\n\n\nYou are not going to let me melt like this, are you?\n"
            + Messages.ANSI_RESET + "\n", falseMessage
    );
  }

}
