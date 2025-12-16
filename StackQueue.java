/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nihansa
 */
public class StackQueue {
    private int[] stack;
    private int top;
    
    // Constructor
    public StackQueue() {
        stack = new int[10];
        top = -1;
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Enqueue - Add element (like push to stack) - O(1)
    public void enqueue(int x) {
        if (top == stack.length - 1) {
            expandStack();
        }
        stack[++top] = x;
        System.out.println("Enqueued: " + x);
    }
    
    // Dequeue - Remove element from front - O(n)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("QUEUE EMPTY - cannot dequeue");
            return -1;
        }
        
        // Remove the bottom element (first in)
        int value = stack[0];
        
        // Shift all elements one position to the left
        for (int i = 0; i < top; i++) {
            stack[i] = stack[i + 1];
        }
        top--;
        
        System.out.println("Dequeued: " + value);
        return value;
    }
    
    // Peek - View front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("QUEUE EMPTY - nothing to peek");
            return -1;
        }
        return stack[0];
    }
    
    // Get current size
    public int size() {
        return top + 1;
    }
    
    // Expand stack when full
    private void expandStack() {
        int newSize = stack.length * 2;
        int[] newStack = new int[newSize];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
    
    // Display current queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    
    // Main method to test
    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        
        System.out.println("=== Enqueue Operations ===");
        queue.enqueue(3);
        queue.display();
        
        queue.enqueue(5);
        queue.display();
        
        queue.enqueue(3);
        queue.display();
        
        queue.enqueue(1);
        queue.display();
        
        queue.enqueue(3);
        queue.display();
        
        queue.enqueue(7);
        queue.display();
        
        queue.enqueue(5);
        queue.display();
        
        System.out.println("\n=== Dequeue Operations ===");
        queue.dequeue();
        queue.display();
        
        queue.dequeue();
        queue.display();
        
        queue.dequeue();
        queue.display();
        
        System.out.println("\n=== Peek Operation ===");
        System.out.println("Front element: " + queue.peek());
        
        System.out.println("\n=== Queue Size ===");
        System.out.println("Current size: " + queue.size());
    }
}