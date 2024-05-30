package collection.set;

public class HashSetV1Main {

  public static void main(String[] args) {
    HashSetV1 set = new HashSetV1(10);
    set.add(1);
    set.add(2);
    set.add(5);
    set.add(8);
    set.add(14);
    set.add(99);
    set.add(9); // hashIndex 중복
    System.out.println(set);

    // search
    int searchValue = 9;
    boolean result = set.contains(searchValue);
    System.out.println("set.contains(" + searchValue + ") = " + result);

    // delete
    boolean removedResult = set.remove(searchValue);
    System.out.println("removedResult = " + removedResult);
    System.out.println(set);
  }
}
