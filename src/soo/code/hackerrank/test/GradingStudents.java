package soo.code.hackerrank.test;

import java.util.Scanner;

public class GradingStudents {

  private static final int FALLING_GRADE = 38;
  private static final int AROUND_STANDARD_NUMBER = 3;

  static int[] solve(int[] grades) {
    final int gradesLength = grades.length;
    final int[] results = new int[gradesLength];

    for (int i = 0; i < gradesLength; i++) {
      int grade = grades[i];

      if (grade < FALLING_GRADE) {
        results[i] = grade;
        continue;
      }

      int multipleOfFiveCount = ((grade / 5) + 1);
      int value = (5 * multipleOfFiveCount) - grade;

      if (value < AROUND_STANDARD_NUMBER) {
        results[i] = grade + value;
      } else {
        results[i] = grade;
      }
    }

    return results;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[] grades = new int[n];

    for (int grades_i = 0; grades_i < n; grades_i++) {
      grades[grades_i] = in.nextInt();
    }

    int[] result = solve(grades);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }

    System.out.println("");
  }
}
