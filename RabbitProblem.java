/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class RabbitProblem {

    // Recursive method to calculate rabbit pairs
    public static int fibonacciRabbits(int n) {
        // Base Case: Month 1 or 2
        if (n <= 2) {
            return 1;
        }
        // Recursive Case: For month n > 2
        else {
            return fibonacciRabbits(n - 1) + fibonacciRabbits(n - 2);
        }
    }
    
    // Main method
    public static void main(String[] args) {
        System.out.println("=== RABBIT PROBLEM ===");
        System.out.println("How many pairs of rabbits after 1 year?");
        System.out.println();
        
        // Display table header
        System.out.println("Month\tAdult Pair\tBaby Pair\tTotal Pair");
        System.out.println("-----\t----------\t---------\t----------");
        
        // Month 0
        System.out.println("0\t0\t\t1\t\t1");
        
        // Month 1 to 12
        for (int month = 1; month <= 12; month++) {
            int adult, baby, total;
            
            if (month == 1) {
                adult = 1;
                baby = 0;
                total = 1;
            } else {
                total = fibonacciRabbits(month + 1);
                adult = fibonacciRabbits(month);
                baby = fibonacciRabbits(month - 1);
            }
            
            System.out.println(month + "\t" + adult + "\t\t" + baby + "\t\t" + total);
        }
        
        System.out.println();
        System.out.println("After 1 year (12 months), there will be " + fibonacciRabbits(13) + " pairs of rabbits.");
    }
}