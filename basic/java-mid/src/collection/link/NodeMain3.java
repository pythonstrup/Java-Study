package collection.link;

public class NodeMain3 {

  public static void main(String[] args) {
    Node first = new Node("A");
    first.next = new Node("B");
    first.next.next = new Node("C");

    System.out.println(first);

    // 모든 노드 탐색
    printAll(first);

    // 마지막 노드 조회
    Node lastNode = getLastNode(first);
    System.out.println("lastNode = " + lastNode);

    // 특정 index 노드 조회
    int index = 2;
    Node index2Node = getNode(first, index);
    System.out.println("index2Node = " + index2Node);

    // 데이터 추가하기
    add(first, "D");
    System.out.println(first);
    add(first, "E");
    System.out.println(first);
    add(first, "F");
    System.out.println(first);
  }

  private static void printAll(final Node node) {
    Node x = node;
    while (x != null) {
      System.out.println(x.item);
      x = x.next;
    }
  }

  private static Node getLastNode(final Node node) {
    Node x = node;
    while (x.next != null) {
      x = x.next;
    }
    return x;
  }

  private static Node getNode(final Node node, final int index) {
    Node x = node;
    for (int i = 0; i < index; i++) {
      x = x.next;
    }
    return x;
  }

  private static void add(final Node node, final String param) {
    Node lastNode = getLastNode(node);
    lastNode.next = new Node(param);
  }
}
