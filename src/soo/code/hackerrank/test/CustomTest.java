package soo.code.hackerrank.test;

public class CustomTest {

  /*
  public static void main(String[] args) {
    System.out.println(test("00110"));
  }

  private static int test(String s) {
    String[] sArr = s.split("");

    int sLength = s.length();
    int count = 0;
    boolean[] sArrCheck = new boolean[sLength];

    if (sArr[0].equals(sArr[sLength - 1])) {
      sArrCheck[0] = true;
      sArrCheck[sLength - 1] = true;

      count++;
    }

    A:
    for (int i = 1; i < sLength - 1; i++) {
      B:
      for (int j = i + 1; j < sLength - 1; j++) {
        if (sArr[i].equals(sArr[j]) && !sArrCheck[j]) {
          sArrCheck[j] = true;
        } else {
          count++;
          break;
        }
      }
    }

    return count;
  }
  */
}

