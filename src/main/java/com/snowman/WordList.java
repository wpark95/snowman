package com.snowman;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordList {

  public static final String WORD_LIST_FILE = "./src/main/resources/two-char-words.txt";
//  public static final String WORD_LIST_FILE = "./src/main/resources/snowman words.csv";

  public static void main(String[] args) throws FileNotFoundException {

    Scanner scanner = new Scanner(new File(WORD_LIST_FILE));
    List<String> words = new ArrayList<>();

    while (scanner.hasNext()) {
      words.add(scanner.nextLine());
    }

    Random rand = new Random();

    String secretWord = words.get(rand.nextInt(words.size()));

    System.out.println(secretWord);
  }
}