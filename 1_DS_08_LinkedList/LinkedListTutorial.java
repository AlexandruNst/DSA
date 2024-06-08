import java.util.LinkedList;

public class LinkedListTutorial {
    public static void main(String[] args) {
        // LinkedList = stored Nodes (data + address)
        // Nodes are in stored in non-consecutive memory locations
        // Elements are linked via pointers

        // Advantages:
        // 1. Dynamic DS (memory allocated at runtime)
        // 2. Insertion/Deletion is fast O(1)
        // 3. No/Low memory waste

        // Disadvantages
        // 1. More memory usage, due to additional pointer(s)
        // 2. No random access of elements (like array[i])
        // 3. Accessing elements is more time consuming O(n)

        LinkedList<String> ll = new LinkedList<>();

        // Can use the LinkedList as a Stack or a Queue
        ll.push("A");
        ll.push("B");
        ll.push("C");
        ll.pop();

        ll.offer("D");
        ll.offer("E");
        ll.offer("F");
        ll.poll();

        // Add at numbered index
        ll.add(4, "E");

        // Other useful methods
        ll.indexOf("C");

        ll.peekFirst();
        ll.peekLast();

        ll.addFirst("X");
        ll.addLast("Y");

        ll.removeFirst();
        ll.removeLast();
    }
}
