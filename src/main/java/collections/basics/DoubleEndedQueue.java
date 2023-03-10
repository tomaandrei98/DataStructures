package collections.basics;

import java.util.Arrays;

public class DoubleEndedQueue {
    private int[] arr;
    private int front;
    private int rear;

    public DoubleEndedQueue(int len) {
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
            arr[rear] = element;
            return true;
        }

        rear++;
        arr[rear] = element;
        return true;
    }

    boolean addFront(int element) {
        //full queue
        if (front == 0) {
            return false;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
            arr[front] = element;
            return true;
        }

        front--;
        arr[front] = element;
        return true;
    }

    int deleteFront() {
        //empty queue
        if (front == -1) {
            throw new IllegalStateException("empty queue");
        }

        //last element
        if (front == rear) {
            int temp = arr[front];
            front = -1;
            rear = -1;
            return temp;
        }

        int temp = arr[front];
        front++;
        return temp;
    }

    int deleteRear() {
        //empty queue
        if (front == -1) {
            throw new IllegalStateException("empty queue");
        }

        //last element
        if (front == rear) {
            int temp = arr[front];
            front = -1;
            rear = -1;
            return temp;
        }

        int temp = arr[rear];
        rear--;
        return temp;
    }


    public int[] getArr() {
        int[] result = new int[rear+1];
        for (int i = front, j = 0; i <= rear && j <= rear; i++, j++) {
            result[j] = arr[i];
        }
        return result;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    @Override
    public String toString() {
        return "DoubleEndedQueue{" +
                "arr=" + Arrays.toString(arr) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }
}
