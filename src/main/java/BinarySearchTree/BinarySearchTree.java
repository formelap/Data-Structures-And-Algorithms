package BinarySearchTree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public BinarySearchTree(int rootValue) {

        this.root = new Node(rootValue);
    }

    public void insert(int value) {

        root = insertHelper(root, value);
    }

    public Node search(int value) {

        return searchHelper(root, value);
    }

    public int findMinimum() {

        return findMinimum(root);
    }

    public void delete(int value) {

        deleteHelper(root, value);
    }

    public void print() {

        printHelper(root);
    }

    private Node insertHelper(Node root, int value) {

        if(root == null) {
            root = new Node(value);
            return root;
        }

        if(value < root.getData()) {
            root.setLeft(insertHelper(root.getLeft(), value));
        }
        if(value > root.getData()) {
            root.setRight(insertHelper(root.getRight(), value));
        }

        return root;
    }

    private Node searchHelper(Node root, int value) {
        if((root == null) || (value == root.getData()))
            return root;

        if(value < root.getData())
            return searchHelper(root.getLeft(), value);

        else
            return searchHelper(root.getRight(), value);
    }

    private void printHelper(Node root) {

        if(root != null) {
            printHelper(root.getLeft());
            System.out.println(root.getData() + "  ");
            printHelper(root.getRight());
        }
    }

    private int findMinimum(Node root) {
        int value = root.getData();

        while(root.getLeft() != null) {
            value = root.getLeft().getData();
            root = root.getLeft();
        }

        return value;
    }

    private Node deleteHelper(Node root, int value) {

        if(root == null)
            return root;

        if(value < root.getData())
            root.setLeft(deleteHelper(root.getLeft(), value));

        else if(value > root.getData())
            root.setRight(deleteHelper(root.getRight(), value));

        else {
            if(root.getLeft() == null)
                return root.getRight();

            else if (root.getRight() == null)
                return root.getLeft();

            root.setData(findMinimum(root.getRight()));

            root.setRight(deleteHelper(root.getRight(), root.getData()));
        }

        return root;
    }

}
