package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalMain1 {

  public static void main(String[] args) {
    Animal animal = new Animal("동물", 0);
    Dog dog = new Dog("멍멍이", 100);
    Cat cat = new Cat("냐옹이", 50);

    Box<Dog> dogBox = new Box<>();
    dogBox.set(dog);
    Dog foundDog = dogBox.get();
    System.out.println("foundDog = " + foundDog);

    Box<Cat> catBox = new Box<>();
    catBox.set(cat);
    Cat foundCat = catBox.get();
    System.out.println("foundCat = " + foundCat);

    Box<Animal> animalBox = new Box<>();
    animalBox.set(animal);
    Animal foundAnimal = animalBox.get();
    System.out.println("foundAnimal = " + foundAnimal);
  }
}
