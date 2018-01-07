package soo.code.hackerrank.test;

public class MergeString {

  static String mergeStrings(String a, String b) {
    final char[] aChars = a.toCharArray();
    final char[] bChars = b.toCharArray();

    final int aLength = a.length();
    final int bLength = b.length();
    final int maxLength = Math.max(aLength, bLength);

    final StringBuilder mergeStringBuilder = new StringBuilder();

    for (int i = 0; i < maxLength; i++) {
      if (i < aLength)
        mergeStringBuilder.append(aChars[i]);
      if (i < bLength)
        mergeStringBuilder.append(bChars[i]);
    }

    return mergeStringBuilder.toString();
  }


  public static void main(String[] args) {
    System.out.println(mergeStrings("ab", "c"));
  }
}
