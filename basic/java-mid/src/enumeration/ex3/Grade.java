package enumeration.ex3;


// ex2에서 직접한 구현한 타입 안전  열거형 패턴 클래스와 원리가 동일하다.
// 열거형은 인터페이스를 구현할 수 있다.
// 또한 추상 메소드를 선언하고 구현할 수 있다. => 이 경우 익명 클래스와 같은 방식으로 사용한다.
public enum Grade { // 이미 Enum을 상속받은 상태기 때문에 다른 클래스를 상속받을 수 없다.
  BASIC, GOLD, DIAMOND
}
