public class UnionFind {
    public static void main(String[] args) {
        // Union Find - DS that track elements split into 1 or more disjoint sets
        // Has 2 primary operations: Union and Find
        // Find = given an elements, will return what group it belongs to
        // Union = merges 2 groups together

        // TC:
        // ***WITH PATH COMPRESSION***:
        // Construction: O(n)
        // Union, Find, Check if connected, Get group size: A(n) *
        // Count groups: O(1)

        // * A(n) meaning
        // Amortised Constant Time. Almost but not quite. Eventually constant.

        UnionFindDS uf = new UnionFindDS(5);
        uf.union(0, 1);
        uf.union(1, 2);

        System.out.println(uf.connected(0, 2));
        System.out.println(uf.groupSize(0));
        System.out.println(uf.groupSize(2));

        System.out.println(uf.size());

        System.out.println(uf.numGroups());
    }

    private static class UnionFindDS {

        // Number of elements in the UF
        private int size;

        // Size of each group
        private int[] sz;

        // id[i] points to the parent of i. If id[i] = i, then i is a root node
        private int[] id;

        // Tracks the number of groups
        private int numGroups;

        public UnionFindDS(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Size <= 0 is not allowed.");
            }

            // the size specifies the number of elements (n)
            this.size = size;
            // initially, there are n groups, each element in its own group
            this.numGroups = size;

            this.id = new int[size];
            this.sz = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i; // initially, every element is a root node
                sz[i] = 1; // initially, every group is of size 1
            }
        }

        // Find which group 'p' belongs to, with path compression
        public int find(int p) {

            // find the root of p's group
            int root = p;
            while (id[root] != root) {
                root = id[root];
            }

            // compress the path to the root. every node from p to root now point to root
            // 'path compression'
            // gives us amortised constant time complexity
            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }

            return root;
        }

        // Unify the groups containing 'p' and 'q'
        public void union(int p, int q) {

            // find the roots
            int root1 = find(p);
            int root2 = find(q);

            // if roots are the same, the elements are in the same group already
            if (root1 == root2)
                return;

            // merge two groups together
            // merge the smaller group into the larger
            if (sz[root1] < sz[root2]) {
                sz[root2] += sz[root1];
                id[root1] = root2;
            } else {
                sz[root1] += sz[root2];
                id[root2] = root1;
            }

            // here we also know that one group got merged
            numGroups--;
        }

        // Return whether p and q are in the same group i.e. have the same root
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        // Return the size of the group p belongs to i.e. sz[root of p]
        public int groupSize(int p) {
            return sz[find(p)];
        }

        // Return number of elements
        public int size() {
            return size;
        }

        // Return number of groups
        public int numGroups() {
            return numGroups;
        }
    }
}