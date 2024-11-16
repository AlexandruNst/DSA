import java.util.ArrayDeque;
import java.util.Deque;

public class Deques {
    public static void main(String[] args) {
        // One data structure to rule them all.
        // A Deque (pronounced "Deck") is a double-ended queue that can add or
        // remove elements from both ends in amortized constant time O(1).
        // Essentially amortised time means "average time taken per
        // operation, if you do many operations"

        // This allows us to replace Stack, Queue, and LinkedList with just four
        // interfaces:

        // addFirst()
        // addLast()
        // removeFirst()
        // removeLast()

        // Stack
        Deque<Integer> s = new ArrayDeque<>();
        s.addLast(1); // 1
        s.addLast(2); // 1, 2
        s.addLast(3); // 1, 2, 3
        s.removeLast(); // 1, 2
        s.removeLast(); // 1

        // Queue
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(1); // 1
        q.addLast(2); // 1, 2
        q.addLast(3); // 1, 2, 3
        q.removeFirst(); // 2, 3
        q.removeFirst(); // 3

        // LinkedList
        Deque<Integer> ll = new ArrayDeque<>();
        ll.addLast(1); // 1
        ll.addLast(2); // 1, 2
        ll.addFirst(0); // 0, 1 ,2
        ll.removeLast(); // 0, 1
        ll.removeFirst(); // 1

        // AI blurp on LinkedList vs ArrayDeque
        // LinkedList:

        // Imagine a train where each carriage is connected to the next one.
        // Each carriage (or "node") holds two things: some data and a connection to the
        // next carriage.
        // Adding or removing carriages at the beginning or end is quick because you
        // just change the connections.
        // But if you want to find a specific carriage, you have to walk through the
        // train from the start until you find it—this can be slow.

        // ArrayDeque:

        // Now, imagine a row of lockers numbered from 1 to 10.
        // You can put stuff in the lockers in order, and you know exactly where
        // everything is because lockers are numbered.
        // Adding or removing stuff at the ends (first or last locker) is quick and
        // easy.
        // If the lockers run out of space, a bigger set of lockers is found, and
        // everything is moved over. This resizing takes time, but it doesn’t happen
        // often.

        // Key Differences:

        // Structure:
        // LinkedList is like a train: it grows or shrinks by adding/removing
        // connections.
        // ArrayDeque is like lockers: it’s a contiguous block of memory that resizes
        // when needed.

        // Speed:
        // LinkedList is better for frequent adding/removing at random positions.
        // ArrayDeque is better for fast access and adding/removing at the ends.

        // Memory Use:
        // LinkedList uses more memory because each node needs extra space to store the
        // connections.
        // ArrayDeque is more memory-efficient but can require resizing.

        // So, if you need fast access or mainly work with the ends of a collection, go
        // with ArrayDeque. If you need to add/remove items often in the middle,
        // LinkedList might be a better choice!

        // Also
        // Also, LinkedList implements List while ArrayDeque doesn't. This means that
        // LinkedList have methods like indexOf or remove(int) while ArrayDeque hasn't.
        // It can be important sometimes.

        // Also
        // Another difference to bear in mind: LinkedList supports null elements,
        // whereas ArrayDeque does not.

        // Key differences:

        // The ArrayDeque class is the resizable array implementation of the Deque
        // interface and LinkedList class is the list implementation
        // NULL elements can be added to LinkedList but not in ArrayDeque
        // ArrayDeque is more efficient than the LinkedList for add and remove operation
        // at both ends and LinkedList implementation is efficient for removing the
        // current element during the iteration
        // The LinkedList implementation consumes more memory than the ArrayDeque
    }
}
