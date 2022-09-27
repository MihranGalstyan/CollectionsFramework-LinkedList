import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
class CarListTest {
    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand " + i, i));
        }
    }

    @Test
    void get() {
    }

    @Test
    void whenAdded100ElementsThenSizeIs100() {
        assertEquals(carList.size(), 100);
    }

    @Test
    void whenElementRemovedByIndexThenSizeMustDecreased() {
        assertTrue(carList.removeAt(24));
        assertEquals(carList.size(), 99);
    }

    @Test
    void whenElementRemovedThenSizeMustDecreased() {
        Car newCar = new Car("Maserati", 11);
        carList.add(newCar);
        assertEquals(carList.size(), 101);
        assertTrue(carList.remove(newCar));
        assertEquals(carList.size(), 100);

    }

    @Test
    void whenNonExistantElementRemovedThenReturnFalse() {
        Car newCar = new Car("Maserati", 11);
        assertEquals(carList.size(), 100);
        assertFalse(carList.remove(newCar));
        assertEquals(carList.size(), 100);
    }

    @Test
    void whenListIsClearedThenSizeMustBe0() {
        assertEquals(carList.size(), 100);
        carList.clear();
        assertEquals(carList.size(), 0);
    }

    @Test
    void whenIndexIsOutOfBoundsThenExceptionIsThrown() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    carList.get(100);
                });
    }

    @Test
    void methodGetReturnsRightValue() {
        Car newCar = new Car("BMW", 5);
        carList.add(newCar);
        assertEquals(carList.get(100), newCar);
    }
}