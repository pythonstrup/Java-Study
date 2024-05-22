package generic.ex1;

public class GenericBox<T> {

  private T value;

  public T get() {
    return value;
  }

  public void set(final T value) {
    this.value = value;
  }
}
