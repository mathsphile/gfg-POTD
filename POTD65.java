//Given an array arr of distinct integers. Rearrange the array in such a way that the first element is the largest and the second element is the smallest, the third element is the second largest and the fourth element is the second smallest, and so on.

class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        Arrays.sort(arr); // Sort the array in ascending order
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        // Alternate elements from end and start of the sorted array
        for (int i = 0; i < n / 2; i++) {
            result.add(arr[n - 1 - i]); // Add largest remaining element
            result.add(arr[i]); // Add smallest remaining element
        }

        // If the array has an odd length, add the middle element
        if (n % 2 != 0) {
            result.add(arr[n / 2]);
        }

        return result;
    }
}
