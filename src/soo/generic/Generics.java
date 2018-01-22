package soo.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

  private static void printList1(List<Object> list) {
    list.forEach(System.out::print);
  }

  private static void printList2(List<?> list) {
    list.forEach(System.out::print);
  }

  /**
   * @param list
   * @param elem
   * @return
   */

  private static long frequency(List<?> list, Object elem) {
    return list.stream().filter(s -> s.equals(elem)).count();
  }

  /**
   * 제너릭 메서드로 선언을 해놓으면 이것은 내가 구현에서 이 T타입을 이용해서 뭔가 작업을 수행하겠다는 의미로 API가 해석하기 때문에 내부구현이 노출
   * 제너릭 타입과 와일카드 둘다 사용가능할경우는 와일드 카드를 사용한다.
   */
  private static <T> boolean isEmpty(List<T> list) {
    return list.size() == 0;
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    //printList1(list);
    System.out.println("");
    printList2(list);
    System.out.println("");
    frequency(list, 2);
    System.out.println("");
    System.out.println(max(list));
    reverse(list);
    System.out.println(list);

    reverseHelper(list);
    reverse(list);
  }

  static void reverse(List<?> list) {
    reverseHelper(list);
  }

  //제너릭 Helper메소드 캡처
  //Law타입으로 변경해서 사용한다.
  private static <T> void reverseHelper(List<T> list) {
    List<T> temp = new ArrayList<>(list);

    for (int i = 0; i < list.size(); i++) {
      list.set(i, temp.get(list.size() - i - 1));
    }
  }

/*
  private static <T> void reverse(List<T> list) {
    List<T> temp = new ArrayList<>(list);

    for (int i = 0; i < list.size(); i++) {
      list.set(i, temp.get(list.size() - i - 1));
    }
  }
*/

  private static <T extends Comparable<? super T>> T max(List<? extends T> list) {
    return list.stream().reduce((a, b) -> a.compareTo(b) > 0 ? a : b).get();
  }
}
