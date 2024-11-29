import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        // Depth First Search - Pick a route, keep going.
        // If you reach a dead end or an already visited node, backtrack
        // Backtrack to a previous node with unvisited neighbours

        // ..A B C D E
        // A 0 1 0 0 0
        // B 0 0 1 0 0
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
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.print();

        graph.depthFirstSearch(1);
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

        // NEW FOR DFS

        public void depthFirstSearch(int src) {
            // to keep track of the visited nodes
            // alternatively, use a 'visited' boolean on the Node,
            // but remember to set it back to false after done
            boolean[] visited = new boolean[matrix.length];
            DFSHelper(src, visited);
        }

        private void DFSHelper(int src, boolean[] visited) {
            // Iteratively with a stack, or Recursively with the call stack
            // Here - recursion

            // If the node is visited, return
            if (visited[src]) {
                return;
            }
            // mark as visited
            visited[src] = true;
            System.out.println(nodes.get(src).data + " = visited");

            // iterate through neighbours.
            // with the adj matrix approach, that means iterating through the row
            for (int i = 0; i < matrix[src].length; i++) {
                // if there is an edge between the nodes
                if (matrix[src][i] == 1) {
                    DFSHelper(i, visited);
                }
            }
            // Once all neighbours are visited, return
            return;
        }

    }

}
