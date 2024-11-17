// You are given an array of integers arr[]. Your task is to reverse the given array.
class Solution {
    public void reverseArray(int arr[]) {
        int start = 0;             // Initialize the starting index
        int end = arr.length - 1;  // Initialize the ending index
        
        while (start < end) {
            // Swap the elements at 'start' and 'end'
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move the pointers closer to the center
            start++;
            end--;
        }
    }
}
