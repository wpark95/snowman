package com.snowman.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WordListProcessorTest {

  WordListProcessor processor = new WordListProcessor();

  public static Stream<Arguments> wordChoice() {
    return Stream.of(
        Arguments.of(
            "4", 4,
            "5", 5,
            "6", 6,
            "7", 7,
            "8", 8,
            "9", 9,
            "10", 10,
            "11", 11,
            "12", 12,
            "13", 13,
            "14", 14,
            "15", 15
        )
    );
  }

  @ParameterizedTest
  @MethodSource
  void wordChoice(String userInput, int expectedWordLength) {
    List<String> actualList = processor.getWords().get(Integer.parseInt(userInput));
    for (String word : actualList) {
      int actualWordLength = word.length();
      assertEquals(expectedWordLength, actualWordLength);
    }
  }

}