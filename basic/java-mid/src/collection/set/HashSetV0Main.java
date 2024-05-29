package collection.set;

public class HashSetV0Main {

  public static void main(String[] args) {
    HashSetV0 set = new HashSetV0();
    set.add(1); // O(1)
    set.add(2); // O(n)
    set.add(3); // O(n)
    set.add(4); // O(n)
    System.out.println(set);

    boolean result = set.add(4);
    System.out.println("result = " + result);
    System.out.println(set);

    System.out.println("set.contains(3) = " + set.contains(3));
    System.out.println("set.contains(99) = " + set.contains(99));
  }
}
