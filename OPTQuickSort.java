/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class OPTQuickSort {

    // Partition method
    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];   // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort method
    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);   // left side
            quickSort(arr, pivotIndex + 1, high);  // right side
        }
    }

    // Main method
    public static void main(String[] args) {

        int[] arr = {8, 3, 1, 7, 0, 10, 2};

        quickSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}

