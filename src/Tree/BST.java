package Tree;

public class BST {

    private Node root;

    public int height(){
        return height(this.root);
    }

    private int height(Node node){
        if(node==null){
            return -1;
        }
        int left = height(node.left);
        int right = height(node.right);
        node.height=Math.max(left,right)+1;
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        insert(value,root);
    }

    private Node insert(int value,Node node){
        if(node==null){
            return new Node(value);
        }
        if(node.value>value){
            node.left = insert(value,node.left);
        }
        if(node.value<value){
            node.right = insert(value,node.right);
        }
        return node;
    }

    public void display(){
        display(this.root,"");
    }

    private void display(Node node, String space){
        if(node == null){
            return;
        }
        System.out.println(space+node.value);
        display(node.left,space+"\t");
        display(node.right,space+"\t");
    }


    public boolean isBalanced(){
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean search(int value){
        return search(this.root,value);
    }

    private boolean search(Node node ,int value){
        if(node == null) return false;
        if(node.value == value){
            return true;
        }
        if(value > node.value){
            return search(node.right,value);
        }
        if(value<node.value){
            return search(node.left,value);
        }
        return false;
    }

    // In-order Traversal: Left -> Root -> Right
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

    // Pre-order Traversal: Root -> Left -> Right
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

    // Post-order Traversal: Left -> Right -> Root
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


    private static class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node(int value){
            this.value = value;
        }

        public int getheight(){
            return this.height;
        }
    }
}
