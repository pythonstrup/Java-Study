package com.pythonstrup.state.gumbal;

public class GumballMachine {

  final static int SOLD_OUT = 0;
  final static int NO_QUARTER = 1;
  final static int HAS_QUARTER = 2;
  final static int SOLD = 3;

  int state = SOLD_OUT;
  int count = 0;

  public GumballMachine(final int count) {
    this.count = count;
    if (count > 0) {
      state = NO_QUARTER;
    }
  }

  public void insertQuarter() {
    if (state == HAS_QUARTER) {
      System.out.println("동전은 한 개만 넣어주세요.");
    } else if (state == NO_QUARTER) {
      state = HAS_QUARTER;
      System.out.println("동전을 넣었습니다.");
    } else if (state == SOLD_OUT) {
      System.out.println("매진되었습니다.");
    } else if (state == SOLD) {
      System.out.println("알맹이를 내보내고 있습니다.");
    }
  }

  public void ejectQuarter() {
    if (state == HAS_QUARTER) {
      System.out.println("동전이 반환됩니다.");
      state = NO_QUARTER;
    } else if (state == NO_QUARTER) {
      System.out.println("동전을 넣어주세요.");
    } else if (state == SOLD_OUT) {
      System.out.println("동전을 넣지 않았습니다. 동전이 반환되지 않습니다.");
    } else if (state == SOLD) {
      System.out.println("이미 알맹이를 뽑았습니다.");
    }
  }

  public void turnCrank() {
    if (state == HAS_QUARTER) {
      System.out.println("손잡이를 돌렸습니다.");
      state = SOLD;
      dispense();
    } else if (state == NO_QUARTER) {
      System.out.println("동전을 넣어주세요.");
    } else if (state == SOLD_OUT) {
      System.out.println("매진되었습니다.");
    } else if (state == SOLD) {

    }
  }

  private void dispense() {
    if (state == HAS_QUARTER) {
      System.out.println("알맹이를 내보낼 수 없습니다."); // 발생할 수 없는 상황 => 에러를 내야 함.
    } else if (state == NO_QUARTER) {
      System.out.println("동전을 넣어주세요."); // 발생할 수 없는 상황 => 에러를 내야 함.
    } else if (state == SOLD_OUT) {
      System.out.println("매진되었습니다."); // 발생할 수 없는 상황 => 에러를 내야 함.
    } else if (state == SOLD) {

    }
  }

  @Override
  public String toString() {
    return String.format("알맹이 수: %d, 현재 상태: %s", count, getStateDescription());
  }

  private String getStateDescription() {
    return switch (state) {
      case SOLD_OUT -> "알맹이 매진";
      case NO_QUARTER -> "동전 없음";
      case HAS_QUARTER -> "동전 있음";
      case SOLD -> "알맹이 판매";
      default -> "알맹이 매진";
    };
  }
}
