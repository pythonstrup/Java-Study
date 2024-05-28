package collection.link;

public class LinkedListV1 {

  private Node first;
  private int size = 0;

  public void add(Object element) {
    Node newNode = new Node(element);
    if (first == null) {
      first = newNode;
    } else {
      Node lastNode = getLastNode();
      lastNode.next = newNode;
    }
    size++;
  }

  public Node getLastNode() {
    Node x = first;
    while (x.next != null) {
      x = x.next;
    }
    return x;
  }

  public Object set(int index, Object element) {
    Node x = getNode(index);
    Object oldValue = x.item;
    x.item = element;
    return oldValue;
  }

  public Object get(int index) {
    Node node = getNode(index);
    return node.item;
  }

  private Node getNode(final int index) {
    Node x = first;
    for (int i = 0; i < index; i++) {
      x = x.next;
    }
    return x;
  }

  public int indexOf(Object o) {
    int index = 0;
    for (Node x = first; x != null; x = x.next) {
      if (o.equals(x.item)) {
        return index;
      }
      index++;
    }
    return -1;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "LinkedListV1{" +
        "first=" + first +
        ", size=" + size +
        '}';
  }
}
