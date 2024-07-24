package Tree;

public class AVL {

    private Node root;

    public int height(){
        return height(this.root);
    }

    private int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            return new Node(value);
        }
        if(node.value > value){
            node.left = insert(value, node.left);
        } else if(node.value < value){
            node.right = insert(value, node.right);
        }
        updateHeight(node);
        return rotate(node);
    }

    private Node rotate(Node node) {
        int balance = height(node.left) - height(node.right);

        if (balance > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                // Left-Left case
                return rightRotate(node);
            } else {
                // Left-Right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (balance < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                // Right-Right case
                return leftRotate(node);
            } else {
                // Right-Left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t3 = c.right;

        c.right = p;
        p.left = t3;

        updateHeight(p);
        updateHeight(c);

        return c;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t3 = p.left;

        p.left = c;
        c.right = t3;

        updateHeight(c);
        updateHeight(p);

        return p;
    }

    private void updateHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public void display(){
        display(this.root, "");
    }

    private void display(Node node, String space){
        if(node == null){
            return;
        }
        System.out.println(space + node.value);
        display(node.left, space + "\t");
        display(node.right, space + "\t");
    }

    public boolean isBalanced(){
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean search(int value){
        return search(this.root, value);
    }

    private boolean search(Node node, int value){
        if(node == null) return false;
        if(node.value == value){
            return true;
        }
        if(value > node.value){
            return search(node.right, value);
        } else {
            return search(node.left, value);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    private static class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            this.height = 0; // Initialize height
        }
    }
}
