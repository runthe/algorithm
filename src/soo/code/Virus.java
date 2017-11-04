package soo.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Virus {

  private static Map<Integer, Set<Integer>> computerEdges = new HashMap<>();

  private static boolean[] countCheckArrays;

  private static int infectedComputerCount;

  public static void main(String[] args) {
    initialize();
    getInfectedComputerCount(computerEdges.get(1));
    System.out.println(infectedComputerCount);
  }

  private static void getInfectedComputerCount(Set<Integer> computers) {
    for (int computer : computers) {

      if (!countCheckArrays[computer - 1]) {
        countCheckArrays[computer - 1] = true;
        infectedComputerCount++;

        if (computerEdges.containsKey(computer)) {
          getInfectedComputerCount(computerEdges.get(computer));
        }
      }
    }
  }

  private static void initialize() {
    Scanner sc = new Scanner(System.in);

    countCheckArrays = new boolean[sc.nextInt()];
    int computerEdgeCount = sc.nextInt();

    for (int i = 0; i < computerEdgeCount; i++) {
      int edgeArrays[];
      int firstComputer = sc.nextInt();
      int secondComputer = sc.nextInt();

      edgeArrays = new int[]{firstComputer, secondComputer};
      Arrays.sort(edgeArrays);

      if (computerEdges.containsKey(edgeArrays[0])) {
        Set<Integer> set = computerEdges.get(edgeArrays[0]);
        set.add(edgeArrays[1]);

        computerEdges.put(edgeArrays[0], set);
      } else {
        Set<Integer> set = new HashSet<>();
        set.add(edgeArrays[1]);

        computerEdges.put(edgeArrays[0], set);
      }
    }
  }
}
