/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nihansa
 */
public class Main {

   

    // 1. The Node: The building block of the list
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    // 2. This is the "addNode" method your error was asking for
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 3. This is the "display" method your error was asking for
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 4. The Main method where the program starts
    public static void main(String[] args) {
        Main list = new Main();

        // These will NOT have errors now
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);

        list.display();
    }
}

