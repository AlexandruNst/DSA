public class DynamicArrays {
    public static void main(String[] args) {
        // Dynamic array = array with a resizable capacity
        // A static array has a set capacity determined at compile time
        DynamicArray da = new DynamicArray();
        System.out.println(da.capacity);

        System.out.println(da.isEmpty());

        da.add("A");
        da.add("B");
        da.add("C");
        System.out.println(da);
        System.out.println("empty: " + da.isEmpty());
        System.out.println("size: " + da.size);
        System.out.println("capacity: " + da.capacity);

        da.insert(0, "X");
        System.out.println(da);
        System.out.println("empty: " + da.isEmpty());
        System.out.println("size: " + da.size);
        System.out.println("capacity: " + da.capacity);

        da.delete("A");
        System.out.println(da);
        System.out.println("empty: " + da.isEmpty());
        System.out.println("size: " + da.size);
        System.out.println("capacity: " + da.capacity);

        System.out.println("C is at position " + da.search("C"));

        System.out.println("Growing and Shrinking");
        DynamicArray da2 = new DynamicArray(3);
        da2.add("D");
        da2.add("E");
        da2.add("F");
        System.out.println(da2);
        da2.add("G");
        System.out.println(da2);
        da2.delete("E");
        da2.delete("F");
        System.out.println(da2);

    }
}

class DynamicArray {
    int size;
    int capacity = 10;
    Object[] array;

    public DynamicArray() {
        this.array = new Object[capacity];
    };

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object data) {
        if (this.size >= this.capacity)
            this.grow();
        this.array[this.size] = data;
        this.size++;
    }

    public void insert(int index, Object data) {
        if (this.size >= this.capacity)
            this.grow();
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = data;
        this.size++;
    }

    public void delete(Object data) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == data) {
                for (int j = 0; j < this.size - i - 1; j++) {
                    this.array[i + j] = this.array[i + j + 1];
                }
                this.array[this.size - 1] = null;
                size--;
                if (size <= (int) (capacity / 3))
                    shrink();
                break;
            }
        }
    }

    public int search(Object data) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == data)
                return i;
        }
        return -1;
    }

    private void grow() {
        int newCapacity = this.capacity * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        this.capacity = newCapacity;
        this.array = newArray;
    }

    private void shrink() {
        int newCapacity = (int) (this.capacity / 2);
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        this.capacity = newCapacity;
        this.array = newArray;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        String string = "";

        for (int i = 0; i < this.capacity; i++) {
            string += this.array[i] + ", ";
        }
        if (string != "") {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        } else
            string = "[]";

        return string;
    }
}
