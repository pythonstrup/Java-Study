package generic.ex1;

public class BoxMain3 {

  public static void main(String[] args) {
    GenericBox<Integer> integerBox = new GenericBox<>();
    integerBox.set(10);
    Integer integer = integerBox.get();
    System.out.println("integer = " + integer);

    GenericBox<String> stringBox = new GenericBox<>();
    stringBox.set("hello");
    String str = stringBox.get();
    System.out.println("str = " + str);

    // 타입 추론: 생성하는 제네릭 타입 생략 가능
    GenericBox<Integer> integerBox2 = new GenericBox<>();
  }
}
