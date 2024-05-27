package collection.array;

public class ArrayListV3Main {

  public static void main(String[] args) {
    ArrayListV3 list = new ArrayListV3();
    list.add("a");
    list.add("b");
    list.add("c");
    System.out.println(list);

    // 원하는 위치에 추가
    System.out.println("addLast");
    list.add(3, "addLast");
    System.out.println(list);

    System.out.println("addFirst");
    list.add(0, "addFirst");
    System.out.println(list);

    // 삭제
    Object removed1 = list.remove(4);
    System.out.println("removed(4) = " + removed1);
    System.out.println(list);

    Object removed2 = list.remove(0);
    System.out.println("removed(0) = " + removed2);
    System.out.println(list);
  }
}
