import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueues {
    public static void main(String[] args) {
        // Priority Queue = FIFO data structure where elements of higher prority are
        // served first

        // Standard queue
        Queue<Double> queue = new LinkedList<>();
        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        while (!queue.isEmpty())
            System.out.println(queue.poll());

        System.out.println("////////");

        // Priority Queue
        Queue<Double> pq = new PriorityQueue<>();
        pq.offer(3.0);
        pq.offer(2.5);
        pq.offer(4.0);
        pq.offer(1.5);
        pq.offer(2.0);

        while (!pq.isEmpty())
            System.out.println(pq.poll());

        System.out.println("////////");

        // Priority Queue - reversed order
        Queue<Double> pqReverse = new PriorityQueue<>(Collections.reverseOrder());
        pqReverse.offer(3.0);
        pqReverse.offer(2.5);
        pqReverse.offer(4.0);
        pqReverse.offer(1.5);
        pqReverse.offer(2.0);

        while (!pqReverse.isEmpty())
            System.out.println(pqReverse.poll());
    }
}