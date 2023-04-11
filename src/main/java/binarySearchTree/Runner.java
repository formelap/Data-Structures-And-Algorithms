package binarySearchTree;

public class Runner {

    public static void main(String[] args) {

        int[] data = {60, 40, 80, 10, 90, 100, 70, 50, 20, 30};

        BinarySearchTree bst = new BinarySearchTree();

        for (int value : data) {
            bst.insert(value);
        }

        System.out.println(bst.findMinimum());

        bst.delete(60);

        bst.print();


    }
}
