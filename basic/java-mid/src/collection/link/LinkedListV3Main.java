package collection.link;

public class LinkedListV3Main {

  public static void main(String[] args) {
    LinkedListV3<String> stringList = new LinkedListV3<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");
    String str = stringList.get(0);
    System.out.println("str = " + str);

    LinkedListV3<Integer> intList = new LinkedListV3<>();
    intList.add(1);
    intList.add(2);
    intList.add(3);
    Integer integer = intList.get(0);
    System.out.println("integer = " + integer);
  }
}
