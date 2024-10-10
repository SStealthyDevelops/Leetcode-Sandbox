package dsa;

import java.util.Arrays;

public class LinkedList<T> {

    private class Node {
        T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        public Node setNext(Node next) {
            this.next = next;
            return this;
        }
        public Node getNext() {
            return this.next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // O(1)
    public void addFirst(T data) {
        Node newData = new Node(data);
        if (head == null) {
            head = newData;
            tail = newData;
            size++;
            return;
        }
        head = newData.setNext(head);
        size++;
    }

    // O(1)
    public void addLast(T data) {
        Node newData = new Node(data);
        if (head == null) {
            head = newData;
            tail = newData;
            size++;
            return;
        }
        tail.setNext(newData);
        tail = newData;
        size++;
    }

    /**
     * O(n) time
     * @return Data that was removed
     */
    public T removeLast() {
        Node current = head;
        while (current != null) {
            if (current.getNext() == tail) {
                T data = current.data;
                tail = current;
                tail.setNext(null);
                size--;
                return data;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * O(1)
     * @return Data that was removed
     */
    public T removeFirst() {
        T data = head.data;
        head = head.getNext();
        size--;
        return data;
    }

    /**
     *  O(n)
     * @param index Index to remove item from
     * @return The data that was removed
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.getNext();
        }
        assert prev != null;
        prev.setNext(current.getNext());
        size--;
        T data = current.data;
        current = null;
        return data;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        System.out.println(Arrays.toString(toArray()));
    }

    // O(n)
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        if (head == null || size == 0) { // Empty array
            return arr;
        }
        Node current = head;
        int counter = 0;
        while (current != null) {
            arr[counter] = current.data;
            current = current.getNext();
            counter++;
        }
        return arr;
    }

    /**
     * O(n)
     * @param index Index of search
     * @return The data at specified index
     */
    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.data;
    }

    /**
     * O(n)
     * @param data Data (pointer) to search for
     * @return int Index of the data
     */
    public int indexOf(T data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }




}
