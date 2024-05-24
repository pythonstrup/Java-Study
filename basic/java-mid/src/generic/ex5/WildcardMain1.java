package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {

  public static void main(String[] args) {
    Box<Object> objectBox = new Box<>();
    Box<Dog> dogBox = new Box<>();
    Box<Cat> catBox = new Box<>();

    dogBox.set(new Dog("멍멍이", 100));

    WildcardEx.printGenericV1(dogBox);
    WildcardEx.printWildcardV1(dogBox);

    WildcardEx.printGenericV2(dogBox);
    WildcardEx.printWildcardV2(dogBox);

    Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
    Cat cat = WildcardEx.printAndReturnGeneric(catBox);

    Animal animal1 = WildcardEx.printAndReturnWildcard(dogBox);

    // 와일드카드는 명확한 타입으로 캐스팅하려면 다운캐스팅을 해야한다.
    Cat wildcardCat = (Cat) WildcardEx.printAndReturnWildcard(catBox);
  }
}
