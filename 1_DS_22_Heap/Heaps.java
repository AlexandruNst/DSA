import java.util.Arrays;

public class Heaps {
    public static void main(String[] args) {
        // A Priory Queue - a queue where each element has a certain priority
        // Elements with higher priority come out of the PQ first
        // Note: elements MUST BE comparable

        // A way to implement a PQ is via a Heap (by far the most popular)
        // Heaps can be Max Heaps or Min Heaps (serving the largest or smallest first)
        // A Heap is a tree-based DS that satisfies the heap invariant:
        // a parent is always smaller (or bigger) than its child

        // A common Heap type is a Binary Heap, i.e. max 2 children
        // but it's not the only type

        // A Heap is not interchangable with a PQ
        // A PQ is an abstract data structure, which is implemented via a Heap
        // The usual implementation of a PQ is a Heap which led to them being used
        // interchangably, but they're fundamentally different things

        // Good when you need to dynamically fetch the "next best/worst" element

        // Time complexity: Polling(remove top) O(log n), Adding O(log n), Peeking O(1)

        // A Binary Heap is a binary tree that enforces the Heap Invariant
        // A B Heap is a complete binary tree i.e. every level is completely filled,
        // except probably the last, where all Nodes are as far left as possible

        // Because of this, the way to represent the Heap is via an Array

        MinHeap heap = new MinHeap();
        heap.add(2);
        heap.add(6);
        heap.add(1);
        heap.add(4);
        heap.add(7);
        heap.add(3);
        heap.add(5);

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());

    }
}

class MinHeap {
    private int capacity;
    private int size;
    int[] items;

    public MinHeap() {
        this.capacity = 10;
        this.size = 0;
        items = new int[capacity];
    }

    // Return the element at the top of the heap
    public int peek() {
        // if no elements in the array, ignore
        if (size == 0)
            return -1;
        // first element in the array is the first element in the heap
        return items[0];
    }

    public int poll() {
        // if no elements in the array, ignore
        if (size == 0)
            return -1;
        // get the value of the element to be returned
        int item = items[0];
        // replace it with the last value of the array
        items[0] = items[this.size - 1];
        // reduce the size
        this.size--;
        // bubble down the new replaced element
        bubbleDown();

        return item;
    }

    public void add(int item) {
        // ensure there is capacity for the new item
        ensureExtraCapacity();
        // add new element at the end of the array
        items[this.size] = item;
        // increase size
        this.size++;
        // bubble up the new item
        bubbleUp();
    }

    // Bubble down the root
    private void bubbleDown() {
        // index of first item
        int index = 0;
        // as long as it has children, walk down to fix the heap
        // using the fact a Heap is a complete BT, need to only check left.
        // If no left, there is definitely no right
        while (hasLeftChild(index)) {
            // if there is a right child, consider it only if the value is smaller.
            // else default to the left child
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            // if it's smaller than the smallest child, heap is in order, break.
            if (items[index] < items[smallerChildIndex])
                break;
            else {
                // not in order, swap
                swap(index, smallerChildIndex);
                // walk the index downwards, replacing with the old smaller child index
                index = smallerChildIndex;
            }
        }
    }

    // Bubble up the last item
    private void bubbleUp() {
        // index of last item
        int index = size - 1;
        // walk up as long as there's a parent && out of order
        while (hasParent(index) && parent(index) > items[index]) {
            int parentIndex = getParentIndex(index);
            // swap with the parent
            swap(parentIndex, index);
            // walk the index upwards, replacing with the old parent index
            index = parentIndex;
        }
    }

    // --- Helper methods ---

    // Swap two items
    private void swap(int indexOne, int indexTwo) {
        int tmp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = tmp;
    }

    // Increase the size of items[] if full
    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    // Methods to get the indices we need
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (int) Math.floor((childIndex - 1) / 2);
    }

    // Methods to check for children and parent
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    // Methods to retrieve the children and parent values
    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

}
