package generic.ex3;

public class AnimalHospitalV2<T> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public void checkup() {
    // T의 타입을 메소드로 정의하는 시점에는 알 수 없다. Object의 기능만 사용 가능하다는 얘기다.
//    System.out.println("animal.getName() = " + animal.getName());
//    System.out.println("animal.getSize() = " + animal.getSize());
//    animal.sound();
  }

  public T getBigger(T target) {
    // 컴파일 오류
//    return animal.getSize() > target.getSize()? animal: target;
    return null;
  }
}
