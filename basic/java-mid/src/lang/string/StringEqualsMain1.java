package lang.string;

public class StringEqualsMain1 {

  public static void main(String[] args) {
    String str1 = new String("hello"); // x001
    String str2 = new String("hello"); // x002
    System.out.println("new String() == 비교: " + (str1 == str2));
    System.out.println("new String() equals 비교: " + (str1.equals(str2)));

    // 문자열 리터럴을 사용하는 경우 자바는 메모리 효율성과 성능 최적화를 위해 문자열 풀을 사용한다.
    // => 하지만 equals를 사용하는 것이 좋다. 모든 String이 리터럴로 만들어졌다는 것을 보장할 수 없기 때문이다.
    String str3 = "hello"; // x003
    String str4 = "hello"; // String pool에 의해 str3와 같은 참조값을 가지게 된다.
    System.out.println("Literal == 비교: " + (str3 == str4)); // 따라서 true다.
    System.out.println("Literal equals 비교: " + (str3.equals(str4)));
  }
}
