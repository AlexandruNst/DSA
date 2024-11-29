public class TreeTraversal {
    public static void main(String[] args) {
        // Tree Traversal - the process of visiting all nodes of a tree

        Node tree = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(6, new Node(5), new Node(7)));
        // .....4
        // .../...\
        // ..2.....5
        // ./.\.../.\
        // 1...3.6...7

        inOrder(tree);

        System.out.println();

        preOrder(tree);

        System.out.println();

        postOrder(tree);
    }

    // left -> root -> right
    // used for BST to visit nodes in vlue order
    private static void inOrder(TreeTraversal.Node tree) {
        if (tree == null)
            return;

        inOrder(tree.left);
        System.out.print(tree.data);
        inOrder(tree.right);
    }

    // root -> left -> right
    // used to create a copy of a tree
    private static void preOrder(TreeTraversal.Node tree) {
        if (tree == null)
            return;

        System.out.print(tree.data);
        preOrder(tree.left);
        preOrder(tree.right);
    }

    // left -> right -> root
    // used to access the tree from leaf to root. Used to delete tree.
    private static void postOrder(TreeTraversal.Node tree) {
        if (tree == null)
            return;

        preOrder(tree.left);
        preOrder(tree.right);
        System.out.print(tree.data);
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
