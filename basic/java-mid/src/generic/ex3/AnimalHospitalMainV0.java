package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {

  public static void main(String[] args) {
    DogHospital dogHospital = new DogHospital();
    CatHospital catHospital = new CatHospital();

    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 300);

    // 개병원
    dogHospital.set(dog);
    dogHospital.checkup();

    // 고양이 병원
    catHospital.set(cat);
    catHospital.checkup();

    // 문제1: 맞지 않는 타입 전달할 가능성 존재 (개병원에 고양이 전달)
    // 문제2: 코드 중복이 너무 많다
  }
}
