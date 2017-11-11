package soo.code;

public class Fibonachi {

  public static void main(String args[]) {
    //0, 1, 1, 2, 3, 5, 8, 13
    System.out.println(stack(7));
    System.out.println(loop(7));
    System.out.println(loop2(7));
  }

  private static int loop2(int n) {
    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    }

    int n1 = 0;
    int n2 = 1;
    int n3 = 0;

    for (int i = 2; i <= n - 1; i++) {
      n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
    }

    return n3;
  }

  private static int loop(int n) {
    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    }

    int[] fiboArray = new int[n];
    fiboArray[0] = 0;
    fiboArray[1] = 1;

    for (int i = 2; i <= n - 1; i++) {
      fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2];
    }

    return fiboArray[n - 1];
  }

  private static int stack(int n) {
    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    }

    return stack(n - 2) + stack(n - 1);
  }
}
