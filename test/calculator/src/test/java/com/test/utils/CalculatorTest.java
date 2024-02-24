package com.test.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.test.exception.InvalidOperatorException;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  public void 덧셈_연산을_할_수_있다() throws Exception {
    // given
    long num1 = 2;
    String operator = "+";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertEquals(5, result); // junit assertions
    assertThat(result).isEqualTo(5); // assertJ assertions
  }

  @Test
  public void 뺄셈_연산을_할_수_있다() throws Exception {
    // given
    long num1 = 5;
    String operator = "-";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertThat(result).isEqualTo(2); // assertJ assertions
  }

  @Test
  public void 곱셈_연산을_할_수_있다() throws Exception {
    // given
    long num1 = 2;
    String operator = "*";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertThat(result).isEqualTo(6); // assertJ assertions
  }

  @Test
  public void 나눗셈_연산을_할_수_있다() throws Exception {
    // given
    long num1 = 9;
    String operator = "/";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertThat(result).isEqualTo(3); // assertJ assertions
  }

  @Test
  public void 유효하지_않은_연산자가_요청으로_들어오면_에러가_발생한다() throws Exception {
    // given
    long num1 = 9;
    String operator = "x";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when

    // then
    assertThrows(InvalidOperatorException.class, () -> {
      calculator.calculate(num1, operator, num2);
    });
  }
}