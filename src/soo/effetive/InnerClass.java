package soo.effetive;

class InnerClass {

  private int a = 10;

  public void test() {
    int b = 20;
    final int d = 40;

    class LocalInner {
      private int c = 30;

      //내부클래스에서 static멤버는 선언할 수 없다.
      //private static int f=100;

      public void print() {
        System.out.println("a:" + a);

        //로컬내부클래스는 지역변수는 접근할 수 없다.
        //System.out.println("b:" + b);
        System.out.println("c:" + c);

        //final로 선언된 지역변수(상수)는 접근할 수 있다.
        System.out.println("d:" + d);
      }
    }
    LocalInner inner = new LocalInner();
    inner.print();
  }
}