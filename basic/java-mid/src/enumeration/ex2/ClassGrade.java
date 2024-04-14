package enumeration.ex2;

public class ClassGrade {

  // 각각 인스턴스 생성? => 참조값이 서로 다르다.
  public static final ClassGrade BASIC = new ClassGrade(); // x001
  public static final ClassGrade GOLD = new ClassGrade(); // x002
  public static final ClassGrade DIAMOND = new ClassGrade(); // x003

  private ClassGrade() {
  }
}
