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

class SLLNode {
    SLLNode next;
    int data;

    public SLLNode(int data) {
        this.data = data;
    }
}

class SinglyLinkedList {
    SLLNode head;

    public void append(int data) {
        if (head == null) {
            head = new SLLNode(data);
            return;
        }
        SLLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new SLLNode(data);
    }

    public void prepend(int data) {
        SLLNode newHead = new SLLNode(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
        }

        SLLNode current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}