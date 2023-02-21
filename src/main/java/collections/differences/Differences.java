package collections.differences;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Differences {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList();
        List<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;

        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        //linked list
        startTime = System.nanoTime();
//        linkedList.get(999_999);
        linkedList.remove(999_999);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Linked List: \t" + elapsedTime + " ns");

        //array list
        startTime = System.nanoTime();
//        arrayList.get(999_999);
        arrayList.remove(999_999);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Array List: \t" + elapsedTime + " ns");

    }
}
