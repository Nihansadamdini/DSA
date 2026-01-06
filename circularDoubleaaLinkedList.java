/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nihansa
 */
public class circularDoubleaaLinkedList {

    // Internal Node class
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    // Add a node to the end
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            Node last = head.prev; 
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head: " + head.data + ")");
    }

    // The Main method to run the code
    public static void main(String[] args) {
        // Create an object of our class
        circularDoubleaaLinkedList list = new circularDoubleaaLinkedList();

        // Adding some data
        list.add(10);
        list.add(20);
        list.add(30);

        // Show the result
        System.out.println("Circular Doubly Linked List:");
        list.display();
    }
}
