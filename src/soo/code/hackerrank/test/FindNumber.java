package soo.code.hackerrank.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNumber {

  public static void main(String[] args) {
    String[] result = findNumber(new String[]{"20th Oct 2052"});

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static List<String> monthList = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

  static String[] findNumber(String[] dates) {
    final String SEPARATOR = "-";
    int datesLength = dates.length;
    String[] results = new String[datesLength];

    for (int i = 0; i < datesLength; i++) {
      String[] dateArray = dates[i].split(" ");

      String year = dateArray[2];
      String month = dateArray[1];
      String day = dateArray[0];

      String convertedMonth = String.format("%02d", monthList.indexOf(month) + 1);
      String convertedDay = String.format("%02d", Integer.parseInt(day.replaceAll("[^0-9]", "")));

      StringBuilder convertedDateBuilder = new StringBuilder();
      convertedDateBuilder.append(year);
      convertedDateBuilder.append(SEPARATOR);
      convertedDateBuilder.append(convertedMonth);
      convertedDateBuilder.append(SEPARATOR);
      convertedDateBuilder.append(convertedDay);

      results[i] = convertedDateBuilder.toString();
    }


    return results;
  }
}
