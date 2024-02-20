package atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceEx {

  public static void execute() {
    String oldName = "old name";
    String newName = "new name";
    AtomicReference<String> atomicReference = new AtomicReference<>(oldName);

    atomicReference.set("Unexpected Name"); // compareAndSet에서 인자로 전달한 값이 부합하지 않으면 false를 반환하고 변경되지 않는다.
    if (atomicReference.compareAndSet(oldName, newName)) {
      System.out.println("New Value is " + atomicReference.get());
    } else {
      System.out.println("Nothing Changed");
    }
  }
}
