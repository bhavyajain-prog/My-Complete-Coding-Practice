package com.Algorithms;

public class BubbleSort {
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5, 5, 8, 6, 9, 2};
        bubbleSort(arr);
        for (int i : arr) System.out.print(i + " ");
    }
}
