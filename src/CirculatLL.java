class CircularLL{

    private Node head;
    private int size;

    public CircularLL() {
        this.head = null;
        this.size = 0;
    }

    // Insert a node at the beginning
    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            newNode.previous = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            newNode.previous = head.previous;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    // Insert a node at the end (similar to insertFirst)
    public void insertLast(int value) {
        insertFirst(value);
    }

    // Print the list in forward direction
    public void printForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.value + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("NULL");
    }

    // Print the list in backward direction (optional)
    public void printBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head.previous;
        do {
            System.out.print(temp.value + " <-> ");
            temp = temp.previous;
        } while (temp != head.previous);
        System.out.println("NULL");
    }

    // Delete the node with a specific value
    public void delete(int value) {
        if (head == null) {
            return; // Handle empty list
        }
        Node temp = head;
        do {
            if (temp.value == value) {
                // Handle deletion logic here
                if (temp == temp.next) { // Only element in the list
                    head = null;
                } else {
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                    if (temp == head) {
                        head = temp.next;
                    }
                }
                size--;
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Value not found in the list");
    }

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }
    }
}
