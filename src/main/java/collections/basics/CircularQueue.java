package collections.basics;

public class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;

    public CircularQueue(int len) {
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
        if (rear - front == arr.length - 1 || front - rear == 1) {
            return false;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
            arr[0] = element;
            return true;
        }

        rear = rear++ % arr.length;
        arr[rear] = element;
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
        front = front++ % arr.length;
        return temp;
    }
}
