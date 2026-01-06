/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class LinkedListStack {

    // Node class
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top;
    
    // Constructor
    public LinkedListStack() {
        top = null;
    }
    
    // Check if empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Push element
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }
    
    // Pop element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    
    // Peek top element
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.data;
    }
    
    // Display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Main method
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        stack.display();
        
        System.out.println("Popped: " + stack.pop());
        
        stack.display();
    }
}
