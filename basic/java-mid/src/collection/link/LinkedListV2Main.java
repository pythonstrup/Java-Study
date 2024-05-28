package collection.link;

public class LinkedListV2Main {

  public static void main(String[] args) {
    LinkedListV2 list = new LinkedListV2();

    list.add("a");
    list.add("b");
    list.add("c");
    System.out.println(list);

    list.add(0, "d");
    System.out.println(list);

    list.remove(0);
    System.out.println(list);

    list.add(1, "e");
    System.out.println(list);

    Object removeItem = list.remove(1);
    System.out.println(list);
  }
}
