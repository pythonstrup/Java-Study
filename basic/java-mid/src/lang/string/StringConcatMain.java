package lang.string;

import lang.immutable.address.Address;

public class StringConcatMain {

  public static void main(String[] args) {
    String a = "hello";
    String b = " java";

    String result1 = a.concat(b);
    // 보통 참조형에서는 + 연산자를 제공하지 않는다. 주소값을 더하는 것이나 다름 없는데, 사실 아래와 같이 연산자를 넣으면 에러가를 띄워준다.
    // Operator '+' cannot be applied to 'lang.immutable.address.Address', 'lang.immutable.address.Address'
//    Address address1 = new Address("1");
//    Address address2 = new Address("2");
//    address1 + address2;

    // 그러나 문자열에서는 + 연산자를 너무 많이 다루기 때문에 편의상 특별히 제공한다.
    String result2 = a + b;
    System.out.println(result1);
    System.out.println(result2);
  }
}
