
public class Graphs {
    public static void main(String[] args) {
        // Won't have code here because Graphs are a theoretical concept
        // Graph implementations are to follow in the next topics

        // Graphs are a non-linear aggregation of Nodes and Edges
        // A node is also known as a Vertex

        // A Node may contain some data
        // An edge is a connection between 2 Nodes
        // If 2 Nodes are connected, they have ***Adjacency***

        // There are mainly 2 types of Graphs - ***Undirected & Directed***

        // Undirected Graphs are like a social network e.g. Facebook
        // Nodes are users, and the Edges represent the friendships between them
        // N --- N

        // Directed Graphs contain ***ONE-WAY*** Edges between Nodes
        // e.g. A --> B
        // A has adjacenecy to B, but not the other way around
        // However, it is valid to have 2 Edges from one Node to another, both ways
        // A <==> B
        // Also, A --> B --> C = A has adjacency to C
        // An example of a Directed Graph is a Map
        // Nodes are locations, Edges are streets
        // Streets can be one-way or two-way

        // There are 2 popular ways to represent a graph
        // ***Adjacency Matrix & Adjacency List***

        // Adjacency Matrix -> Create one column and one row for each Node.
        // Mark 0 for no Edge, and 1 for Edge between row Node and column Node
        // Pro: Time Complexity to locate an Edge is O(1) (based on indices)
        // Con: Space Complexity of the matrix is O(V^2)
        // (for 5 Nodes, you have 5*5=25 spaces)
        // When to use? -> if there are a lot of Edges relative to Nodes

        // Adjacency List -> An array of linked lists
        // Each LL header in the array is the address of a Node in the Graph
        // If there is adjacency between 1 Node and another,
        // add the adjacent Node to the LL
        // To find adjacency between 2 Nodes, find the Node where we're starting and
        // follow the LL
        // Even if there's a Node that is not adjacent to any neighbour,
        // still add to the Adjacency List
        // Pro: Space Complexity of the List is O(V+E)
        // (in the list we hold all Nodes ones, then one more space for each Edge)
        // Con: Time Complexity to locate an Edge is O(V) - linear, follow the LL
        // When to use? -> if there are not many Edges relative to Nodes

    }
}
