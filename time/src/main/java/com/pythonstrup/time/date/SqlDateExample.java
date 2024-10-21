package com.pythonstrup.time.date;

import java.sql.Date;
import java.sql.Timestamp;

public class SqlDateExample {

  public static void main(String[] args) {
    Date date = new Date(2024, 10, 9);
    System.out.println(date);

    Date date1 = new Date(192418492);
    System.out.println(date1);
  }
}
