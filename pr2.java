import java.util.ArrayList;
import java.util.List;

class Stack<T> {
    private List<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public void clear() {
        elements.clear();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void display() {
        System.out.println("Stack elements: " + elements);
    }
}
public class GenericStackDemo {
    public static void main(String[] args) {
        // Stack of Strings
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");
        System.out.println("String Stack:");
        stringStack.display();

        stringStack.pop();
        System.out.println("After popping one element:");
        stringStack.display();

        stringStack.clear();
        System.out.println("After clearing the stack:");
        stringStack.display();

        // Stack of Integers
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        System.out.println("Integer Stack:");
        integerStack.display();

        integerStack.pop();
        System.out.println("After popping one element:");
        integerStack.display();

        integerStack.clear();
        System.out.println("After clearing the stack:");
        integerStack.display();
    }
}
