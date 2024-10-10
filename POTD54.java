  class Solution {

      public int maxDistance(int[] arr) {
  
  // HashMap to store the first occurrence of each element
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        
        // Variable to store the maximum distance
        int maxDistance = 0;
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // If the element is seen for the first time, store its index
            if (!firstOccurrence.containsKey(arr[i])) {
                firstOccurrence.put(arr[i], i);
            } else {
                // Calculate the distance between the current and first occurrence
                int distance = i - firstOccurrence.get(arr[i]);
                // Update maxDistance if we find a larger distance
                maxDistance = Math.max(maxDistance, distance);
            }
        }
        
        return maxDistance;
    }
}