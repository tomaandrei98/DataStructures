package collections.implementation.linkedList.doubleLinkedList;

public class Node {
    private int data;
    private Node prev;  //self-referential
    private Node next;  //self-referential

    public Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
