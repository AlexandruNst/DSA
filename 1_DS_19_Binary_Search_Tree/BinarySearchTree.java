public class BinarySearchTree {
    public static void main(String[] args) {
        // Binary Tree - a Tree in which a Parent has no more than 2 Children
        // Binary Search Tree - a BT in which each Parent is greater than
        // left Child, but less than right Child

        // Benefit - easy to locate a Node when they are in order

        // Time Complexity: best case O(log n) balanced, worst case O(n) a linked list
        // Space Complexity: O(n)

        BST tree = new BST();
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));

        tree.display();
        System.out.println(tree.search(0));
        System.out.println(tree.search(8));

        tree.remove(9);
        tree.remove(4);
        tree.remove(0);
        tree.display();
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class BST {
    Node root;

    // Insert prioritises keeping the current Nodes where they are
    // It will only insert a new Node as a Leaf
    // Hence, the order of insertion matters!
    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (root.data > data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " could not be found.");
        }
    }

    // Removing creates a gap in the tree, so we must find the right Node to
    // replace it with. Removing a Leaf is easy, just make it null. Removing a
    // inner Node means we must find either the lowest on the right, or
    // greatest on the left, whichever is not null, and replace the removed
    // Node with it. Continue by removing the Node that we used to replace.
    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        } else if (root.data > data) {
            root.left = removeHelper(root.left, data);
        } else if (root.data < data) {
            root.right = removeHelper(root.right, data);
        } else { // node found
            if (root.left == null && root.right == null) { // Leaf
                root = null;
            } else if (root.right != null) { // find a successor to replace this
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else { // find a predecesor to replace this
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) { // find the least value below the right child
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) { // find the greatest value below the left child
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
