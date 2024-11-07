public class AVLTrees {
    public static void main(String[] args) {
        // Balanced BST - a self-balancing BST
        // i.e. a BST that adjusts itself to maintain a logarithmic height
        // in proportion to the number of Nodes they hold
        // This allows for very fast insertions and deletions

        // BST - Average O(log n), Worst O(n)
        // BBST - Average O(log n), Worst O(log n)

        // Central to how BBST's work is ***Tree Rotations***,
        // and a clever ***tree invariant***

        // A tree invariant - a property/rule that determines the balance-ness
        // It it imposed on the tree and MUST be met every operation

        // To ensure the invariant is satisfied, Tree Rotations are applied

        // There are many types of BBST
        // One such type is the AVL Tree

        // The property that keeps an AVL Tree balanced is
        // the ***Balance Factor (bf)***

        // BF(node) = H(node.right) - H(node.left)
        // where H is height i.e. # edges between node and furthest Leaf

        // The invariant which keeps an AVL Tree balanced is
        // the requirement that the bf remains -1, 0, or 1.

        // Node information to store: data (comparable), height, bf, left+right

        // A bf of +-2 is adjusted via Tree Rotations

        // Rotation are:
        // Left Rotation
        // Right Rotation
        // LeftRight Rotation
        // RightLeft Rotation

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < 22; i++) {
            avl.insert((int) (Math.random() * 100));
        }

        System.out.println(avl.height());
    }
}

class AVLTree<T extends Comparable<T>> {
    class Node {
        int bf;
        int height;
        T value;
        Node left, right;

        public Node(T value) {
            this.value = value;
        }
    }

    Node root;
    int nodeCount = 0;

    public int height() {
        if (root == null)
            return 0;
        return root.height;
    }

    public int size() {
        return nodeCount;
    }

    public boolean isEmpty() {
        return nodeCount == 0;
    }

    // Return true/false depending on whether a value exists in the tree
    public boolean contains(T value) {
        return contains(root, value);
    }

    // Recursive helper method for contains
    private boolean contains(Node node, T value) {
        // base case, or reached the end, not found
        if (node == null)
            return false;

        // compare value to that of the node
        int cmp = value.compareTo(node.value);

        // dig into left subtree
        if (cmp < 0)
            return contains(node.left, value);

        // dig into right subtree
        if (cmp > 0)
            return contains(node.right, value);

        // cmp == 0 i.e. found the value
        return true;
    }

    // Insert a value in the tree.
    public boolean insert(T value) {
        // value is null, ignore
        if (value == null)
            return false;

        // add new node only if it doesn't exist (enforce unique nodes)
        if (!contains(value)) {
            root = insert(root, value);
            nodeCount++;
            return true;
        }

        // if value is already present, ignore
        return false;
    }

    // Recursive helepr method for insert
    private Node insert(Node node, T value) {
        // base case or reached the end, insert
        if (node == null)
            return new Node(value);

        // compare value to that of the node
        int cmp = value.compareTo(node.value);

        // insert node in left subtree
        if (cmp < 0)
            node.left = insert(node.left, value);

        // insert node in right subtree
        if (cmp > 0)
            node.right = insert(node.right, value);

        // no need to handle cmp == 0 case since we checked the value doesn't exist

        // update balance factor and height values
        update(node);

        // re-balance the tree
        return balance(node);
    }

    // Return true/false depending on whether the value was removed from tree
    public boolean remove(T value) {
        // value is null, ignore
        if (value == null)
            return false;

        // only remove if the tree contains the value
        if (contains(value)) {
            root = remove(root, value);
            nodeCount--;
            return true;
        }

        // if tree doesn't contain value, ignore
        return false;
    }

    // Recursive helper for remove
    private Node remove(Node node, T value) {
        // base case, or null tree
        if (node == null)
            return null;

        // compare value to that of node
        int cmp = value.compareTo(node.value);

        // dig into left subtree
        if (cmp < 0)
            node.left = remove(node.left, value);
        // dig into right subtree
        if (cmp > 0)
            node.right = remove(node.right, value);
        // found the node we wish to remove
        else {
            // leaf node - simply return null
            if (node.right == null && node.left == null)
                return null;
            // left is null, swap node with right child
            if (node.left == null)
                return node.right;
            // right is null, swap with left child
            if (node.right == null)
                return node.left;
            // inner node with both a left and right subtree. The substitution
            // could either be the largest in the left subtree, or the smallest
            // in the right subtree. To decide, we could use a heuristic and
            // remove from the subtree with the most height, in hopes it will
            // help with balancing
            else {
                // choose to remove from left
                if (node.left.height > node.right.height) {
                    T successorValue = findMax(node.left);
                    node.value = successorValue;
                    // don't forget to then remove that from left subtree
                    node.left = remove(node.left, successorValue);
                    // choose to remove from tight
                } else {
                    T successorValue = findMin(node.right);
                    node.value = successorValue;

                    // don't forget to then remove that from left subtree
                    node.right = remove(node.right, successorValue);
                }
            }
        }

        // update balance factor and height values
        update(node);

        // re-balance tree
        return balance(node);
    }

    // Update the balance factor and height of a node
    private void update(Node node) {
        int leftHeight = (node.left == null) ? -1 : node.left.height;
        int rightHeight = (node.right == null) ? -1 : node.right.height;

        node.height = 1 + Math.max(leftHeight, rightHeight);

        node.bf = rightHeight - leftHeight;
    }

    // Re-balance a Node with bf of -2 or +2
    private Node balance(Node node) {
        // tree is left heavy
        if (node.bf == -2) {
            if (node.left.bf <= 0) {
                return rightRotation(node);
            } else {
                return leftRightRotation(node);
            }

            // tree is right heavy
        } else if (node.bf == 2) {
            if (node.right.bf >= 0) {
                return leftRotation(node);
            } else {
                return rightLeftRotation(node);
            }

            // bf is -1, 0, or 1. No need to re-balance anything
        } else {
            return node;
        }
    }

    private Node leftRightRotation(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private Node rightLeftRotation(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;

        // important to update the nodes as the bf and height will change
        // imporatant in this order. Update the new child fist, the new parent last
        update(node);
        update(newParent);
        return newParent;
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;

        // important to update the nodes as the bf and height will change
        // imporatant in this order. Update the new child fist, the new parent last
        update(node);
        update(newParent);

        return newParent;
    }

    private T findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node.value;
    }

    private T findMax(Node node) {
        while (node.right != null)
            node = node.right;
        return node.value;
    }
}
