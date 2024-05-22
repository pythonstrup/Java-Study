package generic.ex1;

public class RawTypeMain {

  public static void main(String[] args) {
    GenericBox integerBox = new GenericBox(); // Raw Type (원시 타입): 타입 파라미터를 명시하지 않고 사용하는 제네릭 타입
    // => primitive type(원시 타입)과는 다른 개념
    // 위 대입문은 GenericBox<Object> integerBox = new GenericBox<>(); 와 똑같음
    integerBox.set(10);
    Integer integer = (Integer) integerBox.get();
    System.out.println("integer = " + integer);
  }
}
