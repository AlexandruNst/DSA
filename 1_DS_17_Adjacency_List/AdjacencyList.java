import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    public static void main(String[] args) {

        // Adjacency List = an array(list) of LinkedLists (or just another list)
        // Each LL has a unique Node at the head for each Graph Vertex
        // All adjacent neighbours are added to that LL
        // NOTE: C -> D -> E doesn't mean D is adj to E. It means C is adj to D & E.

        // Time Complexity: O(V) - traverse a LL linearly to find a matching Node
        // Space Complexity: O(V + E)

        // A -> B ->
        // B -> C ->
        // C -> D -> E ->
        // D ->
        // E -> A -> C ->

        Graph graph = new Graph();
        graph.addNode(new Node('A')); // 0
        graph.addNode(new Node('B')); // 1
        graph.addNode(new Node('C')); // 2
        graph.addNode(new Node('D')); // 3
        graph.addNode(new Node('E')); // 4

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
    ArrayList<LinkedList<Node>> arrayList;

    Graph() {
        arrayList = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> newList = new LinkedList<>(); // create new list
        newList.add(node); // add the new Node at the head
        arrayList.add(newList); // add to main ArrayList
    }

    public void addEdge(int src, int dst) {
        LinkedList<Node> currentList = arrayList.get(src); // get the List with src at the head
        Node dstNode = arrayList.get(dst).get(0); // get the dst Node.
        // NOTE: we don't create a new node each time. We reuse the same ones, the heads
        currentList.add(dstNode); // add to the tail of the src's List
    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node> currentList = arrayList.get(src); // get the List with src at the head
        Node dstNode = arrayList.get(dst).get(0); // get the dst Node.
        for (Node node : currentList) {
            if (node == dstNode) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.println();
        for (LinkedList<Node> currentList : arrayList) {
            for (Node node : currentList) {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
}
