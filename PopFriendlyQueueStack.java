/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

 import java.util.*;
 
public class PopFriendlyQueueStack {
       
    static class QueueStack {
        private Stack<String> pushStack;  // Stack for adding items
        private Stack<String> popStack;   // Stack for removing items (pop-friendly)
        
        public QueueStack() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }
        
        // Add item (push operation) - transfers to popStack immediately
        public void push(String item) {
            // Transfer all items from popStack to pushStack temporarily
            while (!popStack.isEmpty()) {
                pushStack.push(popStack.pop());
            }
            
            // Add new item to pushStack
            pushStack.push(item);
            
            // Move everything back to popStack (keeps pop-friendly order)
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            
            System.out.println("Push " + item);
            display();
        }
        
        // Remove item (pop operation) - O(1) fast pop!
        public String pop() {
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
            
            // PopStack has items in reverse order for display
            for (int i = popStack.size() - 1; i >= 0; i--) {
                allItems.add(popStack.get(i));
            }
            
            System.out.println("Stack: " + allItems);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Pop-Friendly QueueStack ===\n");
        
        QueueStack qs = new QueueStack();
        
        // 1. Push 20 → [20]
        qs.push("20");
        
        // 2. Push 10 
        qs.push("10");
        
        // 3. Pop → [20] (removes 10)
        qs.pop();
        
        // 4. Push 15 → [20, 15]
        qs.push("15");
        
        // 5. Push 50 → [20, 15, 50]
        qs.push("50");
        
        // 6. Pop → [20, 15] (removes 20)
        qs.pop();
        
        // 7. Pop → [20] (removes 15)
        qs.pop();
        
        System.out.println("=== Complete ===");
    }
}


    
