import java.util.HashMap;
import java.util.Map;

public class Tries {
    public static void main(String[] args) {
        // Trie - a tree-like DS where the Nodes store the entire alphabet
        // and words can be retrieved by traversing down the branch of the tree

        // The shape is that of a set of linked nodes, all connecting back
        // to an empty root node. Each node contains an array of pointers,
        // one for each possible alphabetic value

        // The array of pointers can either be under the structure of a map
        // 'a' -> ...
        // 'b' -> ...
        // etc.
        // or a simple array, defined by the link's index in the array
        // e.g. 'a' would be index 0, 'b' would be index 1 etc.

        // There also is a property in each node that determines if the node
        // is the end of a word or not. This is for searching words.

        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("ant");
        trie.insert("dad");
        trie.insert("ball");
        trie.insert("balance");
        trie.insert("code");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("appl"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("dad"));
        System.out.println(trie.search("codex"));

        System.out.println(trie.startsWith("apple"));
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("bal"));
        System.out.println(trie.startsWith("c"));
        System.out.println(trie.startsWith("cod"));
        System.out.println(trie.startsWith("code"));
        System.out.println(trie.startsWith("ants"));

    }
}

class Node {
    Map<Character, Node> children;
    boolean isEndOfWord;

    public Node() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    // Insert a word into the trie
    public void insert(String word) {
        // initialise a pointer at the root
        Node curr = root;
        // iterate through the characters of the word
        for (char c : word.toCharArray()) {
            // if current char does not exist as a child, create new Node
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            // move pointer down, either if the child already existed, or the new one
            curr = curr.children.get(c);
        }
        // mark the end of the word
        curr.isEndOfWord = true;
    }

    // Search for a key in the trie
    public boolean search(String word) {
        // initialise a pointer at the root
        Node curr = root;
        // iterate through the characters of the word
        for (char c : word.toCharArray()) {
            // if current char does not exist as a child, word is not present
            if (!curr.children.containsKey(c))
                return false;
            // if current char exists, move the pointer down
            curr = curr.children.get(c);
        }
        // once the end of the word is reached, check if node is a word end
        return curr.isEndOfWord;
    }

    // Search for a prefix in the trie
    public boolean startsWith(String prefix) {
        // initialise a pointer at the root
        Node curr = root;
        // iterate through the characters of the prefix
        for (char c : prefix.toCharArray()) {
            // if current char does not exist as a child, prefix is not present
            if (!curr.children.containsKey(c))
                return false;
            // if current char exists, move the pointer down
            curr = curr.children.get(c);
        }
        // once the end of the prefix is reached, we can return true
        return true;
    }
}