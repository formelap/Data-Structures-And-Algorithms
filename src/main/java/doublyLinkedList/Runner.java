package doublyLinkedList;

public class Runner {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

        dll.add(0,1);
        dll.addFirst(0);
        dll.addLast(3);
        dll.addLast(4);
        dll.add(2,2);

        dll.print();
        System.out.println("Size: " + dll.size());

        System.out.println(dll.getFirst() == 0);
        System.out.println(dll.getLast() == 4);
        System.out.println(dll.get(2) == 2);

        dll.remove(2);
        dll.removeFirst();
        dll.removeLast();

        dll.print();
        System.out.println("Size: " + dll.size());


    }
}
