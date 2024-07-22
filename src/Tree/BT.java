package Tree;

import java.util.Scanner;

public class BT {
    private Node root;

    public BT(){

    }

    public void populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        Node node = new Node(value);
        root=node;

        populate(scanner,root);
    }

    private void populate(Scanner scanner , Node node){
        System.out.println("want to insert the left of the "+node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to insert left of the "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }

        System.out.println("want to insert the right of the "+node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to insert right of the "+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }

    public void display(){
        display(root,"");
    }

    private void display(Node node,String space){
        if(node == null){
            return;
        }
        System.out.println(space+node.value);
        display(node.left,space+"\t");
        display(node.right,space+"\t");
    }

    private static class Node{
        private int value;
        private Node left;
        private Node right;

        Node(int value){
            this.value = value;
        }

        Node(int value,Node left,Node right){
            this.value=value;
            this.right = right;
            this.left = left;
        }
    }
}
