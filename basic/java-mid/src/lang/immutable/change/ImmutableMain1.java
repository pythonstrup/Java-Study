package lang.immutable.change;

public class ImmutableMain1 {

  public static void main(String[] args) {
    ImmutableObj obj1 = new ImmutableObj(10);
    ImmutableObj obj2 = obj1.add(20);

    // 계산 후 기존 값을 남길 수 있다
    System.out.println("obj1 = " + obj1.getValue());
    System.out.println("obj2 = " + obj2.getValue());
  }
}
