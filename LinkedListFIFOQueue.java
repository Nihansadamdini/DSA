/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class LinkedListFIFOQueue {

    class Node {
        int data;
        Node next;
    }
    
    Node top;
    
    // Push
    public void push(int x) {
        Node newNode = new Node();
        newNode.data = x;
        newNode.next = top;
        top = newNode;
    }
    
    // Pop
    public int pop() {
        if (top == null) {
            System.out.println("Empty");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    
    // Display
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Main
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        stack.display();
        
        stack.pop();
        
        stack.display();
    }
}