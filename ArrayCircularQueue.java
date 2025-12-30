/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

public class ArrayCircularQueue {
 private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    // Constructor
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Add element to queue (enqueue)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + value);
            return;
        }
        
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        System.out.println("Enqueued: " + value);
    }
    
    // Remove element from queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue");
            return -1;
        }
        
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + value);
        return value;
    }
    
    // Peek at front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }
    
    // Get current size
    public int size() {
        return size;
    }
    
    // Display queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(5);
        
        // Test enqueue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        queue.display();
        
        // Try to add when full
        queue.enqueue(60);
        
        // Test dequeue
        queue.dequeue();
        queue.dequeue();
        
        queue.display();
        
        // Add more elements (circular behavior)
        queue.enqueue(60);
        queue.enqueue(70);
        
        queue.display();
        
        // Test peek
        System.out.println("Front element: " + queue.peek());
        
        // Check size
        System.out.println("Queue size: " + queue.size());
    }
    
}
