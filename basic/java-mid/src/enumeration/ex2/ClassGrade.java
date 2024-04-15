package enumeration.ex2;

public class ClassGrade {

  // 각각 인스턴스 생성? => 참조값이 서로 다르다.
  // 코드를 많이 작성해야 한다는 단점이 존재
  public static final ClassGrade BASIC = new ClassGrade(); // x001
  public static final ClassGrade GOLD = new ClassGrade(); // x002
  public static final ClassGrade DIAMOND = new ClassGrade(); // x003

  // private으로 막지 않으면 사용하는 의미가 사라짐
  private ClassGrade() {}
}
