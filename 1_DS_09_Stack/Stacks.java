import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        // Stack = LIFO data structure
        // push() to add
        // pop() to remove
        // peek() to access top element
        // search() position from top

        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack);

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.peek());
    }
}