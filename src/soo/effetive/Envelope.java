package soo.effetive;

public class Envelope {
  void x() {
    System.out.println("say hello");
  }

  class Enclosure {
    //this 한정 구문은 바깥 객체를 참조하기 위해 this 앞에 바깥 객체의 자료형 이름을 붙이는것을 일컫는다.
    void x() {
      Envelope.this.x(); /* 한정됨 */
    }
  }
}
