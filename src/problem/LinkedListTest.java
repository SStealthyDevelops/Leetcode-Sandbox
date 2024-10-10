package problem;

import dsa.LinkedList;

public class LinkedListTest implements Problem {
    @Override
    public void run() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        System.out.println("Size: " + list.getSize());
        list.print();
        System.out.println("Index: " + list.indexOf(40));
        System.out.println("Item @ index: 3: " + list.get(3));
        list.removeLast();
        list.print();
        list.removeFirst();
        list.print();
        list.addFirst(80);
        list.print();

    }
}
