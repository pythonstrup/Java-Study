package collection.array;

public class ArrayListV2Main {

  public static void main(String[] args) {
    ArrayListV2 list = new ArrayListV2(2);
    System.out.println(list);
    list.add("a");
    System.out.println(list);
    list.add("b");
    System.out.println(list);
    list.add("c");
    System.out.println(list);
    list.add("d");
    System.out.println(list);
    list.add("e");
    System.out.println(list);

    // 범위 초과, capacity 가 자동으로 늘어남
    list.add("f");
    System.out.println(list);
  }
}
