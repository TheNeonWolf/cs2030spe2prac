// @author:

public class Sensor {
  private String id;
  private double reading;
  private SensorAction<Double> action;

  public Sensor(String id, double reading, SensorAction<Double> action) {
    this.id = id;
    this.reading = reading;
    this.action = action;
  }

  public String getId() {
    return this.id;
  }

  public double getReading() {
    return this.reading;
  }

  public SensorAction<Double> getAction() {
    return this.action;
  }

  public double performAction() {
    return this.action.perform();
  }

  public Sensor calibrate(Calibration calibration) {
    return this;
  }

  public Sensor changeAction(SensorAction<Double> action) {
    return this;
  }

  @Override
  public String toString() {
    return this.id + ": " + String.format("%.1f", this.reading);
  }
}
