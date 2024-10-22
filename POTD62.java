// Given an array arr[] and two integers say, x and y, find the number of sub-arrays in which the number of occurrences of x is equal to the number of occurrences of y.

class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // HashMap to store the difference between counts of x and y
        HashMap<Integer, Integer> map = new HashMap<>();
        // This is the initial condition when the difference is 0 (before processing any element)
        map.put(0, 1);
        
        int countX = 0, countY = 0;  // Counters for x and y
        int result = 0;  // To store the final count of subarrays
        
        // Iterate over the array
        for (int i = 0; i < arr.length; i++) {
            // Update the counts of x and y
            if (arr[i] == x) {
                countX++;
            }
            if (arr[i] == y) {
                countY++;
            }
            
            // Calculate the difference between the count of x and y
            int diff = countX - countY;
            
            // If this difference has been seen before, it means there exists a subarray
            // between the previous occurrence and the current index where the counts of x and y are equal
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }
            
            // Update the HashMap with the current difference
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return result;
    }
}
