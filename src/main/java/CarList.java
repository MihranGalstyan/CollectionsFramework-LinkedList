/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public interface CarList {
    Car get(int index);

    void add(Car car);

    void add(Car car, int index);

    boolean removeAt(int index);

    boolean remove(Car car);

    int size();

    void clear();
}
