package com.test.utils;

import static org.assertj.core.api.Assertions.assertThat;

import com.test.vo.CalculationRequest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class CalculatorRequestReaderTest {

  @Test
  public void System_in으로_데이터를_읽어올_수_있다() throws Exception {
    // given
    CalculatorRequestReader calculatorRequestReader = new CalculatorRequestReader();
  
    // when
    System.setIn(new ByteArrayInputStream("2 + 3".getBytes()));
    CalculationRequest result = calculatorRequestReader.read();

    // then
    assertThat(2).isEqualTo(result.getNum1());
    assertThat("+").isEqualTo(result.getOperator());
    assertThat(3).isEqualTo(result.getNum2());
  }
}