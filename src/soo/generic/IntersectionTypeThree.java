package soo.generic;

import java.util.function.Consumer;
import java.util.function.Function;

public class IntersectionTypeThree {

  interface Pair<T> {
    T getFirst();

    T getSecond();

    void setFirst(T first);

    void setSecond(T second);
  }

  static class Name implements Pair<String> {
    private String firstName;
    private String secondName;

    Name(String firstName, String secondName) {
      this.firstName = firstName;
      this.secondName = secondName;
    }

    @Override
    public String getFirst() {
      return firstName;
    }

    @Override
    public String getSecond() {
      return secondName;
    }

    @Override
    public void setFirst(String first) {
      this.firstName = first;
    }

    @Override
    public void setSecond(String second) {
      this.secondName = second;
    }
  }

  interface ForwardingPair<T> extends DelegateTo<Pair<T>>, Pair<T> {
    default T getFirst() {
      return delegate().getFirst();
    }

    default T getSecond() {
      return delegate().getSecond();
    }

    default void setFirst(T first) {
      delegate().setFirst(first);
    }

    default void setSecond(T second) {
      delegate().setSecond(second);
    }
  }

  interface DelegateTo<T> {
    T delegate();
  }

  private static <T extends DelegateTo<S>, S> void run(T t, Consumer<T> consumer) {
    consumer.accept(t);
  }

  interface Convertable<T> extends DelegateTo<Pair<T>> {

    default void convert(Function<T, T> mapper) {
      Pair<T> pair = delegate();
      pair.setFirst(mapper.apply(pair.getFirst()));
      pair.setSecond(mapper.apply(pair.getSecond()));
    }
  }

  static <T> void print(Pair<T> pair) {
    System.out.println(pair.getFirst() + " " + pair.getSecond());
  }

  public static void main(String[] args) {
    Pair<String> name = new Name("HwanSoo", "Kim");
    run((ForwardingPair<String> & Convertable<String>) () -> name, o -> {
      System.out.println(o.getFirst());
      System.out.println(o.getSecond());

      print(o);
      o.convert(s -> s.toUpperCase());
      print(o) ;
    });
  }
}
