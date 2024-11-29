import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        // Breadth First Search - traverse a graph level by level,
        // rather than a branch a time (DFS)

        // BFS vs DFS
        // Level by level | Branch by branch
        // Queue | Stack
        // Better if dest is close to start | Better if dest is far from start
        // Siblings before children | Children before sublings

        // ..A B C D E
        // A 0 1 0 0 0
        // B 0 0 1 0 1
        // C 0 0 0 1 1
        // D 0 0 0 0 0
        // E 1 0 1 0 0

        Graph graph = new Graph(5);
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.print();

        graph.breadthFirstSearch(0);
    }

    private static class Node {
        char data;

        Node(char data) {
            this.data = data;
        }
    }

    private static class Graph {

        ArrayList<Node> nodes;
        int[][] matrix;

        Graph(int size) {
            matrix = new int[size][size];
            nodes = new ArrayList<>();
        }

        public void addNode(Node node) {
            nodes.add(node);
        }

        public void addEdge(int src, int dst) {
            matrix[src][dst] = 1;
        }

        // public boolean checkEdge(int src, int dst) {
        // return matrix[src][dst] == 1;
        // }

        public void print() {
            System.out.println();
            System.out.print("  ");

            for (Node node : nodes) {
                System.out.print(node.data + " ");
            }
            System.out.println();
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(nodes.get(i).data + " ");
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // NEW FOR BFS

        public void breadthFirstSearch(int src) {
            // Unlike DFS, BFS uses a Queue
            Queue<Integer> queue = new LinkedList<>();
            // we still need the visited, to avoid loops
            boolean[] visited = new boolean[matrix.length];

            // add start node in the queue and mark as visited
            queue.offer(src);
            visited[src] = true;

            // while there are still available unvisited neighbours
            while (queue.size() != 0) {
                // visit the first node in line
                src = queue.poll();
                System.out.println(nodes.get(src).data + " = visited");

                // look at its neighbours i.e. its row in the adj matrix
                for (int i = 0; i < matrix[src].length; i++) {
                    // if we have an adjacent node that's not visited
                    if (matrix[src][i] == 1 && !visited[i]) {
                        // wait in line
                        queue.offer(i);
                        // mark neighbour as visited.
                        visited[i] = true;
                    }
                }
            }
        }
    }
}
