import java.util.Arrays;

class Solution {
    static boolean canAttend(int[][] arr) {
        // Sort meetings by starting time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 1; i < arr.length; i++) {
            // Check if the current meeting starts before the previous meeting ends
            if (arr[i][0] < arr[i - 1][1]) {
                return false; // Overlap found
            }
        }
        
        return true; // No overlap, so all meetings can be attended
    }
}
