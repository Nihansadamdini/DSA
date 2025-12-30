/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nihansa
 */
public class SinglyLinkedList {

    // Node class
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private int size;
    
    // Constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    // Add element at the end
    public void add(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Added: " + data);
    }
    
    // Add element at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Added at first: " + data);
    }
    
    // Add element at specific position
    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
            return;
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Added " + data + " at index " + index);
    }
    
    // Remove first element
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.println("Removed: " + head.data);
        head = head.next;
        size--;
    }
    
    // Remove last element
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head.next == null) {
            System.out.println("Removed: " + head.data);
            head = null;
            size--;
            return;
        }
        
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        System.out.println("Removed: " + current.next.data);
        current.next = null;
        size--;
    }
    
    // Remove element at specific position
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        
        if (index == 0) {
            removeFirst();
            return;
        }
        
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        System.out.println("Removed: " + current.next.data);
        current.next = current.next.next;
        size--;
    }
    
    // Get element at specific position
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return -1;
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Get size of list
    public int size() {
        return size;
    }
    
    // Display all elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.print("List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        
        list.display();
        
        // Add at beginning
        list.addFirst(5);
        list.display();
        
        // Add at specific position
        list.addAt(2, 15);
        list.display();
        
        // Remove elements
        list.removeFirst();
        list.display();
        
        list.removeLast();
        list.display();
        
        list.removeAt(1);
        list.display();
        
        // Get element
        System.out.println("Element at index 1: " + list.get(1));
        
        // Check size
        System.out.println("List size: " + list.size());
    }
    
}
