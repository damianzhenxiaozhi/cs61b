package main.java;

public class AList<T> {
    private T[] array;
    private int size;
    private int capacity;

    public AList() {
        capacity = 100;
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addLast(T x) {
        if (size >= capacity) {
            expandSize();
        }
        array[size] = x;
        size += 1;
    }

    private void expandSize() {
        capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public T getLast() {
        if (size == 0) {
            return null;
        }

        return array[size - 1];
    }

    public T get(int i) {
        if (i >= size || i < 0) {
            return null;
        }

        return array[i];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (size < capacity / 2) {
            shrinkSize();
        }

        T last = array[size - 1];
        size -= 1;
        return last;
    }

    private void shrinkSize() {
        capacity /= 2;
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
