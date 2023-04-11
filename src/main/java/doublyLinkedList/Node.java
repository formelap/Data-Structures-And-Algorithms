package doublyLinkedList;

class Node<T> {
    private T data;
    private Node<T> previous;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    Node getPrevious() {
        return previous;
    }

    void setPrevious(Node previous) {
        this.previous = previous;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
