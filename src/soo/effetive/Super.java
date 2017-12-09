package soo.effetive;

import java.util.Date;

public class Super {
  //생성자가 재정의 가능 메서드를 호출하는 잘못된 사례
  public Super() {
    overrideMe();
  }

  public void overrideMe() {

  }
}

final class Sub extends Super {
  private final Date date;

  public Sub() {
    date = new Date();
  }

  //상위 클래스 생성자가 호출하게 되는 재정의 메서드
  @Override
  public void overrideMe() {
    System.out.println(date);
  }
}
