package problem;

import dsa.ArrayList;

public class ArrayListTest implements Problem {

    @Override
    public void run() {
        ArrayList<Integer> list = new ArrayList<>(3);
        list.addItem(10);
        list.addItem(20);
        list.addItem(30);
        list.addItem(40);
        list.print();
        System.out.println(list.get(2));
        list.removeItem(2);
        list.print();
    }
}
