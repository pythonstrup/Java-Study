package race.condition.atomic.operations;

public class MinMaxMetrics {

  // Add all necessary member variables
  private volatile long min;
  private volatile long max;

  /**
   * Initializes all member variables
   */
  public MinMaxMetrics() {
    // Add code here
  }

  /**
   * Adds a new sample to our metrics.
   */
  public void addSample(long newSample) {
    // Add code here
    synchronized (this) {
      this.max = Math.max(this.max, newSample);
      this.min = Math.min(this.min, newSample);
    }
  }

  /**
   * Returns the smallest sample we've seen so far.
   */
  public long getMin() {
    // Add code here
    return min;
  }

  /**
   * Returns the biggest sample we've seen so far.
   */
  public long getMax() {
    // Add code here
    return max;
  }
}
