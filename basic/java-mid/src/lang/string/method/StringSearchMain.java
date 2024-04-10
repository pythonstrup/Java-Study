package lang.string.method;

public class StringSearchMain {

  public static void main(String[] args) {
    String str = "Hello, Java! Welcome to Java world.";

    System.out.println("contain 'Java': " + str.contains("Java"));
    System.out.println("'Java'의 첫번째 인덱스: " + str.indexOf("Java"));
    System.out.println("'인덱스 10부터 Java'의 첫번째 인덱스: " + str.indexOf("Java", 10));
    System.out.println("'Java'의 마지막 인덱스: " + str.lastIndexOf("Java"));
  }
}