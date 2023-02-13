package collections.basics;

public class Stack {
    private int[] arr;
    private int top;
    private int len;

    public Stack(int len) {
        initialSetUpLength(len);
        top = -1;
    }

    private void initialSetUpLength(int len) {
        if (len >= 0) {
            arr = new int[len];
            this.len = len;
        } else {
            arr = new int[10];
            this.len = 10;
        }
    }

    boolean push(int element) {
        if (top == arr.length - 1) {
            return false;
        }

        top++;
        arr[top] = element;
        return true;
    }

    int pop() {
        if (top == -1) {
            throw new IllegalStateException("empty stack");
        }

        int temp = arr[top];
        top--;
        return temp;
    }

    private String printStack() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i <= top; i++) {
            output.append(arr[i]).append(", ");
        }

        return (output.length() > 2) ? output.substring(0, output.length() - 2) : "";
    }

    public int[] getArr() {
        return arr;
    }

    public int getTop() {
        return top;
    }

    public int getLen() {
        return len;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=[" + printStack() +
                "]}";
    }
}
