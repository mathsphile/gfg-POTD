// Given 2 sorted integer arrays arr1 and arr2 of the same size. Find the sum of the middle elements of two sorted arrays arr1 and arr2.


class Solution {
       public int SumofMiddleElements(int[] arr1, int[] arr2) {
              // Merge the two sorted arrays into one sorted array
              int[] merged = new int[arr1.length + arr2.length];
              int i = 0, j = 0, k = 0;

              // Merge the two arrays
              while (i < arr1.length && j < arr2.length) {
                     if (arr1[i] < arr2[j]) {
                            merged[k++] = arr1[i++];
                     } else {
                            merged[k++] = arr2[j++];
                     }
              }

              // Copy any remaining elements from arr1
              while (i < arr1.length) {
                     merged[k++] = arr1[i++];
              }

              // Copy any remaining elements from arr2
              while (j < arr2.length) {
                     merged[k++] = arr2[j++];
              }

              // Find the middle elements and return their sum
              int midIndex = merged.length / 2;
              return merged[midIndex] + merged[midIndex - 1];
       }
}
