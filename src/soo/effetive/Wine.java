package soo.effetive;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Wine {
  String name() {
    return "wine";
  }
}

class SparklingWine extends Wine {
  @Override
  String name() {
    return "sparkling wine";
  }
}


class Champagne extends SparklingWine {
  @Override
  String name() {
    return "champagne";
  }
}

class Overriding {
  public static void main(String[] args) {

    Wine[] wines = {
      new Wine(), new SparklingWine(), new Champagne()
    };

    for (Wine wine : wines) {
      System.out.println(wine.name());
    }
  }


  static int min(int firstArg, int... args) {
    int min = firstArg;
    for (int i = 1; i < args.length; i++) {
      if (args[i] < min) {
        min = args[i];
      }
    }

    return min;
  }

}
