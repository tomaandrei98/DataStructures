package collections;

public class Queue {
    int[] arr;
    int front;
    int rear;

    public Queue(int len) {
        initialSetUpLength(len);
        front = -1;
        rear = -1;
    }

    private void initialSetUpLength(int len) {
        if (len >= 0) {
            arr = new int[len];
        } else {
            arr = new int[10];
        }
    }

    boolean addRear(int element) {
        //full queue
        if (rear == arr.length - 1) {
            return false;
        }

        //empty queue
        if (front == -1) {
            front = 0;
            rear = 0;
            arr[0] = element;
            return true;
        }

        //normal adding in a queue
        rear++;
        arr[rear] = element;
        return true;
    }

    int deleteFront() {
        //empty queue
        if (front == -1) {
            throw new IllegalStateException("empty queue");
        }

        //last element from queue
        if (front == rear) {
            int temp = arr[rear];
            front = -1;
            rear = -1;
            return temp;
        }

        //normal deleting from a queue
        int temp = arr[front];
        front++;
        return temp;
    }


    private String printStack() {
        StringBuilder output = new StringBuilder();

        for (Integer i : arr) {
            output.append(i).append(", ");
        }

        return output.substring(0, output.length() - 2);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "arr=[" + printStack() +
                "]}";
    }
}
