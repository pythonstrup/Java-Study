package com.pythonstrup.time.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

  public static void main(String[] args) {
    final Date date1 = new Date(2024, 10 ,13);
    System.out.println(date1);

    final Date date2 = new Date(124, 10 ,13);
    System.out.println(date2);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(simpleDateFormat.format(date1));
  }
}
