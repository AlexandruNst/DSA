public class DoublyLinkedLists {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(1);
        dll.append(2);
        dll.append(3);

        dll.print();

        dll.prepend(5);
        dll.prepend(6);

        dll.print();

        dll.deleteWithValue(2);
        dll.print();

        dll.deleteWithValue(6);
        dll.print();

        dll.deleteWithValue(3);
        dll.print();
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void append(int data) {
        Node node = new Node(data);

        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void prepend(int data) {
        Node node = new Node(data);

        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void deleteWithValue(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            head.prev = null;
            return;
        }
        if (tail.data == data) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                current.next.prev = current;
                return;
            }
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}