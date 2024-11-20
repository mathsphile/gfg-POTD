// You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

import java.util.*;

class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        // There can be at most two candidates for the n/3 majority
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;
        
        // First pass: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // Second pass: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        
        // Add candidates to the result if they appear more than n/3 times
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);
        
        // Return the result in increasing order
        Collections.sort(result);
        return result;
    }
}
