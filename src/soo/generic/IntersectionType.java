package soo.generic;

import java.util.function.Consumer;
import java.util.function.Function;

public class IntersectionType {

  interface Hello extends Function {
    default void hello() {
      System.out.println("Hello");
    }
  }

  interface Hi extends Function {
    default void hi() {
      System.out.println("Hi");
    }
  }

  interface Printer {
    default void print(String str) {
      System.out.println(str);
    }
  }

  interface DelegateTo<T> {
    T delegate();
  }

  //동적인 기능확장법
  //추상메소드가 한개만 되면된다. default 메소드와 static 메소드를 제
  //기능을 계속해서 추가할수있다.
  public static void main(String[] args) {
    hello((Function & Hello & Hi) s -> s);
    run((Function & Hello & Hi & Printer) s -> s, o -> {
      o.hello();
      o.hi();
      o.print("lambda");
    });
  }

  private static <T extends Function> void run(T t, Consumer<T> consumer) {
    consumer.accept(t);
  }

  //불편 계속 타입을 열거해줘야하니까
  //의미없는 Function에 Consumer를 이용해서 다 사용한다.
  private static <T extends Function & Hello & Hi> void hello(T t) {
    t.hi();
    t.hello();
  }


}
