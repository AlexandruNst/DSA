import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        // Queue = FIFO
        // offer() / add() / enqueue() to add
        // poll() / remove() / dequeue() to remove
        // peek() to see first element in queue

        Queue<String> q = new LinkedList<>();

        q.add("A");
        q.add("B");
        q.add("C");

        System.out.println(q);

        q.remove();

        System.out.println(q);
        System.out.println(q.peek());

        // Other useful methods
        q.isEmpty();
        q.size();
        q.contains("A");
    }
}
