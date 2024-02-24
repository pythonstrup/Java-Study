package com.test.utils;

import com.test.vo.CalculationRequest;
import java.util.Scanner;

public class CalculatorRequestReader {

  public CalculationRequest read() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter two numbers and an operator (e.g 1 + 2): ");
    String result = scanner.nextLine();
    return new CalculationRequest(result.split(" "));
  }
}
