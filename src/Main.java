
public class Main {
    public static void main(String[] args) {
/*     //Singly linked list:

        SingleLL list = new SingleLL();
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

        DoublLL list1 = new DoublLL();
        list1.insertFirst(1);
        list1.insertFirst(2);
        list1.insertLast(100);
        list1.display();
        list1.delete(1);
        list1.display();
    }
}
