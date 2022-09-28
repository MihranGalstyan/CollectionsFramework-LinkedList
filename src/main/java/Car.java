import java.util.Objects;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Car {
    private String brand;
    private int number;

    public Car(final String brand, final int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final Car car = (Car) object;
        return number == ((Car) object).number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }
}
