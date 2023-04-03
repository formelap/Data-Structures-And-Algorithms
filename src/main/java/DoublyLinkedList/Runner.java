package DoublyLinkedList;

public class Runner {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.add(0, 0);
        dll.add(3, 3);
        dll.add(5,5);
        dll.print();
        System.out.println("Size: " + dll.size());


    }
}
