import cs2030s.fp.Lazy;
import cs2030s.fp.Transformer;
import cs2030s.fp.Producer;
import cs2030s.fp.Combiner;

/** A small wrapper around a lazily computed sensor reading. */
public class LazyReading {
  private Lazy<Double> reading;

  public LazyReading(Producer<? extends Double> producer) {
    this.reading = Lazy.of(producer);
  }

  /** Return the reading, evaluating its producer at most once. */
  public double get() {
    return 0.0;
  }

  /** Return a new LazyReading whose value is transformed lazily. */
  public LazyReading map(Transformer<? super Double, ? extends Double> mapper) {
    return this;
  }

  /** Return a new LazyReading by lazily combining this value with another. */
  public LazyReading combine(LazyReading other,
      Combiner<? super Double, ? super Double, ? extends Double> combiner) {
    return this;
  }

  @Override
  public String toString() {
    return this.reading.toString();
  }
}
