package com.snowman.model;

import com.snowman.Main;
import com.snowman.view.SnowmanPrinter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public class WordProcessor {

  public static final String WORD_LIST_FILE = "snowman-words-four-to-fifteen.csv";
  private static final Pattern LINE_SPLITTER = Pattern.compile("\\s*,\\s*");
  private final Random rng;
  private final Map<Integer, List<String>> words;

  public WordProcessor() {
    words = new HashMap<>();
    rng = new Random();

    try {
      Files
          .lines(Paths.get(getClass().getClassLoader().getResource(WORD_LIST_FILE).toURI()))
          .flatMap(LINE_SPLITTER::splitAsStream)
          .forEach((word) -> {
            List<String> sameLengthWords = words.computeIfAbsent(word.length(),
                (length) -> new ArrayList<>());
            sameLengthWords.add(word);
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

  public static int wordGuess(BufferedReader reader, int remainingGuess, Set<String> triedWords,
      String secretWord, String wordPlaceholder) throws IOException {
    // TODO: We should not let user enter a wrong letter or word they already tried. So maybe create a map to keep track of those?
    String userGuess = reader.readLine().toLowerCase().trim();
    int newRemainingGuess = remainingGuess;

    if (!triedWords.contains(userGuess)) {
      triedWords.add(userGuess);
      if (userGuess.length() >= 2) {
        if (userGuess.equals(secretWord)) { // TODO: extract these three lines into a method & reuse
          SnowmanPrinter.youWinSnowman();
          triedWords.clear();
          Main.main(null); // Winning case
        } else {
          System.out.println("Wrong word. Come on, I'm going to melt!");
          newRemainingGuess--;
        }
      } else {
        if (secretWord.contains(userGuess)) {
          char userLetter = userGuess.charAt(0);
          for (int i = 0; i < secretWord.length(); i++) {
            char currChar = secretWord.charAt(i);
            if (currChar == userLetter) {
              char[] chars = wordPlaceholder.toCharArray();
              chars[i] = userLetter;
              wordPlaceholder = String.valueOf(chars);
              if (wordPlaceholder.equals(secretWord)) {
                SnowmanPrinter.youWinSnowman();
                triedWords.clear();
                Main.main(null);
              }
            }
          }
        } else {
          System.out.println("Wrong guess. Come on, I'm melting!");
          newRemainingGuess--;
        }
      }
    } else {
      System.out.println(
          String.format("Try again. You've already tried %s before", userGuess));
    }
    return newRemainingGuess;
  }

}