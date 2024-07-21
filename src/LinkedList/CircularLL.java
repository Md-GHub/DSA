package LinkedList;

public class CircularLL {
    private Node head;
    private Node tail;
    private int size;

    CircularLL() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void insertFirst(int value) {
        Node temp = new Node(value);
        if (this.head == null) {
            this.head = temp;
            this.tail = temp;
            temp.next = this.head;  // Point to itself, forming a single node circular linked list
        } else {
            temp.next = this.head;
            this.head = temp;
            this.tail.next = this.head;  // Update tail's next to new head
        }
        this.size += 1;
    }

    public void insertLast(int value) {
        Node temp = new Node(value);
        if (this.head == null) {
            insertFirst(value);
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
        this.tail.next = this.head;  // Complete the circle
        this.size += 1;
    }

    public void display() {
        if (this.head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = this.head;
        do {
            System.out.print(temp.value + "->");
            temp = temp.next;
        } while (temp != this.head);
        System.out.println("(head)");
    }

    public void deleteFirst() {
        if (this.head != null) {
            if (this.head == this.tail) {  // Only one node in the list
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.tail.next = this.head;  // Update tail's next to new head
            }
            this.size -= 1;
        }
    }

    public void deleteLast() {
        if (this.tail != null) {
            if (this.head == this.tail) {  // Only one node in the list
                this.head = null;
                this.tail = null;
            } else {
                Node temp = this.head;
                while (temp.next != this.tail) {
                    temp = temp.next;
                }
                temp.next = this.head;
                this.tail = temp;
            }
            this.size -= 1;
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if (temp.next == this.head) {
            this.tail = temp;
        }
        this.size -= 1;
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

