// Given an array arr[] of positive integers. Find the number of pairs of integers whose difference equals a given number k.
// Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices are considered different.

class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        // Fill the map with frequencies of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr) {
            // Check for pairs with difference k
            if (map.containsKey(num + k)) {
                count += map.get(num + k);
            }
            if (map.containsKey(num - k)) {
                count += map.get(num - k);
            }
            
            // To avoid double-counting pairs
            map.put(num, map.get(num) - 1);
        }
        
        return count;
    }
}