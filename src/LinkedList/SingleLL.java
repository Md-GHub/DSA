package LinkedList;

public class SingleLL {
    private Node head;
    private Node tail;
    private int size;

    SingleLL() {
        this.size = 0;
    }

    public int size(){
        return this.size;
    }
    public void insertFirst(int value) {
        Node temp = new Node(value);
        temp.next = this.head;
        this.head = temp;

        if (this.tail == null) {
            this.tail = this.head;
        }
        this.size += 1;
    }

    public void insertLast(int value) {
        Node temp = new Node(value);
        if (this.tail == null) {
            insertFirst(value);
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
        this.size += 1;
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void deleteFirst(){
        if(this.head!=null){
            this.head = this.head.next;
            this.size-=1;
        }
    }

    public void deleteLast(){
        Node temp = head;
        if(tail==null) return;
        while(temp.next != tail){
            temp=temp.next;
        }

        temp.next=null;
        tail=temp;
        this.size-=1;
    }

    public void delete(int index){
        Node temp = this.head;
        while(index!=1){
            index--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        this.size-=1;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }
}
