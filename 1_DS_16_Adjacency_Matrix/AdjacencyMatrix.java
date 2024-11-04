import java.util.ArrayList;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        // Adjacency Matrix = 2D array to store 1's and 0's to represent Edges

        // Time Complexity to check an Edge: O(1)
        // Space Complexity: O(V^2)

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

        System.out.println(graph.checkEdge(0, 1));
    }
}

class Node {
    char data;

    Node(char data) {
        this.data = data;
    }
}

class Graph {

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

    public boolean checkEdge(int src, int dst) {
        return matrix[src][dst] == 1;
    }

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

}