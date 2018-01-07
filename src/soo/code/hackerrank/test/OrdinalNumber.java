package soo.code.hackerrank.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdinalNumber {

  public static void main(String[] args) {
    String[] names = check(new String[]{
      "Soo XX", "Soo XXI", "Soo XI", "Soo XIX", "Kim XX", "Hwan XX", "Hwan XI", "Hwan XX", "Hwan XIII", "Hwan XII"
    });

    for (String name : names) {
      System.out.println(name);
    }
  }

  private static List<String> mappedOrdinalNumbers = createMappedOrdinalNumbers();

  static List<String> createMappedOrdinalNumbers() {
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

  private static String[] check(String[] inputs) {
    int inputLength = inputs.length;
    String[] results = new String[inputs.length];
    List<OrdinalName> ordinalNumbers = new ArrayList<>();

    for (String input : inputs) {
      String[] nameArray = input.split(" ");

      String name = nameArray[0];
      String ordinal = nameArray[1];
      int number = mappedOrdinalNumbers.indexOf(ordinal);

      OrdinalName ordinalName = new OrdinalName(name, ordinal, number);
      ordinalNumbers.add(ordinalName);
    }

    Collections.sort(ordinalNumbers);

    for (int i = 0; i < inputLength; i++) {
      results[i] = ordinalNumbers.get(i).getOrdinalName();
    }

    return results;
  }
}

class OrdinalName implements Comparable<OrdinalName> {
  private final String name;
  private final String ordinal;
  private final int ordinalNumber;

  public OrdinalName(String name, String ordinal, int ordinalNumber) {
    this.name = name;
    this.ordinal = ordinal;
    this.ordinalNumber = ordinalNumber;
  }

  public String getOrdinalName() {
    return this.name + " " + this.ordinal;
  }

  @Override
  public int compareTo(OrdinalName o) {
    int nameResult = this.name.compareTo(o.name);

    if (nameResult != 0) {
      return nameResult;
    }

    return Integer.compare(this.ordinalNumber, o.ordinalNumber);
  }
}
