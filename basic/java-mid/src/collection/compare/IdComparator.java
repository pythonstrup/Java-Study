package collection.compare;

import java.util.Comparator;

public class IdComparator implements Comparator<MyUser> {

  @Override
  public int compare(final MyUser o1, final MyUser o2) {
    return o1.getId().compareTo(o2.getId());
  }
}
