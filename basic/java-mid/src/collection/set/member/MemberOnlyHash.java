package collection.set.member;

import java.util.Objects;

public class MemberOnlyHash {

  public String id;

  public MemberOnlyHash(final String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "MemberOnlyHash{" +
        "id='" + id + '\'' +
        '}';
  }
}
