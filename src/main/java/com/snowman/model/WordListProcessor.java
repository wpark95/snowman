package com.snowman.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class WordListProcessor {

  public static final String WORD_LIST_FILE = "snowman-words-four-to-fifteen.csv";
  private static final Pattern LINE_SPLITTER = Pattern.compile("\\s*,\\s*");

  private final Random rng;
  private final Map<Integer, List<String>> words;

  public WordListProcessor() {
    words = new HashMap<>();
    rng = new Random();

    try {
      Files.lines(Paths.get(getClass().getClassLoader().getResource(WORD_LIST_FILE).toURI()))
          .flatMap(LINE_SPLITTER::splitAsStream).forEach((word) -> {
            List<String> sameLengthWords = words.computeIfAbsent(word.length(),
                (length) -> new ArrayList<>());
            sameLengthWords.add(word.toLowerCase());
            words.putIfAbsent(word.length(), sameLengthWords);
          });
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  public String wordChoice(int userLength) {
    List<String> sameLengthWords = words.get(userLength);
    return sameLengthWords.get(rng.nextInt(sameLengthWords.size()));
  }

}