package com.test.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.test.exception.BadCalculatingRequestException;
import com.test.exception.InvalidOperatorException;
import org.junit.jupiter.api.Test;

class CalculationRequestTest {

  @Test
  public void 유효한_숫자를_parsing_할_수_있다() throws Exception {
    // given
    String[] parts = new String[]{"2", "+", "3"};
  
    // when
    CalculationRequest calculationRequest = new CalculationRequest(parts);

    // then
    assertThat(2).isEqualTo(calculationRequest.getNum1());
    assertThat("+").isEqualTo(calculationRequest.getOperator());
    assertThat(3).isEqualTo(calculationRequest.getNum2());
  }

  @Test
  public void 세자리_숫자를_parsing_할_수_있다() throws Exception {
    // given
    String[] parts = new String[]{"223", "+", "342"};

    // when
    CalculationRequest calculationRequest = new CalculationRequest(parts);

    // then
    assertThat(223).isEqualTo(calculationRequest.getNum1());
    assertThat("+").isEqualTo(calculationRequest.getOperator());
    assertThat(342).isEqualTo(calculationRequest.getNum2());
  }

  @Test
  public void 유효한_길이의_입력이_들어오지_않으면_에러가_발생한다() throws Exception {
    // given
    String[] parts = new String[]{"2", "+"};

    // when

    // then
    assertThrows(BadCalculatingRequestException.class, () -> {
      new CalculationRequest(parts);
    });
  }

  @Test
  public void 유효하지_않은_연산자가_입력되면_에러가_발생한다() throws Exception {
    // given
    String[] parts = new String[]{"2", "x", "3"};

    // when

    // then
    assertThrows(InvalidOperatorException.class, () -> {
      new CalculationRequest(parts);
    });
  }

  @Test
  public void 연산자의_길이가_2이상이면_에러가_발생한다() throws Exception {
    // given
    String[] parts = new String[]{"2", "+-", "3"};

    // when

    // then
    assertThrows(InvalidOperatorException.class, () -> {
      new CalculationRequest(parts);
    });
  }
}