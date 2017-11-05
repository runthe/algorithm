package soo.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Virus {

  private static List<int[]> computerEdges = new ArrayList<>();

  private static boolean[] countCheckArrays;

  private static int totalComputerCount;

  private static int infectedComputerCount;

  public static void main(String[] args) {
    initialize();

    countCheckArrays[0] = true;
    calculateInfectedComputerCount(1);

    System.out.println(infectedComputerCount);
  }

  private static void calculateInfectedComputerCount(int infectedComputer) {
    for (int[] computers : computerEdges) {
      if (totalComputerCount == infectedComputerCount + 1) {
        break;
      }

      int firstComputer = computers[0];
      int secondComputer = computers[1];
      int sideComputer = 0;

      if (firstComputer == infectedComputer) {
        sideComputer = secondComputer;
      }

      if (secondComputer == infectedComputer) {
        sideComputer = firstComputer;
      }

      if (isWillInfectComputer(sideComputer)) {
        countCheckArrays[sideComputer - 1] = true;
        infectedComputerCount++;
        calculateInfectedComputerCount(sideComputer);
      }
    }
  }

  private static boolean isWillInfectComputer(int computer) {
    return computer != 0 && !countCheckArrays[computer - 1];
  }

  private static void initialize() {
    Scanner sc = new Scanner(System.in);

    totalComputerCount = sc.nextInt();
    countCheckArrays = new boolean[totalComputerCount];
    int computerEdgeCount = sc.nextInt();

    for (int i = 0; i < computerEdgeCount; i++) {
      int edgeArray[];
      int firstComputer = sc.nextInt();
      int secondComputer = sc.nextInt();

      edgeArray = new int[]{firstComputer, secondComputer};
      computerEdges.add(edgeArray);
    }
  }
}
