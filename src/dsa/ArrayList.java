package dsa;

import java.util.Arrays;

public class ArrayList<T>{

    private final static int DEFAULT_INIT_SIZE = 10;


    private T[] array;
    private int size;

    private int multiplicity = 2;

    public ArrayList(final int initialSize) {
        this.array = (T[]) new Object[initialSize];
        this.size = 0;
    }

    public ArrayList() {
        this.array = (T[]) new Object[DEFAULT_INIT_SIZE];
        this.size = 0;
    }

    // O(1)
    public T get(final int index) {
        return this.array[index];
    }

    // O(1) if size can sustain
    // O(n) worst-case
    public ArrayList<T> addItem(T item) {
        if (size == array.length) {
            extendArray();
        }
        array[size] = item;
        size++;
        return this;
    }

    // O(n)
    private void extendArray(int newSize) {
        T[] tempArray = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }
    private void extendArray() {
        extendArray(multiplicity * array.length);
    }

    // O(n)
    public ArrayList<T> removeItem(final int index) {
        array[index] = null;
        shiftLeft(index);
        size--;
        return this;
    }

    // O(1) if index within current array size
    // O(n) if not (worst-case)
    public ArrayList<T> setItem(final int index, final T item) {
        if (index >= array.length) {
            extendArray(index * multiplicity);
        }
        array[index] = item;
        return this;
    }

    // O(n)
    private ArrayList<T> shiftLeft(final int startingIndex) {
        for (int i = startingIndex; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        return this;
    }

    // O(n)
    public T[] toArray() {
        T[] tempArray = (T[]) new Object[size];
        System.arraycopy(array, 0, tempArray, 0, size);
        return tempArray;
    }

    public void print() {
        System.out.println(Arrays.toString(toArray()));
    }

}
