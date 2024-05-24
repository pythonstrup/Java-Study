package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain2 {

  public static void main(String[] args) {
    Box<Object> objectBox = new Box<>();
    Box<Animal> animalBox = new Box<>();
    Box<Dog> dogBox = new Box<>();
    Box<Cat> catBox = new Box<>();

    // Animal을 포함한 상위 타입 전달 가능
    writeBox(objectBox);
    writeBox(animalBox);
//    writeBox(dogBox); // 하한이 Animal이라 넣을 수 없다.
//    writeBox(catBox);

    Animal animal = animalBox.get();
    System.out.println("animal = " + animal);
  }

  // 하한 와일드카드
  // 제네릭에서는 사용하지 못하는 기능이다.
  static void writeBox(Box<? super Animal> box) {
      box.set(new Dog("멍멍이", 100));
  }
}
