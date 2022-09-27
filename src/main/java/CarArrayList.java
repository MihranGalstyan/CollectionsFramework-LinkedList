import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(final int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(final Car car) {
        if (size >= array.length) {
            increase();
        }
        array[size] = car;
        size++;
    }

    @Override
    public boolean removeAt(final int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(final Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void increase() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index provided");
        }
    }
}
