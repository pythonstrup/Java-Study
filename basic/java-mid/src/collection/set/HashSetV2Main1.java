package collection.set;

public class HashSetV2Main1 {

  public static void main(String[] args) {
    HashSetV2 set = new HashSetV2(10);
    set.add("A");
    set.add("B");
    set.add("C");
    set.add("D");
    set.add("AB");
    set.add("SET");
    System.out.println(set);

    System.out.println("A.hashCode() = " + "A".hashCode());
    System.out.println("B.hashCode() = " + "B".hashCode());
    System.out.println("AB.hashCode() = " + "AB".hashCode());
    System.out.println("SET.hashCode() = " + "SET".hashCode());
    
    // search
    String searchValue = "SET";
    boolean result = set.contains(searchValue);
    System.out.println("set.contains(" + searchValue + ") = " + result);
  }
}
