package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {

  private int outInstanceVar = 3;

  public Printer process(int paramVar) {

    int localVar = 1; // 지역 변수는 스택 프레임이 종료되는 순간 함께 제거된다.

    class LocalPrinter implements Printer {
      int value = 0;

      @Override
      public void print() {
        System.out.println("value = " + value);

        // 인스턴스는 지역 변수보다 더 오래 살아 남는다.
        System.out.println("localVar = " + localVar);
        System.out.println("paramVar = " + paramVar);
        System.out.println("outInstanceVar = " + outInstanceVar);
      }
    }

    // localVar와 paramVar는 effectively final(사실상 final)이라 변경이 불가능하다.
    // 만약 localVar의 값을 변경한다면?? 다시 캡쳐해야 하나??
//    localVar = 10; // Variable 'localVar' is accessed from within inner class, needs to be final or effectively final
//    paramVar = 20; // Variable 'paramVar' is accessed from within inner class, needs to be final or effectively final

    // 지역 변수의 값이 달라지면, 스택 영역에 존재하는 지역 변수의 값과 인스턴스에 캡처한 캡처 변수의 값이 서로 달라지는 문제가 발생한다.
    // 이것을 동기화 문제라고 한다.
    return new LocalPrinter();
  }

  public static void main(String[] args) {
    LocalOuterV4 localOuter = new LocalOuterV4();
    Printer printer = localOuter.process(2);
    // printer.print()를 나중에 실행한다. process()의 스택 프레임이 사라진 이후에 실행
    printer.print();

    // 추가
    System.out.println("필드 확인");
    Field[] fields = printer.getClass().getDeclaredFields();
    for (Field field : fields) {
      System.out.println("field = " + field);
      // 숨겨진 필드(메소드가 존재하는 스택영역의 변수로부터 인스턴스가 존재하는 힙영역으로 캡처되어 온 지역변수, 파라미터)
      // final int nested.local.LocalOuterV3$1LocalPrinter.val$localVar
      // final int nested.local.LocalOuterV3$1LocalPrinter.val$paramVar
    }
  }
}
