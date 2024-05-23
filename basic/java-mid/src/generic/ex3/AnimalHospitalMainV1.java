package generic.ex3;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV1 {

  public static void main(String[] args) {
    AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
    AnimalHospitalV1 catHospital = new AnimalHospitalV1();

    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 300);

    // 개병원
    dogHospital.set(dog);
    dogHospital.checkup();

    // 고양이 병원
    catHospital.set(cat);
    catHospital.checkup();

    // 문제1: 매개변수 체크 실패
    dogHospital.set(cat);

    // 문제2: 명확한 타입을 받으려면 캐스팅을 해야함
    // Dog를 기대했지만 위에서 넣은 Cat이 반환되어 버린다.
    Dog biggerDog = (Dog) dogHospital.getBigger(new Dog("멍멍이2", 200)); // 에러가 발생한다.
    System.out.println("biggerDog = " + biggerDog);
  }
}
