package time;

import java.time.LocalDate;

public class LocalDateMain {

  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    LocalDate ofDate = LocalDate.of(2024, 4, 16);
    System.out.println("now = " + now);
    System.out.println("ofDate = " + ofDate);

    // 계산
    ofDate = ofDate.plusDays(10);
    System.out.println("ofDate = " + ofDate);
  }
}
