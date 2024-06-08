public class SinglyLinkedLists {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.prepend(5);
        sll.deleteWithValue(2);
    }
}

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

class SinglyLinkedList {
    Node head;

    public void append(int data) {
        if (head != null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}