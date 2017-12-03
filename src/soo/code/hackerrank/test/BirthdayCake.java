package soo.code.hackerrank.test;

public class BirthdayCake {

  public static void main(String[] args) {
    int result = birthdayCakeCandles(4, new int[]{3, 2, 1, 3});
    System.out.println(result);
  }

  static int birthdayCakeCandles(int n, int[] ar) {
    int i;
    int max = 0;
    int count = 0;

    for (i = 0; i < n; i++) {
      if (i == 0) {
        max = ar[i];
        count++;
      } else {
        if (max == ar[i]) {
          count++;
        } else if (max < ar[i]) {
          max = ar[i];
        }
      }
    }

    return count;
  }
}
