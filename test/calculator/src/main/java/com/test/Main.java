package com.test;

import com.test.vo.CalculationRequest;
import com.test.utils.Calculator;
import com.test.utils.CalculatorRequestReader;

public class Main {

  public static void main(String[] args) {
    CalculationRequest calculationRequest = new CalculatorRequestReader().read();
    long answer = new Calculator().calculate(
        calculationRequest.getNum1(),
        calculationRequest.getOperator(),
        calculationRequest.getNum2());
    System.out.println(answer);
  }
}