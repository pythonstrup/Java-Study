package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV1 {

  public static void hello(Processor processor) {
    System.out.println("프로그램 시작");

    // 코드 조각 시작
    processor.process();
    // 코드 조각 종료

    System.out.println("프로그램 종료");
  }

  static class DiceProcessor implements Processor {

    @Override
    public void process() {
      int randomValue = new Random().nextInt(6) + 1;
      System.out.println("주사위 = " + randomValue);
    }
  }

  static class SumProcessor implements Processor {

    @Override
    public void process() {
      for (int i = 0; i < 3; i++) {
        System.out.println("i = " + i);
      }
    }
  }

  public static void main(String[] args) {
    hello(new DiceProcessor());
    hello(new SumProcessor());
  }
}
