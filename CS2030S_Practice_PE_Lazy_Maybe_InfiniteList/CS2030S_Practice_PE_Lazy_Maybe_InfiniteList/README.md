# CS2030S Practice PE — Sensor Tracker (Lazy + Maybe + InfiniteList)

**Time allowed:** 110 minutes  
**Total:** 20 marks (4 tasks × 5 marks)

This is an original practice exercise inspired by the structure of the supplied PE2 practice. It deliberately tests all three abstractions: `Lazy`, `Maybe`, and `InfiniteList`.

## Instructions
- Complete `LazyReading.java`, `Sensor.java`, `SensorLog.java`, and `SensorLogManager.java`.
- The provided `cs2030s.fp` package is available. Refer to `InfiniteList.md` and `Maybe.md` for the abridged APIs.
- Do not modify method descriptors or add fields/methods unless explicitly permitted.
- For functional-style methods, do not use loops, arrays, conditional expressions (`?:`), block lambdas, `java.util.Optional`, or Java Streams.
- Do not add imports beyond those already supplied.
- Compile from this directory with: `javac -Xlint:unchecked -Xlint:rawtypes *.java`

## Provided functional interfaces
- `SensorAction<T>`: `T perform()`
- `Calibration`: `Sensor calibrate(Sensor sensor)`

---

## Task 1 — LazyReading [5 marks]

Complete `LazyReading`, which wraps a `Lazy<Double>`.

Implement:
1. `get()`: return the lazily computed value.
2. `map(mapper)`: return a new `LazyReading` whose value is the result of applying `mapper` to this reading. The mapper must not run until the resulting reading is evaluated.
3. `combine(other, combiner)`: return a new `LazyReading` whose value is obtained by combining the values of the two readings. Neither reading should be evaluated until the combined result is evaluated.

The `Lazy` implementation is provided. Do not implement memoisation yourself and do not add fields or methods.

### Example behaviour
```java
int[] calls = {0};
LazyReading a = new LazyReading(() -> {
  calls[0]++;
  return 10.0;
});
LazyReading b = a.map(x -> x * 2.0);

b.toString(); // "?" (not evaluated)
b.get();      // 20.0
b.get();      // 20.0; producer is not recomputed
calls[0];     // 1
```

---

## Task 2 — Immutable Sensor [5 marks]

Rewrite `Sensor` as an immutable class. It has exactly three fields:
- `id` (`String`)
- `reading` (`double`)
- `action` (`SensorAction<Double>`)

Implement the constructor, accessors, and methods:
- `performAction()`: invoke and return the action's result.
- `calibrate(Calibration calibration)`: return the calibrated sensor without modifying the original.
- `changeAction(SensorAction<Double> action)`: return a new sensor with the same ID and reading but the new action.

Do not add fields or methods. Preserve the provided `toString()` behaviour.

---

## Task 3 — Functional SensorLog [5 marks]

Rewrite `SensorLog` to use `InfiniteList<Sensor>` instead of `java.util.List<Sensor>`.

Implement:
- `addSensor(Sensor sensor)`: add the sensor to the end of the log.
- `removeSensor(Sensor sensor)`: remove all sensors whose IDs equal the given sensor's ID.
- `getSensors()`: return the `InfiniteList<Sensor>`.
- `performAllActions()`: invoke every sensor's action and return the sum of the results.

Preserve the provided `toString()` behaviour. Use only the provided `InfiniteList` API. Note that `InfiniteList.append` is not public.

---

## Task 4 — SensorLogManager [5 marks]

Implement these static methods using `InfiniteList` and `Maybe` where appropriate:

1. `calculateTotal(SensorLog<Sensor> log)`: return the sum of all sensor readings. An empty log returns `0.0`.
2. `highestReading(SensorLog<Sensor> log)`: return the sensor with the highest reading. If two sensors tie, return the first one. You may assume the log is non-empty. **Use `Maybe` in your solution** to select between the current best sensor and the next sensor; do not use `if`, `?:`, or `Optional`.
3. `calibrateAll(SensorLog<Sensor> log, InfiniteList<Calibration> calibrations)`: for each sensor, apply every calibration in order and return a new `SensorLog<Sensor>` containing the resulting sensors. The original log and sensors must remain unchanged.

---

## Suggested time allocation
- Task 1 — LazyReading: 20 minutes
- Task 2 — Immutable Sensor: 20 minutes
- Task 3 — Functional SensorLog: 30 minutes
- Task 4 — SensorLogManager: 30 minutes
- Compile and review: 10 minutes
