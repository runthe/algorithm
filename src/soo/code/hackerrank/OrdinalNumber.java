package soo.code.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdinalNumber {

  public static void main(String[] args) {
    /*String[] names = test(new String[]{
      "Louis IX", "Louis VIII"
    });*/

    String[] names = test(new String[]{
      "Soo XX", "Soo XXI", "Soo XI", "Soo XIX", "Kim XX", "Hwan XX", "Hwan XI", "Hwan XX", "Hwan XIII", "Hwan XII"
    });

    for (String name : names) {
      System.out.println(name);
    }
  }


  static class NameOrdinal {
    int index;
    String ordinalNumber;

    NameOrdinal(int index, String ordinalNumber) {
      this.index = index;
      this.ordinalNumber = ordinalNumber;
    }

    public String getOrdinalNumber() {
      return this.ordinalNumber;
    }

    public int getIndex() {
      return this.index;
    }
  }

  public static String[] test(String[] names) {
    Arrays.sort(names);
    int namesLength = names.length;

    Map<String, List<NameOrdinal>> sameNameMap = new HashMap<>();

    for (int i = 0; i < namesLength; i++) {
      String[] nameArr = names[i].split(" ");
      String name = nameArr[0];
      String ordinalNumber = nameArr[1];

      if (sameNameMap.containsKey(name)) {
        List<NameOrdinal> list = sameNameMap.get(name);
        list.add(new NameOrdinal(i, ordinalNumber));
        sameNameMap.put(name, list);
      } else {
        List<NameOrdinal> list = new ArrayList<>();
        list.add(new NameOrdinal(i, ordinalNumber));
        sameNameMap.put(name, list);
      }
    }

    sortNamesByOrdinalNumber(names, sameNameMap);

    return names;
  }

  private static void sortNamesByOrdinalNumber(String[] names, Map<String, List<NameOrdinal>> map) {
    List<String> ordinalNumbers = createOrdinalNumbers();

    for (String key : map.keySet()) {
      List<NameOrdinal> list = map.get(key);
      int listSize = list.size();
      int min;
      String temp;

      for (int i = 0; i < listSize; i++) {
        NameOrdinal nameOrdinal = list.get(i);
        min = nameOrdinal.getIndex();

        for (int j = i + 1; j < listSize; j++) {
          if (ordinalNumbers.indexOf(nameOrdinal.getOrdinalNumber()) > ordinalNumbers.indexOf(list.get(j).getOrdinalNumber())) {
            min = list.get(j).getIndex();
          }
        }

        temp = names[min];
        names[min] = names[nameOrdinal.getIndex()];
        names[nameOrdinal.getIndex()] = temp;
      }
    }
  }

  static List<String> createOrdinalNumbers() {
    List<String> ordinalNumbers = new ArrayList<>();
    ordinalNumbers.add("I");
    ordinalNumbers.add("II");
    ordinalNumbers.add("III");
    ordinalNumbers.add("IV");
    ordinalNumbers.add("V");
    ordinalNumbers.add("VI");
    ordinalNumbers.add("VII");
    ordinalNumbers.add("VIII");
    ordinalNumbers.add("IX");
    ordinalNumbers.add("X");

    for (int i = 11; i < 51; i++) {
      String ordinal = i + "";

      int number1 = Integer.parseInt(String.valueOf(ordinal.charAt(0)));
      int number2 = Integer.parseInt(String.valueOf(ordinal.charAt(1)));

      StringBuilder newOrdinal = new StringBuilder();

      if (number1 <= 3) {
        for (int j = 0; j < number1; j++) {
          newOrdinal.append(ordinalNumbers.get(9));
        }
      } else if (number1 == 4) {
        newOrdinal.append("XL");
      } else if (number1 == 5) {
        newOrdinal.append("L");
      }

      if (number2 != 0) {
        newOrdinal.append(ordinalNumbers.get(number2 - 1));
      }

      ordinalNumbers.add(newOrdinal.toString());
    }

    return ordinalNumbers;
  }
}
