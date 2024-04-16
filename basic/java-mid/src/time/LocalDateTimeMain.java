package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime ofDt = LocalDateTime.of(2024, 4, 16, 20, 10, 10);
    System.out.println("now = " + now);
    System.out.println("ofDt = " + ofDt);

    // 날짜와 시간 분리
    LocalDate localDate = ofDt.toLocalDate();
    LocalTime localTime = ofDt.toLocalTime();
    System.out.println("localDate = " + localDate);
    System.out.println("localTime = " + localTime);

    // 날짜와 시간 합체
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
    System.out.println("localDateTime = " + localDateTime);

    // 계산(불변)
    LocalDateTime ofDtPlus = ofDt.plusDays(1000);
    System.out.println("ofDtPlus = " + ofDtPlus);
    LocalDateTime ofDtPlusYears = ofDt.plusYears(1);
    System.out.println("ofDtPlusYears = " + ofDtPlusYears);

    // 비교
    boolean before = now.isBefore(ofDt);
    boolean after = now.isAfter(ofDt);
    boolean equal = now.isEqual(ofDt); // 객체가 다르고 타임존이 달라도 시간적으로 같으면 true를 반환한다.
    // 반면 그냥 equals는 객체의 타입, 타임존 등등 내부 데이터의 모든 구성요소가 같아야 true를 반환한다.
    System.out.println("before = " + before);
    System.out.println("after = " + after);
    System.out.println("equal = " + equal);
  }
}
