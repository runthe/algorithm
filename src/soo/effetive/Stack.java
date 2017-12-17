package soo.effetive;

import java.util.EmptyStackException;
import java.util.List;

public class Stack<E> {

  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public Stack() {
    elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(E e) {
    //ensureCapacity();
    elements[size++] = e;
  }

  public E pop() {
    if (size == 0)
      throw new EmptyStackException();

    //자료형이 E인 원소만 push하므로 아래의 형변환은 안전하다.
    @SuppressWarnings("unchecked")
    E result = (E) elements[--size];
    elements[size] = null; //만기 참조 제거

    return result;
  }


  public static void swap(List<?> list, int i, int j) {
    swapHelper(list, i, j);
  }

  //와일드카드 자료형을 포착하기 위한 private 도움 메서드
  private static <E> void swapHelper(List<E> list, int i, int j) {

    list.set(i, list.set(j, list.get(i)));
  }
}
