import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toMap;

public class MyApp {
    // The int enum pattern - severely deficient!
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;
    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    // Tasty citrus flavored applesauce!
    int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;

    public enum Apple { FUJI, PIPPIN, GRANNY_SMITH }
    public enum Orange { NAVEL, TEMPLE, BLOOD }



    // Enum type with data and behavior
    public enum Planet {
        MERCURY(3.302e+23, 2.439e6),
        VENUS (4.869e+24, 6.052e6),
        EARTH (5.975e+24, 6.378e6),
        MARS (6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN (5.685e+26, 6.027e7),
        URANUS (8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7);
        private final double mass; // In kilograms
        private final double radius; // In meters
        private final double surfaceGravity; // In m / s^2
        // Universal gravitational constant in m^3 / kg s^2
        private static final double G = 6.67300E-11;
        // Constructor
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }
        public double mass() { return mass; }
        public double radius() { return radius; }
        public double surfaceGravity() { return surfaceGravity; }
        public double surfaceWeight(double mass) {
            return mass * surfaceGravity; // F = ma
        }
    }


    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("5");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Weight on %s is %f%n",
                    p, p.surfaceWeight(mass));

        double x = Double.parseDouble("5");
        double y = Double.parseDouble("6");
        for (Operation3 op : Operation3.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));


         Consumer<MyApp> str = test1( MyApp::toStr );

         MyApp app = new MyApp();

         str.accept(app);

    }

    public String toStr() {

        return "k";
    }



    // Enum type that switches on its own value - questionable
    public enum Operation {
        PLUS, MINUS, TIMES, DIVIDE;
        // Do the arithmetic operation represented by this constant
        public double apply(double x, double y) {
            switch(this) {
                case PLUS: return x + y;
                case MINUS: return x - y;
                case TIMES: return x * y;
                case DIVIDE: return x / y;
            }
            throw new AssertionError("Unknown op: " + this);
        }
    }

    // Enum type with constant-specific method implementations
    public enum Operation2 {
        PLUS {public double apply(double x, double y){return x + y;}},
        MINUS {public double apply(double x, double y){return x - y;}},
        TIMES {public double apply(double x, double y){return x * y;}},
        DIVIDE{public double apply(double x, double y){return x / y;}};

        public abstract double apply(double x, double y);
    }

    // Enum type with constant-specific class bodies and data
    public enum Operation3 {
        PLUS("+") {
            public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y; }
        };

        private final String symbol;

        Operation3(String symbol) { this.symbol = symbol; }

        @Override public String toString() { return symbol; }

        public abstract double apply(double x, double y);

        // Implementing a fromString method on an enum type
        private static final Map<String, Operation3> stringToEnum =
                Stream.of(values()).collect(
                        toMap(Object::toString, e -> e));

        // Returns Operation for string, if any
        public static Optional<Operation3> fromString(String symbol) {
            return Optional.ofNullable(stringToEnum.get(symbol));
        }
    }


    public static <T,R > Consumer<T> test1(Function<T,R> functor) {

        Consumer<T> consumer = ( a ) -> functor.apply(a);

        return consumer;
    }


    // Enum that switches on its value to share code - questionable
    enum PayrollDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        SATURDAY, SUNDAY;
        private static final int MINS_PER_SHIFT = 8 * 60;
        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;
            int overtimePay;
            switch(this) {
                case SATURDAY: case SUNDAY: // Weekend
                    overtimePay = basePay / 2;
                    break;
                default: // Weekday
                    overtimePay = minutesWorked <= MINS_PER_SHIFT ?
                            0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
            }
            return basePay + overtimePay;
        }
    }

    // The strategy enum pattern
    enum PayrollDay2 {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
        private final PayType payType;
        PayrollDay2(PayType payType) { this.payType = payType; }
        PayrollDay2() { this(PayType.WEEKDAY); } // Default
        int pay(int minutesWorked, int payRate) {
            return payType.pay(minutesWorked, payRate);
        }
        // The strategy enum type
        private enum PayType {
            WEEKDAY {
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked <= MINS_PER_SHIFT ? 0 :
                            (minsWorked - MINS_PER_SHIFT) * payRate / 2;
                }
            },
            WEEKEND {
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked * payRate / 2;
                }
            };
            abstract int overtimePay(int mins, int payRate);
            private static final int MINS_PER_SHIFT = 8 * 60;
            int pay(int minsWorked, int payRate) {
                int basePay = minsWorked * payRate;
                return basePay + overtimePay(minsWorked, payRate);
            }
        }
    }



}
