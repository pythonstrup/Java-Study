package enumeration.ref3;


public class ClassGradeRefMain3_3 {

  public static void main(String[] args) {
    int price = 10000;
    pintDiscount(Grade.BASIC, price);
    pintDiscount(Grade.GOLD, price);
    pintDiscount(Grade.DIAMOND, price);
  }

  private static void pintDiscount(Grade grade, int price) {
    System.out.println(grade.name() + " = " + grade.discount(price));
  }
}
