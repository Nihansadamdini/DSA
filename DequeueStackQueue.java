/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Stack;
public class DequeueStackQueue {

    // Two stacks to implement queue
    private Stack<Integer> stack1; // For enqueue
    private Stack<Integer> stack2; // For dequeue
    
    // Constructor
    public DequeueStackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Add element to queue (enqueue)
    public void enqueue(int value) {
        stack1.push(value);
        System.out.println("Enqueued: " + value);
    }
    
    // Remove element from queue (dequeue)
    public int dequeue() {
        // If both stacks are empty
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        // Pop from stack2
        int value = stack2.pop();
        System.out.println("Dequeued: " + value);
        return value;
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // Get size of queue
    public int size() {
        return stack1.size() + stack2.size();
    }
    
    // Peek at front element without removing
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        DequeueStackQueue queue = new DequeueStackQueue();
        
        // Test enqueue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("Queue size: " + queue.size());
        
        // Test peek
        System.out.println("Front element: " + queue.peek());
        
        // Test dequeue
        queue.dequeue();
        queue.dequeue();
        
        // Add more elements
        queue.enqueue(40);
        queue.enqueue(50);
        
        // Dequeue all
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
        // Try to dequeue from empty queue
        queue.dequeue();
    }
}
