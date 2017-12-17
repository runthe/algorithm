package soo.effetive;

import java.util.Arrays;
import java.util.Collection;

public class OperationMain {

  public static void main(String[] args) {
    double x = 1;
    double y = 1;

    test(BasicOperation.class, x, y);
    test(Arrays.asList(BasicOperation.values()), x, y);
  }

  //한정적 자료형 토큰 Operation 과 Enum 의 하위자료형
  private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
    for (Operation operation : opSet.getEnumConstants()) {
      System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
    }
  }

  //한정적 와일드 카드 자료형
  private static void test(Collection<? extends Operation> opSet, double x, double y) {
    for (Operation operation : opSet) {
      System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
    }
  }
}
