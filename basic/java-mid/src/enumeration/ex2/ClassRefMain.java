package enumeration.ex2;

public class ClassRefMain {

  public static void main(String[] args) {
    // 타입은 똑같다.
    System.out.println("class BASIC = " + ClassGrade.BASIC.getClass());
    System.out.println("class GOLD = " + ClassGrade.GOLD.getClass());
    System.out.println("class DIAMOND = " + ClassGrade.DIAMOND.getClass());

    // 하지만 각각의 인스턴스가 다르기 때문에 참조값이 서로 다르다.
    System.out.println("ref BASIC = " + ClassGrade.BASIC);
    System.out.println("ref GOLD = " + ClassGrade.GOLD);
    System.out.println("ref DIAMOND = " + ClassGrade.DIAMOND);
  }
}
