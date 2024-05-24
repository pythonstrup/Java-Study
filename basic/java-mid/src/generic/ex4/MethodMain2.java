package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {

  public static void main(String[] args) {
    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 100);

    AnimalMethod.checkup(dog);
    AnimalMethod.checkup(cat);

    Dog targetDog = new Dog("큰 멍멍이", 200);
    Dog biggerDog = AnimalMethod.getBigger(dog, targetDog);
    System.out.println("biggerDog = " + biggerDog);
  }
}
