package LinkedList;

public class DoublLL {

    private Node head;
    private int size;

    // Insert at the beginning
    public void insertFirst(int value) {
        Node temp = new Node(value);
        temp.next = head;
        if (head != null) {
            head.previous = temp;
        }
        head = temp;
        size++;
    }

    // Insert at the end
    public void insertLast(int value) {
        Node temp = new Node(value);
        if (head == null) {
            head = temp;
            return; // Handle empty list case
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = temp;
        temp.previous = last;
        size++;
    }

    // Print the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "<->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) {
            return; // Handle empty list case
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    // Delete the first node
    public void deleteFirst() {
        if (head == null) {
            return; // Handle empty list case
        }
        head = head.next;
        if (head != null) {
            head.previous = null;
        }
        size--;
    }

    // Delete a node at a specific index
    public void delete(int index) {
        if (index <= 0 || index > size) {
            System.out.println("Invalid index");
            return; // Handle invalid index
        }
        if (index == 1) {
            deleteFirst();
            return;
        }
        if (index == size) {
            deleteLast();
            return;
        }
        Node node = head;
        int counter = 1;
        while (counter < index) {
            node = node.next;
            counter++;
        }
        node.next = node.next.next;
        node.next.previous = node;
        size--;
    }

    public int size() {
        return size;
    }

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
