package nested.nested;

public class NestedOuter {

  private static int outClassValue = 3;
  private int outInstanceValue = 2;

  static class Nested {
    private int nestedInstanceValue = 1;

    public void print() {
      // 자신의 멤버에 접근
      System.out.println(nestedInstanceValue);

      // 바깥 클래스의 인스턴스 멤버에는 접근할 수 없다.(클래스는 스태틱이고, 멤버는 스태틱이 아니라서..)
//      System.out.println(outInstanceValue);

      // 바깥 클래스의 클래스 멤버에는 접근할 수 있다. => 이것은 외부 클래스도 마찬가지다.
      System.out.println(outClassValue);
    }
  }
}
