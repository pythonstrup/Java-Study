package time;

import java.time.LocalTime;

public class LocalTimeMain {

  public static void main(String[] args) {
    LocalTime now = LocalTime.now();
    LocalTime ofTime = LocalTime.of(20, 9, 10);
    System.out.println("now = " + now);
    System.out.println("ofTime = " + ofTime);

    // 계산
    LocalTime ofTimePlus = ofTime.plusSeconds(30);
    System.out.println("ofTimePlus = " + ofTimePlus);
  }
}
