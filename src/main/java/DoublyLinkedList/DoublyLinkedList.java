package DoublyLinkedList;

public class DoublyLinkedList<T> {
    private Node head;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(int idx, T data) {
        if (idx > size)
            throw new IndexOutOfBoundsException();

        if (idx == 0) {
            addFirst(data);
            return;
        }

        if(idx == size) {
            addLast(data);
            return;
        }

        final Node<T> node = new Node<>(data);
        size++;

        Node<T> tempNode = head;
        int tempIdx = 0;

        while (tempIdx != idx) {
            tempIdx++;
            tempNode = tempNode.getNext();
        }

        Node<T> previousNode = tempNode.getPrevious();

        previousNode.setNext(node);
        node.setPrevious(previousNode);
        node.setNext(tempNode);
        tempNode.setPrevious(node);

    }

    public void addFirst(T data) {
        final Node<T> node = new Node<>(data);
        size++;

        if (head == null) {
            head = node;
            return;
        }

        head.setPrevious(node);
        node.setNext(head);
        head = node;
    }

    public void addLast(T data) {
        final Node<T> node = new Node<>(data);
        size++;

        if (head == null) {
            head = node;
            return;
        }

        Node<T> tempNode = head;

        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }

        tempNode.setNext(node);
        node.setPrevious(tempNode);

    }


    public int size() {
        return size;
    }

    public void print() {
        Node<T> tempNode = head;

        while (tempNode != null) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }

    }


}
