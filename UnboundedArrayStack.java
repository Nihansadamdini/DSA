/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class UnboundedArrayStack {

    private int[] arr;
    private int top;
    
    // Constructor
    public UnboundedArrayStack() {
        arr = new int[5];
        top = -1;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Expand the array when full
    private void expandArray() {
        int newSize = arr.length * 2;
        int[] newArr = new int[newSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.println("Array expanded to size: " + newSize);
    }
    
    // Shrink the array when less than 25% full
    private void shrinkArray() {
        if (arr.length <= 5) {
            return; // Don't shrink below initial size
        }
        int newSize = arr.length / 2;
        int[] newArr = new int[newSize];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.println("Array shrunk to size: " + newSize);
    }
    
    // Push element to the stack
    public void push(int x) {
        if (top == arr.length - 1) {
            expandArray();
        }
        arr[++top] = x;
    }
    
    // Pop element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY - cannot pop");
            return -1;
        }
        int value = arr[top--];
        
        // Shrink if stack is less than 25% full
        if (top + 1 < arr.length / 4 && arr.length > 5) {
            shrinkArray();
        }
        
        return value;
    }
    
    // Peek top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY - nothing to peek");
            return -1;
        }
        return arr[top];
    }
    
    // Return current number of elements
    public int size() {
        return top + 1;
    }
    
    // Get current array capacity
    public int capacity() {
        return arr.length;
    }
    
    // Main method to test the stack
    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        
        System.out.println("Pushing elements...");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // This will trigger array expansion
        
        System.out.println("\nTop element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Array capacity: " + stack.capacity());
        
        System.out.println("\nPopping elements...");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop(); // This should trigger array shrinking
        stack.pop(); // Prints message - stack empty
        
        System.out.println("\nFinal stack size: " + stack.size());
        System.out.println("Final array capacity: " + stack.capacity());
    }
}