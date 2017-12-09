package soo.effetive;

import java.util.Set;

//계층 대신 구성을 사용하는 Wrapper클래스
public class InstrumentedSet<E> extends ForwardingSet<E> {
  private int addCount = 0;

  public InstrumentedSet(Set<E> s) {
    super(s);
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }
}
