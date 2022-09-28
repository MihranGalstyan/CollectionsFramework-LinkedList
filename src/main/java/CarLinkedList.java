/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class CarLinkedList implements CarList {
    private Node first;
    private Node last;
    private int size;

    @Override
    public Car get(final int index) {
        return getNode(index).value;
    }

    private Node getNode(final int index) {
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(final Car car) {
        if (size == 0) {
            Node node = new Node(null, car, null);
            first = node;
            last = node;
            size++;
        } else {
            Node node = new Node(last, car, null);
            last.next = node;
            last = node;
            size++;
        }
    }

    @Override
    public void add(final Car car, final int index) {
        if (index == size) {
            add(car);
            return;
        }

        checkIndex(index);
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodeNext.previous, car, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    @Override
    public boolean removeAt(final int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null){
            nodeNext.previous = nodePrevious;
        }
        if (nodePrevious != null){
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size --;
        return true;
    }

    @Override
    public boolean remove(final Car car) {
        Node node = first;

        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)){
                removeAt(i);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
    }

    private class Node {
        Node previous;
        Node next;
        Car value;

        public Node(final Node previous, final Car value, final Node next) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }
    }
}
