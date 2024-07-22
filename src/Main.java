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

        BST tree2 = new BST();
        tree2.insert(10);
        tree2.insert(15);
        tree2.insert(7);
        tree2.insert(8);
        tree2.insert(6);
        tree2.insert(20);
        tree2.insert(14);
        tree2.insert(100);
        tree2.insert(200);
        tree2.insert(300);
        tree2.insert(400);

        tree2.display();
        System.out.println(tree2.search(4000));
    }
}
