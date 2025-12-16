/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nihansa
 */
import java.util.*;
public class PushFriendlyQueueStack {

    
    
    static class QueueStack {
        private Stack<String> pushStack;  // Stack for adding items
        private Stack<String> popStack;   // Stack for removing items
        
        public QueueStack() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }
        
        // Add item (push operation)
        public void push(String item) {
            pushStack.push(item);
            System.out.println("Push " + item);
            display();
        }
        
        // Remove item (pop operation)
        public String pop() {
            // Move items from pushStack to popStack if needed
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            
            // Check if empty
            if (popStack.isEmpty()) {
                System.out.println("Empty!");
                return null;
            }
            
            String item = popStack.pop();
            System.out.println("Pop → removed " + item);
            display();
            return item;
        }
        
        // Show current items
        public void display() {
            List<String> allItems = new ArrayList<>();
            
            // Add items from popStack (reversed)
            for (int i = popStack.size() - 1; i >= 0; i--) {
                allItems.add(popStack.get(i));
            }
            
            // Add items from pushStack
            allItems.addAll(pushStack);
            
            System.out.println("Stack: " + allItems);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        QueueStack qs = new QueueStack();
        
        // 1. Push 20
        qs.push("20");
        
        // 2. Push 10
        qs.push("10");
        
        // 3. Pop (removes 10)
        qs.pop();
        
        // 4. Push 15
        qs.push("15");
        
        // 5. Push 50
        qs.push("50");
        
        // 6. Pop (removes 50)
        qs.pop();
        
        // 7. Pop (removes 15)
        qs.pop();
    }
}