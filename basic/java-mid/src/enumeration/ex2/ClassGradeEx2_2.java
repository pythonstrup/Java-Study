package enumeration.ex2;

public class ClassGradeEx2_2 {

  public static void main(String[] args) {
    int price = 10000;
    DiscountService discountService = new DiscountService();

    // ClassGrade 생성자를 외부에서 사용하지 못하도록 막아야 한다. => private 생성자
//    ClassGrade classGrade = new ClassGrade(); // x009
//    int result = discountService.discount(classGrade, price);
//    System.out.println("newClassGrade 등급 할인 금액 = " + result);
  }
}
