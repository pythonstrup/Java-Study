package com.pythonstrup.time.calendar;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarExample {


  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, 2);
    calendar.add(Calendar.WEEK_OF_MONTH, 3);
    calendar.add(Calendar.DATE, -5);
    calendar.add(Calendar.WEEK_OF_MONTH, -7);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(simpleDateFormat.format(calendar.getTime()));

    // 에러가 발생하지 않음
    System.out.println(calendar.getTimeZone());
    TimeZone timeZoneUTC = TimeZone.getTimeZone("Seoul/Asia");
    calendar.setTimeZone(timeZoneUTC);
    System.out.println(calendar.getTimeZone());

    // 에러 발생
    ZoneId zoneId = ZoneId.of("Seoul/Asia");
    LocalDateTime now = LocalDateTime.now();
    ZonedDateTime zonedDateTime = now.atZone(zoneId);
    System.out.println(zonedDateTime);
  }
}
