/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class OptimizedInsertionSort {
    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            // If already in correct position, skip
            if (arr[i - 1] <= key) {
                continue;
            }

            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Sorted Array:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}



    
