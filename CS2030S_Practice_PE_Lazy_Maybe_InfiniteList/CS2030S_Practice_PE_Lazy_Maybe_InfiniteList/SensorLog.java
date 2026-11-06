// @author:

import cs2030s.fp.InfiniteList;
import java.util.List;

public class SensorLog<T extends Sensor> {
  private InfiniteList<T> sensors;

  public SensorLog(InfiniteList<T> sensors) {
    this.sensors = sensors;
  }

  public void addSensor(T sensor) {
    // TODO: implement using InfiniteList only.
  }

  public void removeSensor(T sensor) {
    // TODO: remove all sensors with the same ID.
  }

  public InfiniteList<T> getSensors() {
    return this.sensors;
  }

  public double performAllActions() {
    return 0.0;
  }

  @Override
  public String toString() {
    return this.sensors.reduce("", (acc, elem) ->
        acc + "[" + elem.toString() + "]");
  }
}
