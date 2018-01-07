package soo.code.hackerrank.test;

import java.util.Set;
import java.util.TreeSet;

public class SubSequences {

  public static void main(String[] args) {
    String[] tests = buildSubsequences("abcde");

    for (String test : tests) {
      System.out.println(test);
    }

  }

  static String[] buildSubsequences(String s) {
    final int sLength = s.length();
    final Set<String> subSequences = new TreeSet<>();

    for (int i = 0; i < sLength; i++) {
      subSequences.add(s.substring(i, i + 1));
    }

    return subSequences.toArray(new String[subSequences.size()]);
  }
}
