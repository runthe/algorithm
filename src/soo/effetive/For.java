package soo.effetive;

import java.util.Comparator;

public class For {

  static Integer i;

  public static void main(String[] args) {

    if (i == 42) {
      System.out.println("wow");
    }

    Comparator<Integer> naturalOrder = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        int first = o1;
        int second = o2;
        return first < second ? -1 : (first == second ? 0 : 1);
      }
    };
  }
}
