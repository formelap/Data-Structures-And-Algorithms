package DoublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private Node<T> head;
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
        size++;

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

    public T get(int idx) {
        if(idx >= size)
            throw new IndexOutOfBoundsException();

        if(idx == 0)
            return getFirst();

        if(idx == (size - 1))
            return getLast();

        Node<T> tempNode = head;
        int tempIdx = 0;

        while(tempIdx != idx) {
            tempNode = tempNode.getNext();
            tempIdx++;
        }

        return tempNode.getData();
    }

    public T getFirst() {
        if(head == null)
            throw new NoSuchElementException();

        return head.getData();
    }

    public T getLast() {
        if(head == null)
            throw new NoSuchElementException();

        Node<T> tempNode = head;

        while(tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }

        return tempNode.getData();
    }

    public void remove(int idx) {
        if(idx >= size)
            throw new IndexOutOfBoundsException();

        if(idx == 0) {
            removeFirst();
            return;
        }

        if(idx == (size - 1)) {
            removeLast();
            return;
        }

        Node<T> tempNode = head;
        int tempIdx = 0;

        while(tempIdx != idx) {
            tempNode = tempNode.getNext();
            tempIdx++;
        }

        Node<T> previousNode = tempNode.getPrevious();
        Node<T> nextNode = tempNode.getNext();

        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);

        tempNode.setData(null);
        tempNode.setPrevious(null);
        tempNode.setNext(null);

        size--;
    }

    public void removeFirst() {
        if(head == null)
            throw new NoSuchElementException();

        Node<T> tempNode = head.getNext();

        head.setData(null);
        head.setNext(null);

        tempNode.setPrevious(null);
        head = tempNode;

        size--;
    }

    public void removeLast() {
        if(head == null)
            throw new NoSuchElementException();

        Node<T> tempNode = head;

        while(tempNode.getNext() != null)
            tempNode = tempNode.getNext();

        tempNode.getPrevious().setNext(null);

        tempNode.setData(null);
        tempNode.setPrevious(null);

        size--;

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
