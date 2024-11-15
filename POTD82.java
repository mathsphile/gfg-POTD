// Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

// Note: The second largest element should not be equal to the largest element.

public class Solution {
    public int getSecondLargest(int[] arr) {
        // Check if the array has less than 2 elements
        if (arr.length < 2) {
            return -1;
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            // Update largest and secondLargest
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }
        
        // If secondLargest was not updated, return -1
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}

