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
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand " + i, i));
        }
    }

    @Test
    void get() {
        assertEquals(carList.get(50).getBrand(),"Brand 50");
    }

    @Test
    void whenAdded100ElementsThenSizeIs100() {
        assertEquals(carList.size(), 100);
    }

    @Test
    void insertIntoMiddle() {
        Car bmw = new Car("BMW", 88);
        carList.add(bmw, 50);
        assertEquals(carList.get(50), bmw);
        assertEquals(carList.size(), 101);
    }

    @Test
    void insertIntoFirstPosition() {
        Car bmw = new Car("BMW", 88);
        carList.add(bmw, 0);
        assertEquals(carList.get(0), bmw);
        assertEquals(carList.size(), 101);
    }

    @Test
    void insertIntoLastPosition() {
        Car bmw = new Car("BMW", 88);
        carList.add(bmw, 100);
        assertEquals(carList.get(100), bmw);
        assertEquals(carList.size(), 101);
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
    void whenNonExistentElementRemovedThenReturnFalse() {
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
                () -> carList.get(100));
    }

    @Test
    void methodGetReturnsRightValue() {
        Car newCar = new Car("BMW", 5);
        carList.add(newCar);
        assertEquals(carList.get(100), newCar);
    }
}