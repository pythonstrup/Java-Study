package collection.array;

public class ArrayListV4Main {

  public static void main(String[] args) {
    ArrayListV4<String> stringList = new ArrayListV4<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");
//    stringList.add(1);
    String string = stringList.get(0);
    System.out.println("string = " + string);

    ArrayListV4<Integer> intList = new ArrayListV4<>();
    intList.add(1);
    intList.add(2);
    intList.add(3);
    Integer integer = intList.get(0);
    System.out.println("integer = " + integer);
  }
}
