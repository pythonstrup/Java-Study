package generic.ex5;

// 타입 이레이저
// 하위 호환을 맞추기 위해 컴파일 시점에 제네릭 타입 정보를 제거하고,
// 런타임 시점에는 원시 타입(Raw Type)으로 처리하는 것을 말한다.
public class EraserBox<T> {

  public boolean instanceCheck(Object param) {
//    return param instanceof T; // 컴파일 오류
    // 컴파일 되는 순간, EraserBox의 Type은 Object로 명시된다. 그리고 아래와 같이 코드가 변경된다.
//    return param instanceof Object;
    // 무조건 참이 반환되는 문제가 발생하기 때문에 타입 매개변수에 instanceof 사용하는 것을 허용하지 않는다. => 개발자가 의도하는 것과 다르기 때문에
    return false;
  }

  public void create() {
//    new T();  // 컴파일 오류
    // 무조건 new Object()를 해버리기 때문에
  }
}
