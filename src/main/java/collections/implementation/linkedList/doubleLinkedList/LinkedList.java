package collections.implementation.linkedList.doubleLinkedList;

public class LinkedList {
    private Node start;
    private Node end;

    public LinkedList() {
        start = null;
        end = null;
    }

    boolean insertBeginning(int data) {
        Node newNode = new Node(data);

        //empty list
        if (start == null) {
            start = newNode;
            end = newNode;
            return true;
        }

        //non-empty list
        start.setPrev(newNode);
        newNode.setNext(start);
        start = start.getPrev();
        return true;
    }

    boolean insertEnd(int data) {
        Node newNode = new Node(data);

        //empty list
        if (start == null) {
            start = newNode;
            end = newNode;
            return true;
        }

        //non-empty list
        end.setNext(newNode);
        newNode.setPrev(end);
        end = end.getNext();
        return true;
    }

    boolean insertAfter(int el_add, int el_existing) {
        Node nodeFound = search(el_existing);

        //element not found
        if (nodeFound == null) {
            return false;
        }

        //element is the last element
        if (nodeFound == end) {
            insertEnd(el_add);
            return true;
        }

        //insertion in the middle
        Node nodeToAdd = new Node(el_add);
        Node right = nodeFound.getNext();

        nodeFound.setNext(nodeToAdd);
        nodeToAdd.setPrev(nodeFound);

        nodeToAdd.setNext(right);
        right.setPrev(nodeToAdd);
        return true;
    }

    boolean insertBefore(int el_add, int el_existing) {
        Node nodeFound = search(el_existing);

        //element not found
        if (nodeFound == null) {
            return false;
        }

        //first element
        if (nodeFound == start) {
            insertBeginning(el_add);
            return true;
        }

        //insertion in the middle
        Node nodeToAdd = new Node(el_add);
        Node left = nodeFound.getPrev();

        left.setNext(nodeToAdd);
        nodeToAdd.setPrev(left);

        nodeFound.setPrev(nodeToAdd);
        nodeToAdd.setNext(nodeFound);
        return true;
    }

    public Node deleteBeginning() {
        //empty list
        if (start == null) {
            return null;
        }

        //one element list
        if (start == end) {
            Node deletedNode = start;
            start = null;
            end = null;
            return deletedNode;
        }

        //normal deletion
        Node deletedNode = start;
        start = start.getNext();
        start.setPrev(null);

        return deletedNode;
    }

    public Node deleteEnd() {
        //empty list
        if (start == null) {
            return null;
        }

        //one element list
        if (start == end) {
            Node deletedNode = start;
            start = null;
            end = null;
            return deletedNode;
        }

        //normal deletion
        Node deletedNode = end;
        end = end.getPrev();
        end.setNext(null);

        return deletedNode;
    }

    public Node deleteElement(int element) {
        Node nodeFound = search(element);

        //element not found
        if (nodeFound == null) {
            return null;
        }

        //element is the starting node
        if (nodeFound == start) {
            return deleteBeginning();
        }

        //element is the ending node
        if (nodeFound == end) {
            return deleteEnd();
        }

        //middle deleting
        Node nodeFoundPrev = nodeFound.getPrev();
        Node nodeFoundNext = nodeFound.getNext();
        nodeFoundPrev.setNext(nodeFoundNext);
        nodeFoundNext.setPrev(nodeFoundPrev);
        return nodeFound;
    }

    public Node search(int element) {
        //empty list
        if (start == null) {
            return null;
        }

        //one-element list
        if (start.getData() == end.getData()) {
            return start;
        }

        //normal search
        Node temp;
        temp = start;
        while (temp != null) {
            if (temp.getData() == element) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;

    }

    public void print() {
        Node temp;

        temp = start;

        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
