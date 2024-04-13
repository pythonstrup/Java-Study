package lang.wrapper;

public class WrapperClassMain {

  public static void main(String[] args) {
    // Boxing
//    Integer newInteger = new Integer(10); // deprecated
    Integer newInteger = Integer.valueOf(10); // -128 ~ 127 자주 사용하는 숫자 값을 재사용할 있는 불변 객체를 Integer Cache Pool 에 넣어 놓음
    Long newLong = Long.valueOf(100);
    Double newDouble = Double.valueOf(10.5);
    System.out.println("newInteger = " + newInteger);
    System.out.println("newLong = " + newLong);
    System.out.println("newDouble = " + newDouble);

    // Unboxing
    System.out.println("내부 값 읽기");
    int intValue = newInteger.intValue();
    System.out.println("intValue = " + intValue);
    long longValue = newLong.longValue();
    System.out.println("longValue = " + longValue);

    System.out.println("비교");
    Integer constructorInteger = new Integer(10);
    System.out.println("==: "+(newInteger == constructorInteger)); // false가 된다??!? => 다른 참조 값을 보고 있기 때문이다.
    // Integer.valueOf(10)는 해시 값을 통해 내부 최적화 과정이 있기 때문에 Integer Cache Pool에서 값을 가져온다.
    // 반면 new Integer(10)는 아예 새로운 객체를 만들고 새로운 주소를 부여받기 때문에 참조값이 다를 수 밖에 없다.
    System.out.println("equals: " + (newInteger.equals(constructorInteger))); // 그래서 equals를 사용해야한다.
    Integer newInteger2 = Integer.valueOf(10);
    System.out.println("==: "+(newInteger == newInteger2)); // 반면 valueOf(10) 새로운 객체도 해시값을 통해 똑같은 참조값을 받기 때문에 true가 된다.
  }
}
