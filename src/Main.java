import Stack.ST;
import Tree.AVL;
import Tree.BST;
import Tree.BT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*     //Singly linked list:

        LinkedList.SingleLL list = new LinkedList.SingleLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertLast(6);
        list.display();
        list.deleteLast();
        list.display();
        list.delete(2);
        list.display();
 */

//        DoublLL list1 = new DoublLL();
//        list1.insertFirst(1);
//        list1.insertFirst(2);
//        list1.insertLast(100);
//        list1.display();
//        list1.delete(1);
//        list1.display();



//        BT tree = new BT();
//        tree.populate(new Scanner(System.in));
//        tree.display();

//        AVL tree2 = new AVL();
//        for(int i=0;i<10000000;i++){
//            tree2.insert(i);
//        }
//        tree2.display();
//        System.out.println(tree2.isBalanced());
//        System.out.println(tree2.height());


        ST stack = new ST();
        for(int i=0;i<20;i++){
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        for(int i=0;i<20;i++){
            stack.pop();
        }

        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

    }
}
