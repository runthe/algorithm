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
    int datesLength = dates.length;

    String[] convertedDates = new String[datesLength];
    String separator = "-";

    for (int i = 0; i < datesLength; i++) {
      String[] dateArr = dates[i].split(" ");

      String year = dateArr[2];
      String month = dateArr[1];
      String day = dateArr[0];

      StringBuilder convertedDate = new StringBuilder();
      convertedDate.append(year);
      convertedDate.append(separator);
      convertedDate.append(String.format("%02d", monthList.indexOf(month) + 1));
      convertedDate.append(separator);
      convertedDate.append(String.format("%02d", Integer.parseInt(day.replaceAll("[^0-9]", ""))));

      convertedDates[i] = convertedDate.toString();
    }

    return convertedDates;
  }
}
