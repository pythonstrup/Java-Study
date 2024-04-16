package time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeMain {

  public static void main(String[] args) {
    OffsetDateTime nowOdt = OffsetDateTime.now();
    System.out.println("nowOdt = " + nowOdt);

    LocalDateTime ldt = LocalDateTime.of(2024, 4, 16, 0, 0, 0);
    OffsetDateTime odt = OffsetDateTime.of(ldt, ZoneOffset.of("+01:00"));
    System.out.println("odt = " + odt);
  }
}
